package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class RoomController {

    @GetMapping("/rooms")
    public List<Room> getAvailableRooms() {
        // Replace with logic to fetch rooms from the database
        List<Room> rooms = List.of(
                new Room(101, "Single"),
                new Room(102, "Double"),
                new Room(103, "Suite")
        );
        return rooms;
    }

    @PostMapping("/book-room")
    public String bookRoom(@RequestBody Map<String, Object> request) {
        int roomNumber = (int) request.get("roomNumber");
        // Add logic to update the room status in the database
        return "Room " + roomNumber + " has been booked!";
    }
}

