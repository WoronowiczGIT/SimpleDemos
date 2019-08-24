package SDA.designPatterns.flyweight.flyweightTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeFactory {

    private Map<String, Tree> cachedTrees = new HashMap<>();

    public Tree getTree(String type) throws InterruptedException {

        Tree tree = cachedTrees.get(type);
        if (tree == null) {
            switch (type) {
                case "leaf": {
                    tree = new LeafTree();
                    break;
                }
                case "needle": {
                    tree = new ConiferTree();
                    break;
                }
                case "bs": {
                    tree = new BukszpanTree();
                    break;
                }
                default: {
                    System.out.println("incorrect type");
                    return null;
                }
            }
            cachedTrees.put(type,tree);
            return tree;

        } else {
            return tree;
        }


    }

    public static void main(String[] args) throws InterruptedException {
        TreeFactory factory = new TreeFactory();
        List<Tree> treeList = new ArrayList<>();
        treeList.add(factory.getTree("needle"));
        treeList.add(factory.getTree("leaf"));
        treeList.add(factory.getTree("needle"));
        treeList.add(factory.getTree("bs"));

        Thread.sleep(1500);
        System.out.println("display elements");
        for (Tree t : treeList) {
            t.showTree();
        }

    }
}
