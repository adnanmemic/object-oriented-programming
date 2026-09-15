import java.util.Set;
import java.util.HashSet;

public class RoomRegister {
    private String name;
    private int capacity;
    private Set<String> permittedStudents;
    private Set<String> workingStudents;

    // constructor, sets the name and the capacity of the room and
    // creats empty sets for students with permits and actually working students;
    public RoomRegister(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.permittedStudents = new HashSet<>();
        this.workingStudents = new HashSet<>();
    }

    // returns the name of this room
    public String getName() {
        return this.name;
    }

    // returns the capacity of this room
    public int getCapacity() {
        return this.capacity;
    }

    // records the registration of a student (id) given permit to use this room;
    // returns false if id has already a permit or id is null or id is the empty
    // string;
    // returns true otherwise
    public boolean givePermit(String id) {
        if (id == null || id == "" || permittedStudents.contains(id)) {
            return false;
        } else {
            permittedStudents.add(id);
            return true;
        }
    }

    // records the registration of a student (id) using this room;
    // returns false if the room is full or the student (id) has no permit for this
    // room
    // or the student is registered as using this room;
    // returns true otherwise
    public boolean recordUse(String id) {
        if (workingStudents.size() >= capacity || permittedStudents.contains(id) == false
                || workingStudents.contains(id)) {
            return false;
        } else {
            workingStudents.add(id);
            return true;
        }
    }

    // records the deregistration (exit) of student (id) leaving this room;
    // returns false if the student (id) was not registered as using this room;
    // returns true otherwise
    public boolean recordExit(String id) {
        if (workingStudents.contains(id) == false) {
            return false;
        } else {
            workingStudents.remove(id);
            return true;
        }
    }

    // returns true if the student (id) is registered as using this room currently;
    // returns false otherwise
    public boolean usesRoom(String id) {
        if (workingStudents.contains(id)) {
            return true;
        } else {
            return false;
        }
    }

    // returns true if the student (id) has the permission to use this room;
    // returns false otherwise
    public boolean hasPermission(String id) {
        if (permittedStudents.contains(id)) {
            return true;
        } else {
            return false;
        }
    }

    // returns true if this room is full and false otherwise
    public boolean isFull() {
        if (workingStudents.size() == capacity) {
            return true;
        } else {
            return false;
        }
    }

    // returns the number of students currently in this room
    public int numberInRoom() {
        return workingStudents.size();
    }

    // returns the set of students permitted to use this room
    public Set<String> getStudentsWithPermit() {
        return this.permittedStudents;
    }

    // returns the set of students currently in this room
    public Set<String> getStudentsInRoom() {
        return this.workingStudents;
    }
}