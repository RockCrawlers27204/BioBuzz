package org.firstinspires.ftc.teamcode.Core;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

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
     */
    public void launchBall(double speed) {
        robot.launchLeft.setPower(speed);
        robot.launchRight.setPower(speed);

        //stuff below checks if wheel RPM is within the target range and feeds balls through
        double tolerance = 0.01; //RPM tolerance for launcher
        isFeeding = false;
        if (Math.abs(robot.launchLeft.getPower() - (speed)) <= tolerance && speed != 0) {
            robot.intakeMotor.setPower(-1);
            isFeeding = true;
        }
    }


}
