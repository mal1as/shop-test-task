package com.mal1as.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("PERCENT")
@PrimaryKeyJoinColumn(name = "coupon_id")
@Table(name = "coupon_percent")
@Getter
@Setter
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
