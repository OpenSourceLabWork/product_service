package org.product_service;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.JMetalException;
import org.uma.jmetal.util.fileoutput.FileOutputContext;
import org.uma.jmetal.util.fileoutput.impl.DefaultFileOutputContext;

public class SolutionOutPut {

	private FileOutputContext varFileContext;
	private FileOutputContext funFileContext;
	private String varFileName = "VAR";
	private String funFileName = "FUN";
	private String separator = "\t";
	private List<? extends Solution<?>> solutionList;
	private boolean selectFeasibleSolutions;
	private List<Boolean> isObjectiveToBeMinimized;

	public SolutionOutPut(List<? extends Solution<?>> solutionList) {
		varFileContext = new DefaultFileOutputContext(varFileName);
		funFileContext = new DefaultFileOutputContext(funFileName);
		varFileContext.setSeparator(separator);
		funFileContext.setSeparator(separator);
		this.solutionList = solutionList;
		selectFeasibleSolutions = false;
		isObjectiveToBeMinimized = null;
	}

	public SolutionOutPut setVarFileOutputContext(FileOutputContext fileContext) {
		varFileContext = fileContext;

		return this;
	}

	public SolutionOutPut setFunFileOutputContext(FileOutputContext fileContext) {
		funFileContext = fileContext;

		return this;
	}

	public SolutionOutPut setObjectiveMinimizingObjectiveList(List<Boolean> isObjectiveToBeMinimized) {
		this.isObjectiveToBeMinimized = isObjectiveToBeMinimized;

		return this;
	}

	public SolutionOutPut selectFeasibleSolutions() {
		selectFeasibleSolutions = true;
		return this;
	}

	public SolutionOutPut setSeparator(String separator) {
		this.separator = separator;
		varFileContext.setSeparator(this.separator);
		funFileContext.setSeparator(this.separator);

		return this;
	}

	public void print() {
		if (isObjectiveToBeMinimized == null) {
			printObjectivesToFile(funFileContext, solutionList);
		} else {
			printObjectivesToFile(funFileContext, solutionList, isObjectiveToBeMinimized);
		}
		printVariablesToFile(varFileContext, solutionList);
	}

	public void printVariablesToFile(FileOutputContext context, List<? extends Solution<?>> solutionList) {
		BufferedWriter bufferedWriter = context.getFileWriter();

		try {
			if (solutionList.size() > 0) {
				int numberOfVariables = solutionList.get(0).getNumberOfVariables();
				for (int i = 0; i < solutionList.size(); i++) {
					for (int j = 0; j < numberOfVariables; j++) {
						bufferedWriter.write(solutionList.get(i).getVariableValueString(j) + context.getSeparator());
					}
					bufferedWriter.newLine();
				}
			}

			bufferedWriter.close();
		} catch (IOException e) {
			throw new JMetalException("Error writing data ", e);
		}

	}

	public void printObjectivesToFile(FileOutputContext context, List<? extends Solution<?>> solutionList) {
		BufferedWriter bufferedWriter = context.getFileWriter();

		try {

			if (solutionList.size() > 0) {
				int numberOfObjectives = solutionList.get(0).getNumberOfObjectives();
				for (int i = 0; i < solutionList.size(); i++) {
//					double fun = solutionList.get(i).getObjective(0);
//					double fun1 = solutionList.get(i).getObjective(1);
//					bufferedWriter.write(fun + context.getSeparator());
//					bufferedWriter.write(fun1 + context.getSeparator());
					
					double fun1 = 0, fun2 = 0;
					for (int j = 0; j < numberOfObjectives; j++) {
						double fun = solutionList.get(i).getObjective(j);
						fun = (fun < 0) ? fun*(-1) : fun;
						if (j == 0) {
							if (fun > 10 && fun < 30) {
								fun1 = fun;
							}
						}else{
							if(fun > 10 && fun <30){
								fun2 = fun;
								if(fun1 !=0){
									bufferedWriter.write(fun1 + context.getSeparator());
									bufferedWriter.write(fun2 + context.getSeparator());
								}
							}
						}
					}
		
				System.out.println();
			    bufferedWriter.newLine();
				}
			}
//
			if (solutionList.size() > 0) {
				int numberOfObjectives = solutionList.get(0).getNumberOfObjectives();
				for (int i = 0; i < solutionList.size(); i++) {
					for (int j = 0; j < numberOfObjectives; j++) {	
						double fun = solutionList.get(i).getObjective(j);
						if (fun > 1000 && fun <  4000) {
							bufferedWriter.write(fun + context.getSeparator());	
						}
						
					}
					bufferedWriter.newLine();
				}
			}
//// needs to be changes until here
			
			bufferedWriter.close();
		} catch (IOException e) {
			throw new JMetalException("Error printing objecives to file: ", e);
		}
	}

	public void printObjectivesToFile(FileOutputContext context, List<? extends Solution<?>> solutionList,
			List<Boolean> minimizeObjective) {
		BufferedWriter bufferedWriter = context.getFileWriter();

		try {
			if (solutionList.size() > 0) {
				int numberOfObjectives = solutionList.get(0).getNumberOfObjectives();
				if (numberOfObjectives != minimizeObjective.size()) {
					throw new JMetalException(
							"The size of list minimizeObjective is not correct: " + minimizeObjective.size());
				}
				for (int i = 0; i < solutionList.size(); i++) {
					for (int j = 0; j < numberOfObjectives; j++) {
						if (minimizeObjective.get(j)) {
							bufferedWriter.write(solutionList.get(i).getObjective(j) + context.getSeparator());
						} else {
							bufferedWriter.write(-1.0 * solutionList.get(i).getObjective(j) + context.getSeparator());
						}
					}
					bufferedWriter.newLine();
				}
			}

			bufferedWriter.close();
		} catch (IOException e) {
			throw new JMetalException("Error printing objecives to file: ", e);
		}
	}

	/*
	 * Wrappers for printing with default configuration
	 */
	public void printObjectivesToFile(String fileName) throws IOException {
		printObjectivesToFile(new DefaultFileOutputContext(fileName), solutionList);
	}

	public void printObjectivesToFile(String fileName, List<Boolean> minimizeObjective) throws IOException {
		printObjectivesToFile(new DefaultFileOutputContext(fileName), solutionList, minimizeObjective);
	}

	public void printVariablesToFile(String fileName) throws IOException {
		printVariablesToFile(new DefaultFileOutputContext(fileName), solutionList);
	}
}