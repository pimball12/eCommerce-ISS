<!-- Delete Modal -->
<div class="modal fade" id="delete_modal" tabindex="-1" role="dialog" aria-labelledby="delete_modal_label">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="delete_modal_label">Confirmação</h4>
      </div>
      <div class="modal-body">
        ${delete_modal_message}
      </div>
      <div class="modal-footer">
      	<div class="row">
      		<div class="col-md-2">
      			<form action=" ${base_url}${delete_modal_url}" method="POST">
		        	<input type="hidden" name="id" id="delete_input" value=""/>
		        	<input type="submit" class="btn btn-danger" value="Excluir"/>
		        </form>
      		</div>
      	</div>
      </div>
    </div>
  </div>
</div>