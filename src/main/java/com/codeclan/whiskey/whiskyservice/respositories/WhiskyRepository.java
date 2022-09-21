package com.codeclan.whiskey.whiskyservice.respositories;

import com.codeclan.whiskey.whiskyservice.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

    List<Whisky> findWhiskyByYear(int year);

    List<Whisky> findWhiskiesByDistilleryIdAndAge(Long id, int age);

    List<Whisky> findWhiskiesByDistilleryRegionIgnoreCase(String region);

}
