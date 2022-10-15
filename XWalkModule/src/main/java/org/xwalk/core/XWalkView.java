package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Map;
import org.xwalk.core.extension.XWalkExternalExtensionManagerImpl;

public class XWalkView extends FrameLayout {
   public static final int RELOAD_NORMAL = 0;
   public static final int RELOAD_IGNORE_CACHE = 1;
   public static final String SURFACE_VIEW = "SurfaceView";
   public static final String TEXTURE_VIEW = "TextureView";
	public XWalkWebResourceRequest wrr;
	private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private String mAnimatable;
   private static final String ANIMATABLE = "animatable";
   private static final String XWALK_ATTRS_NAMESPACE = "http://schemas.android.com/apk/res-auto";
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod loadStringStringMethod = new ReflectMethod((Class)null, "load", new Class[0]);
   private ReflectMethod loadStringStringMapMethod = new ReflectMethod((Class)null, "load", new Class[0]);
   private ReflectMethod loadDataStringStringStringMethod = new ReflectMethod((Class)null, "loadData", new Class[0]);
   private ReflectMethod loadDataWithBaseURLStringStringStringStringStringMethod = new ReflectMethod((Class)null, "loadDataWithBaseURL", new Class[0]);
   private ReflectMethod loadUrlStringMethod = new ReflectMethod((Class)null, "loadUrl", new Class[0]);
   private ReflectMethod loadUrlStringMapMethod = new ReflectMethod((Class)null, "loadUrl", new Class[0]);
   private ReflectMethod loadAppFromManifestStringStringMethod = new ReflectMethod((Class)null, "loadAppFromManifest", new Class[0]);
   private ReflectMethod reloadintMethod = new ReflectMethod((Class)null, "reload", new Class[0]);
   private ReflectMethod stopLoadingMethod = new ReflectMethod((Class)null, "stopLoading", new Class[0]);
   private ReflectMethod getUrlMethod = new ReflectMethod((Class)null, "getUrl", new Class[0]);
   private ReflectMethod getHitTestResultMethod = new ReflectMethod((Class)null, "getHitTestResult", new Class[0]);
   private ReflectMethod getContentHeightMethod = new ReflectMethod((Class)null, "getContentHeight", new Class[0]);
   private ReflectMethod getTitleMethod = new ReflectMethod((Class)null, "getTitle", new Class[0]);
   private ReflectMethod getOriginalUrlMethod = new ReflectMethod((Class)null, "getOriginalUrl", new Class[0]);
   private ReflectMethod getNavigationHistoryMethod = new ReflectMethod((Class)null, "getNavigationHistory", new Class[0]);
   private ReflectMethod addJavascriptInterfaceObjectStringMethod = new ReflectMethod((Class)null, "addJavascriptInterface", new Class[0]);
   private ReflectMethod removeJavascriptInterfaceStringMethod = new ReflectMethod((Class)null, "removeJavascriptInterface", new Class[0]);
   private ReflectMethod evaluateJavascriptStringValueCallbackMethod = new ReflectMethod((Class)null, "evaluateJavascript", new Class[0]);
   private ReflectMethod clearCachebooleanMethod = new ReflectMethod((Class)null, "clearCache", new Class[0]);
   private ReflectMethod clearCacheForSingleFileStringMethod = new ReflectMethod((Class)null, "clearCacheForSingleFile", new Class[0]);
   private ReflectMethod hasEnteredFullscreenMethod = new ReflectMethod((Class)null, "hasEnteredFullscreen", new Class[0]);
   private ReflectMethod leaveFullscreenMethod = new ReflectMethod((Class)null, "leaveFullscreen", new Class[0]);
   private ReflectMethod pauseTimersMethod = new ReflectMethod((Class)null, "pauseTimers", new Class[0]);
   private ReflectMethod resumeTimersMethod = new ReflectMethod((Class)null, "resumeTimers", new Class[0]);
   private ReflectMethod onHideMethod = new ReflectMethod((Class)null, "onHide", new Class[0]);
   private ReflectMethod onShowMethod = new ReflectMethod((Class)null, "onShow", new Class[0]);
   private ReflectMethod onDestroyMethod = new ReflectMethod((Class)null, "onDestroy", new Class[0]);
   private ReflectMethod startActivityForResultIntentintBundleMethod = new ReflectMethod((Class)null, "startActivityForResult", new Class[0]);
   private ReflectMethod onActivityResultintintIntentMethod = new ReflectMethod((Class)null, "onActivityResult", new Class[0]);
   private ReflectMethod onNewIntentIntentMethod = new ReflectMethod((Class)null, "onNewIntent", new Class[0]);
   private ReflectMethod saveStateBundleMethod = new ReflectMethod((Class)null, "saveState", new Class[0]);
   private ReflectMethod restoreStateBundleMethod = new ReflectMethod((Class)null, "restoreState", new Class[0]);
   private ReflectMethod getAPIVersionMethod = new ReflectMethod((Class)null, "getAPIVersion", new Class[0]);
   private ReflectMethod getXWalkVersionMethod = new ReflectMethod((Class)null, "getXWalkVersion", new Class[0]);
   private ReflectMethod setUIClientXWalkUIClientInternalMethod = new ReflectMethod((Class)null, "setUIClient", new Class[0]);
   private ReflectMethod setResourceClientXWalkResourceClientInternalMethod = new ReflectMethod((Class)null, "setResourceClient", new Class[0]);
   private ReflectMethod setBackgroundColorintMethod = new ReflectMethod((Class)null, "setBackgroundColor", new Class[0]);
   private ReflectMethod setOriginAccessWhitelistStringStringArrayMethod = new ReflectMethod((Class)null, "setOriginAccessWhitelist", new Class[0]);
   private ReflectMethod setUserAgentStringStringMethod = new ReflectMethod((Class)null, "setUserAgentString", new Class[0]);
   private ReflectMethod getUserAgentStringMethod = new ReflectMethod((Class)null, "getUserAgentString", new Class[0]);
   private ReflectMethod setAcceptLanguagesStringMethod = new ReflectMethod((Class)null, "setAcceptLanguages", new Class[0]);
   private ReflectMethod captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod = new ReflectMethod((Class)null, "captureBitmapAsync", new Class[0]);
   private ReflectMethod getSettingsMethod = new ReflectMethod((Class)null, "getSettings", new Class[0]);
   private ReflectMethod setNetworkAvailablebooleanMethod = new ReflectMethod((Class)null, "setNetworkAvailable", new Class[0]);
   private ReflectMethod getRemoteDebuggingUrlMethod = new ReflectMethod((Class)null, "getRemoteDebuggingUrl", new Class[0]);
   private ReflectMethod zoomInMethod = new ReflectMethod((Class)null, "zoomIn", new Class[0]);
   private ReflectMethod zoomOutMethod = new ReflectMethod((Class)null, "zoomOut", new Class[0]);
   private ReflectMethod zoomByfloatMethod = new ReflectMethod((Class)null, "zoomBy", new Class[0]);
   private ReflectMethod canZoomInMethod = new ReflectMethod((Class)null, "canZoomIn", new Class[0]);
   private ReflectMethod canZoomOutMethod = new ReflectMethod((Class)null, "canZoomOut", new Class[0]);
   private ReflectMethod onCreateInputConnectionEditorInfoMethod = new ReflectMethod((Class)null, "onCreateInputConnection", new Class[0]);
   private ReflectMethod setInitialScaleintMethod = new ReflectMethod((Class)null, "setInitialScale", new Class[0]);
   private ReflectMethod getFaviconMethod = new ReflectMethod((Class)null, "getFavicon", new Class[0]);
   private ReflectMethod setZOrderOnTopbooleanMethod = new ReflectMethod((Class)null, "setZOrderOnTop", new Class[0]);
   private ReflectMethod clearFormDataMethod = new ReflectMethod((Class)null, "clearFormData", new Class[0]);
   private ReflectMethod setSurfaceViewVisibilityintMethod = new ReflectMethod((Class)null, "setSurfaceViewVisibility", new Class[0]);
   private ReflectMethod setXWalkViewInternalVisibilityintMethod = new ReflectMethod((Class)null, "setXWalkViewInternalVisibility", new Class[0]);
   private ReflectMethod setDownloadListenerXWalkDownloadListenerInternalMethod = new ReflectMethod((Class)null, "setDownloadListener", new Class[0]);
   private ReflectMethod onTouchEventMotionEventMethod = new ReflectMethod((Class)null, "onTouchEvent", new Class[0]);
   private ReflectMethod setOnTouchListenerOnTouchListenerMethod = new ReflectMethod((Class)null, "setOnTouchListener", new Class[0]);
   private ReflectMethod scrollTointintMethod = new ReflectMethod((Class)null, "scrollTo", new Class[0]);
   private ReflectMethod scrollByintintMethod = new ReflectMethod((Class)null, "scrollBy", new Class[0]);
   private ReflectMethod computeHorizontalScrollRangeMethod = new ReflectMethod((Class)null, "computeHorizontalScrollRange", new Class[0]);
   private ReflectMethod computeHorizontalScrollOffsetMethod = new ReflectMethod((Class)null, "computeHorizontalScrollOffset", new Class[0]);
   private ReflectMethod computeVerticalScrollRangeMethod = new ReflectMethod((Class)null, "computeVerticalScrollRange", new Class[0]);
   private ReflectMethod computeVerticalScrollOffsetMethod = new ReflectMethod((Class)null, "computeVerticalScrollOffset", new Class[0]);
   private ReflectMethod computeVerticalScrollExtentMethod = new ReflectMethod((Class)null, "computeVerticalScrollExtent", new Class[0]);
   private ReflectMethod getExtensionManagerMethod = new ReflectMethod((Class)null, "getExtensionManager", new Class[0]);
   private ReflectMethod clearSslPreferencesMethod = new ReflectMethod((Class)null, "clearSslPreferences", new Class[0]);
   private ReflectMethod clearClientCertPreferencesRunnableMethod = new ReflectMethod((Class)null, "clearClientCertPreferences", new Class[0]);
   private ReflectMethod getCertificateMethod = new ReflectMethod((Class)null, "getCertificate", new Class[0]);
   private ReflectMethod setFindListenerXWalkFindListenerInternalMethod = new ReflectMethod((Class)null, "setFindListener", new Class[0]);
   private ReflectMethod findAllAsyncStringMethod = new ReflectMethod((Class)null, "findAllAsync", new Class[0]);
   private ReflectMethod findNextbooleanMethod = new ReflectMethod((Class)null, "findNext", new Class[0]);
   private ReflectMethod clearMatchesMethod = new ReflectMethod((Class)null, "clearMatches", new Class[0]);
   private ReflectMethod getCompositingSurfaceTypeMethod = new ReflectMethod((Class)null, "getCompositingSurfaceType", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkView(Context context) {
      super(context, (AttributeSet)null);
      SurfaceView surfaceView = new SurfaceView(context);
      surfaceView.setLayoutParams(new LayoutParams(0, 0));
      this.addView(surfaceView);
      this.constructorTypes = new ArrayList();
      this.constructorTypes.add(Context.class);
      this.constructorParams = new ArrayList();
      this.constructorParams.add(context);
      this.postWrapperMethod = new ReflectMethod(this, "postXWalkViewInternalContextConstructor", new Class[0]);
      this.reflectionInit();
   }

   public void postXWalkViewInternalContextConstructor() {
      this.addView((FrameLayout)this.bridge, new android.widget.FrameLayout.LayoutParams(-1, -1));
      this.removeViewAt(0);
      new XWalkExternalExtensionManagerImpl(this);
   }

   public XWalkView(Context context, AttributeSet attrs) {
      super(context, attrs);
      if (!this.isInEditMode()) {
         if (attrs != null) {
            this.mAnimatable = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto", "animatable");
         }

         SurfaceView surfaceView = new SurfaceView(context);
         surfaceView.setLayoutParams(new LayoutParams(0, 0));
         this.addView(surfaceView);
         this.constructorTypes = new ArrayList();
         this.constructorTypes.add(Context.class);
         this.constructorTypes.add(AttributeSet.class);
         this.constructorParams = new ArrayList();
         this.constructorParams.add(context);
         this.constructorParams.add(attrs);
         this.postWrapperMethod = new ReflectMethod(this, "postXWalkViewInternalContextAttributeSetConstructor", new Class[0]);
         this.reflectionInit();
      }
   }

   public void postXWalkViewInternalContextAttributeSetConstructor() {
      this.addView((FrameLayout)this.bridge, new android.widget.FrameLayout.LayoutParams(-1, -1));
      this.removeViewAt(0);
      new XWalkExternalExtensionManagerImpl(this);
   }

   /** @deprecated */
   @Deprecated
   public XWalkView(Context context, Activity activity) {
      super(context, (AttributeSet)null);
      SurfaceView surfaceView = new SurfaceView(context);
      surfaceView.setLayoutParams(new LayoutParams(0, 0));
      this.addView(surfaceView);
      this.constructorTypes = new ArrayList();
      this.constructorTypes.add(Context.class);
      this.constructorTypes.add(Activity.class);
      this.constructorParams = new ArrayList();
      this.constructorParams.add(context);
      this.constructorParams.add(activity);
      this.postWrapperMethod = new ReflectMethod(this, "postXWalkViewInternalContextActivityConstructor", new Class[0]);
      this.reflectionInit();
   }

   public void postXWalkViewInternalContextActivityConstructor() {
      this.addView((FrameLayout)this.bridge, new android.widget.FrameLayout.LayoutParams(-1, -1));
      this.removeViewAt(0);
      new XWalkExternalExtensionManagerImpl(this);
   }

   /** @deprecated */
   @Deprecated
   public void load(String url, String content) {
      try {
         this.loadStringStringMethod.invoke(url, content);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   /** @deprecated */
   @Deprecated
   public void load(String url, String content, Map<String, String> headers) {
      try {
         this.loadStringStringMapMethod.invoke(url, content, headers);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }

   }

   public void loadData(String data, String mimeType, String encoding) {
      try {
         this.loadDataStringStringStringMethod.invoke(data, mimeType, encoding);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }

   }

   public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
      try {
         this.loadDataWithBaseURLStringStringStringStringStringMethod.invoke(baseUrl, data, mimeType, encoding, historyUrl);
      } catch (UnsupportedOperationException var7) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var7);
      }

   }

   public void loadUrl(String url) {
      try {
         this.loadUrlStringMethod.invoke(url);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void loadUrl(String url, Map<String, String> additionalHttpHeaders) {
      try {
         this.loadUrlStringMapMethod.invoke(url, additionalHttpHeaders);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void loadAppFromManifest(String url, String content) {
      try {
         this.loadAppFromManifestStringStringMethod.invoke(url, content);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void reload(int mode) {
      try {
         this.reloadintMethod.invoke(mode);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void stopLoading() {
      try {
         this.stopLoadingMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public String getUrl() {
      try {
         return (String)this.getUrlMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public XWalkHitTestResult getHitTestResult() {
      try {
         return (XWalkHitTestResult)this.coreWrapper.getWrapperObject(this.getHitTestResultMethod.invoke());
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public int getContentHeight() {
      try {
         return (Integer)this.getContentHeightMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public String getTitle() {
      try {
         return (String)this.getTitleMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public String getOriginalUrl() {
      try {
         return (String)this.getOriginalUrlMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public XWalkNavigationHistory getNavigationHistory() {
      try {
         return (XWalkNavigationHistory)this.coreWrapper.getWrapperObject(this.getNavigationHistoryMethod.invoke());
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }
	
	public WebBackForwardList copyBackForwardList() {
		XWalkNavigationHistory inner = getNavigationHistory();
		return inner==null?null:new BackForwardList(inner);
	}
	
	public static class HistoryItem extends android.webkit.WebHistoryItem{
		final XWalkNavigationItem a;
		
		public HistoryItem(XWalkNavigationItem a) {
			this.a = a;
		}
		
		@Override
		public String getUrl() {
			return a.getUrl();
		}
		
		@Override
		public String getOriginalUrl() {
			return a.getOriginalUrl();
		}
		
		@Override
		public String getTitle() {
			return a.getTitle();
		}
		
		@Nullable
		@Override
		public Bitmap getFavicon() {
			return null;
		}
		
		@Override
		protected WebHistoryItem clone() {
			return new HistoryItem(a);
		}
	}
	
	public static class BackForwardList extends android.webkit.WebBackForwardList{
		final XWalkNavigationHistory a;
		
		BackForwardList(XWalkNavigationHistory a) {
			this.a = a;
		}
		
		@Nullable
		@Override
		public WebHistoryItem getCurrentItem() {
			return new HistoryItem(a.getCurrentItem());
		}
		
		@Override
		public int getCurrentIndex() {
			return a.getCurrentIndex();
		}
		
		@Override
		public WebHistoryItem getItemAtIndex(int index) {
			return new HistoryItem(a.getItemAt(index));
		}
		
		@Override
		public int getSize() {
			return a.size();
		}
		
		@Override
		protected WebBackForwardList clone() {
			return new BackForwardList(a);
		}
	}
	
   public void addJavascriptInterface(Object object, String name) {
      try {
         this.addJavascriptInterfaceObjectStringMethod.invoke(object, name);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            this.addJavascriptInterfaceObjectStringMethod.setArguments(object, name);
            XWalkCoreWrapper.reserveReflectMethod(this.addJavascriptInterfaceObjectStringMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var4);
         }
      }

   }

   public void removeJavascriptInterface(String name) {
      try {
         this.removeJavascriptInterfaceStringMethod.invoke(name);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            this.removeJavascriptInterfaceStringMethod.setArguments(name);
            XWalkCoreWrapper.reserveReflectMethod(this.removeJavascriptInterfaceStringMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }

   }

   public void evaluateJavascript(String script, ValueCallback<String> callback) {
      try {
         this.evaluateJavascriptStringValueCallbackMethod.invoke(script, callback);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void clearCache(boolean includeDiskFiles) {
      try {
         this.clearCachebooleanMethod.invoke(includeDiskFiles);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void clearCacheForSingleFile(String url) {
      try {
         this.clearCacheForSingleFileStringMethod.invoke(url);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean hasEnteredFullscreen() {
      try {
         return (Boolean)this.hasEnteredFullscreenMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void leaveFullscreen() {
      try {
         this.leaveFullscreenMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void pauseTimers() {
      try {
         this.pauseTimersMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void resumeTimers() {
      try {
         this.resumeTimersMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void onHide() {
      try {
         this.onHideMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void onShow() {
      try {
         this.onShowMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void onDestroy() {
      try {
         this.onDestroyMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   /** @deprecated */
   @Deprecated
   public void startActivityForResult(Intent intent, int requestCode, Bundle options) {
      try {
         this.startActivityForResultIntentintBundleMethod.invoke(intent, requestCode, options);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }

   }

   /** @deprecated */
   @Deprecated
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
      try {
         this.onActivityResultintintIntentMethod.invoke(requestCode, resultCode, data);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }

   }

   public boolean onNewIntent(Intent intent) {
      try {
         return (Boolean)this.onNewIntentIntentMethod.invoke(intent);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
            return false;
         }
      }
   }

   public WebBackForwardList saveState(Bundle outState) {
      try {
		  if((Boolean)this.saveStateBundleMethod.invoke(outState)) {
			  return copyBackForwardList();
		  }
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
            
         }
      }
	   return null;
   }

   public WebBackForwardList restoreState(Bundle inState) {
      try {
         if((Boolean)this.restoreStateBundleMethod.invoke(inState)) {
         	return copyBackForwardList();
		 }
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }
	   return null;
   }

   public String getAPIVersion() {
      try {
         return (String)this.getAPIVersionMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public String getXWalkVersion() {
      try {
         return (String)this.getXWalkVersionMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setUIClient(XWalkUIClient client) {
      try {
         this.setUIClientXWalkUIClientInternalMethod.invoke(client.getBridge());
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            this.setUIClientXWalkUIClientInternalMethod.setArguments(new ReflectMethod(client, "getBridge", new Class[0]));
            XWalkCoreWrapper.reserveReflectMethod(this.setUIClientXWalkUIClientInternalMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }

   }

   public void setResourceClient(XWalkResourceClient client) {
      try {
         this.setResourceClientXWalkResourceClientInternalMethod.invoke(client.getBridge());
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            this.setResourceClientXWalkResourceClientInternalMethod.setArguments(new ReflectMethod(client, "getBridge", new Class[0]));
            XWalkCoreWrapper.reserveReflectMethod(this.setResourceClientXWalkResourceClientInternalMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }

   }

   public void setBackgroundColor(int color) {
      try {
         this.setBackgroundColorintMethod.invoke(color);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void setOriginAccessWhitelist(String url, String[] patterns) {
      try {
         this.setOriginAccessWhitelistStringStringArrayMethod.invoke(url, patterns);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void setLayerType(int layerType, Paint paint) {
   }

   public void setUserAgentString(String userAgent) {
      try {
         this.setUserAgentStringStringMethod.invoke(userAgent);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public String getUserAgentString() {
      try {
         return (String)this.getUserAgentStringMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setAcceptLanguages(String acceptLanguages) {
      try {
         this.setAcceptLanguagesStringMethod.invoke(acceptLanguages);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void captureBitmapAsync(XWalkGetBitmapCallback callback) {
      try {
         this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.invoke(callback.getBridge());
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public android.webkit.WebSettings getSettings() {
      try {
         return new WebSettings((XWalkSettings)this.coreWrapper.getWrapperObject(this.getSettingsMethod.invoke()));
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setNetworkAvailable(boolean networkUp) {
      try {
         this.setNetworkAvailablebooleanMethod.invoke(networkUp);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public Uri getRemoteDebuggingUrl() {
      try {
         return (Uri)this.getRemoteDebuggingUrlMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public boolean zoomIn() {
      try {
         return (Boolean)this.zoomInMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public boolean zoomOut() {
      try {
         return (Boolean)this.zoomOutMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void zoomBy(float factor) {
      try {
         this.zoomByfloatMethod.invoke(factor);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean canZoomIn() {
      try {
         return (Boolean)this.canZoomInMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public boolean canZoomOut() {
      try {
         return (Boolean)this.canZoomOutMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public InputConnection onCreateInputConnection(EditorInfo outAttrs) {
      try {
         return (InputConnection)this.onCreateInputConnectionEditorInfoMethod.invoke(outAttrs);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
            return null;
         }
      }
   }

   public void setInitialScale(int scaleInPercent) {
      try {
         this.setInitialScaleintMethod.invoke(scaleInPercent);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public Bitmap getFavicon() {
      try {
         return (Bitmap)this.getFaviconMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setZOrderOnTop(boolean onTop) {
      try {
         this.setZOrderOnTopbooleanMethod.invoke(onTop);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void clearFormData()
   {
      try {
         this.clearFormDataMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void setVisibility(int visibility) {
      if (visibility == 4) {
         visibility = 8;
      }

      super.setVisibility(visibility);
      this.setXWalkViewInternalVisibility(visibility);
      this.setSurfaceViewVisibility(visibility);
   }

   public void setSurfaceViewVisibility(int visibility) {
      try {
         this.setSurfaceViewVisibilityintMethod.invoke(visibility);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            this.setSurfaceViewVisibilityintMethod.setArguments(visibility);
            XWalkCoreWrapper.reserveReflectMethod(this.setSurfaceViewVisibilityintMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }

   }

   public void setXWalkViewInternalVisibility(int visibility) {
      try {
         this.setXWalkViewInternalVisibilityintMethod.invoke(visibility);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            this.setXWalkViewInternalVisibilityintMethod.setArguments(visibility);
            XWalkCoreWrapper.reserveReflectMethod(this.setXWalkViewInternalVisibilityintMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }

   }

   public void setDownloadListener(XWalkDownloadListener listener) {
      try {
         this.setDownloadListenerXWalkDownloadListenerInternalMethod.invoke(listener.getBridge());
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            this.setDownloadListenerXWalkDownloadListenerInternalMethod.setArguments(new ReflectMethod(listener, "getBridge", new Class[0]));
            XWalkCoreWrapper.reserveReflectMethod(this.setDownloadListenerXWalkDownloadListenerInternalMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }

   }

   private boolean performLongClickDelegate() {
      return this.performLongClick();
   }

   private boolean onTouchEventDelegate(MotionEvent event) {
      return this.onTouchEvent(event);
   }

   public boolean onTouchEvent(MotionEvent event) {
      try {
         return (Boolean)this.onTouchEventMotionEventMethod.invoke(event);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
            return false;
         }
      }
   }

   private void onScrollChangedDelegate(int l, int t, int oldl, int oldt) {
      this.onScrollChanged(l, t, oldl, oldt);
   }

   private void onFocusChangedDelegate(boolean gainFocus, int direction, Rect previouslyFocusedRect) {
      this.onFocusChanged(gainFocus, direction, previouslyFocusedRect);
   }

   private void onOverScrolledDelegate(int scrollX, int scrollY, boolean clampedX, boolean clampedY) {
      this.onOverScrolled(scrollX, scrollY, clampedX, clampedY);
   }

   public void setOnTouchListener(OnTouchListener l) {
      try {
         this.setOnTouchListenerOnTouchListenerMethod.invoke(l);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void scrollTo(int x, int y) {
      try {
         this.scrollTointintMethod.invoke(x, y);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void scrollBy(int x, int y) {
      try {
         this.scrollByintintMethod.invoke(x, y);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public int computeHorizontalScrollRange() {
      try {
         return (Integer)this.computeHorizontalScrollRangeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public int computeHorizontalScrollOffset() {
      try {
         return (Integer)this.computeHorizontalScrollOffsetMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public int computeVerticalScrollRange() {
      try {
         return (Integer)this.computeVerticalScrollRangeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public int computeVerticalScrollOffset() {
      try {
         return (Integer)this.computeVerticalScrollOffsetMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public int computeVerticalScrollExtent() {
      try {
         return (Integer)this.computeVerticalScrollExtentMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public XWalkExternalExtensionManager getExtensionManager() {
      try {
         return (XWalkExternalExtensionManager)this.coreWrapper.getWrapperObject(this.getExtensionManagerMethod.invoke());
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void clearSslPreferences() {
      try {
         this.clearSslPreferencesMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void clearClientCertPreferences(Runnable callback) {
      try {
         this.clearClientCertPreferencesRunnableMethod.invoke(callback);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public SslCertificate getCertificate() {
      try {
         return (SslCertificate)this.getCertificateMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setFindListener(XWalkFindListener listener) {
      try {
         this.setFindListenerXWalkFindListenerInternalMethod.invoke(listener.getBridge());
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            this.setFindListenerXWalkFindListenerInternalMethod.setArguments(new ReflectMethod(listener, "getBridge", new Class[0]));
            XWalkCoreWrapper.reserveReflectMethod(this.setFindListenerXWalkFindListenerInternalMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }

   }

   public void findAllAsync(String searchString) {
      try {
         this.findAllAsyncStringMethod.invoke(searchString);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void findNext(boolean forward) {
      try {
         this.findNextbooleanMethod.invoke(forward);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void clearMatches() {
      try {
         this.clearMatchesMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public String getCompositingSurfaceType() {
      try {
         return (String)this.getCompositingSurfaceTypeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
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
         ReflectConstructor constructor = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkViewBridge"), paramTypes);

         try {
            this.bridge = constructor.newInstance(this.constructorParams.toArray());
         } catch (UnsupportedOperationException var5) {
            return;
         }

         if (this.postWrapperMethod != null) {
            this.postWrapperMethod.invoke();
         }

         this.loadStringStringMethod.init(this.bridge, (Class)null, "loadSuper", String.class, String.class);
         this.loadStringStringMapMethod.init(this.bridge, (Class)null, "loadSuper", String.class, String.class, Map.class);
         this.loadDataStringStringStringMethod.init(this.bridge, (Class)null, "loadDataSuper", String.class, String.class, String.class);
         this.loadDataWithBaseURLStringStringStringStringStringMethod.init(this.bridge, (Class)null, "loadDataWithBaseURLSuper", String.class, String.class, String.class, String.class, String.class);
         this.loadUrlStringMethod.init(this.bridge, (Class)null, "loadUrlSuper", String.class);
         this.loadUrlStringMapMethod.init(this.bridge, (Class)null, "loadUrlSuper", String.class, Map.class);
         this.loadAppFromManifestStringStringMethod.init(this.bridge, (Class)null, "loadAppFromManifestSuper", String.class, String.class);
         this.reloadintMethod.init(this.bridge, (Class)null, "reloadSuper", Integer.TYPE);
         this.stopLoadingMethod.init(this.bridge, (Class)null, "stopLoadingSuper");
         this.getUrlMethod.init(this.bridge, (Class)null, "getUrlSuper");
         this.getHitTestResultMethod.init(this.bridge, (Class)null, "getHitTestResultSuper");
         this.getContentHeightMethod.init(this.bridge, (Class)null, "getContentHeightSuper");
         this.getTitleMethod.init(this.bridge, (Class)null, "getTitleSuper");
         this.getOriginalUrlMethod.init(this.bridge, (Class)null, "getOriginalUrlSuper");
         this.getNavigationHistoryMethod.init(this.bridge, (Class)null, "getNavigationHistorySuper");
         this.addJavascriptInterfaceObjectStringMethod.init(this.bridge, (Class)null, "addJavascriptInterfaceSuper", Object.class, String.class);
         this.removeJavascriptInterfaceStringMethod.init(this.bridge, (Class)null, "removeJavascriptInterfaceSuper", String.class);
         this.evaluateJavascriptStringValueCallbackMethod.init(this.bridge, (Class)null, "evaluateJavascriptSuper", String.class, ValueCallback.class);
         this.clearCachebooleanMethod.init(this.bridge, (Class)null, "clearCacheSuper", Boolean.TYPE);
         this.clearCacheForSingleFileStringMethod.init(this.bridge, (Class)null, "clearCacheForSingleFileSuper", String.class);
         this.hasEnteredFullscreenMethod.init(this.bridge, (Class)null, "hasEnteredFullscreenSuper");
         this.leaveFullscreenMethod.init(this.bridge, (Class)null, "leaveFullscreenSuper");
         this.pauseTimersMethod.init(this.bridge, (Class)null, "pauseTimersSuper");
         this.resumeTimersMethod.init(this.bridge, (Class)null, "resumeTimersSuper");
         this.onHideMethod.init(this.bridge, (Class)null, "onHideSuper");
         this.onShowMethod.init(this.bridge, (Class)null, "onShowSuper");
         this.onDestroyMethod.init(this.bridge, (Class)null, "onDestroySuper");
         this.startActivityForResultIntentintBundleMethod.init(this.bridge, (Class)null, "startActivityForResultSuper", Intent.class, Integer.TYPE, Bundle.class);
         this.onActivityResultintintIntentMethod.init(this.bridge, (Class)null, "onActivityResultSuper", Integer.TYPE, Integer.TYPE, Intent.class);
         this.onNewIntentIntentMethod.init(this.bridge, (Class)null, "onNewIntentSuper", Intent.class);
         this.saveStateBundleMethod.init(this.bridge, (Class)null, "saveStateSuper", Bundle.class);
         this.restoreStateBundleMethod.init(this.bridge, (Class)null, "restoreStateSuper", Bundle.class);
         this.getAPIVersionMethod.init(this.bridge, (Class)null, "getAPIVersionSuper");
         this.getXWalkVersionMethod.init(this.bridge, (Class)null, "getXWalkVersionSuper");
         this.setUIClientXWalkUIClientInternalMethod.init(this.bridge, (Class)null, "setUIClientSuper", this.coreWrapper.getBridgeClass("XWalkUIClientBridge"));
         this.setResourceClientXWalkResourceClientInternalMethod.init(this.bridge, (Class)null, "setResourceClientSuper", this.coreWrapper.getBridgeClass("XWalkResourceClientBridge"));
         this.setBackgroundColorintMethod.init(this.bridge, (Class)null, "setBackgroundColorSuper", Integer.TYPE);
         this.setOriginAccessWhitelistStringStringArrayMethod.init(this.bridge, (Class)null, "setOriginAccessWhitelistSuper", String.class, String[].class);
         this.setUserAgentStringStringMethod.init(this.bridge, (Class)null, "setUserAgentStringSuper", String.class);
         this.getUserAgentStringMethod.init(this.bridge, (Class)null, "getUserAgentStringSuper");
         this.setAcceptLanguagesStringMethod.init(this.bridge, (Class)null, "setAcceptLanguagesSuper", String.class);
         this.captureBitmapAsyncXWalkGetBitmapCallbackInternalMethod.init(this.bridge, (Class)null, "captureBitmapAsyncSuper", this.coreWrapper.getBridgeClass("XWalkGetBitmapCallbackBridge"));
         this.getSettingsMethod.init(this.bridge, (Class)null, "getSettingsSuper");
         this.setNetworkAvailablebooleanMethod.init(this.bridge, (Class)null, "setNetworkAvailableSuper", Boolean.TYPE);
         this.getRemoteDebuggingUrlMethod.init(this.bridge, (Class)null, "getRemoteDebuggingUrlSuper");
         this.zoomInMethod.init(this.bridge, (Class)null, "zoomInSuper");
         this.zoomOutMethod.init(this.bridge, (Class)null, "zoomOutSuper");
         this.zoomByfloatMethod.init(this.bridge, (Class)null, "zoomBySuper", Float.TYPE);
         this.canZoomInMethod.init(this.bridge, (Class)null, "canZoomInSuper");
         this.canZoomOutMethod.init(this.bridge, (Class)null, "canZoomOutSuper");
         this.onCreateInputConnectionEditorInfoMethod.init(this.bridge, (Class)null, "onCreateInputConnectionSuper", EditorInfo.class);
         this.setInitialScaleintMethod.init(this.bridge, (Class)null, "setInitialScaleSuper", Integer.TYPE);
         this.getFaviconMethod.init(this.bridge, (Class)null, "getFaviconSuper");
         this.setZOrderOnTopbooleanMethod.init(this.bridge, (Class)null, "setZOrderOnTopSuper", Boolean.TYPE);
         this.clearFormDataMethod.init(this.bridge, (Class)null, "clearFormDataSuper");
         this.setSurfaceViewVisibilityintMethod.init(this.bridge, (Class)null, "setSurfaceViewVisibilitySuper", Integer.TYPE);
         this.setXWalkViewInternalVisibilityintMethod.init(this.bridge, (Class)null, "setXWalkViewInternalVisibilitySuper", Integer.TYPE);
         this.setDownloadListenerXWalkDownloadListenerInternalMethod.init(this.bridge, (Class)null, "setDownloadListenerSuper", this.coreWrapper.getBridgeClass("XWalkDownloadListenerBridge"));
         this.onTouchEventMotionEventMethod.init(this.bridge, (Class)null, "onTouchEventSuper", MotionEvent.class);
         this.setOnTouchListenerOnTouchListenerMethod.init(this.bridge, (Class)null, "setOnTouchListenerSuper", OnTouchListener.class);
         this.scrollTointintMethod.init(this.bridge, (Class)null, "scrollToSuper", Integer.TYPE, Integer.TYPE);
         this.scrollByintintMethod.init(this.bridge, (Class)null, "scrollBySuper", Integer.TYPE, Integer.TYPE);
         this.computeHorizontalScrollRangeMethod.init(this.bridge, (Class)null, "computeHorizontalScrollRangeSuper");
         this.computeHorizontalScrollOffsetMethod.init(this.bridge, (Class)null, "computeHorizontalScrollOffsetSuper");
         this.computeVerticalScrollRangeMethod.init(this.bridge, (Class)null, "computeVerticalScrollRangeSuper");
         this.computeVerticalScrollOffsetMethod.init(this.bridge, (Class)null, "computeVerticalScrollOffsetSuper");
         this.computeVerticalScrollExtentMethod.init(this.bridge, (Class)null, "computeVerticalScrollExtentSuper");
         this.getExtensionManagerMethod.init(this.bridge, (Class)null, "getExtensionManagerSuper");
         this.clearSslPreferencesMethod.init(this.bridge, (Class)null, "clearSslPreferencesSuper");
         this.clearClientCertPreferencesRunnableMethod.init(this.bridge, (Class)null, "clearClientCertPreferencesSuper", Runnable.class);
         this.getCertificateMethod.init(this.bridge, (Class)null, "getCertificateSuper");
         this.setFindListenerXWalkFindListenerInternalMethod.init(this.bridge, (Class)null, "setFindListenerSuper", this.coreWrapper.getBridgeClass("XWalkFindListenerBridge"));
         this.findAllAsyncStringMethod.init(this.bridge, (Class)null, "findAllAsyncSuper", String.class);
         this.findNextbooleanMethod.init(this.bridge, (Class)null, "findNextSuper", Boolean.TYPE);
         this.clearMatchesMethod.init(this.bridge, (Class)null, "clearMatchesSuper");
         this.getCompositingSurfaceTypeMethod.init(this.bridge, (Class)null, "getCompositingSurfaceTypeSuper");
      }
   }
}
