package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class DriveControls {
    /* Controllers */
    private final Joystick joystick0 = new Joystick(0); //Left
    private final Joystick joystick1 = new Joystick(1); //Middle
    private final Joystick joystick2 = new Joystick(2); //Right

    /* Driver Buttons */
    public final JoystickButton zeroGyro = new JoystickButton(joystick0, 10);
    public final JoystickButton robotCentric = new JoystickButton(joystick0, 7);
    public final JoystickButton hangExtend = new JoystickButton(joystick1, 11);
    public final JoystickButton hangRetract = new JoystickButton(joystick1, 10);
    public final JoystickButton hangNoLimits = new JoystickButton(joystick1, 9);
    public final JoystickButton activateShooter = new JoystickButton(joystick2, 9);
    public final JoystickButton runIntake = new JoystickButton(joystick2, 3);
    public final JoystickButton reverseIntake = new JoystickButton(joystick2, 7);
    public final JoystickButton toggleIntake = new JoystickButton(joystick2, 4);
    public final JoystickButton slowMode = new JoystickButton(joystick0, 0); //I wonder if button 0 is the trigger
    public final JoystickButton requestCoopertition = new JoystickButton(joystick2, 8);
    public final JoystickButton requestAmplification = new JoystickButton(joystick2, 6);

    public double getForward() { return joystick0.getY(); } //Deleted a negative symbol to flip directions
    public double getStrafe() { return joystick0.getX(); } //Deleted a negative symbol to flip directions
    public double getRotation() { return -joystick1.getX(); }  
}