package com.marketplace.shoppingcartservice.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//персональная скидка для пользователя

@Entity
@Data
@NoArgsConstructor
@Table(name = "personal_discount")
public class PersonalDiscount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;    //профиль пользователя

    @Column(name = "discount_percent")
    private Integer discountPercent;   //размер скидки в процентах

}
