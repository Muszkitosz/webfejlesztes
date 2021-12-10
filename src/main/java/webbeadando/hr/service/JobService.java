package webbeadando.hr.service;

import webbeadando.hr.service.domain.JobDto;

import java.util.List;

public interface JobService {

    List<JobDto> findAll();
    void save(JobDto jobDto);
    void modify(JobDto jobDto);
    void delete(JobDto jobDto);

    JobDto findOne(Long beosztas_id);
}
