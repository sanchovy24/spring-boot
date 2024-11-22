package com.ryazanova.MyFirstService.Service;
import com.ryazanova.MyFirstService.Model.Positions;

public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);

}


