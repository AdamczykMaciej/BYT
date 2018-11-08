// BUILDER PATTERN
/***
 * 
 * @author Maciej Adamczyk, s15170
 *	
 * @description used mainly when we have many parameters and some of them are optional. Then instead of
 * creating many constructors (which might be inefficient) we can create a builder that will give us more flexibility.
 * We could create getters, setters BUT then our class would be mutable always, and we might want to have
 * an immutable class. Builder class allows us to do so.
 */



interface Builder{
	public <T> T BuildPart();
}

class Product{
	private String name; // required
	private String category; // optional
	
	private Product(ProductBuilder pb) {
		name = pb.name;
		category = pb.category;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}
	
	static class ProductBuilder implements Builder{
		
		private String name;
		private String category;
		
		public ProductBuilder(String name) {
			this.name = name;
		}
		
		public ProductBuilder setCategory(String category) {
			this.category = category;
			return this;
		}
		
		@Override
		public Product BuildPart() {
			return new Product(this);
		}
	}
}

class Planet{
	private final String mass; // required, immutable
	private final String name; // required, immutable
	private String description; // optional
	
	
	private Planet(PlanetBuilder pb) {
		name = pb.name;
		mass = pb.mass;
		description = pb.description;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMass() {
		return mass;
	}
	
	public String getDescription() {
		return description;
	}
	
	static class PlanetBuilder implements Builder{
		
		private final String mass; // required, immutable
		private final String name; // required, immutable
		private String description; // optional
		
		
		public PlanetBuilder(String name, String string) {
			this.name = name;
			this.mass = string;
		}
		
		public PlanetBuilder setDescription(String description) {
			this.description = description;
			return this;
		}
		
		@Override
		public Planet BuildPart() {
			return new Planet(this);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Product p = new Product.ProductBuilder("book").BuildPart();
		
		Product p2 = new Product.ProductBuilder("teddy bear").setCategory("toys").BuildPart();
		System.out.println(p.getName());
		System.out.println(p.getCategory());
		System.out.println(p2.getName());
		System.out.println(p2.getCategory());
		
		Planet planet1 = new Planet.PlanetBuilder("Venus", "big").BuildPart();
	}
}
