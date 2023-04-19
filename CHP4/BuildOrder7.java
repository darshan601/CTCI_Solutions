package CHP4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// Build Order: You are given a list of projects and a list of dependencies (which is a list of pairs of
// projects, where the second project is dependent on the first project). All of a project's dependencies
// must be built before the project is. Find a build order that will allow the projects to be built. If there
// is no valid build order, return an error.
// EXAMPLE
// Input:
// projects: a, b, c, d, e, f
// dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
// Output: f, e, a, b, d, c

public class BuildOrder7 {

    public static List<String> buildOrder(String[] nodes, String[][] dependencies) {

        Map<String, List<String>> graph = new HashMap<>();

        Map<String, Integer> inDegree = new HashMap<>();

        for (String node : nodes) {
            graph.put(node, new ArrayList<>());
            inDegree.put(node, 0);
        }

        for (String[] dependecy : dependencies) {
            String dependent = dependecy[0];
            String dependencyNode = dependecy[1];

            graph.get(dependent).add(dependencyNode);
            inDegree.put(dependencyNode, inDegree.get(dependencyNode) + 1);
        }

        Queue<String> queue = new LinkedList<>();

        for (String node : nodes) {

            if (inDegree.get(node) == 0) {
                queue.offer(node);
            }

        }

        List<String> buildOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            String node = queue.poll();

            buildOrder.add(node);
            System.out.println(graph);
            System.out.println(inDegree);
            System.out.println(buildOrder + "  Buildorder");
            System.out.println("queue" + queue);
            for (String next : graph.get(node)) {
                inDegree.put(next, inDegree.get(next) - 1);

                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }

        if (buildOrder.size() != nodes.length) {
            throw new RuntimeException("Error:Cycle detected");
        }

        return buildOrder;
    }

    public static void main(String[] args) {
        String[] projects = { "a", "b", "c", "d", "e", "f" };
        String[][] dependencies = { { "a", "d" }, { "f", "b" }, { "b", "d" }, { "f", "a" }, { "d", "c" } };
        List<String> buildOrder = buildOrder(projects, dependencies);
        System.out.println(buildOrder); // Output: [e, f, a, b, d, c]
    }

}
