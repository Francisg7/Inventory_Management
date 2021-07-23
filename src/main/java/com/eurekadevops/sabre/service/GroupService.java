package com.eurekadevops.sabre.service;

import com.eurekadevops.sabre.entity.Group;
import com.eurekadevops.sabre.repository.GroupRepository;
import com.eurekadevops.sabre.repository.PermissionRepository;
import com.eurekadevops.sabre.web.dto.Dto;
import com.eurekadevops.sabre.web.dto.GroupNewDto;
import com.eurekadevops.sabre.web.errors.GroupNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupService implements CrudService<Group> {
    
    @Autowired
    private GroupRepository groupRepository;
    
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Group> getAll() {
        return groupRepository.findAll();
    }

    @Override
    public Group getOne(Long id) throws RuntimeException {
        return groupRepository.findById(id).orElseThrow(() -> new GroupNotFoundException(String.format("Group with id '%d' not found", id)));
    }

    @Override
    public Dto getNewDto() throws RuntimeException {
        return new GroupNewDto();
    }

    @Override
    public Dto getUpdateDto(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void save(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void save(Dto dto) {
        GroupNewDto groupNewDto = (GroupNewDto) dto;
        
        Group group = new Group();
        
        group.setName(groupNewDto.getName());
        group.setPermissions(groupNewDto.getPermissions().stream().map(permission -> permissionRepository.findByName(permission)).collect(Collectors.toList()));
    
        groupRepository.save(group);
    }

    @Override
    public void delete(Long id) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Group t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void update(Dto dto) throws RuntimeException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
