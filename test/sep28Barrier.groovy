import java.util.concurrent.Semaphore

// Implement a one-time use barrier
// Barrier size: N
// Number of threads in our system: N
//! We want the barrier could be reuseable


Semaphore mutex = new Semaphore(1)
Semaphore barrier = new Semaphore(0)
Semaphore barrier2 = new Semaphore(0)
final int N = 3
int t = 0
int[] c = new int[N]


N.times {
  Thread.start {
    int id = it;
    10.times { // while (true) {
      // arrival
      mutex.acquire()
      c[id]++
      t++
      if (t == N) {
        N.times { barrier.release() }
        t = 0
      }
      mutex.release()

      // barrier
      println id + " reached barrier.  c=" + c[id]
      barrier.acquire()
      println id + " passed barrier. c=" + c[id]


      mutex.acquire()
      t--
      if (t == 0) {
        N.times { barrier2.release() }
      }
      mutex.release()
      barrier2.acquire()
    }
  }
}

// You have to wait all N threads finishing, then you can continue
