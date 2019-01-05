package com.threadPool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Timer;

import com.general.BaseBean;

/**
 * 线程池
 * User: mackjoe
 * Date: 2007-6-8
 * Time: 16:01:08
 */
public class ThreadPool extends BaseBean {
    private static int maxPools = 200; //最大连接池数目
    private static long checkThreadPeriod = 5*60*1000; //检查连接池的周期
    private ThreadWork thwork=null;
    static ArrayList m_ThreadList=new ArrayList();  //工作线程列表
    static LinkedList m_RunList = new LinkedList();  //工作任务列表
	static ArrayList m_tempList = new ArrayList();  //temp工作任务列表
    static int totalThread = 0;  //总线程数
    static int freeThreadCount = 0;  //未被使用的线程数目
    private Timer timer = null;  //定时器
    static Object o = new Object();

    static{  //先初始化线程池的参数
        ConsumeThreadPoolPara consumeThreadPoolPara = ParseConfig.getConsumeThreadPoolPara();
        if(consumeThreadPoolPara!=null){
            maxPools = consumeThreadPoolPara.getMaxPools();
            //System.out.println("maxPools:"+maxPools);
            checkThreadPeriod = consumeThreadPoolPara.getCheckThreadPeriod()*60*1000;//设置线程有效检查间隔时间(分)
        }
    }

    /**
     * 设置工作线程
     * @param work
     */
    public void setThreadWork(ThreadWork work){
        this.thwork=work;
    }

    /**
     * 设置最大线程数
     * @param maxPools
     */
    public void setMaxPools(int maxPools){
        this.maxPools = maxPools;
    }

    /**
     * 设置线程有效检查间隔时间
     * @param checkThreadPeriod
     */
    public void setCheckThreadPeriod(int checkThreadPeriod){
        this.checkThreadPeriod = checkThreadPeriod;
    }

    /**
     * 连接池
     */
    public ThreadPool() {
        timer = new Timer(true);  //启动定时器
        timer.schedule(new CheckThreadTask(this),0,checkThreadPeriod);
  }

    /**
    * 当有一个工作来的时候启动线程池的线程
    * 1.当空闲线程数为0的时候，看总线程是否小于最大线程池的数目，就new一个新的线程，否则sleep，直到有空闲线程为止;
    * 2.当空闲线程不为0，则将任务丢给空闲线程去完成
    * @param work
    */
    public synchronized void run(ThreadWork work)
  {
      setThreadWork(work);
      //System.out.println("freeThreadCount:"+freeThreadCount);
          if (freeThreadCount == 0) {
              //System.out.println("totalThread:"+totalThread+"<"+"maxPools:"+maxPools);
                  if(totalThread<maxPools){
                    WorkerThread temp = new WorkerThread();
                    totalThread = totalThread + 1;
                    m_ThreadList.add(temp);
                    temp.start();
                    synchronized(m_RunList){
                      m_RunList.add(work);
					  m_tempList.add(work);
                      m_RunList.notify();
                    }
                  }else{
                    while (freeThreadCount==0) {
                      try {
                        Thread.sleep(1000);
                      }
                      catch (InterruptedException e) {
                      }
                    }
                    synchronized(m_RunList){
                      m_RunList.add(work);
					  m_tempList.add(work);
                      m_RunList.notify();
					  synchronized(o){
                        freeThreadCount--;
                      }
                    }
                  }
          } else {
            synchronized(m_RunList){
              m_RunList.add(work);
			  m_tempList.add(work);
              m_RunList.notify();
			  synchronized(o){
				freeThreadCount--;
              }
            }
          }
  }

    /**
    * 检查所有的线程的有效性
    */
    public synchronized void checkAllThreads() {

        Iterator lThreadIterator = m_ThreadList.iterator();
        while (lThreadIterator.hasNext()) { //逐个遍厉
            WorkerThread lTestThread = (WorkerThread) lThreadIterator.next();
            if (! (lTestThread.isAlive())) { //如果处在非活动状态时
                lTestThread = new WorkerThread(); //重新生成个线程
                lTestThread.start(); //启动
            }
        }
    }

    /**
     * 检查指定对象线程是否还在运行
     * @param cheklist
     * @return
     */
    public ArrayList Threadstatus(ArrayList cheklist) {
        ArrayList returnlist=new ArrayList();
        if(cheklist!=null){
            returnlist=cheklist;
            for(int i=0;i<cheklist.size();i++){
                if(m_tempList.indexOf(cheklist.get(i))<0)
                returnlist.remove(i);
            }
        }
        return returnlist;
    }

    /**
    *
    * <p>Title: 工作线程类</p>
    *
    */
    class WorkerThread extends Thread{
        boolean running = true;

        public void run(){
            ThreadWork work=null;
            while(running){
                synchronized(m_RunList){
                    while(m_RunList.size() == 0){
                        try{
                            m_RunList.wait();
                            if(!running) return;
                        }catch(InterruptedException e){}
                    }
                    work = (ThreadWork)m_RunList.removeLast();
                    if(work==null){
                        return;
                    }
                }
                work.doThreadWork();
                m_tempList.remove(work);
				synchronized(o){
                    freeThreadCount++;
                }
            }
        }
    }


}
