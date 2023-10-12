import scala.collection.mutable.{Map, Set}
import scala.io.Source
import scala.util.{Try, Success, Failure}
import java.io.{File, PrintWriter}

class Graph {
  private var adjacencyList: Map[String, Set[String]] = Map()

  def addVertex(vertex: String): Unit = {
    if (!adjacencyList.contains(vertex))
      adjacencyList(vertex) = Set()
  }

  def addEdge(source: String, destination: String): Unit = {
    addVertex(source)
    addVertex(destination)
    adjacencyList(source) += destination
    adjacencyList(destination) += source
  }

  def removeVertex(vertex: String): Unit = {
    if (adjacencyList.contains(vertex)) {
      val neighbors = adjacencyList(vertex)
      for (neighbor <- neighbors) {
        adjacencyList(neighbor) -= vertex
      }
      adjacencyList -= vertex
    }
  }

  def removeEdge(source: String, destination: String): Unit = {
    adjacencyList(source) -= destination
    adjacencyList(destination) -= source
  }

  def saveToFile(filename: String): Unit = {
    val writer = new PrintWriter(new File(filename))
    for ((vertex, neighbors) <- adjacencyList) {
      val neighborsList = neighbors.mkString(", ")
      writer.println(s"$vertex -> $neighborsList")
    }
    writer.close()
  }

  def display(): Unit = {
    for ((vertex, neighbors) <- adjacencyList) {
      val neighborsList = neighbors.mkString(", ")
      println(s"$vertex -> $neighborsList")
    }
  }

  def clearAdjacencyList(): Unit = {
    adjacencyList = Map()
  }
}

object GraphApp {
  def main(args: Array[String]): Unit = {
    var graphs: List[Graph] = List()
    var currentGraph: Option[Graph] = None

    def printMenu(): Unit = {
      println(
        "Menu:\n" +
        "1. Create a graph\n" +
        "2. Delete a graph\n" +
        "3. Create a graph from a configuration file\n" +
        "4. Configure a graph\n" +
        "5. Display the adjacency list\n" +
        "6. Save the configuration to a file\n" +
        "7. Exit"
      )
    }

    def printGraphList(): Unit = {
      println("List of graphs:")
      for ((graph, i) <- graphs.zipWithIndex) {
        println(s"$i: ${if (Some(graph) == currentGraph) "*" else " "}Graph")
      }
    }

    var exit = false
    while (!exit) {
      printMenu()
      print("Enter your choice: ")
      val choice = scala.io.StdIn.readInt()
      choice match {
        case 1 => // Create a graph
          graphs = new Graph() :: graphs
          currentGraph = Some(graphs.head)
          println("Graph created.")
        case 2 => // Delete a graph
          currentGraph = None
          if (graphs.nonEmpty) {
            graphs = graphs.tail
            println("Graph deleted.")
          } else {
            println("No graphs to delete.")
          }
        case 3 => // Create a graph from a configuration file
          println("Enter the filename for the configuration file: ")
          val filename = scala.io.StdIn.readLine()
          val newGraph = new Graph()
          Try {
            for (line <- Source.fromFile(filename).getLines()) {
              val parts = line.split("->|\\-")
              if (parts.length >= 1) {
                val vertex = parts(0).trim()
                newGraph.addVertex(vertex)
                for (i <- 1 until parts.length) {
                  val neighbor = parts(i).trim()
                  newGraph.addEdge(vertex, neighbor)
                }
              }
            }
          } match {
            case Success(_) =>
              graphs = newGraph :: graphs
              currentGraph = Some(graphs.head)
              println("Graph created from the configuration file.")
            case Failure(ex) =>
              println(s"Error reading the configuration file: ${ex.getMessage}")
          }
        case 4 => // Configure a graph
          if (graphs.nonEmpty) {
            println("Enter the index of the graph to configure (0 to ${graphs.length - 1}): ")
            val index = scala.io.StdIn.readInt()
            if (index >= 0 && index < graphs.length) {
              currentGraph = Some(graphs(index))
              configureGraph(currentGraph.get)
            } else {
              println("Invalid index.")
            }
          } else {
            println("No graphs to configure.")
          }
        case 5 => // Display the adjacency list
          currentGraph.foreach { graph =>
            println("Adjacency list:")
            graph.display()
          }
        case 6 => // Save the configuration to a file
          currentGraph.foreach { graph =>
            println("Enter the filename to save the configuration: ")
            val filename = scala.io.StdIn.readLine()
            graph.saveToFile(filename)
            println(s"Graph configuration saved to $filename.")
          }
        case 7 => // Exit
          exit = true
        case _ =>
          println("Invalid choice. Please select a valid option.")
      }
    }
  }

  def configureGraph(graph: Graph): Unit = {
    var exit = false
    while (!exit) {
      println(
        "Graph Configuration Menu:\n" +
        "1. Add a vertex\n" +
        "2. Remove a vertex\n" +
        "3. Add an edge\n" +
        "4. Remove an edge\n" +
        "5. Copy graph to a configuration file\n" +
        "6. Display adjacency list\n" +
        "7. Clear adjacency list\n" +
        "8. Exit"
      )
      print("Enter your choice: ")
      val choice = scala.io.StdIn.readInt()
      choice match {
        case 1 => // Add a vertex
          println("Enter the vertex name: ")
          val vertex = scala.io.StdIn.readLine()
          graph.addVertex(vertex)
          println(s"Vertex $vertex added.")
        case 2 => // Remove a vertex
          println("Enter the vertex name to remove: ")
          val vertex = scala.io.StdIn.readLine()
          graph.removeVertex(vertex)
          println(s"Vertex $vertex removed.")
        case 3 => // Add an edge
          println("Enter the source vertex: ")
          val source = scala.io.StdIn.readLine()
          println("Enter the destination vertex: ")
          val destination = scala.io.StdIn.readLine()
          graph.addEdge(source, destination)
          println(s"Edge from $source to $destination added.")
        case 4 => // Remove an edge
          println("Enter the source vertex: ")
          val source = scala.io.StdIn.readLine()
          println("Enter the destination vertex: ")
          val destination = scala.io.StdIn.readLine()
          graph.removeEdge(source, destination)
          println(s"Edge from $source to $destination removed.")
        case 5 => // Copy graph to a configuration file
          println("Enter the filename to save the configuration: ")
          val filename = scala.io.StdIn.readLine()
          graph.saveToFile(filename)
          println(s"Graph configuration saved to $filename.")
        case 6 => // Display adjacency list
          println("Adjacency list:")
          graph.display()
        case 7 => // Clear adjacency list
          graph.clearAdjacencyList()
          println("Adjacency list cleared.")
        case 8 => // Exit
          exit = true
        case _ =>
          println("Invalid choice. Please select a valid option.")
      }
    }
  }
}
