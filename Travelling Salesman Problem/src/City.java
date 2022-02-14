/**
 * Constructor class for city. It holds the data types for each city's x and y
 * coordinate.
 */

public class City {
	private String name;
	private int x;
	private int y;

	/**
	 * Default constructor
	 * 
	 * @param name name of city
	 * @param x    x coordinate of city
	 * @param y    y coordinate of city
	 */
	public City(String name, int x, int y) {
		this.name = name;
		this.x = x;
		this.y = y;
	}

	/**
	 * Calculate distance from another city
	 * 
	 * Euclidean distance formula: √((x1-x2)^2 + (y1-y2)^2)
	 * 
	 * @param city The city to calculate the distance from
	 * @return distance The distance from the given city
	 */
	public double distanceFrom(City city) {
		// Give difference in x,y
		double deltaXSq = Math.pow((city.getX() - this.getX()), 2);
		double deltaYSq = Math.pow((city.getY() - this.getY()), 2);

		// Calculate shortest path
		return Math.sqrt(Math.abs(deltaXSq + deltaYSq));
	}

	/**
	 * Get name of city
	 *
	 * @return name of city
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get x coordinate of city
	 * 
	 * @return x X coordinate of city
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Get y coordinate of city
	 * 
	 * @return y Y coordinate of city
	 */
	public int getY() {
		return this.y;
	}
}
