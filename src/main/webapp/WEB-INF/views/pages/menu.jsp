<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RICHARD
  Date: 12/04/2018
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="ui secondary pointing menu" id="mimenu">
    <div class="item">
        <img src="<c:url value='/static/img/logo-arcosa.png' />">
    </div>
    <a href="" class="item active"><i class="home icon"></i>Home</a>
    <div class="ui dropdown item">
        <i class="dropdown icon"></i><i class="dolly icon"></i>Ingresos
        <div class="menu">
            <a class="item">Electronics</a>
            <a class="item">Automotive</a>
            <a class="item">Home</a>
        </div>
    </div>
    <a href="" class="item"><i class="boxes icon"></i>Surtidos</a>
    <a href="" class="item"><i class="pallet icon"></i>Ubicaciones</a>
    <div class="right menu">
        <a href="" class="item"><i class="lock icon"></i>Salir</a>
    </div>
</div>


