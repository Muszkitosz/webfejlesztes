package webbeadando.hr.service;

import webbeadando.hr.service.domain.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> findAll();
    void save(EmployeeDto employeeDto);
    void modify(EmployeeDto employeeDto);
    void delete(EmployeeDto employeeDto);

    EmployeeDto findOne(Long dolgozo_id);
}
