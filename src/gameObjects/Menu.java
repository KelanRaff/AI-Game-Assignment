package gameObjects;

import ie.atu.sw.ai.ConsoleColour;

public class Menu {
	
	public void DisplayMenu() {
		System.out.println(ConsoleColour.RED);
		System.out.println("************************************************************");
		System.out.println("*      ATU - Dept. Computer Science & Applied Physics      *");
		System.out.println("*                                                          *");
		System.out.println("*                   AI Text Adventure Game                 *");
		System.out.println("*                                                          *");
		System.out.println("************************************************************");
		
		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
		System.out.println("Enter Text (Type Q! to Quit>");
		
		System.out.println();
		System.out.println("Enter 'go' to start off on your adventure!");
		System.out.println("------------------------------------------");
		System.out.println("Feature examples:");
		System.out.println("Else type 'train' to train the neural networks or 'fuzz' to use use fuzzy logic");
		System.out.println("------------------------------------------");
		
		}
	
	public void showIntro(){
        String s;
        s = "You have fallen down a hole in the forest and woken  up in\n"+
                "an underground cavern that you percieve as the nest of a beast.\n" +
                "Where do you want to go? [Enter n, s, w or e]?\n" +
                "(or enter q to quit)";
        System.out.println(s);
    }
	}

