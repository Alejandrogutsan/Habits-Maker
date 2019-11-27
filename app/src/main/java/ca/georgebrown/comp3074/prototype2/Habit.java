package ca.georgebrown.comp3074.prototype2;

public class Habit {
    private String name;
    private String type;
    private int day_count;

    public Habit(String name, String type, int day_count) {
        this.name = name;
        this.type = type;
        this.day_count = day_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDay_count() {
        return day_count;
    }

    public void setDay_count(int day_count) {
        this.day_count = day_count;
    }
}
