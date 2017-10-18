$(document).ready(function()	{

	$(".sidebar-toggle").click(function()	{
		$.ajax({
			url: base_url + "/adm/view/sidebar",
			type: 'post',
			success: function(result){}
		});
	});	
	
});