package com.marketplace.shoppingcartservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

//профиль пользователя корзины

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "profile")
public class Profile {

    @Id
    @Column(name = "id")
    private UUID id;    //    UUID пользователя

    @Column(name = "name")
    private String name;    //    имя пользователя
}
