package Fenyuk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class ZooClub {
	
	Map<Person, ArrayList<Animal>> map = new HashMap<Person, ArrayList<Animal>>();
	 Scanner sc = new Scanner(System.in);  
	 
	 public void addZooClubMember() {
			System.out.println("Введіть ім'я учасника зооклубу:");
			String name = sc.next();
			System.out.println("Введіть вік учасника зооклубу:");
			int age = sc.nextInt();

			Person zooClubMember = new Person(name, age);

			map.put(zooClubMember, new ArrayList<Animal>());
			System.out.println(zooClubMember.toString() + " успішно зареєстрований в зооклубі!");
		}

		public void addAnimal() {
			System.out.println("Введіть ім'я учасника зооклубу:");
			String name = sc.next();
			System.out.println("Введіть вік учасника зооклубу:");
			int age = sc.nextInt();

			boolean typeCorrect = isZooClubMemberExists(map, name, age);

			if (typeCorrect) {
				System.out.println("Введіть ім'я тварини:");
				String nickname = sc.next();
				System.out.println("Введіть тип тварини:");
				String typeOfAnimal = sc.next();

				Animal newAnimal = new Animal(nickname, typeOfAnimal);

				Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

				while (iterator.hasNext()) {
					Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

					if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
						ArrayList<Animal> animalList = nextMember.getValue();

						animalList.add(newAnimal);
						System.out.println("Тварина " + newAnimal.toString() + " успішно додана учаснику зооклубу "
								+ nextMember.getKey() + "!");
					}
				}

			} else {
				System.out.println("Введеного учасника немає в зооклубі!");
			}
		}

		public void removeAnimal() {
			System.out.println("Введіть ім'я учасника зооклубу:");
			String name = sc.next();
			System.out.println("Введіть вік учасника зооклубу:");
			int age = sc.nextInt();

			boolean typeCorrect = isZooClubMemberExists(map, name, age);

			if (typeCorrect) {
				System.out.println("Введіть ім'я тварини:");
				String nickname = sc.next();
				System.out.println("Введіть тип тварини:");
				String typeOfAnimal = sc.next();

				boolean typeAnimalCorrect = isZooClubMemberAnimalExists(map, name, age, typeOfAnimal, nickname);

				while (typeAnimalCorrect) {
					Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

				if (iterator.hasNext()) {
					Entry<Person, ArrayList<Animal>> nextMember = iterator.next();
					
					if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
						ArrayList<Animal> animalList = nextMember.getValue();
						
						Iterator<Animal> iterator2 = animalList.iterator();
						
						while(iterator2.hasNext()) {
							Animal next2 = iterator2.next();
							if (next2.getTypeOfAnimal().equalsIgnoreCase(typeOfAnimal) && next2.getName().equalsIgnoreCase(nickname)) {
								iterator2.remove();
								System.out.println("Тварина " + next2.toString() + " успішно видалена в учасника зооклубу " + nextMember.getKey() + "!");
							}
						}
					}
				}
				else {
					System.out.println("Введеної тварини немає в учасника!");
				}
				} 
			}
			else {
				System.out.println("Введеного учасника немає в зооклубі!");
			}
		}

		public void removeZooClubMember() {
			System.out.println("Введіть ім'я учасника зооклубу:");
			String name = sc.next();
			System.out.println("Введіть вік учасника зооклубу:");
			int age = sc.nextInt();

			boolean typeCorrect = isZooClubMemberExists(map, name, age);

			if (typeCorrect) {
				Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

				while (iterator.hasNext()) {
					Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

					if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
						iterator.remove();
						System.out.println(nextMember.getKey().toString() + " успішно видалений з зооклубу!");
					}
				}
			} else {
				System.out.println("Введеного учасника немає в зооклубі!");
			}
		}

		public void removeAnimalFromAllMembers() {
			System.out.println("Введіть тип тварини:");
			String typeOfAnimal = sc.next();

			Iterator<Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

				ArrayList<Animal> animalList = nextMember.getValue();

				Iterator<Animal> iterator2 = animalList.iterator();

				while (iterator2.hasNext()) {
					Animal next2 = iterator2.next();

					if (next2.getTypeOfAnimal().equalsIgnoreCase(typeOfAnimal)) {
						iterator2.remove();
						System.out.println("Тип тварини " + next2.toString() + " успішно видалений в усіх учасників зооклубу"
								+ nextMember.getKey() + "!");
					}
				}
			}
		}

		public void viewZooClub() {
			Set<Entry<Person, ArrayList<Animal>>> zooClubMembers = map.entrySet();

			System.out.println("В зооклуб входять:");
			for (Entry<Person, ArrayList<Animal>> entry : zooClubMembers) {
				System.out.println("В участника " + entry.getKey() + " є " + entry.getValue());
			}
		}

		static boolean isZooClubMemberExists(Map<Person, ArrayList<Animal>> zooClub, String name, int age) {
			boolean flag = false;

			Set<Entry<Person, ArrayList<Animal>>> zooClubMembers = zooClub.entrySet();

			for (Entry<Person, ArrayList<Animal>> entry : zooClubMembers) {
				if (entry.getKey().getName().equalsIgnoreCase(name) && entry.getKey().getAge() == age) {
					flag = true;
				}
			}

			return flag;
		}

		static boolean isZooClubMemberAnimalExists(Map<Person, ArrayList<Animal>> zooClub, String name, int age,
				String typeOfAnimal, String nickname) {
			boolean flag = false;

			Iterator<Entry<Person, ArrayList<Animal>>> iterator = zooClub.entrySet().iterator();

			while (iterator.hasNext()) {
				Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

				if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
					ArrayList<Animal> animalList = nextMember.getValue();

					Iterator<Animal> iterator2 = animalList.iterator();

					while (iterator2.hasNext()) {
						Animal next2 = iterator2.next();

						if (next2.getTypeOfAnimal().equalsIgnoreCase(typeOfAnimal) && next2.getName().equalsIgnoreCase(nickname)) {
							flag = true;
						}
					}
				}
			}

			return flag;
		}
}
