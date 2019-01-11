//Class for IO process
import java.io.*;
import java.lang.management.ManagementFactory;

import net.openhft.affinity.AffinityLock;

/**
 * 
 * @author varnita jain, micky vue
 * IO intensive thread class
 *
 */
public class ThreadIO extends Threads {
	public String threadName;


	/**
	 * 
	 * @param ThreadName
	 * constructor for thread creation
	 */
	public ThreadIO(String ThreadName) {
		threadName = ThreadName;
		// TODO Auto-generated constructor stub
		System.out.println("Creating : "+ threadName);

	}
	/**
	 * This is an I/O intensive function which creates a new file, writes data to it and reads data from it.
	 */
	public void run() {
		int ch;
		System.out.println("Running " + threadName);	

		for(int a=0; a< 20 ; a++) {
			try {
				//creating object for read and write file
				InputStream ReadFile = new FileInputStream("C:/Eclipse Workspace/Performance_Benchmark/src/Demo.txt");
				FileOutputStream WriteFile = new FileOutputStream("C:/Eclipse Workspace/Performance_Benchmark/src/DemoWrite.txt");

				//calculating available bytes of file
				int length = ReadFile.available();

				//writing into file
				while((ch=ReadFile.read())!=-1)
                {
					System.out.print((char)ch);
                  	WriteFile.write(ch);
				}

				System.out.println("\nData written into file");
				//closing the files
				ReadFile.close();
				WriteFile.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Exiting : " + threadName);

	}
}