/**
 * Created with IntelliJ IDEA.
 * User: fred
 * Date: 13/10/13
 * Time: 2.32
 * To change this template use File | Settings | File Templates.
 */

import java.net.Socket
import java.io._

object Client extends App {

  override def main (args: Array[String]) = run()

  def run(host: String = "127.0.0.1", port: Int = 8880) {
    val socket = new Socket(host, port)

    handler(socket)
  }

  def handler(socket: Socket) {
    val output = socket.getOutputStream.write("Noob".getBytes)
    val in = new BufferedReader(new InputStreamReader(socket.getInputStream))
    println(output)
    println(in.readLine)
    println("OK")
  }
}
