package com.project.challenge_app.Controller;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ChallengeRepo extends JpaRepository<Challenge,Long> {

    Optional<Challenge> findAllByMonthIgnoreCase(String name);
    
}