package com.study.billsControl.billsPaymentAPI.service;

import com.study.billsControl.billsPaymentAPI.dto.request.BillDTO;
import com.study.billsControl.billsPaymentAPI.entity.Bill;
import com.study.billsControl.billsPaymentAPI.exception.BillAlreadyRegisteredException;
import com.study.billsControl.billsPaymentAPI.exception.BillNotFoundException;
import com.study.billsControl.billsPaymentAPI.mapper.BillMapper;
import com.study.billsControl.billsPaymentAPI.repository.BillRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BillService {

    private final BillMapper billMapper = BillMapper.INSTANCE;

    private BillRepository billRepository;

    public BillDTO createBill(BillDTO billDTO) throws BillAlreadyRegisteredException {


        Optional <Bill> isBill = billRepository.findById(billDTO.getId());

        System.out.println(isBill);

        if (!isBill.isEmpty())
            throw new BillAlreadyRegisteredException();
        else {
            Bill bill = billMapper.toModel(billDTO);

            Bill savedBill = billRepository.save(bill);

            return billMapper.toDTO(savedBill);
        }
    }

    public BillDTO findById(int billId) throws BillNotFoundException {

        Bill foundBill = verifyIfExists(billId);

        return billMapper.toDTO(foundBill);
    }

    public List<BillDTO> listAll() {
        return billRepository.findAll()
                .stream()
                .map(billMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(int billId) throws BillNotFoundException {

        verifyIfExists(billId);

        billRepository.deleteById(billId);
    }
    public Bill verifyIfExists(int BillId) throws BillNotFoundException {

        return billRepository.findById(BillId)
                .orElseThrow(() ->new BillNotFoundException());
    }

}
