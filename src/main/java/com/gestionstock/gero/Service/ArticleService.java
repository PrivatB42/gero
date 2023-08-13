package com.gestionstock.gero.Service;

import com.gestionstock.gero.Other.ArticleNotFoundException;
import com.gestionstock.gero.Repository.ArticleRepository;
import com.gestionstock.gero.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    public ArticleRepository articleRepository;

    public void SaveArticle(Article article){
        articleRepository.save(article);
    }

    public List<Article> ListArticle(){
        return articleRepository.findAll();
    }

    public Article findbyId(Integer id){
        Optional<Article> article = articleRepository.findById(id);
        return article.get();
    }

    public void DeleteArticle(Integer id){
        articleRepository.deleteById(id);
    }

    public List<String> search(String keyword) {
        return articleRepository.search(keyword);
    }


}
