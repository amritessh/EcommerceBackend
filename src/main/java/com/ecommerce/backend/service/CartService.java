/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecommerce.backend.service;

import com.ecommerce.backend.dto.Cart.AddToCartDto;
import com.ecommerce.backend.dto.Cart.CartDto;
import com.ecommerce.backend.dto.Cart.CartItemDto;
import com.ecommerce.backend.exceptions.CartItemsNotExistException;
import com.ecommerce.backend.model.Cart;
import com.ecommerce.backend.model.Product;
import com.ecommerce.backend.model.User;
import com.ecommerce.backend.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author amritesh
 */

@Service
public class CartService {
    
    @Autowired
    CartRepository cartRepository;

    public void addToCart(AddToCartDto addToCartDto, Product product, User user) {
        Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
        cartRepository.save(cart);
    }

    public CartDto listCartItems(User user) {
        // first get all the cart items for user
        List<Cart> cartList = cartRepository.findAllByUserOrderByCreatedDateDesc(user);

        // convert cart to cartItemDto
        List<CartItemDto> cartItems = new ArrayList<>();
        for (Cart cart:cartList){
            CartItemDto cartItemDto = new CartItemDto(cart);
            cartItems.add(cartItemDto);
        }

        // calculate the total price
        double totalCost = 0;
        for (CartItemDto cartItemDto :cartItems){
            totalCost += cartItemDto.getProduct().getPrice() * cartItemDto.getQuantity();
        }

        // return cart DTO
        return new CartDto(cartItems,totalCost);
    }

    public void deleteCartItem(int cartItemId, User user) throws CartItemsNotExistException {
        Optional<Cart> optionalCart = cartRepository.findById(cartItemId);

        if (!optionalCart.isPresent()) {
            throw new CartItemsNotExistException("cartItemId not valid");
        }

        Cart cart = optionalCart.get();

        if (cart.getUser() != user) {
            throw new CartItemsNotExistException("cart item does not belong to user");
        }
        cartRepository.deleteById(cartItemId);
    }
}
