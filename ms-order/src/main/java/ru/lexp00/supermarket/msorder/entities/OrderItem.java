package ru.lexp00.supermarket.msorder.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "order_items")
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "total_price")
    private int totalPrice;

    public void inc() {
        quantity++;
        totalPrice = price * quantity;
    }

    public void dec() {
        quantity--;
        totalPrice = price * quantity;
    }

}
