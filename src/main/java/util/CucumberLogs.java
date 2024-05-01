package util;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class CucumberLogs {
	
	public static void printLog(String message) {
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, message);
		
	}

}
