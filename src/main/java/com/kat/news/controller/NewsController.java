package com.kat.news.controller;

import com.kat.news.dto.ArticleDto;
import com.kat.news.model.News;
import com.kat.news.service.implementation.NewsServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping
public class NewsController {

    private NewsServiceImpl newsService;

    public NewsController(NewsServiceImpl newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/articles")
    public List<ArticleDto> getArticles(News news) throws IOException {
        return newsService.getArticles(news);
    }
}