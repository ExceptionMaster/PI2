package adda.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;
import us.lsi.recursivos.problemasdelistas.ProblemasDeListas;

public class TestEjercicio2 {	

	private static Integer nMin = 100; // Tamaño mínimo de la lista a ordenar
	private static Integer nMax = 10000; // Tamaño máximo de la lista a ordenar
	private static Integer nIncr = 3300; // Incremento en el tamaño de la lista
	private static Integer nIter = 50; // Número de iteraciones para calcular el
	private static Integer nIterWarmup = 500; // Número de iteraciones de calentamiento
	
	private static List<Integer> LIST = new ArrayList<>();
	private static Random rr = new Random(System.nanoTime());


	// Genera una lista de enteros aleatorios de tamaño t y la asigna a la variable
	// 'list'
	private static void genList(Integer n) {
		List<Integer> ls = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ls.add(rr.nextInt(n + 10000));
		}
		LIST = ls; // Genera una lista de enteros aleatorios de tamaño 't'
	}
	
	public static void genData1() {
		String file = "ficheros_generados/mergeSort1.txt";
		Consumer<Integer> cons = t -> genList(t);
		Function<Integer, Long> f = GenData.time(cons, t -> ProblemasDeListas.mergeSort(LIST,1));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void genData4() {
		String file = "ficheros_generados/mergeSort4.txt";
		Consumer<Integer> cons = t -> genList(t);
		Function<Integer, Long> f = GenData.time(cons, t -> ProblemasDeListas.mergeSort(LIST,4));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void genData16() {
		String file = "ficheros_generados/mergeSort16.txt";
		Consumer<Integer> cons = t -> genList(t);
		Function<Integer, Long> f = GenData.time(cons, t -> ProblemasDeListas.mergeSort(LIST,16));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void genData64() {
		String file = "ficheros_generados/mergeSort64.txt";
		Consumer<Integer> cons = t -> genList(t);
		Function<Integer, Long> f = GenData.time(cons, t -> ProblemasDeListas.mergeSort(LIST,64));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void genData256() {
		String file = "ficheros_generados/mergeSort256.txt";
		Consumer<Integer> cons = t -> genList(t);
		Function<Integer, Long> f = GenData.time(cons, t -> ProblemasDeListas.mergeSort(LIST,256));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void show1() {
		String file = "ficheros_generados/mergeSort1.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void show4() {
		String file = "ficheros_generados/mergeSort4.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void show16() {
		String file = "ficheros_generados/mergeSort16.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void show64() {
		String file = "ficheros_generados/mergeSort64.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void show256() {
		String file = "ficheros_generados/mergeSort256.txt";
		List<WeightedObservedPoint> data = DataFile.points(file);
		Fit pl = PowerLog.of();
		pl.fit(data);
		System.out.println(pl.getExpression());
		System.out.println(pl.getEvaluation().getRMS());
		MatPlotLib.show(file, pl.getFunction(), pl.getExpression());
	}
	
	public static void test() {
		genList(100); 
		
		genData1();
		genData4();
		genData16();
		genData64();
		genData256();
		
		show1();
		show4();
		show16();
		show64();
		show256();
		
		MatPlotLib.showCombined("Comparación", List.of("ficheros_generados/mergeSort1.txt","ficheros_generados/mergeSort4.txt",
				"ficheros_generados/mergeSort16.txt","ficheros_generados/mergeSort64.txt","ficheros_generados/mergeSort256.txt"), 
				List.of("Umbral = 1","Umbral = 4","Umbral = 16","Umbral = 64",""));
		
		
	}
}
