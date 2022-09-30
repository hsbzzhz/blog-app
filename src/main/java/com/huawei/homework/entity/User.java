package com.huawei.homework.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.huawei.homework.utils.GenderCheck;

import javax.validation.constraints.*;
import java.io.Serializable;

@TableName("t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    @Pattern(regexp = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+$", message = "邮箱格式错误")
    private String email;
    @GenderCheck
    private String gender;
    private String birth;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birth='" + birth + '\'' +
                '}';
    }
}
