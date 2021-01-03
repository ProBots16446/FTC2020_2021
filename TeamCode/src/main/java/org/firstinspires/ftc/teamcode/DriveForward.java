// simple autonomous program that drives bot forward 2 seconds then ends.

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

// below is the Annotation that registers this OpMode with the FtcRobotController app.
// @Autonomous classifies the OpMode as autonomous, name is the OpMode title and the
// optional group places the OpMode into the Exercises group.
// uncomment the @Disable annotation to remove the OpMode from the OpMode list.

@Autonomous(name="Drive Forward", group="Exercises")
//@disabled
public class DriveForward extends LinearOpMode
{
    DcMotor FrontRight;
    DcMotor FrontLeft;
    DcMotor BackRight;
    DcMotor BackLeft;

    // called when init button is  pressed.

    @Override
    public void runOpMode() throws InterruptedException
    {
        FrontRight = hardwareMap.dcMotor.get("frontRight");
        FrontLeft = hardwareMap.dcMotor.get("frontLeft");
        BackRight = hardwareMap.dcMotor.get("backRight");
        BackLeft = hardwareMap.dcMotor.get("backLeft");

        FrontLeft.setDirection(DcMotor.Direction.REVERSE);
        FrontRight.setDirection(DcMotor.Direction.FORWARD);
        BackLeft.setDirection(DcMotor.Direction.REVERSE);
        BackRight.setDirection(DcMotor.Direction.REVERSE);

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();

        // set both motors to 25% power.

        FrontRight.setPower(1);
        FrontLeft.setPower(1);
        BackRight.setPower(1);
        BackLeft.setPower(1);

        sleep(1500);        // wait for 2 seconds.

        // set motor power to zero to stop motors.

        FrontRight.setPower(0);
        FrontLeft.setPower(0);
        BackRight.setPower(0);
        BackLeft.setPower(0);
    }
}