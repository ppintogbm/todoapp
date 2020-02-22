package com.gbm.samples;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/TodoServlet")
public class TodoServlet extends HttpServlet{
  
  private static final long serialVersionUID = 1L;
  private static List<Todo> todos = new ArrayList<Todo>();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("todoList", todos);
    req.getRequestDispatcher("todo.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    todos.add(new Todo(UUID.randomUUID().toString(),req.getParameter("name").toString(),false));
    resp.sendRedirect("TodoServlet");
  }

}