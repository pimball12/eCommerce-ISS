<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/usuario/usuario_form.jsp"/>
<fmt:setLocale value="pt_BR"/>

<div class="row" >
	<div class="col-md-12">
		<div class="nav-tabs-custom">
			<div class="tab-content">
			
				<div id="tab_propriedades" class="tab-pane ${tab == 0 ? 'active' : ''}">
					<form action="${base_url}/usuario/post" method="POST">
						
						<input type="hidden" name="id" value="${usuario.getId()}"/>
						
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> Nome </label>
									<input type="text" name="produto_nome" class="form-control" required 
									value="${usuario.getPessoa().getNome()}" autofocus/>
								</div>
							</div>
						</div>							
								
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> Sobrenome </label>
									<input type="text" name="produto_descricao" class="form-control"  
									value="${usuario.getPessoa().getSobrenome()}" autofocus/>
								</div>							
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> CPF </label>
									<input type="text" name="produto_descricao" class="form-control"  
									value="${usuario.getPessoa().getCpf()}" autofocus/>
								</div>							
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> Telefone </label>
									<input type="text" name="produto_descricao" class="form-control"  
									value="${usuario.getPessoa().getTelefone()}" autofocus/>
								</div>							
							</div>
						</div>
						
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> E-Mail </label>
									<input type="text" name="produto_descricao" class="form-control"  
									value="${usuario.getEmail()}" autofocus/>
								</div>							
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> Senha </label>
									<input type="text" name="produto_descricao" class="form-control"/>
								</div>							
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> Confirmar Senha </label>
									<input type="text" name="produto_descricao" class="form-control"/>
								</div>							
							</div>
						</div>
					</form>
				</div>					
			</div>
		</div>
	</div>
</div>

<jsp:include page="/view/admin/partial/delete_modal.jsp"/>
<jsp:include page="/view/admin/partial/footer.jsp"/>