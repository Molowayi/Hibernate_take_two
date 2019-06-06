package be.intecbrussel.dakplusplus.datalayer;

import be.intecbrussel.dakplusplus.model.company.Employee;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeRepository {

    private final EntityManager em;

    public EmployeeRepository() {
        this.em = EntityManagerCreator.getEntityManager();
    }

    // CREATE
    public Employee createEmployee(Employee employee) {
        return persistEmployee(employee);
    }

    // UPDATE
    public Employee updateEmployee(Employee employee) throws BadMethodCallException {
        if (employee.getId() == 0) throw new BadMethodCallException("There was an problem with the database");
        return persistEmployee(employee);
    }

    // DELETE
    public Employee deleteEmployee(Employee employee) {
        em.getTransaction().begin();
        em.remove(employee);
        em.getTransaction().commit();

        return employee;
    }

    // READ AND FILTER
    public Employee readEmployee(long id) {
        return em.find(Employee.class, id);
    }

    private Employee persistEmployee(Employee employee) {
        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();
        return employee;
    }

    // GET LIST EMPLOYEE
    public List<Employee> getListEmployee() {
        TypedQuery<Employee> query = em.createQuery("select e from Employee  as e", Employee.class);
        return query.getResultList();
    }

    //  GET ACTIVE EMPLOYEE
    public List<Employee> getActiveEmployee() {
        TypedQuery<Employee> query = em.createQuery("select e from Employee  as p", Employee.class);
        return query.getResultList();
    }
}
