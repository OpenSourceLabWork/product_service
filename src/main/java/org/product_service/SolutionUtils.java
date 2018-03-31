package org.product_service;

import java.util.List;

import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.JMetalLogger;
import org.uma.jmetal.util.fileoutput.impl.DefaultFileOutputContext;
import org.uma.jmetal.util.pseudorandom.JMetalRandom;

public class SolutionUtils {

	public static void printFinalSolutionSet(List<? extends Solution<?>> population) {

	    new SolutionOutPut(population)
	        .setSeparator("\t")
	        .setVarFileOutputContext(new DefaultFileOutputContext("VAR.tsv"))
	        .setFunFileOutputContext(new DefaultFileOutputContext("FUN.tsv"))
	        .print();

//	    JMetalLogger.logger.info("Random seed: " + JMetalRandom.getInstance().getSeed());
//	    JMetalLogger.logger.info("Objectives values have been written to file FUN.tsv");
//	    JMetalLogger.logger.info("Variables values have been written to file VAR.tsv");
	  }
}
