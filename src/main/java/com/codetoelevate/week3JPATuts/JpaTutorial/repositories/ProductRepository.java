package com.codetoelevate.week3JPATuts.JpaTutorial.repositories;

import com.codetoelevate.week3JPATuts.JpaTutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByTitle(String s);

    Optional<ProductEntity> findByCreatedAtAfter(LocalDateTime of);

    Optional<ProductEntity> findByQuantityAndPrice(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int i, BigDecimal bigDecimal);

    List<ProductEntity> findByTitleLike(String search);

    List<ProductEntity> findByTitleContaining(String Search);

    //Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);

    @Query("select p from ProductEntity p where p.title=:title and p.price=:price")
    Optional<ProductEntity> findByTitleAndPrice(String title, BigDecimal price);
}
