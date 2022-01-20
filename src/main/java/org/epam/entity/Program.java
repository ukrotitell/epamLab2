package org.epam.entity;

import java.util.List;

public class Program {
    private List<Program> programs;
    private int id;
    private String name;
    private List<Module> modules;

    public Program() {
    }

    public Program(int id, String name, List<Module> modules) {
        this.id = id;
        this.name = name;
        this.modules = modules;
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

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<Program> getPrograms() {
        return programs;
    }

    public void setPrograms(List<Program> programs) {
        this.programs = programs;
    }

    @Override
    public String toString() {
        return "Program{" +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", modules=" + modules +
                '}';
    }
}

