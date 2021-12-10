package webbeadando.hr.service.impl;

import org.modelmapper.TypeToken;
import webbeadando.hr.persistence.entity.EmployeeJob;
import webbeadando.hr.persistence.entitymanager.*;
import webbeadando.hr.service.EmployeeJobService;
import webbeadando.hr.service.ModelMapper;
import webbeadando.hr.service.domain.EmployeeJobDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;

@Stateless
public class EmployeeJobServiceImpl implements EmployeeJobService {

    @Inject
    EmployeeJobDao employeeJobDao;
    @Inject
    EmployeeDao employeeDao;
    @Inject
    JobDao jobDao;
    @Inject
    ModelMapper modelMapper;

    @Override
    public List<EmployeeJobDto> findAll() {
        List<EmployeeJob> entities = employeeJobDao.findAll();
        Type listType = new TypeToken<List<EmployeeJobDto>>() {}.getType();
        return modelMapper.map(entities, listType);
    }

    @Override
    public EmployeeJobDto findOne(Long dolgozo_beosztas_id) {
        EmployeeJob employeeJob = employeeJobDao.findOne(dolgozo_beosztas_id);
        Type listType = new TypeToken<EmployeeJobDto>() {}.getType();
        return modelMapper.map(employeeJob, listType);
    }

    @Override
    public void save(EmployeeJobDto employeeJobDto) {
        EmployeeJob employeeJob = new EmployeeJob();
        employeeJob.setDolgozoId(employeeDao.findOne(employeeJobDto.getDolgozoId().getDolgozoId()));
        employeeJob.setBeosztasId(jobDao.findOne(employeeJobDto.getBeosztasId().getBeosztasId()));
        employeeJob.setFelvetelDatum(employeeJobDto.getFelvetelDatum());
        employeeJobDao.saveAsReturn(employeeJob);
    }
}
