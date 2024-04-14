package org.example.actor.supervising;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

public class SuperviseMain {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("supervise");
        ActorRef ref = system.actorOf(SupervisingActor.props());
        ref.tell("failChild", ActorRef.noSender());
    }
}
