package org.product_service;

import java.util.Arrays;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractIntegerProblem;
import org.uma.jmetal.solution.IntegerSolution;

@SuppressWarnings("serial")
public class ProductServiceProblem extends AbstractIntegerProblem{
	
	public ProductServiceProblem() {
		setNumberOfVariables(10);
		setNumberOfObjectives(2);
		setName("ProductServiceProblem");
		

//		Testing
//		List<Integer> lowerLimit = Arrays.asList(100, 100, 1, 10, 1, 3500, 1500, 400, 100, 12);
//		List<Integer> upperLimit = Arrays.asList(1000, 1000, 10 ,100, 3, 4000, 2000, 600, 200, 24);
		
		
//		//BENCHMARK Highend
//		List<Integer> lowerLimit = Arrays.asList(100,100, 1, 50, 1, 3500, 1500, 400, 100, 12);
//		List<Integer> upperLimit = Arrays.asList(1000, 1000, 20 ,200, 5,4000, 2000, 600, 200, 24);

		//BENCHMARK lowend
//		List<Integer> lowerLimit = Arrays.asList(100,100, 1, 50, 1, 1000, 150, 0, 50, 12);
//		List<Integer> upperLimit = Arrays.asList(1000, 1000, 20 ,200, 5,2000, 300,100, 100, 24);
	  
	//	BENCHMARK Midend
//		List<Integer> lowerLimit = Arrays.asList(100,100, 1, 50, 1, 2000, 500, 50, 50, 12);
//		List<Integer> upperLimit = Arrays.asList(1000, 1000, 20 ,200, 5,3000, 1000, 300, 100, 24);


// for testing negative values
		/// for maximum product and minimum service
				//List<Integer> lowerLimit = Arrays.asList(-1000,-1000, -20 ,-200, -10, 3000,1000, 500, 100, 24);
				//List<Integer> upperLimit = Arrays.asList(-500, -500, -10, -100, -5, 4000, 2000, 1000, 200, 24);
		/// for maximum product and maximum service
				List<Integer> lowerLimit = Arrays.asList(-1000,-1000, -20 ,-200, -10,-4000, -2000, -1000, -200, -24);
				List<Integer> upperLimit = Arrays.asList(-500, -500, -10, -100, -5, -3000,-1000, -500, -100, -24);

			//  high-end product +  (PREMIUM)
//				List<Integer> lowerLimit = Arrays.asList(500, 500, 10, 100, 5, 3500, 1500, 400, 100, 24);
//				List<Integer> upperLimit = Arrays.asList(1500,1500, 30 ,500, 10, 4000, 2000, 600, 200, 24);
		
			//  Mid-End Data Extensive (PREMIUM)
//				List<Integer> lowerLimit = Arrays.asList(100, 100, 10, 100, 5,2000, 500, 50, 50, 12);
//				List<Integer> upperLimit = Arrays.asList(300, 300, 20 ,200, 10,3000, 1000, 300, 100, 24);
		
//			//  Low-End Data Extensive (PREMIUM)
//			  List<Integer> lowerLimit = Arrays.asList(100, 100, 10, 100, 5,1000, 150, 0, 50, 12);
//			  List<Integer> upperLimit = Arrays.asList(300, 300, 20 ,200, 10,2000, 300,100, 100, 24);

		
				
				
			//  Mid-End + (PREMIUM)
//				List<Integer> lowerLimit = Arrays.asList(500, 500, 10, 100, 5,2001, 1500, 500, 100, 24);
//				List<Integer> upperLimit = Arrays.asList(1000,1000, 20 ,200, 10,3000, 2000, 800, 150, 24);
	
//			//  Low-End + (PREMIUM)
//			  List<Integer> lowerLimit = Arrays.asList(500, 500, 10, 100, 5,1000, 800, 400, 50,24);
//			  List<Integer> upperLimit = Arrays.asList(1000,1000, 20 ,200, 10,2000, 1000,600, 100, 24);
		
		
//			//  high-end+ (STANDARD)
//				List<Integer> lowerLimit = Arrays.asList(400, 300, 10, 100, 3, 3000,1000, 300, 100, 24);
//				List<Integer> upperLimit = Arrays.asList(700, 500,15 ,200, 5, 4000, 2000, 600, 200, 24);
		
//			//  Mid-End +(STANDARD)
//				List<Integer> lowerLimit = Arrays.asList(400, 300, 10, 100, 3,2001, 1500, 500, 100, 24);
//				List<Integer> upperLimit = Arrays.asList(700, 500,15 ,200, 5,3000, 2000, 800, 150, 24);
		
//			//  Low-End + (STANDARD)
//			  List<Integer> lowerLimit = Arrays.asList(400, 300, 10, 100, 3,1000, 800, 400, 50,24);
//			  List<Integer> upperLimit = Arrays.asList(700, 500,15 ,200, 5,2000, 1000,600, 100, 24);
		
		  	//  high-end + (BASIC)
//				List<Integer> lowerLimit = Arrays.asList(100, 300, 2, 100, 1, 3000,1000, 300, 100, 24);
//				List<Integer> upperLimit = Arrays.asList(300, 500, 10 ,200, 3, 4000, 2000, 600, 200, 24);
//		
			//  Mid-End + (BASIC)
//				List<Integer> lowerLimit = Arrays.asList(100, 300, 2, 100, 1,2001, 1500, 500, 100, 24);
//				List<Integer> upperLimit = Arrays.asList(300, 500, 10 ,200, 3,3000, 2000, 800, 150, 24);
		
			//  Low-End SMS  EXTENSIVE(BASIC)
//			List<Integer> lowerLimit = Arrays.asList(100, 300, 2, 100, 1,1000, 800, 400, 50,24);
//			List<Integer> upperLimit = Arrays.asList(300, 500, 10 ,200, 3,2000, 1000,600, 100, 24);
			
	//  Low-End SMS  EXTENSIVE(BASIC) for testing negative
//		List<Integer> lowerLimit = Arrays.asList(-300, -500, -10 ,-200, -3,1000, 100, 100, 50,24);
//		List<Integer> upperLimit = Arrays.asList(-100, -300, -2, -100, -1,2000,200,400, 100, 24);
		
				
		setUpperLimit(upperLimit);
		setLowerLimit(lowerLimit);

	}

	/** Evaluate() method */
	public void evaluate(IntegerSolution solution) {
		double IDQ,NoVC, NoTM, NoVCR, IDQR, Drp, Du, Dr, Dt, Dp;
		double obj1, obj2 = 0;

		NoVC = solution.getVariableValue(0);
		NoTM = solution.getVariableValue(1);
		IDQ = solution.getVariableValue(2);
		NoVCR = solution.getVariableValue(3);
		IDQR = solution.getVariableValue(4);
		Drp = solution.getVariableValue(5);
		Dp = solution.getVariableValue(6);
		Du = solution.getVariableValue(7);
		Dr = solution.getVariableValue(8);
		Dt = solution.getVariableValue(9);

//		obj1 = (0.10 * (NoVC)) + (0.05 * NoTM) + (1.75 * IDQ) - ((0.1 * NoVCR + 1.75 * IDQR));
//		obj2 = (DRP - (Dp + (Du - Dr))) / Dt;
//		
		obj1 = (0.10 * (NoVC+NoVCR)) + (0.05 * NoTM) + (0.35 * (IDQ +IDQR));
		obj2 = (Drp - ( Dp + Du + Dr)) / Dt;
		
		
//		obj1 = obj1+(obj1*0.2);
//		obj2 = obj2+(obj2*0.2);
		
//		System.out.println(NoVC + " , " + NoTM + " , " + IDQ + " , " + NoVCR + " , " + IDQR + " , " + DRP + " , " + Dp
//				+ " , " + Du + " , " + Dr + " , " + Dt +" obj1= "+obj1+" obj2= "+obj2);

//		if (obj1 <= f1max && obj1 >= f1min && obj2 <= f2max && obj2 >= f2min) {
			solution.setObjective(0, obj1);
			solution.setObjective(1, obj2);
//			System.out.println("object : " + obj1 + " object 2 :" + obj2);
//		}
	}
}
