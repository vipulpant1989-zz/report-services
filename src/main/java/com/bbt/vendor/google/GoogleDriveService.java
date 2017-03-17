package com.bbt.vendor.google;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;

public interface GoogleDriveService {

	static final String GOOGLE_SERVICE = "googleService";

	/** Application name. */
	public static final String APPLICATION_NAME = "bbt-web";

	/** Directory to store user credentials for this application. */
	public static final java.io.File DATA_STORE_DIR = new java.io.File(
			System.getProperty("user.home"), ".credentials"
					+ java.io.File.pathSeparator + "google-drive");

	/** Global instance of the JSON factory. */
	public static final JsonFactory JSON_FACTORY = JacksonFactory
			.getDefaultInstance();

	/**
	 * Global instance of the scopes required by this quickstart.
	 *
	 * If modifying these scopes, delete your previously saved credentials at
	 * ~/.credentials/drive-java-quickstart
	 */
	static final List<String> SCOPES = Arrays.asList(DriveScopes.DRIVE,
			DriveScopes.DRIVE_APPDATA, DriveScopes.DRIVE_FILE);

	void connect() throws Exception;

	File createFile(String sName, java.io.File sFile, String sMimeType,
			Map<String, String> sProperties) throws IOException;

	File createFile(String sParentID, String sName, java.io.File sFile,
			String sMimeType, Map<String, String> sProperties)
			throws IOException;

	File getFileByPath(String sPath) throws IOException;

	Map<String, String> getProperties(String sFileID) throws IOException;

	File createDirectory(String sName, Map<String, String> sProperties)
			throws IOException;

	File createDirectory(String sParentID, String sName,
			Map<String, String> sProperties) throws IOException;

	File createPath(String sPath) throws IOException;

	String getFolderId(String sPath) throws IOException;
}
