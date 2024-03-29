package Multithreading;

import java.util.LinkedList;

public class WorkQueue {
	private final int nThreads;
	private final PoolWorker[] threads;
	private final LinkedList queue;
	public WorkQueue(int nThreads) {
		this.nThreads = nThreads;
		queue = new LinkedList();
		threads = new PoolWorker[nThreads];
		for(int i = 0;i<nThreads;i++) {
			threads[i] = new PoolWorker();
			threads[i].start();
		}
	}
	public void execute(Runnable r) {
		synchronized(queue) {
			queue.addLast(r);
			queue.notify();
		}
	}

	private class PoolWorker extends Thread{
		public void run() {
			Runnable r;
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {
						try {
							queue.wait();
						} catch (InterruptedException e) {
						}
					}
					r = (Runnable) queue.removeFirst();
				}
				try {
					r.run();
				} catch (RuntimeException e) {
					// You might want to log something here
				}
			}
		}
	}
}
