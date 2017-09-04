package study.java.foundation.proto;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MediaServer {
	public static final String SHUTDOWN_HOOK_KEY = "server.shutdown.hook";

	private static volatile boolean running = true;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			// logger.warn(Constants.SERVER_NAME + " init...");

			final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:applicationContext.xml");
			if ("true".equals(System.getProperty(SHUTDOWN_HOOK_KEY))) {
				Runtime.getRuntime().addShutdownHook(new Thread() {
					public void run() {
						try {
							context.stop();
						} catch (Throwable t) {
						}
						synchronized (MediaServer.class) {
							running = false;
							MediaServer.class.notify();
						}
					}
				});
			}

			
			context.start();
			long stop = System.currentTimeMillis();
			System.out.println("服务器已启动，花费"+ (stop - start)/1000 + "s");
			// logger.warn(Constants.SERVER_NAME + " started! takes " +
			// (System.currentTimeMillis() - t) + " ms");
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.exit(1);
		}
		synchronized (MediaServer.class) {
			while (running) {
				try {
					MediaServer.class.wait();
				} catch (Throwable e) {
				}
			}
		}
	}

}
