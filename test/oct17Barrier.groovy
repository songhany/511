
class Barr {   // one-time use barrier
  private int size;
  private int c;   // counter

  Barr(int size) {
    this.size = size;
    c = 0;
  }

  synchronized void waitAtBarrier() {
    if (c < size) {   // avoid overflow
      c++;   
      while (c < size) {
        wait();
      }
      notifyAll();   // if use notify(), which call "cascaded singanalling", this will works fine;
    }
  }
}