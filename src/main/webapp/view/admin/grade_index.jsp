<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<jsp:include page="/view/admin/partial/header.jsp"/>
<%@page import="br.iss.ecommerce.domain.Grade"%>
<% List<Grade> grades = (ArrayList<Grade>)request.getAttribute("grades"); %>

<div class="row">
	<div class="col-md-12">
		<div class="box">
			<div class="box-header">
				<h3 class="box-title"> Grades Cadastradas </h3>
				<div class="box-tools">
					<div class="form-group">
						<a href="<%= request.getAttribute("base_url") + "/adm/grade/create" %> "><button class="btn btn-success">
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
							<th colspan="2"></th>
		            	</tr>

						<% for(Grade grade : grades) { %>
		            	<tr>
							<td> <%= grade.getId() %> </td>
							<td> <%= grade.getNome() %> </td>
							
							<td><a href="<%= request.getAttribute("base_url") + "/adm/grade/edit?id=" + grade.getId() %>">
								<span class="label label-primary">Editar</span>
							</a></td>
							
							<td><a href="<%= 	request.getAttribute("base_url") + 
												"/adm/grade/delete?id=" + grade.getId() %>">
								<span class="label label-danger" >Excluir</span>
							</a></td>							
						</tr>
						<% } %>
		          </tbody>
		        </table>	
	        </div>	
	    </div>
	</div>
</div>

<jsp:include page="/view/admin/partial/footer.jsp"/>