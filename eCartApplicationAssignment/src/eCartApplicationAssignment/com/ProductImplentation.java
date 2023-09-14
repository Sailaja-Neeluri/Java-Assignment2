package eCartApplicationAssignment.com;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductImplentation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialize a list of products using Stream.of()
		//Part-1(1)
				List<Product> productList = Stream.of(
						new Product(1, "Apple iPhone 13", 799.99, 4.5),
						new Product(2, "Samsung Galaxy S22", 749.99, 4.6),
						new Product(3, "Google Pixel 6", 699.99, 4.7),
						new Product(4, "Sony WH-1000XM4", 349.99, 4.8),
						new Product(5, "Apple MacBook Pro", 1299.99, 4.9),
						new Product(6, "Dell XPS 13", 1199.99, 4.4),
						new Product(7, "Amazon Echo Dot", 49.99, 4.2),
						new Product(8, "Apple Watch Series 7", 399.99, 4.6),
						new Product(9, "Bose QuietComfort 35 II", 299.99, 4.7),
						new Product(10, "GoPro HERO10 Black", 499.99, 4.5))
						.collect(Collectors.toList());
				
		//Part-1(2)
				productList.stream()
					//Filter the list of products with price less than 600
						   .filter(product->product.getPrice()<600.00)
					//Filter the list of products with rating greater than 4.5
						   .filter(product->product.getRating()>4.5)
						   .forEach(System.out::println);
				
		//Part-1(3)
				productList.stream()
					//Sort the list of products based on their price and then by rating
						.sorted(Comparator.comparing(Product::getPrice)
						.thenComparing(Comparator.comparing(Product::getRating)))
						.forEach(System.out::println);
		//Part-1(3)
				//transform list of products to list of names using map() method
				List<String> productNames = productList.stream()
	                     .map(Product::getName) 
	                     .collect(Collectors.toList());
				System.out.println("Product Names: "+productNames);
				
		//Part-2(1)
				DoubleSummaryStatistics statistics = productList.stream()
                        .collect(Collectors.summarizingDouble(Product::getPrice));
				System.out.println("Count :"+statistics.getCount()); //get the count of products
				System.out.println("Sum :"+statistics.getSum()); //get the sum of prices of products
				System.out.println("Min :"+statistics.getMin()); //get the min of prices of products
				System.out.println("Max :"+statistics.getMax()); //get the max of prices of products
				System.out.println("Average :"+statistics.getAverage()); //get the average of prices of products
				
		//Part-2(3)
				
			//grouping the products using their ratings
				Map<Double,List<Product>> productsByRating = productList.stream()
						                  .collect(Collectors.groupingBy(Product::getRating)); 
				productsByRating.forEach((key,value)->{
					System.out.println("Rating: "+key+", List of Products: "+value);
				});
			//partitioning the products using their price
				Map<Boolean,List<Product>> productsPartByPrice = productList.stream()
		                   .collect(Collectors.partitioningBy(prod->prod.getPrice()>=799.0)); 
				
				productsPartByPrice.forEach((key,value)->{
					System.out.println(">=799.0: "+key+", Products: "+value);
				});
						   
	}

}
