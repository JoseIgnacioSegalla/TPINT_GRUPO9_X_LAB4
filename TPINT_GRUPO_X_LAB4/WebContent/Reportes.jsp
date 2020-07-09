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
<form method="post" action="ServletReportes" style="margin:2%">
		
	<input type=submit name="btnRyL" value="Mostrar Alumnos Regulares y libres"	>
		
	</form>
<%
			int libres=0;
			int regulares=0;
			if(request.getAttribute("libres")!=null){
			libres= Integer.parseInt(request.getAttribute("libres").toString());
			regulares=Integer.parseInt(request.getAttribute("regulares").toString());
			
            DefaultPieDataset data=new DefaultPieDataset();
            data.setValue("Libres", libres);
            data.setValue("Regulares", regulares);
            
            
            JFreeChart grafico=ChartFactory.createPieChart("Estado porcentual de alumnos",data,true,true,true);
            
            response.setContentType("image/JPEG");
            OutputStream sa=response.getOutputStream();
            ChartUtils.writeChartAsJPEG(sa, grafico, 400, 400);
			}
			
			%>
</body>
</html>