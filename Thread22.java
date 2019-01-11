import net.openhft.affinity.AffinityLock;
import net.openhft.affinity.AffinityStrategies;

public class Thread22 extends Threads implements InfThreadAffinity, InfThreadPriority{

	AffinityStrategies AffinityStrategySameCore = AffinityStrategies.SAME_CORE;
	AffinityStrategies AffinityStrategyDiffCore = AffinityStrategies.DIFFERENT_CORE;
	AffinityLock AffinityLockSameCore1;
	AffinityLock AffinityLockSameCore2;
	/**
	 * Implements Thread Class for 2 instances of Comp Thread
	 * @return 
	 * @throws InterruptedException 
	 */
	public long ThreadClassComp() throws InterruptedException {
		//-----------------------------------------CASE: 2 THREAD CLASS T2&T2---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF COMP THREAD-----------------------------------------
		ThreadComp ThreadCompObj1 = new ThreadComp("ThreadComp 1");
		//----------------------------------SECOND INSTANCE OF COMP THREAD-----------------------------------------
		ThreadComp ThreadCompObj2 = new ThreadComp("ThreadComp 2");

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING COMP THREADS----------------------------------------");
		ThreadCompObj1.start();
		ThreadCompObj2.start();

		ThreadCompObj1.join();
		ThreadCompObj2.join();

		System.out.println("----------------------End Timer--------------------");

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		//calculate duration
		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}
	@Override
	public long MaxMin() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 7 THREAD PRIORITY T2 & T2---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF COMP THREAD WITH MAX_PRIORITY-----------------------------------------
		ThreadComp ThreadCompObj71 = new ThreadComp("ThreadComp 1");
		//----------------------------------SECOND INSTANCE OF COMP THREAD WITH MIN_PRIORITY-----------------------------------------
		ThreadComp ThreadCompObj72 = new ThreadComp("ThreadComp 2");

		//---------------------------------------ASSIGNING THREAD PRIORITIES------------------------------------
		ThreadCompObj71.setPriority(MAX_PRIORITY);
		ThreadCompObj72.setPriority(MIN_PRIORITY);

		System.out.println("Priority for ThreadCompObj1 = "+ ThreadCompObj71.getPriority());
		System.out.println("Priority for ThreadCompObj1 = "+ ThreadCompObj72.getPriority());

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING COMP THREADS----------------------------------------");
		ThreadCompObj71.start();
		ThreadCompObj72.start();

		ThreadCompObj71.join();
		ThreadCompObj72.join();

		System.out.println("----------------------End Timer--------------------");

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		//calculate duration
		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}

	@Override
	public long NormalNormal() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 8 THREAD PRIORITY T2 & T2---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF COMP THREAD WITH NORMAL_PRIORITY-----------------------------------------
		ThreadComp ThreadCompObj81 = new ThreadComp("ThreadComp 1");
		//----------------------------------SECOND INSTANCE OF COMP THREAD WITH NORMAL_PRIORITY-----------------------------------------
		ThreadComp ThreadCompObj82 = new ThreadComp("ThreadComp 2");

		//---------------------------------------ASSIGNING THREAD PRIORITIES------------------------------------
		ThreadCompObj81.setPriority(NORM_PRIORITY);
		ThreadCompObj82.setPriority(NORM_PRIORITY);

		System.out.println("Priority for ThreadCompObj1 = "+ ThreadCompObj81.getPriority());
		System.out.println("Priority for ThreadCompObj1 = "+ ThreadCompObj82.getPriority());

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING COMP THREADS----------------------------------------");
		ThreadCompObj81.start();
		ThreadCompObj82.start();

		ThreadCompObj81.join();
		ThreadCompObj82.join();

		System.out.println("----------------------End Timer--------------------");

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		//calculate duration
		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );


	}

	@Override
	public long MinMax() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 9 THREAD PRIORITY T2 & T2---------------------------------------------------------------------------------

		//----------------------------------FIRST INSTANCE OF COMP THREAD WITH MIN_PRIORITY-----------------------------------------
		ThreadComp ThreadCompObj91 = new ThreadComp("ThreadComp 1");
		//----------------------------------SECOND INSTANCE OF COMP THREAD WITH MAX_PRIORITY-----------------------------------------
		ThreadComp ThreadCompObj92 = new ThreadComp("ThreadComp 2");

		//---------------------------------------ASSIGNING THREAD PRIORITIES------------------------------------
		ThreadCompObj91.setPriority(MIN_PRIORITY);
		ThreadCompObj92.setPriority(MAX_PRIORITY);

		System.out.println("Priority for ThreadCompObj1 = "+ ThreadCompObj91.getPriority());
		System.out.println("Priority for ThreadCompObj1 = "+ ThreadCompObj92.getPriority());

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING COMP THREADS----------------------------------------");
		ThreadCompObj91.start();
		ThreadCompObj92.start();

		ThreadCompObj91.join();
		ThreadCompObj92.join();

		System.out.println("----------------------End Timer--------------------");

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();

		//calculate duration
		duration= stopTime - startTime; 
		return duration;
		//System.out.println("Time taken to execute operations = " + duration + " ms" );

	}

	@Override
	public long ThreadAffinitySameCore() throws InterruptedException {
		// TODO Auto-generated method stub
		//-----------------------------------------CASE: 15 THREAD AFFINITY T2 & T2 ON SAME CORE ---------------------------------------------------------------------------------

		AffinityLockObject = AffinityLock.acquireLock(2);	//lock IO thread on a core

		//----------------------------------FIRST INSTANCE OF COMP THREAD ON CORE 2-----------------------------------------
		AffinityLockSameCore1 = AffinityLockObject.acquireLock(AffinityStrategySameCore);
		ThreadComp ThreadCompObj151 = new ThreadComp("ThreadComp 1");
		
		//----------------------------------SECOND INSTANCE OF COMP THREAD ON CORE 2-----------------------------------------
		AffinityLockSameCore2 = AffinityLockObject.acquireLock(AffinityStrategySameCore);
		ThreadComp ThreadCompObj152 = new ThreadComp("ThreadComp 2");

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING COMP THREADS----------------------------------------");
		ThreadCompObj151.start();
		ThreadCompObj152.start();

		ThreadCompObj151.join();
		ThreadCompObj152.join();

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
		//-----------------------------------------CASE: 16 THREAD AFFINITY T2 & T2 ON DIFF CORE ---------------------------------------------------------------------------------
		//----------------------------------FIRST INSTANCE OF COMP THREAD ON CORE 2-----------------------------------------
		AffinityLockObject = AffinityLock.acquireLock(2);	//lock IO thread on a core
		ThreadComp ThreadCompObj161 = new ThreadComp("ThreadComp 1");
		

		//----------------------------------SECOND INSTANCE OF COMP THREAD ON CORE 3-----------------------------------------
		AffinityLockDiffCore = AffinityLockObject.acquireLock(AffinityStrategyDiffCore);//lock thread on a core
		ThreadComp ThreadCompObj162 = new ThreadComp("ThreadComp 2");

		//----------------------------ASSIGN THREAD AFFINITY--------------------------------------------------
		System.out.println("\nThe assignment of CPUs is\n" + AffinityLock.dumpLocks());

		System.out.println("---------------------------Start timer------------------------------");
		startTime = System.currentTimeMillis();

		System.out.println("-------------------------------RUNNING COMP THREADS----------------------------------------");
		ThreadCompObj161.start();
		ThreadCompObj162.start();

		ThreadCompObj161.join();
		ThreadCompObj162.join();

		//-----------------------------------------RELEASE LOCKS------------------------------------------------
		AffinityLockDiffCore.release();
		AffinityLockObject.release();

		//stop timer- get current system time
		stopTime= System.currentTimeMillis();
		duration= stopTime - startTime; 
		return duration;

	}
}
