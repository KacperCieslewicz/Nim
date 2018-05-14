package models;

public class Player {
    private String name;
    private Boolean waiting;

    public Player(String name, Boolean waiting) {
        this.name = name;
        this.waiting = waiting;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getWaiting() {
        return waiting;
    }

    public void setWaiting(Boolean waiting) {
        this.waiting = waiting;
    }
}
