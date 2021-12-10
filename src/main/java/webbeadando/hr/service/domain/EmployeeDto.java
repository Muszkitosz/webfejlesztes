package webbeadando.hr.service.domain;

import java.util.Objects;

public class EmployeeDto {

    private Long dolgozoId;
    private String vezeteknev;
    private String keresztnev;
    private String szuletesiDatum;
    private String lakcim;
    private String anyjaNeve;

    public EmployeeDto() {
    }

    public EmployeeDto(Long dolgozoId, String vezeteknev, String keresztnev, String szuletesiDatum, String lakcim, String anyjaNeve) {
        this.dolgozoId = dolgozoId;
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        this.szuletesiDatum = szuletesiDatum;
        this.lakcim = lakcim;
        this.anyjaNeve = anyjaNeve;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(dolgozoId, that.dolgozoId) && Objects.equals(vezeteknev, that.vezeteknev) && Objects.equals(keresztnev, that.keresztnev) && Objects.equals(szuletesiDatum, that.szuletesiDatum) && Objects.equals(lakcim, that.lakcim) && Objects.equals(anyjaNeve, that.anyjaNeve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dolgozoId, vezeteknev, keresztnev, szuletesiDatum, lakcim, anyjaNeve);
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "dolgozoId=" + dolgozoId +
                ", vezeteknev='" + vezeteknev + '\'' +
                ", keresztnev='" + keresztnev + '\'' +
                ", szuletesiDatum='" + szuletesiDatum + '\'' +
                ", lakcim='" + lakcim + '\'' +
                ", anyjaNeve='" + anyjaNeve + '\'' +
                '}';
    }
}
