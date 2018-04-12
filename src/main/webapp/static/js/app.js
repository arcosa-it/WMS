var app = {
	menu: function(){
		$('.ui.dropdown').dropdown({
		    on: 'hover'
		  });
	},
	init:function(){
		this.menu();
	}
};

app.init();

