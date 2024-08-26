package gameObjects;

public class Enemy extends Thing {

    private Room room; // the Room where the Enemy is

    public Enemy(String aName, String aDescription, Room aRoom) {
        super(aName, aDescription);
        this.room = aRoom;
    }

    public void setRoom(Room aRoom) {
        this.room = aRoom;
    }

    public Room getRoom() {
        return this.room;
    }
}

