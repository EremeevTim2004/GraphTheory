import scala.collection.mutable.{Map, Set}
import java.io.{File, PrintWriter}
import scala.io.Source

class Graph[T] {
  private val adjacencyList: Map[T, Set[T]] = Map()

  def addVertex(vertex: T): Unit = {
    if (!adjacencyList.contains(vertex)) {
      adjacencyList(vertex) = Set()
    }
  }

  def addEdge(from: T, to: T): Unit = {
    addVertex(from)
    addVertex(to)
    adjacencyList(from) += to
  }

  def removeVertex(vertex: T): Unit = {
    if (adjacencyList.contains(vertex)) {
      adjacencyList.remove(vertex)
      adjacencyList.foreach { case (_, neighbors) => neighbors -= vertex }
    }
  }

  def removeEdge(from: T, to: T): Unit = {
    if (adjacencyList.contains(from)) {
      adjacencyList(from) -= to
    }
  }

  def printToFile(filename: String): Unit = {
    val writer = new PrintWriter(new File(filename))
    try {
      adjacencyList.foreach {
        case (vertex, neighbors) =>
          val neighborsStr = neighbors.mkString(" ")
          writer.println(s"$vertex: $neighborsStr")
      }
    } finally {
      writer.close()
    }
  }

  override def toString: String = {
    adjacencyList.map {
      case (vertex, neighbors) => s"$vertex -> ${neighbors.mkString(", ")}"
    }.mkString("\n")
  }

  def readFromFile(filename: String): Unit = {
    val source = Source.fromFile(filename)
    try {
      for (line <- source.getLines()) {
        val parts = line.split(":")
        if (parts.length == 2) {
          val vertex = parts(0).trim.asInstanceOf[T]
          val neighbors = parts(1).trim.split("\\s+").map(_.asInstanceOf[T]).toSet
          adjacencyList(vertex) = neighbors
        }
      }
    } finally {
      source.close()
    }
  }
}

object Graph {
  def apply[T](): Graph[T] = new Graph[T]()
}
