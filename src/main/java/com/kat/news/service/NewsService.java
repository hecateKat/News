package com.kat.news.service;

import com.kat.news.dto.ArticleDto;
import com.kat.news.model.News;

import java.io.IOException;
import java.util.List;

public interface NewsService {

    public List<ArticleDto> getArticles(News news) throws IOException;
}
