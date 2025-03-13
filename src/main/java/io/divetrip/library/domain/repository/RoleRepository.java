package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

    boolean existsByRoleCode(final String roleCode);

    Role findByRoleCode(final String roleCode);

}
