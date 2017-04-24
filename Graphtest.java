class Graphtest {

    public static final int GRAPH_SIZE = 15;
    public static final double EDGE_PERCENT = 0.3;

    public static int count = 0;

    public static void DFS(Graph G, int Parent[], int startVertex, boolean Visited[]) {
        if (Visited[startVertex] == true) {
            return;
        }
        else {
            Visited[startVertex] = true;
            Edge edge = G.edges[startVertex];
            while (edge != null) {
                Parent[edge.neighbor] = startVertex;
                DFS(G, Parent, edge.neighbor, Visited);
                edge = edge.next;
            }
        }
    }


    public static void PrintPath(int Parent[], int endvertex) {
        if (Parent[endvertex] == -1) {
            return;
        }
        else {
            count++;
            PrintPath(Parent, Parent[endvertex]);
            System.out.print(endvertex + " ");
            count--;
            if (count == 0) {
                System.out.println();
            }
        }

    }

//    public static void PrintPath(int Parent[], int endvertex) {
//        int temp;
//        if (Parent[endvertex] == -1) {
//            if (endvertex != 0) {
//                temp = endvertex;
//            }
//            return;
//        }
//        else {
//            temp = -1;
//            if (Parent[endvertex] == -1) {
//                System.out.println(endvertex + " ");
//            }
//            else {
//                PrintPath(Parent, Parent[endvertex]);
//                if (temp == -1) {
//                    System.out.print(endvertex + " ");
//                }
//            }
//        }
//    }

    public static void BFS(Graph G, int Parent[], int startVertex, boolean Visited[]) {
        ArrayQueue queue = new ArrayQueue(Parent.length);
        queue.enqueue(new Integer(startVertex));
        Visited[startVertex] = true;
        while (!queue.empty()) {
            startVertex = queue.dequeue();
            Edge node = G.edges[startVertex];
            while (node != null) {
                if (Visited[node.neighbor] == false) {
                    Visited[node.neighbor] = true;
                    Parent[node.neighbor] = startVertex;
                    queue.enqueue(new Integer(node.neighbor));
                }
                node = node.next;
            }
        }
    }

    public static void main(String args[])
    {
        boolean Visited[] = new boolean[GRAPH_SIZE];
        int Parent[] = new int[GRAPH_SIZE];
        Graph G = new Graph(GRAPH_SIZE);
        int i;
        for (i=0; i<G.numVertex;i++)
        {
            Visited[i] = false;
            Parent[i] = -1;
        }
        G.randomize(EDGE_PERCENT);
        G.print();
        BFS(G,Parent,0,Visited);
        System.out.println("----------------");
        System.out.println("BFS:");
        System.out.println("----------------");
        for (i=0; i<G.numVertex;i++)
        {
            System.out.println("Path from 0 to " + i + ":");
            PrintPath(Parent,i);
        }
        for (i=0; i<G.numVertex;i++)
        {
            Visited[i] = false;
            Parent[i] = -1;
        }
        DFS(G,Parent,0,Visited);
        System.out.println("----------------");
        System.out.println("DFS:");
        System.out.println("----------------");
        for (i=0; i<G.numVertex;i++)
        {
            System.out.println("Path from 0 to " + i + ":");
            PrintPath(Parent,i);
        }
    }
}