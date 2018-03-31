package org.product_service.optimization;

import java.util.Arrays;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;

public class RuleBasedOptimization extends AbstractIntegerProblem{

	public RuleBasedOptimization() {
		setNumberOfVariables(10);
		setNumberOfObjectives(2);
		setName("ProductServiceProblem");
		
		List<Integer> lowerLimit = Arrays.asList(100, 100, 10, 100, 5,1000, 150, 0, 50, 12);
		List<Integer> upperLimit = Arrays.asList(300, 300, 20 ,200, 10,2000, 300,100, 100, 24);
				
		setUpperLimit(upperLimit);
		setLowerLimit(lowerLimit);
	}
	public void evaluate(IntegerSolution solution) {
		
		double IDQ,NoVC, NoTM, NoVCR, IDQR, DRP, Du, Dr, Dt, Dp;
		double obj1, obj2 = 0;

		NoVC = solution.getVariableValue(0);
		NoTM = solution.getVariableValue(1);
		IDQ = solution.getVariableValue(2);
		NoVCR = solution.getVariableValue(3);
		IDQR = solution.getVariableValue(4);
		DRP = solution.getVariableValue(5);
		Dp = solution.getVariableValue(6);
		Du = solution.getVariableValue(7);
		Dr = solution.getVariableValue(8);
		Dt = solution.getVariableValue(9);

		obj1 = (0.10 * (NoVC)) + (0.05 * NoTM) + (1.75 * IDQ) - ((0.1 * NoVCR + 1.75 * IDQR));
		obj2 = (DRP - (Dp + (Du - Dr))) / Dt;
		
		obj1 = obj1+(obj1*0.2);
		obj2 = obj2+(obj2*0.2);
		
		System.out.println(NoVC + " , " + NoTM + " , " + IDQ + " , " + NoVCR + " , " + IDQR + " , " + DRP + " , " + Dp
				+ " , " + Du + " , " + Dr + " , " + Dt +" obj1= "+obj1+" obj2= "+obj2);

			solution.setObjective(0, obj1);
			solution.setObjective(1, obj2);

	}

}
