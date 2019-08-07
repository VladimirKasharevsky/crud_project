package org.mentor.selfProj.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UsersDataSet implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true, updatable = false)
    private String name;

    @Column(name = "password", updatable = false)
    private String password;

    public UsersDataSet() {
    }

    public UsersDataSet(long id, String name, String password) {
        this.setId(id);
        this.setName(name);
        this.setPassword(password);
    }

    public UsersDataSet(String name, String password) {
        this.setId(-1);
        this.setName(name);
        this.setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}