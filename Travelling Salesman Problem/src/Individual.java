/**
 * The individual class is responsible for storing and manipulating a
 * chromosome. It also
 * keeps track of the individual's fitness value.
 */
public class Individual {

	private int[] chromosome;
	private double fitness = -1;

	/**
	 * Initializes individual with specific chromosome
	 * 
	 * @param chromosome The chromosome to give individual
	 */
	public Individual(int[] chromosome) {
		// Create individualchromosome
		this.chromosome = chromosome;
	}

	/**
	 * Initializes random individual
	 * 
	 * @param chromosomeLength The length of the individuals chromosome
	 */
	public Individual(int chromosomeLength) {
		// Create random individual
		int[] individual;
		individual = new int[chromosomeLength];

		for (int gene = 0; gene < chromosomeLength; gene++) {
			individual[gene] = gene;
		}

		this.chromosome = individual;
	}

	/**
	 * Gets individual's chromosome
	 * 
	 * @return The individual's chromosome
	 */
	public int[] getChromosome() {
		return this.chromosome;
	}

	/**
	 * Gets individual's chromosome length
	 * 
	 * @return The individual's chromosome length
	 */
	public int getChromosomeLength() {
		return this.chromosome.length;
	}

	/**
	 * Set gene at offset
	 * 
	 * @param gene   gene
	 * @param offset offset
	 */
	public void setGene(int offset, int gene) {
		this.chromosome[offset] = gene;
	}

	/**
	 * Get gene at offset
	 * 
	 * @param offset offset
	 * @return gene
	 */
	public int getGene(int offset) {
		return this.chromosome[offset];
	}

	/**
	 * Store individual's fitness
	 * 
	 * @param fitness The individuals fitness
	 */
	public void setFitness(double fitness) {
		this.fitness = fitness;
	}

	/**
	 * Gets individual's fitness
	 * 
	 * @return The individual's fitness
	 */
	public double getFitness() {
		return this.fitness;
	}

	public String toString() {
		String output = " ";
		for (int gene = 0; gene < this.chromosome.length; gene++) {
			output += this.chromosome[gene] + 1;

			if (gene != this.chromosome.length - 1)
				output += " -> ";
		}
		return output;
	}

	/**
	 * Search for a specific integer gene in this individual.
	 * 
	 * @param gene gene
	 * @return false if gene not found or true if gene is found.
	 */
	public boolean containsGene(int gene) {
		for (int j : this.chromosome) {
			if (j == gene) {
				return true;
			}
		}
		return false;
	}

}
