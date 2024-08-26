package ie.atu.sw.ai;

import java.util.Scanner;

import aiControllers.FuzzyLogic;
import aiControllers.NetworkModels;
import aiControllers.Semantics;
import game.Game;
import gameObjects.Menu;
import aiControllers.Maze;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		//game variables
		boolean gameOver=false;
		int health = 100;
		int currentRoom =1;
		
		//fuzzy variables
		String temp;
		String cover;
	
		//load menu
		Menu menu = new Menu();
		menu.DisplayMenu();
		
		try (//Use a Scanner or something similar to read in text
				Scanner s = new Scanner(System.in)) {
				String input = s.nextLine();
		        String output;
				
			//Neural net instance
			NetworkModels networkModels = new NetworkModels();
			networkModels.load();
			var fuzzy = new FuzzyLogic();
			Game game = new Game();
			
			//features
				//basic neural network training
			if (input.equals("train")) {
					System.out.println("Training...");
					networkModels.TrainFightNetwork();
					networkModels.TrainRestNetwork();
					System.out.println("Network Model trained! Please Restart and type 'go'.");
				//fuzzy logic with COG method
			} else if (input.equals("fuzz")) {
					System.out.print("> ");
					System.out.println("enter Temp value (0-110)");
					temp = s.nextLine();
					System.out.print("> ");
					System.out.println("enter Cover value (0-100)");
					cover = s.nextLine();
					//apply user values to fuzzy network
					var result = fuzzy.getPlayerSpeed(Integer.parseInt(temp), Integer.parseInt(cover));
					System.out.println(result);
					System.out.println("Example succeeded! Please Restart and type 'go'.");
				//start game logic
			} else if (input.equals("sem")) {
				new Semantics<String>().stackDFsearch(Maze.getInstance().getSource());
			} else if (input.equals("go")) {
				menu.showIntro();
				do {
					System.out.print("> ");
					String gameinput = s.nextLine();
					output = game.RunCommand(gameinput);
		            System.out.println(output);
		            input = gameinput;
				} while (!"q".equals(input));
			}
		}
		
		/*
		 * The locations can be created as an instance of a class Location or something
		 * similar. Items can be added to a Collection associated with each location. The
		 * game characters can keep an inventory using an instance of Collection.  
		 */
		
	}
}