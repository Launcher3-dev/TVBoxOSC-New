package org.xwalk.core;

import android.net.http.SslError;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebViewClient;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

import static org.xwalk.core.Utils.Log;
import static org.xwalk.core.Utils.getLockedView;
import static org.xwalk.core.Utils.unlock;

public class XWalkResourceClient {
   public static final int ERROR_OK = 0;
   public static final int ERROR_UNKNOWN = -1;
   public static final int ERROR_HOST_LOOKUP = -2;
   public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
   public static final int ERROR_AUTHENTICATION = -4;
   public static final int ERROR_PROXY_AUTHENTICATION = -5;
   public static final int ERROR_CONNECT = -6;
   public static final int ERROR_IO = -7;
   public static final int ERROR_TIMEOUT = -8;
   public static final int ERROR_REDIRECT_LOOP = -9;
   public static final int ERROR_UNSUPPORTED_SCHEME = -10;
   public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
   public static final int ERROR_BAD_URL = -12;
   public static final int ERROR_FILE = -13;
   public static final int ERROR_FILE_NOT_FOUND = -14;
   public static final int ERROR_TOO_MANY_REQUESTS = -15;
   private ArrayList<Object> constructorTypes = new ArrayList();
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private WebViewClient a;
	private WebChromeClient b;
   private final XWalkView webView;
   private Object bridge;
   private ReflectMethod onDocumentLoadedInFrameXWalkViewInternallongMethod = new ReflectMethod((Class)null, "onDocumentLoadedInFrame", new Class[0]);
   private ReflectMethod onLoadStartedXWalkViewInternalStringMethod = new ReflectMethod((Class)null, "onLoadStarted", new Class[0]);
   private ReflectMethod onLoadFinishedXWalkViewInternalStringMethod = new ReflectMethod((Class)null, "onLoadFinished", new Class[0]);
   private ReflectMethod onProgressChangedXWalkViewInternalintMethod = new ReflectMethod((Class)null, "onProgressChanged", new Class[0]);
   private ReflectMethod shouldInterceptLoadRequestXWalkViewInternalStringMethod = new ReflectMethod((Class)null, "shouldInterceptLoadRequest", new Class[0]);
   private ReflectMethod shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod = new ReflectMethod((Class)null, "shouldInterceptLoadRequest", new Class[0]);
   private ReflectMethod onReceivedLoadErrorXWalkViewInternalintStringStringMethod = new ReflectMethod((Class)null, "onReceivedLoadError", new Class[0]);
   private ReflectMethod shouldOverrideUrlLoadingXWalkViewInternalStringMethod = new ReflectMethod((Class)null, "shouldOverrideUrlLoading", new Class[0]);
   private ReflectMethod onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod = new ReflectMethod((Class)null, "onReceivedSslError", new Class[0]);
   private ReflectMethod onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod = new ReflectMethod((Class)null, "onReceivedClientCertRequest", new Class[0]);
   private ReflectMethod onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod = new ReflectMethod((Class)null, "onReceivedResponseHeaders", new Class[0]);
   private ReflectMethod doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod = new ReflectMethod((Class)null, "doUpdateVisitedHistory", new Class[0]);
   private ReflectMethod onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod = new ReflectMethod((Class)null, "onReceivedHttpAuthRequest", new Class[0]);
   private ReflectMethod createXWalkWebResourceResponseStringStringInputStreamMethod = new ReflectMethod((Class)null, "createXWalkWebResourceResponse", new Class[0]);
   private ReflectMethod createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod = new ReflectMethod((Class)null, "createXWalkWebResourceResponse", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkResourceClient(XWalkView view, WebViewClient a, WebChromeClient b) {
	   this.webView = view;
	   this.constructorTypes.add("XWalkViewBridge");
	   this.constructorParams = new ArrayList();
	   this.constructorParams.add(view);
	   syncAB(a, b);
	   this.reflectionInit();
   }
	
	public void syncAB(WebViewClient a, WebChromeClient b) {
		if(a!=null)this.a = a;
		if(b!=null)this.b = b;
	}
	
	public void onDocumentLoadedInFrame(XWalkView view, long frameId) {
      try {
         this.onDocumentLoadedInFrameXWalkViewInternallongMethod.invoke(view.getBridge(), frameId);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }

   }

   public void onLoadStarted(XWalkView view, String url) {
//      try {
//         this.onLoadStartedXWalkViewInternalStringMethod.invoke(view.getBridge(), url);
//      } catch (UnsupportedOperationException var4) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         }
//
//         XWalkCoreWrapper.handleRuntimeError(var4);
//      }
	   if(a!=null) {
		   a.onLoadResource(getLockedView(view, true), url);
		   unlock();
	   }
   }
	
	public void onLoadFinished(XWalkView view, String url) {
      try {
         this.onLoadFinishedXWalkViewInternalStringMethod.invoke(view.getBridge(), url);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void onProgressChanged(XWalkView view, int progressInPercent) {
//      try {
//         this.onProgressChangedXWalkViewInternalintMethod.invoke(view.getBridge(), progressInPercent);
//      } catch (UnsupportedOperationException var4) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         }
//
//         XWalkCoreWrapper.handleRuntimeError(var4);
//      }
	   if(b!=null) {
		   b.onProgressChanged(getLockedView(view, true), progressInPercent);
		   unlock();
	   }
   }

   /** @deprecated */
   public WebResourceResponse shouldInterceptLoadRequest(XWalkView view, String url) {
//      try {
//         return (WebResourceResponse)this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.invoke(view.getBridge(), url);
//      } catch (UnsupportedOperationException var4) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         } else {
//            XWalkCoreWrapper.handleRuntimeError(var4);
//            return null;
//         }
//      }
	   
	   if(a!=null) {
		   android.webkit.WebView wv = getLockedView(view, false);
		   this.webView.wrr = null;
		   WebResourceResponse ret = null;
		   try {
			   ret = a.shouldInterceptRequest(wv, url);
		   } catch (Exception e) {
			   Log(e);
		   }
		   unlock();
		   return ret;
	   }
	   return null;
   }

   public XWalkWebResourceResponse shouldInterceptLoadRequest(XWalkView view, XWalkWebResourceRequest request) {
//      try {
//         return (XWalkWebResourceResponse)this.coreWrapper.getWrapperObject(this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.invoke(view.getBridge(), ((XWalkWebResourceRequestHandler)request).getBridge()));
//      } catch (UnsupportedOperationException var4) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         } else {
//            XWalkCoreWrapper.handleRuntimeError(var4);
//            return null;
//         }
//      }
	   if(a==null) {
	   	return null;
	   }
	   android.webkit.WebView wv = getLockedView(view, false);
	   this.webView.wrr = request;
	   XWalkWebResourceResponse ret = null;
	   try {
		   ret = createXWalkWebResourceResponse(a.shouldInterceptRequest(wv, (String)null));
	   } catch (Exception e) {
		   Log(e);
	   }
	   unlock();
	   return ret;
   }
	
	public void onReceivedLoadError(XWalkView view, int errorCode, String description, String failingUrl) {
      try {
         this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.invoke(view.getBridge(), errorCode, description, failingUrl);
      } catch (UnsupportedOperationException var6) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var6);
      }

   }

   public boolean shouldOverrideUrlLoading(XWalkView view, String url) {
//      try {
//         return (Boolean)this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.invoke(view.getBridge(), url);
//      } catch (UnsupportedOperationException var4) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         } else {
//            XWalkCoreWrapper.handleRuntimeError(var4);
//            return false;
//         }
//      }
	
	   if(a!=null) {
		   return a.shouldOverrideUrlLoading(getLockedView(view, true), url);
	   }
	   return false;
   }

   public void onReceivedSslError(XWalkView view, ValueCallback<Boolean> callback, SslError error) {
      try {
         this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.invoke(view.getBridge(), callback, error);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }

   }

   public void onReceivedClientCertRequest(XWalkView view, ClientCertRequest handler) {
      try {
         this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.invoke(view.getBridge(), ((ClientCertRequestHandler)handler).getBridge());
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void onReceivedResponseHeaders(XWalkView view, XWalkWebResourceRequest request, XWalkWebResourceResponse response) {
      try {
         this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.invoke(view.getBridge(), ((XWalkWebResourceRequestHandler)request).getBridge(), response.getBridge());
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }

   }

   public void doUpdateVisitedHistory(XWalkView view, String url, boolean isReload) {
//      try {
//         this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.invoke(view.getBridge(), url, isReload);
//      } catch (UnsupportedOperationException var5) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         }
//
//         XWalkCoreWrapper.handleRuntimeError(var5);
//      }
	   if(a!=null) {
	   		a.doUpdateVisitedHistory(getLockedView(view, true), url, isReload);
	   }
   }

   public void onReceivedHttpAuthRequest(XWalkView view, XWalkHttpAuthHandler handler, String host, String realm) {
      try {
         this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.invoke(view.getBridge(), handler.getBridge(), host, realm);
      } catch (UnsupportedOperationException var6) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var6);
      }

   }

   public XWalkWebResourceResponse createXWalkWebResourceResponse(String mimeType, String encoding, InputStream data) {
      try {
         return (XWalkWebResourceResponse)this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamMethod.invoke(mimeType, encoding, data));
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var5);
            return null;
         }
      }
   }

   public XWalkWebResourceResponse createXWalkWebResourceResponse(String mimeType, String encoding, InputStream data, int statusCode, String reasonPhrase, Map<String, String> responseHeaders) {
      try {
         return (XWalkWebResourceResponse)this.coreWrapper.getWrapperObject(this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.invoke(mimeType, encoding, data, statusCode, reasonPhrase, responseHeaders));
      } catch (UnsupportedOperationException var8) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var8);
            return null;
         }
      }
   }
	
	
	private XWalkWebResourceResponse createXWalkWebResourceResponse(WebResourceResponse resourceResponse) {
		if(resourceResponse==null) {
			return null;
		}
   		return createXWalkWebResourceResponse(resourceResponse.getMimeType(), resourceResponse.getEncoding(), resourceResponse.getData());
	}
	
   void reflectionInit() {
      XWalkCoreWrapper.initEmbeddedMode();
      this.coreWrapper = XWalkCoreWrapper.getInstance();
      if (this.coreWrapper == null) {
         XWalkCoreWrapper.reserveReflectObject(this);
      } else {
         int length = this.constructorTypes.size();
         Class<?>[] paramTypes = new Class[length + 1];

         for(int i = 0; i < length; ++i) {
            Object type = this.constructorTypes.get(i);
            if (type instanceof String) {
               paramTypes[i] = this.coreWrapper.getBridgeClass((String)type);
               this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
            } else if (type instanceof Class) {
               paramTypes[i] = (Class)type;
            } else {
               assert false;
            }
         }

         paramTypes[length] = Object.class;
         this.constructorParams.add(this);
         ReflectConstructor constructor = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkResourceClientBridge"), paramTypes);

         try {
            this.bridge = constructor.newInstance(this.constructorParams.toArray());
         } catch (UnsupportedOperationException var5) {
            return;
         }

         if (this.postWrapperMethod != null) {
            this.postWrapperMethod.invoke();
         }

         this.onDocumentLoadedInFrameXWalkViewInternallongMethod.init(this.bridge, (Class)null, "onDocumentLoadedInFrameSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Long.TYPE);
         this.onLoadStartedXWalkViewInternalStringMethod.init(this.bridge, (Class)null, "onLoadStartedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
         this.onLoadFinishedXWalkViewInternalStringMethod.init(this.bridge, (Class)null, "onLoadFinishedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
         this.onProgressChangedXWalkViewInternalintMethod.init(this.bridge, (Class)null, "onProgressChangedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE);
         this.shouldInterceptLoadRequestXWalkViewInternalStringMethod.init(this.bridge, (Class)null, "shouldInterceptLoadRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
         this.shouldInterceptLoadRequestXWalkViewInternalXWalkWebResourceRequestInternalMethod.init(this.bridge, (Class)null, "shouldInterceptLoadRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge"));
         this.onReceivedLoadErrorXWalkViewInternalintStringStringMethod.init(this.bridge, (Class)null, "onReceivedLoadErrorSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Integer.TYPE, String.class, String.class);
         this.shouldOverrideUrlLoadingXWalkViewInternalStringMethod.init(this.bridge, (Class)null, "shouldOverrideUrlLoadingSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
         this.onReceivedSslErrorXWalkViewInternalValueCallbackSslErrorMethod.init(this.bridge, (Class)null, "onReceivedSslErrorSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, SslError.class);
         this.onReceivedClientCertRequestXWalkViewInternalClientCertRequestInternalMethod.init(this.bridge, (Class)null, "onReceivedClientCertRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("ClientCertRequestHandlerBridge"));
         this.onReceivedResponseHeadersXWalkViewInternalXWalkWebResourceRequestInternalXWalkWebResourceResponseInternalMethod.init(this.bridge, (Class)null, "onReceivedResponseHeadersSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceRequestHandlerBridge"), this.coreWrapper.getBridgeClass("XWalkWebResourceResponseBridge"));
         this.doUpdateVisitedHistoryXWalkViewInternalStringbooleanMethod.init(this.bridge, (Class)null, "doUpdateVisitedHistorySuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Boolean.TYPE);
         this.onReceivedHttpAuthRequestXWalkViewInternalXWalkHttpAuthHandlerInternalStringStringMethod.init(this.bridge, (Class)null, "onReceivedHttpAuthRequestSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkHttpAuthHandlerBridge"), String.class, String.class);
         this.createXWalkWebResourceResponseStringStringInputStreamMethod.init(this.bridge, (Class)null, "createXWalkWebResourceResponseSuper", String.class, String.class, InputStream.class);
         this.createXWalkWebResourceResponseStringStringInputStreamintStringMapMethod.init(this.bridge, (Class)null, "createXWalkWebResourceResponseSuper", String.class, String.class, InputStream.class, Integer.TYPE, String.class, Map.class);
      }
   }
}
