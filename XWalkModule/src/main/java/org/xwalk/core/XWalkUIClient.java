package org.xwalk.core;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebViewClient;

import java.util.ArrayList;

import static org.xwalk.core.Utils.Log;
import static org.xwalk.core.Utils.getLockedView;
import static org.xwalk.core.Utils.unlock;

public class XWalkUIClient {
	private WebViewClient a;
	private WebChromeClient b;
	private final XWalkView webView;
   private ArrayList<Object> constructorTypes = new ArrayList();
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private ReflectMethod enumJavascriptMessageTypeClassValueOfMethod = new ReflectMethod();
   private ReflectMethod enumConsoleMessageTypeClassValueOfMethod = new ReflectMethod();
   private ReflectMethod enumInitiateByClassValueOfMethod = new ReflectMethod();
   private ReflectMethod enumLoadStatusClassValueOfMethod = new ReflectMethod();
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod = new ReflectMethod((Class)null, "onCreateWindowRequested", new Class[0]);
   private ReflectMethod onIconAvailableXWalkViewInternalStringMessageMethod = new ReflectMethod((Class)null, "onIconAvailable", new Class[0]);
   private ReflectMethod onReceivedIconXWalkViewInternalStringBitmapMethod = new ReflectMethod((Class)null, "onReceivedIcon", new Class[0]);
   private ReflectMethod onRequestFocusXWalkViewInternalMethod = new ReflectMethod((Class)null, "onRequestFocus", new Class[0]);
   private ReflectMethod onJavascriptCloseWindowXWalkViewInternalMethod = new ReflectMethod((Class)null, "onJavascriptCloseWindow", new Class[0]);
   private ReflectMethod onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod((Class)null, "onJavascriptModalDialog", new Class[0]);
   private ReflectMethod onFullscreenToggledXWalkViewInternalbooleanMethod = new ReflectMethod((Class)null, "onFullscreenToggled", new Class[0]);
   private ReflectMethod openFileChooserXWalkViewInternalValueCallbackStringStringMethod = new ReflectMethod((Class)null, "openFileChooser", new Class[0]);
   private ReflectMethod onScaleChangedXWalkViewInternalfloatfloatMethod = new ReflectMethod((Class)null, "onScaleChanged", new Class[0]);
   private ReflectMethod shouldOverrideKeyEventXWalkViewInternalKeyEventMethod = new ReflectMethod((Class)null, "shouldOverrideKeyEvent", new Class[0]);
   private ReflectMethod onUnhandledKeyEventXWalkViewInternalKeyEventMethod = new ReflectMethod((Class)null, "onUnhandledKeyEvent", new Class[0]);
   private ReflectMethod onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod = new ReflectMethod((Class)null, "onConsoleMessage", new Class[0]);
   private ReflectMethod onReceivedTitleXWalkViewInternalStringMethod = new ReflectMethod((Class)null, "onReceivedTitle", new Class[0]);
   private ReflectMethod onPageLoadStartedXWalkViewInternalStringMethod = new ReflectMethod((Class)null, "onPageLoadStarted", new Class[0]);
   private ReflectMethod onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod = new ReflectMethod((Class)null, "onPageLoadStopped", new Class[0]);
   private ReflectMethod onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod((Class)null, "onJsAlert", new Class[0]);
   private ReflectMethod onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod((Class)null, "onJsConfirm", new Class[0]);
   private ReflectMethod onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod = new ReflectMethod((Class)null, "onJsPrompt", new Class[0]);
   private ReflectMethod onShowCustomViewViewCustomViewCallbackInternalMethod = new ReflectMethod((Class)null, "onShowCustomView", new Class[0]);
   private ReflectMethod onShowCustomViewViewintCustomViewCallbackInternalMethod = new ReflectMethod((Class)null, "onShowCustomView", new Class[0]);
   private ReflectMethod onHideCustomViewMethod = new ReflectMethod((Class)null, "onHideCustomView", new Class[0]);

   private Object ConvertJavascriptMessageType(XWalkUIClient.JavascriptMessageType type) {
      return this.enumJavascriptMessageTypeClassValueOfMethod.invoke(type.toString());
   }

   private Object ConvertConsoleMessageType(XWalkUIClient.ConsoleMessageType type) {
      return this.enumConsoleMessageTypeClassValueOfMethod.invoke(type.toString());
   }

   private Object ConvertInitiateBy(XWalkUIClient.InitiateBy type) {
      return this.enumInitiateByClassValueOfMethod.invoke(type.toString());
   }

   private Object ConvertLoadStatus(XWalkUIClient.LoadStatus type) {
      return this.enumLoadStatusClassValueOfMethod.invoke(type.toString());
   }

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkUIClient(XWalkView view, WebViewClient a, WebChromeClient b) {
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
	
   public boolean onCreateWindowRequested(XWalkView view, XWalkUIClient.InitiateBy initiator, ValueCallback<XWalkView> callback) {
      try {
         return (Boolean)this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.invoke(view.getBridge(), this.ConvertInitiateBy(initiator), callback);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var5);
            return false;
         }
      }
   }

   public void onIconAvailable(XWalkView view, String url, Message startDownload) {
      try {
         this.onIconAvailableXWalkViewInternalStringMessageMethod.invoke(view.getBridge(), url, startDownload);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }

   }

   public void onReceivedIcon(XWalkView view, String url, Bitmap icon) {
      try {
         this.onReceivedIconXWalkViewInternalStringBitmapMethod.invoke(view.getBridge(), url, icon);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }
	   if(b!=null) {
		   b.onReceivedIcon(getLockedView(view, true), icon);
		   unlock();
	   }
   }

   public void onRequestFocus(XWalkView view) {
      try {
         this.onRequestFocusXWalkViewInternalMethod.invoke(view.getBridge());
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void onJavascriptCloseWindow(XWalkView view) {
      try {
         this.onJavascriptCloseWindowXWalkViewInternalMethod.invoke(view.getBridge());
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean onJavascriptModalDialog(XWalkView view, XWalkUIClient.JavascriptMessageType type, String url, String message, String defaultValue, XWalkJavascriptResult result) {
      try {
         return (Boolean)this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(view.getBridge(), this.ConvertJavascriptMessageType(type), url, message, defaultValue, ((XWalkJavascriptResultHandler)result).getBridge());
      } catch (UnsupportedOperationException var8) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var8);
            return false;
         }
      }
   }

   public void onFullscreenToggled(XWalkView view, boolean enterFullscreen) {
      try {
         this.onFullscreenToggledXWalkViewInternalbooleanMethod.invoke(view.getBridge(), enterFullscreen);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void openFileChooser(XWalkView view, ValueCallback<Uri> uploadFile, String acceptType, String capture) {
      try {
         this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.invoke(view.getBridge(), uploadFile, acceptType, capture);
      } catch (UnsupportedOperationException var6) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var6);
      }

   }

   public void onScaleChanged(XWalkView view, float oldScale, float newScale) {
      try {
         this.onScaleChangedXWalkViewInternalfloatfloatMethod.invoke(view.getBridge(), oldScale, newScale);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }
	   if(a!=null) {
		   a.onScaleChanged(getLockedView(view, true), oldScale, newScale);
		   unlock();
	   }
   }

   public boolean shouldOverrideKeyEvent(XWalkView view, KeyEvent event) {
      try {
         return (Boolean)this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.invoke(view.getBridge(), event);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var4);
            return false;
         }
      }
   }

   public void onUnhandledKeyEvent(XWalkView view, KeyEvent event) {
      try {
         this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.invoke(view.getBridge(), event);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public boolean onConsoleMessage(XWalkView view, String message, int lineNumber, String sourceId, XWalkUIClient.ConsoleMessageType messageType) {
      try {
         return (Boolean)this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.invoke(view.getBridge(), message, lineNumber, sourceId, this.ConvertConsoleMessageType(messageType));
      } catch (UnsupportedOperationException var7) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var7);
            return false;
         }
      }
   }

   public void onReceivedTitle(XWalkView view, String title) {
      try {
         this.onReceivedTitleXWalkViewInternalStringMethod.invoke(view.getBridge(), title);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }
	   if(b!=null) {
		   b.onReceivedTitle(getLockedView(view, true), title);
		   unlock();
	   }
   }

   public void onPageLoadStarted(XWalkView view, String url) {
//      try {
//         this.onPageLoadStartedXWalkViewInternalStringMethod.invoke(view.getBridge(), url);
//      } catch (UnsupportedOperationException var4) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         }
//
//         XWalkCoreWrapper.handleRuntimeError(var4);
//      }
	   if(a!=null) {
		   a.onPageStarted(getLockedView(webView, true), url, null);
		   unlock();
	   }
   }

   public void onPageLoadStopped(XWalkView view, String url, XWalkUIClient.LoadStatus status) {
//      try {
//         this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.invoke(view.getBridge(), url, this.ConvertLoadStatus(status));
//      } catch (UnsupportedOperationException var5) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         }
//
//         XWalkCoreWrapper.handleRuntimeError(var5);
//      }
//
	   if(a!=null) {
		   a.onPageFinished(getLockedView(webView, true), url);
		   unlock();
	   }
   }

   public boolean onJsAlert(XWalkView view, String url, String message, XWalkJavascriptResult result) {
      try {
         return (Boolean)this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(view.getBridge(), url, message, ((XWalkJavascriptResultHandler)result).getBridge());
      } catch (UnsupportedOperationException var6) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var6);
            return false;
         }
      }
   }

   public boolean onJsConfirm(XWalkView view, String url, String message, XWalkJavascriptResult result) {
      try {
         return (Boolean)this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.invoke(view.getBridge(), url, message, ((XWalkJavascriptResultHandler)result).getBridge());
      } catch (UnsupportedOperationException var6) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var6);
            return false;
         }
      }
   }

   public boolean onJsPrompt(XWalkView view, String url, String message, String defaultValue, XWalkJavascriptResult result) {
      try {
         return (Boolean)this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.invoke(view.getBridge(), url, message, defaultValue, ((XWalkJavascriptResultHandler)result).getBridge());
      } catch (UnsupportedOperationException var7) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var7);
            return false;
         }
      }
   }

   public void onShowCustomView(View view, CustomViewCallback callback) {
//      try {
//         this.onShowCustomViewViewCustomViewCallbackInternalMethod.invoke(view, ((CustomViewCallbackHandler)callback).getBridge());
//      } catch (UnsupportedOperationException var4) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         }
//
//         XWalkCoreWrapper.handleRuntimeError(var4);
//      }
	   if(b!=null) {
		   b.onShowCustomView(view, callback);
	   }
   }

   public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) {
//      try {
//         this.onShowCustomViewViewintCustomViewCallbackInternalMethod.invoke(view, requestedOrientation, ((CustomViewCallbackHandler)callback).getBridge());
//      } catch (UnsupportedOperationException var5) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         }
//
//         XWalkCoreWrapper.handleRuntimeError(var5);
//      }
		//www
	   if(b!=null) {
		   b.onShowCustomView(view, callback);
	   }
   }

   public void onHideCustomView() {
//      try {
//         this.onHideCustomViewMethod.invoke();
//      } catch (UnsupportedOperationException var2) {
//         if (this.coreWrapper == null) {
//            throw new RuntimeException("Crosswalk's APIs are not ready yet");
//         }
//
//         XWalkCoreWrapper.handleRuntimeError(var2);
//      }
	   if(b!=null) {
		   b.onHideCustomView();
	   }
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
         ReflectConstructor constructor = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkUIClientBridge"), paramTypes);

         try {
            this.bridge = constructor.newInstance(this.constructorParams.toArray());
         } catch (UnsupportedOperationException var5) {
            return;
         }

         if (this.postWrapperMethod != null) {
            this.postWrapperMethod.invoke();
         }

         this.enumJavascriptMessageTypeClassValueOfMethod.init((Object)null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), "valueOf", String.class);
         this.enumConsoleMessageTypeClassValueOfMethod.init((Object)null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType"), "valueOf", String.class);
         this.enumInitiateByClassValueOfMethod.init((Object)null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), "valueOf", String.class);
         this.enumLoadStatusClassValueOfMethod.init((Object)null, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal"), "valueOf", String.class);
         this.onCreateWindowRequestedXWalkViewInternalInitiateByInternalValueCallbackMethod.init(this.bridge, (Class)null, "onCreateWindowRequestedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$InitiateByInternal"), ValueCallback.class);
         this.onIconAvailableXWalkViewInternalStringMessageMethod.init(this.bridge, (Class)null, "onIconAvailableSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Message.class);
         this.onReceivedIconXWalkViewInternalStringBitmapMethod.init(this.bridge, (Class)null, "onReceivedIconSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Bitmap.class);
         this.onRequestFocusXWalkViewInternalMethod.init(this.bridge, (Class)null, "onRequestFocusSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"));
         this.onJavascriptCloseWindowXWalkViewInternalMethod.init(this.bridge, (Class)null, "onJavascriptCloseWindowSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"));
         this.onJavascriptModalDialogXWalkViewInternalJavascriptMessageTypeInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, (Class)null, "onJavascriptModalDialogSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), this.coreWrapper.getBridgeClass("XWalkUIClientInternal$JavascriptMessageTypeInternal"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
         this.onFullscreenToggledXWalkViewInternalbooleanMethod.init(this.bridge, (Class)null, "onFullscreenToggledSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Boolean.TYPE);
         this.openFileChooserXWalkViewInternalValueCallbackStringStringMethod.init(this.bridge, (Class)null, "openFileChooserSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), ValueCallback.class, String.class, String.class);
         this.onScaleChangedXWalkViewInternalfloatfloatMethod.init(this.bridge, (Class)null, "onScaleChangedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), Float.TYPE, Float.TYPE);
         this.shouldOverrideKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, (Class)null, "shouldOverrideKeyEventSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class);
         this.onUnhandledKeyEventXWalkViewInternalKeyEventMethod.init(this.bridge, (Class)null, "onUnhandledKeyEventSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), KeyEvent.class);
         this.onConsoleMessageXWalkViewInternalStringintStringConsoleMessageTypeMethod.init(this.bridge, (Class)null, "onConsoleMessageSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, Integer.TYPE, String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$ConsoleMessageType"));
         this.onReceivedTitleXWalkViewInternalStringMethod.init(this.bridge, (Class)null, "onReceivedTitleSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
         this.onPageLoadStartedXWalkViewInternalStringMethod.init(this.bridge, (Class)null, "onPageLoadStartedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class);
         this.onPageLoadStoppedXWalkViewInternalStringLoadStatusInternalMethod.init(this.bridge, (Class)null, "onPageLoadStoppedSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, this.coreWrapper.getBridgeClass("XWalkUIClientInternal$LoadStatusInternal"));
         this.onJsAlertXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, (Class)null, "onJsAlertSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
         this.onJsConfirmXWalkViewInternalStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, (Class)null, "onJsConfirmSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
         this.onJsPromptXWalkViewInternalStringStringStringXWalkJavascriptResultInternalMethod.init(this.bridge, (Class)null, "onJsPromptSuper", this.coreWrapper.getBridgeClass("XWalkViewBridge"), String.class, String.class, String.class, this.coreWrapper.getBridgeClass("XWalkJavascriptResultHandlerBridge"));
         this.onShowCustomViewViewCustomViewCallbackInternalMethod.init(this.bridge, (Class)null, "onShowCustomViewSuper", View.class, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge"));
         this.onShowCustomViewViewintCustomViewCallbackInternalMethod.init(this.bridge, (Class)null, "onShowCustomViewSuper", View.class, Integer.TYPE, this.coreWrapper.getBridgeClass("CustomViewCallbackHandlerBridge"));
         this.onHideCustomViewMethod.init(this.bridge, (Class)null, "onHideCustomViewSuper");
      }
   }

   public static enum LoadStatus {
      FINISHED,
      FAILED,
      CANCELLED;
   }

   public static enum InitiateBy {
      BY_USER_GESTURE,
      BY_JAVASCRIPT;
   }

   public static enum ConsoleMessageType {
      DEBUG,
      ERROR,
      LOG,
      INFO,
      WARNING;
   }

   public static enum JavascriptMessageType {
      JAVASCRIPT_ALERT,
      JAVASCRIPT_CONFIRM,
      JAVASCRIPT_PROMPT,
      JAVASCRIPT_BEFOREUNLOAD;
   }
}
