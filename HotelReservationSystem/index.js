const rooms = [
    { roomNumber: 101, roomType: "Single", isAvailable: true },
    { roomNumber: 102, roomType: "Double", isAvailable: true },
    { roomNumber: 103, roomType: "Suite", isAvailable: false }
];

const roomContainer = document.getElementById("rooms");

function renderRooms() {
    roomContainer.innerHTML = ""; // Clear existing content
    rooms.forEach((room, index) => {
        const roomDiv = document.createElement("div");
        roomDiv.className = "room";
        roomDiv.innerHTML = `
            <h3>Room ${room.roomNumber} (${room.roomType})</h3>
            <p>Status: ${room.isAvailable ? "Available" : "Booked"}</p>
            <button onclick="toggleBooking(${index})">${room.isAvailable ? "Book Now" : "Release Room"}</button>
        `;
        roomContainer.appendChild(roomDiv);
    });
}

function toggleBooking(index) {
    rooms[index].isAvailable = !rooms[index].isAvailable;
    renderRooms();
}

renderRooms();