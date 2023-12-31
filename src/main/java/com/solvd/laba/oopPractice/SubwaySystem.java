package com.solvd.laba.oopPractice;

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
import java.util.stream.Collectors;

public class SubwaySystem {
    private static final Logger LOGGER = LogManager.getLogger(SubwaySystem.class);
    private String companyName;
    private List<Station> stations;
    private List<Train> trains;
    private List<TrainLine> trainLines;
    private Set<Manager> managers;
    private Set<TrainDriver> trainDrivers;
    private Set<Security> securities;
    private Set<Passenger> passengers;
    private Map<Passenger, Ticket> passengerTicketMap;


    public SubwaySystem(String companyName, List<Station> stations, List<Train> trains, List<TrainLine> trainLines, Set<Manager> managers, Set<TrainDriver> trainDrivers, Set<Security> securities, Set<Passenger> passengers, Map<Passenger, Ticket> passengerTicketMap) {
        this.companyName = companyName;
        this.stations = stations;
        this.trains = trains;
        this.trainLines = trainLines;
        this.managers = managers;
        this.trainDrivers = trainDrivers;
        this.securities = securities;
        this.passengers = passengers;
        this.passengerTicketMap = passengerTicketMap;
        LOGGER.info("This SubwaySystem created: " + companyName);
    }

    public SubwaySystem() {
        LOGGER.warn("empty SubwaySystem");
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Station> getStations() {
        return stations.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void setStations(List<Station> stations) {
        this.stations = stations;
    }

    public List<Train> getTrains() {
        return trains.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    public List<TrainLine> getTrainLines() {
        return trainLines.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public void setTrainLines(List<TrainLine> trainLines) {
        this.trainLines = trainLines;
    }

    public Set<Manager> getManagers() {
        return managers.stream()
                .distinct()
                .collect(Collectors.toSet());
    }

    public void setManagers(Set<Manager> managers) {
        this.managers = managers;
    }

    public Set<TrainDriver> getTrainDrivers() {
        return trainDrivers.stream()
                .sorted()
                .collect(Collectors.toSet());
    }

    public void setTrainDrivers(Set<TrainDriver> trainDrivers) {
        this.trainDrivers = trainDrivers;
    }

    public Set<Security> getSecurities() {
        return securities.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public void setSecurities(Set<Security> securities) {
        this.securities = securities;
    }

    public HashSet<Passenger> getPassengers() {
        List<Passenger> sortedList = passengers.stream()
                .sorted(Comparator.comparing(Passenger::getFirstName))
                .collect(Collectors.toList());

        return new HashSet<>(sortedList);
    }

    public void setPassengers(HashSet<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Map<Passenger, Ticket> getPassengerTicketMap() {
        return passengerTicketMap;
    }

    public void setPassengerTicketMap(Map<Passenger, Ticket> passengerTicketMap) {
        this.passengerTicketMap = passengerTicketMap;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubwaySystem that = (SubwaySystem) o;
        return Objects.equals(companyName, that.companyName) && Objects.equals(stations, that.stations) && Objects.equals(trains, that.trains) && Objects.equals(trainLines, that.trainLines) && Objects.equals(managers, that.managers) && Objects.equals(trainDrivers, that.trainDrivers) && Objects.equals(securities, that.securities) && Objects.equals(passengers, that.passengers) && Objects.equals(passengerTicketMap, that.passengerTicketMap);
    }
    public String checkPaidTicket(Passenger passenger){
        Ticket ticket;
        ticket = passengerTicketMap.get(passenger);
        if (ticket.receivePayment() == "You already paid $"){
            return "This "+ticket+" purchased by"+passenger;
        }else{
        return "This "+ticket+" didnt purchase yet";}
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, stations, trains, trainLines, managers, trainDrivers, securities, passengers, passengerTicketMap);
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
                ", tickets=" + passengerTicketMap +
                '}';
    }

    // Method that returns an Optional<String>
    public Optional<String> getInfo() {
        // Some logic that may return null
        String result = null;
        return Optional.ofNullable(result);
    }
}
