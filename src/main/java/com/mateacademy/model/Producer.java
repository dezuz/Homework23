package com.mateacademy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "producer")
public class Producer extends BaseModel {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "producer")
    private List<Product> products = new ArrayList<>();
}
