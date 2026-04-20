# Smart Campus API

## Overview
This is a REST API for managing rooms, sensors, and sensor readings in a Smart Campus system.

## How to Run
1. Open the project in IntelliJ
2. Run Main.java
3. Open:
   http://localhost:8080/api/v1/

## Sample curl commands

### Get all rooms
curl -X GET http://localhost:8080/api/v1/rooms

### Create a room
curl -X POST http://localhost:8080/api/v1/rooms \
-H "Content-Type: application/json" \
-d "{\"id\":\"LIB-301\",\"name\":\"Library\",\"capacity\":40}"

### Create a sensor
curl -X POST http://localhost:8080/api/v1/sensors \
-H "Content-Type: application/json" \
-d "{\"id\":\"TEMP-001\",\"type\":\"Temperature\",\"status\":\"ACTIVE\",\"currentValue\":22.5,\"roomId\":\"LIB-301\"}"

### Add a reading
curl -X POST http://localhost:8080/api/v1/sensors/TEMP-001/readings \
-H "Content-Type: application/json" \
-d "{\"value\":25.5}"