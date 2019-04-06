package SDA.Lambdas.Downloader;

public class Main {

    public static void main(String[] args) {
        String fileName = " StarCraft";

        //Interface implementation
        Download dl = new DownloadImpl();
        dl.download(fileName);

        //Embeded interface
        Download dl2 = new Download() {
            @Override
            public void download(String download) {
                System.out.println("file: "+ download+" downlaoded via embeded interface");
            }
        };
        dl2.download(fileName);

        // Anonymous interface
        download(new Download() {
            @Override
            public void download(String download) {
                System.out.println("file: "+ download+" downlaoded anonymously");
            }
        });

        // Lambdas
        download((String download)-> System.out.println("file: "+ download+" downlaoded by lambdas"));



    }
    static void download(Download dl){}
}
