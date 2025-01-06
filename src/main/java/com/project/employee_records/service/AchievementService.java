package com.project.employee_records.service;

import com.project.employee_records.model.Achievement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AchievementService {
    Optional<Achievement> getAchievement(Integer idAchiev);
    Page<Achievement> getAchievements(Pageable pageable);
    Achievement setAchievement(Achievement achievement);
    void deleteAchievement(Integer idAchiev);
}
