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
class ConfigWrapper(wrapped: TSConfig) extends Config {
  import collection.JavaConverters._

  override def getBoolean(path: String) : Boolean = wrapped.getBoolean(path)

  override def getInt(path: String) : Int = wrapped.getInt(path)

  override def getLong(path: String) : Long = wrapped.getLong(path)

  override def getDouble(path: String) : Double = wrapped.getDouble(path)

  override def getString(path: String) : String = wrapped.getString(path)

  override def getStringList(path: String) : Seq[String] = 
    if(wrapped.hasPath(path)) wrapped.getStringList(path).asScala
    else Nil
}
