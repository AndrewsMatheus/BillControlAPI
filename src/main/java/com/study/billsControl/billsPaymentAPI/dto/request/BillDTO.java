package com.study.billsControl.billsPaymentAPI.dto.request;
import java.util.Date;
import lombok.Builder;

import javax.validation.constraints.NotEmpty;

@Builder
public class BillDTO {

    @NotEmpty
    private int id;

    @NotEmpty
    private String description;

    @NotEmpty
    private Date date;

    @NotEmpty
    private float value;
}
