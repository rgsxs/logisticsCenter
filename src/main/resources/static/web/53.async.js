(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[53],{"20K/":function(e,a,t){"use strict";var l=t("284h"),s=t("TqRt");Object.defineProperty(a,"__esModule",{value:!0}),a.default=void 0,t("IzEo");var n=s(t("bx4M"));t("14J3");var d=s(t("BMrR"));t("jCWc");var r=s(t("kPKH"));t("Znn+");var u=s(t("ZTPi"));t("iQDF");for(var i=s(t("+eQT")),m=l(t("q1tI")),f=t("LLXN"),c=s(t("ZhIB")),o=s(t("lVjH")),g=t("KTCi"),E=i.default.RangePicker,p=u.default.TabPane,k=[],y=0;y<7;y+=1)k.push({title:(0,f.formatMessage)({id:"app.analysis.test"},{no:y}),total:323234});var v=(0,m.memo)(function(e){var a=e.rangePickerValue,t=e.salesData,l=e.isActive,s=e.handleRangePickerChange,i=e.loading,y=e.selectDate;return m.default.createElement(n.default,{loading:i,bordered:!1,bodyStyle:{padding:0}},m.default.createElement("div",{className:o.default.salesCard},m.default.createElement(u.default,{tabBarExtraContent:m.default.createElement("div",{className:o.default.salesExtraWrap},m.default.createElement("div",{className:o.default.salesExtra},m.default.createElement("a",{className:l("today"),onClick:function(){return y("today")}},m.default.createElement(f.FormattedMessage,{id:"app.analysis.all-day",defaultMessage:"All Day"})),m.default.createElement("a",{className:l("week"),onClick:function(){return y("week")}},m.default.createElement(f.FormattedMessage,{id:"app.analysis.all-week",defaultMessage:"All Week"})),m.default.createElement("a",{className:l("month"),onClick:function(){return y("month")}},m.default.createElement(f.FormattedMessage,{id:"app.analysis.all-month",defaultMessage:"All Month"})),m.default.createElement("a",{className:l("year"),onClick:function(){return y("year")}},m.default.createElement(f.FormattedMessage,{id:"app.analysis.all-year",defaultMessage:"All Year"}))),m.default.createElement(E,{value:a,onChange:s,style:{width:256}})),size:"large",tabBarStyle:{marginBottom:24}},m.default.createElement(p,{tab:m.default.createElement(f.FormattedMessage,{id:"app.analysis.sales",defaultMessage:"Sales"}),key:"sales"},m.default.createElement(d.default,null,m.default.createElement(r.default,{xl:16,lg:12,md:12,sm:24,xs:24},m.default.createElement("div",{className:o.default.salesBar},m.default.createElement(g.Bar,{height:295,title:m.default.createElement(f.FormattedMessage,{id:"app.analysis.sales-trend",defaultMessage:"Sales Trend"}),data:t}))),m.default.createElement(r.default,{xl:8,lg:12,md:12,sm:24,xs:24},m.default.createElement("div",{className:o.default.salesRank},m.default.createElement("h4",{className:o.default.rankingTitle},m.default.createElement(f.FormattedMessage,{id:"app.analysis.sales-ranking",defaultMessage:"Sales Ranking"})),m.default.createElement("ul",{className:o.default.rankingList},k.map(function(e,a){return m.default.createElement("li",{key:e.title},m.default.createElement("span",{className:"".concat(o.default.rankingItemNumber," ").concat(a<3?o.default.active:"")},a+1),m.default.createElement("span",{className:o.default.rankingItemTitle,title:e.title},e.title),m.default.createElement("span",{className:o.default.rankingItemValue},(0,c.default)(e.total).format("0,0")))})))))),m.default.createElement(p,{tab:m.default.createElement(f.FormattedMessage,{id:"app.analysis.visits",defaultMessage:"Visits"}),key:"views"},m.default.createElement(d.default,null,m.default.createElement(r.default,{xl:16,lg:12,md:12,sm:24,xs:24},m.default.createElement("div",{className:o.default.salesBar},m.default.createElement(g.Bar,{height:292,title:m.default.createElement(f.FormattedMessage,{id:"app.analysis.visits-trend",defaultMessage:"Visits Trend"}),data:t}))),m.default.createElement(r.default,{xl:8,lg:12,md:12,sm:24,xs:24},m.default.createElement("div",{className:o.default.salesRank},m.default.createElement("h4",{className:o.default.rankingTitle},m.default.createElement(f.FormattedMessage,{id:"app.analysis.visits-ranking",defaultMessage:"Visits Ranking"})),m.default.createElement("ul",{className:o.default.rankingList},k.map(function(e,a){return m.default.createElement("li",{key:e.title},m.default.createElement("span",{className:"".concat(o.default.rankingItemNumber," ").concat(a<3?o.default.active:"")},a+1),m.default.createElement("span",{className:o.default.rankingItemTitle,title:e.title},e.title),m.default.createElement("span",null,(0,c.default)(e.total).format("0,0")))})))))))))}),M=v;a.default=M}}]);