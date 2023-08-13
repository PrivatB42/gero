package com.gestionstock.gero.Controller;

import com.gestionstock.gero.Service.RoleService;
import com.gestionstock.gero.Service.UtilisateurService;
import com.gestionstock.gero.entity.Role;
import com.gestionstock.gero.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    private Utilisateur utilisateur = new Utilisateur();

    @PostMapping("/utilistateur/save")
    public String saveUtilisateur(Utilisateur utilisateur){
        System.out.println("Nouvel utilisateur ---------------------------- "+ utilisateur);
        utilisateurService.SaveUtilisateur(utilisateur);
        //ra.addFlashAttribute("message", "the user has been save successfuly.");
        return "redirect:/utilisateur";
    }

    @GetMapping("/utilisateur")
    public String showUserList(Model model){
        List<Utilisateur> listUsers = utilisateurService.findAll();
        model.addAttribute("utilisateur",new Utilisateur());
        model.addAttribute("listUsers", listUsers);

        return "Gestion_utilisateur";
    }

    @GetMapping("/utilisateur/edit/{id}")
    public  String showEditForm(@PathVariable("id") Integer id){
        utilisateur = utilisateurService.findById(id);
        System.out.println("Utilisateur recupered ---------------------------- "+ utilisateur);
        return "redirect:/modif";
    }



    @GetMapping("/utilisateur/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        utilisateurService.deleteById(id);
        return "redirect:/utilisateur";
    }

    @GetMapping("/modif")
    public String affichemodifpage(Model model) {
        Utilisateur user = utilisateur;
        model.addAttribute("utilisateur",user);
        return "Modif_utilisateur";
    }



}
