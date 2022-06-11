package com.amit.demo.web;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/template")
public class ConsumeWebService {
   @Autowired
   RestTemplate restTemplate;

   @RequestMapping(value = "/products/exchange")
   public Product getProductList() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      HttpEntity <String> entity = new HttpEntity<String>(headers);
      
      return restTemplate.exchange("http://localhost:8086/products/1", HttpMethod.GET, entity, Product.class).getBody();
   }
   
   private Product getProductById(Integer id)
   {
       final String uri = "http://localhost:8086/products/{id}";
       RestTemplate restTemplate = new RestTemplate();
        
       Map<String, String> params = new HashMap<String, String>();
       params.put("id", String.valueOf(id));
        
       Product product = restTemplate.getForObject(uri, Product.class, params);
        
       return product;
   }
   
   @GetMapping("/products/{id}")
   public Product getProductDetails(@PathVariable Integer id) {
	   return getProductById(id);
   }
   
   @PostMapping("/products")
   public Product createProduct(@RequestBody Product product) {
	   final String uri = "http://localhost:8086/products";
	    RestTemplate restTemplate = new RestTemplate();
	    return restTemplate.postForObject( uri, product, Product.class);
   }

}