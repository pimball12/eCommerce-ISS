    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Main Footer -->
  <footer class="main-footer">
    <!-- To the right -->
    <div class="pull-right hidden-xs">
      Anything you want
    </div>
    <!-- Default to the left -->
    <strong>Copyright &copy; 2016 <a href="#">Company</a>.</strong> All rights reserved.
  </footer>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 2.2.3 -->
<script src="<%= request.getAttribute("base_url") %>/view/admin/assets/plugins/jQuery/jquery-2.2.3.min.js"></script>
<!-- Bootstrap 3.3.6 -->
<script src="<%= request.getAttribute("base_url") %>/view/admin/assets/bootstrap/js/bootstrap.min.js"></script>
<!-- AdminLTE App -->
<script src="<%= request.getAttribute("base_url") %>/view/admin/assets/dist/js/app.min.js"></script>
<!-- Url Base para uso no javascript -->
<script> var base_url = "<%= request.getAttribute("base_url") %>" </script>
<!-- Script geral -->
<script src="<%= request.getAttribute("base_url") %>/view/admin/assets/public/general.js"></script>
<!-- Scripts adicionais -->
<% if (request.getAttribute("scripts") != null) { %>
<% for(String script: (String[])request.getAttribute("scripts"))  { %>
  <script src="<%=  request.getAttribute("base_url")   %>/view/admin/assets/public/<%=script %>"></script>
<%}%>
<%}%>

</body>
</html>
