(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[16],{"7Zm1":function(e,a,t){e.exports={trendItem:"antd-pro\\components\\-trend\\index-trendItem",down:"antd-pro\\components\\-trend\\index-down",up:"antd-pro\\components\\-trend\\index-up",trendItemGrey:"antd-pro\\components\\-trend\\index-trendItemGrey",reverseColor:"antd-pro\\components\\-trend\\index-reverseColor"}},"Umy/":function(e,a,t){"use strict";var l=t("TqRt");Object.defineProperty(a,"__esModule",{value:!0}),a.default=void 0;var n=l(t("lwsE")),s=l(t("W8MJ")),d=l(t("a1gu")),r=l(t("Nsbk")),u=l(t("7W2i")),i=l(t("q1tI")),f=t("KTCi"),c=function(e){function a(){var e,t;(0,n.default)(this,a);for(var l=arguments.length,s=new Array(l),u=0;u<l;u++)s[u]=arguments[u];return t=(0,d.default)(this,(e=(0,r.default)(a)).call.apply(e,[this].concat(s))),t.rendertoHtml=function(){var e=t.props.children;t.main&&(t.main.innerHTML=(0,f.yuan)(e))},t}return(0,u.default)(a,e),(0,s.default)(a,[{key:"componentDidMount",value:function(){this.rendertoHtml()}},{key:"componentDidUpdate",value:function(){this.rendertoHtml()}},{key:"render",value:function(){var e=this;return i.default.createElement("span",{ref:function(a){e.main=a}})}}]),a}(i.default.PureComponent);a.default=c},YR7N:function(e,a,t){"use strict";var l=t("TqRt");Object.defineProperty(a,"__esModule",{value:!0}),a.default=void 0;var n=l(t("pVnL"));t("Pwec");var s=l(t("CtXQ")),d=l(t("lSNA")),r=l(t("QILm")),u=l(t("q1tI")),i=l(t("TSYQ")),f=l(t("7Zm1")),c=function(e){var a,t=e.colorful,l=void 0===t||t,c=e.reverseColor,o=void 0!==c&&c,m=e.flag,p=e.children,g=e.className,E=(0,r.default)(e,["colorful","reverseColor","flag","children","className"]),y=(0,i.default)(f.default.trendItem,(a={},(0,d.default)(a,f.default.trendItemGrey,!l),(0,d.default)(a,f.default.reverseColor,o&&l),a),g);return u.default.createElement("div",(0,n.default)({},E,{className:y,title:"string"===typeof p?p:""}),u.default.createElement("span",{className:f.default.value},p),m&&u.default.createElement("span",{className:f.default[m]},u.default.createElement(s.default,{type:"caret-".concat(m)})))},o=c;a.default=o},ZOrW:function(e,a,t){"use strict";var l=t("TqRt"),n=t("284h");Object.defineProperty(a,"__esModule",{value:!0}),a.default=void 0,t("7Kak");var s=l(t("9yH6"));t("g9YV");var d=l(t("wCAj"));t("IzEo");var r=l(t("bx4M"));t("5Dmo");var u=l(t("3S7+"));t("14J3");var i=l(t("BMrR"));t("jCWc");var f=l(t("kPKH"));t("qVdP");var c=l(t("jsC+"));t("Pwec");var o=l(t("CtXQ"));t("lUTK");var m=l(t("BvKs")),p=l(t("lwsE")),g=l(t("W8MJ")),E=l(t("a1gu")),y=l(t("Nsbk")),h=l(t("7W2i"));t("iQDF");var v=l(t("+eQT"));t("Znn+");for(var M,k,b=l(t("ZTPi")),T=n(t("q1tI")),C=t("MuoO"),x=t("LLXN"),F=t("KTCi"),N=l(t("YR7N")),D=l(t("LOQS")),w=l(t("ZhIB")),S=l(t("v99g")),R=l(t("Umy/")),I=t("+n12"),P=l(t("lVjH")),B=b.default.TabPane,L=v.default.RangePicker,A=[],W=0;W<7;W+=1)A.push({title:"\u5de5\u4e13\u8def ".concat(W," \u53f7\u5e97"),total:323234});var V=(M=(0,C.connect)(function(e){var a=e.chart,t=e.loading;return{chart:a,loading:t.effects["chart/fetch"]}}),M(k=function(e){function a(e){var t;(0,p.default)(this,a),t=(0,E.default)(this,(0,y.default)(a).call(this,e)),t.state={salesType:"all",currentTabKey:"",rangePickerValue:(0,I.getTimeDistance)("year"),loading:!0},t.handleChangeSalesType=function(e){t.setState({salesType:e.target.value})},t.handleTabChange=function(e){t.setState({currentTabKey:e})},t.handleRangePickerChange=function(e){var a=t.props.dispatch;t.setState({rangePickerValue:e}),a({type:"chart/fetchSalesData"})},t.selectDate=function(e){var a=t.props.dispatch;t.setState({rangePickerValue:(0,I.getTimeDistance)(e)}),a({type:"chart/fetchSalesData"})},t.rankingListData=[];for(var l=0;l<7;l+=1)t.rankingListData.push({title:(0,x.formatMessage)({id:"app.analysis.test"},{no:l}),total:323234});return t}return(0,h.default)(a,e),(0,g.default)(a,[{key:"componentDidMount",value:function(){var e=this,a=this.props.dispatch;this.reqRef=requestAnimationFrame(function(){a({type:"chart/fetch"}),e.timeoutId=setTimeout(function(){e.setState({loading:!1})},600)})}},{key:"componentWillUnmount",value:function(){var e=this.props.dispatch;e({type:"chart/clear"}),cancelAnimationFrame(this.reqRef),clearTimeout(this.timeoutId)}},{key:"isActive",value:function(e){var a=this.state.rangePickerValue,t=(0,I.getTimeDistance)(e);return a[0]&&a[1]&&a[0].isSame(t[0],"day")&&a[1].isSame(t[1],"day")?P.default.currentDate:""}},{key:"render",value:function(){var e,a=this,t=this.state,l=t.rangePickerValue,n=t.salesType,p=t.loading,g=t.currentTabKey,E=this.props,y=E.chart,h=E.loading,v=y.visitData,M=y.visitData2,k=y.salesData,C=y.searchData,I=y.offlineData,A=y.offlineChartData,W=y.salesTypeData,V=y.salesTypeDataOnline,H=y.salesTypeDataOffline,K=p||h;e="all"===n?W:"online"===n?V:H;var O=T.default.createElement(m.default,null,T.default.createElement(m.default.Item,null,"\u64cd\u4f5c\u4e00"),T.default.createElement(m.default.Item,null,"\u64cd\u4f5c\u4e8c")),q=T.default.createElement("span",{className:P.default.iconGroup},T.default.createElement(c.default,{overlay:O,placement:"bottomRight"},T.default.createElement(o.default,{type:"ellipsis"}))),j=T.default.createElement("div",{className:P.default.salesExtraWrap},T.default.createElement("div",{className:P.default.salesExtra},T.default.createElement("a",{className:this.isActive("today"),onClick:function(){return a.selectDate("today")}},T.default.createElement(x.FormattedMessage,{id:"app.analysis.all-day",defaultMessage:"All Day"})),T.default.createElement("a",{className:this.isActive("week"),onClick:function(){return a.selectDate("week")}},T.default.createElement(x.FormattedMessage,{id:"app.analysis.all-week",defaultMessage:"All Week"})),T.default.createElement("a",{className:this.isActive("month"),onClick:function(){return a.selectDate("month")}},T.default.createElement(x.FormattedMessage,{id:"app.analysis.all-month",defaultMessage:"All Month"})),T.default.createElement("a",{className:this.isActive("year"),onClick:function(){return a.selectDate("year")}},T.default.createElement(x.FormattedMessage,{id:"app.analysis.all-year",defaultMessage:"All Year"}))),T.default.createElement(L,{value:l,onChange:this.handleRangePickerChange,style:{width:256}})),G=[{title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.table.rank",defaultMessage:"Rank"}),dataIndex:"index",key:"index"},{title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.table.search-keyword",defaultMessage:"Search keyword"}),dataIndex:"keyword",key:"keyword",render:function(e){return T.default.createElement("a",{href:"/"},e)}},{title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.table.users",defaultMessage:"Users"}),dataIndex:"count",key:"count",sorter:function(e,a){return e.count-a.count},className:P.default.alignRight},{title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.table.weekly-range",defaultMessage:"Weekly Range"}),dataIndex:"range",key:"range",sorter:function(e,a){return e.range-a.range},render:function(e,a){return T.default.createElement(N.default,{flag:1===a.status?"down":"up"},T.default.createElement("span",{style:{marginRight:4}},e,"%"))},align:"right"}],Q=g||I[0]&&I[0].name,U=function(e){var a=e.data,t=e.currentTabKey;return T.default.createElement(i.default,{gutter:8,style:{width:138,margin:"8px 0"}},T.default.createElement(f.default,{span:12},T.default.createElement(D.default,{title:a.name,subTitle:T.default.createElement(x.FormattedMessage,{id:"app.analysis.conversion-rate",defaultMessage:"Conversion Rate"}),gap:2,total:"".concat(100*a.cvr,"%"),theme:t!==a.name&&"light"})),T.default.createElement(f.default,{span:12,style:{paddingTop:36}},T.default.createElement(F.Pie,{animate:!1,color:t!==a.name&&"#BDE4FF",inner:.55,tooltip:!1,margin:[0,0,0,0],percent:100*a.cvr,height:64})))},Z={xs:24,sm:12,md:12,lg:12,xl:6,style:{marginBottom:24}};return T.default.createElement(S.default,null,T.default.createElement(i.default,{gutter:24},T.default.createElement(f.default,Z,T.default.createElement(F.ChartCard,{bordered:!1,title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.total-sales",defaultMessage:"Total Sales"}),action:T.default.createElement(u.default,{title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.introduce",defaultMessage:"introduce"})},T.default.createElement(o.default,{type:"info-circle-o"})),loading:K,total:function(){return T.default.createElement(R.default,null,"126560")},footer:T.default.createElement(F.Field,{label:T.default.createElement(x.FormattedMessage,{id:"app.analysis.day-sales",defaultMessage:"Day Sales"}),value:"\uffe5".concat((0,w.default)(12423).format("0,0"))}),contentHeight:46},T.default.createElement(N.default,{flag:"up",style:{marginRight:16}},T.default.createElement(x.FormattedMessage,{id:"app.analysis.week",defaultMessage:"Weekly Changes"}),T.default.createElement("span",{className:P.default.trendText},"12%")),T.default.createElement(N.default,{flag:"down"},T.default.createElement(x.FormattedMessage,{id:"app.analysis.day",defaultMessage:"Daily Changes"}),T.default.createElement("span",{className:P.default.trendText},"11%")))),T.default.createElement(f.default,Z,T.default.createElement(F.ChartCard,{bordered:!1,loading:K,title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.visits",defaultMessage:"visits"}),action:T.default.createElement(u.default,{title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.introduce",defaultMessage:"introduce"})},T.default.createElement(o.default,{type:"info-circle-o"})),total:(0,w.default)(8846).format("0,0"),footer:T.default.createElement(F.Field,{label:T.default.createElement(x.FormattedMessage,{id:"app.analysis.day-visits",defaultMessage:"Day Visits"}),value:(0,w.default)(1234).format("0,0")}),contentHeight:46},T.default.createElement(F.MiniArea,{color:"#975FE4",data:v}))),T.default.createElement(f.default,Z,T.default.createElement(F.ChartCard,{bordered:!1,loading:K,title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.payments",defaultMessage:"Payments"}),action:T.default.createElement(u.default,{title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.introduce",defaultMessage:"Introduce"})},T.default.createElement(o.default,{type:"info-circle-o"})),total:(0,w.default)(6560).format("0,0"),footer:T.default.createElement(F.Field,{label:T.default.createElement(x.FormattedMessage,{id:"app.analysis.conversion-rate",defaultMessage:"Conversion Rate"}),value:"60%"}),contentHeight:46},T.default.createElement(F.MiniBar,{data:v}))),T.default.createElement(f.default,Z,T.default.createElement(F.ChartCard,{loading:K,bordered:!1,title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.operational-effect",defaultMessage:"Operational Effect"}),action:T.default.createElement(u.default,{title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.introduce",defaultMessage:"introduce"})},T.default.createElement(o.default,{type:"info-circle-o"})),total:"78%",footer:T.default.createElement("div",{style:{whiteSpace:"nowrap",overflow:"hidden"}},T.default.createElement(N.default,{flag:"up",style:{marginRight:16}},T.default.createElement(x.FormattedMessage,{id:"app.analysis.week",defaultMessage:"Weekly changes"}),T.default.createElement("span",{className:P.default.trendText},"12%")),T.default.createElement(N.default,{flag:"down"},T.default.createElement(x.FormattedMessage,{id:"app.analysis.day",defaultMessage:"Weekly changes"}),T.default.createElement("span",{className:P.default.trendText},"11%"))),contentHeight:46},T.default.createElement(F.MiniProgress,{percent:78,strokeWidth:8,target:80,color:"#13C2C2"})))),T.default.createElement(r.default,{loading:K,bordered:!1,bodyStyle:{padding:0}},T.default.createElement("div",{className:P.default.salesCard},T.default.createElement(b.default,{tabBarExtraContent:j,size:"large",tabBarStyle:{marginBottom:24}},T.default.createElement(B,{tab:T.default.createElement(x.FormattedMessage,{id:"app.analysis.sales",defaultMessage:"Sales"}),key:"sales"},T.default.createElement(i.default,null,T.default.createElement(f.default,{xl:16,lg:12,md:12,sm:24,xs:24},T.default.createElement("div",{className:P.default.salesBar},T.default.createElement(F.Bar,{height:295,title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.sales-trend",defaultMessage:"Sales Trend"}),data:k}))),T.default.createElement(f.default,{xl:8,lg:12,md:12,sm:24,xs:24},T.default.createElement("div",{className:P.default.salesRank},T.default.createElement("h4",{className:P.default.rankingTitle},T.default.createElement(x.FormattedMessage,{id:"app.analysis.sales-ranking",defaultMessage:"Sales Ranking"})),T.default.createElement("ul",{className:P.default.rankingList},this.rankingListData.map(function(e,a){return T.default.createElement("li",{key:e.title},T.default.createElement("span",{className:"".concat(P.default.rankingItemNumber," ").concat(a<3?P.default.active:"")},a+1),T.default.createElement("span",{className:P.default.rankingItemTitle,title:e.title},e.title),T.default.createElement("span",{className:P.default.rankingItemValue},(0,w.default)(e.total).format("0,0")))})))))),T.default.createElement(B,{tab:T.default.createElement(x.FormattedMessage,{id:"app.analysis.visits",defaultMessage:"Visits"}),key:"views"},T.default.createElement(i.default,null,T.default.createElement(f.default,{xl:16,lg:12,md:12,sm:24,xs:24},T.default.createElement("div",{className:P.default.salesBar},T.default.createElement(F.Bar,{height:292,title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.visits-trend",defaultMessage:"Visits Trend"}),data:k}))),T.default.createElement(f.default,{xl:8,lg:12,md:12,sm:24,xs:24},T.default.createElement("div",{className:P.default.salesRank},T.default.createElement("h4",{className:P.default.rankingTitle},T.default.createElement(x.FormattedMessage,{id:"app.analysis.visits-ranking",defaultMessage:"Visits Ranking"})),T.default.createElement("ul",{className:P.default.rankingList},this.rankingListData.map(function(e,a){return T.default.createElement("li",{key:e.title},T.default.createElement("span",{className:a<3?P.default.active:""},a+1),T.default.createElement("span",null,e.title),T.default.createElement("span",null,(0,w.default)(e.total).format("0,0")))}))))))))),T.default.createElement(i.default,{gutter:24},T.default.createElement(f.default,{xl:12,lg:24,md:24,sm:24,xs:24},T.default.createElement(r.default,{loading:K,bordered:!1,title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.online-top-search",defaultMessage:"Online Top Search"}),extra:q,style:{marginTop:24}},T.default.createElement(i.default,{gutter:68},T.default.createElement(f.default,{sm:12,xs:24,style:{marginBottom:24}},T.default.createElement(D.default,{subTitle:T.default.createElement("span",null,T.default.createElement(x.FormattedMessage,{id:"app.analysis.search-users",defaultMessage:"search users"}),T.default.createElement(u.default,{title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.introduce",defaultMessage:"introduce"})},T.default.createElement(o.default,{style:{marginLeft:8},type:"info-circle-o"}))),gap:8,total:(0,w.default)(12321).format("0,0"),status:"up",subTotal:17.1}),T.default.createElement(F.MiniArea,{line:!0,height:45,data:M})),T.default.createElement(f.default,{sm:12,xs:24,style:{marginBottom:24}},T.default.createElement(D.default,{subTitle:T.default.createElement("span",null,T.default.createElement(x.FormattedMessage,{id:"app.analysis.per-capita-search",defaultMessage:"Per Capita Search"}),T.default.createElement(u.default,{title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.introduce",defaultMessage:"introduce"})},T.default.createElement(o.default,{style:{marginLeft:8},type:"info-circle-o"}))),total:2.7,status:"down",subTotal:26.2,gap:8}),T.default.createElement(F.MiniArea,{line:!0,height:45,data:M}))),T.default.createElement(d.default,{rowKey:function(e){return e.index},size:"small",columns:G,dataSource:C,pagination:{style:{marginBottom:0},pageSize:5}}))),T.default.createElement(f.default,{xl:12,lg:24,md:24,sm:24,xs:24},T.default.createElement(r.default,{loading:K,className:P.default.salesCard,bordered:!1,title:T.default.createElement(x.FormattedMessage,{id:"app.analysis.the-proportion-of-sales",defaultMessage:"The Proportion of Sales"}),bodyStyle:{padding:24},extra:T.default.createElement("div",{className:P.default.salesCardExtra},q,T.default.createElement("div",{className:P.default.salesTypeRadio},T.default.createElement(s.default.Group,{value:n,onChange:this.handleChangeSalesType},T.default.createElement(s.default.Button,{value:"all"},T.default.createElement(x.FormattedMessage,{id:"app.analysis.channel.all",defaultMessage:"ALL"})),T.default.createElement(s.default.Button,{value:"online"},T.default.createElement(x.FormattedMessage,{id:"app.analysis.channel.online",defaultMessage:"Online"})),T.default.createElement(s.default.Button,{value:"stores"},T.default.createElement(x.FormattedMessage,{id:"app.analysis.channel.stores",defaultMessage:"Stores"}))))),style:{marginTop:24,minHeight:509}},T.default.createElement("h4",{style:{marginTop:8,marginBottom:32}},T.default.createElement(x.FormattedMessage,{id:"app.analysis.sales",defaultMessage:"Sales"})),T.default.createElement(F.Pie,{hasLegend:!0,subTitle:T.default.createElement(x.FormattedMessage,{id:"app.analysis.sales",defaultMessage:"Sales"}),total:function(){return T.default.createElement(R.default,null,e.reduce(function(e,a){return a.y+e},0))},data:e,valueFormat:function(e){return T.default.createElement(R.default,null,e)},height:248,lineWidth:4})))),T.default.createElement(r.default,{loading:K,className:P.default.offlineCard,bordered:!1,bodyStyle:{padding:"0 0 32px 0"},style:{marginTop:32}},T.default.createElement(b.default,{activeKey:Q,onChange:this.handleTabChange},I.map(function(e){return T.default.createElement(B,{tab:T.default.createElement(U,{data:e,currentTabKey:Q}),key:e.name},T.default.createElement("div",{style:{padding:"0 24px"}},T.default.createElement(F.TimelineChart,{height:400,data:A,titleMap:{y1:(0,x.formatMessage)({id:"app.analysis.traffic"}),y2:(0,x.formatMessage)({id:"app.analysis.payments"})}})))}))))}}]),a}(T.Component))||k),H=V;a.default=H},lVjH:function(e,a,t){e.exports={iconGroup:"antd-pro\\pages\\-dashboard\\-analysis-iconGroup",rankingList:"antd-pro\\pages\\-dashboard\\-analysis-rankingList",rankingItemNumber:"antd-pro\\pages\\-dashboard\\-analysis-rankingItemNumber",active:"antd-pro\\pages\\-dashboard\\-analysis-active",rankingItemTitle:"antd-pro\\pages\\-dashboard\\-analysis-rankingItemTitle",salesExtra:"antd-pro\\pages\\-dashboard\\-analysis-salesExtra",currentDate:"antd-pro\\pages\\-dashboard\\-analysis-currentDate",salesCard:"antd-pro\\pages\\-dashboard\\-analysis-salesCard",salesBar:"antd-pro\\pages\\-dashboard\\-analysis-salesBar",salesRank:"antd-pro\\pages\\-dashboard\\-analysis-salesRank",salesCardExtra:"antd-pro\\pages\\-dashboard\\-analysis-salesCardExtra",salesTypeRadio:"antd-pro\\pages\\-dashboard\\-analysis-salesTypeRadio",offlineCard:"antd-pro\\pages\\-dashboard\\-analysis-offlineCard",trendText:"antd-pro\\pages\\-dashboard\\-analysis-trendText",rankingTitle:"antd-pro\\pages\\-dashboard\\-analysis-rankingTitle",salesExtraWrap:"antd-pro\\pages\\-dashboard\\-analysis-salesExtraWrap"}}}]);