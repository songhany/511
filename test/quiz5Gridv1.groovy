
class Grid {
  private int c;  // consumer
  private int p;  // producer
  private final Lock lock = new ReentrantLock();
  private final Condition comsume = lock.newCondition(); 
  private final Condition stopProduce = lock.newCondition();

  void startConsuming() {
    lock.lock()
    try {
      while (p == c) {
        consume.await();
      }
      c++;
    } finally {
      lock.unlock();
    }
  }

  void stopConsuming() {  // you can always stop consuming
    lock.lock()
    try {
      c--;
      // notifyAll();
      stopProduce.signal();
      consume.signal();
    } finally {
      lock.unlock();
    }
  }

  void startProducing() {
    lock.lock()
    try {
      p++;
      // notifyAll();
      consume.signal();
      stopProduce.signal();
    } finally {
      lock.unlock();
    }
  }

  void stopProducing() {
    lock.lock()
    try {
      while (p == c) {
        stopProduce.await();
      }
      p--;
    finally {
      lock.unlock();
    }
  }
}