package kisok;

public class Product {

	String name;
	int price;

	public Product(String name, int price) {
		this.name = name;
		this.price = price;

	}

	public Product(int price, String name) {
		this.name = name;
		this.price = price;
	};

	public Product() {
	};

	void info() {
		System.out.println(name + " 가격 : " + price + "원");
	};

}
