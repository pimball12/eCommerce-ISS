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
				<h3 class="box-title"> Grades Cadastrados </h3>
				<div class="box-tools">
					<div class="form-group">
						<a href="${base_url}/adm/grade/create?grade_id=${grupo.getId()}"><button class="btn btn-success">
							Adicionar
						</button></a>
					</div>
				</div>
			</div> 
			<div class="box-body table-responsive ">
				<table class="table table-hover">
		            <tbody>
		            	<tr>
							<th>Nome</th>
							<th colspan="1"></th>
		            	</tr> 
		
						<c:forEach var="grade" items="${grupo.getGrades()}">
		            	<tr>
							<td> ${grade.getId()} </td>
							<td> ${grade.getNome()} </td>
							
							<td><a href="${base_url}/adm/grade/edit?id=${grade.getId()}&grade_id=${grade.getId()}">
								<span class="label label-primary">Editar</span>
							</a></td>
							
							<td><a href="#">
								<span id="${grade.getId()}" class="label label-danger delete_button" data-toggle="modal" data-target="#delete_modal">
								Excluir</span>
							</a></td>			 		
						</tr> 
						</c:forEach>
		          </tbody>
		        </table>	
	       </div>	
	   </div>
	</div>
</div>

<jsp:include page="/view/admin/partial/delete_modal.jsp"/>

</c:if>

<a class="btn btn-default" href="${base_url}/adm/grupo">Voltar</a>

<jsp:include page="/view/admin/partial/footer.jsp"/>