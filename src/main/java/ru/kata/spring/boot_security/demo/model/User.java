package ru.kata.spring.boot_security.demo.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String city;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    public User() {
    }

    public User(String username, Integer age, String city) {
        this.username = username;
        this.age = age;
        this.city = city;
    }


    public User(Long id, String username, Integer age, String city) {
        this.id = id;
        this.username = username;
        this.age = age;
        this.city = city;
    }

    public User(String username, String password, Integer age, String city, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.city = city;
        this.roles = roles;
    }
    public User(Long id, String username, String city, Integer age, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.city = city;
    }

    public User(Long id, String username, String city, Integer age, String password, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.city = city;
        this.roles = roles;
    }

    public String rolesToString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for (var el : roles) {
            stringJoiner.add(el.getName().substring(5));
        }
        return stringJoiner.toString();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(age, user.age) && Objects.equals(city, user.city) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, age, city, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", roles=" + roles +
                '}';
    }
}
