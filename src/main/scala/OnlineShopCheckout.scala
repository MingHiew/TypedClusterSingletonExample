import java.util.UUID

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

case class Order(items: List[String],total: Double)

class OnlineShopCheckout(paymentSystem: ActorRef[Transaction]) {
  var orderId = 0
  def apply(): Behavior[Order] = Behaviors.receive[Order] {(context,message) =>
    message match {
      case Order(_,totalAmount) => {
        context.log.info(s"Received order $orderId for amount $totalAmount, sending transaction to validate")
        val newTransaction = Transaction(orderId,UUID.randomUUID().toString,totalAmount)
        paymentSystem ! newTransaction
        orderId+=1
        Behaviors.same
      }
    }

  }
}
