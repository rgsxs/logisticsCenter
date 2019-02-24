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

export function getFormItem(data) {
    let formItems = []
    data && data.item && data.item.forEach(item => {
        if(item.type==='input'){
            formItems.push(
                <FormItem labelCol={{ span: 5 }} wrapperCol={{ span: 15 }} label="驾驶员">
                    {form.getFieldDecorator('driver', {
                    rules: [{ required: true, message: '请输入至少五个字符的驾驶员！', min: 5 }],
                    })(<Input placeholder="请输入" />)}
                </FormItem>
            )
        }
    })

}