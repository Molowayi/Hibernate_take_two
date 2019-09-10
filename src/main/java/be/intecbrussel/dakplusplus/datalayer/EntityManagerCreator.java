package be.intecbrussel.dakplusplus.datalayer;

import javax.persistence.*;

public class EntityManagerCreator {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("thordb2");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}

