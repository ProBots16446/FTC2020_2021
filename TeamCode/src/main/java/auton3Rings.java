// simple autonomous program that drives bot forward 2 seconds then ends.

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.Shared.HardwareBot;

import java.sql.Time;
import java.util.Timer;

// below is the Annotation that registers this OpMode with the FtcRobotController app.
// @Autonomous classifies the OpMode as autonomous, name is the OpMode title and the
// optional group places the OpMode into the Exercises group.
// uncomment the @Disable annotation to remove the OpMode from the OpMode list.

@Autonomous(name="auton3Rings", group="Exercises")
//@disabled
public class auton3Rings extends LinearOpMode
{
   HardwareBot robot = new HardwareBot();
   float gyro;
    // called when init button is  pressed.

    @Override
    public void runOpMode() throws InterruptedException {

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();
    }

        public void DriveForDistance(float angle, int distance, int speed)
        {
//set defalt spee

            // start timer
            // while time not reached

            robot.lastAngles = robot.gyro.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            gyro = robot.lastAngles.firstAngle;

            int power = 50;
            if(speed>0)
            {
                power = speed;
            }

            if(gyro == angle)
            {
                drive(speed,speed);
            }

            if(gyro >= angle)
            {
                //todo add determine speed method
                float dif = angle-gyro;
                // make bigger adjustment the bigger the dif.
                
                drive(speed, speed-10);
            }

            if(gyro <= angle)
            {
                drive(speed-10, speed);
            }

        }

public void drive(double leftPower, double rightPower)
        {
            robot.FrontLeft.setPower(leftPower);

// to do set for each wheel or side.

        }

        public int  determineSpeed(double angle ,double gyroangle)
        {
            //todo determine speed based on dif i[of actual and target
return 100;
        }


    }
