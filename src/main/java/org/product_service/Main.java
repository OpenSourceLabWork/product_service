package org.product_service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.product_service.parameterstuning.AbstractAlgorithmRunnerEdited;

public class Main {

	public static void main(String[] args) throws IOException {
		try {

			BufferedWriter writer = new BufferedWriter(new FileWriter(new File("file3.txt")));
		
			double[] mutation = {0.1,0.2,0.4,0.6,0.8};
			double[] crossover = {0.2,0.4,0.6,0.8,1.0};
			int[] population = {500,1000,1500,2000,2500};
			int[] evaluation = {2500,3500,4500,5500,6500};

			System.out.println("Multi-Object problem loading...");
		//	new Runner().run(new String[] { "org.product_service.ProductServiceProblem", "lib/ProductServiceProblem.pf" });
		//	new Runner().run(new String[] { "org.product_service.optimization.ProductProblems", "lib/ProductProblem.pf" });
		//	new Runner().run(new String[] { "org.product_service.optimization.ServiceProblems", "lib/ServiceProblem.pf" });
		//	new Runner().run(new String[] { "org.product_service.optimization.ProductPriceProblem", "lib/ProductProblem2.pf" });
			writer.write("crossover"+"\t"+"mutation"+"\t"+"population"+"\t"+"evaluation"+"\t"+"GD"+"\n\n");
			
			/*From here*/
//			for(int i=0;i<crossover.length;i++){
//				for(int j=0;j<mutation.length;j++){
//					for(int k=0;k<population.length;k++){
//						for(int l=0;l<evaluation.length;l++){
//							 new Runner().run(new String[] { "org.product_service.ProductServiceProblem", "lib/ProductServiceProblem.pf",crossover[i]+"",mutation[j]+"",population[k]+"",evaluation[l]+"" });
//							 
//							 writer.write(crossover[i]+"\t"+mutation[j]+"\t"+population[k]+"\t"+evaluation[l]+"\t"+
//									 round(AbstractAlgorithmRunnerEdited.gd,4)+"\t"+
//									 round(AbstractAlgorithmRunnerEdited.sv,4)+"\t"+
////									 round(AbstractAlgorithmRunnerEdited.hv,4)+"\t"+
//									 round(AbstractAlgorithmRunnerEdited.ep,4)+"\n");
//							 System.out.println(crossover[i]+"\t"+mutation[j]+"\t"+population[k]+"\t"+evaluation[l]+"\t"+
//									 round(AbstractAlgorithmRunnerEdited.gd,4)+"\t"+
//									 round(AbstractAlgorithmRunnerEdited.sv,4)+"\t"+
////									 round(AbstractAlgorithmRunnerEdited.hv,4)+"\t"+
//									 round(AbstractAlgorithmRunnerEdited.ep,4)+
//									 "\n");
//						}	
//					}
//				}
//			}
			/*Until here*/
			
			/** Uncomment below line*/
			new Runner().run(new String[] { "org.product_service.ProductServiceProblem", "lib/ProductServiceProblem.pf"});
			
			writer.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static String round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();


	    BigDecimal bd = new BigDecimal(value);
	    bd = bd.setScale(places, RoundingMode.HALF_UP);
	    return bd.toPlainString();
	}
}
