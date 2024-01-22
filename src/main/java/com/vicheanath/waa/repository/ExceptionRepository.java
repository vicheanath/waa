package com.vicheanath.waa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExceptionRepository extends JpaRepository<com.vicheanath.waa.entity.Exception, String> {
}
