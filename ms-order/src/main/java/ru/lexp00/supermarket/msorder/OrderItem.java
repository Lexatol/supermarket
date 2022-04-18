package ru.lexp00.supermarket.msorder;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import ru.lexp00.supermarket.entities.products.Product;

import javax.persistence.*;

//@Entity
@Table(name = "order_item")
@Setter
@Getter
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;

    @Column (name = "quantity")
    private int quantity;

    @Column (name = "total_price")
    private int totalPrice;
}
