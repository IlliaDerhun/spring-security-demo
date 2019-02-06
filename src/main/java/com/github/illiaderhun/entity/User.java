package com.github.illiaderhun.entity;

import com.github.illiaderhun.validation.PasswordMatches;
import com.github.illiaderhun.validation.ValidEmail;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@PasswordMatches
public class User {

    @NotNull
    @NotEmpty
    private String firstName;

    @NotNull
    @NotEmpty
    private String lastName;

    @NotNull
    @NotEmpty
    private String password;

    private String matchingPassword;

    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

    public User() {
    }

    public User(@NotNull @NotEmpty String firstName, @NotNull @NotEmpty String lastName,
                @NotNull @NotEmpty String password, String matchingPassword, @NotNull @NotEmpty String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.matchingPassword = matchingPassword;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User dto = (User) o;
        return Objects.equals(firstName, dto.firstName) && Objects.equals(lastName, dto.lastName) && Objects
            .equals(password, dto.password) && Objects.equals(matchingPassword, dto.matchingPassword) && Objects
                   .equals(email, dto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, password, matchingPassword, email);
    }

    @Override
    public String toString() {
        return "User{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", password='" + password
               + '\'' + ", matchingPassword='" + matchingPassword + '\'' + ", email='" + email + '\'' + '}';
    }
}
