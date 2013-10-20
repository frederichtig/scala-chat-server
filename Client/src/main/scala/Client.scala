/**
 * Created with IntelliJ IDEA.
 * User: fred
 * Date: 13/10/13
 * Time: 2.32
 * To change this template use File | Settings | File Templates.
 */

import java.net.Socket
import java.io.{InputStreamReader, OutputStreamWriter, PrintWriter, BufferedReader}

class Client(host: String = "127.0.0.1", port: Int = 8889) {
  var output: PrintWriter = _
  var input: String = _

  def run() {
    val socket = new Socket(host, port)
    output = new PrintWriter(new OutputStreamWriter(socket.getOutputStream))
    input = new BufferedReader(new InputStreamReader(socket.getInputStream)).readLine()
    chatHandler(socket)
  }

  def chatHandler(socket: Socket) {
    val words = List("Hello", "World", "Muthafucka")
    for (word <- words) {
      output.println(word)
      output.flush()
      println(input)
    }
    println("OK")
  }
}

object Client extends App {
  def apply() = {
    val client = new Client
    client.run()
  }
}
