package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class Teleoperated {
	public static int init() {
		CameraServer.getInstance().startAutomaticCapture();
		return 0;
	}

	public static int periodic() {
		DriveMode previous = Drive.driveMode;
		switch (Robot.rightStick.joystick.getPOV()) {
			case 0:
				Drive.driveMode = DriveMode.DS4_TANK;
				break;
			case 45:
				break;
			case 90:
				Drive.driveMode = DriveMode.DS4_ARCADE;
				break;
			case 135:
				break;
			case 180:
				Drive.driveMode = DriveMode.HYBRID;
				break;
			case 225:
				break;
			case 270:
				Drive.driveMode = DriveMode.TANK;
				break;
			case 315:
				break;
		}
		if (Drive.driveMode != previous) {
			System.out.println("Drive mode changed to: " + Drive.driveMode);
		}

		switch (Drive.driveMode) {
			case ARCADE:
				break;
			case HYBRID:
				break;
			case TANK:
				break;
			case DS4_ARCADE:
				Drive.ds4ArcadeDrive();
				break;
			case DS4_TANK:
				Drive.ds4TankDrive();
				break;
		}
		//System.out.println(Robot.ultrasonic.getVoltage() + " | " + Robot.ultrasonic.getVoltage() / 0.1123046725988388);
		Distance distance = Robot.ultrasonic.getDistance();
		SmartDashboard.putString("DB/String 0", distance.getString());
		SmartDashboard.putString("DB/String 1", String.valueOf(distance.value));
		double servo = (Math.max(Math.min(distance.value, 24), 12) - 12) / 12;
		SmartDashboard.putString("DB/String 2", String.valueOf(servo));
		Robot.leftServo.set(servo);
		//System.out.println(distance.getFloorFeet() + " | " + distance.getFloorInches());
		//System.out.println(distance.toFeetInt() + " Feet, " + distance.toInchesInt() % 12 + " Inches.");

		/*double[] speeds;
		boolean modifier = Robot.rightStick.getTrigger();

		if (Drive.driveMode == DriveMode.TANK) {
			speeds = new double[] {Robot.leftStick.getY(), Robot.rightStick.getY()};
		} else if (Drive.driveMode == DriveMode.DS4_TANK) {
			double throttle = SmartDashboard.getNumber("DB/Slider 0", 1) / 5;
			speeds = new double[] {Robot.rightStick.getY() * throttle, -Robot.rightStick.joystick.getRawAxis(5) * throttle};
			if (SmartDashboard.getBoolean("DB/Button 0")) {
				Robot.rightServo.set((Robot.rightStick.joystick.getRawAxis(4) * 0.5) + 0.5);
				Robot.leftServo.set(1 - ((Robot.rightStick.joystick.getRawAxis(3) * 0.5) + 0.5));
				Robot.rightServo1.set((Robot.rightStick.joystick.getRawAxis(0) * 0.5) + 0.5);
				Robot.leftServo1.set(1 - ((Robot.rightStick.joystick.getRawAxis(2) * 0.5) + 0.5));
			}
			//Robot.ultrasonic.setAutomaticMode(true);
			//Robot.ultrasonic.ping();
			//System.out.println(Robot.ultrasonic.getRangeInches());
		} else {
			double forward = 0;
			double rotation = 0;
			switch (Drive.driveMode) {
				case ARCADE:
					forward = Robot.rightStick.getY();
					rotation = Robot.rightStick.getX();
					break;
				case HYBRID:
					forward = Robot.rightStick.getY();
					rotation = Robot.rightStick.getX() + (modifier ? Robot.rightStick.getTwist() : 0);

					//---------------------
					//Test.periodic();
					//---------------------

					break;
				case TWIST:
					forward = Robot.rightStick.getY();
					rotation = Robot.rightStick.getTwist();
					break;
				case TRIPLE:
					forward = Robot.rightStick.getY();
					rotation = Robot.rightStick.getTwist() + Robot.rightStick.getX() * Range.clamp(forward * 4, -1, 1);
					break;
				case DS4_ARCADE:
					forward = Robot.rightStick.getY() * SmartDashboard.getNumber("DB/Slider 0", 1) / 5;
					rotation = Robot.rightStick.getX() * SmartDashboard.getNumber("DB/Slider 1", 1) / 5;
					break;
			}
			speeds = new double[] {forward + rotation, forward - rotation};
		}

		speeds = Scale.scale(Scale.compress(speeds), Robot.rightStick.getThrottle() * (modifier ? 0.5 : 1));

		Robot.leftDrive.set(speeds[0]);
		Robot.rightDrive.set(speeds[1]);*/

		return 0;
	}
}