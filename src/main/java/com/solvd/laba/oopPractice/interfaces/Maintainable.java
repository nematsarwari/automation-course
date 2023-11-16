package com.solvd.laba.oopPractice.interfaces;

import java.time.LocalDate;

public interface Maintainable {
    void maintenanceDate(LocalDate date);
    void maintenanceReason(String reason);
}
