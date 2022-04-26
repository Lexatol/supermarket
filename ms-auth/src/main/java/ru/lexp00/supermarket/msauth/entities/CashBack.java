package ru.lexp00.supermarket.msauth.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cashback")
@Getter
@Setter
public class CashBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cash_id")
    private Long cash_id;

    @Column(name = "bonus")
    private int bonus;

}
