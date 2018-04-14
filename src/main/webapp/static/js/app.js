var app = {
	menu: function(){
		$('.ui.dropdown').dropdown({
		    on: 'hover'
		  });
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