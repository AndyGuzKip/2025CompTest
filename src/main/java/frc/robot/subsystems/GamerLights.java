
//Manual: https://www.revrobotics.com/content/docs/REV-11-1105-UM.pdf 

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class GamerLights extends SubsystemBase {

    private Spark blinkin = new Spark(0); // PWM port of the driver
    private double lastToggleTime;
    private boolean isBlue;
    private double currentColor;

    public GamerLights() {
        lastToggleTime = Timer.getFPGATimestamp(); // Get initial timestamp
        isBlue = true; // Start with blue
        currentColor = 0.87; // Initialize to blue color
        blinkin.set(currentColor); // Set initial color
        
        Timer.start();
    }

    // Update the color based on the current state
    private void updateColor() {
        if (isBlue) {
            currentColor = 0.87; // Blue color value
        } else {
            currentColor = 0.69; // Yellow color value
        }
        blinkin.set(currentColor); // Set the color
    }

    // Method to toggle the color
    public void toggleColor() {
        isBlue = !isBlue; // Toggle the color state
        updateColor(); // Update the color
    }

    // Method to start the timer
    public void startTimer() {
        lastToggleTime = Timer.getFPGATimestamp(); // Reset the timestamp
    }

    // Method to check if it's time to toggle the color and reset the timer if needed
    
    public void periodic() {
     
        if (Timer.getFPGATimestamp() - lastToggleTime >= 5) { // Check if 5 seconds have elapsed

        // isBlue = isBlue; // Toggle the color back to blue

        toggleColor(); // Toggle the color
        startTimer(); // Reset the timer    
      }
    }


    // Method to set the button light color (strobe white)
    @Override
    public void buttonLight() {
        currentColor = -0.05; // White color value
        updateColor(); // Update the color
    }
}
