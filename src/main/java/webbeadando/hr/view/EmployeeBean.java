package webbeadando.hr.view;

import webbeadando.hr.service.EmployeeService;
import webbeadando.hr.service.domain.EmployeeDto;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named(value = "employeeBean")
@ViewScoped
public class EmployeeBean implements Serializable {

    @Inject
    EmployeeService employeeService;

    private List<EmployeeDto> employeeDtos;
    private EmployeeDto selectedDto = new EmployeeDto();

    private String newVezeteknev;
    private String newKeresztnev;
    private String newSzuletesiDatum;
    private String newLakcim;
    private String newAnyjaNeve;

    @PostConstruct
    private void init(){
        employeeDtos = employeeService.findAll();
        newVezeteknev = null;
        newKeresztnev = null;
        newSzuletesiDatum = null;
        newLakcim = null;
        newAnyjaNeve = null;
    }

    public void addEmployee(){
        EmployeeDto employee = new EmployeeDto();
        employee.setVezeteknev(newVezeteknev);
        employee.setKeresztnev(newKeresztnev);
        employee.setSzuletesiDatum(newSzuletesiDatum);
        employee.setLakcim(newLakcim);
        employee.setAnyjaNeve(newAnyjaNeve);
        employeeService.save(employee);
        init();
    }

    public void onRowSelect() {
        newVezeteknev = selectedDto.getVezeteknev();
        newKeresztnev = selectedDto.getKeresztnev();
        newSzuletesiDatum = selectedDto.getSzuletesiDatum();
        newLakcim = selectedDto.getLakcim();
        newAnyjaNeve = selectedDto.getAnyjaNeve();
    }

    public void modifyEmployee() {
        selectedDto.setVezeteknev(newVezeteknev);
        selectedDto.setKeresztnev(newKeresztnev);
        selectedDto.setSzuletesiDatum(newSzuletesiDatum);
        selectedDto.setLakcim(newLakcim);
        selectedDto.setAnyjaNeve(newAnyjaNeve);
        employeeService.modify(selectedDto);
        init();
    }

    public void deleteEmployee() {
        employeeService.delete(selectedDto);
        init();
    }


    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<EmployeeDto> getEmployeeDtos() {
        return employeeDtos;
    }

    public void setEmployeeDtos(List<EmployeeDto> employeeDtos) {
        this.employeeDtos = employeeDtos;
    }

    public EmployeeDto getSelectedDto() {
        return selectedDto;
    }

    public void setSelectedDto(EmployeeDto selectedDto) {
        this.selectedDto = selectedDto;
    }

    public String getNewVezeteknev() {
        return newVezeteknev;
    }

    public void setNewVezeteknev(String newVezeteknev) {
        this.newVezeteknev = newVezeteknev;
    }

    public String getNewKeresztnev() {
        return newKeresztnev;
    }

    public void setNewKeresztnev(String newKeresztnev) {
        this.newKeresztnev = newKeresztnev;
    }

    public String getNewSzuletesiDatum() {
        return newSzuletesiDatum;
    }

    public void setNewSzuletesiDatum(String newSzuletesiDatum) {
        this.newSzuletesiDatum = newSzuletesiDatum;
    }

    public String getNewLakcim() {
        return newLakcim;
    }

    public void setNewLakcim(String newLakcim) {
        this.newLakcim = newLakcim;
    }

    public String getNewAnyjaNeve() {
        return newAnyjaNeve;
    }

    public void setNewAnyjaNeve(String newAnyjaNeve) {
        this.newAnyjaNeve = newAnyjaNeve;
    }
}
