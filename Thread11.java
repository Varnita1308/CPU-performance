import net.openhft.affinity.AffinityLock;
import net.openhft.affinity.AffinityStrategies;

public class Thread11 extends Threads implements InfThreadAffinity, InfThreadPriority {

	AffinityStrategies AffinityStrategySameCore = AffinityStrategies.SAME_CORE;
	AffinityStrategies AffinityStrategyDiffCore = AffinityStrategies.DIFFERENT_CORE;
	AffinityLock AffinityLockSameCore1;
	AffinityLock AffinityLockSameCore2;

	/**
	 * Implments Thread Class for 2 instances of IO Thread
	 * @return 
	 * @throws InterruptedException 
	 */
	public long ThreadClassIO() throws InterruptedException {
		//-------------------CASE: 1 THREAD CLASS T1&T1-------------------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF IO THREAD-----------------------------------------
		ThreadIO ThreadIOObj1 = new ThreadIO("ThreadIO 1");

		//------------------------------SECOND INSTANCE OF IO THREAD------------------------------------------
		ThreadIO ThreadIOObj2 = new ThreadIO("ThreadIO 2");

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING IO THREADS----------------------------------------");
		ThreadIOObj1.start();
		ThreadIOObj2.start();

		ThreadIOObj1.join();
		ThreadIOObj2.join();

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		duration= stopTime - startTime; 

		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}

	@Override
	public long MaxMin() throws InterruptedException {
		// TODO Auto-generated method stub
		//----------------------------------FIRST INSTANCE OF IO THREAD WITH MAX_PRIORITY-----------------------------------------
		ThreadIO ThreadIOObj1 = new ThreadIO("ThreadIO 1");

		//------------------------------SECOND INSTANCE OF IO THREAD WITH MIN_PRIORITY------------------------------------------
		ThreadIO ThreadIOObj2 = new ThreadIO("ThreadIO 2");

		//---------------------------------------ASSIGNING THREAD PRIORITIES------------------------------------
		ThreadIOObj1.setPriority(MAX_PRIORITY);
		ThreadIOObj2.setPriority(MIN_PRIORITY);

		System.out.println("Priority for ThreadIOObj1 = "+ ThreadIOObj1.getPriority());
		System.out.println("Priority for ThreadIOObj2 = "+ ThreadIOObj2.getPriority());

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING IO THREADS----------------------------------------");
		ThreadIOObj1.start();
		ThreadIOObj2.start();

		ThreadIOObj1.join();
		ThreadIOObj2.join();

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}


	@Override
	public long NormalNormal() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 5 THREAD PRIORITY T1 & T1---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF IO THREAD WITH NORMAL_PRIORITY-----------------------------------------
		ThreadIO ThreadIOObj51 = new ThreadIO("ThreadIO 1");

		//------------------------------SECOND INSTANCE OF IO THREAD WITH NORMAL_PRIORITY------------------------------------------
		ThreadIO ThreadIOObj52 = new ThreadIO("ThreadIO 2");

		//---------------------------------------ASSIGNING THREAD PRIORITIES------------------------------------
		ThreadIOObj51.setPriority(NORM_PRIORITY);
		ThreadIOObj52.setPriority(NORM_PRIORITY);

		System.out.println("Priority for ThreadIOObj1 = "+ ThreadIOObj51.getPriority());
		System.out.println("Priority for ThreadIOObj2 = "+ ThreadIOObj52.getPriority());

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING IO THREADS----------------------------------------");
		ThreadIOObj51.start();
		ThreadIOObj52.start();

		ThreadIOObj51.join();
		ThreadIOObj52.join();

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

		//-------------------------------------------------------------------------------------------------------------------------------------------

	}

	@Override
	public long MinMax() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 6 THREAD PRIORITY T1 & T1 ---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF IO THREAD WITH MIN_PRIORITY-----------------------------------------
		ThreadIO ThreadIOObj61 = new ThreadIO("ThreadIO 1");

		//------------------------------SECOND INSTANCE OF IO THREAD WITH MAX_PRIORITY------------------------------------------
		ThreadIO ThreadIOObj62 = new ThreadIO("ThreadIO 2");

		//---------------------------------------ASSIGNING THREAD PRIORITIES------------------------------------
		ThreadIOObj61.setPriority(MIN_PRIORITY);
		ThreadIOObj62.setPriority(MAX_PRIORITY);

		System.out.println("Priority for ThreadIOObj1 = "+ ThreadIOObj61.getPriority());
		System.out.println("Priority for ThreadIOObj2 = "+ ThreadIOObj62.getPriority());

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING IO THREADS----------------------------------------");
		ThreadIOObj61.start();
		ThreadIOObj62.start();

		ThreadIOObj61.join();
		ThreadIOObj62.join();

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}


	@Override
	public long ThreadAffinitySameCore() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 13 THREAD AFFINITY T1 & T1 ON SAME CORE ---------------------------------------------------------------------------------

		AffinityLockObject = AffinityLock.acquireLock(2);	//lock IO thread on a core

		//----------------------------------FIRST INSTANCE OF IO THREAD-----------------------------------------
		AffinityLockSameCore1 = AffinityLockObject.acquireLock(AffinityStrategySameCore);
		ThreadIO ThreadIOObj131 = new ThreadIO("ThreadIO 1");

		//------------------------------SECOND INSTANCE OF IO THREAD------------------------------------------
		AffinityLockSameCore2 = AffinityLockObject.acquireLock(AffinityStrategySameCore);
		ThreadIO ThreadIOObj132 = new ThreadIO("ThreadIO 2");

		//----------------------------ASSIGN THREAD AFFINITY--------------------------------------------------
		System.out.println("\nThe assignment of CPUs is\n" + AffinityLock.dumpLocks());

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING IO THREADS----------------------------------------");
		ThreadIOObj131.start();
		ThreadIOObj132.start();

		ThreadIOObj131.join();
		ThreadIOObj132.join();

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

	@Override
	public long ThreadAffinityDiffCore() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 14 THREAD AFFINITY T1 & T1 ON DIFF CORE ---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF IO THREAD LOCKED ON CORE 2-----------------------------------------

		AffinityLockObject = AffinityLock.acquireLock(2);	//lock IO thread on a core
		ThreadIO ThreadIOObj141 = new ThreadIO("ThreadIO 1");

		//------------------------------SECOND INSTANCE OF IO THREAD LOCKED ON CORE 3------------------------------------------
		AffinityLockDiffCore = AffinityLockObject.acquireLock(AffinityStrategyDiffCore);//lock thread on a core
		ThreadIO ThreadIOObj142 = new ThreadIO("ThreadIO 2");

		//----------------------------ASSIGN THREAD AFFINITY--------------------------------------------------
		System.out.println("\nThe assignment of CPUs is\n" + AffinityLock.dumpLocks());

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING IO THREADS----------------------------------------");
		ThreadIOObj141.start();
		ThreadIOObj142.start();

		ThreadIOObj141.join();
		ThreadIOObj142.join();

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
