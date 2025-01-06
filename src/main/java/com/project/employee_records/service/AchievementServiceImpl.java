package com.project.employee_records.service;

import com.project.employee_records.model.Achievement;
import com.project.employee_records.repository.AchievementRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AchievementServiceImpl implements AchievementService {
    private AchievementRepository achievementRepository;

    @Override
    public Optional<Achievement> getAchievement(Integer idAchiev) {
        return achievementRepository.findById(idAchiev);
    }

    @Override
    public Page<Achievement> getAchievements(Pageable pageable) {
        return achievementRepository.findAll(pageable);
    }

    @Override
    public Achievement setAchievement(Achievement achievement) {
        achievementRepository.save(achievement);
        return achievement;
    }

    @Override
    public void deleteAchievement(Integer idAchiev) {
        achievementRepository.deleteById(idAchiev);
    }
}
