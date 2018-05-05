<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: RICHARD
  Date: 03/05/2018
  Time: 05:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<option value="">Selecciona una opción</option>
<c:forEach items="${cuotas}" var="c">
    <option value="${c.clave_producto}">${c.producto} a ${c.periodo} días</option>
</c:forEach>
