package com.kat.news.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {

    private String title;

    private String description;

    private String author;

    @Override
    public String toString() {
        return title + ":"
                + description + ":"
                + author;
    }
}