/**
 * Created with IntelliJ IDEA.
 * User: fred
 * Date: 12/10/13
 * Time: 23.35
 * To change this template use File | Settings | File Templates.
 */

//import akka.actor._
import java.net.{ServerSocket, Socket}
import java.io._

object Server extends App {
  override def main(args: Array[String]) {
    val server = new ServerSocket(8880)
    val socket = server.accept()
    var sockets: Map[Socket, String] = Map()
    run(socket)
  }

  def run(socket: Socket) {
    while (true) {
      println("Client connected")
    //    def message = (Thread.currentThread.getName() + "\n").getBytes
      val input = new BufferedInputStream(socket.getInputStream)
      if (input.startswith("!")) {
        if (input[1:] == "name") {
          val name = input[input.index(":")+1:]
          sockets += (socket, name)
        }
      } else {
        for ((key, value) <- sockets) {
          socket.getOutputStream.write(input.getBytes)
        }
      }
      println("Input:" + input)
    //    println(input)
    }
  }
}
//
//object Server extends App {
//
//    ActorSystem().actorOf(Props(new Server(socket)))
//  }
//}
