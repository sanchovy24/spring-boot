package com.ryazanova.MyFirstService.Service;

import com.ryazanova.MyFirstService.Model.Positions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AnnualBonusServiceTest {

    @Test
    void calculate() {
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;
        double result = new AnnualBonusServiceImpl().calculate(position, salary,
                bonus, workDays);
        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }
}