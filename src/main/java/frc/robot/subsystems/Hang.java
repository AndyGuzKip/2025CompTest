package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.Hang.*;

public class Hang extends SubsystemBase {
    private final CANSparkMax leftHangController;
    private final CANSparkMax rightHangController;
    private final double hangSpeed;
    private double leftEncoder = 0;
    private double rightEncoder = 0;
    private double upperLimit = -49; 
    private double lowerLimit = 0;
    private boolean limits = true;

    public Hang() {
        leftHangController = new CANSparkMax(leftHangID, MotorType.kBrushless); 
        rightHangController = new CANSparkMax(rightHangID, MotorType.kBrushless); 
        hangSpeed = maxSpeed;
    }

    @Override
    public void periodic() {
        leftEncoder =  leftHangController.getEncoder().getPosition();
        rightEncoder = rightHangController.getEncoder().getPosition();
        SmartDashboard.putNumber("Left Hang Current", leftHangController.getOutputCurrent());
        SmartDashboard.putNumber("Right Hang Current", rightHangController.getOutputCurrent());
        SmartDashboard.putNumber("Left Encoder", leftEncoder);
        SmartDashboard.putNumber("Right Encoder", rightEncoder);
    }

    public void runHang(int input) {    
        /*
         * If the hang is beyond its limit, it can only go in a favorable direction (e.g it can 
         * only go down if it's too high).
         */
        if(leftEncoder > lowerLimit && rightEncoder > lowerLimit && input == -1 && limits) {
            leftHangController.set(maxSpeed * -1);
            rightHangController.set(maxSpeed * -1);
        }
        else if(leftEncoder < upperLimit && rightEncoder < upperLimit && input == 1 && limits) {
            leftHangController.set(maxSpeed);
            rightHangController.set(maxSpeed);
        }
        else {
            leftHangController.set(maxSpeed * input);
            rightHangController.set(maxSpeed * input);
        }
    }

    public void stopHang() {
        leftHangController.set(0);
        rightHangController.set(0);
    }

    public void removeHangLimits() { limits = false; }
}