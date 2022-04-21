package ru.lexp00.supermarket.msorder.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @OneToMany (mappedBy = "order")
    private List<OrderItem> items;

    @Column (name = "address")
    private String address;

    @Column (name = "price")
    private int totalPrice;

}
