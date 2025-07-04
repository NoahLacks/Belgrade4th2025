package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
    private WPI_TalonSRX motor;

    public Arm() {
        motor = new WPI_TalonSRX(8);
    }

    public Command runArm(DoubleSupplier speed) {
        return run(() -> {
            motor.set(speed.getAsDouble());
        });
    }
}
