package ru.kata.spring.boot_security.demo.DTO;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Objects;
/**
 * Класс - промежуточное звено, мнежду request body и entity User
 * */
public class EditUserDTO {
    private Long id;

    private String username;

    private String password;
    private Integer age;
    private String city;
    private List<Role> roles;


    public EditUserDTO(Long id, String username, String password, Integer age, String city, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.city = city;
        this.roles = roles;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        EditUserDTO userModel = (EditUserDTO) o;
        return Objects.equals(id, userModel.id) && Objects.equals(username, userModel.username) && Objects.equals(password, userModel.password) && Objects.equals(age, userModel.age) && Objects.equals(city, userModel.city) && Objects.equals(roles, userModel.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, age, city, roles);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", roles=" + roles +
                '}';
    }
}
