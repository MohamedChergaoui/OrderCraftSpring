package com.exemple.service.User;

import com.exemple.entity.User;
import com.exemple.repository.InterfaceUserRepository;
import com.exemple.service.User.InterfaceUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService implements InterfaceUserService {

    @Autowired
    private InterfaceUserRepository interfaceUserRepository;

    @Override
    @Transactional
    public List<User> getUsers() {
        return interfaceUserRepository.findAll();
    }

    @Override
    public User GitUserById(long id ) {
        return interfaceUserRepository.findById( id);
    }

    @Override
    public User ModUser(long id,String name,String Prenom ,String password,String rolle,String email) {
       User user= interfaceUserRepository.findById(id);
       user.setEmail(email);
       user.setName(name);
       user.setPrenom(Prenom);
       user.setModdepass(password);
       user.setRole(rolle);
        return interfaceUserRepository.save(user);
    }

    @Override
    public void  DeleUser(long id) {

        interfaceUserRepository.deleteById(id);
    }

    @Override
    public User AddUser(String name, String Prenom, String password, String rolle, String email) {
        User user = new User();
        user.setRole(rolle);
        user.setPrenom(Prenom);
        user.setEmail(email);
        user.setName(name);
        user.setModdepass(password);
        return interfaceUserRepository.save(user);
    }
}
