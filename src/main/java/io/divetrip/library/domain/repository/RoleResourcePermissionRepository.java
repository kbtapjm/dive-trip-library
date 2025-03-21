package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.RoleResourcePermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleResourcePermissionRepository extends JpaRepository<RoleResourcePermission, UUID>  {

}
