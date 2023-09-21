import java.util.*;

public class NOGraph extends Graph
{
    public String graphName;
    public List<List<Boolean>> adjacencyList;

    public NOGraph(String gName) {}
    public NOGraph(Graph g) {}
    public NOGraph(String gName, String fName) {}

    public void AddTop (String tName) {}
    public void AddEdge (String tName1, String tName2) {}

    public void RemoveTop (String tName) {}
    public void RemoveEdge (String tName1, String tName2) {}
}
