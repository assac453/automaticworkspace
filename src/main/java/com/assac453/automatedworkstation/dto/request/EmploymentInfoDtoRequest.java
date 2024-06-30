package com.assac453.automatedworkstation.dto.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmploymentInfoDtoRequest {
    private Integer workPeriod;
    private String position;
    private String organization;
}
