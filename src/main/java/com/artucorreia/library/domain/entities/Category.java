package com.artucorreia.library.domain.entities;

import java.util.List;
import java.util.Objects;

public class Category {
  private Integer id;
  private String name;
  private List<Book> books;

  public Category() {}

  public Category(Integer id, String name, List<Book> books) {
    this.id = id;
    this.name = name;
    this.books = books;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Category category = (Category) o;
    return Objects.equals(id, category.id)
        && Objects.equals(name, category.name)
        && Objects.equals(books, category.books);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, books);
  }
}
