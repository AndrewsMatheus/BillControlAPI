package com.study.billsControl.billsPaymentAPI.dto.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BillDTO {

    private int id;

    @NotNull
    @Size(min = 1, max = 200)
    private String description;

    @NotNull
    private String dueDate;

    @NotNull
    private Double value;
}
