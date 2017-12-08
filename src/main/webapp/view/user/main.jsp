<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/user/partial/header.jsp"/>

<!--start-shoes--> 
<div class="goggles"> 
	<div class="container"> 
	
		<h2>Conheça Nossos Produtos!</h2>
		
		<c:set var="counter" value="0"/>
		<c:forEach var="produto" items="${produtos}">
			
			<c:if test="${counter == 0}">
				<div class="product-one">
			</c:if>			
			
			<div class="col-md-3 product-left"> 
				<div class="p-one simpleCart_shelfItem">							
						<a href="${base_url}/produto?id=${produto.getId()}">
							<img style="width:100%" src="${base_url}/adm/imagem/get?path=${produto.getImagens().size() > 0 ? produto.getImagens().toArray()[0].getCaminho() : ''}" alt="" />
							<div class="mask"> 
								<span>Ver Produto</span>
							</div>
						</a>
					<h4>${produto.getNome()}</h4>
					<p><a class="item_add" href="${base_url}/produto?id=${produto.getId()}"><i></i> <span class=" item_price"><fmt:formatNumber value="${produto.getPreco()}" type = "currency" /></span></a></p>
				
				</div>
			</div>		
			
			<c:set var="counter" value="${counter + 1}"/>
			<c:if test="${counter == 4}">
				<c:set var="counter" value="0"/>
				<div class="clearfix"> </div>
				</div>
			</c:if>
			
		</c:forEach>
		<c:if test="${counter != 4}">
			<c:set var="counter" value="0"/>
			<div class="clearfix"> </div>
			</div>
		</c:if>		
		
	</div>
</div>

<jsp:include page="/view/user/partial/footer.jsp"/>