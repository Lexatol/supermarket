package ru.lexp00.supermarket.msproduct.entities.products;

import lombok.*;
import ru.lexp00.supermarket.msproduct.entities.categories.Category;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    @ManyToMany
    @JoinTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categoryList;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "product")
    private List<ProductComment> productCommentList;
}
