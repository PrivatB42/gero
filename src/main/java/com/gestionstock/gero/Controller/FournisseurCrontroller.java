package com.gestionstock.gero.Controller;

import com.gestionstock.gero.Other.FournisseurNotFoundException;
import com.gestionstock.gero.Service.FournisseurService;
import com.gestionstock.gero.entity.Fournisseur;
import com.gestionstock.gero.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FournisseurCrontroller {

    @Autowired
    private FournisseurService service;

    private Fournisseur fournisseur = new Fournisseur();

    @GetMapping("/fournisseur")
    public String hommefour(Model model, RedirectAttributes ra){

        List<Fournisseur> ListFournisseur = service.listAll();

        model.addAttribute("fournisseur",new Fournisseur());
        model.addAttribute("ListFournisseur",ListFournisseur);

       /* try{
            List listvide = new ArrayList();
            listvide.add("");

            if(ListFournisseur == null){
                ListFournisseur = listvide;
            }

        }catch (FournisseurNotFoundException e){
            ra.addFlashAttribute("message", e.getMessage());
        }*/

        return "Gestion_fournisseur";
    }

    @PostMapping("/fournisseur/save")
    public String saveFournisseur(Fournisseur fournisseur){
        System.out.println("Nouvel utilisateur ---------------------------- "+ fournisseur);
        service.Savefournsseur(fournisseur);
        //ra.addFlashAttribute("message", "the user has been save successfuly.");
        return "redirect:/fournisseur";
    }

    @GetMapping("/fournisseur/edit/{id}")
    public  String showEditForm(@PathVariable("id") Integer id){
        fournisseur = service.findById(id);
        System.out.println("Utilisateur recupered ---------------------------- "+ fournisseur);
        return "redirect:/editfournisseur";
    }

    @GetMapping("/fournisseur/delete/{id}")
    public  String deleteUser(@PathVariable("id") Integer id){
        service.deleteById(id);
        return "redirect:/fournisseur";
    }

    @GetMapping("/editfournisseur")
    public  String modiffournisseur(Model model){
        Fournisseur fournc = fournisseur;
        model.addAttribute("fournisseur", fournc);
        return "Modif_fournisseur";
    }

}
