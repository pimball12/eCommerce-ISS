<jsp:include page="/view/admin/partial/header.jsp"/>

<form action="${base_url}/adm/itemgrade/post" method="POST">
	
	<input type="hidden" name="id" value="${itemGrade.getId()}"/>
	<input type="hidden" name="grade_id" value="${grade_id}"/>

	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-body  ">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label> Valor do Item de Grade </label>
								<input type="text" name="itemgrade_valor" class="form-control" required 
								value="${itemGrade.getValor()}" autofocus/>
							</div>
						</div>
					</div>					
					<div class="box-footer">
						<a class="btn btn-default" href="${base_url}/adm/grade/edit?id=${grade_id}">Voltar</a>
						<input type="submit" class="btn btn-primary pull-right" value="Salvar"/>
					</div>
		        </div>	
		    </div>
		</div>
	</div>
</form>

<jsp:include page="/view/admin/partial/footer.jsp"/>