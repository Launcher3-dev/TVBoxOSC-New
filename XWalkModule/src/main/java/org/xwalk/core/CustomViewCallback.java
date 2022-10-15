package org.xwalk.core;

import android.webkit.WebChromeClient;

public interface CustomViewCallback extends WebChromeClient.CustomViewCallback {
   void onCustomViewHidden();
}
