package com.hou27.basicboard.domain;

import java.time.LocalDateTime;

public class Comment {
  private int id;

  private LocalDateTime createdAt;

  private LocalDateTime modifiedAt;

  private int articleId;

  private int accountId;

  private String content;
}
