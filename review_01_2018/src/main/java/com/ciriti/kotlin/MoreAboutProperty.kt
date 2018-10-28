package com.ciriti.kotlin

/**
 * Created by Carmelo Iriti
 */
interface User {
  val nickname: String
}

class FacebookUser(val accountId: Int) : User {
  /** this property store the value of the function */
  override val nickname = getFacebookName(accountId)

  private fun getFacebookName(accountId: Int): String{
    println("function getFacebookName")
    return "carmelo"
  }
}

class SubscribingUser(val email: String) : User {
  /** this property calculate the value always */
  override val nickname: String
    get(){
      println("getter SubscribingUser")
      return email.substringBefore('@')
    }
}

/**
 *
 */

interface Session{
  /** this is an open property */
  val user : User
}

class FbUser : User{
  val accoutnId = 1
  override val nickname: String = "carmelo"
}

fun main(args : Array<String>){
  val fbu = FacebookUser(1)
  val sb = SubscribingUser("ciriti@gmail.com")

  /**
   * Which property is calculated on each access?
   */
  fbu.nickname
  fbu.nickname
  fbu.nickname
  fbu.nickname
  println()
  sb.nickname
  sb.nickname
  sb.nickname
  sb.nickname

}

fun analyzeUserSession(session : Session){
  if(session.user is FbUser){
    /**
     * compile error
     * smart cast doesn't work because session.user has open o custom setter
     */
//    println(session.user.accoutnId)
  }
}

