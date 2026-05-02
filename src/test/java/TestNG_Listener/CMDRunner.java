package TestNG_Listener;
//The purpose of this class to automatically generate allure reports and delete old reports before generating new ones.
// This class can be executed as a standalone Java application or integrated into a build process to ensure
// that the Allure reports are always up-to-date and free of old data.
public class CMDRunner {
    public static int executeCMD(String CMD)
    {
        try{
            //This step to run cmd commands
            Process process = Runtime.getRuntime().exec(CMD);
            //wait till cmd finish
            int exitCode = process.waitFor();
            //if exist code is zero means run of command is successful else any other number means failed
            if (exitCode == 0) {
                System.out.println("Command executed successfully: " + CMD);
                return exitCode;
            } else {
                System.err.println("Command execution failed with exit code " + exitCode + ": " + CMD);
                return exitCode;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return 0;
    }

}
