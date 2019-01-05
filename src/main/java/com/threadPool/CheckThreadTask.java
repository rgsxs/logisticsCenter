package com.threadPool;

import java.util.TimerTask;

class CheckThreadTask extends TimerTask {
       private static boolean isRunning = false;
    private ThreadPool pool;
       public CheckThreadTask(ThreadPool pool){
            this.pool = pool;
       }
       public void run() {
            if (!isRunning)  {
                  isRunning = true;
                  pool.checkAllThreads();
                  isRunning = false;
                }
       }
}
