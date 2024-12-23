package com.interview.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "address", schema = "public")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@EqualsAndHashCode(of = {"id"})
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String address;

    @Enumerated
    private AddressType addressType;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private LocalDateTime createdTime;

}
