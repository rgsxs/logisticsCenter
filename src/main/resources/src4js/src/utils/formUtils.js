import React from 'react';
import {
    Row,
    Col,
    Card,
    Form,
    Input,
    Select,
    Icon,
    Button,
    Dropdown,
    Menu,
    InputNumber,
    DatePicker,
    Modal,
    message,
    Badge,
    Divider,
    Steps,
    Radio,
  } from 'antd';
const FormItem = Form.Item;
const { Step } = Steps;
const { TextArea } = Input;
const { Option } = Select;
const RadioGroup = Radio.Group;
const RangePicker = DatePicker.RangePicker;
import styles from './formUtils.less';

export function getFormItem(data,form,expandForm,callback1,callback2,callback3) {
    const {getFieldDecorator} = form;
    let formItems = [];
    return <Form  layout="inline">
      <Row >
        <Col md={8} sm={24} offset={20}>
            <span className={styles.submitButtons} style={{paddingBottom:'15px'}}>
            {callback1 &&
              <Button type="primary"  onClick={callback1}>
                查询
              </Button>
            }
            {callback2 &&
              <Button style={{ marginLeft: 8 }} onClick={callback2}>
              重置
            </Button>
            }
            {callback3 &&
              <a style={{ marginLeft: 8 }} onClick={callback3}>
              高级搜索 {expandForm?<Icon type="up" />:<Icon type="down" />}
              </a>
            }
            </span>
        </Col>
      </Row>
        {<Row gutter={{ md: 8, lg: 24, xl: 48 }}>
        {data && data.item && data.item.map((item,index) => {
          if(expandForm===false && index > 2){
            return;
          }
          if(item.type==='input'){
              return (
                  <Col md={8} sm={24}>
                  <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label={item.label}>
                      {form.getFieldDecorator(item.key, {
                      rules: item.rules&&item.rules,
                      })(<Input placeholder={item.placeholder} />)}
                  </FormItem>
                  </Col>
              )
          }
          if(item.type==='select'){
            return (
                <Col md={8} sm={24}>
                <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label={item.label}>
                    {form.getFieldDecorator(item.key, {
                    rules: item.rules&&item.rules,
                    })(<Select 
                        style={{ width: '100%' }}
                        mode={item.isMulti?'multiple':''}
                        >
                        {item.options&&item.options.map((option,index)=>{
                          return(
                            <Option value={option.key} key={option.key}>{option.value}</Option>
                          )
                        })}
                      </Select>)
                    }
                </FormItem>
                </Col>
            )
          }
          if(item.type==='datePicker'){
            return (
                <Col md={8} sm={24}>
                <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label={item.label}>
                    {form.getFieldDecorator(item.key, {
                    rules: item.rules&&item.rules,
                    })(<DatePicker
                      placeholder={item.placeholder}
                    />)
                    }
                </FormItem>
                </Col>
            )
          }
          if(item.type==='rangePicker'){
            return (
                <Col md={8} sm={24}>
                <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label={item.label}>
                    {form.getFieldDecorator(item.key, {
                    rules: item.rules&&item.rules,
                    })(<RangePicker
                      format='YYYY-MM-DD'
                    />)
                    }
                </FormItem>
                </Col>
            )
          }
        })
        
        }
      </Row>
      }
      </Form>

}