package com.gbm.samples;

import java.io.Serializable;

public class Todo implements Serializable{

  private static final long serialVersionUID = 1L;


  public String id;
  public String name;
  public Boolean status;

  public Todo(){
    super();
  }

  public Todo(String id, String name, Boolean status){
    super();
    this.id = id;
    this.name = name;
    this.status = status;
    
  }

  public String getId(){
    return this.id;
  }

  public String getName(){
    return this.name;
  }

  public Boolean getStatus(){
    return this.status;
  }

  public void setName(String name){
    this.name = name; 
  }

  public void setStatus(Boolean status){
    this.status = status;
  }

}