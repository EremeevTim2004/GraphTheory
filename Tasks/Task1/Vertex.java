import java.util.*;

public class Vertex
{
    public String name;
    public List<String> edges;

    public Vertex(String name, List<String> edges)
    {
        this.name = name;
        this.edges = new ArrayList<>(edges);
    }
}
