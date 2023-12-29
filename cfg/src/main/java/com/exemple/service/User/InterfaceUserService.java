package com.exemple.service.User;

import com.exemple.entity.User;

import java.util.List;

public interface InterfaceUserService {

    public List<User> getUsers();
    public User GitUserById(long id);
    public User ModUser(long id,String name,String Prenom ,String password,String rolle,String email);
    public void DeleUser(long id);
    public User AddUser(String name,String Prenom ,String password,String rolle,String email);

}
