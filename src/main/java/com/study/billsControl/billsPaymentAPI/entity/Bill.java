package com.study.billsControl.billsPaymentAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.DateFormat;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    private int id;

    @Column
    private String description;

    @Column
    private DateFormat dueDate;

    @Column
    private float value;
}
