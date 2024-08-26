package gameObjects;

import java.util.ArrayList;

public class Player extends Thing {

    private Room room; // the Room where the Person is at present
	//private ArrayList item;
	

    public Player(String aName, String aDescription, Room aRoom) {
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