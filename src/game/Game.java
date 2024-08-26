package game;

import java.util.*;
import gameObjects.Room;
import gameObjects.Player;
import gameObjects.Direction;
import gameObjects.Enemy;;

public class Game {
	public ArrayList <Room>map;
	private Player player;
	
	List<String> objects = new ArrayList<>(Arrays.asList("axe", "amulet", "thorn"));
	List<String> commands = new ArrayList<>(Arrays.asList(
            "take", "drop", "look",
            "n", "s", "w", "e"));
	
	 public Game() {
	        this.map = new ArrayList<Room>();
	        	//           name,   description,                             N,        S,      W,      E 
		 map.add(new Room("Wolf Den", "A rotten room damp with mould", Direction.NOEXIT, 2, Direction.NOEXIT, 1));
		 map.add(new Room("Forest", "A leafy woodland", Direction.NOEXIT, Direction.NOEXIT, 0, Direction.NOEXIT));
		 map.add(new Room("Cavern", "A gloomy cave with walls lined in luminous rock", 0, Direction.NOEXIT, Direction.NOEXIT, 3));
		 map.add(new Room("Dungeon", "A vile cell emitting cruelty", Direction.NOEXIT, Direction.NOEXIT, 2, Direction.NOEXIT));
		 map.add(new Room("Exit", "A well lit passage out of this forsaken cave!", Direction.NOEXIT, Direction.NOEXIT, 3, Direction.NOEXIT));
		 
		// create player in the first room
	        player = new Player("player", "a brave and exciting hero", map.get(0));
	    //create enemies in other rooms
	 }
	 
		ArrayList getMap() {
	        return map;
	    }

		void setMap(ArrayList aMap) {
	        map = aMap;
	    }
		
		public Player getPlayer() {
	        return player;
	    }

	    public void setPlayer(Player aPlayer) {
	        player = aPlayer;
	    }
	    
	    //game logic methods
	    void moveActorTo(Player p, Room aRoom) {
	        p.setRoom(aRoom);
	    }
	    
	    int moveTo(Player aPlayer, Direction dir) {
		    	Room r = aPlayer.getRoom();
		        int exit;
		        
		        switch (dir) {
	            case NORTH:
	                exit = r.getN();
	                break;
	            case SOUTH:
	                exit = r.getS();
	                break;
	            case EAST:
	                exit = r.getE();
	                break;
	            case WEST:
	                exit = r.getW();
	                break;
	            default:
	                exit = Direction.NOEXIT; // noexit - stay in same room
	                break;
	        }
	        if (exit != Direction.NOEXIT) {
	            moveActorTo(aPlayer, map.get(exit));
	        }
        return exit;
	    }
	    
	    public int movePlayerTo(Direction dir) {
	    	return moveTo(player, dir);
	    }
	    
	    private void goN() {
	        updateOutput(movePlayerTo(Direction.NORTH));
	    }

	    private void goS() {
	        updateOutput(movePlayerTo(Direction.SOUTH));
	    }

	    private void goW() {
	        updateOutput(movePlayerTo(Direction.WEST));
	    }

	    private void goE() {
	        updateOutput(movePlayerTo(Direction.EAST));
	    }
	    
	    void updateOutput(int roomNo) {
	    	//gives feedback to user
	    	String out;
	        if (roomNo == Direction.NOEXIT) {
	        	out = "No Exit!";
	        } else {
	            Room r = getPlayer().getRoom();
	            out = "You are in "
	                    + r.getName() + ". " + r.getDescription();
	        }
	        System.out.println(out);
	    }
	    
	    public String RunCommand(String inputstr) {
	    	 String lowstr = inputstr.trim().toLowerCase();
	    	 String s = "ok";
	    	 
	            if (lowstr.equals("")) {
	                s = "You must enter a command";
	            } else {
	                //handle command
	            	switch (lowstr) {
	                case "n":
	                    goN();
	                    break;
	                case "s":
	                    goS();
	                    break;
	                case "w":
	                    goW();
	                    break;
	                case "e":
	                    goE();
	                    break;
	                case "look":
	                    returnRoomItems();
	                    break;
	                case "get":
	                    getRoomItems();
	                    break;
	                case "fight":
	                    fightEnemyInRoom();
	                    break;
	                case "eat":
	                    eatSomeFood();
	                    break;
	                case "tell":
	                    tellPlayer();
	                    break;
	                case "remove":
	                    removeItem(lowstr);
	                    break;
	                case "p":
	                    listInventory();
	                    break;
	                default:
	                    System.out.println("Command Unknown");
	                    break;
	            }
	        }
	        return s;
	    }

		private void removeItem(String item) {
			objects.remove(item);
			
		}

		private void getRoomItems() {
			objects.add("Meat");
			System.out.println("Picked up a piece of meat(worth 20hp). type P to list inventory.");
			
		}

		private void returnRoomItems() {
			System.out.println("A Piece of Fresh Meat is available in this room! I wonder how it got here....");
			
		}
		
		private void fightEnemyInRoom() {
			System.out.println("No Worthy battles in sight....Maybe further in the cavern....");
		}
		
		private void eatSomeFood() {
			System.out.println("Restored 20 HP!");
			objects.remove("Meat");
		}
		
		private void tellPlayer() {
			System.out.println("The walls of this cave seem to deathly quiet.......perhaps it is best to continue on......");
		}
		
		private void listInventory() {
			for (String var : objects) 
			{ 
				System.out.println(var);
			}
		}
	   }
