package com.gestionstock.gero.Controller;

import com.gestionstock.gero.Service.CategorieService;
import com.gestionstock.gero.entity.Categorie;
import com.gestionstock.gero.entity.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategorieController {

    @Autowired
    private CategorieService service;

    private Categorie categorie = new Categorie();

    @GetMapping("/categorie")
    public String homme(Model model, RedirectAttributes ra){
        List<Categorie> ListCategorie = service.listAll();
        model.addAttribute("categorie",new Categorie());
        model.addAttribute("Listcategorie",ListCategorie);
        return "Gestion_categorie";
    }

    @PostMapping("/categorie/save")
    public String savecategorie(Categorie categorie){
        System.out.println("Nouvel utilisateur ---------------------------- "+ categorie);
        service.Save(categorie);
        return "redirect:/categorie";
    }

    @GetMapping("/categorie/edit/{id}")
    public  String showEditForm(@PathVariable("id") Integer id){
        categorie = service.findById(id);
        System.out.println("Utilisateur recupered ---------------------------- "+ categorie);
        return "redirect:/editcategorie";
    }

    @GetMapping("/categorie/delete/{id}")
    public  String deleteUser(@PathVariable("id") Integer id){
        service.deleteById(id);
        return "redirect:/categorie";
    }

    @GetMapping("/editcategorie")
    public  String categorieditpage(Model model){
        Categorie cate = categorie;
        model.addAttribute("categorie", cate);
        return "Modif_categorie";
    }

}
