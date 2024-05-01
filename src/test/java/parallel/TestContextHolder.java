package parallel;

import com.aventstack.extentreports.ExtentTest;

public class TestContextHolder {
    private static final ThreadLocal<ExtentTest> currentTest = new ThreadLocal<>();
    private static final ThreadLocal<String> fileToAttach = new ThreadLocal<>();

    public static ExtentTest getCurrentTest() {
        return currentTest.get();
    }

    public static void setCurrentTest(ExtentTest test) {
        currentTest.set(test);
    }

    public static void removeCurrentTest() {
        currentTest.remove();
    }
    
    public static String getfileToAttach() {
        return fileToAttach.get();
    }

    public static void setfileToAttach(String fileName) {
    	fileToAttach.set(fileName);
    }

    public static void removeFileToAttach() {
    	fileToAttach.remove();
    }
}
