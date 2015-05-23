// -   Project: sconfig (https://github.com/jokade/sconfig)
// Description:
//
// Distributed under the MIT License (see included file LICENSE)
package sconfig

import scala.scalajs.js

object JSConfigFactory {

  def apply(config: js.Object) : Config = new JSObjectConfig(config.asInstanceOf[js.Dictionary[Any]])

  final class JSObjectConfig(wrapped: js.Dictionary[Any]) extends Config {

    @inline final override def getBoolean(path: String): Boolean = wrapped(path).asInstanceOf[Boolean]

    @inline final override def getInt(path: String): Int = wrapped(path).asInstanceOf[Int]

    @inline final override def getDouble(path: String): Double = wrapped(path).asInstanceOf[Double]

    @inline final override def getLong(path: String): Long = wrapped(path).asInstanceOf[Long]

    @inline final override def getString(path: String): String = wrapped(path).asInstanceOf[String]
    /**
     * Returns a sequence of String configuration values.
     * Returns an empty sequence if the specified configuration path is not defined.
     */
    override def getStringList(path: String): Seq[String] = ???

  }
}
