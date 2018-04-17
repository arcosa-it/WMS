<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RICHARD
  Date: 12/04/2018
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="desktop">
    <!--div class="ui top menu" id="mimenu"-->
    <div class="ui top pointing menu">
        <div class="item">
            <img src="<c:url value='/static/img/logo-arcosa.png' />">
        </div>
        <a href="" class="item active"><i class="home icon"></i>Home</a>
        <!--Ingresos-->
        <div class="ui dropdown item">
            <i class="dropdown icon"></i><i class="dolly icon"></i>Ingresos
            <div class="menu">
                <div class="item">
                    <i class="dropdown icon"></i>
                    Crear documento
                    <div class="menu">
                        <a href="<c:url value="/subirDocumento"/>" class="item">Subir Documento</a>
                        <a href="<c:url value="/capturaManual"/>" class="item">Captura Manual</a>
                    </div>
                </div>
                <a class="item">Verificación</a>
                <a href="<c:url value="/escaneo"/>" class="item">Escaneo</a>
            </div>
        </div>

        <a href="" class="item"><i class="boxes icon"></i>Surtidos</a>
        <a href="" class="item"><i class="pallet icon"></i>Ubicaciones</a>
        <div class="right menu">
            <a href="<c:url value="/login"/> " class="item"><i class="lock icon"></i>Salir</a>
        </div>
    </div>
</div>
<div class="telefono">
    <div class="ui top pointing menu">
        <div class="ui container">
            <div class="item">
                <img src="<c:url value='/static/img/logo-arcosa.png' />">
            </div>
            <div class="right menu">

                <a class="menu-tel launch icon item">
                    Menu
                    <i class="content icon" style="margin-left:10px"></i>

                </a>

            </div>

        </div>
    </div>
</div>

