package org.epam;


import lombok.Data;

import java.util.List;
@Data
public class Program {
    private int id;
    private String name;
    private List<Module> modules;

    public Program(int id, String name, List<Module> modules) {
        this.id = id;
        this.name = name;
        this.modules = modules;
    }

    public Program() {
    }
}

