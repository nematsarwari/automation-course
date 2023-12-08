package com.solvd.laba.oopPractice.people;

import com.solvd.laba.oopPractice.Exception.InvalidPersonException;
import com.solvd.laba.oopPractice.FileUtils;
import com.solvd.laba.oopPractice.abstracts.Person;
import com.solvd.laba.oopPractice.enums.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class Manager extends Person {
    private static final Logger LOGGER = LogManager.getLogger(Manager.class);
    private LocalDate hiredDate;
    private HiringSeason hiringSeason;
    private Salary salary;
    private EmployeeStatus managerStatus;
    private FileUtils fileUtils;
    private WeekPlans weekPlans;
    public static int countManager;

    public Manager(String firstName, String lastName, long phoneNumber, LocalDate hiredDate, Salary salary, HiringSeason hiringSeason) throws InvalidPersonException {
        super(firstName, lastName, phoneNumber);
        this.hiredDate = hiredDate;
        this.salary = salary;
        this.hiringSeason = hiringSeason;
        managerStatus = managerStatus.Available;
        countManager++;
        LOGGER.info("This manager created: " + firstName + " " + lastName);
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDate hiredDate) {
        this.hiredDate = hiredDate;
    }

    public HiringSeason getHiringSeason() {
        return hiringSeason;
    }

    public void setHiringSeason(HiringSeason hiringSeason) {
        this.hiringSeason = hiringSeason;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public EmployeeStatus getManagerStatus() {
        return managerStatus;
    }

    public void setManagerStatus(EmployeeStatus managerStatus) {
        this.managerStatus = managerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Objects.equals(hiredDate, manager.hiredDate) && hiringSeason == manager.hiringSeason && salary == manager.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hiredDate, hiringSeason, salary);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "hiredDate=" + hiredDate +
                ", hiringSeason=" + hiringSeason +
                ", salary=" + salary +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
    String path = "src\\test\\java\\employeesDocuments\\"+getFirstName()+"Documents.txt";
    @Override
    public void writeDocument() {
        fileUtils = new FileUtils();
        fileUtils.writeToFile(path,
                "FirstName: " + getFirstName()+
                "\nLastName: " + getLastName()+
                "\nPhoneNumber: " + getPhoneNumber() +
                "\nHiredDate: " + getHiredDate());
        LOGGER.info("document successfully written!");
    }

    @Override
    public void printDocument() {
        List<String> lines = fileUtils.readFromFile(path);
        // Consumer lambda and stream
        lines.stream().forEach(System.out::println);
    }
    public String getDayPlan(String day){
        return weekPlans.getPlanForDay(day);
    }

    public String getWeekPlans() {
        return weekPlans.getAllPlans();
    }
}
