package webbeadando.hr.view;

import webbeadando.hr.service.EmployeeJobService;
import webbeadando.hr.service.domain.*;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named(value = "employeeJobBean")
@ViewScoped
public class EmployeeJobBean implements Serializable {

    @Inject
    EmployeeJobService employeeJobService;

    private List<EmployeeJobDto> employeeJobDtos;
    private EmployeeJobDto selectedDto = new EmployeeJobDto();

    private EmployeeDto newDolgozoId;
    private JobDto newBeosztasId;

    @PostConstruct
    private void init(){
        employeeJobDtos = employeeJobService.findAll();
        newDolgozoId = null;
        newBeosztasId = null;
    }

    public void addEmployeeJob() {
        EmployeeJobDto employeeJob = new EmployeeJobDto();
        employeeJob.setDolgozoId(newDolgozoId);
        employeeJob.setBeosztasId(newBeosztasId);
        employeeJob.setFelvetelDatum(new Date(System.currentTimeMillis()));
        employeeJobService.save(employeeJob);
        init();
    }

    public void onRowSelect() {
        newDolgozoId = selectedDto.getDolgozoId();
        newBeosztasId = selectedDto.getBeosztasId();
    }

    public EmployeeJobService getEmployeeJobService() {
        return employeeJobService;
    }

    public void setEmployeeJobService(EmployeeJobService employeeJobService) {
        this.employeeJobService = employeeJobService;
    }

    public List<EmployeeJobDto> getEmployeeJobDtos() {
        return employeeJobDtos;
    }

    public void setEmployeeJobDtos(List<EmployeeJobDto> employeeJobDtos) {
        this.employeeJobDtos = employeeJobDtos;
    }

    public EmployeeJobDto getSelectedDto() {
        return selectedDto;
    }

    public void setSelectedDto(EmployeeJobDto selectedDto) {
        this.selectedDto = selectedDto;
    }

    public EmployeeDto getNewDolgozoId() {
        return newDolgozoId;
    }

    public void setNewDolgozoId(EmployeeDto newDolgozoId) {
        this.newDolgozoId = newDolgozoId;
    }

    public JobDto getNewBeosztasId() {
        return newBeosztasId;
    }

    public void setNewBeosztasId(JobDto newBeosztasId) {
        this.newBeosztasId = newBeosztasId;
    }
}
