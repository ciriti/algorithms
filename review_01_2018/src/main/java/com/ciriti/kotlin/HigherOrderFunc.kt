package com.ciriti.kotlin

/**
 * Created by Carmelo Iriti
 */

/**
 * 3 different version to write the same function
 */
fun main(args : Array<String>){

  val db = DatabaseImpl()

  /** 1. classic function */
  transaction(db){ 1 }

  /** 2. extension version */
  db.transactionV1 {
    it.beginTransaction() // the receiver object is it
    1
  }

  /** 3. function with receiver version */
  db.transactionV2 {
    this.beginTransaction() // the receiver object is "this"
    1
  }

}

interface Database{
  fun beginTransaction()
  fun setTransactionSuccessful()
  fun endTransaction()
}

class DatabaseImpl : Database{
  override fun beginTransaction() {}
  override fun setTransactionSuccessful() {}
  override fun endTransaction() {}
}

/**
 * regular Function literals
 */
fun Database.transactionV1(block : (db : Database) -> Int) : Int{
  beginTransaction()
  try {
    /** you must specify the argument into the function: block(this) */
    val result = block(this)
    setTransactionSuccessful()
    return result
  } finally {
    endTransaction()
  }
}
/**
 * Function literals with receiver - https://kotlinlang.org/docs/reference/lambdas.html#function-literals-with-receiver
 */
fun Database.transactionV2(block : Database.() -> Int) : Int{
  beginTransaction()
  try {
    /** implicitly the argument into block is the receiver of this extension: block(this) */
    val result = block()
    setTransactionSuccessful()
    return result
  } finally {
    endTransaction()
  }
}

/**
 * this is the simplest way to write transactionV1 and transactionV2 functions
 */
fun transaction(db: Database, body: (Database) -> Int): Int {
  db.beginTransaction()
  try {
    val result = body(db)
    db.setTransactionSuccessful()
    return result
  } finally {
    db.endTransaction()
  }
}
