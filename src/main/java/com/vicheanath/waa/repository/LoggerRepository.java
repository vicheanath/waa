package com.vicheanath.waa.repository;

import com.vicheanath.waa.entity.Logger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoggerRepository extends JpaRepository<Logger, String> {
}
