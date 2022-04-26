package ru.lexp00.supermarket.msorder.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lexp00.supermarket.mscore.dto.orders.OrderItemDto;
import ru.lexp00.supermarket.mscore.dto.orders.CartDto;
import ru.lexp00.supermarket.mscore.dto.products.ProductDto;
import ru.lexp00.supermarket.msorder.Bean.Cart;
import ru.lexp00.supermarket.msorder.entities.OrderItem;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartService {
    private final Cart cart;
    private final ProductClient productClient;

    private final int QUANTITY = 1;

    public CartDto findCart() {
        return createCartDto();
    }

    public CartDto addToCart(Long id) {
        ProductDto pr = productClient.getProductById(id);
        List<OrderItem> items = cart.getItems();
        for (OrderItem item : items) {
            if (item.getProductId().equals(id)) {
                item.inc();
                recalculate();
                return createCartDto();
            }
        }
        OrderItem orderItem = OrderItem.builder()
                .productId(pr.getId())
                .quantity(QUANTITY)
                .price(pr.getPrice())
                .totalPrice(pr.getPrice())
                .build();
        cart.getItems().add(orderItem);
        recalculate();
        return createCartDto();
    }

    public CartDto decToCart(Long id) {
        Iterator<OrderItem> iterator = cart.getItems().iterator();
        while (iterator.hasNext()) {
            OrderItem orderItem = iterator.next();
            if (orderItem.getProductId().equals(id)) {
                orderItem.dec();
                if (orderItem.getQuantity() == 0) {
                    iterator.remove();
                }
                recalculate();
                return createCartDto();
            }
        }
        return createCartDto();
    }

    public CartDto removeCart(Long id) {
        Iterator<OrderItem> iterator = cart.getItems().iterator();
        while (iterator.hasNext()) {
            OrderItem orderItem = iterator.next();
            if (orderItem.getProductId().equals(id)) {
                iterator.remove();
                recalculate();
                return createCartDto();
            }
        }
        return createCartDto();
    }

    public void clear() {
        cart.getItems().clear();
        recalculate();
    }

    private void recalculate() {
        cart.setTotalPrice(0);
        int total = 0;
        for (OrderItem item : cart.getItems()) {
            total += item.getTotalPrice();
        }
        cart.setTotalPrice(total);
    }

    private OrderItemDto orderItemDto(OrderItem orderItem) {
        String title = productClient.getProductById(orderItem.getProductId()).getTitle();
        OrderItemDto orderItemDto = OrderItemDto.builder()
                .productId(orderItem.getProductId())
                .productTitle(title)
                .quantity(orderItem.getQuantity())
                .price(orderItem.getPrice())
                .totalPrice(orderItem.getTotalPrice())
                .build();
        return orderItemDto;
    }

    private CartDto createCartDto() {
        return CartDto.builder()
                .items(cart.getItems().stream().map(this::orderItemDto).collect(Collectors.toList()))
                .totalPrice(cart.getTotalPrice())
                .build();
    }
}
