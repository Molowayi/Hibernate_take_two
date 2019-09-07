package be.intecbrussel.dakplusplus.datalayer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericEntityRepository<E> {

    private final EntityManager em;
    private final Class<E> entityClass;

    public GenericEntityRepository() {
        this.em = EntityManagerCreator.getEntityManager();
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    // CREATE
    public E createEntity(E e) {
        return persistEntity(e);
    }

    // UPDATE
    public void updateEntity(E e) throws BadMethodCallException {
        try {
            persistEntity(e);
        } catch (Exception ex) {
            throw new BadMethodCallException("There was an problem with the database" + ex.getMessage());
        }
    }

    // DELETE
    public E deleteEntity(E e) {
        em.getTransaction().begin();
        em.remove(e);
        em.getTransaction().commit();

        return e;
    }

    //  READ AND FILTER
    public E readEntity(long id) {
        return (E) em.find(this.entityClass, id);
    }

    private E persistEntity(E e) {
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        return e;
    }

    public List<E> getListEntity() {
        TypedQuery<E> query = em.createQuery("select e from " + entityClass.getName() + "as e", this.entityClass);
        return query.getResultList();
    }
}
