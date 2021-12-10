package com.clientui.proxies;
import com.clientui.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "GATEWAY-SERVER", url = "localhost:9004")
public interface MicroserviceProduitsProxy {
    @GetMapping(value = "/MICROSERVICE-PRODUITS/Produits")
    List<ProductBean> listeDesProduits();
    @GetMapping( value = "/MICROSERVICE-PRODUITS/Produits/{id}")
    ProductBean recupererUnProduit(@PathVariable("id") int id);
}
