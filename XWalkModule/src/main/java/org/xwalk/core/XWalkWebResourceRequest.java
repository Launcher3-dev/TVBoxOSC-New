package org.xwalk.core;

import android.net.Uri;
import java.util.Map;

public interface XWalkWebResourceRequest {
   Uri getUrl();

   boolean isForMainFrame();

   boolean hasGesture();

   String getMethod();

   Map<String, String> getRequestHeaders();
}
