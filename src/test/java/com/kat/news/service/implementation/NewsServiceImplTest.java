package com.kat.news.service.implementation;

import com.kat.news.model.Article;
import com.kat.news.model.News;
import com.kat.news.service.NewsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NewsServiceImplTest {

    @Autowired
    private NewsService newsService;

    @Mock
    private News news;

    @Test
    void testShouldGetAllArticlesAndCreateFile () throws IOException {
        createNews();
        newsService.getArticles(news);

    }

    private News createNews(){
        return News.builder()
                .articles(createArticleList())
                .build();

    }

    private List<Article> createArticleList(){
        List<Article> articleList = new ArrayList<>();
        articleList.add(createArticle("1", "1", "1"));
        articleList.add(createArticle("2", "2", "2"));
        articleList.add(createArticle("3", "3", "3"));
        articleList.add(createArticle("4", "4", "4"));
        articleList.add(createArticle("5", "5", "5"));
        return articleList;
    }

    private Article createArticle (String title, String description, String author){
        return Article.builder()
                .title(title)
                .description(description)
                .author(author)
                .build();
    }
}