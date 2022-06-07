package ru.lexp00.supermarket.routinglib.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private Long id;
    private String userName;
    private List<OrderItemDto> items;
    private String address;
    private String phone;
    private String email;
    private int totalPrice;

}
