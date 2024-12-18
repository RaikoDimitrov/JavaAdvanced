package com.company.ExamPreparation;

import java.util.*;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        Map<String, String[][]> departmentsRoomsAndBeds = new LinkedHashMap<>();
        Map<String, List<String>> doctorAndPatients = new LinkedHashMap<>();

        while (!"Output".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            departmentsRoomsAndBeds.putIfAbsent(data[0], new String[20][3]);
            addPatientInRoom(departmentsRoomsAndBeds.get(data[0]), data[3]);

            String doctor = data[1] + " " + data[2];
            doctorAndPatients.putIfAbsent(doctor, new ArrayList<>());
            doctorAndPatients.get(doctor).add(data[3]);
        }

        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            if (data.length == 1) {
                printPatients(departmentsRoomsAndBeds.get(data[0]), 0);
            } else if (data.length == 2) {
                if (Character.isDigit(data[1].charAt(0))) {
                    printPatients(departmentsRoomsAndBeds.get(data[0]), Integer.parseInt(data[1]));
                } else {
                    String doctorName = data[0] + " " + data[1];
                    doctorAndPatients.get(doctorName).stream().sorted(String::compareTo).forEach(System.out::println);
                }
            }
        }
    }

    private static void printPatients(String[][] rooms, int roomNumber) {
        List<String> patients = new ArrayList<>();
        if (roomNumber < 0 || roomNumber >= rooms.length) {
            System.out.println("Invalid room number.");
            return;
        }
        if (roomNumber == 0) {
            for (String[] room : rooms) {
                for (String patient : room) {
                    if (patient != null) {
                        patients.add(patient);
                    }
                }
            }
        } else {
            for (int i = 0; i < rooms[roomNumber].length; i++) {
                if (rooms[roomNumber - 1][i] != null) {
                    patients.add(rooms[roomNumber - 1][i]);
                }
                patients.sort(String::compareTo);
            }
        }
        patients.forEach(System.out::println);
    }

    private static void addPatientInRoom(String[][] rooms, String patient) {
        if (rooms[19][2] == null) {
            for (int i = 0; i < rooms.length; i++) {
                for (int j = 0; j < rooms[i].length; j++) {
                    if (rooms[i][j] == null) {
                        rooms[i][j] = patient;
                        return;
                    }
                }
            }
        }
    }
}
