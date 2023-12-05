package com.solvd.laba.oopPractice;

import com.solvd.laba.oopPractice.Exception.InvalidPersonException;
import com.solvd.laba.oopPractice.Exception.UnsuccessfulPaymentException;
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

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger LOGGER = LogManager.getLogger(SubwaySystem.class);




        try {

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

            Manager manager1 = new Manager("Olivia", "Bennett", 720342424l, LocalDate.of(1990, 6, 25), Salary.MANAGER, HiringSeason.getSeasonByMonth("March"));
            Manager manager2 = new Manager("Ethan", "Rodriguez", 3424568454l, LocalDate.of(1995, 6, 15),Salary.MANAGER,HiringSeason.getSeasonByMonth("May"));
            Manager manager3 = new Manager("Maya", "Foster", 458230853l, LocalDate.of(1999, 3, 17), Salary.MANAGER, HiringSeason.getSeasonByMonth("November"));
            Manager manager4 = new Manager("Nathan", "Reynolds", 548420853l, LocalDate.of(1996, 7, 5), Salary.MANAGER, HiringSeason.getSeasonByMonth("June"));

            TrainDriver driver1 = new TrainDriver("Harper", "Mitchell", 745632782l, LocalDate.of(1980, 5, 12), Salary.DRIVER, HiringSeason.getSeasonByMonth("January"));
            TrainDriver driver2 = new TrainDriver("Adrian", "Williams", 857846325l, LocalDate.of(1975, 6, 17), Salary.DRIVER, HiringSeason.getSeasonByMonth("August"));
            TrainDriver driver3 = new TrainDriver("Lily", "Anderson", 745452877l, LocalDate.of(1999, 9, 27), Salary.DRIVER, HiringSeason.getSeasonByMonth("October"));
            TrainDriver driver4 = new TrainDriver("Oliver", "Martinez", 456724572l, LocalDate.of(1976, 2, 8), Salary.DRIVER, HiringSeason.getSeasonByMonth("February"));

            Security security1 = new Security("Serena", "Thompson", 745632455l, LocalDate.of(1990, 6, 22), Salary.SECURITY, HiringSeason.getSeasonByMonth("July"));
            Security security2 = new Security("Lucas", "Turner", 85766425l, LocalDate.of(1995, 7, 27), Salary.SECURITY, HiringSeason.getSeasonByMonth("March"));
            Security security3 = new Security("Sofia", "Rodriguez", 74454645l, LocalDate.of(19989, 5, 17),Salary.SECURITY,  HiringSeason.getSeasonByMonth("September"));
            Security security4 = new Security("Owen", "Campbell", 66764572l, LocalDate.of(19786, 3, 9), Salary.SECURITY, HiringSeason.getSeasonByMonth("December"));

            Passenger passenger1 = new Passenger("Amelia", "Turner",745632455l,LocalDate.of(2023, 11, 14));
            Passenger passenger2 = new Passenger("Mitchell", "Foster",342453454l,LocalDate.of(2023, 11, 16));
            Passenger passenger3 = new Passenger("Sebastian ", "Reynolds",566632455l,LocalDate.of(2023, 11, 16));
            Passenger passenger4 = new Passenger("Isabella", "Rivera",77222455l,LocalDate.of(2023, 11, 15));

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

            Set<Manager> managers = new HashSet<>();
            managers.add(manager1);
            managers.add(manager2);
            managers.add(manager3);
            managers.add(manager4);

            Set<TrainDriver> trainDrivers = new HashSet<>();
            trainDrivers.add(driver1);
            trainDrivers.add(driver2);
            trainDrivers.add(driver3);
            trainDrivers.add(driver4);

            Set<Security> securities = new HashSet<>();
            securities.add(security1);
            securities.add(security2);
            securities.add(security3);
            securities.add(security4);

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


            SubwaySystem subwayCompany = new SubwaySystem("UnionSubwayStation", stations, trains, trainLines, managers, trainDrivers, securities, passengers, passengerTicketMap);
            System.out.println(subwayCompany);
            ticket1.makePayment(23423422345l, 20);
            ticket1.receivePayment();
        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }


    }
}
