package com.exemple.service.Login;

import com.exemple.entity.User;

public interface ILogin {
    public User Login(String email, String password);
}
