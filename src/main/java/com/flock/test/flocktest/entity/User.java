package com.flock.test.flocktest.entity;

import com.flock.test.flocktest.models.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "USERS")
public class User {
    @Id
    @Setter(AccessLevel.PRIVATE)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "USERNAME", unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ROL")
    private Role rol;

    @Column(name= "ENABLED")
    private Boolean enabled;

    public User() {}
}
