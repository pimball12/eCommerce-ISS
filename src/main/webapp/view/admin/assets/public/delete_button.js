$(document).ready(function()	{
	$(".delete_button").on("click", function()	{
		var item_id = $(this).attr("id");
		$("#delete_input").val(item_id);
	});
});