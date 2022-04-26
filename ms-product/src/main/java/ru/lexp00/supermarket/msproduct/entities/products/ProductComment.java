package ru.lexp00.supermarket.msproduct.entities.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "product_comment")
@Setter
@Getter
@NoArgsConstructor
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long comment_id;

    @Column(name = "user_id")
    private Long user_id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "description")
    private String description;
}
