package com.auto.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//Screenshot, alerts,frames, windows,Sync issue, javascript executor

public class Helper {

	public static String captureScreensshot(WebDriver driver) {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String path =System.getProperty("user.dir")+"/Screenshots/ssshot_"+getCurrentTime()+".png";

		try {
			FileHandler.copy(src, new File(path));
			System.out.println("Screenshot Captured");
		} catch (IOException e) {

			System.out.println("Unable to capture Screenshot" + e.getMessage());

			e.printStackTrace();
		}
		
		return path;

	}

	public static String getCurrentTime() {

		DateFormat df = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		Date dt = new Date();
		return df.format(dt);
	}

}
