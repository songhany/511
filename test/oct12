import java.util.concurrent.locks.*;

class Buffer {
  private Object buffer = null;
  private final Lock lock = new ReentrantLock();
  private final Condition full = lock.newCondition();
  private final Condition empty = lock.newCondition();

  // Buffer() {
  //   buffer = null;
  // }
  
  void produce(Object o) {
    lock.lock();
    try {
      while (buffer != null) {
        empty.await();
      }
      buffer = o;
      full.signal();
    } finally {
      lock.unlock();
    }
  }

  Object consume() {
    lock.lock()
    try {
      while (buffer == null) {
        full.await()
      }
      Object temp = buffer;
      buffer = null;
      empty.signal()
      return temp;
    } finally {
      lock.unlock();
    }
  }
}

Buffer b = new Buffer();

10.times {
  int id = it
  Thread.start {  // Producer
    b.produce(id);
    println "produce " + id;
  }
}

10.times {
  int id = it
  Thread.start {  // Consumer
    println "consumer " + b.consume();
  }
}

return;