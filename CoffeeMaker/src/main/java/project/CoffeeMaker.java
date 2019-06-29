package main.java.project;

import java.util.Scanner;
import logic.java.project.CoffeeMakerAPI;

import logic.java.project.M4CoffeeMakerAPI;
import logic.java.project.M4Source;
import logic.java.project.M4UserInterface;
import logic.java.project.M4Vessel;

public class CoffeeMaker {

	public static int menu() {
		int option = 0;
		Scanner input = new Scanner(System.in);
		
		System.out.println("***Welcome to Coffee Maker Machine***");
		System.out.println("Option 1: To press the BREW button");
		System.out.println("Option 2: To ");
		System.out.println("Option 3: To ");
		System.out.println("Option 4: To exit");
		System.out.println("Choose a number option");
		
		option = input.nextInt();
		return option;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		M4CoffeeMakerAPI api = new M4CoffeeMakerAPI();
		
		M4UserInterface ui = new M4UserInterface(api);
		M4Source source = new M4Source(api);
		M4Vessel vessel = new M4Vessel(api);
		
		ui.init(source, vessel);
		source.init(ui, vessel);
		vessel.init(ui, source);
		
		api.buttonPressed = true;
		api.boilerEmpty = false;
		api.potNotEmpty = false;
		ui.check();
		api.boilerEmpty = true;
		source.check();
		api.potNotEmpty = true;
		//serving coffee
		api.potNotEmpty = false;
		vessel.check(true);
			
		/* Scanner sn = new Scanner(System.in);
		boolean exit = false;
		int userChoice = 0;
		
		while(!exit) {
			userChoice = menu();
			switch(userChoice) {
			case 1:
				System.out.println("You choose the option 1");
				api.buttonPressed = true;
				break;
			case 2:
				System.out.println("You choose the option 2");
				break;
			case 3:
				System.out.println("You choose the option 3");
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("Only options between 1 and 4");
			}
		} */
		
		
		// 1. If button status is pressed, start brewing the coffee. If not, I will ask you for pressing the button.
		
		/* 2. Start brewing: first ask if source and vessel are ready and then it will start both.

		-source is ready when status is BOILER NOT EMPTY (getBoilerStatus)
		start: isBrewing true, startBrewing: valve closed and boiler on
		-vessel is ready when status is POT EMPTY (getWarmerPlateStatus)
		start: isBrewing true, isComplete false */
		
		/* 3. Source startBrewing:
		 * valve closed
		 * boiler on
		 * */
		
	}
	
}
