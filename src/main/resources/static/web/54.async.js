(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[54],{Jqna:function(e,a,t){"use strict";var n=t("284h"),l=t("TqRt");Object.defineProperty(a,"__esModule",{value:!0}),a.default=void 0,t("IzEo");var r=l(t("bx4M"));t("Znn+");var d=l(t("ZTPi"));t("14J3");var i=l(t("BMrR"));t("jCWc");var f=l(t("kPKH")),u=n(t("q1tI")),o=t("LLXN"),c=l(t("lVjH")),s=t("KTCi"),m=l(t("LOQS")),p=function(e){var a=e.data,t=e.currentTabKey;return u.default.createElement(i.default,{gutter:8,style:{width:138,margin:"8px 0"}},u.default.createElement(f.default,{span:12},u.default.createElement(m.default,{title:a.name,subTitle:u.default.createElement(o.FormattedMessage,{id:"app.analysis.conversion-rate",defaultMessage:"Conversion Rate"}),gap:2,total:"".concat(100*a.cvr,"%"),theme:t!==a.name&&"light"})),u.default.createElement(f.default,{span:12,style:{paddingTop:36}},u.default.createElement(s.Pie,{animate:!1,color:t!==a.name&&"#BDE4FF",inner:.55,tooltip:!1,margin:[0,0,0,0],percent:100*a.cvr,height:64})))},g=d.default.TabPane,v=(0,u.memo)(function(e){var a=e.activeKey,t=e.loading,n=e.offlineData,l=e.offlineChartData,i=e.handleTabChange;return u.default.createElement(r.default,{loading:t,className:c.default.offlineCard,bordered:!1,style:{marginTop:32}},u.default.createElement(d.default,{activeKey:a,onChange:i},n.map(function(e){return u.default.createElement(g,{tab:u.default.createElement(p,{data:e,currentTabKey:a}),key:e.name},u.default.createElement("div",{style:{padding:"0 24px"}},u.default.createElement(s.TimelineChart,{height:400,data:l,titleMap:{y1:(0,o.formatMessage)({id:"app.analysis.traffic"}),y2:(0,o.formatMessage)({id:"app.analysis.payments"})}})))})))}),y=v;a.default=y}}]);