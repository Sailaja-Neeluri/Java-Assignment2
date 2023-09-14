package eCartApplicationAssignment.com;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	private List<Product> items;

	public Cart() {
		super();
		items = new ArrayList<>(); 
	}
	
//Part-2(2)
	public void addToCart(Product product){
		items.add(product);
	}

	public List<Product> getItems() {
		return items;
	}

	public void setItems(List<Product> items) {
		this.items = items;
	}
	
	public double calculateTotal(List<Product> item){
		int sum=0;
		
		return item.stream()
		    .mapToDouble(product->product.getPrice())
		    .reduce(sum,(a,b)->a+b);
		
	}
	
	public double calculateTotalParallel(List<Product> item){
		int sum=0;
		
		return item.parallelStream()
		    .mapToDouble(product->product.getPrice())
		    .reduce(sum,(a,b)->a+b);	
	}
	
	public static void main(String[] args) {
//Part-2(2)
		Product p1 = new Product(1, "Apple iPhone 13", 799.99, 4.5);
		Product p2 = new Product(2, "Samsung Galaxy S22", 749.99, 4.6);
		Product p3 = new Product(3, "Google Pixel 6", 699.99, 4.7);
		
		Cart user = new Cart();
		
		//add products to the user's cart
		
		user.addToCart(p1); 
		user.addToCart(p2);
		user.addToCart(p3);
		
		//print the items in cart
		System.out.println(user.getItems()); 
		long startSeq = System.nanoTime();
		
		//calculate total cart price
		double cartTotalPrice = user.calculateTotal(user.getItems()); 
		System.out.println("Cart Total Price :"+cartTotalPrice);
		long endSeq = System.nanoTime();
		long durationSeq = (endSeq-startSeq)/1000000 ; 
		
		System.out.println("Sequential Search duration: "+durationSeq);
		
		//Part-3(2)
		long startPar = System.nanoTime();
		
		//calculate total cart price using parallel stream
		double cartTotalPriceParallel = user.calculateTotalParallel(user.getItems()); 
		System.out.println("Cart Total Price :"+cartTotalPriceParallel);
		long endPar = System.nanoTime();
		long durationPar = (endPar-startPar)/1000000 ; 
		System.out.println("Parallel Search Duration: "+durationPar);
		

}
}
