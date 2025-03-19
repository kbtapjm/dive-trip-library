package io.divetrip.library.domain.repository;

import io.divetrip.library.domain.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResourceRepository extends JpaRepository<Resource, UUID> {

    boolean existsByResourceUrl(final String resourceUrl);

    List<Resource> findByOrderByResourceOrderAsc();

}
