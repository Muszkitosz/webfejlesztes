package webbeadando.hr.persistence.entitymanager;

import webbeadando.hr.persistence.entity.Employee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmployeeDao {

    @PersistenceContext(unitName = "msSqlConn")
    protected EntityManager em;

    public void save(Employee t) {
        em.merge(t);
        em.flush();
    }

    public void delete(Employee t) {
        em.remove(t);
    }

    public Employee findOne(Long dolgozo_id) {
        return em.find(Employee.class, dolgozo_id);
    }

    public List<Employee> findAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }
}
