package org.firstinspires.ftc.teamcode.Core;



import static org.firstinspires.ftc.teamcode.Core.Robot.MoveDirection.*;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(group = "Templates", name = "Legacy Linear Autonomous")
public class RockCrawlerAuto extends LinearOpMode {
    private Robot robot;
    private AutonomousPLUS auto;

    public static final String ALLIANCE_KEY = "Alliance";
    public static final String PATTERN_KEY = "Pattern";

    public void runOpMode() {

        robot = new Robot(hardwareMap, telemetry, this);
        auto = new AutonomousPLUS(robot);

        while (opModeInInit()) {
            // This is the equivalent of init_loop(). It will repeat until the play button is
            // pressed.
            sleep(1);
        }


        robot.readyHardware();
        blackboard.put(ALLIANCE_KEY, "RED");

        waitForStart();

        //The code to run once play has been pressed goes here.
        //Does not loop, runs top to bottom
        auto.speed = 0.25; //sets default speed for the move funcs without speed input

        auto.moveAndStall(FORWARD, 900,0);
        sleep(0);
        //robot.runIntake(robot.intakeDefaultSpeed);
        //auto.moveAndStall(LEFT, 900,0);

        stop();
    }
}

