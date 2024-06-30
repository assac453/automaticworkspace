package com.assac453.automatedworkstation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractRequestDtoResponse {
    private Date signedDate;
    private Boolean signedStatus;
    private BigDecimal approvedAmount;
    private Integer approvedTerm;
    private Boolean approvedStatus;
}
