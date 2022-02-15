<p align="center">
  <img height="300" src="https://github.com/rohan-bhautoo/Travelling-Salesman-Problem/blob/main/Screenshots/Travelling-Salesman-Problem.png">
</p>
<h1 align="center">Travelling Salesman Problem</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.2.0-brightgreen.svg" />
  <img alt="Java" src="https://img.shields.io/badge/Java-ED8B00?logo=java&logoColor=white" />
  <img alt="JDK" src="https://img.shields.io/badge/JDK->=11.0.14-blue.svg" />
</p>

## Description
> The travelling salesman problem is to go to each city exactly once and return to the start. A system was built, in Java, to solve this problem by providing the shortest path and the length of the path.

### 🏠 [Homepage](/Travelling%20Salesman%20Problem/src/TSP.java)

## Prerequisite

### Java Development Kit (JDK) 
> JDK version 11 is used for this project as it includes the JavaFX library. Download it [here](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html).
> 
> For Windows:
```sh
set JAVA_HOME="C:\[Path to folder]\Java\jdk-11.0.14
```
> Enter the Environment Variables in System Properties.
> 
> Add **%JAVA_HOME%\bin** into Path.
```sh
%JAVA_HOME%\bin
```
<p align="center">
  <img height="400" src="https://github.com/rohan-bhautoo/Point-Of-Sales-System/blob/master/Screenshots/Env%20Variable.png">
</p>

## Genetic Algorithm
  > Genetic algorithms are designed to solve problems by using the same processes as in nature. The processes use a combination of selection, recombination, and mutation to evolve a solution to a problem.
<p align="center">
  <img height="400" src="https://github.com/rohan-bhautoo/Travelling-Salesman-Problem/blob/main/Screenshots/genetic-algorithm-process.png">
</p>

> The algorithm starts by initializing a population of candidate solutions of City objects. The data will be obtained from text files containing the name, x and y coordinates of the city.
> Next, the population is evaluated by assigning a fitness value to each individual in the population. 
> 
> After evaluation, the algorithm will terminate if a condition is met. In the project, the termination condition is executed if the algorithm has reached a fixed number of generations. 
> 
> If the condition is not met, the population goes through a selection process where candidate solutions are picked based on their fitness score, to breed the next generation of solutions. 
> 
> The crossover and mutation stages are where new individuals are created for the next generation. 
> 
> The new population goes back to the evaluation step and the process starts again. 
> 
> Finally, if the termination condition is met, the algorithm will show the results to the user. 

### City
> The [City.java](/Travelling%20Salesman%20Problem/src/City.java) class constructor class for City objects. It contains parameters such as the name, x and y coordinates of the city. Additionally, the distanceFrom() function calculates the distance between two cities using Euclidean distance formula.
```java
public double distanceFrom(City city) {
  // Give difference in x,y
  double deltaXSq = Math.pow((city.getX() - this.getX()), 2);
  double deltaYSq = Math.pow((city.getY() - this.getY()), 2);

  // Calculate shortest path
  return Math.sqrt(Math.abs(deltaXSq + deltaYSq));
}
```

### Individual
> The [Individual.java](/Travelling%20Salesman%20Problem/src/Individual.java) class represents a single candidate solution and its chromosome. The constructor accepts an integer which represents the length of the chromosome and an integer array which is used as the chromosome. The class also get the individual’s fitness value.

#### Crossover
> A gene in the chromosome must be unique or else it will create an invalid solution since a city should be visited only once. The ordered crossover method has been used in this project. In this method, a subset of the first parent’s chromosome is selected and added to the child chromosome in the same position.
<p align="center">
  <img height="150" src="https://github.com/rohan-bhautoo/Travelling-Salesman-Problem/blob/main/Screenshots/crossover.png">
</p>

> The information from parent 2 is then added to the offspring by starting from the end position of the subset. If the gene is present in the offspring chromosome, it is not added.
<p align="center">
  <img height="150" src="https://github.com/rohan-bhautoo/Travelling-Salesman-Problem/blob/main/Screenshots/crossover_offspring.png">
</p>

### Population
> The [Population.java](/Travelling%20Salesman%20Problem/src/Population.java) class represents a population of individuals. It holds different methods to access or update the individuals in the population. It also has the total fitness score of the population.
```java
public Individual getFittest(int offset) {
  // Order population by fitness
  Arrays.sort(this.population, (o1, o2) -> {
    if (o1.getFitness() > o2.getFitness()) {
      return -1;
    } else if (o1.getFitness() < o2.getFitness()) {
      return 1;
    }
    return 0;
  });

  // Return the fittest individual
  return this.population[offset];
}
```

#### Mutation
> The swap mutation has been applied since it is an easy solution. The swap mutation algorithm works by simply swapping the genetic information at two points. This process ensures no duplicate genes are created and that any resulting offspring will be valid solutions.
<p align="center">
  <img height="150" src="https://github.com/rohan-bhautoo/Travelling-Salesman-Problem/blob/main/Screenshots/mutation.png">
</p>

### Route
> The route class calculates the total route distance in the array of City objects.
```java
public double getDistance() {
  if (this.distance > 0) {
    return this.distance;
  }

  // Loop over cities in route and calculate route distance
  double totalDistance = 0;
  for (int cityIndex = 0; cityIndex + 1 < this.route.length; cityIndex++) {
    totalDistance += this.route[cityIndex].distanceFrom(this.route[cityIndex + 1]);
  }

  totalDistance += this.route[this.route.length - 1].distanceFrom(this.route[0]);
  this.distance = totalDistance;

  return totalDistance;
}
```

## Usage
> Compile all the java files using:
```sh
javac *.java
```
> Then, execute the algorithm
```sh
java TSP
```
> *Note: [test1tsp.txt](/Travelling%20Salesman%20Problem/src/test1tsp.txt), [test2atsp.txt](/Travelling%20Salesman%20Problem/src/test2atsp.txt) and [test3atsp.txt](/Travelling%20Salesman%20Problem/src/test3atsp.txt) are used to test the algorithm.*

## Author

👤 **Rohan Bhautoo**
* Github: [@rohan-bhautoo](https://github.com/rohan-bhautoo)
* LinkedIn: [@rohan-bhautoo](https://linkedin.com/in/rohan-bhautoo)

## Show your support

Give a ⭐️ if this project helped you!
