<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Highcharts Example</title>

		<style type="text/css">

		</style>
	</head>
	<body>

<script src="${pageContext.request.contextPath }/resource/Highcharts-6.0.7/code/highcharts.js"></script>
<script src="${pageContext.request.contextPath }/resource/Highcharts-6.0.7/code/highcharts-3d.js"></script>
<script src="${pageContext.request.contextPath }/resource/Highcharts-6.0.7/code/modules/exporting.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resource/js/jquery-1.9.1.js"></script>

<div id="container" style="height: 400px"></div>

<script type="text/javascript">

$(function(){
	alert(123);
	$.ajax({
        url: '${pageContext.request.contextPath }/customer/getSourceBingZhuang',
        type: 'GET',
        dataType: 'json',
        success: function(data){
            test(data);
        }
    })
})

function test(shuju){
	alert(1111)
	Highcharts.chart('container', {
	    chart: {
	        type: 'pie',
	        options3d: {
	            enabled: true,
	            alpha: 45,
	            beta: 0
	        }
	    },
	    title: {
	        text: '客户来源分布图'
	    },
	    tooltip: {
	        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
	    },
	    plotOptions: {
	        pie: {
	            allowPointSelect: true,
	            cursor: 'pointer',
	            depth: 35,
	            dataLabels: {
	                enabled: true,
	                format: '{point.name}'
	            }
	        }
	    },
	    series: [{
	        type: 'pie',
	        name: 'Browser share',
	        data: shuju
	    }]
	});
}
		</script>
	</body>
</html>