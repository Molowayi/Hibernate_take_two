package be.intecbrussel.dakplusplus.datalayer;

import javax.persistence.*;

public class EntityManagerCreator {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("action_is_update");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

}

