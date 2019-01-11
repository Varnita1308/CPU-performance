/**
 * 
 * @author varnita1308
 * Interface is created to implement all Thread affinity operations
 *
 */
public interface InfThreadAffinity {

	/**
	 * This function is called to Implement Thread Affinity on Same Core
	 * @return execution time
	 * @throws InterruptedException 
	 */
	long ThreadAffinitySameCore() throws InterruptedException;
	
	/**
	 * This function is called to Implement Thread Affinity on Diff Core
	 * @return execution time
	 * @throws InterruptedException 
	 */
	long ThreadAffinityDiffCore() throws InterruptedException;
}
