package model;

import gobblerobservation.GobblerObservable;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Observer;

class Kakler extends Thread {

	private OutputStream target;
	private InputStream source;
	private GobblerObservable gob = new GobblerObservable();

	Kakler(InputStream source, OutputStream target) {
		this.target = target;
		this.source = source;
		start();
	}

	public void run() {
		try {
			int n = -1;
			while ((n = source.read()) != -1) {
				target.write(n);
			    gob.setValue(n);
			}			
			target.close();
		} catch (Exception ioe) {
		}
	}

//	public String getTheId() {
//		// TODO Auto-generated method stub
//		return "ID = " + theId;
//	}

}
