package com.gestionstock.gero.Controller;

import com.gestionstock.gero.Service.ArticleService;
import com.gestionstock.gero.Service.CommandeFournisseurService;
import com.gestionstock.gero.Service.FournisseurService;
import com.gestionstock.gero.entity.Article;
import com.gestionstock.gero.entity.Categorie;
import com.gestionstock.gero.entity.CommandeFournisseur;
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
public class CommandeFournisseurController {

    @Autowired
    private CommandeFournisseurService service;
    @Autowired
    private ArticleService serviceA;
    @Autowired
    private FournisseurService serviceF;


    @GetMapping("/commandefournisseur")
    public String homeCF(Model model){

        List<CommandeFournisseur> ListCommande = service.listencours();
        List<Article> listArticle = serviceA.ListArticle();
        List<Fournisseur> listFournisseur = serviceF.listAll();

        model.addAttribute("commandefournisseur",new CommandeFournisseur());
        model.addAttribute("ListCommande",ListCommande);
        model.addAttribute("listArticle",listArticle);
        model.addAttribute("listFournisseur",listFournisseur);

        return "commande_fournisseur";
    }

    @GetMapping("/receptioncommande")
    public String homeec(Model model){

        List<CommandeFournisseur> ListCommande = service.listcommanderecu();
        List<Article> listArticle = serviceA.ListArticle();
        List<Fournisseur> listFournisseur = serviceF.listAll();

        //model.addAttribute("commandefournisseur",new CommandeFournisseur());
        model.addAttribute("ListCommande",ListCommande);
        model.addAttribute("listArticle",listArticle);
        model.addAttribute("listFournisseur",listFournisseur);

        return "reception_commande";
    }

    @PostMapping("/commandefournisseur/save")
    public String saveCommande(CommandeFournisseur commande){
        System.out.println("Nouvel utilisateur ---------------------------- "+ commande);
        commande.setEtat("En_cours");
        service.Savecommande(commande);
        return "redirect:/commandefournisseur";
    }

    @GetMapping("/commandefournisseur/edit/{id}")
    public  String showEditForm(@PathVariable("id") Integer id, Model model){
        CommandeFournisseur commande = service.findById(id);
        System.out.println("Utilisateur recupered ---------------------------- "+ commande);
        model.addAttribute("commande", commande);
        return "Modif_commande";

    }

    @GetMapping("/commandefournisseur/validate/{id}")
    public  String validateCf(@PathVariable("id") Integer id, Model model){
        CommandeFournisseur commande = service.findById(id);
        commande.setEtat("reçu");
        System.out.println("Utilisateur recupered ---------------------------- "+ commande);

        service.Savecommande(commande);
        /*List<CommandeFournisseur> ListCommande = service.listAll();
        List<Article> listArticle = serviceA.ListArticle();
        List<Fournisseur> listFournisseur = serviceF.listAll();

        //model.addAttribute("commandefournisseur",new CommandeFournisseur());

        model.addAttribute("ListCommande",ListCommande);
        model.addAttribute("listArticle",listArticle);
        model.addAttribute("listFournisseur",listFournisseur);*/

        //model.addAttribute("commande", commande);
        return "redirect:/receptioncommande";

    }

    @GetMapping("/commandefournisseur/delete/{id}")
    public  String deleteUser(@PathVariable("id") Integer id){

        service.deleteById(id);
        return "redirect:/commandefournisseur";

    }



}
