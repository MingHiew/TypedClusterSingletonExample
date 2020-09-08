import akka.actor.typed.{ActorRef, Behavior}
import akka.actor.typed.scaladsl.Behaviors
import akka.cluster.typed.{ClusterSingleton, SingletonActor}

class PaymentSystemNode(port: Int,shouldStartSingleton: Boolean = true) extends App {
  def apply(): Behavior[Nothing] = Behaviors.setup[Nothing]{context =>

      val paymentSystem: ActorRef[Transaction] = ClusterSingleton(context.system)
        .init(SingletonActor(PaymentSystem(),"paymentSystem"))
    
    Behaviors.empty
  }
}
