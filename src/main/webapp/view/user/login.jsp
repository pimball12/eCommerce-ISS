<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/view/user/partial/header.jsp"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Acesso</title>
    </head>
    <body>
        <div class="back">
            <h2>Login</h2>
        </div>
        <div class="container">
            <div class="account_grid">
                <div class=" login-right">
                    <h3>Usuario</h3>
                    <form action="${base_url}/user/auth" method="POST">
                        <div>
                            <span>Usuario</span>
                            <input type="text" name="login" required> 
                        </div>
                        <div>
                            <span>Senha</span>
                            <input type="password" name="senha" required> 
                        </div>
                        <a class="forgot" href="#">Esqueci minha senha!</a>
                        <input type="submit" value="Logar">
                    </form>
                </div>
                <div class=" login-left">
                    <h3>Novo Cliente?</h3>
                    <a class="acount-btn" href="${base_url}/user/create">Criar conta!</a>
                </div>
            </div>
        </div>
    </body>
</html>