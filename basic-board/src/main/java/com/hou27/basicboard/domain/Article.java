package com.hou27.basicboard.domain;

import java.time.LocalDateTime;

public class Article {
  private int id;

  private LocalDateTime createdAt;

  private LocalDateTime modifiedAt;

  private String title;

  private String content;

  private int accountId;
}
