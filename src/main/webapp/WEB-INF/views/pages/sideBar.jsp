<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: astwer
  Date: 14/04/18
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<div class="ui left vertical inverted menu sidebar">
    <a href="" class="item">
        <i class="home icon"></i>Home
    </a>
    <div class="item">
        <i class="dolly icon"></i>Ingresos
        <div class="menu">

            <a href="<c:url value="/subirDocumento"/> " class="item">Crear docuemnto</a>
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