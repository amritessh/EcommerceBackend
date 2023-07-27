/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.backend.repository;

import com.ecommerce.backend.model.Cart;
import com.ecommerce.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author amritesh
 */

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{
    List<Cart> findAllByUserOrderByCreatedDateDesc(User user);
}
