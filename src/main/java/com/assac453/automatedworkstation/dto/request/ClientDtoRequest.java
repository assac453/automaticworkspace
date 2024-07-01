package com.assac453.automatedworkstation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDtoRequest {
    private Integer id;
    private String fio;
    private String passport;
    private Boolean familyStatus;
    private String registrationAddress;
    private String contactPhone;
    private List<EmploymentInfoDtoRequest> employmentInfos;
}
