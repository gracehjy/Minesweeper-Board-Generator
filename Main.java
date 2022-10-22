import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    //Prompt the user to input the size of the board and the probability of a mine
    Scanner in = new Scanner(System.in);
    System.out.println("How many columns?");
    int cols = in.nextInt();
    System.out.println("How many rows?");
    int rows = in.nextInt();
    System.out.println("What is the probability of a mine?");
    double probability = in.nextDouble();
		
    //Create a 2D array for the board (one with numbers and one without numbers)
    String[][] grid = new String[rows][cols];
    String[][] gridWithVals = new String[rows][cols];

    //Fill the unnumbered board with mines if the random value generated is less than the given probability of a mine
    //If the random value is greater, then use a . instead of a mine
    double randVal;
    for(int r = 0; r < rows; r++) {
      for(int c = 0; c < cols; c++) {
        randVal = Math.random();
	if(randVal < probability) {
	  grid[r][c] = "*";
	}
	else {
	  grid[r][c] = ".";
	}
      }
    }
    
    //Use logic to count how many mines a non-mine element is touching
    //Fill the numbered board with the bombCount at specific indices 
    //If the specific element is a mine, fill the numbered board with a mine at that element as well
    int bombCount;
    for(int r = 0; r < rows; r++) {
      for(int c = 0; c < cols; c++) {
        bombCount = 0;
	if(grid[r][c].equals("*")) {
	  gridWithVals[r][c] = "*";
	}
	else if(r == 0 && c == 0) {
	  if(grid[r][c+1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c+1].equals("*")) {
	    bombCount++;
	  }
	  gridWithVals[r][c] = ""+bombCount;
	}
	else if(r == 0 && c == cols-1) {
	  if(grid[r][c-1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c-1].equals("*")) {
	    bombCount++;
	  }
	  gridWithVals[r][c] = ""+bombCount;
	}
	else if(r == rows-1 && c == 0) {
	  if(grid[r][c+1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r-1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r-1][c+1].equals("*")) {
	    bombCount++;
	  }
	  gridWithVals[r][c] = ""+bombCount;
	}
	else if(r == rows-1 && c == cols-1) {
	  if(grid[r][c-1].equals("*")) {
            bombCount++;
	  }
	  if(grid[r-1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r-1][c-1].equals("*")) {
	    bombCount++;
	  }
	  gridWithVals[r][c] = ""+bombCount;
	}
	else if(r == 0) {
	  if(grid[r][c-1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r][c+1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c-1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c+1].equals("*")) {
	    bombCount++;
	  }
	  gridWithVals[r][c] = ""+bombCount;
	}
	else if(r == rows-1) {
	  if(grid[r][c-1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r][c+1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r-1][c-1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r-1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r-1][c+1].equals("*")) {
	    bombCount++;
	  }
	  gridWithVals[r][c] = ""+bombCount;
	}
	else if(c == 0) {
	  if(grid[r-1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r-1][c+1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r][c+1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c+1].equals("*")) {
	    bombCount++;
	  }
	  gridWithVals[r][c] = ""+bombCount;
	}
	else if(c == cols-1) {
	  if(grid[r-1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r-1][c-1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r][c-1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c-1].equals("*")) {
	    bombCount++;
	  }
	  gridWithVals[r][c] = ""+bombCount;
	}
	else {
	  if(grid[r-1][c-1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r-1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r-1][c+1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r][c-1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r][c+1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c-1].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c].equals("*")) {
	    bombCount++;
	  }
	  if(grid[r+1][c+1].equals("*")) {
	    bombCount++;
	  }
	  gridWithVals[r][c] = ""+bombCount;
	}	
      }
    }

    //Print out both boards
    //Have the non-Numbered board on the left and the numbered board on the right
    System.out.println();
    for(int r = 0; r < rows; r++) {
      for(int Lc = 0; Lc < cols; Lc++) {
        System.out.print(grid[r][Lc]+" ");
      }
      System.out.print("\t");
      for(int Rc = 0; Rc < cols; Rc++) {
	System.out.print(gridWithVals[r][Rc]+" ");
      }
    System.out.println();
    }
  }
}
