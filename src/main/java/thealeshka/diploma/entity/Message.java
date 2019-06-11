package thealeshka.diploma.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Message() {
    }

    public Message(String text, Date date, Person person) {
        this.text = text;
        this.date = date;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(id, message.id) &&
                Objects.equals(text, message.text) &&
                Objects.equals(date, message.date) &&
                Objects.equals(person, message.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text, date, person);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", date=" + date +
                ", person=" + person +
                '}';
    }
}