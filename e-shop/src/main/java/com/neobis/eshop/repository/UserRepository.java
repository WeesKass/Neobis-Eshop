package com.neobis.eshop.repository;

import com.neobis.eshop.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <UserEntity, Integer> {
}
