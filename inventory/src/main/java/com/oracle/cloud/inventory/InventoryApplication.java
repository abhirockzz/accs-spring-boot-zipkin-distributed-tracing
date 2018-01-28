package com.oracle.cloud.inventory;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class InventoryApplication {
    private static final Logger LOG = Logger.getLogger(InventoryApplication.class.getName());

   
    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);

    }


    @RequestMapping(value = "/inventory/{item}", method = RequestMethod.GET, produces = {"application/json"})
    @ResponseBody
    public InventoryInfo getInventory(@PathVariable("item") String item) {
        LOG.log(Level.INFO, "Fetching inventory for item {0}", item);
        return new InventoryInfo(new Random().nextInt(10) + 1);
    }
}
