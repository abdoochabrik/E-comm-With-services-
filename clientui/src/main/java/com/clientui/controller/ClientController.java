package com.clientui.controller;

import com.clientui.beans.ProductBean;
import com.clientui.proxies.MicroserviceProduitsProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {
    Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MicroserviceProduitsProxy ProduitsProxy;
    @RequestMapping("/")
    public String accueil(Model model){
        List<ProductBean> produits = ProduitsProxy.listeDesProduits();
        model.addAttribute("produits", produits);
        log.info("request sent from client");
        return "Accueil";

    }

    @RequestMapping("/details-produit/{id}")
    public String ficheProduit(@PathVariable int id, Model model){
        ProductBean produit = ProduitsProxy.recupererUnProduit(id);
        model.addAttribute("produit", produit);
        return "FicheProduit";
    }

}
