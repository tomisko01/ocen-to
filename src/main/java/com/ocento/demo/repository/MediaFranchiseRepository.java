package com.ocento.demo.repository;

import com.ocento.demo.domain.MediaFranchise;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaFranchiseRepository extends CrudRepository<MediaFranchise, Long> {
}
