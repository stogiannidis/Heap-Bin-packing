import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Greedy {

	public static void main(String[] args) {
		//DLinkedList<Disk> disks = new DLinkedList<>();
		//long startTime = System.currentTimeMillis();
		File file = new File(args[0]);
		int size_t = q_size(file);
		MaxPQ<Disk> diskQ = new MaxPQ<>(size_t);
		int totalspace =0;
		int disknumber =1;
		int foldernumber = 0;
		Disk d1 = new Disk();
		diskQ.insert(d1);

		try{
			System.out.println("Reading input file");
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String data;
			while((data = bf.readLine()) != null){
				int result = Integer.parseInt(data);
				if (result > 1000000 || result < 0 ) { //not checking overflow
					System.out.println("Folder size bigger than allowed - Program terminating");
					System.exit(0);
				}
				Disk currentBiggerDisk = diskQ.getMax();
				if(result <= currentBiggerDisk.getFreeSpace()){
					currentBiggerDisk.addFolder(result);
				}
				else{
					Disk temp = new Disk();
					temp.addFolder(result);
					diskQ.insert(temp);
					disknumber++;
				}
				diskQ.insert(currentBiggerDisk);
				foldernumber++;
				totalspace+=result;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Size sum of all folders = " + totalspace/1000000 + "TB");
		System.out.println("Total Folders = " + foldernumber);
		System.out.println("Total number of disks used = " + disknumber);
		//long endTime = System.currentTimeMillis();
		//System.out.println("Total execution time: " + (endTime-startTime) + "ms");
		diskQ.print();
	}

	private static int q_size(File file){
		int t = 0;
		try{
			BufferedReader bf = new BufferedReader(new FileReader(file));
			while((bf.readLine()) != null) t++;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
}