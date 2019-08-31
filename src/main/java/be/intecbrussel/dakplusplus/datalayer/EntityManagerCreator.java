package be.intecbrussel.dakplusplus.datalayer;

import javax.persistence.*;

public class EntityManagerCreator {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("thordbH2");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}

