package TreesAndGraphs;

public class Graph {
    public Node[] nodes;

    public Graph(Node[] nodes) {
        this.nodes = nodes;
    }

    public boolean equals(Graph g){
        if(this.nodes.length != g.nodes.length)
            return false;

        for(int i = 0; i < nodes.length; i++){
            if(!nodes[i].equals(g.nodes[i]))
                return false;
        }

        return true;
    }
}

class Node {
    private String name;
    private boolean visited;
    private Node[] children;

    public Node(String name) {
        this.name = name;
        this.visited = false;
    }
    public Node(String name, Node[] children) {
        this.name = name;
        this.children = children;
        this.visited = false;
    }

    public void setChildren(Node[] children){
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Node[] getChildren() {
        return children;
    }

    public boolean equals(Node node){
        return this.name.equals(node.name);
    }
}

