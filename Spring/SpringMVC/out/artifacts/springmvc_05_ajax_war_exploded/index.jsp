<%--
  Created by IntelliJ IDEA.
  User: LYL
  Date: 2021/7/16
  Time: 10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.6.0.js"></script>
    <script>
        function a() {
          $.post({
            url:"${pageContext.request.contextPath}/a1",
            data:{"name":$("#username").val()},
            success:function (data) {
                  alert(data);
            }
          })
        }
    </script>
  </head>
  <body>
  <input type="text" id="username" onblur="a()"/>
  </body>
</html>
