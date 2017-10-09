<jsp:include page="/view/admin/partial/header.jsp"/>

<div class="row">
	<div class="col-md-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title"> Grades Cadastradas </h3>
				<div class="box-tools">
					<div class="form-group">
						<a href="#"><button class="btn btn-success">Cadastrar</button></a>
					</div>
				</div>
			</div>
			<div class="box-body table-responsive ">
				<table class="table table-hover">
		            <tbody>
		            	<tr>
							<th>Código</th>
							<th>Nome</th>
							<th colspan="3"></th>
		            	</tr>

		            	<tr>
							<td>1</td>
							<td>Cor</td>
							
							<td><a href="#">
								<span class="label label-primary">Editar</span>
							</a></td>
							
							<td><a href="#">
								<span class="label label-danger" >Excluir</span>
							</a></td>
							
							<td><a href="#">
								<span class="label label-success" >Valores</span>
							</a></td>							
						</tr>
		          </tbody>
		        </table>	
	        </div>	
	    </div>
	</div>
</div>

<jsp:include page="/view/admin/partial/footer.jsp"/>