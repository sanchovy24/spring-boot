package com.ryazanova.MyFirstService.Service;

import com.ryazanova.MyFirstService.Model.Positions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class QuarterlyBonusServiceTest {
    @Test
    void calculateQuarterlyBonusForManager() {
        Positions position = Positions.MAN;
        double salary = 100000.00;
        double bonus = 0.15;
        int workDays = 60;

        double result = new QuarterlyBonusServiceImpl().calculate(position, salary, bonus, workDays);
        double expected = (salary * bonus * 90 * position.getPositionCoefficient()) / workDays;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarterlyBonusForNonManager() {
        Positions position = Positions.HR;
        double salary = 100000.00;
        double bonus = 0.15; // 15%
        int workDays = 60;

        double result = new QuarterlyBonusServiceImpl().calculate(position, salary, bonus, workDays);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void calculateQuarterlyBonusWithZeroWorkDays() {
        Positions position = Positions.MAN;
        double salary = 100000.00;
        double bonus = 0.15; // 15%
        int workDays = 0;

        assertThatThrownBy(() -> new QuarterlyBonusServiceImpl().calculate(position, salary, bonus, workDays))
                .isInstanceOf(ArithmeticException.class)
                .hasMessageContaining("/ by zero"); // Сообщение об ошибке деления на ноль
    }

}