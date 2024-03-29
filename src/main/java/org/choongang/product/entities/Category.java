package org.choongang.product.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.commons.entities.BaseMember;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(indexes = @Index(name = "idx_category_listOrder", columnList = "listOrder DESC, createdAt DESC"))
public class Category extends BaseMember {
  @Id //기본키
  @Column(length = 30)
  private String cateCd; //분류 코드

  @Column(length = 60, nullable = false)
  private String cateNm; // 분류 명

  private int listOrder; //진열 가중치

  private boolean active; //사용 여부

}
