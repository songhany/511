// eb5 Exercise 5
import java.util.concurrent.Semaphore;

Semaphore station0 = new Semaphore(1) 
Semaphore station1 = new Semaphore(1) 
Semaphore station2 = new Semaphore(1) 
permToProcess = [??, ??, ??]   // list of semaphores for machines
doneProcessing = [??, ??, ??]  // list of semaphores for machines

100. times {
  Thread.start { // Car
    // Go to station 0
    
    // Move on to station 1 
    
    // Move on to station 2
  } 
}

3. times {
  int id = it; // iteration variable
  Thread.start {  // Machine at station id
    while (true) {
        // Wait for car to arrive
        
        // Process car when it has arrived
      }
  }
}
return;