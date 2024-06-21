package com.mal1as.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@DiscriminatorValue("FIXED")
@PrimaryKeyJoinColumn(name = "coupon_id")
@Table(name = "coupon_fixed")
@Getter
@Setter
public class CouponFixed extends Coupon {

    @OneToOne
    @JoinColumn(name = "coupon_id", insertable = false, updatable = false)
    private Coupon coupon;

    @Column(name = "sum")
    private Integer sum;

    @Override
    public Double calculatePriceWithDiscount(Double price) {
        return price < sum ? 0 : price - sum;
    }
}
