<%--
  Created by IntelliJ IDEA.
  User: RICHARD
  Date: 16/04/2018
  Time: 06:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui segments">
    <div class="ui segment">
        <h2><i class="clipboard list icon"></i> Captura Ingresos <button class="ui right floated labeled icon button blue "><i class="right arrow icon"></i>Guardar</button></h2>
    </div>
    <div class="ui very padded segment">


        <form class="ui form">
            <div class="ui grid">


                <div class="four column row">
                    <div class="column">
                        <div class="field">
                            <label for="documento"><i class="asterisk loading icon"></i>ID DOCUMENTO</label>
                            <input type="text" name="lote" id="documento" placeholder="111-111-454" value="" readonly="">
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="registro"><i class="asterisk loading icon"></i>Numero De Registro</label>
                            <input type="text" name="num_registro" id="registro" placeholder="Numero Registro" value="" readonly="">
                        </div>
                    </div>

                </div>


                <div class="five column row">
                    <div class="column">
                        <div class="field">
                            <label for="lote">Lote</label>
                            <input type="text" name="lote" id="lote" placeholder="Lote">
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label for="lote">Cantidad</label>
                            <input type="text" name="cantidad" id="cantidad" placeholder="Cantidad">
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label for="id_cliente">Id Cliente</label>
                            <input type="text" name="id_cliente" id="id_cliente" placeholder="Id Cliente">
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label for="marca">Marca</label>
                            <input type="text" name="marca" id="marca" placeholder="Marca">
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="marca">Temperatura</label>
                            <input type="text" name="temperatura" id="temperatura" placeholder="Temperatura">
                        </div>
                    </div>

                </div>

                <div class="three column row">

                    <div class="column">
                        <div class="field">
                            <label for="peso_neto">Peso Neto</label>
                            <input type="text" name="peso_neto" id="peso_neto" placeholder="Peso Neto">
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="peso_bruto">Peso Bruto</label>
                            <input type="text" name="peso_bruto" id="peso_bruto" placeholder="Peso Bruto">
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="codigo_barras">Codigo De Barras</label>
                            <input type="text" id="codigo_barras" name="codigo_barras" id="codigo_barras" placeholder="Codigo De Barras">
                        </div>
                    </div>
                </div>


                <div class="three column row">

                    <div class="column">
                        <div class="field">
                            <label for="sku">SKU</label>
                            <input type="text" name="sku" id="sku" placeholder="SKU">
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="estatus">Estatus</label>
                            <select id="estatus">
                                <option value="">Selecciona Opcion</option>
                                <option>Activado</option>
                                <option>Detener</option>
                                <option>Reactivar</option>
                            </select>
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="medidas">Medidas</label>
                            <input type="text" name="medidas" id="medidas" placeholder="Medidas">
                        </div>
                    </div>
                </div>


                <div class="three column row">

                    <div class="column">
                        <div class="field">
                            <label for="caducidad">Caducidad</label>
                            <input type="text" name="caducidad" id="caducidad" placeholder="Caducidad">
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="fecha_produccion">Fecha Producción</label>
                            <div class="ui calendar" id="fecha_div">
                                <div class="ui input left icon">
                                    <i class="calendar icon"></i>
                                    <input type="text" placeholder="Date" readonly="" id="fecha_produccion">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="clave_producto">Cuota De Cobro</label>
                            <input type="text" name="clave_producto" id="clave_producto" placeholder="Clave Del Producto">
                        </div>
                    </div>
                </div>




                <div class="three column row">

                    <div class="column">
                        <div class="field">
                            <label for="fecha_ingre">Facha Ingreso</label>
                            <input type="text" name="fecha_ingre" placeholder="Fecha Ingreso" readonly="" id="fecha_ingre">
                        </div>
                    </div>



                    <div class="column">
                        <div class="field">
                            <label for="hora">Hora Ingreso</label>
                            <input type="text" name="hora" id="hora" readonly="" placeholder="Hora">
                        </div>
                    </div>


                    <div class="column">
                        <div class="field">
                            <label for="camara">Camara</label>
                            <input type="text" name="camara" id="camara" placeholder="Camara">
                        </div>
                    </div>
                </div>



                <div class="one column row">

                    <div class="column">
                        <div class="field">
                            <label for="descripcion">Descripción</label>
                            <input type="text" id="descripcion" placeholder="descripción">
                        </div>
                    </div>
                </div>


                <!--<div class="one column row">

                    <div class="column">
                        <div class="field">
                            <button class="ui right floated labeled icon button blue "><i class="right arrow icon"></i>Guardar</button>
                        </div>
                    </div>
                </div>-->


                <table class="ui celled table">


                    <thead>
                    <tr>
                        <th>No. Registro</th>
                        <th>Producto</th>
                        <th>Descripción</th>
                        <th>Cantidad</th>
                        <th>SKU</th>
                        <th>Caducidad</th>
                        <th>Lote</th>
                        <th>Peso Bruto</th>
                        <th>Peso Neto</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>
                            <div class="ui ribbon label">First</div>
                        </td>
                        <td>Celda</td>
                        <td>Celda</td>
                    </tr>
                    <tr>
                        <td>Celda</td>
                        <td>Celda</td>
                        <td>Celda</td>
                    </tr>
                    <tr>
                        <td>Celda</td>
                        <td>Celda</td>
                        <td>Celda</td>
                    </tr>

                    <tr>
                        <td>Celda</td>
                        <td>Celda</td>
                        <td>Celda</td>
                    </tr>
                    </tbody>
                </table>



            </div>
        </form>
    </div>
</div>
