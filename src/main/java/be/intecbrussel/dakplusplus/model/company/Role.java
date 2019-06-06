package be.intecbrussel.dakplusplus.model.company;

public enum Role {
    WORKER(25),
    ADMINISTRATIVE(25),
    TEAM_LEADER(35),
    MANAGER(50);

    private float hour_wage;

    Role(float hour_wage) {
        this.hour_wage = hour_wage;
    }

    public float getHour_wage() {
        return hour_wage;
    }
}
