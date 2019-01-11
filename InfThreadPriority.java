/**
 * 
 * @author varnita1308, micky vue
 * Interface is created to implement all Thread priority operations
 *
 */
public interface InfThreadPriority {
	
	/**
	 * This function is called to Implement Thread Priority with (MAX_PRIORITY,MIN_PRIORITY) combination
	 * @return execution time
	 * @throws InterruptedException 
	 */
	long MaxMin() throws InterruptedException; 
	
	/**
	 * This function is called to Implement Thread Priority with (NORM_PRIORITY,NORM_PRIORITY) combination
	 * @return execution time
	 * @throws InterruptedException 
	 */
	long NormalNormal() throws InterruptedException;
	
	/**
	 * This function is called to Implement Thread Priority with (MIN_PRIORITY,MAX_PRIORITY) combination
	 * @return execution time
	 * @throws InterruptedException 
	 */
	long MinMax() throws InterruptedException;

}
