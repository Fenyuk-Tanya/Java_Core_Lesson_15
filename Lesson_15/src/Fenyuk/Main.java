package Fenyuk;

import java.util.Scanner;

public class Main {
	
	static void menu() {
		System.out.println();
		System.out.println("Введіть 1, щоб  зареєструвати нового учасника зооклубу.");
		System.out.println("Введіть 2, щоб  додати тварину учаснику зооклубу.");
		System.out.println("Введіть 3, щоб  видалити тварину в учасника зооклубу.");
		System.out.println("Введіть 4, щоб  видалити учасника з зооклубу.");
		System.out.println("Введіть 5, щоб  видалити введену тварину в усіх учасників зооклубу.");
		System.out.println("Введіть 6, щоб  вивести на екран зооклуб.");
		System.out.println("Введіть 0, щоб  вийти з програми.");
	}

	public static void main(String[] args) {
		
		TypeOfAnimal typeOfAnimal[] = TypeOfAnimal.values();
		ZooClub zooClub = new ZooClub();
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			menu();
			
			switch (sc.nextInt()) {
			case 1: {
				zooClub.addZooClubMember();
				break;
			}
			case 2: {
				zooClub.addAnimal();
				break;
			}
			case 3: {
				zooClub.removeAnimal();
				break;
			}
			case 4: {
				zooClub.removeZooClubMember();
				break;
			}
		    case 5: {
			    zooClub.removeAnimalFromAllMembers();
			break;
			}
			case 6: {
				zooClub.viewZooClub();
				break;
			}
		    case 0: {
		    	System.exit(0);
		    	System.out.println("Ви вийшли з програми");
		        break;
			}
			default:
	             System.out.println("Невірне значення");
	             break;
	        }
			sc.close();
		}
	}
}
