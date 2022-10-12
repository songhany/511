import java.util.concurrent.Semaphore

Semaphore permToLoad = new Semaphore(0)
Semaphore downLoading = new Semaphore(0)
List<Semaphore> tracks = [new Semaphore(1), new Semaphore(1)]

20.times {
  int dir = new Random().nextInt(2);
  Thread.start {  // PassengerTrain(i)
    tracks[dir].acquire();
    tracks[dir].release();
  }
}

20.times {
  int dir = new Random().nextInt(2);
  Thread.start {  // FreightTrain(i)
    // mutex.acquire()
    tracks[0].acquire()
    tracks[1].acquire()
    // mutex.release()
    permToLoad.release()
    downLoading.acquire()
    tracks[0].release()
    tracks[1].release()
  }
}

Thread.start {  // Loading Machine
  while (true) {
    permToLoad.acquire();
    // load freight train
    downLoading.release()
  }
}
