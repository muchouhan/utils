package com.muchouhan.emailutil;

/**
 * 
 * @author muchouhan
 *
 */
public class EmailUtilityMain {


	/**
	 * 
	 */
	private static final String TO_RECIPIENT="mukundchouhan220@gmail.com";
	/**
	 * 
	 */
	private static final String PROTOCOL="smtp.gmail.com";
	/**
	 * 
	 */
	private static final String SUBJECT="This is Subject";
	/**
	 * 
	 */
	private static final String MESSAGE="This is real message";
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		String recipients = FileManager.getInstance().getActiveRecipient();
		EmailSender.getInstance().send(PROTOCOL,TO_RECIPIENT, recipients, SUBJECT,MESSAGE);
	}

}
