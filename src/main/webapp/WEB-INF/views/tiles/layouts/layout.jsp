<%--
  Created by IntelliJ IDEA.
  User: RICHARD
  Date: 12/04/2018
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>


<html>
<head>
    <title>WMS</title>
    <meta content="charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <%@include file="estilos.jsp"%>


</head>
<body>
    <tiles:insertAttribute name="sideBar" />




        <div class="pusher">
            <tiles:insertAttribute name="menu" />
            <div class="ui container">

                <tiles:insertAttribute name="body" />
            </div>

         </div>



    <tiles:insertAttribute name="footer" />
    <%@include file="scriptGrl.jsp"%>
</body>
</html>
