import java.util.*;

public class MGraph extends Graph
{
    public String graphName;
    public List<List<Boolean>> adjacencyList;

    public MGraph(String gName) {}
    public MGraph(Graph g) {}
    public MGraph(String gName, String fName) {}

    public void AddTop (String tName) {}
    public void AddEdge (String tName1, String tName2) {}

    public void RemoveTop (String tName) {}
    public void RemoveEdge (String tName1, String tName2) {}
}
