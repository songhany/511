import java.util.concurrent.Semaphore

final int N = 10
Object buffer[] = new Object[N]
Random r = new Random()
Semaphore permToConsume = new Semaphore(0)
Semaphore permToProduce = new Semaphore(N)
Semaphore mutexP = new Semaphore(1)
Semaphore mutexC = new Semaphore(1)
int start = 0;
int end = 0

Thread.start {  // Producer
  while (true) {
    permToProduce.acquire()
    // produce
    mutexP.acquire()
    buffer[end] = r.nextInt(100)
    end = (end + 1) % N
    mutexP.release()
    permToConsume.release()
  }
}


Thread.start {  // Consumer
  while (true) {
    permToConsume.acquire()
    // consume
    mutexC.acquire()
    buffer[start] = null
    start = (start + 1) % N
    mutexC.release()
    permToProduce.release()
  }
}

