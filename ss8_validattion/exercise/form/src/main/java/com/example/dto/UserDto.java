package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import java.util.regex.Pattern;

public class UserDto implements Validator {
    private String firstname;
    private String lastname;
    private String phoneNumber;
    private int age;
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(String firstname, String lastname, String phoneNumber, int age, String email) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto user = (UserDto) target;
        if (user.firstname.length() < 5 || user.firstname.length() > 45) {
            errors.rejectValue("firstname", "xxx", "must be more than 5 and less than 45 character");
        }
        if (user.lastname.length() < 5 || user.lastname.length() > 45) {
            errors.rejectValue("lastname", "xxx", "must be more than 5 and less than 45 character");
        }
        if (!Pattern.matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$", user.phoneNumber)) {
            errors.rejectValue("phoneNumber", "xxx", "phone number illegal");
        }
        try{
            if (user.age < 18) {
                errors.rejectValue("age", "xxx", "age must be more than 18");
            }
        }catch (NumberFormatException e){
            errors.rejectValue("age", "xxx", "age must be more than 18");
        }
    }
}
