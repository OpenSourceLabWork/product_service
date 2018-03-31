package org.product_service.optimization;

import java.util.Arrays;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;

public class ServiceProblems extends AbstractIntegerProblem{
	
	public ServiceProblems() {
		setNumberOfVariables(5);
		setNumberOfObjectives(1);
		setName("ProductServiceProblem");
		
		List<Integer> lowerLimit = Arrays.asList(550, 550, 2, 55, 2);
		List<Integer> upperLimit = Arrays.asList(1000, 1000, 10 ,100, 3);

			
		setUpperLimit(upperLimit);
		setLowerLimit(lowerLimit);

	}

	public void evaluate(IntegerSolution solution) {
		double IDQ,NoVC, NoTM, NoVCR, IDQR;
		double obj1= 0;

		NoVC = solution.getVariableValue(0);
		NoTM = solution.getVariableValue(1);
		IDQ = solution.getVariableValue(2);
		NoVCR = solution.getVariableValue(3);
		IDQR = solution.getVariableValue(4);

		obj1 = (0.10 * (NoVC)) + (0.05 * NoTM) + (1.75 * IDQ) - ((0.1 * NoVCR + 1.75 * IDQR));
		
		obj1 = obj1+(obj1*0.2);
		
		System.out.println(NoVC + " , " + NoTM + " , " + IDQ + " , " + NoVCR + " , " + IDQR +" obj1= "+obj1);

//		if (obj1 <= f1max && obj1 >= f1min && obj2 <= f2max && obj2 >= f2min) {
			solution.setObjective(0, obj1);
//		solution.setObjective(1, obj2);
		
	}

}
