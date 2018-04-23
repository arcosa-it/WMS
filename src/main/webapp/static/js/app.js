var app = {
	menu: function(){
		$('.ui.dropdown').dropdown({
		    on: 'hover'
		});
	},
	menuSide:function(){

	},
    nombreInput: function(input){
        nombre = input.substring(input.lastIndexOf("\\") + 1, input.length);
		$(".titulo-archivo").html(nombre);

    },
	pasosEscaneo: function (codigo) {
        $(".primero").hide();
        $(".segundo").show();
        $("#pallet").removeClass("active");
        $("#caja").addClass("active")
		$("#titulo_pallet").text("Código de Pallet: "+codigo);
    },
	uploadFile: function () {
        var inputFile = document.getElementById("file");
        var file = inputFile.files[0];
        var data = new FormData(document.getElementById("form-escaneo"));
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        var idcliente = document.getElementById("idcliente");
        //data.append('archivo',file);
        $.ajax({
            url: 'admin_leerExcel',
            type: 'POST',
            contentType: false,
            beforeSend: function (xhr) {
                $("#loader").show();
                xhr.setRequestHeader(header,token);
            },
            success: function (data) {
                var success = document.getElementById("result");
                success.innerHTML = data;
                var file_input = $('#file');
                file_input.reset();
                $("#loader").hide();
            },
            data:data,
            processData:false,
            cache:false,
            enctype: "multipart/form-data"
        });
    },
    capturaManual: function () {
        $(".step-2").hide();
        $("#formulario").hide();
        $("#formulario2").hide();
        $("#tabla_ingresos").hide();


        $('#fecha_div').calendar({
            monthFirst: false,
            type: 'date',
            today: 'true',
            formatter: {
                date: function(date, settings) {
                    if (!date) return '';
                    return date.toLocaleString('en-us', { year: 'numeric', month: '2-digit', day: '2-digit' }).replace(/(\d+)\/(\d+)\/(\d+)/, '$2/$1/$3');
                }
            }
        });


        $('#hora_ingreso').calendar({
            type: 'time'
        });





        $('.ingresar')
            .popup({
                inline: true
            })
        ;



        $('.modificar')
            .popup({
                inline: true
            })
        ;



        $("#crear").click(function (){

            $("#step2").addClass("active");
            $("#step1").removeClass("active");
            $(".step-1").hide();

            //alert("hola mundo");



            $('#contenedor')
                .transition({
                    animation  : 'scale',
                    duration   : '0.5s',
                    onComplete : function() {
                        $(".step-2").show();
                        $("#formulario").show();
                    }
                });
            return false;


        });


        $("#paso_dos").click(function (){

            $("#step3").addClass("active");
            $("#step2").removeClass("active");

            $(".step-1").hide();





            //alert("hola mundo");


            $('#formulario')
                .transition({
                    animation  : 'scale',
                    duration   : '0.5s',
                    onComplete : function() {


                        $("#formulario").hide();


                        $("#formulario2").show();
                        $("#tabla_ingresos").show();


                    }
                });
            return false;


        });
    },
	init:function(){
		this.menu();
	}
};

app.init();

app.capturaManual();

$(".primero").show();
$(".segundo").hide();

$("#file").on("change",function(){
	app.nombreInput($(this).val());
})
$("#siguiente").click(function () {
	var codigo_pallet=$("#pallet_codigo").val();
	app.pasosEscaneo(codigo_pallet);
})
$('.ui.accordion').accordion()

$('.menu-tel').click(function(){
	$(".sidebar").sidebar("toggle");
})
    ///.sidebar('setting', 'transition', 'push')
$("#loader").hide()

$('#fecha_div').calendar({
    monthFirst: false,
    type: 'date',
    today: 'true',
    formatter: {
        date: function (date, settings) {
            if (!date) return '';
            return date.toLocaleString('es-es', {year: 'numeric', month: '2-digit', day: '2-digit'}).replace(/(\d+)\/(\d+)\/(\d+)/, '$2/$1/$3');
        }
    }
})
$("#aceptar").click(function () {
    app.uploadFile();
})