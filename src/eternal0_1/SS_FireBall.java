package eternal0_1;

public class SS_FireBall{
    private double x;
    private double y;
    private double angleTheta;
    protected double ball_dir;
    protected int mouse_Xcoor;
    protected int mouse_Ycoor;
//    protected Timer timer;

    public SS_FireBall(double x, double y, int mx, int my){
        this.x = x;
        this.y = y;
        this.ball_dir = 5;
        this.mouse_Xcoor = mx;
        this.mouse_Ycoor = my;
        this.angleTheta = 0;

        calculateRadian();
    }

    public void calculateRadian(){
        double deltaX = mouse_Xcoor - SpaceShip.spaceship_lastX - (SpaceShip.getSpaceShipWidth() / 2f);
        double deltaY = mouse_Ycoor - SpaceShip.getSpaceShip_y();

        angleTheta = Math.atan2(deltaY, deltaX);
    }

    public void moveBall(){
        double vel = this.ball_dir; // vel: 5
//        double radianTheta = Math.toRadians(angleTheta);
//        radianTheta -= Math.PI/2d;
        this.setXcoor(this.getXcoor() + vel*Math.cos(angleTheta));
        this.setYcoor(this.getYcoor() + vel*Math.sin(angleTheta));

    }

    public double getXcoor() {
        return x;
    }

    public void setXcoor(double x) {
        this.x = x;
    }

    public double getYcoor() {
        return y;
    }

    public void setYcoor(double y) {
        this.y = y;
    }

    public double getAngleTheta() {
        return angleTheta;
    }

    public void setAngleTheta(double angle) {
        this.angleTheta = angle;
    }

    public int getMouse_Xcoor() {
        return mouse_Xcoor;
    }

    public void setMouse_Xcoor(int mouse_Xcoor) {
        this.mouse_Xcoor = mouse_Xcoor;
    }

    public int getMouse_Ycoor() {
        return mouse_Ycoor;
    }

    public void setMouse_Ycoor(int mouse_Ycoor) {
        this.mouse_Ycoor = mouse_Ycoor;
    }
}
