package com.gestionstock.gero.Service;

import com.gestionstock.gero.Repository.RoleRepository;
import com.gestionstock.gero.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;


    public List<Role> ListRole(){
        return roleRepository.findAll();
    }

    public Optional<Role> getRoleUser(Integer id){
        return roleRepository.findById(id);
    }

}
