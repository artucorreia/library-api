package com.artucorreia.library.infra.persistence.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authors")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class AuthorEntity extends BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length = 50, unique = true)
  private String name;
  //    private List<Book> books;
}
