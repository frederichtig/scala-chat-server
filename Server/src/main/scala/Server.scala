/**
 * Created with IntelliJ IDEA.
 * User: fred
 * Date: 12/10/13
 * Time: 23.35
 * To change this template use File | Settings | File Templates.
 */

import java.net.{ServerSocket, Socket}
import java.io.{InputStreamReader, OutputStreamWriter, PrintWriter, BufferedReader}

class Server(port: Int = 8889) {
  var sockets = Map[Socket, String]()
  var output: PrintWriter = _
  var input: String = _

  def run() {
    val server = new ServerSocket(port)
    val socket = server.accept()

    output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream))
    input = new BufferedReader(new InputStreamReader(socket.getInputStream)).readLine()
    chatHandler(socket)
  }

  def chatHandler(socket: Socket) {
    println("Client connected")
    println(socket)
    output.println("Welcome!")
    output.flush()
    while (true) {
      println(input)
      if (input.substring(0) == "!") {
        if (input.substring(1,5) == "name") {
          val name = input.substring(input.indexOf(":"), input.length)
          sockets += (socket -> name)
        }
      } else {
        sendAll(input)
      }
    }
  }

  def sendAll(message: String) {
    for ((key, value) <- sockets) {
      output.println(input.getBytes)
      output.flush()
    }
  }
}

object Server extends App {
  def apply() = {
    val server = new Server()
    server.run()
  }
}