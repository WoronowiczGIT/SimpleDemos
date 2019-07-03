package SDA.dataStructure.myBrowser;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Browser {
   private List<Page> history = new LinkedList<>();
   private Network network;
   private int currentPage = -1;
   public void connect(Network network){
       this.network = network;
   }

   public String visitPage(String address){
       Page myPage = network.getPage(address);
       history.add(myPage);
       currentPage++;
       return myPage.getContent();
   }

   public String visitNext(){
       if(history.size() > currentPage+2)
           return history
                   .get(++currentPage)
                   .getContent();
       return "page not found";
   }
   public String visitPrev(){
       if(history.size() > 1 && currentPage > 0)
           return history
                   .get(--currentPage)
                   .getContent();
       return "page not found";
   }

}
class Network {
private Set<Page> webPages = new HashSet<>();
public void addPage(Page page){
    webPages.add(page);
}
public Page getPage(String address){
    for (Page p: webPages) {
        if(p.getAddress().equals(address)){
            return p;
        }
    }
    throw new IllegalArgumentException("page not found");
}
}
class Page{
    private String content;
    private String address;

    Page(String address, String content){
        this.address = address;
        this.content = content;
    }
    public String getContent() { return content; }
    public String getAddress() { return address; }
    public void setContent(String content) { this.content = content; }
}