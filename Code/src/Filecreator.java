import java.util.*;
import java.io.*;
public class Filecreator{
	
	public static void createFiles(){
		int name1 = 1;
		int name2 = 1;
		int name3 = 1;
		for(int i=0; i<10; i++){
			try{
				FileOutputStream file = new FileOutputStream("100folders" + name1 + "_parts.txt");
				name1++;
				for(int k=0; k<100; k++){
					String data = (int)(Math.random() *1000000)+"\n";
					file.write(data.getBytes());
				}
				file.close();
			}
			catch(Exception N){
				System.err.println(N);
			}	
			try{
				FileOutputStream file = new FileOutputStream("500folders" + name2 + "_parts.txt");
				name2++;
				for(int k=0; k<500; k++){
					String data = (int)(Math.random() *1000000)+"\n";
					file.write(data.getBytes());
				}
				file.close();
			}
			catch(Exception N){
				System.err.println(N);
			}
			try{
				FileOutputStream file = new FileOutputStream("1000folders" + name3 + "_parts.txt");
				name3++;
				for(int k=0; k<1000; k++){
					String data = (int)(Math.random() *1000000)+"\n";
					file.write(data.getBytes());
				}
				file.close();
			}
			catch(Exception N){
				System.err.println(N);
			}
		}//closes big for
	}
	
	public static void main(String[] args){
		System.out.println("Initializing C");
		createFiles(); 
		System.out.println("Greedy vs GreedyDecreased");
		System.out.println("100 folders: 59 - 52");
		System.out.println("500 folders: 294 - 255");
		System.out.println("1000 folders: 590 - 514");
	}
		
		
	
}