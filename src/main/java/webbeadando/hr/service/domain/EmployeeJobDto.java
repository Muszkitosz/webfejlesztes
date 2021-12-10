package webbeadando.hr.service.domain;

import java.util.Date;
import java.util.Objects;

public class EmployeeJobDto {

    private Long dolgozoBeosztasId;
    private EmployeeDto dolgozoId;
    private JobDto beosztasId;
    private Date felvetelDatum;

    public EmployeeJobDto() {
    }

    public EmployeeJobDto(Long dolgozoBeosztasId, EmployeeDto dolgozoId, JobDto beosztasId, Date felvetelDatum) {
        this.dolgozoBeosztasId = dolgozoBeosztasId;
        this.dolgozoId = dolgozoId;
        this.beosztasId = beosztasId;
        this.felvetelDatum = felvetelDatum;
    }

    public Long getDolgozoBeosztasId() {
        return dolgozoBeosztasId;
    }

    public void setDolgozoBeosztasId(Long dolgozoBeosztasId) {
        this.dolgozoBeosztasId = dolgozoBeosztasId;
    }

    public EmployeeDto getDolgozoId() {
        return dolgozoId;
    }

    public void setDolgozoId(EmployeeDto dolgozoId) {
        this.dolgozoId = dolgozoId;
    }

    public JobDto getBeosztasId() {
        return beosztasId;
    }

    public void setBeosztasId(JobDto beosztasId) {
        this.beosztasId = beosztasId;
    }

    public Date getFelvetelDatum() {
        return felvetelDatum;
    }

    public void setFelvetelDatum(Date felvetelDatum) {
        this.felvetelDatum = felvetelDatum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeJobDto that = (EmployeeJobDto) o;
        return Objects.equals(dolgozoBeosztasId, that.dolgozoBeosztasId) && Objects.equals(dolgozoId, that.dolgozoId) && Objects.equals(beosztasId, that.beosztasId) && Objects.equals(felvetelDatum, that.felvetelDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dolgozoBeosztasId, dolgozoId, beosztasId, felvetelDatum);
    }

    @Override
    public String toString() {
        return "EmployeeJobDto{" +
                "dolgozoBeosztasId=" + dolgozoBeosztasId +
                ", dolgozoId=" + dolgozoId +
                ", beosztasId=" + beosztasId +
                ", felvetelDatum=" + felvetelDatum +
                '}';
    }
}
