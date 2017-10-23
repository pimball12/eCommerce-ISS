$(document).ready(function()	{

	$("[data-mask]").inputmask();

	$("[data-mask]").datepicker({
		autoclose: true,
		format: 'dd/mm/yyyy',                
	    language: 'pt-BR'
	});
	
});