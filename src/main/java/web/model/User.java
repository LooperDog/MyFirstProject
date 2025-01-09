package web.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Surname")
    private String Surname;

    @Column(name = "age")
    private Integer age;


    public User() {
    }

    public User(Long id, String name, String surname, Integer age) {
        this.id = id;
        Name = name;
        Surname = surname;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(Name, user.Name) &&
                Objects.equals(Surname, user.Surname) &&
                Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}