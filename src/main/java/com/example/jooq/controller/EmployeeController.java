package com.example.jooq.controller;

import static org.springframework.http.HttpStatus.OK;

import com.example.jooq.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nu.studer.sample.tables.pojos.Employee;
import nu.studer.sample.tables.records.EmployeeRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService employeeService;


  @GetMapping
  public ResponseEntity<Employee> get(@RequestParam("id") int id) {
    Employee employee = employeeService.getEmployee(id);
    return new ResponseEntity<>(employee, OK);
  }
}
