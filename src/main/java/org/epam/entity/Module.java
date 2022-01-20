package org.epam.entity;

public class Module {

    private int id;
    private int programId;
    private String name;
    private int duration;

    public Module() {
    }

    public Module(int id, int programId, String name, int duration) {
        this.id = id;
        this.programId = programId;
        this.name = name;
        this.duration = duration;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                "," +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                '}';
    }
}

