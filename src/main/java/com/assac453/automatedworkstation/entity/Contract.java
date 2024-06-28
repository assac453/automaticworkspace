package com.assac453.automatedworkstation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "contracts")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "signed_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date signedDate;

    @Column(name = "signed_status", nullable = false)
    private Boolean signedStatus;

    @OneToOne(mappedBy = "contract")
    private Request request;
}
