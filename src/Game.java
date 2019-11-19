class Game {

  // true = alive, false = dead
  private boolean[] grid;

  final private int rows;
  final private int cols;

  Game(int rows, int cols) {
    this.grid = new boolean[rows * cols];
    this.rows = rows;
    this.cols = cols;
    this.grid = Presets.getPreset("empty", rows, cols);
  }

  // generates the next generation
  void lifeCycle() {
    boolean[] newGrid = new boolean[this.grid.length];
    for (int row = 0; row < this.rows; row++) {
      for (int col = 0; col < this.cols; col++) {
        // https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life#Rules
        switch (this.getNeighbors(row, col)) {
          case 0:
          case 1:
            newGrid[getIndex(row, col)] = false;
            break;
          case 2:
            newGrid[getIndex(row, col)] = this.grid[getIndex(row, col)];
            break;
          case 3:
            newGrid[getIndex(row, col)] = true;
            break;
          case 4:
          case 5:
          case 6:
          case 7:
          case 8:
            newGrid[getIndex(row, col)] = false;
            break;
        }
      }
    }
    this.grid = newGrid;
  }

  void setGrid(boolean[] grid) {
    this.grid = grid;
  }

  boolean[] getGrid() {
    return this.grid;
  }

  // returns amount of alive neighbors
  int getNeighbors(int row, int col) {
    int neighbors = 0;
    for (int i = Math.max(0, row - 1); i <= Math.min(row + 1, this.rows - 1); i++) {
      for (int j = Math.max(0, col - 1); j <= Math.min(col + 1, this.cols - 1); j++) {
        if (!(i == row && j == col) && this.grid[this.getIndex(i, j)]) {
          neighbors++;
        }
      }
    }
    return neighbors;
  }

  // converts two-dimensional to one-dimensional index
  int getIndex(int row, int col) {
    return row * this.cols + col;
  }

}
