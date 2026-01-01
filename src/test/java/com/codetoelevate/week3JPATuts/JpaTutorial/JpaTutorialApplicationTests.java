package com.codetoelevate.week3JPATuts.JpaTutorial;

import com.codetoelevate.week3JPATuts.JpaTutorial.entities.ProductEntity;
import com.codetoelevate.week3JPATuts.JpaTutorial.repositories.ProductRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository(){
        ProductEntity productEntity = ProductEntity.builder()
                .sku("SKU-5016")
                .title("Nestle Chocolate")
                .price(BigDecimal.valueOf(124.45))
                .quantity(12)
                .build();
        ProductEntity savedProductEntity = productRepository.save(productEntity);
        System.out.println(savedProductEntity);
    }

    @Test
    void getRepository(){
        List<ProductEntity> entities = productRepository.findAll();
        System.out.println(entities);
    }

    @Test
    void getRepositoryFindById(){
        Optional<ProductEntity> entity = productRepository.findById(15L);
        System.out.println(entity);
    }

    @Test
    void getRepositoryfindByName(){
        Optional<ProductEntity> entity = productRepository.findByTitle("Laptop 16GB RAM");
        System.out.println(entity);
    }

    @Test
    void getRepositoryfindByCreatedAtAfter(){
        Optional<ProductEntity> entity = productRepository.findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0));
        System.out.println(entity);
    }

    @Test
    void getRepositoryFindByQuantityAndPrice(){
        Optional<ProductEntity> entity = productRepository.findByQuantityAndPrice(120, BigDecimal.valueOf(499.99));
        System.out.println(entity);
    }

    @Test
    void getRepositoryFindByQuantityGreaterThanAndPriceLessThan(){
        List<ProductEntity> entity = productRepository.findByQuantityGreaterThanAndPriceLessThan(10, BigDecimal.valueOf(699.99));
        System.out.println(entity);
    }

    @Test
    void getRepositoryFindByNameLike(){
        List<ProductEntity> entities = productRepository.findByTitleLike("%Laptop%");
        //List<ProductEntity> entities = productRepository.findByTitleContaining("Laptop");
        System.out.println(entities);
    }

    @Test
    void getRepositoryFindByTitleAndPrice(){
        Optional<ProductEntity> entity = productRepository.findByTitleAndPrice("Smartphone 5G", BigDecimal.valueOf(39999.00));
        System.out.println(entity);
    }
}
