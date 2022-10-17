
class Grid {
  private int c;  // consumer
  private int p;  // producer

  synchronized void startConsuming() {
    while (p == c) {
      wait();
    }
    c++;
  }

  synchronized void stopConsuming() {  // you can always stop consuming
    c--;
    notifyAll();
  }

  synchronized void startProducing() {
    p++;
    notifyAll();
  }

  synchronized void stopProducing() {
    while (p == c) {
      wait();
    }
    p--;
  }
}