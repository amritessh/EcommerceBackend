package com.ecommerce.backend.repository;

import com.ecommerce.backend.model.User;
import com.ecommerce.backend.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Integer> {
    List<WishList> findAllByUserOrderByCreatedDateDesc(User user);
}
