package com.study.billsControl.billsPaymentAPI.dto.request;
import lombok.Builder;

import javax.validation.constraints.NotEmpty;

@Builder
public class BillDTO {

    @NotEmpty
    private int id;

    @NotEmpty
    private String description;

    private String dueDate;

    @NotEmpty
    private float value;
}
