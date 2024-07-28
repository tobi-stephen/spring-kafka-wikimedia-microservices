package com.laplace.wiki;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiMessageRepository extends JpaRepository<WikiMessage, Long>{
    
}
