package com.study.billsControl.billsPaymentAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.DateFormat;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill {

    @Id
    private int id;

    @Column
    private String description;

    @Column(nullable = false)
    private DateFormat dueDate;

    @Column
    private float value;
}
