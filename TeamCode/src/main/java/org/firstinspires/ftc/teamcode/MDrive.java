package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.teamcode.Shared.HardwareBot;

@TeleOp(name="MDrive: TeleOP", group="Test")
//@Disabled
    public class MDrive extends OpMode{

        //Declare OpMode members. Use the class created to define the robot's hardware
        HardwareBot robot = new HardwareBot();

        //Telemetry boolean (used to turn on any valid telemetry at the right time)
        boolean joyPosTele = true;
        boolean joyPolarCoordTele = true;
        boolean wheelScalersTele = true;
        boolean leftBumper=false;
        boolean rightBumper=false;
    //Code to run ONCE when the driver hits INIT
        @Override
        public void init() {

//Initialize the hardware variables. The init() method of the hardware class does all the work here
            robot.init(hardwareMap);

// Send telemetry message to signify robot waiting
            telemetry.addData("Say", "Hell-O-Ween! Driver");
        }

        @Override
        public void init_loop() {
        }

        @Override
        public void start() {
        }

        @Override
        public void loop() {

            Drive();
            Shoot();
            Intake();

//Update the Telemetry
            telemetry.update();
        }

        //Code to run ONCE after the driver hits STOP
        @Override
        public void stop() {
        }
    public double limit(double value) {
        return Math.max(-1, Math.min(value, 1));
    }
        public void Drive()
        {
            double multipliar=1.25;
            double r = Math.hypot(gamepad1.left_stick_x, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(gamepad1.left_stick_y, -gamepad1.left_stick_x) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x;
            final double v1 = (r * Math.cos(robotAngle) - rightX)*multipliar;
            final double v2 = (r * Math.sin(robotAngle) + rightX)*multipliar;
            final double v3 = (r * Math.sin(robotAngle) - rightX)*multipliar;
            final double v4 = (r * Math.cos(robotAngle) + rightX)*multipliar;

            robot.FrontLeft.setPower(limit(v1));
            robot.FrontRight.setPower(limit(v2));
            robot.BackLeft.setPower(limit(v3));
            robot.BackRight.setPower(limit(v4));

            telemetry.addData("Speed: ", v1);
            telemetry.update();
            robot.lastAngles= robot.gyro.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
            telemetry.addData("1 imu heading", robot.lastAngles.firstAngle);

            telemetry.update();
        }
    public void Shoot()
    {

        double leftTriggerSpeed =gamepad1.left_trigger;

        robot.Shooter.setPower(limit(leftTriggerSpeed));




    }
   public void Intake() {

       leftBumper = gamepad1.left_bumper;
       rightBumper = gamepad1.right_bumper;

       if (rightBumper) {
           robot.IntakeTwo.setPower(100);
       }
       if (leftBumper) {
           robot.IntakeTwo.setPower(0);
       }


   }
}