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
  case object Eating extends ParadigmState
  case object Thinking extends ParadigmState
  case object Talking extends ParadigmState

  sealed trait ForkState
  case object Grasped extends ForkState
  case object Free extends ForkState

  sealed trait ForkStateEvent
  case object ForkGrabbed extends ForkStateEvent
  case object ForkDropped extends ForkStateEvent

  sealed trait ParadigmStateEvents
  case object StartedEating extends ParadigmStateEvents
  case object StartedThinking extends ParadigmStateEvents
  case object StartedTalking extends ParadigmStateEvents

  /*
   * this should handle ShiftParadigm commands
   *
   * ParadigmState => (ForkState, ForkState) => ParadigmState
   *
   */

  def shiftParadigm(
      state: ParadigmState,
      forks: (ForkState, ForkState)
  ): Option[ParadigmState] = state match {
    case Eating if forks == (Grasped, Grasped) => Some(Thinking)
    case Thinking                              => Some(Talking)
    case Talking if forks == (Free, Free)      => Some(Eating)
    case _                                     => None
  }

  // Option allows me to fail fast, right?
  // so if I get an Epiphany (a group of paradigm shifts) that doesn't
  // work the idea is to get a none back into terms of shiftEvents

  def main(args: Array[String]): Unit = {
    println("test")
  }

}
