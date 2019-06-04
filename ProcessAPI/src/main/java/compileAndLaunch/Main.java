package compileAndLaunch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String path = "C:/Users/m1rage/IdeaProjects/SimpleDemos/ProcessAPI/src/main/java/compileAndLaunch/";
    private static String relativePath = "src/main/java/compileAndLaunch/";

    private static String compile = "javac -cp src "+ relativePath +"Main2.java";
    private static String[] compiler = {"javac",relativePath+"Main2.java"};

    // tutaj spacja po path, jest bardzo istotna.
    private static String run = "java -cp "+relativePath+" Main2";
    private static String[] runner = {"java","-cp",relativePath,"Main2"};


    public static void main(String[] args) throws IOException, InterruptedException {
    Process process = null;
        runTime(process);
            deleteClassFiles();
        pBuilder(process);
            deleteClassFiles();
    }
    private static void runTime(Process process) throws IOException, InterruptedException {
        process = Runtime.getRuntime()
                .exec(compiler);
        process.waitFor();

        process = Runtime.getRuntime()
                .exec(runner);

        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        System.out.println(output.readLine());

        process.waitFor();
    }
    private static void pBuilder(Process process) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder(compiler);

        process = pb.start();
        process.waitFor();

        pb = new ProcessBuilder(runner);
        process = pb.start();

        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        System.out.println(output.readLine());
        process.waitFor();
    }

    private static void deleteClassFiles(){
        File classFile = new File(path+"Main2.class");
        while (classFile.exists()){ classFile.delete();}
    }

}
