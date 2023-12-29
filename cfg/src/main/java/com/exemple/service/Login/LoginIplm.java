package com.exemple.service.Login;

import com.exemple.entity.User;
import com.exemple.repository.InterfaceUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class LoginIplm implements ILogin{
    @Autowired
    private InterfaceUserRepository interfaceUserRepository;
    @Override
    @Transactional
    public User Login( String email,String password) {

        return  interfaceUserRepository.findUserByEmailAndModdepass(email,password);
    }
}
