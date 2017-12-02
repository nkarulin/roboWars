package robowars.robots;

import robowars.arena.Robot;
import robowars.arena.RobotColor;

public class MyRobot extends Robot {

    private String name;
    private RobotColor color;

    public MyRobot(String name, RobotColor color) {
        this.name = name;
        this.color = color;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public RobotColor getColor() {
        return color;
    }

    @Override
    public void onCollision() {
        turnLeft(90f);
    }

    @Override
    public void tick() {
        ahead();
    }

}
