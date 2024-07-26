package com.example.liquibase.Service.ımpl;

import com.example.liquibase.Dto.ShoppingCartDto;
import com.example.liquibase.Entity.ShoppingCart;
import com.example.liquibase.Repository.ShoppingCartRepository;
import com.example.liquibase.Service.ShoppingCartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class ShoppingCartImpl implements ShoppingCartService {
    ShoppingCartRepository shoppingCartRepository;


    @Override
    public ShoppingCart createShoppingCart(ShoppingCartDto shoppingCartDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setName(shoppingCartDto.getName());

        return  shoppingCartRepository.save(shoppingCart);
    }
}
