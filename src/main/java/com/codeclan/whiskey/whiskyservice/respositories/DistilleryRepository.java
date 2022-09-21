package com.codeclan.whiskey.whiskyservice.respositories;

import com.codeclan.whiskey.whiskyservice.models.Distillery;

import com.codeclan.whiskey.whiskyservice.models.Whisky;
import org.aspectj.weaver.Lint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistilleryRepository extends JpaRepository<Distillery, Long> {
    List<Distillery> findDistilleryByRegionIgnoreCase(String region);

    List<Distillery> findDistilleryByWhiskiesAge(int age);

}
