package com.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOut {

	private final String fileName;
	private final FileWriter fileWriter;

	public FileOut(final File directory, final String fileName) throws IOException {
		this(new File(directory, fileName));
	}

	public FileOut(final File file) throws IOException {
		System.out.println("open :" + file.getAbsolutePath());
		createParentDirectory(file);
		file.createNewFile();
		fileWriter = new FileWriter(file);
		fileName = file.getAbsolutePath();
	}

	private static void createParentDirectory(final File file) {
		File directory = file.getParentFile();
		directory.mkdirs();
	}

	public void write(final String str) throws IOException {
		try {
			fileWriter.write(str);
		} catch (IOException ioe) {
			close();
			throw new IOException("SourceReader(): File Not Read: " + ioe);
		}
	}

	public void writeln(final String str) throws IOException {
		try {
			fileWriter.write(str + "\n");
		} catch (IOException ioe) {
			close();
			throw new IOException("SourceReader(): File Not Read: " + ioe);
		}
	}

	public void close() {
		System.out.println("close :" + fileName);
		try {
			if (fileWriter != null) {
				fileWriter.flush();
				fileWriter.close();
			}
		} catch (IOException ioe) {
			// nothing
		}
	}
}
