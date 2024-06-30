package com.assac453.automatedworkstation.dto.request;


import com.assac453.automatedworkstation.dto.EmploymentInfoDto;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class RequestDtoRequest {
    private String fio;
    private String passport;
    private Boolean familyStatus;
    private String registrationAddress;
    private String contactPhone;
    private List<EmploymentInfoDto> employments;
    private BigDecimal requestAmount;
}
