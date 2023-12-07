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
import java.util.function.Supplier;


public class Security extends Person {
    private static final Logger LOGGER = LogManager.getLogger(Security.class);
    private LocalDate hiredDate;
    private Salary salary;
    private HiringSeason hiringSeason;
    private EmployeeStatus securityStatus;
    private FileUtils fileUtils;

    public static int countSecurity;

    public Security(String firstName, String lastName, long phoneNumber, LocalDate hiredDate, Salary salary, HiringSeason hiringSeason) throws InvalidPersonException {
        super(firstName, lastName, phoneNumber);
        this.hiredDate = hiredDate;
        this.salary = salary;
        this.hiringSeason = hiringSeason;
        securityStatus = securityStatus.Available;
        countSecurity++;
        LOGGER.info("This security created: " + firstName + " " + lastName);
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

    public EmployeeStatus getSecurityStatus() {
        return securityStatus;
    }

    public void setSecurityStatus(EmployeeStatus securityStatus) {
        this.securityStatus = securityStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Security security = (Security) o;
        return Objects.equals(hiredDate, security.hiredDate) && salary == security.salary && hiringSeason == security.hiringSeason;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hiredDate, salary, hiringSeason);
    }

    @Override
    public String toString() {
        return "Security{" +
                "hiredDate=" + hiredDate +
                ", salary=" + salary +
                ", hiringSeason=" + hiringSeason +
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
        // Supplier lambda to provide lines
        Supplier<List<String>> linesSupplier = () -> fileUtils.readFromFile(path);

        // Get the lines from the supplier
        List<String> lines = linesSupplier.get();

        // Consumer lambda and forEach to print the lines
        lines.forEach(System.out::println);
    }
}
