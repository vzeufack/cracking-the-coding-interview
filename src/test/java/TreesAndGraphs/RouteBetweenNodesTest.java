package TreesAndGraphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteBetweenNodesTest {
    Node s1, e1, s2, e2, s3, e3, s4, e4, a4, b4, s5, e5, a5, b5;


    @BeforeEach
    void setUp() {
        s1 = new Node("s1");
        e1 = s1;

        e2 = new Node("e2");
        s2 = new Node("s2", new Node[]{e2});

        s3 = new Node("s3");
        e3 = new Node("e3", new Node[]{s3});

        e4 = new Node("e4");
        a4 = new Node("a4", new Node[]{e4});
        b4 = new Node("b4");
        s4 = new Node("s4", new Node[]{a4, b4});

        b5 = new Node("b5");
        a5 = new Node("a5", new Node[]{b5});
        s5 = new Node("s5", new Node[]{a5});
        b5.setChildren(new Node[]{s5});
        e5 = new Node("e5");
    }

    @Test
    void dfs() {
        assertTrue(RouteBetweenNodes.dfs(s1, e1));
        assertTrue(RouteBetweenNodes.dfs(s2, e2));
        assertTrue(RouteBetweenNodes.dfs(s4, e4));
        assertFalse(RouteBetweenNodes.dfs(s3, e3));
        assertFalse(RouteBetweenNodes.dfs(s5, e5));
    }

    @Test
    void bfs() {
        assertTrue(RouteBetweenNodes.bfs(s1, e1));
        assertTrue(RouteBetweenNodes.bfs(s2, e2));
        assertFalse(RouteBetweenNodes.bfs(s3, e3));
        assertTrue(RouteBetweenNodes.bfs(s4, e4));
        assertFalse(RouteBetweenNodes.bfs(s5, e5));
    }
}