package com.ryazanova.MyFirstService.Service;


import com.ryazanova.MyFirstService.Model.Positions;
import org.springframework.stereotype.Service;

@Service
public class QuarterlyBonusServiceImpl implements QuarterlyBonusService{
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        if (positions != Positions.MAN) {
            return 0;
        }

        int quarterDays = 90;
        return (salary * bonus * quarterDays * positions.getPositionCoefficient()) / workDays;
    }
}
