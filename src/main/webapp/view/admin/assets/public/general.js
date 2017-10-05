$(document).ready(function()	{

	$(".sidebar-toggle").click(function()	{
		$.ajax({
			url: base_url + "template/collapsed_sidebar",
			type: 'post',
			success: function(result){}
		});
	});

	$("#admin_treeview > a").click(function()	{
		$.ajax({
			url: base_url + "template/collapsed_admin_treeview",
			type: 'post',
			success: function(result){}
		});
	});
	
});