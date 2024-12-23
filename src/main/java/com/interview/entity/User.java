package com.interview.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "company_user", schema = "public")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"id"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @OneToMany(mappedBy = "user")
    private List<Address> userAddresses;
}
