public class Disk implements Comparable<Disk>{
	private int FreeSpace;
	private DLinkedList<Integer> Folders = new DLinkedList<>();
	private static int idconst=1203;
	private int id;
	
	
	public Disk(){
		FreeSpace = 1000000; 
		id = idconst++;
	}
	
	public int getFreeSpace(){
		return FreeSpace;
	}
	
	public int getID(){
		return id;
	}

	public void addFolder(int spacerequired){
		if(FreeSpace >= spacerequired){
			FreeSpace = FreeSpace - spacerequired;
			Folders.add(spacerequired);
		}
		else System.out.println("There is not enough space in the disk");
		
	}

	@Override
	public int compareTo(Disk B) {
		if(this.getFreeSpace() == B.getFreeSpace()){
			return 0;
		}
		else if(this.getFreeSpace() > B.getFreeSpace()){
			return 1;
		}
		else {
			return -1;
		}
	}

	@Override
	public String toString(){
		return "id " + getID() +" " +getFreeSpace() + ": " + Folders.toString();
	}
}