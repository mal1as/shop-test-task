package com.mal1as.model.entity;

import com.mal1as.model.enums.CouponType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "type")
@Table(name = "coupon")
@Getter
@Setter
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", insertable = false, updatable = false)
    private CouponType type;

    @Column(name = "code")
    private String code;

    @Transient
    public Double calculatePriceWithDiscount(Double price) {
        throw new UnsupportedOperationException();
    }
}
