package com.mb.supermarket_master.repositories;

import com.mb.supermarket_master.domain.entities.Product;
import com.mb.supermarket_master.domain.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByName(String name);

    //concat is for wildcards, and the % before and after
    //lower is telling to ignore case
    // is null or, is to say the field is optional, if its null then it is skipped
    // """ is a text block and can be used for SQL or HTML so you dont need escaping quotes or new lines
    @Query("""
            SELECT p FROM Product p
            WHERE (:keyword IS NULL OR LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')))
            AND (:category IS NULL OR p.category = :category)
            AND (:priceMin IS NULL OR p.price >= :priceMin)
            AND (:priceMax IS NULL OR p.price <= :priceMax)
            """)
    List<Product> searchProducts(
            //this is to bind the declared attribute to the query above
            @Param("keyword") String keyword,
            @Param("category") ProductCategory category,
            @Param("priceMin") Double priceMin,
            @Param("priceMax") Double priceMax
            );

}
