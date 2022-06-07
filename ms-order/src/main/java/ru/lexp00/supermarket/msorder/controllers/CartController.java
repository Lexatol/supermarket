package ru.lexp00.supermarket.msorder.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lexp00.supermarket.msorder.services.CartService;
import ru.lexp00.supermarket.routinglib.dtos.CartDto;

@RestController
@RequestMapping("api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public CartDto getCart() {
        return cartService.findCart();
    }

    @GetMapping("/inc/{id}")
    public CartDto addToCart(@PathVariable Long id) {
        return cartService.addToCart(id);
    }

    @GetMapping("/dec/{id}")
    public CartDto decToCart(@PathVariable Long id) {
         return cartService.decToCart(id);
    }

    @GetMapping("/remove/{id}")
    public CartDto removeCart(@PathVariable Long id) {
        return cartService.removeCart(id);
    }

    @GetMapping("/clear")
    public void clearCart() {
        cartService.clear();
    }
}
