public class Presets {

  // generate random field with living portion of 'ratio'
  static boolean[] random(int rows, int cols, float ratio) {
    boolean[] grid = new boolean[rows * cols];
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        grid[getIndex(row, col, cols)] = Math.random() < ratio;
      }
    }
    return grid;
  }

  // 1 = alive, 0 = dead
  static boolean[] getPreset(String preset, int rows, int cols) {
    switch (preset) {
      case "empty":
        boolean[] grid = new boolean[rows * cols];
        for (int i = 0; i < grid.length; i++) {
          grid[i] = false;
        }
        return grid;
      case "block":
        return gridFromPattern(new int[][]{
            {1, 1},
            {1, 1}
        }, rows, cols);
      case "beehive":
        return gridFromPattern(new int[][]{
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {0, 1, 1, 0}
        }, rows, cols);
      case "loaf":
        return gridFromPattern(new int[][]{
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {0, 1, 0, 1},
            {0, 0, 1, 0}
        }, rows, cols);
      case "tub":
        return gridFromPattern(new int[][]{
            {0, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
        }, rows, cols);
      case "boat":
        return gridFromPattern(new int[][]{
            {1, 1, 0},
            {1, 0, 1},
            {0, 1, 0}
        }, rows, cols);
      case "longboat":
        return gridFromPattern(new int[][]{
            {0, 1, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {0, 0, 1, 1}
        }, rows, cols);
      case "ship":
        return gridFromPattern(new int[][]{
            {1, 1, 0},
            {1, 0, 1},
            {0, 1, 1}
        }, rows, cols);
      case "barge":
        return gridFromPattern(new int[][]{
            {0, 1, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {0, 0, 1, 0}
        }, rows, cols);
      case "snake":
        return gridFromPattern(new int[][]{
            {1, 0, 1, 1},
            {1, 1, 0, 1}
        }, rows, cols);
      case "python":
        return gridFromPattern(new int[][]{
            {0, 0, 0, 1, 1},
            {1, 0, 1, 0, 1},
            {1, 1, 0, 0, 0}
        }, rows, cols);
      case "fishhook":
        return gridFromPattern(new int[][]{
            {1, 1, 0, 0},
            {1, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 1, 1},
        }, rows, cols);
      case "blinker":
        return gridFromPattern(new int[][]{
            {1, 1, 1}
        }, rows, cols);
      case "toad":
        return gridFromPattern(new int[][]{
            {0, 1, 1, 1},
            {1, 1, 1, 0},
        }, rows, cols);
      case "clock":
        return gridFromPattern(new int[][]{
            {0, 1, 0, 0},
            {0, 1, 0, 1},
            {1, 0, 1, 0},
            {0, 0, 1, 0}
        }, rows, cols);
      case "beacon":
        return gridFromPattern(new int[][]{
            {1, 1, 0, 0},
            {1, 0, 0, 0},
            {0, 0, 0, 1},
            {0, 0, 1, 1}
        }, rows, cols);
      case "bipole":
        return gridFromPattern(new int[][]{
            {1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1}
        }, rows, cols);
      case "tumbler":
        return gridFromPattern(new int[][]{
            {1, 1, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1},
            {0, 0, 1, 0, 1, 0, 0},
            {0, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 0}
        }, rows, cols);
      case "octagon":
        return gridFromPattern(new int[][]{
            {0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 1},
            {0, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 1},
            {0, 1, 0, 0, 1, 0}
        }, rows, cols);
      case "pulsar":
        return gridFromPattern(new int[][]{
            {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0}
        }, rows, cols);
      case "1-2-3-4":
        return gridFromPattern(new int[][]{
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}
        }, rows, cols);
      case "aforall":
        return gridFromPattern(new int[][]{
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }, rows, cols);
      case "pentadecathlon":
        return gridFromPattern(new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        }, rows, cols);
      case "queenbeeshuttle":
        return gridFromPattern(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }, rows, cols);
      case "achimsp11":
        return gridFromPattern(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }, rows, cols);
      case "glider":
        return gridFromPattern(new int[][]{
            {0, 0, 1},
            {1, 0, 1},
            {0, 1, 1}
        }, rows, cols);
      case "lwss":
        return gridFromPattern(new int[][]{
            {0, 1, 1, 1, 1},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0}
        }, rows, cols);
      case "mwss":
        return gridFromPattern(new int[][]{
            {0, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0}
        }, rows, cols);
      case "hwss":
        return gridFromPattern(new int[][]{
            {0, 1, 1, 1, 1, 1, 1},
            {1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 0, 0, 0}
        }, rows, cols);
      case "canadagoose":
        return gridFromPattern(new int[][]{
            {1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {0, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }, rows, cols);
      case "copperhead":
        return gridFromPattern(new int[][]{
            {0, 1, 1, 0, 0, 1, 1, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 1, 1, 0},
            {0, 0, 1, 1, 1, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0},
            {0, 0, 0, 1, 1, 0, 0, 0}
        }, rows, cols);
      case "loafer":
        return gridFromPattern(new int[][]{
            {0, 1, 1, 0, 0, 1, 0, 1, 1},
            {1, 0, 0, 1, 0, 0, 1, 1, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 1}
        }, rows, cols);
      case "rpentomino":
        return gridFromPattern(new int[][]{
            {0, 1, 1},
            {1, 1, 0},
            {0, 1, 0}
        }, rows, cols);
      case "bheptomino":
        return gridFromPattern(new int[][]{
            {1, 0, 1, 1},
            {1, 1, 1, 0},
            {0, 1, 0, 0}
        }, rows, cols);
      case "cheptomino":
        return gridFromPattern(new int[][]{
            {0, 1, 1, 1},
            {1, 1, 1, 0},
            {0, 1, 0, 0}
        }, rows, cols);
      case "eheptomino":
        return gridFromPattern(new int[][]{
            {0, 1, 1, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 0}
        }, rows, cols);
      case "fheptomino":
        return gridFromPattern(new int[][]{
            {1, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 0, 0},
            {0, 1, 1, 1}
        }, rows, cols);
      case "pi":
        return gridFromPattern(new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 0, 1}
        }, rows, cols);
      case "acorn":
        return gridFromPattern(new int[][]{
            {0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {1, 1, 0, 0, 1, 1, 1}
        }, rows, cols);
      case "blocknglider":
        return gridFromPattern(new int[][]{
            {1, 1, 0, 0},
            {1, 0, 1, 0},
            {0, 0, 1, 1}
        }, rows, cols);
      case "bunnies":
        return gridFromPattern(new int[][]{
            {1, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 0}
        }, rows, cols);
      case "rabbits":
        return gridFromPattern(new int[][]{
            {1, 0, 0, 0, 1, 1, 1},
            {1, 1, 1, 0, 0, 1, 0},
            {0, 1, 0, 0, 0, 0, 0}
        }, rows, cols);
      case "glidersbythedozen":
        return gridFromPattern(new int[][]{
            {1, 1, 0, 0, 1},
            {1, 0, 0, 0, 1},
            {1, 0, 0, 1, 1}
        }, rows, cols);
      case "herschel":
        return gridFromPattern(new int[][]{
            {1, 0, 0},
            {1, 1, 1},
            {1, 0, 1},
            {0, 0, 1}
        }, rows, cols);
      case "thunderbird":
        return gridFromPattern(new int[][]{
            {1, 1, 1},
            {0, 0, 0},
            {0, 1, 0},
            {0, 1, 0},
            {0, 1, 0}
        }, rows, cols);
      case "23334m":
        return gridFromPattern(new int[][]{
            {0, 0, 1, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0},
            {1, 0, 0, 1, 0},
            {0, 0, 0, 0, 1},
            {0, 1, 0, 0, 1},
            {0, 0, 1, 0, 1},
            {0, 1, 0, 0, 0}
        }, rows, cols);
      case "7468m":
        return gridFromPattern(new int[][]{
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 1},
            {1, 1, 0, 1, 1, 0},
            {1, 0, 0, 0, 0, 0}
        }, rows, cols);
      case "diehard":
        return gridFromPattern(new int[][]{
            {0, 0, 0, 0, 0, 0, 1, 0},
            {1, 1, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 1, 1}
        }, rows, cols);
      case "gosperglidergun":
        return gridFromPattern(new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }, rows, cols);
      case "blocklayingswitchengine1":
        return gridFromPattern(new int[][]{
            {0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 1, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0}
        }, rows, cols);
      case "blocklayingswitchengine2":
        return gridFromPattern(new int[][]{
            {1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0},
            {0, 0, 0, 1, 1},
            {0, 1, 1, 0, 1},
            {1, 0, 1, 0, 1}
        }, rows, cols);
      case "blocklayingswitchengine3":
        return gridFromPattern(new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1}
        }, rows, cols);
      default:
        throw new IllegalArgumentException("Unknown preset '" + preset + "'");
    }
  }

  private static boolean[] gridFromPattern(int[][] pattern, int rows, int cols) {
    boolean[] grid = new boolean[rows * cols];
    for (int i = 0; i < grid.length; i++) {
      grid[i] = false;
    }
    for (int row = 0; row < pattern.length; row++) {
      for (int col = 0; col < pattern[row].length; col++) {
        int offsetX = cols / 2 - pattern[row].length / 2;
        int offsetY = rows / 2 - pattern.length / 2;
        grid[getIndex(row + offsetY, col + offsetX, cols)] = pattern[row][col] == 1;
      }
    }
    return grid;
  }

  // converts two-dimensional to one-dimensional index
  private static int getIndex(int row, int col, int cols) {
    return row * cols + col;
  }

}
