package ciriti.dilib.post

import arrow.core.Either
import arrow.core.Try
import arrow.core.getOrElse

/**
 * Created by Carmelo Iriti
 */
interface DaoOperationsSyntax {
  val dao: DaoDatabase

  fun User.query() =
    dao.query("SELECT * from Users where userId = ${this.id}")

  fun Company.query() =
    dao.query("SELECT * from Companies where companyId = ${this.id}")
}

class DaoDatabase{
  fun query(q : String){}
}

class User(val id : Int)
class Company(val id : Int)

// NetworkSyntax

interface NetworkSyntax {
  val network: NetworkModule

  fun User.request() =
    network.request(this.id)

  fun Company.request() =
    network.request(this.id)
}

class NetworkModule{
  fun request(id : Int){}
}

interface RequestSyntax: DaoOperationsSyntax, NetworkSyntax {

  fun User.fetchUser() =
    Try { query() }.getOrElse { request() }

  fun Company.fetchUCompany() {
    Try { query() }.getOrElse { request() }
    Either
  }

}

object DataRepository {
  fun RequestSyntax.getUser(user: User) =
    user.fetchUser()

  fun DaoOperationsSyntax.getCompany(company: Company) =
    company.query()
}

//val globalSyntax = object: RequestSyntax {
//  override val network = GlobalNetwork()
//
//  override val dao = DaoSingletonObject
//}
//
//fun main(args: Array<String>) {
//  println(globalSyntax.getUser(User("123")))
//}

interface Eq<F> {
  fun F.eqv(b: F): Boolean

  fun F.neqv(b: F): Boolean =
    !eqv(b)
}