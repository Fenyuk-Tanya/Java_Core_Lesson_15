package Fenyuk;

import java.util.Objects;

public class Animal {
	
	String nickname;
	String typeOfAnimal;
	
	
	public Animal(String name, String typeOfAnimal) {
		super();
		this.nickname = name;
		this.typeOfAnimal = typeOfAnimal;
	}

	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}

	public void setTypeOfAnimal(String typeOfAnimal) {
		this.typeOfAnimal = typeOfAnimal;
	}

	public String getName() {
		return nickname;
	}

	public void setName(String name) {
		this.nickname = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nickname, typeOfAnimal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		return Objects.equals(nickname, other.nickname) && Objects.equals(typeOfAnimal, other.typeOfAnimal);
	}

	@Override
	public String toString() {
		return "Animal [nickname=" + nickname + ", typeOfAnimal=" + typeOfAnimal + "]";
	}


	
	

}
