package ru.lexp00.supermarket.mscore.dto.orders;

import lombok.*;
import ru.lexp00.supermarket.mscore.dto.orders.OrderItemDto;

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
