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

class FormUtils extends React.PureComponent {
    constructor(props) {
        super(props);
        this.state = {
            expandForm:false,
        };
    }
    componentDidMount() {
        console.log('formUtils')
    }

    componentWillMount(){
        console.log('formUtils willMount')
    }

    toggleSearch = ()=>{
        const { expandForm } = this.state;
        this.setState({expandForm:!expandForm})
    }
    handleFormReset = ()=>{
        this.props.form.resetFields();
    }
    render(){
        console.log('formUtils render')
        const {form , data, buttons} = this.props;
        const {getFieldDecorator} = form;
        const {expandForm} = this.state;
        let formItems = [];
        return <div>
        <Form  layout="inline">
          <Row >
            <Col md={8} sm={24} offset={20}>
                {buttons&&buttons.map(data => {
                return (
                    <span
                    style={{
                        display: "inline-block",
                        lineHeight: "28px",
                        verticalAlign: "middle",
                        marginLeft: 10
                    }}
                    >
                    {data}
                    </span>
                );
                })}
                
                <Button style={{ marginLeft: 8 }} onClick={this.handleFormReset}>
                  重置
                </Button>
                <a style={{ marginLeft: 8 }} onClick={this.toggleSearch}>
                高级搜索 {expandForm?<Icon type="up" />:<Icon type="down" />}
                </a>
                
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
                                <Option value={option.key}>{option.value}</Option>
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
          </div>
    }
}

export default Form.create()(FormUtils);