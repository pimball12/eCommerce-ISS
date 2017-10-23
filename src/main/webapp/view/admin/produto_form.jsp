<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/admin/partial/header.jsp"/>
<fmt:setLocale value="pt_BR"/>

<div class="row" >
	<div class="col-md-12">
		<div class="nav-tabs-custom">
			<ul class="nav nav-tabs">
			
				<li class="active">
					<a href="#tab_propriedades" data-toggle="tab" aria-expanded="true">Propriedades</a>				
				</li>
				
				<c:if test="${produto.getId() != 0}">
				
				<li>
					<a href="#tab_imagens" data-toggle="tab" aria-expanded="false">Imagens</a>				
				</li>
				
				<li>
					<a href="#tab_estoque" data-toggle="tab" aria-expanded="false">Estoque</a>				
				</li>	
						
				</c:if>						
						
			</ul>
			
			<div class="tab-content">
			
				<div id="tab_propriedades" class="tab-pane active">
				<form action="${base_url}/adm/produto/post">
					
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
								placeholder="Ex: 13,55" value="${produto.getPreco()}" autofocus/>
							</div>					
						</div>
											
						<div class="col-md-6"> 
							<div class="form-group">
								<label> Peso Padrão (Kg) </label>
								<input type="text" name="produto_pesoPadrao" class="form-control weight-numeric" required 
								placeholder="Ex: 1,329" value="${produto.getPesoPadrao()}" autofocus/>
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
						
							<input type="submit" class="btn btn-primary pull-right" value="Salvar"/>
							
						</div>
					</div>
										
				</form>
				</div>
				
				<c:if test="${produto.getId() != 0}">
				
					<div id="tab_imagens" class="tab-pane">
						
					</div>
						
					<div id="tab_estoque" class="tab-pane">
						
					</div>
				
				</c:if>			
						
			</div>
		</div>
	</div>
</div>

<jsp:include page="/view/admin/partial/delete_modal.jsp"/>
<jsp:include page="/view/admin/partial/footer.jsp"/>