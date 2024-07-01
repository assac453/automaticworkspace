package com.assac453.automatedworkstation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fio", nullable = false)
    private String fio;

    @Column(name = "passport", nullable = false, length = 10, unique = true)
    private String passport;

    @Column(name = "family_status", nullable = false)
    private Boolean familyStatus;

    @Column(name = "registration_address", nullable = false)
    private String registrationAddress;

    @Column(name = "contact_phone", nullable = false, length = 11, unique = true)
    private String contactPhone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<EmploymentInfo> employmentInfos = new HashSet<>();

    @OneToMany(mappedBy = "client")
    private Set<Request> requests = new LinkedHashSet<>();
}
