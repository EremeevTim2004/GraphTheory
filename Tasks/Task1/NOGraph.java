import java.util.*;
import java.io.*;

public class NOGraph extends Graph
{
    public NOGraph(String gName)
    {
        graphName = gName;
    }
    public NOGraph(NOGraph g) {}
    public NOGraph(String gName, String fName) {}

    public void AddTop (String tName) {}
    public void AddEdge (String tName1, String tName2) {}

    public void RemoveTop (String tName) {}
    public void RemoveEdge (String tName1, String tName2) {}
}
