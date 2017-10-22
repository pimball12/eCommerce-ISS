<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/view/admin/partial/header.jsp"/>

<div class="row">
	<div class="col-md-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title"> Parametros Gerais </h3>
				<div class="box-tools">
					<div class="form-group">
						<a href="<%= request.getAttribute("base_url") + "/adm/parametro/create" %> "><button class="btn btn-success">
							Cadastrar
						</button></a>
					</div>
				</div>
			</div>
			<div class="box-body table-responsive ">
				<table class="table table-hover">
		            <tbody>
		            	<tr>
							<th>E-Mail</th>
							<th>Remetente</th>
							<th colspan="2"></th>
		            	</tr>

						<c:forEach var="parametro" items="${parametro}">
		            	<tr>
							<td> ${parametro.getEmail()} </td>
							<td> ${parametro.getRemetente()} </td>
							
							<td><a href="${base_url}/adm/parametro/edit?id=${parametro.getId()}">
								<span class="label label-primary">Editar</span>
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
<jsp:include page="/view/admin/partial/footer.jsp"/>