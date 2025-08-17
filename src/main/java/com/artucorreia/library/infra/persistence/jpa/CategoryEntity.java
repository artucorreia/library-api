package com.artucorreia.library.infra.persistence.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class CategoryEntity extends BaseEntity {
  private Integer id;
  private String name;
  //    private List<Book> books;
}
