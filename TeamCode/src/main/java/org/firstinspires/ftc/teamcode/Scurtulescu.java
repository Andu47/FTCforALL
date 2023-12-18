package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.acmerobotics.dashboard.config.Config;



@Config
@TeleOp()
public class Scurtulescu extends LinearOpMode {
    DcMotor MotorJos;
    DcMotor MotorSus;
    Servo servo;

    public void runOpMode(){
      MotorJos=hardwareMap.get(DcMotor.class,"DcMotorJos");
      MotorSus=hardwareMap.get(DcMotor.class,"DcMotorSus");
      servo=hardwareMap.get(Servo.class,"Servo");

      waitForStart();
      while (opModeIsActive()){
          MotorJos.setPower(0);
          if (gamepad1.a)
              MotorJos.setPower(0.8);
          if(gamepad1.b)
              MotorJos.setPower(0);
          if (gamepad1.right_bumper)
              MotorSus.setPower(0.8);
          if(gamepad1.left_bumper)
              MotorSus.setPower(-0.8);

          servo.setPosition(gamepad1.right_trigger);
      }
    }
}
