package robowars.arena;

/**
 * Created by kodoo on 19.11.17.
 */
public enum RobotColor {

    RED("\u001B[31m"),
    GREE("\u001B[32m"),
    CYAN("\u001B[36m");

    String colorString;

    RobotColor(String colorString) {
        this.colorString = colorString;
    }

    public static String resetColor() {
        return "\u001B[0m";
    }

}
