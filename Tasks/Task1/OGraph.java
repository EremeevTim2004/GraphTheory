import java.util.*;
import java.io.*;

public class OGraph extends Graph
{
    public OGraph(String gName)
    {
        graphName = gName;
        topNum = 0;
        edgeNum = 0;
    }
    public OGraph(OGraph g) {}
    public OGraph(String gName, String fName) {}

    public void AddTop (String tName) {}
    public void AddEdge (String tName1, String tName2) {}

    public void RemoveTop (String tName) {}
    public void RemoveEdge (String tName1, String tName2) {}
}