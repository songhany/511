/*
Implement the fan bar exercise from Exercise Booklet 5, using monitors. 
Here is the statement. On Fridays the bar is usually full of Jets fans. 
Since the owners are Patriots fans they would like to implement an access control mechanism 
in which one Jets fan can enter for every two Patriots fans.
*/


class Bar {

  private int unsorted_priorities = 0;
  private int p = 0;
  private int j = 0;
  private boolean itGotLate;

  Bar() {
    unsorted_priorities = 0;
  }

  synchronized void printState() {
    println "p: " + p + " j: " + j;
  }

  synchronized void patriots() {  
    unsorted_priorities++;
    p++;
    notify(); 
    printState();
  }

  synchronized void jets() {  // one Jets fan can enter for every two Patriots fans
    while (unsorted_priorities < 2 && !itGotLate) {  // you never ever change WHILE to IF statement,
      wait();  // because if notify() wake up this thread, you must recheck whether it can pass the while statment
    }
    if (!itGotLate) {
      unsorted_priorities = unsorted_priorities - 2;
    }
    j++;
    printState();
  }

  synchronized void itGotLate() {
    notifyAll();
    itGotLate = true;
  }
}

Bar b = new Bar(); 

100.times {
  Thread.start {// jets 
    b.jets();
  } 
}

100.times {
  Thread.start { // patriots 
    b.patriots();
  } 
}

// Thread.start {   // let all Jets fan go into
//   b.sleep(1000)
//   b.itGotLate();
// }