<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/view/admin/partial/header.jsp"/>

<form action="${base_url}/adm/parametro/post" method="POST">
	
	<input type="hidden" name="id" value="${parametro.getId()}"/>

	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-body  ">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label> E-Mail </label>
								<input type="text" name="parametro_nome" class="form-control" required 
								value="${parametro.getEmail()}" autofocus/>
							</div>
							<div class="form-group">
								<label> Remetente </label>
								<input type="text" name="parametro_nome" class="form-control" required 
								value="${parametro.getEmail()}" autofocus/>
							</div>
						</div>
					</div>					
					<div class="box-footer">
						<input type="submit" class="btn btn-primary pull-right" value="Salvar"/>
					</div>
		        </div>	
		    </div>
		</div>
	</div>
</form>

<a class="btn btn-default" href="${base_url}/adm/grade">Voltar</a>

<jsp:include page="/view/admin/partial/footer.jsp"/>