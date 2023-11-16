package com.solvd.laba.oopPractice;

import com.solvd.laba.oopPractice.people.Manager;
import com.solvd.laba.oopPractice.people.Passenger;
import com.solvd.laba.oopPractice.people.Security;
import com.solvd.laba.oopPractice.people.TrainDriver;
import com.solvd.laba.oopPractice.stationSystem.Station;
import com.solvd.laba.oopPractice.stationSystem.Train;
import com.solvd.laba.oopPractice.stationSystem.TrainLine;

import java.util.*;

public class SubwaySystem {
    private String companyName;
    private List<Station> stations;
    private List<Train> trains;
    private List<TrainLine> trainLines;
    private Set<Manager> managers;
    private Set<TrainDriver> trainDrivers;
    private Set<Security> securities;
    private Queue<Passenger> passengers;
    private Map<Integer, Ticket> tickets;

    public SubwaySystem(String companyName, List<Station> stations, List<Train> trains, List<TrainLine> trainLines, Set<Manager> managers, Set<TrainDriver> trainDrivers, Set<Security> securities, Queue<Passenger> passengers, Map<Integer, Ticket> tickets){
        this.companyName = companyName;
        this.stations = new ArrayList<>(stations);
        this.trains = new ArrayList<>(trains);
        this.trainLines = new ArrayList<>(trainLines);
        this.managers = new HashSet<>(managers);
        this.trainDrivers = new HashSet<>(trainDrivers);
        this.securities = new HashSet<>(securities);
        this.passengers = new PriorityQueue<>(passengers);
        this.tickets = new HashMap<>(tickets);
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

    public Queue<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Queue<Passenger> passengers) {
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
