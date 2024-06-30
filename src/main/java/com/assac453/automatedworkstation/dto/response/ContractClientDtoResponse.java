package com.assac453.automatedworkstation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContractClientDtoResponse {
    private int id;
    private String fio;
    private Date signedDate;
    private Boolean signedStatus;
}
