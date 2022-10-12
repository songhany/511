/*
  We wish to implement a three-way sequencer using monitors in order to coordinate N threads. 
  A three-way sequencer provides the following operations first, second, third. 
  The idea is that each of the threads can invoke any of these operations. 
  The sequencer will alternate cyclically the execution of first, then second, and finally third.
*/


class TWS {
  int state;
  static final Lock lock = new ReentrantLock();
  static final Condition first = lock.newCondition(); 
  static final Condition second = lock.newCondition();
  static final Condition third = lock.newCondition();

  TWS() {
    state = 1;
  }

  synchronized void printState(int i) {
    println Threa.concurrentThread().getId() + " executed " + i;
  }

  synchronized void one() {
    while (state != 1) {
      wait();
    }
    state = 2;
    notifyAll();
    printState(1);
  }

  synchronized void two() {
    while (state != 2) {
      wait();
    }
    state = 3;
    notifyAll();
    printState(2);
  }

  synchronized void three() {
    while (state != 3) {
      wait();
    }
    state = 1;
    notifyAll();
    printState(3);
  }
}

TWS tws = new TWS();

100.times {
  Thread.start {
    swtch(new Random().nextInt(3)) {
      case 0: tws.one() break
      case 1: tws.two() break
      default: tws.three()
    }
  }
}