<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/admin/partial/header.jsp"/>
<fmt:setLocale value="pt_BR"/>

<div class="row" >
	<div class="col-md-12">
		<div class="nav-tabs-custom">
			<ul class="nav nav-tabs">
			
				<li class="${tab == 0 ? 'active' : ''}">
					<a href="#tab_propriedades" data-toggle="tab" aria-expanded="${tab == 0 ? 'true' : 'false'}">Propriedades</a>				
				</li>
				
				<c:if test="${produto.getId() != 0}">
				
				<li class="${tab == 1 ? 'active' : ''}">
					<a href="#tab_imagens" data-toggle="tab" aria-expanded="${tab == 1 ? 'true' : 'false'}">Imagens</a>				
				</li>
				
				<li class="${tab == 2 ? 'active' : ''}">
					<a href="#tab_estoque" data-toggle="tab" aria-expanded="${tab == 2 ? 'true' : 'false'}">Estoque</a>				
				</li>	
						
				</c:if>						
						
			</ul>
			
			<div class="tab-content">
			
				<div id="tab_propriedades" class="tab-pane ${tab == 0 ? 'active' : ''}">
					<form action="${base_url}/adm/produto/post" method="POST">
						
						<input type="hidden" name="id" value="${produto.getId()}"/>
						
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> Nome </label>
									<input type="text" name="produto_nome" class="form-control" required 
									value="${produto.getNome()}" autofocus/>
								</div>
							</div>
						</div>							
								
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> Descrição </label>
									<input type="text" name="produto_descricao" class="form-control"  
									value="${produto.getDescricao()}" autofocus/>
								</div>							
							</div>
						</div>
						
						<div class="row">	 
							<div class="col-md-6"> 
								<div class="form-group">
									<label> Preço (R$) </label>
									<input type="text" name="produto_preco" class="form-control currency-numeric" required 
									placeholder="Ex: 13,55" value="<fmt:formatNumber value="${produto.getPreco()}" type = "number" maxFractionDigits = "2" minFractionDigits = "2"/>" autofocus/>
								</div>					
							</div>
												
							<div class="col-md-6"> 
								<div class="form-group">
									<label> Peso Padrão (Kg) </label>
									<input type="text" name="produto_pesoPadrao" class="form-control weight-numeric" required 
									placeholder="Ex: 1,329" value="<fmt:formatNumber value="${produto.getPesoPadrao()}" type = "number" maxFractionDigits = "3" minFractionDigits = "3" />" autofocus/>
								</div>									
							</div>
						</div>		
						
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label> Grupo </label>
									<select name="grupo_id" class="form-control select2">
										<c:forEach var="grupo" items="${grupos}">
										<option value="${grupo.getId()}" ${grupo.getId() == produto.getGrupo().getId() ? 'selected' : '' }>
									${grupo.getNome()}
									</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>							
						
						<div class="row">					
							<div class="col-md-6">
								<div class="form-group">
									<label>
										<input type="checkbox" name="produto_ativo" value="ativo" ${produto.getAtivo() ? 'checked' : ''}>
										 Ativo
									</label>
								</div>						
							</div>	
							
							<div class="col-md-6">
								<div class="form-group"> 
									<label>
										<input type="checkbox" name="produto_destaque" value="destaque" ${produto.getDestaque() ? 'checked' : ''}>
										 Destaque
									</label>
								</div>						
							</div>								
						</div>	
						
						<div class="row">
							<div class="col-md-12">
							
								<a class="btn btn-default" href="${base_url}/adm/produto">Voltar</a>
							
								<input type="submit" class="btn btn-primary pull-right" value="Salvar"/>
								
							</div>
						</div>

					</form>
				</div>
				
				<c:if test="${produto.getId() != 0}">
				
					<div id="tab_imagens" class="tab-pane ${tab == 1 ? 'active' : ''}">
						
						<form action="${base_url}/adm/imagem/post" method="POST" enctype="multipart/form-data">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="image">Enviar Imagem</label>
										<input id="image" type="file" name="imagem" required/>
									
										<p class="help-block">Selecione a imagem a ser associada ao produto.</p>
									</div>							
								</div>
								<div class="col-md-6">
									<br class="hidden-xs"/>
									<input type="submit" class="btn btn-success btn-lg" value="Enviar"/>
								</div>
							</div>
						</form>		 
						
						<hr/>
						
							
					</div> 
						
					<div id="tab_estoque" class="tab-pane ${tab == 2 ? 'active' : ''}"> 
						
					</div>
				
				</c:if>			
						
			</div>
		</div>
	</div>
</div>

<jsp:include page="/view/admin/partial/delete_modal.jsp"/>
<jsp:include page="/view/admin/partial/footer.jsp"/>