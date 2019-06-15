package com.mateacademy.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Accessors(chain = true)
@Table(name = "role")
public class Role extends BaseModel {

    @Column(name = "name")
    private String name;

    @ManyToOne
    private UserEntity user;
}
