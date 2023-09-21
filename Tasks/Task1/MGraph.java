import java.util.*;
import java.io.*;

public class MGraph extends Graph
{
    public MGraph(String gName)
    {
        graphName = gName;
    }
    public MGraph(MGraph g) {}
    public MGraph(String gName, String fName) {}

    public void AddTop (String tName) {}
    public void AddEdge (String tName1, String tName2) {}

    public void RemoveTop (String tName) {}
    public void RemoveEdge (String tName1, String tName2) {}
}
