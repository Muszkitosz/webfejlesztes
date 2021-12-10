package webbeadando.hr.persistence.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "employee", schema = "hr")
@NamedQuery(name = "Employee.findAll", query = "select employee from Employee employee")
public class Employee implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dolgozo_id")
    private Long dolgozoId;
    @Column(name = "vezeteknev")
    private String vezeteknev;
    @Column(name = "keresztnev")
    private String keresztnev;
    @Column(name = "szuletesi_datum")
    private String szuletesiDatum;
    @Column(name = "lakcim")
    private String lakcim;
    @Column(name = "anyja_neve")
    private String anyjaNeve;


    @OneToMany(mappedBy="dolgozoId", fetch = FetchType.LAZY)
    private List<EmployeeJob> employeeJobList;

    public Employee() {
    }

    public Employee(Long dolgozoId, String vezeteknev, String keresztnev, String szuletesiDatum, String lakcim, String anyjaNeve, List<EmployeeJob> employeeJobList) {
        this.dolgozoId = dolgozoId;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.szuletesiDatum = szuletesiDatum;
        this.lakcim = lakcim;
        this.anyjaNeve = anyjaNeve;
        this.employeeJobList = employeeJobList;
    }

    public Long getDolgozoId() {
        return dolgozoId;
    }

    public void setDolgozoId(Long dolgozoId) {
        this.dolgozoId = dolgozoId;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public String getSzuletesiDatum() {
        return szuletesiDatum;
    }

    public void setSzuletesiDatum(String szuletesiDatum) {
        this.szuletesiDatum = szuletesiDatum;
    }

    public String getLakcim() {
        return lakcim;
    }

    public void setLakcim(String lakcim) {
        this.lakcim = lakcim;
    }

    public String getAnyjaNeve() {
        return anyjaNeve;
    }

    public void setAnyjaNeve(String anyjaNeve) {
        this.anyjaNeve = anyjaNeve;
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
        Employee employee = (Employee) o;
        return Objects.equals(dolgozoId, employee.dolgozoId) && Objects.equals(vezeteknev, employee.vezeteknev) && Objects.equals(keresztnev, employee.keresztnev) && Objects.equals(szuletesiDatum, employee.szuletesiDatum) && Objects.equals(lakcim, employee.lakcim) && Objects.equals(anyjaNeve, employee.anyjaNeve) && Objects.equals(employeeJobList, employee.employeeJobList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dolgozoId, vezeteknev, keresztnev, szuletesiDatum, lakcim, anyjaNeve, employeeJobList);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "dolgozoId=" + dolgozoId +
                ", vezeteknev='" + vezeteknev + '\'' +
                ", keresztnev='" + keresztnev + '\'' +
                ", szuletesiDatum='" + szuletesiDatum + '\'' +
                ", lakcim='" + lakcim + '\'' +
                ", anyjaNeve='" + anyjaNeve + '\'' +
                ", employeeJobList=" + employeeJobList +
                '}';
    }
}
