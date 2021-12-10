package webbeadando.hr.persistence.entitymanager;

import webbeadando.hr.persistence.entity.Job;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class JobDao {

    @PersistenceContext(unitName = "msSqlConn")
    protected EntityManager em;

    public void save(Job t) {
        em.merge(t);
        em.flush();
    }

    public void delete(Job t) {
        em.remove(t);
    }

    public Job findOne(Long beosztas_id) {
        return em.find(Job.class, beosztas_id);
    }

    public List<Job> findAll() {
        return em.createNamedQuery("Job.findAll", Job.class).getResultList();
    }
}
