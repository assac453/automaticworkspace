package com.assac453.automatedworkstation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmploymentInfoDto {
    private Integer id;
    private Integer workPeriod;
    private String position;
    private String organization;
    private Integer clientId;
}