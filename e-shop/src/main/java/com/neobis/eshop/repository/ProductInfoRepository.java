package com.neobis.eshop.repository;

import com.neobis.eshop.entity.ProductInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInfoRepository extends JpaRepository<ProductInfoEntity, Integer> {
}
