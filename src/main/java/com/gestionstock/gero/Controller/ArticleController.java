package com.gestionstock.gero.Controller;

import com.gestionstock.gero.Service.ArticleService;
import com.gestionstock.gero.Service.CategorieService;
import com.gestionstock.gero.entity.Article;
import com.gestionstock.gero.entity.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService service;

    @Autowired
    private CategorieService categorieService;

    private Article article =new Article();

    @GetMapping("/article")
    public String homme(Model model){
        List<Article> ListService = service.ListArticle();
        List<Categorie> ListCategorie = categorieService.listAll();
        model.addAttribute("article",new Article());
        model.addAttribute("ListService",ListService);
        model.addAttribute("Listcategorie",ListCategorie);
        return "Gestion_article";
    }

    @PostMapping("/article/save")
    public String savecategorie(Article article){
        System.out.println("Nouvel utilisateur ---------------------------- "+ article);
        service.SaveArticle(article);
        return "redirect:/article";
    }

    @GetMapping("/article/edit/{id}")
    public  String showEditForm(@PathVariable("id") Integer id){
        article = service.findbyId(id);
        System.out.println("Utilisateur recupered ---------------------------- "+ article);
        return "redirect:/editarticle";
    }

    @GetMapping("/article/delete/{id}")
    public  String deleteUser(@PathVariable("id") Integer id){
        service.DeleteArticle(id);
        return "redirect:/article";
    }

    @GetMapping("/editarticle")
    public  String articleeditpage(Model model){
        Article arti = article;
        List<Categorie> ListCategorie = categorieService.listAll();
        model.addAttribute("article", arti);
        model.addAttribute("Listcategorie",ListCategorie);
        return "Modif_article";
    }


}
