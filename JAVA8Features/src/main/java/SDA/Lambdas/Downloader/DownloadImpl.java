package SDA.Lambdas.Downloader;

public class DownloadImpl implements Download {
    @Override
    public void download(String download) {
        System.out.println("file: "+ download+" downlaoded by regular interface");
    }
}
