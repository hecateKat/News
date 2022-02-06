package com.kat.news.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {

    public Source source;
    public String author;
    public String title;
    public String description;
    public String url;
    public String urlToImage;
    public Date publishedAt;
    public String content;
}