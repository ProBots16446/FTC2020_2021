package org.firstinspires.ftc.teamcode.Shared;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note: All names are lower case and some have single spaces between words.
 *
 * Motor channel: Drive Motor 1: "drive1"
 * Motor channel: Drive Motor 2: "drive2"
 * Motor channel: Drive Motor 3: "drive3"
 * Motor channel: Drive Motor 4: "drive4"
 */
public class HardwareBot {
    /* Public OpMode members. */
    public DcMotor FrontLeft = null;
    public DcMotor FrontRight = null;
    public DcMotor BackLeft = null;
    public DcMotor BackRight = null;
    public DcMotor ShooterLeft = null;
    public DcMotor ShooterRight = null;

    /* Local OpMode members. */
    HardwareMap hwMapRobot = null;

    /* Constructor */
    public HardwareBot() {
    }
    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {

// Save reference to Hardware map
        hwMapRobot = ahwMap;

// Define and Initialize Motors
       
        FrontLeft = hwMapRobot.dcMotor.get("frontLeft");
        FrontRight = hwMapRobot.dcMotor.get("frontRight");
        BackLeft = hwMapRobot.dcMotor.get("backLeft");
        BackRight = hwMapRobot.dcMotor.get("backRight");
        ShooterLeft = hwMapRobot.dcMotor.get("shooterLeft");
        ShooterRight = hwMapRobot.dcMotor.get("shooterRight");
//Define Motor Directions
        FrontLeft.setDirection(DcMotor.Direction.FORWARD);
        FrontRight.setDirection(DcMotor.Direction.REVERSE);
        BackLeft.setDirection(DcMotor.Direction.FORWARD);
        BackRight.setDirection(DcMotor.Direction.FORWARD);
        ShooterLeft.setDirection(DcMotor.Direction.FORWARD);
        ShooterRight.setDirection(DcMotor.Direction.FORWARD);
// Set all motors to zero power
        FrontLeft.setPower(0);
        FrontRight.setPower(0);
        BackLeft.setPower(0);
        BackRight.setPower(0);
        ShooterLeft.setPower(0);
        ShooterRight.setPower(0);
// Set all motors to run with encoders.
// May want to use RUN_USING_ENCODER if encoders are installed.
        FrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS );
        FrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS );
        BackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS );
        BackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS );
        ShooterLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS );
        ShooterRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODERS );

    }
}
