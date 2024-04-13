package com.producttrackingsystem.repository;

import com.producttrackingsystem.entity.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealerRepository extends JpaRepository<Dealer,Long> {
}
