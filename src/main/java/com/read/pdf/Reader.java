package com.read.pdf;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

public class Reader {

	@Test
	public void read() {
		try {
			// String homePath = RuntimeEnv.getInstance().getNCHome();
			// String filePath = homePath + "/tempdoc/" + docId + ".pdf";
			BufferedReader in = new BufferedReader(new FileReader("resource/aglie.pdf"));
			String str;
			while ((str = in.readLine()) != null) {
				System.out.println(str);
			}
			System.out.println(str);
		} catch (IOException e) {
		}
	}

}
