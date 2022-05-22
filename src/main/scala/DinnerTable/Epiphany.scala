package DinnerTable

object Epiphany {

  /*
The requirements mostly come from the wiki page:
https://en.wikipedia.org/wiki/Dining_philosophers_problem

5 Philosophers (Heraclitus, Searle, Nietzsche, Aristotle, McLuhan)
5 Forks (??Dependencies?? Resources??)
Philosophers States: Eating, Thinking, Talking(Hungry)


Event Storm -
  EpiphanyReached - an event which triggers state changes for all Philosophers and
    possible a Fork workflow event.

  StartedEating
  StartedThinking
  StartedTalking

  ForkGrabbed
  ForkDropped


Bounded Context: Shifting States/Paradigms
Workflow: "Paradigm Shift"
  triggered by:
    "EpiphanyReached" event
  primary input:
    ?? The philosophers seating order? or No input
  other input:
    the Fork status

   output events:
      "<State Change>" events
      "<Fork Change>" events

   side-effects:
      None?? Maybe so logs or displays.



   */

  case class Philosopher(
      name: String,
      state: ParadigmState,
      leftFork: ForkState,
      rightFork: ForkState
  ) {}

  sealed trait ParadigmState
  case object StartedEating extends ParadigmState
  case object StartedThinking extends ParadigmState
  case object StartedTalking extends ParadigmState

  sealed trait ForkState
  case object ForkGrabbed extends ForkState
  case object ForkState extends ForkState

  def main(args: Array[String]): Unit = {
    println("test")
  }

}
