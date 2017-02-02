package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class Test {
	public static int init() {
		return 0;
	}

	public static int periodic() {
		/*String string = SmartDashboard.getString("DB/String 5");

		if (string.length() >= 4) {
			Robot.leftServo.set(((double) string.toCharArray()[0] - 48) / 10);
			Robot.leftServo1.set(((double) string.toCharArray()[1] - 48) / 10);
			Robot.rightServo.set(((double) string.toCharArray()[2] - 48) / 10);
			Robot.rightServo1.set(((double) string.toCharArray()[3] - 48) / 10);
		}*/

		if (SmartDashboard.getBoolean("DB/Button 0")) {
			setValues();
		}
		if (SmartDashboard.getBoolean("DB/Button 1")){
			setValues();
			SmartDashboard.putBoolean("DB/Button 1", false);
		}

		return 0;
	}

	static void setValues() {
		Robot.leftServo.set((SmartDashboard.getNumber("DB/Slider 0")) / 5);
		Robot.leftServo1.set((SmartDashboard.getNumber("DB/Slider 1")) / 5);
		Robot.rightServo.set((SmartDashboard.getNumber("DB/Slider 2")) / 5);
		Robot.rightServo1.set((SmartDashboard.getNumber("DB/Slider 3")) / 5);
	}
}