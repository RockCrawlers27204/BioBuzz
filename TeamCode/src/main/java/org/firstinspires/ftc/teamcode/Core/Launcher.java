package org.firstinspires.ftc.teamcode.Core;


public class Launcher {
    private final Robot robot;
    public Launcher (Robot robot) {
        this.robot = robot;
    }

    public boolean isFeeding = false;

    /**
     * turns on launch motors,
     * turns on intake when motors up to speed
     * @param speed launch speed as a decimal 0-1
     * @param motorRPM maximum RPM of installed motors
     */
    public void launchBall(double speed, int motorRPM) {
        robot.launchLeft.setVelocity(speed * motorRPM); //flip if reversed
        robot.launchRight.setVelocity(speed * motorRPM); //flip if reversed

        //stuff below checks if wheel RPM is within the target range and feeds balls through
        int tolerance = 80; //RPM tolerance for launcher
        isFeeding = false;
        if (Math.abs(robot.launchRight.getVelocity() - (speed * motorRPM)) < tolerance && speed != 0) {
            robot.intakeMotor.setPower(-1);
            isFeeding = true;
        }
    }

}
