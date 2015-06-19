package com.olegchir.fadeok.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by olegchir on 19.06.2015.
 */
@Entity
public class FadeokUser {
    @Id
    @GeneratedValue
    public long id;
    @Basic
    public String name;
    @OneToMany(mappedBy = "user")
    public List<FadeokTask> tasks;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTasks(List<FadeokTask> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public List<FadeokTask> getTasks() {
        return tasks;
    }
}
