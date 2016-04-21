package com.muchouhan.emailutil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileManager implements Cloneable {

	private static FileManager manager = new FileManager();

	private static StringBuffer recipients = new StringBuffer();

	private static final String CVSSPLITBY = ",";

	static {
		// Load the properties file
		try {
			BufferedReader br = null;
			String line = "";

			br = new BufferedReader(new InputStreamReader(FileManager.class.getResourceAsStream("/Recipient.txt")));

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] row = line.split(CVSSPLITBY);
				if (row[1].equalsIgnoreCase("active")) {
					recipients.append(row[0]+";");
				}
			}

		} catch (Exception e) {
			// Catching the exception as null condition
			// is handled in the methods.
		}
	}

	private FileManager() {

	}

	public String getActiveRecipient() {
		return recipients.toString();
	}

	public static FileManager getInstance() {
		return manager;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return null;
	}

}
