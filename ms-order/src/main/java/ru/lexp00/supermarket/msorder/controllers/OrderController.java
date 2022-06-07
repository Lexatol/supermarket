package ru.lexp00.supermarket.msorder.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.lexp00.supermarket.msorder.Bean.Cart;
import ru.lexp00.supermarket.msorder.services.OrderService;
import ru.lexp00.supermarket.routinglib.dtos.OrderDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    private final Cart cart;

    @GetMapping
    public List<OrderDto> getAll() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public OrderDto createNewOrder(@RequestParam String address,
                                   @RequestParam String phone,
                                   @RequestParam String email) {
        String name = "Petya";//todo забирать имя из токена
        return orderService.save(name, cart, address, phone, email);
    }
}
