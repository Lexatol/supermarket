package ru.lexp00.supermarket.mscore.dto.orders;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private Long productId;
    private String productTitle;
    private int quantity;
    private int price;
    private int totalPrice;
}
