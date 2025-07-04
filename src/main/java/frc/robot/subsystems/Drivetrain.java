package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    private DifferentialDrive drive;

    private WPI_TalonSRX leftTalon1;
    private WPI_TalonSRX leftTalon2;
    private WPI_TalonSRX rightTalon1;
    private WPI_TalonSRX rightTalon2;

    public Drivetrain() {
        leftTalon1 = new WPI_TalonSRX(5);
        leftTalon2 = new WPI_TalonSRX(6);

        leftTalon2.follow(leftTalon1);

        rightTalon1 = new WPI_TalonSRX(1);
        rightTalon2 = new WPI_TalonSRX(2);

        rightTalon2.follow(rightTalon1);

        drive = new DifferentialDrive(leftTalon1, rightTalon1);
    }

    public Command arcadeDrive(DoubleSupplier xSpeed, DoubleSupplier zRotation) {
        return run(() -> {
            drive.arcadeDrive(xSpeed.getAsDouble(), zRotation.getAsDouble());
        });
    }

    public Command driveTank(DoubleSupplier leftSpeed, DoubleSupplier rightSpeed) {
        return run(() -> {
            drive.tankDrive(leftSpeed.getAsDouble(), rightSpeed.getAsDouble());
        });
    }
}
