package ru.lexp00.supermarket.msorder.entities;

import lombok.*;
import org.hibernate.annotations.Cascade;
import ru.lexp00.supermarket.msorder.Bean.Cart;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @OneToMany (mappedBy = "order")
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<OrderItem> items;

    @Column (name = "address")
    private String address;

    @Column (name = "phone")
    private String phone;

    @Column (name = "email")
    private String email;

    @Column (name = "price")
    private int totalPrice;

    public Order(Long userId, Cart cart, String address, String phone, String email) {
        this.userId = userId;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.items = new ArrayList<>();
        cart.getItems().stream().forEach(o -> {
            o.setOrder(this);
            items.add(o);
        });
        this.totalPrice = cart.getTotalPrice();
    }
}
