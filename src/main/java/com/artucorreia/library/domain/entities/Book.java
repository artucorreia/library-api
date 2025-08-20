package com.artucorreia.library.domain.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Book {
  private Long id;
  private String title;
  private String content;
  private LocalDateTime date;
  private Category category;
  private Author author;

  public Book() {}

  public Book(
      Long id,
      String title,
      String content,
      LocalDateTime date,
      Category category,
      Author author) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.date = date;
    this.category = category;
    this.author = author;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Book book = (Book) o;
    return Objects.equals(id, book.id)
        && Objects.equals(title, book.title)
        && Objects.equals(content, book.content)
        && Objects.equals(date, book.date)
        && Objects.equals(category, book.category)
        && Objects.equals(author, book.author);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, content, date, category, author);
  }
}
