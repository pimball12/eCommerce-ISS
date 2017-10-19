<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>${page_title} :: ${page_description}   </title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.6 -->
  <link rel="stylesheet" href="<%= request.getAttribute("base_url") %>/view/admin/assets/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="<%= request.getAttribute("base_url") %>/view/admin/assets/plugins/Font-Awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="<%= request.getAttribute("base_url") %>/view/admin/assets/plugins/ionicons/css/ionicons.min.css">
  
  <!-- Styles adicionais -->
  <% if (request.getAttribute("styles") != null) { %>
  <% for(String style: (String[])request.getAttribute("styles"))	{ %> 
    <link rel="stylesheet" href="<%=  request.getAttribute("base_url")  %>/view/admin/assets/<%= style %>">
  <%}%>
  <%}%>

  <!-- Theme style -->
  <link rel="stylesheet" href="<%= request.getAttribute("base_url") %>/view/admin/assets/dist/css/AdminLTE.min.css">
  <!-- AdminLTE Skins. -->
  <link rel="stylesheet" href="<%= request.getAttribute("base_url") %>/view/admin/assets/dist/css/skins/skin-black-light.min.css">
  <!-- Style Geral -->
  <link rel="stylesheet" href="<%= request.getAttribute("base_url") %>/view/admin/assets/public/general.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>

<body class="hold-transition skin-black-light sidebar-mini <%= request.getAttribute("sidebar_collapse") %>">

<div class="wrapper">
  <!-- Main Header -->
  <header class="main-header">

    <!-- Logo -->
    <a href="<%= request.getAttribute("base_url") %>" class="logo">
      <!-- mini logo for sidebar mini 50x50 pixels -->
      <span class="logo-mini"><b>B</b>S</span>
      <!-- logo for regular state and mobile devices -->
      <span class="logo-lg"><b>Barata</b>Shop</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
      <!-- Sidebar toggle button-->
      <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
        <span class="sr-only">Toggle navigation</span>
      </a>
      <!-- Navbar Right Menu -->
      <div class="navbar-custom-menu">
        <ul class="nav navbar-nav">
          <!-- User Account Menu -->
          <li class="dropdown user user-menu">
            <!-- Menu Toggle Button -->
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <!-- The user image in the navbar-->
              <img src="<%= request.getAttribute("base_url") %>/view/admin/assets/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">
              <!-- hidden-xs hides the username on small devices so only the image appears. -->
              <span class="hidden-xs">Renato <!--TODO: Adicionar aqui nome de usuário logado. --></span>
            </a>
            <ul class="dropdown-menu">
              <!-- The user image in the menu -->
              <li class="user-header">
                <img src="<%= request.getAttribute("base_url") %>/view/admin/assets/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                <p>
                  <!--TODO: Adicinar aqui nome de usuário logado -->
                  <small>Renato</small>
                </p>
              </li>
              <!-- Menu Footer-->
              <li class="user-footer">
                <div class="pull-left">
                  <a href="#" class="btn btn-default btn-flat">Perfil</a>
                </div>
                <div class="pull-right">
                  <!--TODO: Adicionar aqui link para deslogamento de usuário -->
                  <a href="<%= request.getAttribute("base_url") %>" class="btn btn-default btn-flat">Sair</a>
                </div>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </nav>
  </header>
  <!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

      <!-- Sidebar Menu -->
      <ul class="sidebar-menu">
        <li class="header">MENU</li>
        <!-- Optionally, you can add icons to the links -->
        <!-- TODO: Adicionar mecanismo para definir se a treeview vai estar aberta ou não -->
        <li><a href="<%= request.getAttribute("base_url") %>/adm/grade"><i class="fa  fa-sliders"></i> <span>Grades</span></a></li>
        <li><a href="<%= request.getAttribute("base_url") %>/adm/produto"><i class="fa fa-soccer-ball-o"></i> <span>Produtos</span></a></li>
        
      </ul>
      <!-- /.sidebar-menu -->
    </section> 
    <!-- /.sidebar -->
  </aside>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    
    <!-- Aviso -->
    <% if (request.getAttribute("flash_message") != null) { %>
    <div class="row">
      <div class="col-md-12">
        <div class="alert ${flash_message_kind} alert-dismissible">
          <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
          <h4><i class="icon fa ${flash_message_icon}"></i> Aviso</h4>
          ${flash_message_text}
        </div>
      </div>
    </div>
    <% } %>         
    
    <section class="content-header">   
      <h1>
        ${page_title}
        <small>${page_description}</small>
      </h1>
      <!-- TODO: Adicionar breadcump se for mostrado necessário. -->
    </section>

    <!-- Main content -->
    <section class="content">