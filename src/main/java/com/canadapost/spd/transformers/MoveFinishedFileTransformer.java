package com.canadapost.spd.transformers;

import java.io.File;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

/**
 * Java transformer used to move a file to a new location.
 * 
 * When the OOB Mule File connector is used, this Transformer is not required.
 * But in cases where Java code is used to manually read files, this connector
 * is needed to move the file after processing.
 * 
 * @author David Hunter (Deloitte)
 *
 */
public class MoveFinishedFileTransformer extends AbstractMessageTransformer {
	/**
	 * The directory to which the file should be moved
	 */
	private String targetDirectory;
	/**
	 * The Mule flowVar that contains the name of the current file (the file to
	 * be moved)
	 */
	private String currentFileVar;

	/**
	 * Called by MuleSoft at runtime. Simply uses normal Java functionality to
	 * "rename" (i.e. move) the file.
	 * 
	 * @param message
	 *            The Mule message object
	 * @param outputEncoding
	 *            Not used
	 * 
	 * @return null -- no response
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		String currentFilePath = message.getProperty(this.currentFileVar, PropertyScope.INVOCATION);

		File currentFile = new File(currentFilePath);
		currentFile.renameTo(new File(this.targetDirectory + File.separator + currentFile.getName()));
		return null;
	}

	public String getTargetDirectory() {
		return targetDirectory;
	}

	public void setTargetDirectory(String targetDirectory) {
		this.targetDirectory = targetDirectory;
	}

	public String getCurrentFileVar() {
		return currentFileVar;
	}

	public void setCurrentFileVar(String currentFileVar) {
		this.currentFileVar = currentFileVar;
	}

}
