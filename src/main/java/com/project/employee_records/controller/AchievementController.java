package com.project.employee_records.controller;

import com.project.employee_records.model.Achievement;
import com.project.employee_records.service.AchievementService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class AchievementController {
    private final AchievementService achievementService;

    @GetMapping("/achievements/{idAchiev}")
    public ResponseEntity<Achievement> getAchievement(@PathVariable Integer idAchiev){
        return ResponseEntity.of(achievementService.getAchievement(idAchiev));
    }

    @GetMapping("/achievements")
    public Page<Achievement> getAchievements(Pageable pageable){
        return achievementService.getAchievements(pageable);
    }

    @PostMapping("/achievements")
    public ResponseEntity<Void> saveAchievement(@RequestBody Achievement achievement){
        Achievement createAchievement = achievementService.setAchievement(achievement);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idAchiev}").buildAndExpand(createAchievement.getIdAchiev()).toUri();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(location);
        headers.add("Access-Control-Expose-Headers", "*");
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/achievements/{idAchiev}")
    public ResponseEntity<Void> updateAchievement(@RequestBody Achievement achievement, @PathVariable Integer idAchiev){
        return achievementService.getAchievement(idAchiev)
                .map(a -> {
                    achievementService.setAchievement(achievement);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/achievements/{idAchiev}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable Integer idAchiev){
        return achievementService.getAchievement(idAchiev)
                .map(a -> {
                    achievementService.deleteAchieviement(idAchiev);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
