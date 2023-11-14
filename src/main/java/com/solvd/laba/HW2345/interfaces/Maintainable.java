package com.solvd.laba.HW2345.interfaces;

import java.time.LocalDate;

public interface Maintainable {
    void maintenanceDate(LocalDate date);
    void maintenanceReason(String reason);
}
