package com.kamil.todo_manager.entity;

public class Todo {


    private Integer id;
    private String title;
    private String content;
    private String status;

    public Integer getId() {
        return id;
    }

    public Todo() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

  //  public Todo(int id, String title, String content, String status) {
     //   this.id = id;
      //  this.title = title;
      //  this.content = content;
       // this.status = status;
   // }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
