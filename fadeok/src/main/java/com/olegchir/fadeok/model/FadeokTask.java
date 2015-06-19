package com.olegchir.fadeok.model;

import javax.persistence.*;

/**
 * Created by olegchir on 19.06.2015.
 */
@Entity
public class FadeokTask {
    @Id @GeneratedValue()
    public long id;

    @Basic
    public String text;

    @Basic
    public boolean completed;

    @ManyToOne
    public FadeokUser user;

    public String getText() {
        return text;
    }

    public long getId() {
        return id;
    }

    public FadeokUser getUser() {
        return user;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
