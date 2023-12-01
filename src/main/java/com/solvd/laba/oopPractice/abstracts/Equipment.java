package com.solvd.laba.oopPractice.abstracts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Equipment {
    private static final Logger LOGGER = LogManager.getLogger(Equipment.class);
    protected String name;
    protected LocalDate establishedDate;

    public Equipment(String name, LocalDate establishedDate) {
        this.name = name;
        this.establishedDate = establishedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(name, equipment.name) && Objects.equals(establishedDate, equipment.establishedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, establishedDate);
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "name='" + name + '\'' +
                ", establishedDate=" + establishedDate +
                '}';
    }
}
