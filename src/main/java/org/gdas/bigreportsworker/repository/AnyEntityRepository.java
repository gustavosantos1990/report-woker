package org.gdas.bigreportsworker.repository;

import org.gdas.bigreportsworker.model.entity.AnyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnyEntityRepository extends JpaRepository<AnyEntity, Long> {
}
