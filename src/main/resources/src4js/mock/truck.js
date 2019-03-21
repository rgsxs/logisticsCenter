import { parse } from 'url';

// mock tableListDataSource
let tableListDataSource = [];
for (let i = 0; i < 46; i += 1) {
  tableListDataSource.push({
      key: i,
      truckNumber: `TradeCode ${i}`,
      truckOwner: '曲丽丽',
      truckBrand: Math.floor(Math.random() * 10) % 2,
      truckName:'',
      contactNumber:'',
      truckType:'',
      driver:'',
      truckColor:'',
      trucklength:'',
      truckWidth:'',
      truckHeight:'',
      standardWeight:'',
      driverLicense:'',
      engineNumber:'',
      madeDate: new Date(),
      buyDate: new Date(),
      worth:'',
      buyCost:'',
  });
}

function selectTruck(req, res, u) {
  let url = u;
  if (!url || Object.prototype.toString.call(url) !== '[object String]') {
    url = req.url; // eslint-disable-line
  }

  const params = parse(url, true).query;

  let dataSource = tableListDataSource;

  if (params.sorter) {
    const s = params.sorter.split('_');
    dataSource = dataSource.sort((prev, next) => {
      if (s[1] === 'descend') {
        return next[s[0]] - prev[s[0]];
      }
      return prev[s[0]] - next[s[0]];
    });
  }

  if (params.truckBrand) {
    const truckBrand = params.truckBrand.split(',');
    let filterDataSource = [];
    truckBrand.forEach(s => {
      filterDataSource = filterDataSource.concat(
        dataSource.filter(data => parseInt(data.truckBrand, 10) === parseInt(s[0], 10))
      );
    });
    dataSource = filterDataSource;
  }

  if (params.truckNumber) {
    dataSource = dataSource.filter(data => data.truckNumber.indexOf(params.truckNumber) > -1);
  }

  let pageSize = 10;
  if (params.pageSize) {
    pageSize = params.pageSize * 1;
  }

  const result = {
    list: dataSource,
    pagination: {
      total: dataSource.length,
      pageSize,
      current: parseInt(params.currentPage, 10) || 1,
    },
  };
  return res.json(result);
}

function postRule(req, res, u, b) {
  let url = u;
  if (!url || Object.prototype.toString.call(url) !== '[object String]') {
    url = req.url; // eslint-disable-line
  }

  const body = (b && b.body) || req.body;
  const { method, truckNumber, driver, key } = body;

  switch (method) {
    /* eslint no-case-declarations:0 */
    case 'delete':
      tableListDataSource = tableListDataSource.filter(item => key.indexOf(item.key) === -1);
      break;
    case 'post':
      const i = Math.ceil(Math.random() * 10000);
      tableListDataSource.unshift({
        key: i,
        truckNumber: `TradeCode ${i}`,
        truckOwner: '曲丽丽',
        truckBrand: Math.floor(Math.random() * 10) % 2,
        truckName:'',
        contactNumber:'',
        truckType:'',
        driver:'',
        truckColor:'',
        trucklength:'',
        truckWidth:'',
        truckHeight:'',
        standardWeight:'',
        driverLicense:'',
        engineNumber:'',
        madeDate: new Date(),
        buyDate: new Date(),
        worth:'',
        buyCost:'',
      });
      break;
    case 'update':
      tableListDataSource = tableListDataSource.map(item => {
        if (item.key === key) {
          Object.assign(item, { driver, truckNumber });
          return item;
        }
        return item;
      });
      break;
    default:
      break;
  }

  const result = {
    list: tableListDataSource,
    pagination: {
      total: tableListDataSource.length,
    },
  };

  return res.json(result);
}

function getAdvancedForm(req, res, u, b){
  let itemChilds = [];
  let children = [];
  for (let i = 10; i < 36; i++) {
    children.push({key:i,value:`驾驶员${i}`});
  }
  itemChilds.push({type:'input',label:'车牌',key:'truckNumber',rules: [],placeholder:'请输入车牌'});
  itemChilds.push({type:'select',label:'驾驶员',key:'driver',options:children,isMulti:true});
  itemChilds.push({type:'rangePicker',label:'购买日期',key:'buyDate',placeholder:'购买日期'});
  itemChilds.push({type:'input',label:'驾驶',key:'driver4'});
  itemChilds.push({type:'input',label:'驾驶',key:'driver4'});
  itemChilds.push({type:'input',label:'驾驶',key:'driver4'});
  let advancedForm={
    item:itemChilds
  }
  return res.json(advancedForm);
}
export default {
  'POST /api/truck/selectTruck': selectTruck,
  'POST /api/truck/deleteTruck': postRule,
  'POST /api/truck/addTruck': postRule,
  'POST /api/truck/updateTruck': postRule,
  'POST /api/truck/getAdvancedForm': getAdvancedForm,
};
