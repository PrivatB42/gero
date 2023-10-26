package com.gestionstock.gero.Controller;

import com.gestionstock.gero.Service.ArticleService;
import com.gestionstock.gero.Service.LigneVenteService;
import com.gestionstock.gero.Service.VenteService;
import com.gestionstock.gero.entity.Article;
import com.gestionstock.gero.entity.LigneVente;
import com.gestionstock.gero.entity.Vente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VenteController {


    @Autowired
    private VenteService service;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LigneVenteService ligneVenteService;
    private List<LigneVente> listlv = new ArrayList<LigneVente>();
    private List<LigneVente> ligneVenteList = new ArrayList<>();
    private int totalph = 0, idp = 1;
    private int totalvs;
    private List<LigneVente> tablevs = new ArrayList<>();

    @GetMapping("/caisse")
    public String caisse(Model model){

        List<Article> articleList = articleService.ListArticle();
        model.addAttribute("ligneVente", new LigneVente());
        model.addAttribute("articles", articleList);
        model.addAttribute("listlv", listlv);
        model.addAttribute("totalph", totalph);

        return "caisse";
    }

    @PostMapping("/ligne/add")
    public String addLigne(LigneVente ligneVente){

        int pdv, qtev, price, valeur_de_retour = 0;
        LigneVente ligne = new LigneVente();
        totalph = 0;

        ligneVente.setIDlc(idp);

        pdv = ligneVente.getIdarticlelc().getPrixVente();
        qtev = ligneVente.getQte();
        price = qtev * pdv;
        ligneVente.setIDlc(idp);
        //totalph =  totalph + price;
        ligneVente.setPrixHtlc(price);

        if (!listlv.isEmpty()){

            for (LigneVente vente : listlv) {

                int idlv = ligneVente.getIdarticlelc().getIdArticle();
                int idllv = vente.getIdarticlelc().getIdArticle();

                if (idllv == idlv) {
                    ligne = vente;
                    System.out.println("l'article a ete trouve");
                    valeur_de_retour = 1;
                }
            }

            if ( valeur_de_retour == 1 ){

                ligne.setQte(ligneVente.getQte());
                pdv = ligne.getIdarticlelc().getPrixVente();
                qtev = ligne.getQte();
                price = qtev * pdv;
                //totalph =  totalph + price;
                ligne.setPrixHtlc(price);

            }
            if (valeur_de_retour == 0) {
                listlv.add(ligneVente);
            }

        }else {
            listlv.add(ligneVente);
        }
        idp += 1;

        for (LigneVente lc : listlv){
            totalph += lc.getPrixHtlc();
        }

        System.out.println("listv de la methode add = ========||||||||||||||| == ======= == == = "+listlv);

        return "redirect:/caisse";
    }

    @PostMapping("/vente/save")
    public String Savevente(){

        String timestamp = ZonedDateTime.now(ZoneId.of("Africa/Abidjan"))
                .format(DateTimeFormatter.ofPattern("MM.dd.yyy, hh.mm.ss"));

        Vente ventep =  new Vente();
        ventep.setCreatedDate(timestamp);
        ventep.setModifiedDate(timestamp);
        ventep.setTotalprix(totalph);
        Vente vente = service.SaveVente(ventep);
        System.out.println("vente =========================================== "+vente);
        System.out.println("listv = ========||||||||||||||| == ======= == == = "+listlv);

        int idpf = vente.getIdVente();

        for (LigneVente lv : listlv )
        {
            lv.setIDlc(0);

            int qtev = lv.getQte();
            int idarticle = lv.getIdarticlelc().getIdArticle();
            Article article = articleService.findbyId(idarticle);
            article.setStock(lv.getIdarticlelc().getStock() - qtev);
            articleService.SaveArticle(article);
            lv.setIdventelc(vente);
            ligneVenteService.SaveLV(lv);
            System.out.println("ligne vente  = ======== == ======= == == = "+lv);
        }

        listlv.clear();
        totalph = 0;

        return "redirect:/caisse";
    }


    @GetMapping("/suspendrevente")
    public String suspendrevente(Model model) {

        tablevs = listlv;
        totalvs = totalph;

        return "redirect:/caisse";
    }


    @GetMapping("/ventesuspendue")
    public String ventesuspendue(Model model) {

        model.addAttribute("listlv", tablevs );
        model.addAttribute("totalph", totalvs);

        return "vente_suspendue";
    }

    @GetMapping("/venterecuperee")
    public String venterecup() {

        listlv = tablevs;
        totalph = totalvs;


        return "redirect:/caisse";
    }

    @GetMapping("/autocomplete")
    @ResponseBody
    public List<String> searchkey(@RequestParam(value = "term", required = false, defaultValue = "") String term){
        List<String> articles = articleService.search(term);
        System.out.println("ttttttttttttttttttttttttttttttttttttt ::::::::: "+ articles);

        return articles;
    }


    @GetMapping("/listevente")
    public String listevente(Model model){

        List<Vente> listvente = service.AffichVente() ;
        model.addAttribute("listvente", listvente);

        return "listevente";
    }

    @GetMapping("/listevente/lignevente/{id}")
    public String afficheLvente(@PathVariable("id") Integer id, Model model) {

        try {
            Vente vente = service.VenteParID(id);
            System.out.println("La vente recuperée par id------- "+ vente);
            ligneVenteList = ligneVenteService.ListelvByVenteID(vente);
            System.out.println("liste des Lignes vente : "+ ligneVenteList);
            model.addAttribute("ligneVenteList", ligneVenteList);

            return "redirect:/listearticlevendu";
        }catch (Exception e){
            e.printStackTrace();

            return "redirect:/listevente";
        }
    }

    @GetMapping("/listearticlevendu")
    public String afficheLvrai(Model model) {

        System.out.println("liste des Lignes vente : "+ ligneVenteList);
        model.addAttribute("ligneVenteList", ligneVenteList);

        return "listelignevente";

    }





}
