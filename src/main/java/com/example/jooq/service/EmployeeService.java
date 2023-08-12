package com.example.jooq.service;

import static nu.studer.sample.Tables.EMPLOYEE;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nu.studer.sample.tables.pojos.Employee;
import org.jooq.DSLContext;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final DSLContext context;

  public Employee getEmployee(Integer id) {

    return context.selectFrom(EMPLOYEE).where(EMPLOYEE.ID.eq(id)).fetchOneInto(Employee.class);
  }
}
