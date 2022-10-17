
class Grid {
  // private int c;  // consumer
  // private int p;  // producer
  private int delta;
  private final Lock lock = new ReentrantLock();
  private final Condition comsume = lock.newCondition(); 
  private final Condition stopProduce = lock.newCondition();

  void startConsuming() {
    lock.lock()
    try {
      while (delta == 0) {
        consume.await();
      }
      delta++;
    } finally {
      lock.unlock();
    }
  }

  void stopConsuming() {  // you can always stop consuming
    lock.lock()
    try {
      delta--;
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
      delta++;
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
      while (delta == 0) {
        stopProduce.await();
      }
      delta--;
    finally {
      lock.unlock();
    }
  }
}