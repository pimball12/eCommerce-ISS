$(document).ready(function()	{
	
	$(".numeric").numeric({negative : false, decimalPlaces : 0, decimal : "\0"});
	
	$(".int-numeric").numeric({negative : true, decimalPlaces : 0, decimal : "\0"});

	$(".weight-numeric").numeric({ decimalPlaces : 3, negative : false, decimal : "," })
						.focus(function(){$(this).select()});
	
	$(".currency-numeric").numeric({ decimalPlaces : 2, negative : false, decimal : "," })
						  .focus(function(){$(this).select()});

});