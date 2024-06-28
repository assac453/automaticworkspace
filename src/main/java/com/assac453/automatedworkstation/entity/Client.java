package com.assac453.automatedworkstation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fio", nullable = false)
    private String fio;

    @Column(name = "passport", nullable = false, length = 10)
    private String passport;

    @Column(name = "family_status", nullable = false)
    private Boolean familyStatus;

    @Column(name = "registration_address", nullable = false)
    private String registrationAddress;

    @Column(name = "contact_phone", nullable = false, length = 11)
    private String contactPhone;

    @Column(name = "request_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal requestAmount;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmploymentInfo> employmentInfos;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Request> requests;

}
