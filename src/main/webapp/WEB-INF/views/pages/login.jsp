<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="<c:url value="/static/css/login-estilos.css"/> "/>
<%--
  Created by IntelliJ IDEA.
  User: RICHARD
  Date: 11/04/2018
  Time: 11:38 PM
  To change this template use File | Settings | File Templates.
--%>
<div class="bg-login"></div>
<div class="ui middle aligned center aligned grid">
    <div class="column">
        <h2 class="ui blue image header">
            <img src="<c:url value='/static/img/logo-arcosa.png' />" class="image">
            <div class="content">
                WMS | <span>ARCOSA</span>
            </div>
        </h2>
        <form action="<c:url value="/home"/> " class="ui large form">
            <div class="ui stacked segment">
                <div class="field">
                    <div class="ui left icon input">
                        <i class="user icon"></i>
                        <input type="text" placeholder="Usuario..." id="usuario">
                    </div>
                </div>
                <div class="field">
                    <div class="ui left icon input">
                        <i class="lock icon"></i>
                        <input type="password" placeholder="Contraseña..." id="password">
                    </div>
                </div>
                <button class="ui fluid large blue submit button">Ingresar</button>
            </div>
        </form>
    </div>
</div>
