package eCartApplicationAssignment.com;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelizedoperationsProductSearch {
	
	//Part-3(1)
		public static Optional<Product> sequentialSearch(List<Product> products,String searchName){
			return products.stream()
			        .filter(product->product.getName().equals(searchName))
			        .findFirst();
		}
		
		public static Optional<Product> parallelSearch(List<Product> products,String searchName){
			return products.parallelStream()
			        .filter(product->product.getName().equals(searchName))
			        .findFirst();
		}

		public static void main(String[] args) {
			
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
			
			
			
			long startSeq = System.nanoTime();
			ParallelizedoperationsProductSearch.sequentialSearch(productList,"Amazon Echo Dot");
			long endSeq = System.nanoTime();
			long durationSeq = (endSeq-startSeq)/1000000 ; 
			System.out.println("Sequential Search duration: "+durationSeq);
			
			long startPar = System.nanoTime();
			ParallelizedoperationsProductSearch.parallelSearch(productList,"Amazon Echo Dot");
			long endPar = System.nanoTime();
			long durationPar = (endPar-startPar)/1000000 ;
			System.out.println("Parallel Search Duration: "+durationPar);
			
		}
		

}
