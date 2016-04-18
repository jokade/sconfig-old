// -   Project: sconfig (https://github.com/jokade/sconfig)
// Description:
//
// Distributed under the MIT License (see included file LICENSE)
package sconfig

import scala.scalajs.js

object JSConfigFactory {

  def apply(config: js.Object) : Config = apply(config.asInstanceOf[js.Dictionary[Any]])

  def apply(config: js.Dictionary[Any]) : Config = new JSObjectConfig(config)

  def apply(properties: (String,Any)*) : Config = apply(js.Dictionary(properties:_*))

  final class JSObjectConfig(wrapped: js.Dictionary[Any]) extends Config {

    @inline override def getBoolean(path: String): Boolean = wrapped(path).asInstanceOf[Boolean]

    @inline override def getBooleanList(path: String): Iterable[Boolean] =
      wrapped.getOrElse(path,js.Array()).asInstanceOf[js.Array[Boolean]]

    @inline override def getInt(path: String): Int = wrapped(path).asInstanceOf[Int]

    @inline override def getIntList(path: String): Iterable[Int] =
      wrapped.getOrElse(path,js.Array()).asInstanceOf[js.Array[Int]]

    @inline override def getLong(path: String): Long = wrapped(path).asInstanceOf[Long]

    @inline override def getLongList(path: String): Iterable[Long] =
      wrapped.getOrElse(path,js.Array()).asInstanceOf[js.Array[Long]]

    @inline override def getDouble(path: String): Double = wrapped(path).asInstanceOf[Double]

    @inline override def getDoubleList(path: String): Iterable[Double] =
      wrapped.getOrElse(path,js.Array()).asInstanceOf[js.Array[Double]]

    @inline override def getString(path: String): String = wrapped(path).asInstanceOf[String]

    /**
     * Returns a sequence of String configuration values.
     * Returns an empty sequence if the specified configuration path is not defined.
     */
    @inline override def getStringList(path: String): Seq[String] =
      wrapped.getOrElse(path,js.Array()).asInstanceOf[js.Array[String]]

  }
}
