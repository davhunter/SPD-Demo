package com.canadapost.spd.transformers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.mule.api.MuleMessage;
import org.mule.api.transformer.TransformerException;
import org.mule.api.transport.PropertyScope;
import org.mule.transformer.AbstractMessageTransformer;

/**
 * Java Transformer used to load a file from the file system. The file is loaded
 * into the payload as an <code>ArrayList</code> of strings, representing each
 * line (record) in the file.
 * 
 * The only reason custom Java code is required is that the MuleSoft File
 * connector can only be used for active monitoring of a file/location. This
 * transformer is used for cases where we want to manually read the file at a
 * specific point in processing -- that is, we want to insert dependencies in
 * file processing.
 * 
 * @author David Hunter (Deloitte)
 */
public class LoadFileTransformer extends AbstractMessageTransformer {
	/**
	 * The name of the flowVar in MuleSoft that contains the file name.
	 */
	private String fileNameProperty;

	/**
	 * Called by MuleSoft at runtime to load a file. Each line is written as a
	 * string into an <code>ArrayList</code>.
	 * 
	 * @param message
	 *            The MuleSoft message
	 * @param outputEncoding
	 *            Not used
	 * 
	 * @return An <code>ArrayList</code> of lines/records from the fie.
	 */
	@Override
	public Object transformMessage(MuleMessage message, String outputEncoding) throws TransformerException {
		String fileName = message.getProperty(this.fileNameProperty, PropertyScope.INVOCATION);
		ArrayList<String> lines = new ArrayList<String>();

		try {
			FileReader inputFile;
			inputFile = new FileReader(fileName);
			BufferedReader br = new BufferedReader(inputFile);
			String currentLine;

			while ((currentLine = br.readLine()) != null) {
				lines.add(currentLine);
			}

			br.close();
			inputFile.close();
		} catch (FileNotFoundException e) {
			throw new TransformerException(this, e);
		} catch (IOException e) {
			throw new TransformerException(this, e);
		}

		return lines;
	}

	public String getFileNameProperty() {
		return fileNameProperty;
	}

	public void setFileNameProperty(String fileNameProperty) {
		this.fileNameProperty = fileNameProperty;
	}

}
