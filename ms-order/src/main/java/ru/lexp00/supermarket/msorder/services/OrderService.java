package ru.lexp00.supermarket.msorder.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lexp00.supermarket.mscore.dto.orders.OrderDto;
import ru.lexp00.supermarket.mscore.dto.orders.OrderItemDto;
import ru.lexp00.supermarket.msorder.entities.Order;
import ru.lexp00.supermarket.msorder.entities.OrderItem;
import ru.lexp00.supermarket.msorder.repositories.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    private final UserClient userClient;

    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream().map(this::orderToDto).collect(Collectors.toList());
    }

    private OrderDto orderToDto(Order order) {
        String name = userClient.getById(order.getUser_id()).getUsername();
        OrderDto orderDto = OrderDto.builder()
                .id(order.getId())
                .userName(name)
                .items(order.getItems().stream().map(this::orderItemDto).collect(Collectors.toList()))
                .address(order.getAddress())
                .build();
        return orderDto;
    }

    private OrderItemDto orderItemDto(OrderItem orderItem) {
        String title = productClient.getProductById(orderItem.getProduct_id()).getTitle();
        OrderItemDto orderItemDto = OrderItemDto.builder()
                .productTitle(title)
                .quantity(orderItem.getQuantity())
                .price(orderItem.getPrice())
                .totalPrice(orderItem.getTotalPrice())
                .build();
        return orderItemDto;
    }
}
