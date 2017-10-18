<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/admin/partial/header.jsp"/>
<fmt:setLocale value="pt_BR"/>
<div class="row">
	<div class="col-md-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title"> Produtos Cadastrados </h3>
				<div class="box-tools">
					<div class="form-group">
						<a href="<%= request.getAttribute("base_url") + "/adm/produto/create" %> "><button class="btn btn-success">
							Cadastrar
						</button></a>
					</div>
				</div>
			</div>
			<div class="box-body table-responsive ">
				<table class="table table-hover">
		            <tbody>
		            	<tr>
							<th>Código</th>
							<th>Nome</th>
							<th>Grupo</th>
							<th>Preço</th>
							<th>Destaque</th>
							<th>Peso Padrão (Kg)</th>
							<th colspan="2"></th>
		            	</tr>

						<c:forEach var="produto" items="${produtos}">
		            	<tr>
							<td> ${produto.getId()} </td>
							<td> ${produto.getNome()} </td>
							<td> ${produto.getGrupo().getNome()} </td>
							<td> <fmt:formatNumber value="${produto.getPreco()}" type = "currency" /></td>
							<td> ${produto.getDestaque() ? 'Sim' : 'Não'} </td>
							<td> <fmt:formatNumber value="${produto.getPesoPadrao()}" type = "number" maxFractionDigits = "3" /></td>
							
							<td><a href="${base_url}/adm/produto/edit?id=${produto.getId()}">
								<span class="label label-primary">Editar</span>
							</a></td>
							
							<td><a href="#">
								<span id="${produto.getId()}" class="label label-danger delete_button" data-toggle="modal" data-target="#delete_modal">
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
<jsp:include page="/view/admin/partial/footer.jsp"/>