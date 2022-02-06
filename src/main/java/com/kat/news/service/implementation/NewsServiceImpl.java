package com.kat.news.service.implementation;

import com.kat.news.dto.ArticleDto;
import com.kat.news.model.Article;
import com.kat.news.model.News;
import com.kat.news.service.NewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    public static final String API_KEY = "1461e8f5556e4942a8ed7f2c5c30a50b";
    public static final String URL = "https://newsapi.org/v2/top-headlines?country=pl&category=business&apiKey=" + API_KEY;

    private RestTemplate restTemplate = new RestTemplate();

    public List<ArticleDto> getArticles(News news) throws IOException {
        List<ArticleDto> articleDtoList = getArticleDtos(news);
        createFile(articleDtoList);
        return articleDtoList;
    }

    private List<ArticleDto> getArticleDtos(News news) {
        news = getNews();
        List<ArticleDto> articleDtoList = new ArrayList<>();

        for (Article article: news.articles) {
            ArticleDto articleDto = ArticleDto.builder()
                    .title(article.title)
                    .description(article.description)
                    .author(article.author)
                    .build();
            log.info(articleDto.toString());
            articleDtoList.add(articleDto);
        }
        return articleDtoList;
    }

    private News getNews() {
        News news = restTemplate.getForObject(URL, News.class);
        return news;
    }

    private void createFile(List<ArticleDto> articleDtoList) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("articles.txt"));

        for (ArticleDto articleDto: articleDtoList) {
            writer.write(articleDto.toString() + "\n");
        }
        writer.close();
    }
}