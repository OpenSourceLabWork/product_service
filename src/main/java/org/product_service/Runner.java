package org.product_service;

import java.io.FileNotFoundException;
import java.util.List;

import org.product_service.parameterstuning.AbstractAlgorithmRunnerEdited;
import org.uma.jmetal.algorithm.Algorithm;
import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAIIBuilder;
import org.uma.jmetal.operator.CrossoverOperator;
import org.uma.jmetal.operator.MutationOperator;
import org.uma.jmetal.operator.SelectionOperator;
import org.uma.jmetal.operator.impl.crossover.IntegerSBXCrossover;
import org.uma.jmetal.operator.impl.mutation.IntegerPolynomialMutation;
import org.uma.jmetal.operator.impl.selection.BinaryTournamentSelection;
import org.uma.jmetal.problem.Problem;
import org.uma.jmetal.solution.IntegerSolution;
import org.uma.jmetal.util.AlgorithmRunner;
import org.uma.jmetal.util.JMetalLogger;
import org.uma.jmetal.util.ProblemUtils;

/**
 * Hello world!
 *
 */
public class Runner extends AbstractAlgorithmRunnerEdited {
	double cross = 0.4;
	double mut = 1.0;
	int pop = 2000;
	int eval = 4000;

	public void run(String[] args) throws FileNotFoundException {

		Problem<IntegerSolution> problem;
		Algorithm<List<IntegerSolution>> algorithm;
		CrossoverOperator<IntegerSolution> crossover;
		MutationOperator<IntegerSolution> mutation;
		SelectionOperator<List<IntegerSolution>, IntegerSolution> selection;

		String problemName = null;

		String referenceParetoFront = "";
		if (args.length == 1) {
			problemName = args[0];
//			this.cross = 0.8;
//			this.mut = 0.6;
//			this.eval = 2500;
//			this.pop = 500;
		} else if (args.length == 2) {
			problemName = args[0];
			referenceParetoFront = args[1];
//			this.cross = Double.parseDouble(args[2]);
//			this.mut = Double.parseDouble(args[3]);
//			this.eval = Integer.parseInt(args[4]);
//			this.pop = Integer.parseInt(args[5]);

		} else {
			System.err.println("No problem provided.");
			System.exit(0);
			// problemName =
			// "org.uma.jmetal.problem.multiobjective.ProductService" ;
			// referenceParetoFront = "pareto_fronts/ProductService.pf";
		}

		problem = ProblemUtils.<IntegerSolution> loadProblem(problemName);

		double crossoverProbability = cross;
		double crossoverDistributionIndex = 20.0;
		crossover = new IntegerSBXCrossover(crossoverProbability, crossoverDistributionIndex);

		double mutationProbability = mut / problem.getNumberOfVariables();
		double mutationDistributionIndex = 20.0;
		mutation = new IntegerPolynomialMutation(mutationProbability, mutationDistributionIndex);

		selection = new BinaryTournamentSelection<IntegerSolution>();

		algorithm = new NSGAIIBuilder<IntegerSolution>(problem, crossover, mutation).setSelectionOperator(selection)
				.setMaxEvaluations(eval).setPopulationSize(pop).build();

		AlgorithmRunner algorithmRunner = new AlgorithmRunner.Executor(algorithm).execute();

		List<IntegerSolution> population = algorithm.getResult();
		long computingTime = algorithmRunner.getComputingTime();

		JMetalLogger.logger.info("Total execution time: " + computingTime + "ms");

		SolutionUtils.printFinalSolutionSet(population);
		if (!referenceParetoFront.equals("")) {
			printQualityIndicators(population, referenceParetoFront);
		}
	}
}
