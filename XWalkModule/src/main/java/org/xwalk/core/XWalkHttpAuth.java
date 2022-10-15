package org.xwalk.core;

public interface XWalkHttpAuth {
   void proceed(String var1, String var2);

   void cancel();

   boolean isFirstAttempt();
}
