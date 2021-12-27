package com.study.billsControl.billsPaymentAPI.controller;

import com.study.billsControl.billsPaymentAPI.dto.request.BillDTO;
import com.study.billsControl.billsPaymentAPI.exception.BillAlreadyRegisteredException;
import com.study.billsControl.billsPaymentAPI.exception.BillNotFoundException;
import com.study.billsControl.billsPaymentAPI.service.BillService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bills")
@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BillController {

    private final BillService billService;

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public BillDTO create(@RequestBody @Valid BillDTO billDTO) throws BillAlreadyRegisteredException {

        return billService.createBill(billDTO);
    }

    @GetMapping("/{billId}")
    @ResponseStatus(HttpStatus.OK)
    public BillDTO findById(@PathVariable int billId) throws BillNotFoundException {
        return billService.findById(billId);
    }

    @GetMapping
    public List<BillDTO> listBills(){
        return billService.listAll();
    }


    @DeleteMapping("/{billId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int billId) throws BillNotFoundException{

        billService.deleteById(billId);
    }

}
