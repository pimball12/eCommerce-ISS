<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/user/partial/header.jsp"/>
<fmt:setLocale value="pt_BR"/>

<div class="back">
    <h2>Detalhes do Produto </h2>
</div> 

<div class="product">
    <div class="container">
        <!---->
        <div class="col-md-12 product-price1">
            <div class="col-md-5 single-top">
                <div class="flexslider ">
                    <ul class="slides">
                        <c:forEach items="${produto.getImagens()}" var="imagem">
							<li>
	                            <img class="zoom" src="${base_url}/adm/imagem/get?path=${imagem.getCaminho()}" />
	                        </li>                                    
                        </c:forEach>      
                    </ul>
                </div>
                <!-- FlexSlider -->
                <script defer src="${base_url}/view/user/assets/js/jquery.flexslider.js"></script>
                <link rel="stylesheet" href="${base_url}/view/user/assets/css/flexslider.css" type="text/css" media="screen" />
                <script>
                    // Can also be used with $(document).ready()
                    $(window).load(function() {
                      $('.flexslider').flexslider({
                        animation: "slide"
                      });
                    });
                </script>
            </div>
            <div class="col-md-7 single-top-in simpleCart_shelfItem">
                <div class="single-para ">
                    <h4>${produto.getNome()}</h4>
                    <p>${produto.getDescricao()}</p>
                    <h5 class="item_price"><fmt:formatNumber value="${produto.getPreco()}" type = "currency" /></h5>
                    <form action="${base_url}/produto/add" method="POST">
                    <div class="available" style="border-bottom: 1px solid #C4C3C3">
                        <ul>
                            <li>
                                Opções
                                <select name="estoque_id">
                                	<c:forEach items="${produto.getEstoquesOrdered()}" var="estoque">
                                	<c:if test="${estoque.getQuantidade() - estoque.getReservado() > 0 }">
                                	<option value="${estoque.getId()}">
										<c:forEach items="${estoque.getItensGrade()}" var="itemGrade">
                                    	|&nbsp;&nbsp;&nbsp;
										${String.format("%1$-20s", itemGrade.getGrade().getNome().concat(" : ").concat(itemGrade.getValor())).replace(' ', '&nbsp;')}
										</c:forEach>
										|
									</option> 
                                    </c:if>
                                    </c:forEach>  
                                </select>
                            </li>           
                            <div class="clearfix"> </div>
                        </ul>
                    </div>
                     
                    <button type="submit" class="add-cart">Adicionar ao Carrinho</button> 
                    </form>
                </div>
            </div>
            <div class="clearfix"> </div> 
            <!---->
        </div>
        <div class="clearfix"> </div>
    </div>
</div>	

<script type="text/javascript" src="${base_url}/view/user/assets/js/magnify.js"></script>
<script>
	$(function()	{
		$(".zoom").okzoom({
			width:	200,
			height:	200,
			scaleWidth: 800
		});
	});
</script>

<jsp:include page="/view/user/partial/footer.jsp"/>