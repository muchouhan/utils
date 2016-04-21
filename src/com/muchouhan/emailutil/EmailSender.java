package com.muchouhan.emailutil;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class EmailSender implements Cloneable {

	/**
	 * 
	 */
	private static EmailSender sender = new EmailSender();

	/**
	 * 
	 */
	private EmailSender() {

	}

	/**
	 * 
	 * @return
	 */
	public static EmailSender getInstance() {
		return sender;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return null;
	}
	

	/**
	 * 
	 * @param host
	 * @param from
	 * @param to
	 * @param subject
	 * @param message
	 */
	public static void send(String host, String from, String to,
			String subject, String message) {
		try {
			
			//Set host and SMTP properties
			System.setProperty("mail.host", host);
			System.setProperty("mail.smtp.starttls.enable", "true");
			System.setProperty("mail.transport.protocol", "smtp");
			System.setProperty("mail.smtp.auth", "true");
			System.setProperty("mail.smtp.port", "465");
		

			// open connection using java.net internal "mailto" protocol handler
			URL url = new URL("mailto:" + to);
			URLConnection conn = url.openConnection();
			conn.connect();

			//TODO: To send message use below line 
			//PrintWriter out = new PrintWriter(new OutputStreamWriter(conn.getOutputStream()));
			
			//TODO: Below line need to comment if we have to send mail to real recipient
			PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8));
            			
			// write out mail headers
			// From header in the form From: "alias" <email>
			out.println("From: \"" + from + "\" <" + from + ">");
			out.println("To: " + to);
			out.println("Subject: " + subject);
			out.println(); // blank line to end the list of headers

			// write out the message
			out.println(message);

			// close the stream to terminate the message
			out.close();
		} catch (Exception err) {
			System.err.println(err);
		}
	}
}
