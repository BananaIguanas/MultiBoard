public class ChessMove {
	
	private String srcLocationName;
	private int[] srcLocation;
	private String destLocationName;
	private int[] destLocation;

	public ChessMove(String srcLocationName, String destLocationName) {
		this.srcLocationName = srcLocationName;
		this.destLocationName = destLocationName;
		this.srcLocation = setLocation(srcLocationName);
		this.destLocation = setLocation(destLocationName);
	}

	private int[] setLocation(String name) {
		if (name.length() == 2) {
			char[] tokens = name.toCharArray();
			int rank = tokens[0] - 'A';
			int file = tokens[1] - '1';
			int[] location = new int[]{file, rank};
			return location;
		}
		return null;
	}

	/*
	 * Main method for debugging.
	 */

	//public static void main(String[] args)  {
	//	ChessMove move = new ChessMove("A1", "E3");
	//	for (int i : move.destLocation) {
	//		System.out.println(i);
	//	}
	//}

} 
