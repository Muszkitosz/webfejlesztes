package webbeadando.hr.service.domain;

import java.util.Objects;

public class JobDto {

    private Long beosztasId;
    private String beosztasNev;
    private String rovidLeiras;

    public JobDto() {
    }

    public JobDto(Long beosztasId, String beosztasNev, String rovidLeiras) {
        this.beosztasId = beosztasId;
        this.beosztasNev = beosztasNev;
        this.rovidLeiras = rovidLeiras;
    }

    public Long getBeosztasId() {
        return beosztasId;
    }

    public void setBeosztasId(Long beosztasId) {
        this.beosztasId = beosztasId;
    }

    public String getBeosztasNev() {
        return beosztasNev;
    }

    public void setBeosztasNev(String beosztasNev) {
        this.beosztasNev = beosztasNev;
    }

    public String getRovidLeiras() {
        return rovidLeiras;
    }

    public void setRovidLeiras(String rovidLeiras) {
        this.rovidLeiras = rovidLeiras;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobDto jobDto = (JobDto) o;
        return Objects.equals(beosztasId, jobDto.beosztasId) && Objects.equals(beosztasNev, jobDto.beosztasNev) && Objects.equals(rovidLeiras, jobDto.rovidLeiras);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beosztasId, beosztasNev, rovidLeiras);
    }

    @Override
    public String toString() {
        return "JobDto{" +
                "beosztasId=" + beosztasId +
                ", beosztasNev='" + beosztasNev + '\'' +
                ", rovidLeiras='" + rovidLeiras + '\'' +
                '}';
    }
}
