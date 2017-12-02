package robowars.arena;

public class ArenaASCIIDrawer {

    private Arena arena;
    private String screenChars[][];


    public ArenaASCIIDrawer(Arena arena) {
        this.arena = arena;
        screenChars = new String[arena.width + 1][arena.height + 1];
    }

    public void draw() {
        clearChars();

        for (Robot robot : arena.robots) {
            screenChars[(int) robot.x][(int) robot.y] =
                    robot.getColor().colorString + '@' + RobotColor.resetColor();
        }
        outputChars();
    }

    private void clearChars() {
        for (int x = 0; x < arena.width + 1; x++) {
            for (int y = 0; y < arena.height + 1; y++) {
                screenChars[x][y] = " ";
                if (x == 0 || x == arena.width || y == 0 || y == arena.height) {
                    screenChars[x][y] = ".";
                }
            }
        }
    }

    private void outputChars() {
        char escCode = 0x1B;
        int row = arena.height + 1; int column = 0;
        System.out.print(String.format("%c[%d;%df",escCode,row,column));

        StringBuilder out = new StringBuilder();
        for (int y = arena.height; y >= 0; y--) {
            for (int x = 0; x < arena.width + 1; x++) {
                out.append(screenChars[x][y]);
            }
            out.append('\n');
        }
        System.out.println(out.toString());
    }
}
