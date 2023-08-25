package com.mss.e.farming.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: Md. Tanver Ahammed,
 * tanvermbstuit16@gmail.com,
 * ICT, MBSTU
 */

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String email;

    private String phone;

    private short age;

    private String designation;

    private String address;

    private boolean isEnable;

    private String password;

    @OneToMany(mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Role> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "organization_id_fk", referencedColumnName = "id")
    private Organization organization;

    @ManyToMany
    @JoinTable(
            name = "user_blog",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "blog_id", referencedColumnName = "id")
    )
    private List<Blog> blogs = new ArrayList<>();

}
