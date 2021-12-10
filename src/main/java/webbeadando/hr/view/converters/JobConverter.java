package webbeadando.hr.view.converters;

import webbeadando.hr.service.JobService;
import webbeadando.hr.service.domain.JobDto;

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
@FacesConverter(value = "jobTConverter", managed = true)
public class JobConverter implements Converter {

    @Inject
    JobService jobService;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if(value != null && value.trim().length() > 0) {
            try {
                return findOneById(jobService.findAll(),Long.valueOf(value));
            } catch(NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        }
        else {
            return null;
        }
    }

    public JobDto findOneById(List<JobDto> list, Long id){
        for(JobDto dto: list){
            if(dto.getBeosztasId().equals(id))
                return dto;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if(object != null) {
            return String.valueOf(((JobDto) object).getBeosztasId());
        }
        else {
            return null;
        }
    }
}
