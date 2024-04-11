package com.tanish.springunittests.model;

import javax.persistence.*;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    private Long id;
    private String name;

    public Customer() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
