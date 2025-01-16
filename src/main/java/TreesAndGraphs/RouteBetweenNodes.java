package TreesAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a directed graph and two nodes (S and E), this function determines
 * if there is a route from S to E
 */
public class RouteBetweenNodes {
    /*
     * Time complexity = O(n) with n = number of nodes in the graph
     * Space complexity = O(n)
     *
     * if s == null or e == null or s is visited, return false
     * if s == e return true
     * set s to visited     *
     * if s has children
     *      for each child of s
     *          if(dfs(graph, child, e))
     *              return true
     *
     * return false
     */
    public static boolean dfs(Node s, Node e){
        if(s == null || e == null || s.isVisited())
            return false;

        if(s == e)
            return true;

        s.setVisited(true);
        if(s.getChildren() != null) {
            for (Node child : s.getChildren()) {
                if (dfs(child, e))
                    return true;
            }
        }

        return false;
    }

    /*
    Time complexity = O(n) with n = number of nodes in the graph
    Space complexity = O(n)

    create a queue and push s to queue

    while there are nodes in the queue
        dequeue
        if node = e
            return true
        set to visited
        else
            if s has children
                for every child of s
                    if child is not visited
                        add to queue

    return false
     */
    public static boolean bfs(Node s, Node e){
        if(s == null || e == null)
            return false;

        Queue<Node> queue = new LinkedList<>();
        queue.add(s);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            if(current == e)
                return true;
            current.setVisited(true);

            if(current.getChildren() != null){
                for(Node child: current.getChildren()){
                    if(!child.isVisited())
                        queue.add(child);
                }
            }
        }

        return false;
    }
}
