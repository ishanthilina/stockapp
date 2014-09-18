<%--
  Created by IntelliJ IDEA.
  User: ishan
  Date: 9/18/14
  Time: 9:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="js/amcharts/amcharts.js" type="text/javascript"></script>
    <script src="js/amcharts/serial.js" type="text/javascript"></script>
    <script src="js/amcharts/amstock.js" type="text/javascript"></script>
    <link rel="stylesheet" href="js/amcharts/style.css" type="text/css">
    <title></title>

    <script type="text/javascript">

        var chartData= [
            {date: new Date(2011, 5, 1, 0, 0, 0, 0), val:10},
            {date: new Date(2011, 5, 2, 0, 0, 0, 0), val:11},
            {date: new Date(2011, 5, 3, 0, 0, 0, 0), val:12},
            {date: new Date(2011, 5, 4, 0, 0, 0, 0), val:11},
            {date: new Date(2011, 5, 5, 0, 0, 0, 0), val:10},
            {date: new Date(2011, 5, 6, 0, 0, 0, 0), val:11},
            {date: new Date(2011, 5, 7, 0, 0, 0, 0), val:13},
            {date: new Date(2011, 5, 8, 0, 0, 0, 0), val:14},
            {date: new Date(2011, 5, 9, 0, 0, 0, 0), val:17},
            {date: new Date(2011, 5, 10, 0, 0, 0, 0), val:13}
//            ,
//            {date: new Date(2011, 5, 1, 10, 0, 0, 0), val:10},
//            {date: new Date(2011, 5, 1, 11, 0, 0, 0), val:11},
//            {date: new Date(2011, 5, 1, 12, 0, 0, 0), val:12},
//            {date: new Date(2011, 5, 1, 13, 0, 0, 0), val:11},
//            {date: new Date(2011, 5, 1, 14, 0, 0, 0), val:10},
//            {date: new Date(2011, 5, 1, 15, 0, 0, 0), val:11},
//            {date: new Date(2011, 5, 1, 16, 0, 0, 0), val:13},
//            {date: new Date(2011, 5, 1, 17, 0, 0, 0), val:14},
//            {date: new Date(2011, 5, 1, 18, 0, 0, 0), val:17},
//            {date: new Date(2011, 5, 1, 19, 0, 0, 0), val:13}
        ];



        AmCharts.ready(function(){
            var chart = new AmCharts.AmStockChart();

            chart.pathToImages = "js/amcharts/images/";

            //dataset
            var dataSet = new AmCharts.DataSet();

            dataSet.dataProvider = chartData;

            dataSet.fieldMappings = [{fromField:"val", toField:"value"}];

            dataSet.categoryField = "date";

            chart.dataSets = [dataSet];

            //panel
            var stockPanel = new AmCharts.StockPanel();

            chart.panels = [stockPanel];

            //creating a graph for the panel

            var graph = new AmCharts.StockGraph();
            graph.valueField = "value";
            graph.type = "column";

            graph.fillAlphas = 1;   //dnt make column transparent
            graph.title = "Value"
            stockPanel.addStockGraph(graph);

            //set minimum display period
            var categoryAxesSettings = new AmCharts.CategoryAxesSettings();
            categoryAxesSettings.minPeriod = "hh";
            chart.categoryAxesSettings = categoryAxesSettings;

            //add chart to bottom also
            var chartScrollbarSettings = new AmCharts.ChartScrollbarSettings();
            chartScrollbarSettings.graph = graph;
            chartScrollbarSettings.graphType = "line";
            chart.chartScrollbarSettings = chartScrollbarSettings;

            //period selector
            var periodSelector = new AmCharts.PeriodSelector();
            chart.periodSelector = periodSelector;

            periodSelector.periods = [
                {period:"DD", count:1, label:"1 day"},
                {period:"DD", selected:true, count:5, label:"5 days"},
                {period:"MM", count:1, label:"1 month"},
                {period:"YYYY", count:1, label:"1 year"},
                {period:"YTD", label:"YTD"},
                {period:"MAX", label:"MAX"}
            ];

            chart.write("chartdiv");
        });
    </script>

</head>
<body>

<div id="chartdiv" style="width:100%; height:400px;"></div>

</body>
</html>