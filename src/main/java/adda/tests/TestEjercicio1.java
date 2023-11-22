package adda.tests;

import java.util.List;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import adda.ejercicios.Ejercicio1;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class TestEjercicio1 {
	
	public static void genDataRD() {
		Integer nMin = 100; // Valor mínimo de n
	    Integer nMax = 1000; // Valor máximo de n
	    Integer nIncr = 33; // Incremento en los valores de n
	    Integer nIter = 100000; // Número de iteraciones para cada medición de tiempo
	    Integer nIterWarmup = 10000; // Número de iteraciones para warmup
		
		String file = "ficheros_generados/rd.txt";
		Function<Integer,Long> f1 = GenData.time(t -> Ejercicio1.fRecDouble(t));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
		System.out.println("Fin Recursivo Double");
	}
	
	public static void genDataRBI() {
		Integer nMin = 100; // Valor mínimo de n
	    Integer nMax = 1000; // Valor máximo de n
	    Integer nIncr = 33; // Incremento en los valores de n
	    Integer nIter = 2000; // Número de iteraciones para cada medición de tiempo
	    Integer nIterWarmup = 1000; // Número de iteraciones para warmup
		
		String file = "ficheros_generados/rbi.txt";
		Function<Integer,Long> f1 = GenData.time(t -> Ejercicio1.fRecBigInteger(t));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
		System.out.println("Fin Recursivo BigInteger");
	}
	
	public static void genDataID() {
		Integer nMin = 100; // Valor mínimo de n
	    Integer nMax = 1000; // Valor máximo de n
	    Integer nIncr = 33; // Incremento en los valores de n
	    Integer nIter = 2000; // Número de iteraciones para cada medición de tiempo
	    Integer nIterWarmup = 1000; // Número de iteraciones para warmup
		
		String file = "ficheros_generados/id.txt";
		Function<Integer,Long> f1 = GenData.time(t -> Ejercicio1.fIterDouble(t));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
		System.out.println("Fin Iterativo Double");
	}
	
	public static void genDataIBI() {
		Integer nMin = 100; // Valor mínimo de n
	    Integer nMax = 1000; // Valor máximo de n
	    Integer nIncr = 33; // Incremento en los valores de n
	    Integer nIter = 2000; // Número de iteraciones para cada medición de tiempo
	    Integer nIterWarmup = 1000; // Número de iteraciones para warmup
		
		String file = "ficheros_generados/ibi.txt";
		Function<Integer,Long> f1 = GenData.time(t -> Ejercicio1.fIterBigInteger(t));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f1,file,nMin,nMax,nIncr,nIter,nIterWarmup);
		System.out.println("Fin Iterativo BigInteger");
	}
	
	public static void showRD() {
		String file = "ficheros_generados/rd.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void showRBI() {
		String file = "ficheros_generados/rbi.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void showID() {
		String file = "ficheros_generados/id.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void showIBI() {
		String file = "ficheros_generados/ibi.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void test() {
		genDataRD();
		genDataRBI();
		genDataID();
		genDataIBI();
		
		showRD();
		showRBI();
		showID();
		showIBI();
		
		MatPlotLib.showCombined("Comparación", List.of("ficheros_generados/rd.txt","ficheros_generados/rbi.txt",
				"ficheros_generados/id.txt","ficheros_generados/ibi.txt"), 
				List.of("Recursiva Double","Recursiva BigInteger","Iterativa Double","Iterativa BigInteger"));
		
		
	}
}
