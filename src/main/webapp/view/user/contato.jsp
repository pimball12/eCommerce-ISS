<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/user/partial/header.jsp"/>
<fmt:setLocale value="pt_BR"/>

<div class="back">
    <h2>Contato </h2>
</div> 

<div class="contact">
    <div class="container">
        <div class="col-md-12">
        	<div class="contact-top">
	            <form action="mailto:${email}">
	                <div>
	                	<span>Nome</span>
	                	<span><input name="nome" type="text"></span>
	                </div>
	                <div>
	                	<span>Email</span>
	                	<span><input name="email" type="text"></span>
	                </div>
					<div>
	                	<span>Telefone</span>
	                	<span><input name="telefone" type="text"></span>
	                </div>
	                <div>
	                	<span>Mensagem</span>
	                	<textarea cols="77" rows="6"></textarea>
	                </div>
	
	                
	                <input value="Mandar Mensagem" type="submit">
	            </form>        	
        	</div>
        </div>
        <div class="clearfix"> </div>
        <p class="footer-class">Copyrights © 2015 I Wear. All rights reserved | Design by <a href="http://w3layouts.com/">W3layouts</a></p>
    </div>
</div>





<jsp:include page="/view/user/partial/footer.jsp"/>