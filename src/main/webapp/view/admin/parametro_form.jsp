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
								<input type="text" name="email" class="form-control" required 
								value="${parametro.getEmail()}" autofocus/>
							</div>
							<label> Remetente </label>
							<div class="form-group">
								<label> Pais </label>
								<input type="text" name="pais" class="form-control" required 
								value="${parametro.getRemetente().getPais()}" autofocus/>
							</div>
							<div class="form-group">
								<label> Estado </label>
								<input type="text" name="pais" class="form-control" required 
								value="${parametro.getRemetente().getEstado()}" autofocus/>
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
<jsp:include page="/view/admin/partial/footer.jsp"/>