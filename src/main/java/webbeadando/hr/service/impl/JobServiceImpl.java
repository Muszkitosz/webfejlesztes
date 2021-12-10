package webbeadando.hr.service.impl;

import org.modelmapper.TypeToken;
import webbeadando.hr.persistence.entity.Job;
import webbeadando.hr.persistence.entitymanager.JobDao;
import webbeadando.hr.service.JobService;
import webbeadando.hr.service.ModelMapper;
import webbeadando.hr.service.domain.JobDto;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.lang.reflect.Type;
import java.util.List;

@Stateless
public class JobServiceImpl implements JobService {

    @Inject
    JobDao jobDao;
    @Inject
    ModelMapper modelMapper;

    @Override
    public List<JobDto> findAll() {
        List<Job> entities = jobDao.findAll();
        Type listType = new TypeToken<List<JobDto>>() {}.getType();
        return modelMapper.map(entities, listType);
    }

    @Override
    public JobDto findOne(Long beosztas_id) {
        Job job = jobDao.findOne(beosztas_id);
        Type listType = new TypeToken<JobDto>() {}.getType();
        return modelMapper.map(job, listType);
    }

    @Override
    public void save(JobDto jobDto) {
        Job job = new Job();
        job.setBeosztasNev(jobDto.getBeosztasNev());
        job.setRovidLeiras(jobDto.getRovidLeiras());
        jobDao.save(job);
    }

    @Override
    public void modify(JobDto jobDto) {
        Job job = jobDao.findOne(jobDto.getBeosztasId());
        job.setBeosztasNev(jobDto.getBeosztasNev());
        job.setRovidLeiras(jobDto.getRovidLeiras());
        jobDao.save(job);
    }

    @Override
    public void delete(JobDto jobDto) {
        Job job = jobDao.findOne(jobDto.getBeosztasId());
        jobDao.delete(job);
    }
}
