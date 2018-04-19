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
        //data.append('archivo',file);
        $.ajax({
            url: 'leerExcel',
            type: 'POST',
            contentType: false,
            beforeSend: function () {
                $("#loader").show();
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
	init:function(){
		this.menu();
	}
};

app.init();

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
});