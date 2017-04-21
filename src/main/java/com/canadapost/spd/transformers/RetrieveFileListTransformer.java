package com.canadapost.spd.transformers;

import java.io.File;
import java.util.ArrayList;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.transformer.AbstractMessageTransformer;

/**
 * Mule transformer which retrieves a list of all files from the file system,
 * and populates the payload with a list of their fully qualified names.
 * 
 * @author David Hunter (Deloitte)
 */
public class RetrieveFileListTransformer extends AbstractMessageTransformer {
	/**
	 * The directory in which the code should look for matching files
	 */
	private String pathToScan;
	/**
	 * The regular expression to match against -- could result in multiple
	 * matching files
	 */
	private String fileRegEx;

	/**
	 * Called by MuleSoft to perform the transformation. The
	 * <code>pathToScan</code> and <code>fileRegEx</code> for finding matching
	 * files are passed by the flow. Simply populates the payload with an
	 * <code>ArrayList</code> of filenames that match.
	 * 
	 * @param message
	 *            The MuleSoft message object
	 * @param outputEncoding
	 *            Not used
	 * 
	 * @return <code>ArrayList</code> of files that match the regex, in the
	 *         location.
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		File folderToScan = new File(this.pathToScan);
		ArrayList<String> fileList = new ArrayList<String>();

		File[] listOfFiles = folderToScan.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				String currentFileName = listOfFiles[i].getName();
				if (currentFileName.matches(this.fileRegEx)) {
					fileList.add(listOfFiles[i].getAbsolutePath());
				}
			}
		}

		return fileList;
	}

	public String getPathToScan() {
		return pathToScan;
	}

	public void setPathToScan(String pathToScan) {
		this.pathToScan = pathToScan;
	}

	public String getFileRegEx() {
		return fileRegEx;
	}

	public void setFileRegEx(String fileRegEx) {
		this.fileRegEx = fileRegEx;
	}

}
