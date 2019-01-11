import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.BitSet;
import net.openhft.affinity.*;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * 
 * @author varnita Jain
 *
 */
public class Threads extends Thread {
	//-----------------------------------------GLOBAL VARIABLES-----------------------------------------------
	//creating global variables for clock variables
	static long startTime;
	static long stopTime;
	static long duration;
	int cpuId;

	public static String threadName;

	static AffinityLock AffinityLockSameCore;
	static AffinityLock AffinityLockDiffCore;
	static AffinityLock AffinityLockObject;

	static AffinityStrategies AffinityStrategySameCore = AffinityStrategies.SAME_CORE;
	static AffinityStrategies AffinityStrategyDiffCore = AffinityStrategies.DIFFERENT_CORE;

	//main method
	public static void main(String[] args) throws InterruptedException {
		//clock start time and clock end time and duration

		System.out.println("****************************MULTITHREADING IN WINDOWS******************************");

		//---------------------------------------------H/W DETAILS--------------------------------------------
		//get no of processors:
		System.out.println("----------------------------H/W DETAILS-------------------------------------------");

		int processors = Runtime.getRuntime().availableProcessors();
		System.out.println("No of available Processors: "+ processors);
		//System.out.println("-----------------------------------------------------------------------");

		//get Base affinity
		final BitSet BASE_AFFINITY = Affinity.getAffinity();
		System.out.println("Base Affinity= "+ BASE_AFFINITY);

		/*System.out.println("is Current Thread CPU time supported: "+ ManagementFactory.getThreadMXBean().isCurrentThreadCpuTimeSupported());*/

		System.out.println("-----------------------------------------------------------------------");


		//creating objects for Thread11, Thread12 and Thread22 class
		Thread11 Thread11Object = new Thread11();
		Thread22 Thread22Object = new Thread22();
		Thread12 Thread12Object = new Thread12();

		System.out.println("Enter a value:\n 1. Thread Class \n 2. Thread Priority\n 3. Thread Affinity\n");
		while(true) {
			//creating object of Scanner class
			Scanner in = new Scanner(System.in);
			
			//ChooseOption will let the user enter an integer value
			int ChooseOption = in.nextInt();

			/**
			 * switch case for user menu
			 */
			switch (ChooseOption) {	
			case 1:
				long duration1 = Thread11Object.ThreadClassIO();
				long duration2 = Thread22Object.ThreadClassComp();
				long duration3 = Thread12Object.ThreadClassMixed();

				System.out.println("Time taken to execute Thread Class = "+ (duration1+duration2+duration3)/3 +"ms");

				break;

			case 2:
				long duration4 = Thread11Object.MaxMin();
				long duration5 = Thread11Object.NormalNormal();
				long duration6 = Thread11Object.MinMax();

				long duration7 = Thread22Object.MaxMin();
				long duration8 = Thread22Object.NormalNormal();
				long duration9 = Thread22Object.MinMax();

				long duration10 = Thread12Object.MaxMin();
				long duration11 = Thread12Object.NormalNormal();
				long duration12 = Thread12Object.MinMax();

				System.out.println("Time taken to execute Thread Priority for Thread11= "+ (duration4+duration5+duration6)/3 +"ms");
				
				System.out.println("Time taken to execute Thread Priority for Thread22= "+ (duration7+duration8+duration9)/3 +"ms");
				
				System.out.println("Time taken to execute Thread Priority for Thread12= "+ (duration10+duration11+duration12)/3 +"ms");

				break;

			case 3:

				long duration13 = Thread11Object.ThreadAffinityDiffCore();
				long duration14 = Thread11Object.ThreadAffinitySameCore();

				long duration15 = Thread22Object.ThreadAffinityDiffCore();
				long duration16 = Thread22Object.ThreadAffinitySameCore();

				long duration17 = Thread12Object.ThreadAffinityDiffCore();
				long duration18 = Thread12Object.ThreadAffinitySameCore();

				System.out.println("Time taken to execute Core Affinity for Thread11 on diff core= "+ duration13 +"ms");
				System.out.println("Time taken to execute Core Affinity for Thread11 on same core= "+ duration14 +"ms");
				System.out.println("Time taken to execute Core Affinity for Thread22 on diff core= "+ duration15 +"ms");
				System.out.println("Time taken to execute Core Affinity for Thread22 on same core= "+ duration16 +"ms");
				System.out.println("Time taken to execute Core Affinity for Thread12 on diff core= "+ duration17 +"ms");
				System.out.println("Time taken to execute Core Affinity for Thread12 on same core= "+ duration18 +"ms");

				break;

			default:
				break;
			}
		}
	}
}