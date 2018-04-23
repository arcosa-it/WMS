<%--
  Created by IntelliJ IDEA.
  User: larry
  Date: 23/04/2018
  Time: 10:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui segments">
    <div class="ui segment">
        <h2><i class="clipboard list icon"></i> Captura Ingresos</h2>
    </div>
    <div class="ui very padded segment">



        <div class="ui steps">
            <div class="step active"  id="step1">
                <i class="edit blue icon"></i>
                <div class="content">

                    <div class="title">Crear o Modificar</div>
                    <div class="description">Elige un método de envío </div>
                </div>
            </div>

            <div class="step" id="step2" style="">
                <i class="file alternate outline blue icon"></i>
                <div class="content">
                    <div class="title">Datos</div>
                    <div class="description">Introduce la información de pago</div>


                </div>
            </div>

            <div class="link step" id="step3">

                <i class="pencil alternate blue icon"></i>
                <div class="content">
                    <div class="title">Captura De Datos</div>
                    <div class="description">Introduce la información de pago</div>


                </div>
            </div>
        </div>






        <div class="ui segment" id="contenedor">

            <div class="ui grid">

                <div class="right floated five wide column">
                    <a href="#" id="crear" class="modificar"><i id="user" class="circular huge file alternate  icon"></i></a>
                    <div class="ui special popup">
                        <p>Selecciona esta opcion para crear una Ingreso</p>
                    </div>
                </div>

                <div class="right floated five wide column">

                    <a href="#" class="ingresar"><i id="user" class="circular huge pencil alternate  icon"></i></a>
                    <div class="ui special popup">
                        <p>Selecciona esta opcion para modificar una Ingreso</p>
                    </div>
                </div>

            </div>

        </div>






        <form class="ui form padded segment" id="formulario">

            <div class="ui grid">


                <div class="three column row">

                    <div class="column">
                        <div class="field">
                            <div class="ui left corner labeled input">
                                <input type="text" placeholder="ID DOCUMENTO" readonly="">
                                <div class="ui left corner label">
                                    <i class="asterisk loading icon"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>




                <div class="three column row">
                    <div class="column">
                        <div class="field">
                            <label for="id_cliente">ID CLIENTE </label>
                            <select>
                                <option value="">Selecciona Opcion</option>
                                <option>Sigma</option>
                                <option>Bachoco</option>
                                <option>Parrillero</option>
                                <option>La villita</option>
                            </select>
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label for="clave_producto">CLAVE DEL PRODUCTO</label>
                            <input type="text" name="clave_producto" id="clave_producto" placeholder="Clave Producto">
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label for="camara">CAMARA</label>
                            <input type="text" name="camara" id="camara" placeholder="Camara">
                        </div>
                    </div>

                </div>

                <div class="three column row">

                    <div class="column">
                        <div class="field">
                            <label for="temperatura">TEMPERATURA</label>
                            <input type="text" name="temperatura" id="temperatura" placeholder="Temperatura">
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="hora_ingreso">HORA INGRESO</label>
                            <div class="ui calendar" id="hora_ingreso">
                                <div class="ui input left icon">
                                    <i class="time icon"></i>
                                    <input type="text" placeholder="Hora Ingreso">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="column" id="fecha_div">
                        <div class="field">
                            <label for="codigo_barras">FECHA INGRESO</label>
                            <div class="ui input left icon">
                                <i class="calendar alternate outline icon"></i>
                                <input type="text" name="codigo_barras" id="codigo_barras" placeholder="Fecha Ingreso">
                            </div>
                        </div>



                    </div>
                </div>



                <div class="one column row">

                    <div class="column">
                        <div class="field">
                            <button id="paso_dos" class="ui right floated labeled icon button blue "><i class="right arrow icon"></i>Guardar</button>
                        </div>
                    </div>
                </div>
            </div>


        </form>





        <form class="ui form padded segment" id="formulario2">


            <div class="ui grid">


                <div class="three column row">

                    <div class="column">
                        <div class="field">
                            <div class="ui left corner labeled input">
                                <input type="text" placeholder="ID DOCUMENTO" readonly="">
                                <div class="ui left corner label">
                                    <i class="asterisk loading icon"></i>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>



                <div class="three column row">

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
                            <label for="marca">Marca</label>
                            <input type="text" name="marca" id="marca" placeholder="Marca">
                        </div>
                    </div>

                </div>

                <div class="four column row">

                    <div class="column">
                        <div class="field">
                            <label for="peso">Peso</label>
                            <input type="text" name="peso" id="peso" placeholder="Peso">
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="codigo_barras">Codigo De Barras</label>
                            <input type="text" name="codigo_barras" id="codigo_barras" placeholder="Codigo De Barras">
                        </div>
                    </div>

                    <div class="column" id="fecha_div">
                        <div class="field">
                            <label for="sku">SKU</label>
                            <input type="text" name="sku" id="sku" placeholder="SKU">
                        </div>
                    </div>

                    <div class="column">
                        <div class="field">
                            <label for="estatus">Estatus</label>
                            <select>
                                <option value="">Selecciona Opcion</option>
                                <option>Activado</option>
                                <option>Detener</option>
                                <option>Reactivar</option>
                            </select>
                        </div>
                    </div>
                </div>


                <div class="four column row">

                    <div class="column">

                        <div class="field">
                            <label for="medidas">Medidas</label>
                            <input type="text" name="medidas" id="medidas" placeholder="Medidas">
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label for="caducidad">Caducidad</label>
                            <input type="text" name="caducidad" id="caducidad" placeholder="Caducidad">
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label for="fecha_produccion">Fecha Producción</label>
                            <input type="text" name="fecha_produccion" id="fecha_produccion" placeholder="Fecha Producción">
                        </div>
                    </div>
                    <div class="column">
                        <div class="field">
                            <label for="clave_producto">Cuota De Cobro</label>
                            <input type="text" name="clave_producto" id="clave_producto" placeholder="Clave Del Producto">
                        </div>
                    </div>

                </div>


                <div class="one column row">
                    <div class="column">
                        <div class="field">
                            <button id="paso_dos" class="ui right floated labeled icon button blue "><i class="right arrow icon"></i>Finalizar</button>
                        </div>
                    </div>
                </div>

            </div> <!---termina grid-->
        </form>




        <table class="ui celled table" id="tabla_ingresos">
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
</div>
