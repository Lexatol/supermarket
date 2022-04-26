package ru.lexp00.supermarket.msorder.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.lexp00.supermarket.mscore.dto.orders.OrderDto;
import ru.lexp00.supermarket.mscore.dto.orders.OrderItemDto;
import ru.lexp00.supermarket.mscore.exeptions.ResourceNotFoundException;
import ru.lexp00.supermarket.msorder.Bean.Cart;
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
    private final CartService cartService;

    public List<OrderDto> findAll() {
        return orderRepository.findAll().stream()
                .map(this::orderToDto)
                .collect(Collectors.toList());
    }

    public OrderDto findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order with " + id + " is not found"));
        return orderToDto(order);
    }

    public OrderDto save(String username, Cart cart, String address, String phone, String email) {
        Long userId = userClient.getByUsername(username).getId();
        Order order = new Order (userId, cart, address, phone, email);
        orderRepository.save(order);
        cartService.clear();
        return orderToDto(order);
    }

    private OrderDto orderToDto(Order order) {
        String name = userClient.getById(order.getUserId()).getUsername();
        OrderDto orderDto = OrderDto.builder()
                .id(order.getId())
                .userName(name)
                .items(order.getItems().stream().map(this::orderItemDto).collect(Collectors.toList()))
                .address(order.getAddress())
                .phone(order.getPhone())
                .email(order.getEmail())
                .totalPrice(order.getTotalPrice())
                .build();
        return orderDto;
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
}
