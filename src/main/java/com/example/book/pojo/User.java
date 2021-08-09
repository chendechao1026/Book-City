package com.example.book.pojo;

public class User {
  public Object save;
  private int id;
  private  String username;
  private  String password;
  private  String emial;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmial() {
    return emial;
  }

  public void setEmial(String emial) {
    this.emial = emial;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", username='" + username + '\'' +
      ", password='" + password + '\'' +
      ", emial='" + emial + '\'' +
      '}';
  }
public User(){
    
}
  public User(Integer o, String jc, String password, String emial) {
  }

  public User(int id, String username, String password, String emial) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.emial = emial;
  }
}
