package com.assac453.automatedworkstation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractDto {
    private Integer id;
    private Date signedDate;
    private Boolean signedStatus;
}
