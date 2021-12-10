package com.study.billsControl.billsPaymentAPI.service;

import com.study.billsControl.billsPaymentAPI.builder.BillDTOBuilder;
import com.study.billsControl.billsPaymentAPI.dto.request.BillDTO;
import com.study.billsControl.billsPaymentAPI.entity.Bill;
import com.study.billsControl.billsPaymentAPI.exception.BillAlreadyRegisteredException;
import com.study.billsControl.billsPaymentAPI.exception.BillNotFoundException;
import com.study.billsControl.billsPaymentAPI.mapper.BillMapper;
import com.study.billsControl.billsPaymentAPI.repository.BillRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BillServiceTest {

    private static final int INVALID_BILL_ID = 1;

    @Mock
    private BillRepository billRepository;

    private BillMapper billMapper= BillMapper.INSTANCE;

    @InjectMocks
    private BillService billService;

    @Test
    void whenBillInformedThenItShouldBeCreated() throws BillAlreadyRegisteredException {

        // given

        BillDTO billDTO = BillDTOBuilder.builder().build().toBillDTO();
        Bill expectedSavedBill = billMapper.toModel(billDTO);

        // when

        when(billRepository.findById(billDTO.getId())).thenReturn(Optional.empty());
        when(billRepository.save(expectedSavedBill)).thenReturn(expectedSavedBill);

        BillDTO createdBillDTO = billService.createBill(billDTO);

        // then
        assertEquals(billDTO.getId(), createdBillDTO.getId());
        assertEquals(billDTO.getDescription(), createdBillDTO.getDescription());
    }

    @Test
    void whenAlreadyRegisteredBillInformedThenAnExceptionShouldBeThrown() {
        // given
        BillDTO expectedBillDTO = BillDTOBuilder.builder().build().toBillDTO();
        Bill duplicatedBill = billMapper.toModel(expectedBillDTO);

        // when
        when(billRepository.findById(expectedBillDTO.getId())).thenReturn(Optional.of(duplicatedBill));

        // then
        assertThrows(BillAlreadyRegisteredException.class, () -> billService.createBill(expectedBillDTO));
    }

    @Test
    void whenValidBillIdIsGivenThenReturnABill() throws BillNotFoundException {
        // given
        BillDTO expectedFoundBillDTO = BillDTOBuilder.builder().build().toBillDTO();
        Bill expectedFoundBill = billMapper.toModel(expectedFoundBillDTO);

        // when
        when(billRepository.findById(expectedFoundBill.getId())).thenReturn(Optional.of(expectedFoundBill));

        // then
        BillDTO foundBillDTO = billService.findById(expectedFoundBillDTO.getId());

        assertThat(foundBillDTO, is(equalTo(expectedFoundBillDTO)));
    }

    @Test
    void whenNotRegisteredBillIdIsGivenThenThrowAnException() {
        // given
        BillDTO expectedFoundBillDTO = BillDTOBuilder.builder().build().toBillDTO();

        // when
        when(billRepository.findById(expectedFoundBillDTO.getId())).thenReturn(Optional.empty());

        // then
        assertThrows(BillNotFoundException.class, () -> billService.findById(expectedFoundBillDTO.getId()));
    }

    @Test
    void whenListBillIsCalledThenReturnAListOfBills() {
        // given
        BillDTO expectedFoundBillDTO = BillDTOBuilder.builder().build().toBillDTO();
        Bill expectedFoundBill = billMapper.toModel(expectedFoundBillDTO);

        //when
        when(billRepository.findAll()).thenReturn(Collections.singletonList(expectedFoundBill));

        //then
        List<BillDTO> foundListBillsDTO = billService.listAll();

        assertThat(foundListBillsDTO, is(not(empty())));
        assertThat(foundListBillsDTO.get(0), is(equalTo(expectedFoundBillDTO)));
    }

    @Test
    void whenListBillIsCalledThenReturnAnEmptyListOfBills() {
        //when
        when(billRepository.findAll()).thenReturn(Collections.EMPTY_LIST);

        //then
        List<BillDTO> foundListBillsDTO = billService.listAll();

        assertThat(foundListBillsDTO, is(empty()));
    }

    @Test
    void whenExclusionIsCalledWithValidIdThenABillShouldBeDeleted() throws BillNotFoundException{
        // given
        BillDTO expectedDeletedBillDTO = BillDTOBuilder.builder().build().toBillDTO();
        Bill expectedDeletedBill = billMapper.toModel(expectedDeletedBillDTO);

        // when
        when(billRepository.findById(expectedDeletedBillDTO.getId())).thenReturn(Optional.of(expectedDeletedBill));
        doNothing().when(billRepository).deleteById(expectedDeletedBillDTO.getId());

        // then
        billService.deleteById(expectedDeletedBillDTO.getId());

        verify(billRepository, times(1)).findById(expectedDeletedBillDTO.getId());
        verify(billRepository, times(1)).deleteById(expectedDeletedBillDTO.getId());
    }

}
