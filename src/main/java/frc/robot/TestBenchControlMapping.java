package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.HandCommands;

/**
 * All of the mapping of controls to commands happens here.
 */
public class TestBenchControlMapping {

    public static final double DEADBAND = 0.1;

    /**
     * Maps additional controls on the driver's joystick
     *    - X will trigger Kyle & Christopher's command
     *    - Y will trigger Ed's command
     *    - Start will zero the gyro again
     * 
     * Add additional button/axis mappings here.
     */
    public static void mapControls(TestBench testBench, XboxController specialopsController) {
        // TODO map commands here
        trigger(specialopsController, Button.kY, HandCommands.grabCone(testBench.hand));
        trigger(specialopsController, Button.kB, HandCommands.grabCube(testBench.hand));
        trigger(specialopsController, Button.kRightBumper, HandCommands.release(testBench.hand));
    //    trigger(specialopsController, Button.kBack, new ArmPresetCommand(testBench.arm, ArmPresetCommand.TRAVEL_PRESET));
    }

    /**
     * Use this to make a specific button trigger a command
     */
    public static void trigger(XboxController controller, Button button, Command command) {
        new JoystickButton(controller, button.value).onTrue(command);
    }
}