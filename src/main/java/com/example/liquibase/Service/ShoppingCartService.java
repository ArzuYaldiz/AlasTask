package com.example.liquibase.Service;

import com.example.liquibase.Dto.ShoppingCartDto;
import com.example.liquibase.Entity.ShoppingCart;
import com.example.liquibase.Repository.ShoppingCartRepository;

public interface ShoppingCartService {

     ShoppingCart createShoppingCart(ShoppingCartDto shoppingCartDto);


}
