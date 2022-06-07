package ru.lexp00.supermarket.routinglib.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private List<OrderItemDto> items;
    private int totalPrice;
}
