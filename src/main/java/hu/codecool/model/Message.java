package hu.codecool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String value;

    // Need to ignore for JSON serialization to work, because
    // this is a circular reference: user has messages, each message points
    // to a user, which are in turn link to a user and so on.
    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Message() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
