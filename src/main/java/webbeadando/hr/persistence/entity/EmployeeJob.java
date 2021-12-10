package webbeadando.hr.persistence.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employee_job", schema = "hr")
@NamedQuery(name = "EmployeeJob.findAll", query = "select employeeJob from EmployeeJob employeeJob")
public class EmployeeJob implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dolgozo_beosztas_id")
    private Long dolgozoBeosztasId;
    @JoinColumn(name = "dolgozo_id", referencedColumnName = "dolgozo_id")
    private Employee dolgozoId;
    @JoinColumn(name = "beosztas_id", referencedColumnName = "beosztas_id")
    private Job beosztasId;
    @Column(name = "felvetel_datum")
    private Date felvetelDatum;

    public EmployeeJob() {
    }

    public EmployeeJob(Long dolgozoBeosztasId, Employee dolgozoId, Job beoasztasId, Date felvetelDatum) {
        this.dolgozoBeosztasId = dolgozoBeosztasId;
        this.dolgozoId = dolgozoId;
        this.beosztasId = beoasztasId;
        this.felvetelDatum = felvetelDatum;
    }

    public Long getDolgozoBeosztasId() {
        return dolgozoBeosztasId;
    }

    public void setDolgozoBeosztasId(Long dolgozoBeosztasId) {
        this.dolgozoBeosztasId = dolgozoBeosztasId;
    }

    public Employee getDolgozoId() {
        return dolgozoId;
    }

    public void setDolgozoId(Employee dolgozoId) {
        this.dolgozoId = dolgozoId;
    }

    public Job getBeosztasId() {
        return beosztasId;
    }

    public void setBeosztasId(Job beosztasId) {
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
        EmployeeJob that = (EmployeeJob) o;
        return Objects.equals(dolgozoBeosztasId, that.dolgozoBeosztasId) && Objects.equals(dolgozoId, that.dolgozoId) && Objects.equals(beosztasId, that.beosztasId) && Objects.equals(felvetelDatum, that.felvetelDatum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dolgozoBeosztasId, dolgozoId, beosztasId, felvetelDatum);
    }

    @Override
    public String toString() {
        return "EmployeeJob{" +
                "dolgozoBeosztasId=" + dolgozoBeosztasId +
                ", dolgozoId=" + dolgozoId +
                ", beosztasId=" + beosztasId +
                ", felvetelDatum=" + felvetelDatum +
                '}';
    }
}
