package com.mss.e.farming.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @Author: Md. Tanver Ahammed,
 * tanvermbstuit16@gmail.com,
 * ICT, MBSTU
 */

@Entity
@Table(name = "organizations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String type;

    private String description;

    @OneToMany(mappedBy = "organization", orphanRemoval = true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<User> users;

}
