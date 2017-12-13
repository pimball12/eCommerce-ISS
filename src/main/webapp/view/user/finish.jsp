<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/user/partial/header.jsp"/>
<fmt:setLocale value="pt_BR"/>

<div class="back">
    <h2> Fechar Pedido </h2>
</div> 

<div class="general-form">
    <div class="container">
        <div class="col-md-12">
        	<div class="general-form-top">
	            <form action="mailto:${email}">
	            	<h3>Meus Dados</h3> 
	                <div class="col-md-6">
	                	<span>Nome</span>
	                	<span><input name="nome" type="text"></span>
	                </div>
	                <div class="col-md-6"> 
	                	<span>Email</span>
	                	<span><input name="email" type="text"></span>
	                </div>
					<div>
	                	<span>Telefone</span>
	                	<span><input name="telefone" type="text"></span>
	                </div>
	
	                <a>Mandar Mensagem</a>
	            </form>        	
        	</div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<jsp:include page="/view/user/partial/footer.jsp"/>