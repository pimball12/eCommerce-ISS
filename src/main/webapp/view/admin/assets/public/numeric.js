$(document).ready(function()	{

	$(".weight-numeric").numeric({ decimalPlaces : 3, negative : false, decimal : "," })
						.focus(function(){$(this).select()});
	
	$(".currency-numeric").numeric({ decimalPlaces : 2, negative : false, decimal : "," })
						  .focus(function(){$(this).select()});

});