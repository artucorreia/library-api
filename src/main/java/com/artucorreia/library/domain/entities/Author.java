package com.artucorreia.library.domain.entities;

import java.util.List;
import java.util.Objects;

public class Author {
  private Long id;
  private String name;
  private List<Book> books;

  public Author() {}

  public Author(Long id, String name, List<Book> books) {
    this.id = id;
    this.name = name;
    this.books = books;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
    Author author = (Author) o;
    return Objects.equals(id, author.id)
        && Objects.equals(name, author.name)
        && Objects.equals(books, author.books);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, books);
  }
}
