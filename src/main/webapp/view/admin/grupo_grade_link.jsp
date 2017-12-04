<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/view/admin/partial/header.jsp"/>

<form action="${base_url}/adm/grupo/grade/link/post" method="POST">
	
	<input type="hidden" name="grupo_id" value="${grupo_id}"/>

	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-body  ">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label> Grade </label>
								<select class="form-control select2" name="grade_id">
									<c:forEach var="grade" items="${grades}">
			            	 			<option value="${grade.getId()}"> ${grade.getNome()} </option>
									</c:forEach>
								</select>
							</div>
						</div>
					</div>					
					<div class="box-footer">
						<a class="btn btn-default" href="${base_url}/adm/grupo/edit?id=${grupo_id}">Voltar</a>
						<input type="submit" class="btn btn-primary pull-right" value="Salvar"/>
					</div>
		        </div>	
		    </div>
		</div>
	</div>
</form>

<jsp:include page="/view/admin/partial/footer.jsp"/>