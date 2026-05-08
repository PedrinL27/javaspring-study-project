package com.pedro.coursespring.dto.insert;

import java.io.Serializable;

public class UserInsertDTO implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private String name;
    private String email;
    private String phone;
    private String password;
    
    public UserInsertDTO(String name, String email, String phone, String password) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    
}
