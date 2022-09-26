import java.util.concurrent.Semaphore

// Implement a one-time use barrier
// Barrier size: N
// Number of threads in our system: N

final int N = 3
int t = 0
Semaphore barrier = new Semaphore(0)
Semaphore mutex = new Semaphore(1)

N.times {
  Thread.start {
    while (true) {
      // entry protocal
      mutex.acquire()
      if (t == N) {
        barrier.release()  // release barries for myself.   // N.times { barrier.release() }  this will cause Overflow
      } else {
        t++  // all threads will use this variable
        if (t == N) {
          N.times { barrier.release() }  // barrier.release(N) this is atomicly release
        }
      }
      mutex.release()

      // barrier
      barrier.acquire()    
    }
  }
}

// You have to wait all N threads finishing, then you can continue
