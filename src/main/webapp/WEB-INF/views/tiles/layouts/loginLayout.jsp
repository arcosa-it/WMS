<%--
  Created by IntelliJ IDEA.
  User: RICHARD
  Date: 11/04/2018
  Time: 11:11 PM
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
    <%@include file="estilos.jsp"%>
    <style type="text/css">
        body {
            background-color: #DADADA;
        }
        .grid {
            height: 100%;
        }
        .image {
            margin-top: -100px;
        }
        .column {
            max-width: 450px;
        }
    </style>
</head>
<body>
    <div class="ui container">
        <tiles:insertAttribute name="body" />
    </div>
    <script>
        $(document)
            .ready(function() {
                $('.ui.form')
                    .form({
                        fields: {
                            email: {
                                identifier  : 'usuario',
                                rules: [
                                    {
                                        type   : 'empty',
                                        prompt : 'Por favor Ingresa tu usuario'
                                    }
                                ]
                            },
                            password: {
                                identifier  : 'password',
                                rules: [
                                    {
                                        type   : 'empty',
                                        prompt : 'Por favor ingresa tu contraseña'
                                    },
                                    {
                                        type   : 'length[4]',
                                        prompt : 'Tu Contraseña debe contener por lo menos 4 caracteres'
                                    }
                                ]
                            }
                        }
                    })
                ;
            })
        ;
    </script>
</body>
</html>
