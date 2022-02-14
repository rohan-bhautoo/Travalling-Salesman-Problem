import java.io.InputStream;
import java.util.Scanner;

/**
 * Main, executive class for the Traveling Salesman Problem.
 */
public class TSP {

	public static int maxGenerations = 10000;

	public static void main(String[] args) {

		// Input for file name
		System.out.print("Enter file name: ");
		try (Scanner input = new Scanner(System.in)) {
			// Line starts at 0
			int startingLine = 0;

			String inputLine = input.nextLine();

			// Checks if inputLine is empty
			if (inputLine.isEmpty()) {
				System.out.println("File not found!");
				System.exit(0);
			}

			// Lines in file is split by new line.
			String[] lines = read(inputLine).split("\n");

			// Set size of array to be number of lines in the file
			int numOfCities = lines.length;
			City[] cities = new City[numOfCities];

			// Loop to add cities
			for (int i = startingLine; i < lines.length; i++) {
				String[] line = removeWhiteSpace(lines[i]).trim().split(" ");
				int x = Integer.parseInt(line[1].trim());
				int y = Integer.parseInt(line[2].trim());
				City city = new City(line[0], x, y);
				cities[i] = city;
			}

			// Initial GA
			GeneticAlgorithm ga = new GeneticAlgorithm(100, 0.001, 0.9, 2, 5);

			// Initialize population
			Population population = ga.initPopulation(cities.length);

			// Evaluate population
			ga.evalPopulation(population, cities);

			Route startRoute = new Route(population.getFittest(0), cities);
			System.out.println("Start distance: " + startRoute.getDistance());

			// Keep track of current generation
			int generation = 1;
			// Start evolution loop
			long start = System.nanoTime();
			while (!ga.isTerminationConditionMet(generation, maxGenerations)) {
				// Print fittest individual from population
				// Route route = new Route(population.getFittest(0), cities);
				// System.out.println("G"+generation+" Best distance: " + route.getDistance());

				// Apply crossover
				population = ga.crossoverPopulation(population);

				// Apply mutation
				population = ga.mutatePopulation(population);

				// Evaluate population
				ga.evalPopulation(population, cities);

				// Increment the current generation
				generation++;
			}
			long finish = System.nanoTime();
			long timeElapsed = finish - start;
			double seconds = (double) timeElapsed / 1_000_000_000.0;

			System.out.println("Stopped after " + maxGenerations + " generations.");
			Route route = new Route(population.getFittest(0), cities);
			System.out.println("Best distance: " + route.getDistance());
			System.out.print("Route:");
			System.out.println(population.getFittest(0));
			System.out.println("Time Elapsed: " + timeElapsed + "ns (" + seconds + "s)");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove white space from file
	 *
	 * @param s string
	 * @return string
	 */
	private static String removeWhiteSpace(String s) {
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
				s = s.substring(0, i) + s.substring(i + 1);
				i--;
			}
		}
		return s;
	}

	/**
	 * Method to read file using scanner.
	 *
	 * @param fileName name of file
	 * @return file
	 */
	public static String read(String fileName) {
		InputStream stream = TSP.class.getResourceAsStream(fileName);
		try (Scanner scanner = new Scanner(stream).useDelimiter("\\A")) {
			return scanner.hasNext() ? scanner.next() : "";
		}
	}
}
