<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/user/partial/header.jsp"/>
<fmt:setLocale value="pt_BR"/>

<div class="back">
    <h2> Fechar Pedido </h2>
</div> 

<div class="product">
    <div class="container">
        <div class="col-md-12 product-price1">
        	<h1 class="container-header">Itens do Pedido</h1>
            <div class="check-out">
                <div class=" cart-items">
                    <div class="in-check">
                        <ul class="unit">
                            <li><span>Item</span></li>
                            <li><span>Produto </span></li>
                            <li><span></span></li>
                            <li style="text-align: right;"><span >Quantidade</span></li>
                            <li style="text-align: right;"><span >Preço</span></li>
                            <div class="clearfix"> </div>
                        </ul>
                        <c:if test="${cart.isEmpty()}">
                        <ul class="cart-header">
	                        <li><span></span></li>
	                        <li><span></span></li>
	                        <li><span><h4>Não há itens no carrinho</h4> </span></li>
	                        <li><span></span></li>
	                        <li><span></span></li>
	                        <div class="clearfix"> </div>
                        </ul>
                        </c:if>
                        <c:forEach items="${cart}" var="item">
                        <ul class="cart-header"> 
                            <a href="${base_url}/produto/remove?estoque_id=${item.getId()}" class="close1"></a>
                            <c:set var="imagens" value="${imagemDAO.listByProduto(item.getProduto().getId())}"></c:set>
                            <li class="ring-in"><a href="${base_url}/produto?id=${item.getProduto().getId()}"><img src="${base_url}/adm/imagem/get?path=${imagens.size() > 0 ? imagens.toArray()[0].getCaminho() : ''}" class="img-responsive" alt=""></a>
                            </li>
                            <li>
                            	<span>
                            	${item.getProduto().getNome()}   
                            	<c:set var="itensGrade" value="${itemGradeDAO.listByEstoque(item.getId())}"></c:set>
                            	<c:forEach var="itemGrade" items="${itensGrade}">
                            	 ; ${itemGrade.getGrade().getNome()}:${itemGrade.getValor()}
                            	</c:forEach>
                            	</span>
                            </li>
                            <li><span></span></li>
                            <li><span style="text-align: right;">1 <!-- Modificar --></span></li>
                            <li><span style="text-align: right;"><fmt:formatNumber value="${item.getProduto().getPreco()}" type = "currency" /></span></li>
                            <div class="clearfix"> </div>
                        </ul> 						
						</c:forEach>
                    </div>
                    <ul class="unit">                     
                        <li ><span></span></li>
                        <li><span></span></li>
                        <li><span></span></li>
						<li style="text-align: right;"><span>Itens: ${cart_quant}</span></li> 
                        <li style="text-align: right;"><span>Total: <fmt:formatNumber value="${cart_total}" type = "currency" /></span></li>                           
                        <div class="clearfix"> </div>
                    </ul>
                </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div> 	
</div>

<div class="general-form">
    <div class="container">
        <div class="col-md-12">
        	<h1 class="container-header">Dados de Entrega</h1>
        	<div class="general-form-top">
            	<div class="col-md-5">
        			<span><h3>Rua</h3></span>
        			<span><input type="text" name="rua" value="Rua Umuarama" /></span>
            	</div>
            	<div class="col-md-2 col-md-offset-1">
        			<span><h3>Número</h3></span>
        			<span><input type="text" name="numero" value="273" /></span>
            	</div>
				<div class="col-md-3 col-md-offset-1">
        			<span><h3>Bairro</h3></span>
        			<span><input type="text" name="bairro" value="Zona 08" /></span>
            	</div> 
            	
            	<div class="col-md-5">
        			<span><h3>Complemento</h3></span>
        			<span><input type="text" name="complemento" value="Sobrado Azul" /></span>
            	</div>
				<div class="col-md-2 col-md-offset-1">
        			<span><h3>Estado</h3></span>
        			<span><input type="text" name="estado" value="PR" /></span>
            	</div>	     	            	
            	<div class="col-md-3 col-md-offset-1">
        			<span><h3>Cidade</h3></span>
        			<span><input type="text" name="cidade" value="Maringá" /></span>
            	</div>       	 
            	
            	<div class="col-md-2">
            		<span><h3>Envio / Frete</h3></span>
            		<span>
            			<select name="envio">
            				<option value="0">Sedex</option>
            				<option value="1">Pac</option>
            			</select>
            		</span>
            	</div>            	         	
            	<div class="col-md-2">
            		<span><button style="margin-top: 41px; float:right">Calcular </button></span>
            	</div>
            	<div class="col-md-2">
            		<span>&nbsp;</span>
        			<span><input style="margin-top: 20px" type="text" name="frete" value="R$0,00" readonly="readonly" /></span>
            	</div>
            	
            	
	            <div class="clearfix"></div>
        	</div>
        </div>
       	<div class="clearfix"> </div>
    </div>
</div>

<div class="general-form">
    <div class="container">
        <div class="col-md-12">
        	<h1 class="container-header">Dados de Pagamento</h1>
        	<div class="general-form-top">        	
	           	<div class="col-md-5">
	       			<span><h3>Rua</h3></span> 
	       			<span><input type="text" name="rua" value="Rua Umuarama" /></span>
	           	</div>
	           	<div class="col-md-2 col-md-offset-1">
	       			<span><h3>Número</h3></span>
	       			<span><input type="text" name="numero" value="273" /></span>
	           	</div>
				<div class="col-md-3 col-md-offset-1">
	       			<span><h3>Bairro</h3></span>
	       			<span><input type="text" name="bairro" value="Zona 08" /></span>
	           	</div>         	
	           	<div class="clearfix"></div>
	        </div>
        </div>
        <div class="clearfix"></div>
    </div>
</div>

<jsp:include page="/view/user/partial/footer.jsp"/>