<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/user/partial/header.jsp"/>
<fmt:setLocale value="pt_BR"/>

<div class="back">
	<h2> Meu Carrinho </h2>
</div>

<div class="product">
    <div class="container">
        <!---->
        <div class="col-md-12 product-price1">
            <div class="check-out">
                <div class=" cart-items">
                    <div class="in-check">
                        <ul class="unit">
                            <li><span>Item</span></li>
                            <li><span>Produto </span></li>
                            <li><span>Preço</span></li>
                            <li><span>Quantidade</span></li>
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
                            <li><span>
                            	${item.getProduto().getNome()}   
                            	<c:set var="itensGrade" value="${itemGradeDAO.listByEstoque(item.getId())}"></c:set>
                            	<c:forEach var="itemGrade" items="${itensGrade}">
                            	 ; ${itemGrade.getGrade().getNome()}:${itemGrade.getValor()}
                            	</c:forEach>
                            </span></li>
                            <li><span><fmt:formatNumber value="${item.getProduto().getPreco()}" type = "currency" /></span></li>
                            <li><span>1 <!-- Modificar --></span></li>
                            <div class="clearfix"> </div>
                        </ul> 						
						</c:forEach>
                    </div>
                    <ul class="unit">
                        <li><span>Quantidade: ${cart_quant}</span></li>
                        <li><span>Total: <fmt:formatNumber value="${cart_total}" type = "currency" /></span></li>                        
                        <li><span></span></li>
                        <li><span></span></li>
                        <li><a class="btn-cart-submit" />FECHAR PEDIDO</a></li>
                        <div class="clearfix"> </div>
                    </ul>
                </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div> 	
</div>

<jsp:include page="/view/user/partial/footer.jsp"/>