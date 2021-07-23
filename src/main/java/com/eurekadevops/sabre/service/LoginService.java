package com.eurekadevops.sabre.service;

import com.eurekadevops.sabre.entity.Group;
import com.eurekadevops.sabre.entity.Login;
import com.eurekadevops.sabre.repository.EmployeeRepository;
import com.eurekadevops.sabre.repository.GroupRepository;
import com.eurekadevops.sabre.repository.LoginRepository;
import com.eurekadevops.sabre.web.dto.Dto;
import com.eurekadevops.sabre.web.dto.LoginNewDto;
import com.eurekadevops.sabre.web.errors.LoginNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService, CrudService<Login> {
    
    @Autowired
    private LoginRepository loginRepository;
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private GroupRepository groupRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    private Logger logger = LoggerFactory.getLogger(LoginService.class);

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login login = loginRepository.findByUsername(username);
        
        if (login == null)
            throw new UsernameNotFoundException("Username not found");
        
        return new User(login.getUsername(), login.getPassword(), mapGroupToAuthorities(login.getGroup()));
    }
    
    private Collection<? extends GrantedAuthority> mapGroupToAuthorities(Group group) {
        return group.getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getName())).collect(Collectors.toList());
    }

    @Override
    public List<Login> getAll() {
        return loginRepository.findAll();
    }

    @Override
    public Login getOne(Long id) throws RuntimeException {
        return loginRepository.findById(id).orElseThrow(() -> new LoginNotFoundException(String.format("Login with id '%d'", id)));
    }

    @Override
    public Dto getNewDto() throws RuntimeException {
        LoginNewDto loginDto = new LoginNewDto();
        
        loginDto.setEmployees(employeeRepository.findAll());
        loginDto.setGroups(groupRepository.findAll());
        
        return loginDto;
    }

    @Override
    public Dto getUpdateDto(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Login login) {
        loginRepository.save(login);
    }

    @Override
    public void save(Dto dto) {
        LoginNewDto loginNewDto = (LoginNewDto) dto;
        Login login = new Login();
        
        login.setUsername(loginNewDto.getUsername());
        login.setPassword(passwordEncoder.encode(loginNewDto.getPassword()));
        login.setEmployee(employeeRepository.getOne(loginNewDto.getEmployeeId()));
        login.setGroup(groupRepository.getOne(loginNewDto.getGroupId()));
        
        loginRepository.save(login);
    }

    @Override
    public void delete(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Login t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Dto dto) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
