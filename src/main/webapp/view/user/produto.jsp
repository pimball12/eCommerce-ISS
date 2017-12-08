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
                <div class="flexslider">
                    <ul class="slides">
                        <c:forEach items="${produto.getImagens()}" var="imagem">
							<li>
	                            <img src="${base_url}/adm/imagem/get?path=${imagem.getCaminho()}" />
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
                    <div class="star-on">
                        <ul class="star-footer">
                            <li><a href="#"><i> </i></a></li>
                            <li><a href="#"><i> </i></a></li>
                            <li><a href="#"><i> </i></a></li>
                            <li><a href="#"><i> </i></a></li>
                            <li><a href="#"><i> </i></a></li>
                        </ul>
                        <div class="review">
                            <a href="#"> 1 customer review </a>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                    <h5 class="item_price"><fmt:formatNumber value="${produto.getPreco()}" type = "currency" /></h5>
                    <div class="available" style="border-bottom: 1px solid #C4C3C3">
                        <ul>
                            <li class="size-in">
                                Color
                                <select>
                                    <option>Silver</option>
                                    <option>Black</option>
                                    <option>Dark Black</option>
                                    <option>Red</option>
                                </select>
                            </li>
                            <li class="size-in">
                                Size
                                <select>
                                    <option>Large</option>
                                    <option>Medium</option>
                                    <option>small</option>
                                    <option>Large</option>
                                    <option>small</option>
                                </select>
                            </li>
                            <li class="size-in">
                                Size
                                <select>
                                    <option>Large</option>
                                    <option>Medium</option>
                                    <option>small</option>
                                    <option>Large</option>
                                    <option>small</option>
                                </select>
                            </li>                            
                            <div class="clearfix"> </div>
                        </ul>
                    </div>
                    
                    <a href="#" class="add-cart item_add">ADD TO CART</a>
                </div>
            </div>
            <div class="clearfix"> </div>
            <!---->
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<jsp:include page="/view/user/partial/footer.jsp"/>