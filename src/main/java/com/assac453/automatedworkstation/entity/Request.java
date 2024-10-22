package com.assac453.automatedworkstation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "requests")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "approved_amount", nullable = false, precision = 12, scale = 2)
    private BigDecimal approvedAmount;

    @Column(name = "approved_term", nullable = false)
    private Integer approvedTerm;

    @Column(name = "approved_status", nullable = false)
    private Boolean approvedStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "request")
    private Set<Contract> contracts = new LinkedHashSet<>();

}
