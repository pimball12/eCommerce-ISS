<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/view/admin/partial/header.jsp"/>

<form action="${base_url}/adm/grupo/post" method="POST">
	
	<input type="hidden" name="id" value="${grupo.getId()}"/>

	<div class="row">
		<div class="col-md-12">
			<div class="box">
				<div class="box-body  ">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label> Nome do Grupo </label>
								<input type="text" name="grupo_nome" class="form-control" required 
								value="${grupo.getNome()}" autofocus/>
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

<c:if test="${grupo.getGrades() != null}">
<div class="row">
	<div class="col-md-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title"> Grades Associadas </h3>
				<div class="box-tools">
					<div class="form-group">
						<a href="${base_url}/adm/grupo/grade/link?grupo_id=${grupo.getId()}"><button class="btn btn-success">
							Adicionar
						</button></a>
					</div>
				</div>
			</div> 
			<div class="box-body table-responsive ">
				<table class="table table-hover">
		            <tbody>
		            	<tr>
		            		<th>Codigo</th>
							<th>Nome</th>
							<th colspan="1"></th>
		            	</tr> 
		
						<c:forEach var="grade" items="${grupo.getGrades()}">
		            	<tr>
							<td> ${grade.getId()} </td>
							<td> ${grade.getNome()} </td>
							<td><a href="#">
								<form action="${base_url}/adm/grupo/grade/unlink" method="POST">
									<input type="hidden" name="grupo_id" value="${grupo.getId()}"/>
									<input type="hidden" name="grade_id" value="${grade.getId()}"/>
									<button type="submit" class="label label-danger">
								</form>
								Desvincular</span>
							</a></td>			 		
						</tr> 
						</c:forEach>
		          </tbody>
		        </table>	
	       </div>	
	   </div>
	</div>
</div>

</c:if>

<a class="btn btn-default" href="${base_url}/adm/grupo">Voltar</a>

<jsp:include page="/view/admin/partial/footer.jsp"/>