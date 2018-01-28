package com.oracle.cloud.product;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ProductService {

    private static final Logger LOG = Logger.getLogger(ProductService.class.getName());
    
    String INVENTORY_SERVICE = System.getenv().getOrDefault("INVENTORY_SERVICE", "http://localhost:8080");
    
    
    @Autowired
    private RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(ProductService.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/product/{name}", produces = "application/json")
    @ResponseBody
    public ProductInfo info(@PathVariable("name") String name) {

        LOG.log(Level.INFO, "Looking for product {0}", name);
        LOG.log(Level.INFO, "Invoking Inventory Service {0}", INVENTORY_SERVICE);
        InventoryInfo inventory = restTemplate.getForObject(INVENTORY_SERVICE+"/inventory/"+name, InventoryInfo.class);
        return new ProductInfo(name, inventory);
    }
}
