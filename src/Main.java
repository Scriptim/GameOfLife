public class Main {

  public static void main(String[] args) {
    int rows = 300;
    int cols = 500;
    int cellWidth = 2;
    if (args.length != 0) {
      if (args.length == 3) {
        try {
          rows = Integer.parseInt(args[0]);
          cols = Integer.parseInt(args[1]);
          cellWidth = Integer.parseInt(args[2]);
        } catch (NumberFormatException ex) {
          System.err.println("java -jar GameOfLife.jar [rows] [columns] [cell width]");
          System.exit(1);
          return;
        }
      } else {
        System.err.println("java -jar GameOfLife.jar [rows] [columns] [cell width]");
        System.exit(1);
        return;
      }
    }
    UserInterface.showUserInterface(rows, cols, cellWidth);
  }

}