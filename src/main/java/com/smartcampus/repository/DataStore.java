package com.smartcampus.repository;

import com.smartcampus.model.Room;
import com.smartcampus.model.Sensor;
import com.smartcampus.model.SensorReading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataStore {
    public static final Map<String, Room> rooms = new HashMap<>();
    public static final Map<String, Sensor> sensors = new HashMap<>();
    public static final Map<String, List<SensorReading>> sensorReadings = new HashMap<>();

    private DataStore() {
    }

    public static void seedData() {
        Room room1 = new Room("LIB-301", "Library Quiet Study", 40);
        Room room2 = new Room("ENG-101", "Engineering Lab", 25);

        rooms.put(room1.getId(), room1);
        rooms.put(room2.getId(), room2);
    }

    public static List<SensorReading> getReadingsForSensor(String sensorId) {
        return sensorReadings.computeIfAbsent(sensorId, k -> new ArrayList<>());
    }
}