package com.gbm.samples;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("todos")
public class TodoService{
  private static List<Todo> todos = new ArrayList<Todo>();

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getUsers(){
    return Response.ok(todos).build();
  }

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response create(Todo todo){
    todo.id = UUID.randomUUID().toString();
    this.todos.add(todo);
    return Response.ok().build();
  }

  @PUT
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response update(Todo todo){
    Todo found = null;
    for(Todo items:this.todos){
      if(todo.id.equals(items.id)){
        found = items;
      }
    }

    if(found == null){
      return Response.status(Status.NOT_FOUND).build();
    }
    else{
      found.setStatus(todo.status);
      return Response.ok(found).build();
    }
  }
}