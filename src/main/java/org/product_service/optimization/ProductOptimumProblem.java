package org.product_service.optimization;

import java.util.Arrays;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;

public class ProductOptimumProblem extends AbstractIntegerProblem{
	
	public ProductOptimumProblem() {
		setNumberOfVariables(9);
		setNumberOfObjectives(1);
		setName("ProductOptimumProblem");
		
		List<Integer> lowerLimit = Arrays.asList(120, 1, 6, 1200,16, 1, 1,1,16);
		List<Integer> upperLimit = Arrays.asList(180, 2, 8, 3000,128, 4,16,16, 128);
		
		setUpperLimit(upperLimit);
		setLowerLimit(lowerLimit);

	}

	public void evaluate(IntegerSolution solution) {
		double weight, sim, size, battery, internal, ram, primary, secondry, external;
		double obj1 = 0;

		weight = solution.getVariableValue(0);
		sim = solution.getVariableValue(1);
		size = solution.getVariableValue(2);
		battery = solution.getVariableValue(3);
		internal = solution.getVariableValue(4);
		ram = solution.getVariableValue(5);
		primary = solution.getVariableValue(6);
		secondry = solution.getVariableValue(7);
		external = solution.getVariableValue(8);

		obj1 = (weight*0.423)+(sim*0.488)+(size*0.413)+(battery*0.499)+(internal*0.497)+(ram*0.467)+
				(primary*0.433)+(secondry*0.421)+(external*0.434);
	
		System.out.println(weight+" "+sim+" "+size+" "+battery+" "+internal+" "+ram+" "+primary+" "+secondry+" "+external);
		
		solution.setObjective(0, obj1);
		
	}
	
	

}
