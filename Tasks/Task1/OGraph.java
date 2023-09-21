import java.util.*;

public class OGraph extends Graph
{
    public String graphName;
    public List<List<Boolean>> adjacencyList;

    public OGraph(String gName) {}
    public OGraph(Graph g) {}
    public OGraph(String gName, String fName) {}

    public void AddTop (String tName) {}
    public void AddEdge (String tName1, String tName2) {}

    public void RemoveTop (String tName) {}
    public void RemoveEdge (String tName1, String tName2) {}
}