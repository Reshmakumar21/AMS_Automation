/*
 * @author Shivam Tiwari
 * @version 2.1
 * @since 2020-05-01
 */
package com.ibm.reports;

import javax.mail.PasswordAuthentication;

/**
 * The Class Authenticator.
 */
class Authenticator extends javax.mail.Authenticator {

	/** The authentication. */
	private PasswordAuthentication authentication;

	/**
	 * Instantiates a new authenticator.
	 *
	 * @param username
	 *            the username
	 * @param password
	 *            the password
	 */
	public Authenticator(String username, String password) {
		authentication = new PasswordAuthentication(username, password);
	}

	/**
	 * Gets the password authentication.
	 *
	 * @return the password authentication
	 */
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return authentication;
	}
}
