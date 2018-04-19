<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RICHARD
  Date: 13/04/2018
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui segments">
    <div class="ui segment">
        <h2>
            <i class="file archive outline icon"></i>Subir Documento
        </h2>
    </div>
    <div class="ui segment">
        <form action="" class="ui form" id="form-escaneo">
            <div class="grid">
                <div class="eight wide column">
                    <div class="field">
                        <select name="idcliente" id="idcliente">
                            <c:forEach items="${clientes}" var="cliente">
                                <option value="${cliente.id_cliente}">${cliente.id_cliente} ${cliente.nom_cliente}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="three column row">
                    <div class="column">
                        
                    </div>
                    <div class="column">
                        <label for="file" class="ui icon button">
                            <i class="file icon"></i>
                            Adjuntar Documento</label>
                        <input type="file" style="display:none" id="file" multiple="" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"/>
                    </div>
                </div>
                <div class="three column row">
                    <h4 class="titulo-archivo"></h4>
                    <div class="ui segment" id="loader">
                        <div class="ui active inverted dimmer">
                            <div class="ui text loader">Cargando</div>
                        </div>
                        <p></p>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>