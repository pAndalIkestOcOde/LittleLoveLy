package com.vtcorp.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    private String username;
    private String password;
    private String name;
    private String mail;
    private String phone;
    private String city;
    private String district;
    private String ward;
    private String street;
    private Integer point;
    private String role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    @ManyToMany
    @JoinTable(name = "voucher_availability",
            joinColumns = @JoinColumn(name = "fk_username"),
            inverseJoinColumns = @JoinColumn(name = "fk_voucher_id"))
    private List<Voucher> vouchers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductReview> productReviews;

}
