package com.techlabs.drumkit.testdrive;

import com.techlabs.drumkit.DrumKit;

public class TestDrive {

	public static void main(String[] args) {
		DrumKit d = new DrumKit();
		d.playSnare();
		d.snare = false;
		if (d.snare == true) {
				d.playSnare();
		}
		d.plyTopHat();
	}

}
