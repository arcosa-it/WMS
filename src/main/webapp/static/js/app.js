var app = {
	menu: function(){
		$('.ui.dropdown').dropdown({
		    on: 'hover'
		  });
	},
    nombreInput: function(input){
        nombre = input.substring(input.lastIndexOf("\\") + 1, input.length);
        console.log(nombre);
    },
	init:function(){
		this.menu();
	}
};

app.init();


$("#file").on("change",function(){
	app.nombreInput($(this).val());
	alert($(this).val());
})