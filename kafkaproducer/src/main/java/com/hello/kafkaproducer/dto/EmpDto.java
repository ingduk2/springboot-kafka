package com.hello.kafkaproducer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmpDto {

    private String empNo;
    private String empName;
    private String deptNo;
}
