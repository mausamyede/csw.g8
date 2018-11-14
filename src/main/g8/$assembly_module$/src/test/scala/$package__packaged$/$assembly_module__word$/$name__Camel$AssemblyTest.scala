package $package$.$assembly_module;format="word"$

import csw.location.api.models.Connection.AkkaConnection
import csw.location.api.models.{ComponentId, ComponentType}
import csw.testkit.scaladsl.CSWService.{AlarmStore, EventStore}
import csw.testkit.scaladsl.ScalaTestFrameworkTestKit
import org.scalatest.FunSuiteLike

import scala.concurrent.Await
import scala.concurrent.duration._


class $name;format="Camel"$AssemblyTest extends ScalaTestFrameworkTestKit(AlarmStore, EventStore) with FunSuiteLike {

  import frameworkTestKit.frameworkWiring._

  override def beforeAll(): Unit = {
    super.beforeAll()
    // uncomment if you want one Assembly run for all tests
    //spawnStandalone(com.typesafe.config.ConfigFactory.load("$name;format="Camel"$AssemblyStandalone.conf"))
  }

  test("Assembly should be locatable using Location Service") {
    val connection = AkkaConnection(ComponentId("$name;format="Camel"$Assembly", ComponentType.Assembly))
    val akkaLocation = Await.result(locationService.resolve(connection, 10.seconds), 10.seconds).get

    akkaLocation.connection shouldBe connection
  }
}