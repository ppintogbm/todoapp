<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
  <head>
    <title>
      TODO's
    </title>
    <script src="webjars/jquery/3.4.1/jquery.min.js" type="text/javascript"></script>
    <link href="webjars/bootstrap/4.4.1-1/css/bootstrap.css" rel="stylesheet">
    <script src="webjars/bootstrap/4.4.1-1/js/bootstrap.min.js" type="text/javascript"></script>
  </head>
<body>
  <body>
    <div class="container-md">
      <h1>Todo's</h1>
      <ul id="todolist" class="list-group">
        <c:forEach items="${todoList}" var="todo">
          <li class="list-group-item">${todo.getName()}</li>
        </c:forEach>
        <li id="new-todo" class="list-group-item">
          <form action="${pageContext.request.contextPath}/TodoServlet" method="POST">
            <input type="hidden" name="status" value="false"/>
            <input type="text" name="name" placeholder="New Task" />
            <button class="btn btn-primary" type="submit">Crear</button>
          </form>
        </li>
      </ul>
    </div>
  </body>
</body>
</html>
