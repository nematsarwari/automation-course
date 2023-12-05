package com.solvd.laba.oopPractice.people;

import com.solvd.laba.oopPractice.Exception.InvalidPersonException;
import com.solvd.laba.oopPractice.FileUtils;
import com.solvd.laba.oopPractice.abstracts.Person;
import com.solvd.laba.oopPractice.enums.EmployeeStatus;
import com.solvd.laba.oopPractice.enums.HiringSeason;
import com.solvd.laba.oopPractice.enums.Salary;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;


public class TrainDriver extends Person {
    private static final Logger LOGGER = LogManager.getLogger(TrainDriver.class);
    private LocalDate hiredDate;

    private Salary salary;

    private HiringSeason hiringSeason;
    EmployeeStatus trainDriverStatus;
    private FileUtils fileUtils;

    public static int countDriver;

    public TrainDriver(String firstName, String lastName, long phoneNumber, LocalDate hiredDate, Salary salary, HiringSeason hiringSeason) throws InvalidPersonException {
        super(firstName, lastName, phoneNumber);
        this.hiredDate = hiredDate;
        this.salary = salary;
        this.hiringSeason = hiringSeason;
        trainDriverStatus = trainDriverStatus.Available;
        countDriver++;
        LOGGER.info("This trainDriver created: " + firstName + " " + lastName);
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDate hiredDate) {
        this.hiredDate = hiredDate;
    }


    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public HiringSeason getHiringSeason() {
        return hiringSeason;
    }

    public void setHiringSeason(HiringSeason hiringSeason) {
        this.hiringSeason = hiringSeason;
    }

    public EmployeeStatus getTrainDriverStatus() {
        return trainDriverStatus;
    }

    public void setTrainDriverStatus(EmployeeStatus trainDriverStatus) {
        this.trainDriverStatus = trainDriverStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TrainDriver that = (TrainDriver) o;
        return Objects.equals(hiredDate, that.hiredDate) && salary == that.salary && hiringSeason == that.hiringSeason;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hiredDate, salary, hiringSeason);
    }

    @Override
    public String toString() {
        return "TrainDriver{" +
                "hiredDate=" + hiredDate +
                ", salary=" + salary +
                ", hiringSeason=" + hiringSeason +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    String path = "C:\\Users\\nemat\\IdeaProjects\\automation-course\\src\\test\\java\\employeesDocuments\\"+getFirstName()+"Documents.txt";
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
        // Function lambda to read lines from a file
        Function<String, List<String>> readLinesFunction = filePath -> fileUtils.readFromFile(filePath);

        // Apply the function to get the lines
        List<String> lines = readLinesFunction.apply(path);

        // Consumer lambda and forEach to print the lines
        lines.forEach(System.out::println);
    }
}
