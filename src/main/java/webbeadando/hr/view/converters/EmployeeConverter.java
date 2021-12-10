package webbeadando.hr.view.converters;

import webbeadando.hr.service.EmployeeService;
import webbeadando.hr.service.domain.EmployeeDto;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@FacesConverter(value = "employeeTConverter", managed = true)
public class EmployeeConverter implements Converter {

    @Inject
    EmployeeService employeeService;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return findOneById(employeeService.findAll(),Long.valueOf(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    public EmployeeDto findOneById(List<EmployeeDto> list, Long id){
        for(EmployeeDto dto: list){
            if(dto.getDolgozoId().equals(id))
                return dto;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((EmployeeDto) object).getDolgozoId());
        }
        else {
            return null;
        }
    }
}
