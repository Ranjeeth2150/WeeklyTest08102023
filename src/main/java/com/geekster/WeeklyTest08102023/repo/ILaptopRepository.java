package com.geekster.WeeklyTest08102023.repo;

import com.geekster.WeeklyTest08102023.model.Address;
import com.geekster.WeeklyTest08102023.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaptopRepository extends JpaRepository<Laptop,String> {
}
