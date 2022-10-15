package org.xwalk.core;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Utils {
	public static boolean testing;
	private static boolean straightParams;
	private static Object tag;
	private static final Lock lock = new ReentrantLock();
	
	public static android.webkit.WebView getLockedView(Object tag_, boolean straightParams_) {
		lock.lock();
		straightParams = straightParams_;
		tag = tag_;
		return null;
	}
	
	public static void unlock() {
		try {
			lock.unlock();
		} catch (Exception ignored) { }
	}
	
	public static Object getTag() {
		Object ret = tag;
		if(straightParams) {
			unlock();
		}
		return ret;
	}
	
	public static void Log(Object...o) {
		StringBuilder msg= new StringBuilder();
		if(o!=null)
			for (Object o1 : o) {
				if(o1!=null) {
					if (o1 instanceof Throwable) {
						ByteArrayOutputStream s = new ByteArrayOutputStream();
						PrintStream p = new PrintStream(s);
						((Throwable) o1).printStackTrace(p);
						msg.append(s.toString());
					} else if (o1 instanceof int[]) {
						msg.append(Arrays.toString((int[]) o1));
						continue;
					} else if (o1 instanceof String[]) {
						msg.append(Arrays.toString((Object[]) o1));
						continue;
					} else if (o1 instanceof short[]) {
						msg.append(Arrays.toString((short[]) o1));
						continue;
					} else if (o1 instanceof byte[]) {
						msg.append(Arrays.toString((byte[]) o1));
						continue;
					}
				}
				if(msg.length()>0) msg.append(", ");
				msg.append(o1);
			}
		if(testing) {
			System.out.println(msg.toString());
		} else {
			android.util.Log.d("fatal poison",msg.toString());
		}
	}
}
