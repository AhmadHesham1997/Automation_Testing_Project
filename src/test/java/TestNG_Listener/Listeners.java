package TestNG_Listener;

import org.testng.IExecutionListener;

public class Listeners implements IExecutionListener {
    private final String DeleteJsoncommand = "cmd /c cd target/allure-results && del *.json";

    private final String GenerateReportCommand = "cmd /c C:\\Users\\ahesh\\.jdks\\openjdk-25.0.1\\bin\\java.exe -classpath \"allure\\allure-2.36.0\\lib\\*;allure\\allure-2.36.0\\lib\\config\" io.qameta.allure.CommandLine generate target/allure-results -o target/allure-report --clean";

    public void onExecutionStart() {
        System.out.println("Execution started. Deleting old Allure results...");
       int result = CMDRunner.executeCMD(DeleteJsoncommand);
        if (result == 0) {
            System.out.println("Old Allure results deleted successfully.");
        } else {
            System.out.println("Failed to delete old Allure results. Please check the command and try again.");
        }
    }

    public void onExecutionFinish() {
        System.out.println("Execution finished. Generating Allure report...");
       int result = CMDRunner.executeCMD(GenerateReportCommand);
       if (result == 0) {
           System.out.println("Allure report generated successfully.");
       } else {
           System.out.println("Failed to generate Allure report. Please check the command and try again.");
       }
    }
}
