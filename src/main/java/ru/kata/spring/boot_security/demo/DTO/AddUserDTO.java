package ru.kata.spring.boot_security.demo.DTO;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Objects;

public class AddUserDTO {
    private String username;

    private String password;
    private Integer age;
    private String city;
    private List<Role> roles;

    public AddUserDTO(String username, Integer age, String city, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.city = city;
        this.roles = roles;
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
        AddUserDTO that = (AddUserDTO) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(age, that.age) && Objects.equals(city, that.city) && Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, age, city, roles);
    }

    @Override
    public String toString() {
        return "AddUserModel{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", roles=" + roles +
                '}';
    }
}
