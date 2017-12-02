package robowars.arena;

import robowars.robots.MyRobot;

import java.util.ArrayList;
import java.util.List;

public class Arena {

    int width;
    int height;

    int robotSize;

    List<Robot> robots = new ArrayList<>();

    public Arena(int width, int height, int robotSize) {
        this.width = width;
        this.height = height;
        this.robotSize = robotSize;
        this.robots = new ArrayList<>();
    }

    public void addRobot(Robot newRobot, float x, float y) {
        newRobot.x = x;
        newRobot.y = y;
        robots.add(newRobot);
    }

    public void tick() {
        for (Robot robot : robots) {
            robot.tick();
            int rightBound = width - robotSize / 2;
            int leftBound = robotSize / 2;
            int upperBound = height - robotSize / 2;

            if (robot.x >= rightBound || robot.x <= leftBound || robot.y >= upperBound
                    || robot.y <= leftBound) {
                robot.onCollision();
                if (robot.x > rightBound) robot.x = rightBound;
                if (robot.y > upperBound) robot.y = upperBound;
                if (robot.x < leftBound) robot.x = leftBound;
                if (robot.y < leftBound) robot.y = leftBound;
            }

            robot.movedThisTurn = false;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Robot robot1 = new MyRobot("Ivan", RobotColor.RED);
        Robot robot2 = new MyRobot("Dmitry", RobotColor.GREE);
        MyRobot robot3 = new MyRobot("Ignat", RobotColor.CYAN);

        Arena arena = new Arena(400, 400, 50);

        arena.addRobot(robot1, 1, 2);
        arena.addRobot(robot2, 100, 2);
        arena.addRobot(robot3, 200, 2);

        Java2DArenaDrawer arenaDrawer = new Java2DArenaDrawer(arena);

        while (!arena.isFinished()) {
            Thread.sleep(20);
            arena.tick();
        }

    }

    public boolean isFinished() {
        return false;
    }
}
