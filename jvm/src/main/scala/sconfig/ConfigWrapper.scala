//     Project: sconfig
//      Author: jokade <jkspam@karchedon.de>
// Description: Provides a wrapper for Typesafe Config instances
//
package sconfig

import com.typesafe.config.{Config => TSConfig}

/**
 * A wrapper around Typesafe Config instances.
 *
 * @constructor
 * @param wrapped Typesafe Config instance
 */
final class ConfigWrapper(wrapped: TSConfig) extends Config {
  import collection.JavaConverters._

  override def getBoolean(path: String) : Boolean = wrapped.getBoolean(path)

  override def getBooleanList(path: String): Iterable[Boolean] =
    if(wrapped.hasPath(path)) wrapped.getBooleanList(path).asScala.map(Boolean.unbox(_))
    else Nil

  override def getInt(path: String) : Int = wrapped.getInt(path)

  override def getIntList(path: String): Iterable[Int] =
    if(wrapped.hasPath(path)) wrapped.getIntList(path).asScala.map(Int.unbox(_))
    else Nil

  override def getLong(path: String) : Long = wrapped.getLong(path)

  override def getLongList(path: String): Iterable[Long] =
    if(wrapped.hasPath(path)) wrapped.getLongList(path).asScala.map(Long.unbox(_))
    else Nil

  override def getDouble(path: String) : Double = wrapped.getDouble(path)

  override def getDoubleList(path: String): Iterable[Double] =
    if(wrapped.hasPath(path)) wrapped.getDoubleList(path).asScala.map(Double.unbox(_))
    else Nil

  override def getString(path: String) : String = wrapped.getString(path)

  override def getStringList(path: String) : Iterable[String] =
    if(wrapped.hasPath(path)) wrapped.getStringList(path).asScala
    else Nil

}
