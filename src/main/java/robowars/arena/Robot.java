package robowars.arena;

public abstract class Robot {

    public static final double SPEED = 5.0;
    float x;
    float y;

    float angle;

    boolean movedThisTurn;

    public abstract String getName();
    public abstract RobotColor getColor();

    public abstract void onCollision();
    public abstract void tick();

    public final void turnRight(float degree) {
        angle += degree;
    }

    public final void turnLeft(float degree) {
        angle -= degree;
    }

    public final void ahead() {
        if (movedThisTurn) {
            return;
        }

        movedThisTurn = true;

        x += SPEED * Math.cos(angle);
        y += SPEED * Math.sin(angle);
    }

    public final void backward() {
        if (movedThisTurn) {
            return;
        }

        movedThisTurn = true;

        x -= SPEED * Math.cos(angle);
        y -= SPEED * Math.sin(angle);
    }
}
