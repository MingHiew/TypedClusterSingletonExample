import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.Behaviors

case class Transaction(orderId: Int, txnId: String, amount: Double)

object PaymentSystem {

  def apply(): Behavior[Transaction] = Behaviors.receive[Transaction]((context,message) =>
    message match {
      case Transaction(orderId,_,amount) => context.log.info(s"Validating Transaction: $orderId - $amount")
      Behaviors.same
    }
  )


}
