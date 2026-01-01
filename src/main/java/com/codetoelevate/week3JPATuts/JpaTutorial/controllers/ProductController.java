package com.codetoelevate.week3JPATuts.JpaTutorial.controllers;

import com.codetoelevate.week3JPATuts.JpaTutorial.entities.ProductEntity;
import com.codetoelevate.week3JPATuts.JpaTutorial.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final int PAGE_SIZE=5;
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //@GetMapping()
    /*public List<ProductEntity> getAllProductsSortedByPrice(){
        return productRepository.findByOrderByPrice();
    }*/

    //@GetMapping()
    /*public List<ProductEntity> getAllProductsDynamicSorting(@RequestParam(defaultValue = "id") String sortBy){
        //return productRepository.findBy(Sort.by(Sort.Direction.ASC, sortBy, "price"));
        return productRepository.findBy(Sort.by(
                Sort.Order.asc(sortBy),
                Sort.Order.asc("price")));
    }*/

    @GetMapping()
    public List<ProductEntity> getALlProductsPagination(@RequestParam(defaultValue = "id") String sortBy,
                                                        @RequestParam(defaultValue = "0") Integer pageNumber){
        Pageable pageable = PageRequest.of(pageNumber,PAGE_SIZE, Sort.by(Sort.Direction.ASC, sortBy));
        return productRepository.findBy(pageable).getContent();
    }
}
