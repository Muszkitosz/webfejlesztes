package webbeadando.hr.persistence.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "job", schema = "hr")
@NamedQuery(name = "Job.findAll", query = "select job from Job job")
public class Job implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beosztas_id")
    private Long beosztasId;
    @Column(name = "beosztas_neve")
    private String beosztasNev;
    @Column(name = "rovid_leiras")
    private String rovidLeiras;

    @OneToMany(mappedBy="beosztasId", fetch = FetchType.LAZY)
    private List<EmployeeJob> employeeJobList;

    public Job() {
    }

    public Job(Long beosztasId, String beosztasNev, String rovidLeiras, List<EmployeeJob> employeeJobList) {
        this.beosztasId = beosztasId;
        this.beosztasNev = beosztasNev;
        this.rovidLeiras = rovidLeiras;
        this.employeeJobList = employeeJobList;
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

    public List<EmployeeJob> getEmployeeJobList() {
        return employeeJobList;
    }

    public void setEmployeeJobList(List<EmployeeJob> employeeJobList) {
        this.employeeJobList = employeeJobList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return Objects.equals(beosztasId, job.beosztasId) && Objects.equals(beosztasNev, job.beosztasNev) && Objects.equals(rovidLeiras, job.rovidLeiras) && Objects.equals(employeeJobList, job.employeeJobList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(beosztasId, beosztasNev, rovidLeiras, employeeJobList);
    }

    @Override
    public String toString() {
        return "Job{" +
                "beosztasId=" + beosztasId +
                ", beosztasNev='" + beosztasNev + '\'' +
                ", rovidLeiras='" + rovidLeiras + '\'' +
                ", employeeJobList=" + employeeJobList +
                '}';
    }
}
