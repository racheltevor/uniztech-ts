package com.example.demo;

import java.util.*;

class Room {
    int roomNumber;
    String roomType;
    boolean isAvailable;

    public Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isAvailable = true;
    }

    public void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Room " + roomNumber + " has been booked successfully.");
        } else {
            System.out.println("Room " + roomNumber + " is not available.");
        }
    }

    public void releaseRoom() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Room " + roomNumber + " has been released.");
        } else {
            System.out.println("Room " + roomNumber + " is already available.");
        }
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " (" + roomType + ") - " + (isAvailable ? "Available" : "Booked");
    }
}

class Hotel {
    String hotelName;
    List<Room> rooms;

    public Hotel(String hotelName) {
        this.hotelName = hotelName;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(int roomNumber, String roomType) {
        rooms.add(new Room(roomNumber, roomType));
    }

    public void showAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println(room);
            }
        }
    }

    public Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber) {
                return room;
            }
        }
        return null;
    }
}













public class HotelReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel("Grand Stay");

        hotel.addRoom(101, "Single");
        hotel.addRoom(102, "Double");
        hotel.addRoom(103, "Suite");

        System.out.println("Welcome to " + hotel.hotelName + " Hotel Reservation System");

        while (true) {
            System.out.println("\n1. Show Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Release a Room");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hotel.showAvailableRooms();
                    break;
                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumberToBook = scanner.nextInt();
                    Room roomToBook = hotel.findRoomByNumber(roomNumberToBook);
                    if (roomToBook != null) {
                        roomToBook.bookRoom();
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter room number to release: ");
                    int roomNumberToRelease = scanner.nextInt();
                    Room roomToRelease = hotel.findRoomByNumber(roomNumberToRelease);
                    if (roomToRelease != null) {
                        roomToRelease.releaseRoom();
                    } else {
                        System.out.println("Room not found.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
