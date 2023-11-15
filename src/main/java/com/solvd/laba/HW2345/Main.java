package com.solvd.laba.HW2345;

import com.solvd.laba.HW2345.customLinklist.CustomLinkedList;
import com.solvd.laba.HW2345.people.Manager;
import com.solvd.laba.HW2345.stationSystem.Station;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {
        Station station = new Station("nn", "kj", LocalDate.of(1394,2,4));

        //Manager manager = new Manager("nemat", "sarwari", 7205226267l, LocalDate.of(1999,01,05), 2348972);
        //manager.showID();

        CustomLinkedList<Integer> a = new CustomLinkedList<>();
        a.insert(2);
        a.insert(6);
        a.insert(3);
        a.insert(27);
        a.insert(9);
        a.printList();

    }
}
