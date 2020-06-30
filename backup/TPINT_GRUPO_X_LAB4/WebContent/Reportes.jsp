<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.io.*"%>
<%@page import="org.jfree.chart.*"%>
<%@page import="org.jfree.chart.ChartUtils" %>
<%@page import="org.jfree.chart.plot.*"%>
<%@page import="org.jfree.data.general.*"%>
<%@page import="org.jfree.data.category.DefaultCategoryDataset.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
            DefaultPieDataset data=new DefaultPieDataset();
            data.setValue("Libres", 50);
            data.setValue("Regulares", 400);
            
            
            JFreeChart grafico=ChartFactory.createPieChart("Estado porcentual de alumnos",data,true,true,true);
            
            response.setContentType("image/JPEG");
            OutputStream sa=response.getOutputStream();
            ChartUtils.writeChartAsJPEG(sa, grafico, 400, 400);
%>
</body>
</html>