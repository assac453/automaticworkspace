package com.assac453.automatedworkstation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDto {
    private Integer id;
    private BigDecimal approvedAmount;
    private Integer approvedTerm;
    private Boolean approvedStatus;
    private Integer clientId;
    private Integer contractId;
}
