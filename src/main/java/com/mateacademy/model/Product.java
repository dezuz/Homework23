package com.mateacademy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "product")
public class Product extends BaseModel {

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="producer_id")
    private Producer producer;
}
