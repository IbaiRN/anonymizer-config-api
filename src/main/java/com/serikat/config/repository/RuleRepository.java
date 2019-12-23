package com.serikat.config.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.serikat.config.entity.RuleEntity;

@Repository
public interface RuleRepository extends CrudRepository<RuleEntity,Long> {


}