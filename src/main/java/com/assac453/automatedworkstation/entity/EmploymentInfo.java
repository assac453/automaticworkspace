package com.assac453.automatedworkstation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employment_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmploymentInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "work_period", nullable = false)
    private Integer workPeriod;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "organization", nullable = false)
    private String organization;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clients_id", nullable = false)
    private Client client;


}
