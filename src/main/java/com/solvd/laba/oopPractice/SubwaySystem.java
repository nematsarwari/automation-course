package com.solvd.laba.oopPractice;

import com.solvd.laba.oopPractice.Exception.InvalidPersonException;
import com.solvd.laba.oopPractice.interfaces.CustomLambda;
import com.solvd.laba.oopPractice.people.Manager;
import com.solvd.laba.oopPractice.people.Passenger;
import com.solvd.laba.oopPractice.people.Security;
import com.solvd.laba.oopPractice.people.TrainDriver;
import com.solvd.laba.oopPractice.stationSystem.Station;
import com.solvd.laba.oopPractice.stationSystem.Train;
import com.solvd.laba.oopPractice.stationSystem.TrainLine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SubwaySystem {
    private static final Logger LOGGER = LogManager.getLogger(SubwaySystem.class);
    private String companyName;
    private List<Station> stations;
    private List<Train> trains;
    private List<TrainLine> trainLines;
    private Set<Manager> managers;
    private Set<TrainDriver> trainDrivers;
    private Set<Security> securities;
    private HashSet<Passenger> passengers;
    private Map<Integer, Ticket> tickets;

    public SubwaySystem(String companyName, List<Station> stations, List<Train> trains, List<TrainLine> trainLines, Set<Manager> managers, Set<TrainDriver> trainDrivers, Set<Security> securities, Set<Passenger> passengers, Map<Integer, Ticket> tickets){
        this.companyName = companyName;
        this.stations = new ArrayList<>(stations);
        this.trains = new ArrayList<>(trains);
        this.trainLines = new ArrayList<>(trainLines);
        this.managers = new HashSet<>(managers);
        this.trainDrivers = new HashSet<>(trainDrivers);
        this.securities = new HashSet<>(securities);
        this.passengers = new HashSet<>(passengers);
        this.tickets = new HashMap<>(tickets);
        LOGGER.info("This SubwaySystem created: " + companyName);
    }
    public SubwaySystem(){
        LOGGER.warn("empty SubwaySystem");
    }

    // Predicate: Check if a passenger has a valid ticket
    Predicate<Passenger> hasValidTicket = Passenger::hasValidTicket;

    // Consumer: Process a passenger entering the subway
    Consumer<Passenger> processEntry = passenger -> {
        System.out.println(passenger.getFirstName() + " enters the subway station.");
        if (hasValidTicket.test(passenger)) {
            System.out.println("Valid ticket. Welcome!");
        } else {
            System.out.println("No valid ticket. Please purchase a ticket.");
        }
    };


    // Function: Process a passenger and return a greeting message
    Function<Passenger, String> greetPassenger = passenger -> {
        processEntry.accept(passenger);
        return "Hello, " + passenger.getFirstName() + "!";
    };
    // Additional Lambda Function: Display station closing message
    Runnable closeStation = () -> System.out.println("Subway station is closing. Thank you for using our services.");

    // Custom Lambda Functions with Generics
    CustomLambda<Integer> square = (num) -> num * num;
    CustomLambda<String> stringLength = (str) -> String.valueOf(str.length());
    CustomLambda<Boolean> not = (flag) -> !flag;


    // Simulate closing the subway station
    public void closeSubwayStation() {
        closeStation.run();
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Station> getStations() {
        return stations;
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public List<TrainLine> getTrainLines() {
        return trainLines;
    }

    public void setTrainLines(List<TrainLine> trainLines) {
        this.trainLines = trainLines;
    }

    public Set<Manager> getManagers() {
        return managers;
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }

    public Set<TrainDriver> getTrainDrivers() {
        return trainDrivers;
    }

    public void setTrainDrivers(Set<TrainDriver> trainDrivers) {
        this.trainDrivers = trainDrivers;
    }

    public Set<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(Set<Security> securities) {
        this.securities = securities;
    }

    public HashSet<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(HashSet<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Map<Integer, Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Map<Integer, Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubwaySystem that = (SubwaySystem) o;
        return Objects.equals(companyName, that.companyName) && Objects.equals(stations, that.stations) && Objects.equals(trains, that.trains) && Objects.equals(trainLines, that.trainLines) && Objects.equals(managers, that.managers) && Objects.equals(trainDrivers, that.trainDrivers) && Objects.equals(securities, that.securities) && Objects.equals(passengers, that.passengers) && Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, stations, trains, trainLines, managers, trainDrivers, securities, passengers, tickets);
    }

    @Override
    public String toString() {
        return "SubwaySystem{" +
                "companyName='" + companyName + '\'' +
                ", stations=" + stations +
                ", trains=" + trains +
                ", trainLines=" + trainLines +
                ", managers=" + managers +
                ", trainDrivers=" + trainDrivers +
                ", securities=" + securities +
                ", passengers=" + passengers +
                ", tickets=" + tickets +
                '}';
    }
}
