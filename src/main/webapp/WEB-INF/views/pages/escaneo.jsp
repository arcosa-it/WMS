<%--
  Created by IntelliJ IDEA.
  User: RICHARD
  Date: 13/04/2018
  Time: 06:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="ui segments">
    <div class="ui segment">
        <h2><i class="barcode icon"></i>Escanear Ingreso</h2>
    </div>
    <div class="ui segment">
        <div class="ui unstackable steps">
            <a class="active step" id="pallet">
                <i class="truck icon"></i>
                <div class="content">
                    <div class="title">Pallet</div>
                    <div class="description">Escanear Pallet</div>
                </div>
            </a>
            <a class="step" id="caja">
                <i class="boxes icon"></i>
                <div class="content">
                    <div class="title">Cajas</div>
                    <div class="description">Escanear Cajas</div>
                </div>
            </a>
        </div>
        <div class="primero">
            <div class="ui grid">
                <div class="one wide column"></div>
                <div class="sixteen wide column">
                    <div class="ui label">
                         Escanea el codigo de los pallets
                    </div>
                </div>
                <!--div class="sixteen wide column">
                    <div class="ui fluid icon input">
                        <i class="inverted circular barcode link icon"></i>
                        <input type="text" id="pallet_codigo">
                    </div>
                </div-->
                <div class="ui left action input">
                    <button class="ui teal labeled icon button">
                        <i class="barcode icon"></i>
                        Pallet tag
                    </button>
                    <input type="text" placeholder="Escanea el codigo del pallet...">
                </div>
                <div class="sixteen wide column">
                    <button class="ui blue button right floated" id="siguiente">Siguiente</button>
                </div>
            </div>
        </div>
        <div class="segundo">
            <div class="ui grid">
                <div class="one wide column"></div>
                <div class="sixteen wide column">
                    <div class="ui label">
                        Codigo de Escaneo
                    </div>
                </div>
                <div class="sixteen wide column">
                    <div class="ui fluid icon input">
                        <i class="inverted circular barcode link icon"></i>
                        <input type="text" id="codigo">
                    </div>
                </div>
                <div class="sixteen wide column">
                    <button class="ui blue button right floated" id="buscar">Buscar</button>
                </div>
            </div>

            <h3 id="titulo_pallet"></h3>

            <div class="ui styled accordion">
                <div class="title">
                    <i class="dropdown icon"></i>
                    Código caja: 156545325
                </div>
                <div class="content">
                    <ul>
                        <li>Producto: Jamón Virginia</li>
                        <li>Lote: 4565</li>
                        <li>SKU: 1596</li>
                        <li>Caducidad: 30/08/2019</li>
                        <li>Peso Bruto: 25.59</li>
                        <li>peso Neto: 24.48</li>
                    </ul>
                </div>
            </div>

        </div>
    </div>
</div>
