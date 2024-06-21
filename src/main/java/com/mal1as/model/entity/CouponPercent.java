package com.mal1as.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@DiscriminatorValue("PERCENT")
@PrimaryKeyJoinColumn(name = "coupon_id")
@Table(name = "coupon_percent")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CouponPercent extends Coupon {

    @OneToOne
    @JoinColumn(name = "coupon_id", insertable = false, updatable = false)
    private Coupon coupon;

    @Column(name = "percent")
    private Integer percent;

    @Override
    public Double calculatePriceWithDiscount(Double price) {
        return price - price * percent / 100;
    }
}
