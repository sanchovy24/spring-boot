package com.ryazanova.MyFirstService.Service;
import com.ryazanova.MyFirstService.Model.Positions;

public interface QuarterlyBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);
}
