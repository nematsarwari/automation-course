package com.solvd.laba.oopPractice;

import com.solvd.laba.oopPractice.customLinklist.CustomLinkedList;
import com.solvd.laba.oopPractice.people.Manager;
import com.solvd.laba.oopPractice.people.Passenger;
import com.solvd.laba.oopPractice.people.Security;
import com.solvd.laba.oopPractice.people.TrainDriver;
import com.solvd.laba.oopPractice.stationSystem.Station;
import com.solvd.laba.oopPractice.stationSystem.Train;
import com.solvd.laba.oopPractice.stationSystem.TrainLine;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Logger LOGGER = LogManager.getLogger(SubwaySystem.class);

        // file writer and reader
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\nemat\\IdeaProjects\\automation-course\\src\\main\\resources\\NewYorkTrainStation.txt"));
            writer.write("1: New York and Harlem Railroad: Established on November 26, 1831");
            writer.write("\n2: Long Island Rail Road (LIRR): Chartered on April 24, 1834");
            writer.write("\n3: New York Central Railroad: Founded in 1853");
            writer.write("\n4: Interborough Rapid Transit (IRT): The first subway line in New York City, the IRT opened on October 27, 1904");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            List<String> lines = FileUtils.readLines(new File("C:\\Users\\nemat\\IdeaProjects\\automation-course\\src\\main\\resources\\NewYorkTrainStation.txt"));
            System.out.println(lines.get(0));
            System.out.println(lines.get(1));
            System.out.println(lines.get(2));
            System.out.println(lines.get(3));
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Main application started!");
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(4);
        linkedList.insert(3);
        linkedList.printList();

//        try {
//            Station station1 = new Station("Westminster", "Monica Blvd", LocalDate.of(1980, 4, 9));
//            Station station2 = new Station("Grand Central", "Broadway", LocalDate.of(1960, 5, 2));
//            Station station3 = new Station("Central Station", "Market Street", LocalDate.of(1950, 9, 4));
//            Station station4 = new Station("Union Station", "Pike Place", LocalDate.of(1976, 1, 3));
//
//            Train train1 = new Train("Starlight", LocalDate.of(1960, 10,10) , 100 );
//            Train train2 = new Train("Empire", LocalDate.of(1980, 12,30) ,100);
//            Train train3 = new Train("Southwest", LocalDate.of(1965, 1,24) ,150 );
//            Train train4 = new Train("Eagle", LocalDate.of(1970, 2,5) ,150 );
//
//            TrainLine line1 = new TrainLine("Blue Line", LocalDate.of(1940, 1,3) ,1);
//            TrainLine line2 = new TrainLine("Limited", LocalDate.of(19350, 10,8) ,2);
//            TrainLine line3 = new TrainLine("Silver", LocalDate.of(1980, 12,15) ,3);
//            TrainLine line4 = new TrainLine("Golden",LocalDate.of(1950, 11,27) ,4);
//
//            Manager manager1 = new Manager("Olivia", "Bennett", 720342424l, LocalDate.of(1990, 6, 25),2314);
//            Manager manager2 = new Manager("Ethan", "Rodriguez", 3424568454l, LocalDate.of(1995, 6, 15),7890);
//            Manager manager3 = new Manager("Maya", "Foster", 458230853l, LocalDate.of(1999, 3, 17),8901);
//            Manager manager4 = new Manager("Nathan", "Reynolds", 548420853l, LocalDate.of(1996, 7, 5), 6789);
//
//            TrainDriver driver1 = new TrainDriver("Harper", "Mitchell", 745632782l, LocalDate.of(1980, 5, 12),1729);
//            TrainDriver driver2 = new TrainDriver("Adrian", "Williams", 857846325l, LocalDate.of(1975, 6, 17),4563);
//            TrainDriver driver3 = new TrainDriver("Lily", "Anderson", 745452877l, LocalDate.of(1999, 9, 27),5678);
//            TrainDriver driver4 = new TrainDriver("Oliver", "Martinez", 456724572l, LocalDate.of(1976, 2, 8), 1234);
//
//            Security security1 = new Security("Serena", "Thompson", 745632455l, LocalDate.of(1990, 6, 22),4562);
//            Security security2 = new Security("Lucas", "Turner", 85766425l, LocalDate.of(1995, 7, 27),7891);
//            Security security3 = new Security("Sofia", "Rodriguez", 74454645l, LocalDate.of(19989, 5, 17),2345);
//            Security security4 = new Security("Owen", "Campbell", 66764572l, LocalDate.of(19786, 3, 9), 5678);
//
//            Passenger passenger1 = new Passenger("Amelia", "Turner",745632455l,LocalDate.of(2023, 11, 14));
//            Passenger passenger2 = new Passenger("Mitchell", "Foster",342453454l,LocalDate.of(2023, 11, 16));
//            Passenger passenger3 = new Passenger("Sebastian ", "Reynolds",566632455l,LocalDate.of(2023, 11, 16));
//            Passenger passenger4 = new Passenger("Isabella", "Rivera",77222455l,LocalDate.of(2023, 11, 15));
//
//            Ticket ticket1 = new Ticket("Aidan", "Harrison");
//            Ticket ticket2 = new Ticket("Jackson", "Campbell");
//            Ticket ticket3 = new Ticket("Evelyn", "Brooks");
//            Ticket ticket4 = new Ticket("Chloe", "Bennett");
//
//            List<Station> st = new ArrayList<>();
//            st.add(station1);
//            st.add(station2);
//            st.add(station3);
//            st.add(station4);
//
//            List<Train> tr = new ArrayList<>();
//            tr.add(train1);
//            tr.add(train2);
//            tr.add(train3);
//            tr.add(train4);
//
//            List<TrainLine> tL = new ArrayList<>();
//            tL.add(line1);
//            tL.add(line2);
//            tL.add(line3);
//            tL.add(line4);
//
//            Set<Manager> Mng = new HashSet<>();
//            Mng.add(manager1);
//            Mng.add(manager2);
//            Mng.add(manager3);
//            Mng.add(manager4);
//
//            Set<TrainDriver> drv = new HashSet<>();
//            drv.add(driver1);
//            drv.add(driver2);
//            drv.add(driver3);
//            drv.add(driver4);
//
//            Set<Security> scrt = new HashSet<>();
//            scrt.add(security1);
//            scrt.add(security2);
//            scrt.add(security3);
//            scrt.add(security4);
//
//            Queue<Passenger> psngr = new PriorityQueue<>();
//            psngr.add(passenger1);
//            psngr.add(passenger2);
//            psngr.add(passenger3);
//            psngr.add(passenger4);
//
//            Map<Integer, Ticket> tkt = new HashMap<>();
//            tkt.put(Ticket.getTicketNumber(), ticket1);
//            tkt.put(Ticket.getTicketNumber(), ticket2);
//            tkt.put(Ticket.getTicketNumber(), ticket3);
//            tkt.put(Ticket.getTicketNumber(), ticket4);
//
//            SubwaySystem subwayCompany = new SubwaySystem("UnionSubwayStation", st, tr, tL, Mng, drv, scrt, psngr, tkt);
//            System.out.println(subwayCompany);
//        }catch (Exception e){
//            LOGGER.error(e.getMessage());
//        }


    }
}
