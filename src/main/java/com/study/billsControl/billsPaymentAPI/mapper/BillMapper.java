package com.study.billsControl.billsPaymentAPI.mapper;

import com.study.billsControl.billsPaymentAPI.dto.request.BillDTO;
import com.study.billsControl.billsPaymentAPI.entity.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BillMapper{

    BillMapper INSTANCE = Mappers.getMapper(BillMapper.class);

    @Mapping(target = "dueDate", source = "dueDate", dateFormat = "dd-MM-yyyy")
    Bill toModel(BillDTO billDTO);

    BillDTO toDTO(Bill bill);
}