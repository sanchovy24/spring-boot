package com.ryazanova.MyFirstService.Service;
import com.ryazanova.MyFirstService.Model.Positions;
import org.springframework.stereotype.Service;

@Service
public class
AnnualBonusServiceImpl implements AnnualBonusService{
    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        int year = java.time.LocalDate.now().getYear();
        int quantityDay = isLeapYear(year) ? 366 : 365;

        return salary * bonus * quantityDay * positions.getPositionCoefficient() / workDays;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
