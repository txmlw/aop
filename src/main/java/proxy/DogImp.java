package proxy;

import proxy.annon.Animal;
import proxy.imp.AnimalInterface;

public class DogImp implements AnimalInterface {

	@Animal(value = "lucy")
	private String name;

	private String Property;

	public DogImp() {
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void bark() {
		System.out.println("Dog:wang wang xue bing.....");
	}

	@Override
	@Animal(Property = "狗刨")
	public void setProperty(String Property) {
		this.Property = Property;
	}

	@Override
	public void getProperty() {
		System.out.println(this.name +"---"+ this.Property);
	}

	@Override
	public void eating() {
		System.out.println("我正在吃"+this.Property);
	}
}
