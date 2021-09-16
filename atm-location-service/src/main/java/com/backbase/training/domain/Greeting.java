package com.backbase.training.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This is to test if I'm doing stuff the way I should be doing
 */
@Entity
@Table(name = "greetings")
public class Greeting {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "message")
    private String message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
