//     Project: sconfig
// Description: Defines a Typesafe config compatible trait for configuration maps
//
package sconfig

/**
 * A Typesafe Config compatible API for accessing configuration values.
 */
trait Config {

  def getBoolean(path: String) : Boolean

  def getBooleanList(path: String) : Iterable[Boolean]

  def getInt(path: String) : Int

  def getIntList(path: String) : Iterable[Int]

  def getLong(path: String) : Long

  def getLongList(path: String) : Iterable[Long]

  def getDouble(path: String) : Double

  def getDoubleList(path: String) : Iterable[Double]

  def getString(path: String) : String

  /**
   * Returns a sequence of String configuration values.
   * Returns an empty sequence if the specified configuration path is not defined.
   */
  def getStringList(path: String) : Iterable[String]
}
