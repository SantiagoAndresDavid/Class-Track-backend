package com.arquitecture.service;

import com.arquitecture.data.StatisticRepository;
import com.arquitecture.entity.Statistic;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class StatisticService {
    @Inject
    StatisticRepository statisticRepository;

    public String saveStatistic(Statistic statistic) {
        try {
            statisticRepository.save(statistic);
            return "Statistic saved";
        } catch (Exception e) {
            return "Error saving statistic: " + e.getMessage();
        }
    }
}
