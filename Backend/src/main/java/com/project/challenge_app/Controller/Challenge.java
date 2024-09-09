package com.project.challenge_app.Controller;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
 @Entity
public class Challenge {
    @Id
    private long id;
    @Column(name = "monthName")
    private String month;
    private String description;
}
