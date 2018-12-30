package com.github.smk7758.OpenCV_CameraCalibration;

public class FileIO {
	public static String getFilePath(String path) {
		return getFilePath(path, "");
	}

	public static String getFilePath(String path, String add_text) {
		return getFilePath(path, add_text, path.substring(getLastDotIndex(path), path.length()));
	}

	public static String getFilePath(String path, String add_text, String extention) {
		if (add_text.length() > 0) add_text = "_" + add_text;
		return path.substring(0, getLastDotIndex(path)) + add_text + "_" + System.currentTimeMillis() + "." + extention;
	}

	public static int getLastDotIndex(String path) {
		int last_index = 0;
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == '.') last_index = i;
		}
		return last_index;
	}
}
