package com.solvd.laba.oopPractice;

import com.solvd.laba.oopPractice.customLinklist.CustomLinkedList;
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

public class SubwaySystem {
    private static final Logger LOGGER = LogManager.getLogger(SubwaySystem.class);
    static List<Station> stations = new ArrayList<>();
    static List<Train> trains = new ArrayList<>();
    static List<TrainLine> trainLines = new ArrayList<>();
    static Set<Manager> managers = new HashSet<>();
    static Set<TrainDriver> trainDrivers =new HashSet<>();
    static Set<Security> securities = new HashSet<>();
    static Queue<Passenger> passengers = new PriorityQueue<>();
    static Map<Integer, Ticket> tickets = new HashMap<>();


    public static void main(String[] args) {
        LOGGER.info("Main application started!");

        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(4);
        linkedList.insert(3);
        linkedList.printList();

        try {
            Station station1 = new Station("Westminster", "Monica Blvd", LocalDate.of(1980, 4, 9));
            Station station2 = new Station("Grand Central", "Broadway", LocalDate.of(1960, 5, 2));
            Station station3 = new Station("Central Station", "Market Street", LocalDate.of(1950, 9, 4));
            Station station4 = new Station("Union Station", "Pike Place", LocalDate.of(1976, 1, 3));

            Train train1 = new Train("Starlight", 100 );
            Train train2 = new Train("Empire", 100);
            Train train3 = new Train("Southwest", 150 );
            Train train4 = new Train("Eagle", 150 );

            TrainLine line1 = new TrainLine("Blue Line", 1);
            TrainLine line2 = new TrainLine("Limited", 2);
            TrainLine line3 = new TrainLine("Silver", 3);
            TrainLine line4 = new TrainLine("Golden",4);

            Manager manager1 = new Manager("Olivia", "Bennett", 720342424l, LocalDate.of(1990, 6, 25),2314);
            Manager manager2 = new Manager("Ethan", "Rodriguez", 3424568454l, LocalDate.of(1995, 6, 15),7890);
            Manager manager3 = new Manager("Maya", "Foster", 458230853l, LocalDate.of(1999, 3, 17),8901);
            Manager manager4 = new Manager("Nathan", "Reynolds", 548420853l, LocalDate.of(1996, 7, 5), 6789);

            TrainDriver driver1 = new TrainDriver("Harper", "Mitchell", 745632782l, LocalDate.of(1980, 5, 12),1729);
            TrainDriver driver2 = new TrainDriver("Adrian", "Williams", 857846325l, LocalDate.of(1975, 6, 17),4563);
            TrainDriver driver3 = new TrainDriver("Lily", "Anderson", 745452877l, LocalDate.of(1999, 9, 27),5678);
            TrainDriver driver4 = new TrainDriver("Oliver", "Martinez", 456724572l, LocalDate.of(1976, 2, 8), 1234);

            Security security1 = new Security("Serena", "Thompson", 745632455l, LocalDate.of(1990, 6, 22),4562);
            Security security2 = new Security("Lucas", "Turner", 85766425l, LocalDate.of(1995, 7, 27),7891);
            Security security3 = new Security("Sofia", "Rodriguez", 74454645l, LocalDate.of(19989, 5, 17),2345);
            Security security4 = new Security("Owen", "Campbell", 66764572l, LocalDate.of(19786, 3, 9), 5678);

            Passenger passenger1 = new Passenger("Amelia", "Turner",745632455l,LocalDate.of(2023, 11, 14));
            Passenger passenger2 = new Passenger("Mitchell", "Foster",342453454l,LocalDate.of(2023, 11, 16));
            Passenger passenger3 = new Passenger("Sebastian ", "Reynolds",566632455l,LocalDate.of(2023, 11, 16));
            Passenger passenger4 = new Passenger("Isabella", "Rivera",77222455l,LocalDate.of(2023, 11, 15));

            Ticket ticket1 = new Ticket("Aidan", "Harrison");
            Ticket ticket2 = new Ticket("Jackson", "Campbell");
            Ticket ticket3 = new Ticket("Evelyn", "Brooks");
            Ticket ticket4 = new Ticket("Chloe", "Bennett");

            stations.add(station1);
            stations.add(station2);
            stations.add(station3);
            stations.add(station4);

            trains.add(train1);
            trains.add(train2);
            trains.add(train3);
            trains.add(train4);

            trainLines.add(line1);
            trainLines.add(line2);
            trainLines.add(line3);
            trainLines.add(line4);

            managers.add(manager1);
            managers.add(manager2);
            managers.add(manager3);
            managers.add(manager4);

            trainDrivers.add(driver1);
            trainDrivers.add(driver2);
            trainDrivers.add(driver3);
            trainDrivers.add(driver4);

            securities.add(security1);
            securities.add(security2);
            securities.add(security3);
            securities.add(security4);

            passengers.add(passenger1);
            passengers.add(passenger2);
            passengers.add(passenger3);
            passengers.add(passenger4);

            tickets.put(1, ticket1);
            tickets.put(2, ticket2);
            tickets.put(3, ticket3);
            tickets.put(4, ticket4);

        }catch (Exception e){
            LOGGER.error(e.getMessage());
        }
        System.out.println(stations);
        System.out.println(trains);
        System.out.println(trainLines);
        System.out.println(managers);
        System.out.println(trainDrivers);
        System.out.println(securities);
        System.out.println(passengers);
        System.out.println(tickets);
    }
}
