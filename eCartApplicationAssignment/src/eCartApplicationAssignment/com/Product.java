package eCartApplicationAssignment.com;

public class Product {
	
	private int id;
	private String name;
	private double price;
	private double rating;
	
	public Product(){
		
	}
	
	
	public Product(int id, String name, double price, double rating) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.rating = rating;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public double getRating() {
		return rating;
	}


	public void setRating(double rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Product ["+
				"id=" + id + 
				", name='" + name + '\''+
				",price=" + price +
				", rating=" + rating +
				"]";
	}

}
