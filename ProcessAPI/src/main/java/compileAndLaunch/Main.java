package compileAndLaunch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Hello!");
        String relativePath = "src/main/java/compileAndLaunch/";
        String path = "C:/Users/m1rage/IdeaProjects/SimpleDemos/ProcessAPI/src/main/java/compileAndLaunch/";

        String compile = "javac -cp src "+ relativePath +"Main2.java";
        // tutaj spacja po path, jest bardzo istitna i nie wiem czemu.
        String run = "java -cp "+relativePath+" Main2";

        Process process;

        process = Runtime.getRuntime()
                .exec(compile);
        process.waitFor();

        process = Runtime.getRuntime()
                .exec(run);

        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        System.out.println(output.readLine());

        process.waitFor();
        System.out.println("process is alive - "+ process.isAlive());
        process.destroy();

        File classFile = new File(path+"Main2.class");
        while (classFile.exists()){ classFile.delete();}
    }

}
