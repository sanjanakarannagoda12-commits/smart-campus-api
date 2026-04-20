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

## Report Answers

### Part 1

**Q1: JAX-RS Resource Lifecycle**
By default, JAX-RS resource classes are instantiated per request. This means a new instance is created for each incoming HTTP request. This approach avoids shared state issues but requires careful handling of shared data structures such as HashMaps. To prevent data inconsistency or race conditions, shared resources should be managed carefully, especially in concurrent environments.

**Q2: HATEOAS (Hypermedia)**
HATEOAS allows clients to dynamically navigate the API using links provided in responses. Instead of relying on static documentation, clients can discover available endpoints through responses. This improves flexibility and reduces coupling between client and server.

---

### Part 2

**Q1: Returning IDs vs Full Objects**
Returning only IDs reduces network usage but requires additional client requests to retrieve full data. Returning full objects increases bandwidth usage but improves performance by reducing the number of requests. A balance depends on system requirements.

**Q2: DELETE Idempotency**
DELETE is idempotent because multiple identical delete requests result in the same outcome. After a resource is deleted, repeating the DELETE request does not change the system state further.

---

### Part 3

**Q1: @Consumes Annotation**
The @Consumes annotation defines the expected input format. If a client sends data in a different format, JAX-RS returns a 415 Unsupported Media Type error, preventing incorrect data processing.

**Q2: QueryParam vs Path**
Query parameters are better for filtering because they allow flexible and optional criteria. Path parameters are more suitable for identifying specific resources, not filtering collections.

---

### Part 4

**Q1: Sub-resource Locator Pattern**
The sub-resource locator pattern improves modularity by separating nested logic into different classes. This reduces complexity and keeps the main resource class clean. It also improves maintainability and scalability for large APIs.

**Q2: Data Consistency**
When a new reading is added, the sensor's currentValue is updated to reflect the latest measurement. This ensures that the system always provides the most recent data without requiring additional queries.

---

### Part 5

**Q1: HTTP 422 vs 404**
HTTP 422 is more appropriate when the request is valid but contains incorrect data, such as referencing a non-existing room. A 404 is used when the resource itself is not found.

**Q2: Stack Trace Security Risk**
Exposing stack traces reveals internal system details such as class names and file paths. Attackers can use this information to identify vulnerabilities and exploit the system.

**Q3: Logging Filters**
Using JAX-RS filters for logging is better than adding logs manually in each method because it centralizes logging logic. This reduces code duplication and ensures consistency across all endpoints.