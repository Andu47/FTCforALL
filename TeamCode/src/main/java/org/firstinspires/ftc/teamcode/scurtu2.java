package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.Telemetry;


@Config
@TeleOp()
public class scurtu2 extends LinearOpMode {
    DcMotor MotorJos;
    DcMotor MotorSus;
    Servo servo;
    GamepadEx gm;
    int pozMotor=0;

    int pozmaxim = 2000;
    boolean pornit_motor_jos = false;

    boolean pornit_servo = false;

    Telemetry telemetry;


    public void runOpMode(){
        MotorJos=hardwareMap.get(DcMotor.class,"DcMotorJos");
        MotorSus=hardwareMap.get(DcMotor.class,"DcMotorSus");
        servo=hardwareMap.get(Servo.class,"Servo");
        MotorSus.setTargetPosition(pozMotor);
        MotorSus.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        telemetry = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());

        gm = new GamepadEx(gamepad1);

        waitForStart();
        while (opModeIsActive()) {
            gm.getGamepadButton(GamepadKeys.Button.A).whenPressed(() -> pornire_motor_jos());

            pozMotor = Range.clip((int) (pozMotor + gm.getLeftY() * 20), 0, pozmaxim);
            MotorSus.setTargetPosition(pozMotor);

            gm.getGamepadButton(GamepadKeys.Button.A).whenPressed(() -> pornire_servo());
            telemetry.addData("MotorSusPoz", pozMotor);
            telemetry.update();


        }
    }
    void pornire_motor_jos() {
        if (pornit_motor_jos) {
            MotorJos.setPower(0.8);
            pornit_motor_jos = false;
        } else {
            MotorJos.setPower(0);
            pornit_motor_jos = true;
        }
    }

    void pornire_servo() {
        if (pornit_servo) {
            servo.setPosition(1);
            pornit_servo = false;
        } else {
            servo.setPosition(0);
            pornit_servo = true;
        }
    }
}


