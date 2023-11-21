package adda.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import org.apache.commons.math3.fitting.WeightedObservedPoint;

import adda.ejercicios.Ejercicio2;
import us.lsi.curvefitting.DataFile;
import us.lsi.curvefitting.Fit;
import us.lsi.curvefitting.GenData;
import us.lsi.curvefitting.PowerLog;
import us.lsi.graphics.MatPlotLib;

public class TestEjercicio2 {
	private static Integer nMin = 100; // Valor mínimo de n
	private static Integer nMax = 10000; // Valor máximo de n
	private static Integer nIncr = 333; // Incremento en los valores de n
	private static Integer nIter = 1000; // Número de iteraciones para cada medición de tiempo
	private static Integer nIterWarmup = 10000; // Número de iteraciones para warmup
    
	private static List<Integer> LIST = new ArrayList<>();
	
	private static List<Integer> genList(int length) {
        List<Integer> lista = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            lista.add(rand.nextInt(100)); // Números aleatorios hasta 100, puedes ajustar según sea necesario
        }
        return lista;
    }
	
	public static void genData1() {
		String file = "ficheros_generados/mergeSort1.txt";
		Function<Integer,Long> f = GenData.time(t -> Ejercicio2.mergeSort(LIST,1));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void genData4() {
		String file = "ficheros_generados/mergeSort4.txt";
		Function<Integer,Long> f = GenData.time(t -> Ejercicio2.mergeSort(LIST,4));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void genData16() {
		String file = "ficheros_generados/mergeSort16.txt";
		Function<Integer,Long> f = GenData.time(t -> Ejercicio2.mergeSort(LIST,16));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void genData64() {
		String file = "ficheros_generados/mergeSort64.txt";
		Function<Integer,Long> f = GenData.time(t -> Ejercicio2.mergeSort(LIST,64));
//		Integer tMin,Integer tMax,Integer tInc,Integer numIter,Integer numIterWarmup
		GenData.tiemposEjecucionAritmetica(f, file, nMin, nMax, nIncr, nIter, nIterWarmup);
	}
	
	public static void genData256() {
		String file = "ficheros_generados/mergeSort256.txt";
		Function<Integer,Long> f = GenData.time(t -> Ejercicio2.mergeSort(LIST,256));
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
