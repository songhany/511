// Exercise Booklet 5: Semaphores (cont)
// Exercise 1. (♢) On Fridays the bar is usually full of Jets fans. 
// Since the owners are Patriots fans they would like to implement an access control mechanism in which one Jets fan can enter for every two Patriots fans.
import java.util.concurrent.Semaphore

Semaphore ticket = new Semaphore(0)
Semaphore mutex = new Semaphore(1)

20.times {
  Thread.start {  // Patriot
    // entry protocol
    ticket.release()

    // go in
  }
}

20.times {
  Thread.start {  // Jets
    // entry protocol
      // Same like before sep23PatriotJets.groovy, 
    // go in
  }
}