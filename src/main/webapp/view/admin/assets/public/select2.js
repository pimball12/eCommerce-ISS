$(document).ready(function()	{
	
	$(".select2").select2({
		"language": {
	       	noResults: function(){
	        	return "Nenhum resultado encontrado.";
	       	}
	   }
	});
	
});