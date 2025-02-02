package com.TwinLine.Blogsite.payload;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDto {
    private int id;
    @NotEmpty
    @Size(min=4, message = "Username must be minimum of 4 characters")
    private String name;

    @NotEmpty

    @Email(message = "Email address is not valid")
    private String email;

    @NotEmpty
    @Size(min=4, max=10,message = "Password must be of min 3 chars and max 10 chars")
    private String password;
    @NotNull
    private int age;
    @NotEmpty
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
