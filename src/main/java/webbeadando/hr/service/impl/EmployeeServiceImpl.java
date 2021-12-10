package webbeadando.hr.service.impl;

import org.modelmapper.TypeToken;
import webbeadando.hr.persistence.entity.Employee;
import webbeadando.hr.persistence.entitymanager.EmployeeDao;
import webbeadando.hr.service.EmployeeService;
import webbeadando.hr.service.ModelMapper;
import webbeadando.hr.service.domain.EmployeeDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;

@Stateless
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    EmployeeDao employeeDao;
    @Inject
    ModelMapper modelMapper;

    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> entities = employeeDao.findAll();
        Type listType = new TypeToken<List<EmployeeDto>>() {}.getType();
        return modelMapper.map(entities, listType);
    }

    @Override
    public EmployeeDto findOne(Long dolgozo_id) {
        Employee employee = employeeDao.findOne(dolgozo_id);
        Type listType = new TypeToken<EmployeeDto>() {}.getType();
        return modelMapper.map(employee, listType);
    }

    @Override
    public void save(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setVezeteknev(employeeDto.getVezeteknev());
        employee.setKeresztnev(employeeDto.getKeresztnev());
        employee.setSzuletesiDatum(employeeDto.getSzuletesiDatum());
        employee.setLakcim(employeeDto.getLakcim());
        employee.setAnyjaNeve(employeeDto.getAnyjaNeve());
        employeeDao.save(employee);
    }

    @Override
    public void modify(EmployeeDto employeeDto) {
        Employee employee = employeeDao.findOne(employeeDto.getDolgozoId());
        employee.setVezeteknev(employeeDto.getVezeteknev());
        employee.setKeresztnev(employeeDto.getKeresztnev());
        employee.setSzuletesiDatum(employeeDto.getSzuletesiDatum());
        employee.setLakcim(employeeDto.getLakcim());
        employee.setAnyjaNeve(employeeDto.getAnyjaNeve());
        employeeDao.save(employee);
    }

    @Override
    public void delete(EmployeeDto employeeDto) {
        Employee employee = employeeDao.findOne(employeeDto.getDolgozoId());
        employeeDao.delete(employee);
    }
}
