package com.crud.demo.controllers;

import com.crud.demo.entities.Product;
import com.crud.demo.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/")
    public ResponseEntity<Iterable<Product>> findAll() {
        try {
            return new ResponseEntity<Iterable<Product>>(
                    productService.findAll(), HttpStatus.OK
            );
        } catch (Exception ex) {
            return new ResponseEntity<Iterable<Product>>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/{id}", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE}, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
    public ResponseEntity<Product> find(@PathVariable("id") String id) {
        try {
            return new ResponseEntity<Product>(
                    productService.find(id), HttpStatus.OK
            );
        } catch (Exception ex) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping(value = "/create", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
    public ResponseEntity<Product> create(@RequestBody Product product) {
        try {
            return new ResponseEntity<Product>(
                    productService.save(product), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update", produces = { MimeTypeUtils.APPLICATION_JSON_VALUE }, consumes = { MimeTypeUtils.APPLICATION_JSON_VALUE })
    public ResponseEntity<Product> update(@RequestBody Product product) {
        try {
            return new ResponseEntity<Product>(
                    productService.save(product), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Product> delete(@PathVariable String id) {
        try {
            productService.delete(id);
            return new ResponseEntity<Product>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
        }
    }
}
