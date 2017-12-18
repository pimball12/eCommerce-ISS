<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/user/partial/header.jsp"/>

<div class="row" >
	<div class="col-md-12">
		<div class="nav-tabs-custom">
			<div class="back">
			    <h2>REGISTRO</h2>
			</div>
			<div class="container">
			    <div class="register">
			        <h3>INFORMACOES PESSOAIS</h3>
			        <form action="${base_url}/user/post" method="POST">
			            <div class="mation">
			                <div>
			                    <span>Nome</span>
			                    <input type="text" name="nome" required>
			                </div>
			                <div>
			                    <span>Sobrenome</span>
			                    <input type="text" name="sobrenome" required> 
			                </div>
			                <div>
			                    <span>CPF</span>
			                    <input type="text" name="cpf" required> 
			                </div>
			                <div>
			                    <span>Telefone</span>
			                    <input type="text" name="telefone" required>
			                </div>
			                <div>
			                    <span>E-Mail</span>
			                    <input type="text" name="email" required>
			                </div>
			                <div>
			                    <span>Senha</span>
			                    <input type="password" name="senha" required>						 
			                </div>
			                <div>
			                    <span>Repetir Senha</span>
			                    <input type="password" name="senha2" required>						 
			                </div>
			                
			                <h3>ENDERECO</h3>
							<div>
			                    <span>CEP</span>
			                    <input type="text" name="cep" required> 
			                </div>
			                <div>
			                    <span>Cidade</span>
			                    <input type="text" name="cidade" required> 
			                </div>
			                <div>
			                    <span>Estado</span>
			                    <input type="text" name="estado" required> 
			                </div>
			                <div>
			                    <span>Rua</span>
			                    <input type="text" name="rua" required> 
			                </div>
			                <div>
			                    <span>Numero</span>
			                    <input type="text" name="numero" required> 
			                </div>
			                <div>
			                    <span>Complemento</span>
			                    <input type="text" name="complemento" required> 
			                </div>
			                <div>
			                    <span>Bairro</span>
			                    <input type="text" name="bairro" required> 
			                </div>
			            </div>
			            <input type="submit" value="Cadastrar">
			        </form>
			    </div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/view/admin/partial/footer.jsp"/>