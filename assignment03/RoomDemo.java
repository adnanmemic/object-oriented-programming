public class RoomDemo {

    public static void main(String[] args) {

        RoomRegister Room1 = new RoomRegister("Stv", 3);
        RoomRegister Room2 = new RoomRegister("T01", 50);
        String line = "-----------------------------------------------";

        // NameOfRoom
        System.out.println("Name of Room 1: " + Room1.getName());
        System.out.println("Name of Room 2: " + Room2.getName());
        System.out.println(line);

        // CapacityOfRoom
        System.out.println("Capacity of Room 1: " + Room1.getCapacity());
        System.out.println("Capacity of Room 2: " + Room2.getCapacity());
        System.out.println(line);

        // givePermit
        System.out.println("Give Permit to 0000000 in Room 1: " + Room1.givePermit("0000000"));
        System.out.println("Give Permit to 4433228 in Room 1: " + Room1.givePermit("4433228"));
        // give permission to id that already has one
        System.out.println("Give Permit to 4433228 in Room 1 (again): " + Room1.givePermit("4433228"));
        System.out.println("Give Permit to 6665555 in Room 1: " + Room1.givePermit("6665555"));
        System.out.println("Give Permit to 7778888 in Room 1: " + Room1.givePermit("7778888"));
        System.out.println("Give Permit to null in Room 1: " + Room1.givePermit(null));
        System.out.println("Give Permit to empty string in Room 1: " + Room1.givePermit(""));
        System.out.println("Give Permit to 1122334 in Room 2: " + Room2.givePermit("1122334"));
        System.out.println("Give Permit to 0000111 in Room 2: " + Room2.givePermit("0000111"));
        System.out.println(line);

        // recordUse
        System.out.println("Add 4433228 to Room 1: " + Room1.recordUse("4433228"));
        // add id that already is in this room
        System.out.println("Add 4433228 to Room 1 (again): " + Room1.recordUse("4433228"));
        // adding without permission
        System.out.println("Add 1111111 (no permission) to Room 1: " + Room1.recordUse("1111111"));
        System.out.println("Add 6665555 to Room 1: " + Room1.recordUse("6665555"));
        System.out.println("Add 7778888 to Room 1: " + Room1.recordUse("7778888"));
        System.out.println("Add 0000111 to Room 2: " + Room2.recordUse("0000111"));
        System.out.println(line);

        // recordExit
        System.out.println("Remove 0000111 from Room 2: " + Room2.recordExit("0000111"));
        // id does not exist
        System.out.println("Remove 5555555 (invalid id) from Room 1: " + Room1.recordExit("5555555"));
        System.out.println(line);

        // usesRoom
        // uses room
        System.out.println("Does 6665555 use Room 1? " + Room1.usesRoom("6665555"));
        // does not use room (was removed before)
        System.out.println("Does 0000111 use Room 2? " + Room1.usesRoom("0000111"));
        System.out.println(line);

        // hasPermission
        // has permission
        System.out.println("Does 4433228 has permission for Room 1? " + Room1.hasPermission("4433228"));
        // has no permission to this room
        System.out.println("Does 4433228 has permission for Room 2? " + Room2.hasPermission("4433228"));
        System.out.println(line);

        // isFull
        // room is full
        System.out.println("Is Room1 full? " + Room1.isFull());
        // not full
        System.out.println("Is Room2 full? " + Room2.isFull());
        System.out.println(line);

        // numberInRoom
        System.out.println("Number of poeple in Room 1: " + Room1.numberInRoom());
        System.out.println("Number of poeple in Room 2: " + Room2.numberInRoom());
        System.out.println(line);

        // getStudentsWithPermit
        System.out.println("Permitted students Room 1: " + Room1.getStudentsWithPermit());
        System.out.println("Permitted students Room 2: " + Room2.getStudentsWithPermit());
        System.out.println(line);

        // getStudentsInRoom
        System.out.println("Students in Room 1: " + Room1.getStudentsInRoom());
        System.out.println("Students in Room 2: " + Room2.getStudentsInRoom());
        System.out.println(line);

        // controlAccess
        // Enter to a full room
        System.out.println("2222222 wants to enter Room 1: " + controlAccess("2222222", Room1));
        // invalid id (null)
        System.out.println("null wants to enter Room 2: " + controlAccess(null, Room2));
        // invalid id (empty string)
        System.out.println("empty string wants to enter Room 2: " + controlAccess("", Room2));
        // student with no permission
        System.out.println("1234567 wants to enter Room 2: " + controlAccess("1234567", Room2));
        // enter
        System.out.println("1122334 string wants to enter Room 2: " + controlAccess("1122334", Room2));
    }

    public static String controlAccess(String id, RoomRegister room) {
        if (room.isFull()) {
            return "room is full";
        } else if (!room.isFull() && (id == null || id == "")) {
            return "invalid id";
        } else if (!room.isFull() && !room.hasPermission(id)) {
            return "not authorized";
        } else {
            return "enter";
        }
    }
}
