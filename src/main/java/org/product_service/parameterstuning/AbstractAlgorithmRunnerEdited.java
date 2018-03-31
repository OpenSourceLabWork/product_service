package org.product_service.parameterstuning;

import java.io.FileNotFoundException;
import java.util.List;

import org.uma.jmetal.qualityindicator.impl.Epsilon;
import org.uma.jmetal.qualityindicator.impl.ErrorRatio;
import org.uma.jmetal.qualityindicator.impl.InvertedGenerationalDistance;
import org.uma.jmetal.qualityindicator.impl.InvertedGenerationalDistancePlus;
import org.uma.jmetal.qualityindicator.impl.Spread;
import org.uma.jmetal.qualityindicator.impl.hypervolume.PISAHypervolume;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.JMetalLogger;
import org.uma.jmetal.util.fileoutput.SolutionListOutput;
import org.uma.jmetal.util.fileoutput.impl.DefaultFileOutputContext;
import org.uma.jmetal.util.front.Front;
import org.uma.jmetal.util.front.imp.ArrayFront;
import org.uma.jmetal.util.front.util.FrontNormalizer;
import org.uma.jmetal.util.front.util.FrontUtils;
import org.uma.jmetal.util.point.util.PointSolution;

/**
 * Abstract class for Runner classes
 *
 * @author Antonio J. Nebro <antonio@lcc.uma.es>
 */
public abstract class AbstractAlgorithmRunnerEdited {
  /**
   * Write the population into two files and prints some data on screen
   * @param population
   */
	public static Double gd;
	public static Double sv;
	public static Double hv;
	public static Double ep;
	
	
  public static void printFinalSolutionSet(List<? extends Solution<?>> population) {

    new SolutionListOutput(population)
        .setSeparator("\t")
        .setVarFileOutputContext(new DefaultFileOutputContext("VAR.tsv"))
        .setFunFileOutputContext(new DefaultFileOutputContext("FUN.tsv"))
        .print();

//    JMetalLogger.logger.info("Random seed: " + JMetalRandom.getInstance().getSeed());
//    JMetalLogger.logger.info("Objectives values have been written to file FUN.tsv");
//    JMetalLogger.logger.info("Variables values have been written to file VAR.tsv");
  }

  /**
   * Print all the available quality indicators
   * @param population
   * @param paretoFrontFile
   * @throws FileNotFoundException
   */
  public static <S extends Solution<?>> void printQualityIndicators(List<S> population, String paretoFrontFile)
      throws FileNotFoundException {
    Front referenceFront = new ArrayFront(paretoFrontFile);
    FrontNormalizer frontNormalizer = new FrontNormalizer(referenceFront) ;

    Front normalizedReferenceFront = frontNormalizer.normalize(referenceFront) ;
    Front normalizedFront = frontNormalizer.normalize(new ArrayFront(population)) ;
    List<PointSolution> normalizedPopulation = FrontUtils
        .convertFrontToSolutionList(normalizedFront) ;

    // custom variable for printing matrix
    gd = new GenerationalDistanceEdited<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation);
    sv = new Spread<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation);
    hv = new PISAHypervolume<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation);
    ep = new Epsilon<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation);
    
    
    String outputString = "\n" ;
    outputString += "Hypervolume (N) : " +
        new PISAHypervolume<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation) + "\n";
    outputString += "Hypervolume     : " +
        new PISAHypervolume<S>(referenceFront).evaluate(population) + "\n";
    outputString += "Epsilon (N)     : " +
        new Epsilon<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation) +
        "\n" ;
    outputString += "Epsilon         : " +
        new Epsilon<S>(referenceFront).evaluate(population) + "\n" ;
    outputString += "GD (N)          : " +
        new GenerationalDistanceEdited<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation) + "\n";
    outputString += "GD              : " +
        new GenerationalDistanceEdited<S>(referenceFront).evaluate(population) + "\n";
    outputString += "IGD (N)         : " +
        new InvertedGenerationalDistance<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation) + "\n";
    outputString +="IGD             : " +
        new InvertedGenerationalDistance<S>(referenceFront).evaluate(population) + "\n";
    outputString += "IGD+ (N)        : " +
        new InvertedGenerationalDistancePlus<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation) + "\n";
    outputString += "IGD+            : " +
        new InvertedGenerationalDistancePlus<S>(referenceFront).evaluate(population) + "\n";
    outputString += "Spread (N)      : " +
        new Spread<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation) + "\n";
    outputString += "Spread          : " +
        new Spread<S>(referenceFront).evaluate(population) + "\n";
//    outputString += "R2 (N)          : " +
//        new R2<List<DoubleSolution>>(normalizedReferenceFront).runAlgorithm(normalizedPopulation) + "\n";
//    outputString += "R2              : " +
//        new R2<List<? extends Solution<?>>>(referenceFront).runAlgorithm(population) + "\n";
    outputString += "Error ratio     : " +
        new ErrorRatio<List<? extends Solution<?>>>(referenceFront).evaluate(population) + "\n";
    
    JMetalLogger.logger.info(outputString);
  }
}
