package com.eurekadevops.sabre.repository;

import com.eurekadevops.sabre.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {
    
    public Permission findByName(String permissinName);

}
