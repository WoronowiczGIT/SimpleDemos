package compileAndLaunch;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    private static String path = "C:/Users/m1rage/IdeaProjects/SimpleDemos/ProcessAPI/src/main/java/compileAndLaunch/";
    private static String relativePath = "src/main/java/compileAndLaunch/";

    private static String compile = "javac -cp src " + relativePath + "Main2.java";
    private static String[] compiler = {"javac", relativePath + "Main2.java"};

    // tutaj spacja po path, jest bardzo istotna. Także -cp jest niezbędne
    private static String run = "java -cp " + relativePath + " Main2";
    private static String[] runner = {"java", "-cp", relativePath, "Main2"};

    private static Process process = null;

    public static void main(String[] args) throws IOException, InterruptedException {

        runTime();
            deleteClassFiles();
        pBuilder();
            deleteClassFiles();
        pBuilderDirectory();
            deleteClassFiles();
    }

    private static void runTime() throws IOException, InterruptedException {
            System.out.println("\n--- runtime ---");

        process = Runtime.getRuntime()
                .exec(compiler);
            System.out.println("compiled successful " + process.isAlive());
        process.waitFor();

        process = Runtime.getRuntime()
                .exec(runner);
            System.out.println("read successful " + process.isAlive() + "\n");

        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));
        output.lines().forEach(line -> System.out.println(line + "\n"));

        process.waitFor();
            System.out.println("ended successful " + process.exitValue());
    }

    private static void pBuilder() throws IOException, InterruptedException {
            System.out.println("\n--- pBuilder ---");

        ProcessBuilder pb = new ProcessBuilder(compiler);

        process = pb.start();
            System.out.println("compiled successful " + process.isAlive());
        process.waitFor();

        pb = new ProcessBuilder(runner);
        process = pb.start();
            System.out.println("read successful " + process.isAlive() + "\n");

        BufferedReader output = new BufferedReader(new InputStreamReader(process.getInputStream()));

        output.lines().forEach(line -> System.out.println(line));
        process.waitFor();
            System.out.println("ended successful " + process.exitValue());
    }

    private static void pBuilderDirectory() throws IOException, InterruptedException {
            System.out.println("\n--- pBuilder/directory/command ---");

        File dir = new File(path.substring(0,path.length()-1));

        ProcessBuilder pb = new ProcessBuilder().command(Arrays.asList("javac","Main2.java")).directory(dir);
        Process proc = pb.start();
            System.out.println("compiled successful " + proc.isAlive());
        proc.waitFor();

        proc = pb.command(Arrays.asList("java","Main2")).directory(dir).start();
            System.out.println("read successful " + proc.isAlive());

        BufferedReader output = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        output.lines().forEach(line -> System.out.println(line));
        proc.waitFor();
    }


    private static void deleteClassFiles() {
        File classFile = new File(path + "Main2.class");
        while (classFile.exists()) {
            classFile.delete();
        }

        File main = new File(path + "Main.class");
        while (main.exists()) {
            main.delete();
        }
    }

}
