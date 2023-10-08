package com.geekster.WeeklyTest08102023.repo;

import com.geekster.WeeklyTest08102023.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address,Long> {
}
