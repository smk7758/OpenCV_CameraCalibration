package com.github.smk7758.OpenCV_CameraCalibration;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.opencv.calib3d.Calib3d;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class Main {
	final String pic_path = "F:\\users\\smk7758\\Desktop\\samples_CameraCaliblation\\left01.jpg";

	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {
		new Main().processer();
	}

	public void processer() {
		if (!Files.exists(Paths.get(pic_path))) {
			System.err.println("The picture file does not exist!");
			return;
		}

		Mat inputMat = Imgcodecs.imread(pic_path);
		Mat mat = inputMat.clone();

		Imgproc.cvtColor(mat, mat, Imgproc.COLOR_BGR2GRAY);

		final Size patternSize = new Size(6, 9);
		MatOfPoint2f corners = new MatOfPoint2f();
		if (Calib3d.findChessboardCorners(mat, patternSize, corners)) {
			Calib3d.drawChessboardCorners(inputMat, patternSize, corners, true);
		} else {
			System.err.println("Cannot find Chessboard Corners.");
		}

		Imgcodecs.imwrite(FileIO.getFilePath(pic_path, "after"), inputMat);
	}
}
