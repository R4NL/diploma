package thealeshka.diploma.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person", cascade = CascadeType.ALL)
    private List<Message> list;

    public Person() {
    }

    public Person(String userName, String password) {
        this.userName = userName;
        this.password = password;
        list = new ArrayList<>();
    }

    public Person(String userName, String password, List<Message> list) {
        this.userName = userName;
        this.password = password;
        this.list = list;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getList() {
        return list;
    }

    public void setList(List<Message> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(userName, person.userName) &&
                Objects.equals(password, person.password) &&
                Objects.equals(list, person.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, password, list);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", list=" + list +
                '}';
    }
}
