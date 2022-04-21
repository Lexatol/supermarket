package ru.lexp00.supermarket.mscore.dto.orders;

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
}
