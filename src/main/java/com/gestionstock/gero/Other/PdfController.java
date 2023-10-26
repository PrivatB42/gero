package com.gestionstock.gero.Other;

import com.gestionstock.gero.Service.VenteService;
import com.gestionstock.gero.entity.Vente;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class PdfController {

    @Autowired
    private VenteService service;

    @GetMapping("/pdf/vente")
    public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {

        response.setContentType("application/pdf");
        String currentDateTime = ZonedDateTime.now(ZoneId.of("Africa/Abidjan"))
                .format(DateTimeFormatter.ofPattern("MM.dd.yyy hh.mm.ss"));
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);

        List<Vente> ventelist = service.AffichVente();

        Pdfserice generator = new Pdfserice();
        generator.setVenteList(ventelist);
        generator.generate(response);

    }
}