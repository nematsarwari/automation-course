package com.solvd.laba.oopPractice;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.github.javafaker.*;
import com.solvd.laba.oopPractice.Exception.InvalidPersonException;
import com.solvd.laba.oopPractice.enums.HiringSeason;
import com.solvd.laba.oopPractice.enums.Salary;
import com.solvd.laba.oopPractice.people.Manager;
import com.solvd.laba.oopPractice.people.Passenger;
import com.solvd.laba.oopPractice.people.Security;
import com.solvd.laba.oopPractice.people.TrainDriver;
import com.solvd.laba.oopPractice.stationSystem.Station;
import com.solvd.laba.oopPractice.stationSystem.Train;
import com.solvd.laba.oopPractice.stationSystem.TrainLine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static java.time.LocalDate.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Logger LOGGER = LogManager.getLogger(SubwaySystem.class);
        Faker faker = new Faker();
        Scanner scan = new Scanner(System.in);





        System.out.println("Welcome! Please provide the name of your company.");
        String companyName = scan.next();
        System.out.println("How many managers are envisioned for your organization?");
        int numOfManagers = scan.nextInt();
        System.out.println("How many TrainDrivers are envisioned for your organization?");
        int numOfTrainDriver = scan.nextInt();
        System.out.println("How many Security are envisioned for your organization?");
        int numOfSecurity = scan.nextInt();


        // Array of month names
        String[] monthNames = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};

        // Generate a random index
        Random random = new Random();
        int randomIndex = random.nextInt(monthNames.length);

        // Get the month name at the random index
        String randomMonthName = monthNames[randomIndex];

        // this will create random TrainDrivers
        Set<Manager> managers = new HashSet<>();;
        Manager manager;
        for (int i = 1; i <= numOfManagers; i++) {
            Date hiringDateAsDate = faker.date().past(365, java.util.concurrent.TimeUnit.DAYS);
            LocalDate hiringDate = Instant.ofEpochMilli(hiringDateAsDate.getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
               manager = new Manager(faker.name().firstName(), faker.name().lastName(), faker.number().randomNumber(),hiringDate, Salary.MANAGER,HiringSeason.getSeasonByMonth(randomMonthName));

            managers.add(manager);
        }

        // this will create random managers
        Set<TrainDriver> trainDrivers = new HashSet<>();
        TrainDriver trainDriver;
        for (int i = 1; i <= numOfManagers; i++) {
            Date hiringDateAsDate = faker.date().past(365, java.util.concurrent.TimeUnit.DAYS);
            LocalDate hiringDate = Instant.ofEpochMilli(hiringDateAsDate.getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            trainDriver = new TrainDriver(faker.name().firstName(), faker.name().lastName(), faker.number().randomNumber(),hiringDate, Salary.MANAGER,HiringSeason.getSeasonByMonth(randomMonthName));
            trainDrivers.add(trainDriver);
        }

        // this will create random Securities
        Set<Security> securities = new HashSet<>();
        Security security;
        for (int i = 1; i <= numOfManagers; i++) {
            Date hiringDateAsDate = faker.date().past(365, java.util.concurrent.TimeUnit.DAYS);
            LocalDate hiringDate = Instant.ofEpochMilli(hiringDateAsDate.getTime())
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            security = new Security(faker.name().firstName(), faker.name().lastName(), faker.number().randomNumber(),hiringDate, Salary.MANAGER,HiringSeason.getSeasonByMonth(randomMonthName));

            securities.add(security);
        }
        scan.close();



            Station station1 = new Station("Westminster", "Monica Blvd", LocalDate.of(1980, 4, 9));
            Station station2 = new Station("Grand Central", "Broadway", LocalDate.of(1960, 5, 2));
            Station station3 = new Station("Central Station", "Market Street", LocalDate.of(1950, 9, 4));
            Station station4 = new Station("Union Station", "Pike Place", LocalDate.of(1976, 1, 3));

            Train train1 = new Train("Starlight", LocalDate.of(1960, 10,10) , 100 );
            Train train2 = new Train("Empire", LocalDate.of(1980, 12,30) ,100);
            Train train3 = new Train("Southwest", LocalDate.of(1965, 1,24) ,150 );
            Train train4 = new Train("Eagle", LocalDate.of(1970, 2,5) ,150 );

            TrainLine line1 = new TrainLine("Blue Line", LocalDate.of(1940, 1,3) ,1);
            TrainLine line2 = new TrainLine("Limited", LocalDate.of(19350, 10,8) ,2);
            TrainLine line3 = new TrainLine("Silver", LocalDate.of(1980, 12,15) ,3);
            TrainLine line4 = new TrainLine("Golden",LocalDate.of(1950, 11,27) ,4);



            Passenger passenger1 = new Passenger(faker.name().firstName(), faker.name().lastName(),745632455l,LocalDate.of(2023, 11, 14));
            Passenger passenger2 = new Passenger(faker.name().firstName(), faker.name().lastName(),342453454l,LocalDate.of(2023, 11, 16));
            Passenger passenger3 = new Passenger(faker.name().firstName(), faker.name().lastName(),566632455l,LocalDate.of(2023, 11, 16));
            Passenger passenger4 = new Passenger(faker.name().firstName(), faker.name().lastName(),77222455l,LocalDate.of(2023, 11, 15));

            Ticket ticket1 = new Ticket(343);
            Ticket ticket2 = new Ticket(789);
            Ticket ticket3 = new Ticket(238);
            Ticket ticket4 = new Ticket(964);

            // tie passenger with ticket

            passenger1.assignTicket(ticket1);
            passenger2.assignTicket(ticket2);
            passenger3.assignTicket(ticket3);
            passenger4.assignTicket(ticket4);

            List<Station> stations = new ArrayList<>();
            stations.add(station1);
            stations.add(station2);
            stations.add(station3);
            stations.add(station4);

            List<Train> trains = new ArrayList<>();
            trains.add(train1);
            trains.add(train2);
            trains.add(train3);
            trains.add(train4);

            List<TrainLine> trainLines = new ArrayList<>();
            trainLines.add(line1);
            trainLines.add(line2);
            trainLines.add(line3);
            trainLines.add(line4);



            Set<Passenger> passengers = new HashSet<>();
            passengers.add(passenger1);
            passengers.add(passenger2);
            passengers.add(passenger3);
            passengers.add(passenger4);

            Map<Passenger, Ticket> passengerTicketMap = new HashMap<>();
            passengerTicketMap.put(passenger1, ticket1);
            passengerTicketMap.put(passenger2, ticket2);
            passengerTicketMap.put(passenger3, ticket3);
            passengerTicketMap.put(passenger4, ticket4);


            SubwaySystem subwayCompany = new SubwaySystem(companyName, stations, trains, trainLines, managers, trainDrivers, securities, passengers, passengerTicketMap);


        // reflection
        Class<Passenger> passengerClass = Passenger.class;
        // Extract information about fields
        System.out.println("Fields:");
        for (Field field : passengerClass.getDeclaredFields()) {
            System.out.println("Name: " + field.getName() +
                    ", Type: " + field.getType() +
                    ", Modifiers: " + field.getModifiers());
        }

        // Extract information about constructors
        System.out.println("\nConstructors:");
        for (Constructor<?> constructor : passengerClass.getDeclaredConstructors()) {
            System.out.println("Name: " + constructor.getName() +
                    ", Parameters: " + constructor.getParameterCount() +
                    ", Modifiers: " + constructor.getModifiers());
        }

        // Extract information about methods
        System.out.println("\nMethods:");
        for (Method method : passengerClass.getDeclaredMethods()) {
            System.out.println("Name: " + method.getName() +
                    ", Return Type: " + method.getReturnType() +
                    ", Parameters: " + method.getParameterCount() +
                    ", Modifiers: " + method.getModifiers());
        }

        try {
            // Create an object using reflection
            Constructor<Passenger> constructor = passengerClass.getConstructor(String.class, String.class, long.class, LocalDate.class);
            Passenger passenger = constructor.newInstance("John", "Doe", 1234567890, LocalDate.now());


            // Print the object using reflection
            System.out.println("\nPassenger Object:");
            System.out.println(passenger);
        } catch (Exception e) {
            e.printStackTrace();
        }

            // Using the getInfo method with Optional
            Optional<String> resultOptional = subwayCompany.getInfo();

            if (resultOptional.isPresent()) {
                System.out.println("Result: " + resultOptional.get());
            } else {
                System.out.println("Result is null");
            }


    }
}
