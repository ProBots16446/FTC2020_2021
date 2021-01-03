// simple autonomous program that drives bot forward 2 seconds then ends.

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

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

public class auton3Rings<done, shoot> extends LinearOpMode {
    HardwareBot robot = new HardwareBot();

    float gyro;
    // called when init button is  pressed.
    boolean done;


    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Mode", "waiting");
        telemetry.update();
        robot.init(hardwareMap);
        // wait for start button.
        waitForStart();

        while (!done) // while not done
        {
            DriveForDistance(0,
                    1, 50

            );
            shoot(2000,100);

            shoot(0,0);

            DriveForDistance(0, 1, 80);
            done = true;
            sleep(2000);
            // drive
        }

        //drive forward
        telemetry.addData("Mode", "running");
        telemetry.update();
    }

    public void DriveForDistance(float angle, long distance, int speed) {
        long start = System.currentTimeMillis();
        long finish = System.currentTimeMillis();
        long timeElapsed = 0;

        telemetry.addData("ElapsedTime", String.valueOf(timeElapsed));
        telemetry.update();

        /// 1 second is 1000 mili seconds
        while (timeElapsed < distance * 1000)
        {
            timeElapsed = finish - start;

            robot.lastAngles = robot.gyro.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            gyro = robot.lastAngles.firstAngle;

            int power = 50;
            if (speed > 0) {
                power = speed;
            }

            if (gyro == angle) {
                drive(speed, speed);
            }

            if (gyro >= angle) {
                //todo add determine speed method
                float dif = angle - gyro;
                // make bigger adjustment the bigger the dif.

                drive(speed, speed - 12);
                drive(speed + 10, speed);

            }

            if (gyro <= angle) {
                float dif = angle - gyro;
                drive(speed - 10, speed);
                drive(speed, speed + 8);
            }
            finish = System.currentTimeMillis();
            drive(0, 0);
        }

        }



        public void shoot(int time, int power)
        {
            robot.Shooter.setPower(power);
            sleep(time);
            robot.IntakeTwo.setPower(power);
            sleep(time);

    }




        public void drive(double leftPower, double rightPower){
        robot.FrontLeft.setPower(leftPower);
        robot.FrontRight.setPower(rightPower);
        robot.BackLeft.setPower(leftPower);
        robot.BackRight.setPower(rightPower);


// to do set for each wheel or side.

    }

    public int determineSpeed(double angle, double gyroangle) {
        //todo determine speed based on dif i[of actual and target
        return 100;
    }




    }