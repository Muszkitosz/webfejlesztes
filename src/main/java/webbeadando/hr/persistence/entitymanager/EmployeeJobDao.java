package webbeadando.hr.persistence.entitymanager;


import webbeadando.hr.persistence.entity.EmployeeJob;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class EmployeeJobDao {

    @PersistenceContext(unitName = "msSqlConn")
    protected EntityManager em;

    public void save(EmployeeJob t) {
        em.merge(t);
        em.flush();
    }

    public EmployeeJob findOne(Long dolgozo_beosztas_id) {
        return em.find(EmployeeJob.class, dolgozo_beosztas_id);
    }

    public List<EmployeeJob> findAll() {
        return em.createNamedQuery("EmployeeJob.findAll", EmployeeJob.class).getResultList();
    }

    public EmployeeJob saveAsReturn(EmployeeJob t) {
        EmployeeJob savedEmployeeJob = em.merge(t);
        em.flush();

        return savedEmployeeJob;
    }
}
