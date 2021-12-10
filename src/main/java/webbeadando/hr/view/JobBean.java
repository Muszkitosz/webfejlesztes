package webbeadando.hr.view;

import webbeadando.hr.service.JobService;
import webbeadando.hr.service.domain.EmployeeDto;
import webbeadando.hr.service.domain.JobDto;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "jobBean")
@ViewScoped
public class JobBean implements Serializable {

    @Inject
    JobService jobService;

    private List<JobDto> jobDtos;
    private JobDto selectedDto = new JobDto();

    private String newBeosztasNev;
    private String newRovidLeiras;

    @PostConstruct
    private void init(){
        jobDtos = jobService.findAll();
        newBeosztasNev = null;
        newRovidLeiras = null;
    }

    public void addJob(){
        JobDto job = new JobDto();
        job.setBeosztasNev(newBeosztasNev);
        job.setRovidLeiras(newRovidLeiras);
        jobService.save(job);
        init();
    }

    public void onRowSelect() {
        newBeosztasNev = selectedDto.getBeosztasNev();
        newRovidLeiras = selectedDto.getRovidLeiras();
    }

    public void modifyJob() {
        selectedDto.setBeosztasNev(newBeosztasNev);
        selectedDto.setRovidLeiras(newRovidLeiras);
        jobService.modify(selectedDto);
        init();
    }

    public void deleteJob() {
        jobService.delete(selectedDto);
        init();
    }

    public JobService getJobService() {
        return jobService;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    public List<JobDto> getJobDtos() {
        return jobDtos;
    }

    public void setJobDtos(List<JobDto> jobDtos) {
        this.jobDtos = jobDtos;
    }

    public JobDto getSelectedDto() {
        return selectedDto;
    }

    public void setSelectedDto(JobDto selectedDto) {
        this.selectedDto = selectedDto;
    }

    public String getNewBeosztasNev() {
        return newBeosztasNev;
    }

    public void setNewBeosztasNev(String newBeosztasNev) {
        this.newBeosztasNev = newBeosztasNev;
    }

    public String getNewRovidLeiras() {
        return newRovidLeiras;
    }

    public void setNewRovidLeiras(String newRovidLeiras) {
        this.newRovidLeiras = newRovidLeiras;
    }
}
