package com.gestionaleAlberghi.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MyFileWriter {
	String path;

	public MyFileWriter(String path) {
		this.path = path;
	}

	public boolean write(String fileName, String data) {
		OutputStream os = null;
		boolean result = false;
		try {
			os = new FileOutputStream(new File(this.path + "\\" + fileName));
			os.write(data.getBytes(), 0, data.length());
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
