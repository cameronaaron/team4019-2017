package org.usfirst.frc.team4019;

import edu.wpi.first.wpilibj.AnalogInput;

class Distance {
	double value;
	public Distance(double value) {
		this.value = value;
	}

	double getFeet() {
		return this.value / 12;
	}

	int getFeetRound() {
		return (int) Math.round(this.getFeet());
	}

	int getFeetFloor() {
		return (int) Math.floor(this.getFeet());
	}

	int getFeetCeil() {
		return (int) Math.ceil(this.getFeet());
	}

	double getInches() {
		return this.value % 12;
	}

	int getInchesRound() {
		return (int) Math.round(this.getInches());
	}

	int getInchesFloor() {
		return (int) Math.floor(this.getInches());
	}

	int getInchesCeil() {
		return (int) Math.ceil(this.getInches());
	}

	double getInchesTotal() {
		return this.value;
	}

	int getTotalInchesRound() {
		return (int) Math.round(this.getInchesTotal());
	}

	int getTotalInchesFloor() {
		return (int) Math.floor(this.getInchesTotal());
	}

	int getTotalInchesCeil() {
		return (int) Math.ceil(this.getInchesTotal());
	}

	String getString() {
		int feet = this.getFeetFloor();
		int inches = this.getInchesFloor();
		return feet + "' " + inches + "\"";
	}
}

public class Ultrasonic {
	int port;
	AnalogInput analogInput;
	static double voltsToFeetGlobal = 0.0093587227165699;//0.1123046725988388;
	double voltsToFeet = Ultrasonic.voltsToFeetGlobal;
	public Ultrasonic(int port) {
		this.port = port;
		this.analogInput = new AnalogInput(this.port);
	}

	Distance getDistance() {
		return new Distance(this.analogInput.getVoltage() / this.voltsToFeet);
	}

	Distance getRound() {
		return new Distance(Math.round(this.analogInput.getVoltage() / this.voltsToFeet));
	}
}
