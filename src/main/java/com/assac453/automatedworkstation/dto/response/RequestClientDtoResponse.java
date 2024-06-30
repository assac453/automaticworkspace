package com.assac453.automatedworkstation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestClientDtoResponse {
    private String fio;
    private BigDecimal amount;
    private Integer term;
    private boolean status;
}
