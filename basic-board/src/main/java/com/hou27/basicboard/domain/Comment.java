package com.hou27.basicboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@Table(indexes = {
    @Index(columnList = "createdAt"),
    @Index(columnList = "content")
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreatedDate
  @Column(nullable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(nullable = false)
  private LocalDateTime modifiedAt;

  @Setter
  @Column(nullable = false, length = 500)
  private String content;

  @Setter
  @ManyToOne(optional = false) // no cascade
  private Article article;

  /**
   * Constructor
   */
//  protected Comment() {
//  }

  private Comment(String content, Article article) {
    this.content = content;
    this.article = article;
  }

  public static Comment of(String content, Article article) {
    return new Comment(content, article);
  }

  /**
   * equals, hashCode
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Comment comment)) {
      return false;
    }

    return id != null && id.equals(comment.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
