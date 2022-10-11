
class Bar {

  private int delta = 0;
  private int p = 0;
  private int j = 0;
  private boolean itGotLate;

  Bar() {
    delta = 0;
  }

  synchronized void printState() {
    println "p: " + p + " j: " + j;
  }

  synchronized void patriots() {
    delta++;
    p++;
    notify();
    printState();
  }

  synchronized void jets() {
    if (!itGotLate) {
      while (delta < 2) {
        wait();
      }
      delta = delta - 2;
      j++;
    }
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