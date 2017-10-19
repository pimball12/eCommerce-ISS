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
								<label> Nome da Grade </label>
								<input type="text" name="grade_nome" class="form-control" required 
								value="${parametro.getNome()}" autofocus/>
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

<c:if test="${grade.getItensGrade() != null}">
<div class="row">
	<div class="col-md-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title"> Itens Cadastrados </h3>
				<div class="box-tools">
					<div class="form-group">
						<a href="${base_url}/adm/itemgrade/create?grade_id=${grade.getId()}"><button class="btn btn-success">
							Adicionar
						</button></a>
					</div>
				</div>
			</div> 
			<div class="box-body table-responsive ">
				<table class="table table-hover">
		            <tbody>
		            	<tr>
							<th>Código</th>
							<th>Valor</th>
							<th colspan="2"></th>
		            	</tr> 
		
						<tr>
							<td> ${itemGrade.getId()} </td>
							<td> ${itemGrade.getValor()} </td>
							
							<td><a href="${base_url}/adm/itemgrade/edit?id=${itemGrade.getId()}&grade_id=${grade.getId()}">
								<span class="label label-primary">Editar</span>
							</a></td>
						</tr> 
		          </tbody>
		        </table>	
	       </div>	
	   </div>
	</div>
</div>

<jsp:include page="/view/admin/partial/delete_modal.jsp"/>

</c:if>

<a class="btn btn-default" href="${base_url}/adm/grade">Voltar</a>

<jsp:include page="/view/admin/partial/footer.jsp"/>