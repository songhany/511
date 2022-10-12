/*
Implement the fan bar exercise from Exercise Booklet 5, using monitors. 
Here is the statement. On Fridays the bar is usually full of Jets fans. 
Since the owners are Patriots fans they would like to implement an access control mechanism 
in which one Jets fan can enter for every two Patriots fans.
*/


class TWS {
  int state = 1;
  static final Lock lock = new ReentrantLock();
  static final Condition first = lock.newCondition(); 
  static final Condition second = lock.newCondition();
  static final Condition third = lock.newCondition();

  TWS() {

  }

  synchronized void printState(int i) {
    
  }

  one() {
     lock.lock();  // block until condition holds
     try {
       // ... method body
     } finally {
       lock.unlock()
     }
  }

  two() {
     lock.lock();  // block until condition holds
     try {
       // ... method body
     } finally {
       lock.unlock()
     }
  }

  three() {
     lock.lock();  // block until condition holds
     try {
       // ... method body
     } finally {
       lock.unlock()
     }
  }
}

TWS tws = new TWS()

200.times {
  Thread.start {
    swtch(new Random().nextInt(3)) {
      case 0: tws.one() break
      case 1: tws.two() break
      default: tws.three()
    }
  }
}