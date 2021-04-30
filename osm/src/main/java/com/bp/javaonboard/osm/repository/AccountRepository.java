package com.bp.javaonboard.osm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bp.javaonboard.osm.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{ 

}
