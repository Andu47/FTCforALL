package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.external.Telemetry;


@Config
@TeleOp()
public class TestServo extends LinearOpMode {

    Servo servo;

    double poz = 0;

    Telemetry telemetry;

    public void runOpMode(){

        servo=hardwareMap.get(Servo.class,"Servo");

        telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());


        waitForStart();
        while (opModeIsActive()){
            poz = poz + gamepad1.left_stick_y * 0.001;

            telemetry.addData("poz", poz);

            servo.setPosition(poz);

            telemetry.update();
        }
    }
}
