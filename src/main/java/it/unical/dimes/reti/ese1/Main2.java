package it.unical.dimes.reti.ese1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;



public class Main2 {

	//CONNESSIONE CON UN SERVER NTP
	public static void main(String args[]) {
		try {

			Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);
//			Socket s = new Socket("ntp1.inrim.it", 13);
			System.out.println(s);
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			boolean more = true;

			//ora corrente dal server NTP
			while (more) {
				String line = in.readLine();
				if (line == null)
					more = false;
				else
					System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e);

		}
	}
}
