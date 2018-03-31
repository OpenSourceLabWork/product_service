package org.product_service.optimization;

import java.util.Arrays;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;

public class ProductProblems extends AbstractIntegerProblem{
	
	public ProductProblems() {
		setNumberOfVariables(5);
		setNumberOfObjectives(1);
		setName("ProductProblem");
		
		List<Integer> lowerLimit = Arrays.asList(500, 100, 10, 50, 12);
		List<Integer> upperLimit = Arrays.asList(2000, 300,100, 100, 24);

		setUpperLimit(upperLimit);
		setLowerLimit(lowerLimit);
	}

	public void evaluate(IntegerSolution solution) {
		double DRP, Du, Dr, Dt, Dp;
		double obj2 = 0;

		DRP = solution.getVariableValue(0);
		Dp = solution.getVariableValue(1);
		Du = solution.getVariableValue(2);
		Dr = solution.getVariableValue(3);
		Dt = solution.getVariableValue(4);

		obj2 = (DRP - (Dp + (Du - Dr))) / Dt;
		obj2 = obj2+(obj2*0.2);
		
		System.out.println(DRP + " , " + Dp	+ " , " + Du + " , " + Dr + " , " + Dt +" obj2= "+obj2);

		solution.setObjective(0, obj2);
		
	}

}
