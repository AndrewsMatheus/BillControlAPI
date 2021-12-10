package com.study.billsControl.billsPaymentAPI.builder;

import com.study.billsControl.billsPaymentAPI.dto.request.BillDTO;
import lombok.Builder;

@Builder
public class BillDTOBuilder {

    @Builder.Default
    private Integer id = 1;

    @Builder.Default
    private String description = "Conta de energia";

    @Builder.Default
    private String dueDate = "13-11-2021";

    @Builder.Default
    private Double value = 150.0;

    public BillDTO toBillDTO(){

        return new BillDTO(id,
                description,
                dueDate,
                value);
    }
}
