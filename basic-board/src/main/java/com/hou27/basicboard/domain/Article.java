package com.hou27.basicboard.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@ToString
@Table(indexes = {
    @Index(columnList = "createdAt"),
    @Index(columnList = "title")
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Article {
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
  @Column(nullable = false)
  private String title;

  @Setter
  @Column(nullable = false, length = 10000)
  private String content;

  @Setter
  private String tag;

  @OrderBy("createdAt DESC")
  @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
  @Exclude // do not include this field in the generated toString.
  private final Set<Comment> comments = new LinkedHashSet<>();

  /**
   * Constructor
   */
  protected Article() {
  }

  private Article(String title, String content, String tag) {
    this.title = title;
    this.content = content;
    this.tag = tag;
  }

  public static Article of(String title, String content, String tag) {
    return new Article(title, content, tag);
  }

  /**
   * equals, hashCode
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    // pattern variable로 코드 개선
//    if (!(o instanceof Article)) {
//      return false;
//    }
//    Article article = (Article) o;
    if (!(o instanceof Article article)) {
      return false;
    }
    
    return id != null && id.equals(article.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}
