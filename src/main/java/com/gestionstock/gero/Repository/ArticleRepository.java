package com.gestionstock.gero.Repository;

import com.gestionstock.gero.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query(value = "SELECT id_article, libelle_article FROM article where libelle_article like :keyword%", nativeQuery = true)
    List<String> search(@Param("keyword") String keyword);

}
