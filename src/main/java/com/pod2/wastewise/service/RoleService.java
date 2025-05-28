package com.pod2.wastewise.service;

import com.pod2.wastewise.exception.RoleDoesNotExistException;
import com.pod2.wastewise.model.Role;
import com.pod2.wastewise.model.Worker;
import com.pod2.wastewise.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService {

    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    /**
     * Finds the existing role
     * Trows exception if role is not found
     * @param id
     * @return role
     * @throws RoleDoesNotExistException
     */
    public Role findRole(String id) throws RoleDoesNotExistException {
        logger.info("Finding role with id {}",id);
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isEmpty()){
            throw new RoleDoesNotExistException ("Role with id " + id + " and Role type " + optionalRole.get().getRole() + " does not exist");
        }
        logger.info("Found role with id {} ", id);
        return optionalRole.get();
    }

//    public List<Worker> findWorkersWithRoleType(String RoleType){
//
//    }
}
