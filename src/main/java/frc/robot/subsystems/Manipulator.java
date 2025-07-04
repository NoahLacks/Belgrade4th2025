package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.Constants;

public class Manipulator extends SubsystemBase {
    private WPI_TalonSRX motor1;
    private WPI_TalonSRX motor2;

    public Manipulator() {
        motor1 = new WPI_TalonSRX(Constants.manipulatorMotor1);
        motor2 = new WPI_TalonSRX(Constants.manipulatorMotor2);

        motor2.follow(motor1);
    }

    public Command runManipulator(DoubleSupplier speed) {
        return run(() -> {
            motor1.set(speed.getAsDouble());
        });
    }
}
