package com.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileIn {

	private final String fileName;
	private final BufferedReader bufferedReader;

	public FileIn(final File directory, final String fileName) throws IOException {
		this(new File(directory, fileName));
	}

	public FileIn(final File file) throws IOException {
		System.out.println("open :" + file.getAbsolutePath());
		bufferedReader = new BufferedReader(new FileReader(file));
		this.fileName = file.getAbsolutePath();
	}

	public String read() throws IOException {
		try {
			return bufferedReader.readLine();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			close();
			throw ioe;
		}
	}

	public void close() {
		System.out.println("close :" + fileName);
		try {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		} catch (IOException ioe) {
			// nothing
		}
	}
}
