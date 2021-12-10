package com.study.billsControl.billsPaymentAPI.repository;

import com.study.billsControl.billsPaymentAPI.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
