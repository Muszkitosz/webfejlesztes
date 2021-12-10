package webbeadando.hr.service;

import webbeadando.hr.service.domain.EmployeeJobDto;

import java.util.List;

public interface EmployeeJobService {

    List<EmployeeJobDto> findAll();
    void save(EmployeeJobDto employeeJobDto);

    /*
    void delete(EmployeeJobDto employeeJobDto);
     */

    EmployeeJobDto findOne(Long dolgozo_beosztas_id);
}
