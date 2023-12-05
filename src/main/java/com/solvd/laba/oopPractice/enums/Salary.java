package com.solvd.laba.oopPractice.enums;

public enum Salary {
    MANAGER("Manager", 80000),
    DRIVER("Driver", 50000),
    SECURITY("Security", 45000);

    private final String jobTitle;
    private final int fixedSalary;

    Salary(String jobTitle, int fixedSalary) {
        this.jobTitle = jobTitle;
        this.fixedSalary = fixedSalary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public int getFixedSalary() {
        return fixedSalary;
    }

    public static int getSalaryByTitle(String title) {
        for (Salary salary : Salary.values()) {
            if (salary.getJobTitle().equalsIgnoreCase(title)) {
                return salary.getFixedSalary();
            }
        }
        throw new IllegalArgumentException("No salary found for the job title: " + title);
    }
}
