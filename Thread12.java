import net.openhft.affinity.AffinityLock;
import net.openhft.affinity.AffinityStrategies;

/**
 * 
 * @author varnita1308
 * this class is created to perform thread operations for 1 instance of I/O and another of Computation thread
 *
 */
public class Thread12 extends Threads implements InfThreadAffinity, InfThreadPriority{

	AffinityStrategies AffinityStrategySameCore = AffinityStrategies.SAME_CORE;
	AffinityStrategies AffinityStrategyDiffCore = AffinityStrategies.DIFFERENT_CORE;
	AffinityLock AffinityLockSameCore1;
	AffinityLock AffinityLockSameCore2;
	
	/**
	 * @return execution time
	 * @throws InterruptedException 
	 * Implements Thread Class for 1 IO and 1 Comp thread
	 */
	public long ThreadClassMixed() throws InterruptedException {
		//-----------------------------------------CASE: 3 THREAD CLASS T1&T2---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF IO THREAD-----------------------------------------
		ThreadIO ThreadIOObj3 = new ThreadIO("ThreadIO 1");

		//----------------------------------FIRST INSTANCE OF COMP THREAD-----------------------------------------
		ThreadComp ThreadCompObj3 = new ThreadComp("ThreadComp 1");

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING THREADS----------------------------------------");
		ThreadIOObj3.start();
		ThreadCompObj3.start();

		ThreadIOObj3.join();
		ThreadCompObj3.join();

		System.out.println("----------------------End Timer--------------------");

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		//calculate duration
		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}
	@Override
	/**
	 * Implements Thread Priority for 1 IO and 1 Comp thread
	 * T1= MAX_PRIORITY
	 * T2= MIN_PRIORITY
	 * @return execution time
	 * @throws InterruptedException 
	 * 
	 */
	public long MaxMin() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 10 THREAD PRIORITY T1&T2---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF IO THREAD WITH MAX_PRIORITY-----------------------------------------
		ThreadIO ThreadIOObj101 = new ThreadIO("ThreadIO 1");

		//----------------------------------FIRST INSTANCE OF COMP THREAD WITH MIN_PRIORITY-----------------------------------------
		ThreadComp ThreadCompObj101 = new ThreadComp("ThreadComp 1");

		//---------------------------------------ASSIGNING THREAD PRIORITIES------------------------------------
		ThreadIOObj101.setPriority(MAX_PRIORITY);
		ThreadCompObj101.setPriority(MIN_PRIORITY);

		System.out.println("Priority for ThreadIOObj1 = "+ ThreadIOObj101.getPriority());
		System.out.println("Priority for ThreadCompObj1 = "+ ThreadCompObj101.getPriority());


		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING THREADS----------------------------------------");
		ThreadIOObj101.start();
		ThreadCompObj101.start();

		ThreadIOObj101.join();
		ThreadCompObj101.join();

		System.out.println("----------------------End Timer--------------------");

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		//calculate duration
		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}

	/**
	 * Implements Thread Priority for 1 IO and 1 Comp thread
	 * T1= NORM_PRIORITY
	 * T2= NORM_PRIORITY
	 * @return execution time
	 * @throws InterruptedException 
	 * 
	 */
	@Override
	public long NormalNormal() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 11 THREAD PRIORITY T1&T2---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF IO THREAD WITH NORMAL_PRIORITY-----------------------------------------
		ThreadIO ThreadIOObj111 = new ThreadIO("ThreadIO 1");

		//----------------------------------FIRST INSTANCE OF COMP THREAD WITH NORMAL_PRIORITY-----------------------------------------
		ThreadComp ThreadCompObj111 = new ThreadComp("ThreadComp 1");

		//---------------------------------------ASSIGNING THREAD PRIORITIES------------------------------------
		ThreadIOObj111.setPriority(NORM_PRIORITY);
		ThreadCompObj111.setPriority(NORM_PRIORITY);

		System.out.println("Priority for ThreadIOObj1 = "+ ThreadIOObj111.getPriority());
		System.out.println("Priority for ThreadCompObj1 = "+ ThreadCompObj111.getPriority());


		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING THREADS----------------------------------------");
		ThreadIOObj111.start();
		ThreadCompObj111.start();

		ThreadIOObj111.join();
		ThreadCompObj111.join();

		System.out.println("----------------------End Timer--------------------");

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		//calculate duration
		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}

	/**
	 * Implements Thread Priority for 1 IO and 1 Comp thread
	 * T1= MAX_PRIORITY
	 * T2= MIN_PRIORITY
	 * @return execution time
	 * @throws InterruptedException 
	 * 
	 */
	@Override
	public long MinMax() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 12 THREAD PRIORITY T1&T2---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF IO THREAD WITH MIN_PRIORITY-----------------------------------------
		ThreadIO ThreadIOObj12 = new ThreadIO("ThreadIO 1");

		//----------------------------------FIRST INSTANCE OF COMP THREAD WITH MAX_PRIORITY-----------------------------------------
		ThreadComp ThreadCompObj12 = new ThreadComp("ThreadComp 1");

		//---------------------------------------ASSIGNING THREAD PRIORITIES------------------------------------
		ThreadIOObj12.setPriority(MIN_PRIORITY);
		ThreadCompObj12.setPriority(MAX_PRIORITY);

		System.out.println("Priority for ThreadIOObj1 = "+ ThreadIOObj12.getPriority());
		System.out.println("Priority for ThreadCompObj1 = "+ ThreadCompObj12.getPriority());


		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING THREADS----------------------------------------");
		ThreadIOObj12.start();
		ThreadCompObj12.start();

		ThreadIOObj12.join();
		ThreadCompObj12.join();

		System.out.println("----------------------End Timer--------------------");

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		//calculate duration
		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}

	/**
	 * This function is called to Implement Thread Affinity for T1, T2 on Same Core
	 * @return execution time
	 * @throws InterruptedException 
	 */
	@Override
	public long ThreadAffinitySameCore() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 17 THREAD AFFINITY T1 & T2 ON SAME CORE ---------------------------------------------------------------------------------

		AffinityLockObject = AffinityLock.acquireLock(2);	//lock IO thread on a core
		//----------------------------------FIRST INSTANCE OF IO THREAD ON CORE 2-----------------------------------------
		AffinityLockSameCore1 = AffinityLockObject.acquireLock(AffinityStrategySameCore);
		ThreadIO ThreadIOObj17 = new ThreadIO("ThreadIO 1");

		//----------------------------------FIRST INSTANCE OF COMP THREAD ON CORE 2-----------------------------------------
		AffinityLockSameCore2 = AffinityLockObject.acquireLock(AffinityStrategySameCore);
		ThreadComp ThreadCompObj17 = new ThreadComp("ThreadComp 1");

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING THREADS----------------------------------------");
		ThreadIOObj17.start();
		ThreadCompObj17.start();

		ThreadIOObj17.join();
		ThreadCompObj17.join();


		//-----------------------------------------RELEASE LOCKS------------------------------------------------
		//AffinityLockDiffCore.release();	
		AffinityLockSameCore1.release();
		AffinityLockSameCore2.release();
		AffinityLockObject.release();
		
		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}

	/**
	 * This function is called to Implement Thread Affinity for T1, T2 on Diff Core
	 * @return execution time
	 * @throws InterruptedException 
	 */
	@Override
	public long ThreadAffinityDiffCore() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 18 THREAD AFFINITY T1 & T2 ON DIFF CORE ---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF IO THREAD ON CORE 2-----------------------------------------
		AffinityLockObject = AffinityLock.acquireLock(2);	//lock IO thread on a core
		ThreadIO ThreadIOObj18 = new ThreadIO("ThreadIO 1");

		//----------------------------------FIRST INSTANCE OF COMP THREAD ON CORE 3-----------------------------------------
		AffinityLockDiffCore = AffinityLockObject.acquireLock(AffinityStrategyDiffCore);//lock thread on a diff core 
		ThreadComp ThreadCompObj18 = new ThreadComp("ThreadComp 1");
	
		//----------------------------ASSIGN THREAD AFFINITY--------------------------------------------------
		System.out.println("\nThe assignment of CPUs is\n" + AffinityLock.dumpLocks());

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING COMP THREADS----------------------------------------");
		ThreadIOObj18.start();
		ThreadCompObj18.start();

		ThreadIOObj18.join();
		ThreadCompObj18.join();

		//-----------------------------------------RELEASE LOCKS------------------------------------------------
		AffinityLockDiffCore.release();
		AffinityLockObject.release();

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();
		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}

}
