package eternal0_1;

public class AS_FireBall{
    private double x;
    private double y;
    protected double ball_dir;
    protected double spaceShipX;
    protected double spaceShipY;
    protected double angle;

    public AS_FireBall(double x, double y, double ssX, double ssY){
        this.x = x;
        this.y = y;
        this.ball_dir = 10;
        this.spaceShipX = ssX;
        this.spaceShipY = ssY;
        this.angle = 0;

        calculateRadian();
    }

    public void calculateRadian(){
        double deltaX = this.getX() - this.spaceShipX;
        double deltaY = this.getY() - this.spaceShipY;

        angle = Math.atan2(deltaY, deltaX);
    }

    public void moveBall(){
        this.setX(this.getX() - ball_dir*Math.cos(angle));
        this.setY(this.getY() - ball_dir*Math.sin(angle));
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getBall_dir() {
        return ball_dir;
    }

    public void setBall_dir(double ball_dir) {
        this.ball_dir = ball_dir;
    }
}
