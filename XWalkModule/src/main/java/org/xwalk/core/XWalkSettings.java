package org.xwalk.core;

import java.util.ArrayList;

public class XWalkSettings {
   public static final int LOAD_DEFAULT = -1;
   public static final int LOAD_CACHE_ELSE_NETWORK = 1;
   public static final int LOAD_NO_CACHE = 2;
   public static final int LOAD_CACHE_ONLY = 3;
   private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private ReflectMethod enumLayoutAlgorithmClassValueOfMethod = new ReflectMethod();
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod setCacheModeintMethod = new ReflectMethod((Class)null, "setCacheMode", new Class[0]);
   private ReflectMethod getCacheModeMethod = new ReflectMethod((Class)null, "getCacheMode", new Class[0]);
   private ReflectMethod setBlockNetworkLoadsbooleanMethod = new ReflectMethod((Class)null, "setBlockNetworkLoads", new Class[0]);
   private ReflectMethod getBlockNetworkLoadsMethod = new ReflectMethod((Class)null, "getBlockNetworkLoads", new Class[0]);
   private ReflectMethod setAllowFileAccessbooleanMethod = new ReflectMethod((Class)null, "setAllowFileAccess", new Class[0]);
   private ReflectMethod getAllowFileAccessMethod = new ReflectMethod((Class)null, "getAllowFileAccess", new Class[0]);
   private ReflectMethod setAllowContentAccessbooleanMethod = new ReflectMethod((Class)null, "setAllowContentAccess", new Class[0]);
   private ReflectMethod getAllowContentAccessMethod = new ReflectMethod((Class)null, "getAllowContentAccess", new Class[0]);
   private ReflectMethod setJavaScriptEnabledbooleanMethod = new ReflectMethod((Class)null, "setJavaScriptEnabled", new Class[0]);
   private ReflectMethod setAllowUniversalAccessFromFileURLsbooleanMethod = new ReflectMethod((Class)null, "setAllowUniversalAccessFromFileURLs", new Class[0]);
   private ReflectMethod setAllowFileAccessFromFileURLsbooleanMethod = new ReflectMethod((Class)null, "setAllowFileAccessFromFileURLs", new Class[0]);
   private ReflectMethod setLoadsImagesAutomaticallybooleanMethod = new ReflectMethod((Class)null, "setLoadsImagesAutomatically", new Class[0]);
   private ReflectMethod getLoadsImagesAutomaticallyMethod = new ReflectMethod((Class)null, "getLoadsImagesAutomatically", new Class[0]);
   private ReflectMethod setBlockNetworkImagebooleanMethod = new ReflectMethod((Class)null, "setBlockNetworkImage", new Class[0]);
   private ReflectMethod getBlockNetworkImageMethod = new ReflectMethod((Class)null, "getBlockNetworkImage", new Class[0]);
   private ReflectMethod getJavaScriptEnabledMethod = new ReflectMethod((Class)null, "getJavaScriptEnabled", new Class[0]);
   private ReflectMethod getAllowUniversalAccessFromFileURLsMethod = new ReflectMethod((Class)null, "getAllowUniversalAccessFromFileURLs", new Class[0]);
   private ReflectMethod getAllowFileAccessFromFileURLsMethod = new ReflectMethod((Class)null, "getAllowFileAccessFromFileURLs", new Class[0]);
   private ReflectMethod setJavaScriptCanOpenWindowsAutomaticallybooleanMethod = new ReflectMethod((Class)null, "setJavaScriptCanOpenWindowsAutomatically", new Class[0]);
   private ReflectMethod getJavaScriptCanOpenWindowsAutomaticallyMethod = new ReflectMethod((Class)null, "getJavaScriptCanOpenWindowsAutomatically", new Class[0]);
   private ReflectMethod setSupportMultipleWindowsbooleanMethod = new ReflectMethod((Class)null, "setSupportMultipleWindows", new Class[0]);
   private ReflectMethod supportMultipleWindowsMethod = new ReflectMethod((Class)null, "supportMultipleWindows", new Class[0]);
   private ReflectMethod setUseWideViewPortbooleanMethod = new ReflectMethod((Class)null, "setUseWideViewPort", new Class[0]);
   private ReflectMethod getUseWideViewPortMethod = new ReflectMethod((Class)null, "getUseWideViewPort", new Class[0]);
   private ReflectMethod setDomStorageEnabledbooleanMethod = new ReflectMethod((Class)null, "setDomStorageEnabled", new Class[0]);
   private ReflectMethod getDomStorageEnabledMethod = new ReflectMethod((Class)null, "getDomStorageEnabled", new Class[0]);
   private ReflectMethod setDatabaseEnabledbooleanMethod = new ReflectMethod((Class)null, "setDatabaseEnabled", new Class[0]);
   private ReflectMethod getDatabaseEnabledMethod = new ReflectMethod((Class)null, "getDatabaseEnabled", new Class[0]);
   private ReflectMethod setMediaPlaybackRequiresUserGesturebooleanMethod = new ReflectMethod((Class)null, "setMediaPlaybackRequiresUserGesture", new Class[0]);
   private ReflectMethod getMediaPlaybackRequiresUserGestureMethod = new ReflectMethod((Class)null, "getMediaPlaybackRequiresUserGesture", new Class[0]);
   private ReflectMethod setUserAgentStringStringMethod = new ReflectMethod((Class)null, "setUserAgentString", new Class[0]);
   private ReflectMethod getUserAgentStringMethod = new ReflectMethod((Class)null, "getUserAgentString", new Class[0]);
   private ReflectMethod setAcceptLanguagesStringMethod = new ReflectMethod((Class)null, "setAcceptLanguages", new Class[0]);
   private ReflectMethod getAcceptLanguagesMethod = new ReflectMethod((Class)null, "getAcceptLanguages", new Class[0]);
   private ReflectMethod setSaveFormDatabooleanMethod = new ReflectMethod((Class)null, "setSaveFormData", new Class[0]);
   private ReflectMethod getSaveFormDataMethod = new ReflectMethod((Class)null, "getSaveFormData", new Class[0]);
   private ReflectMethod setInitialPageScalefloatMethod = new ReflectMethod((Class)null, "setInitialPageScale", new Class[0]);
   private ReflectMethod setTextZoomintMethod = new ReflectMethod((Class)null, "setTextZoom", new Class[0]);
   private ReflectMethod getTextZoomMethod = new ReflectMethod((Class)null, "getTextZoom", new Class[0]);
   private ReflectMethod setDefaultFontSizeintMethod = new ReflectMethod((Class)null, "setDefaultFontSize", new Class[0]);
   private ReflectMethod getDefaultFontSizeMethod = new ReflectMethod((Class)null, "getDefaultFontSize", new Class[0]);
   private ReflectMethod setDefaultFixedFontSizeintMethod = new ReflectMethod((Class)null, "setDefaultFixedFontSize", new Class[0]);
   private ReflectMethod getDefaultFixedFontSizeMethod = new ReflectMethod((Class)null, "getDefaultFixedFontSize", new Class[0]);
   private ReflectMethod setSupportZoombooleanMethod = new ReflectMethod((Class)null, "setSupportZoom", new Class[0]);
   private ReflectMethod supportZoomMethod = new ReflectMethod((Class)null, "supportZoom", new Class[0]);
   private ReflectMethod setBuiltInZoomControlsbooleanMethod = new ReflectMethod((Class)null, "setBuiltInZoomControls", new Class[0]);
   private ReflectMethod getBuiltInZoomControlsMethod = new ReflectMethod((Class)null, "getBuiltInZoomControls", new Class[0]);
   private ReflectMethod supportsMultiTouchZoomForTestMethod = new ReflectMethod((Class)null, "supportsMultiTouchZoomForTest", new Class[0]);
   private ReflectMethod setSupportSpatialNavigationbooleanMethod = new ReflectMethod((Class)null, "setSupportSpatialNavigation", new Class[0]);
   private ReflectMethod getSupportSpatialNavigationMethod = new ReflectMethod((Class)null, "getSupportSpatialNavigation", new Class[0]);
   private ReflectMethod setSupportQuirksModebooleanMethod = new ReflectMethod((Class)null, "setSupportQuirksMode", new Class[0]);
   private ReflectMethod getSupportQuirksModeMethod = new ReflectMethod((Class)null, "getSupportQuirksMode", new Class[0]);
   private ReflectMethod setLayoutAlgorithmLayoutAlgorithmInternalMethod = new ReflectMethod((Class)null, "setLayoutAlgorithm", new Class[0]);
   private ReflectMethod getLayoutAlgorithmMethod = new ReflectMethod((Class)null, "getLayoutAlgorithm", new Class[0]);
   private ReflectMethod setLoadWithOverviewModebooleanMethod = new ReflectMethod((Class)null, "setLoadWithOverviewMode", new Class[0]);
   private ReflectMethod getLoadWithOverviewModeMethod = new ReflectMethod((Class)null, "getLoadWithOverviewMode", new Class[0]);

   private Object ConvertLayoutAlgorithm(XWalkSettings.LayoutAlgorithm type) {
      return this.enumLayoutAlgorithmClassValueOfMethod.invoke(type.toString());
   }

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkSettings(Object bridge) {
      this.bridge = bridge;
      this.reflectionInit();
   }

   public void setCacheMode(int mode) {
      try {
         this.setCacheModeintMethod.invoke(mode);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public int getCacheMode() {
      try {
         return (Integer)this.getCacheModeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public void setBlockNetworkLoads(boolean flag) {
      try {
         this.setBlockNetworkLoadsbooleanMethod.invoke(flag);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getBlockNetworkLoads() {
      try {
         return (Boolean)this.getBlockNetworkLoadsMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setAllowFileAccess(boolean allow) {
      try {
         this.setAllowFileAccessbooleanMethod.invoke(allow);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getAllowFileAccess() {
      try {
         return (Boolean)this.getAllowFileAccessMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setAllowContentAccess(boolean allow) {
      try {
         this.setAllowContentAccessbooleanMethod.invoke(allow);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getAllowContentAccess() {
      try {
         return (Boolean)this.getAllowContentAccessMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setJavaScriptEnabled(boolean flag) {
      try {
         this.setJavaScriptEnabledbooleanMethod.invoke(flag);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void setAllowUniversalAccessFromFileURLs(boolean flag) {
      try {
         this.setAllowUniversalAccessFromFileURLsbooleanMethod.invoke(flag);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void setAllowFileAccessFromFileURLs(boolean flag) {
      try {
         this.setAllowFileAccessFromFileURLsbooleanMethod.invoke(flag);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void setLoadsImagesAutomatically(boolean flag) {
      try {
         this.setLoadsImagesAutomaticallybooleanMethod.invoke(flag);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getLoadsImagesAutomatically() {
      try {
         return (Boolean)this.getLoadsImagesAutomaticallyMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setBlockNetworkImage(boolean flag) {
      try {
         this.setBlockNetworkImagebooleanMethod.invoke(flag);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getBlockNetworkImage() {
      try {
         return (Boolean)this.getBlockNetworkImageMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public boolean getJavaScriptEnabled() {
      try {
         return (Boolean)this.getJavaScriptEnabledMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public boolean getAllowUniversalAccessFromFileURLs() {
      try {
         return (Boolean)this.getAllowUniversalAccessFromFileURLsMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public boolean getAllowFileAccessFromFileURLs() {
      try {
         return (Boolean)this.getAllowFileAccessFromFileURLsMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setJavaScriptCanOpenWindowsAutomatically(boolean flag) {
      try {
         this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.invoke(flag);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getJavaScriptCanOpenWindowsAutomatically() {
      try {
         return (Boolean)this.getJavaScriptCanOpenWindowsAutomaticallyMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setSupportMultipleWindows(boolean support) {
      try {
         this.setSupportMultipleWindowsbooleanMethod.invoke(support);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean supportMultipleWindows() {
      try {
         return (Boolean)this.supportMultipleWindowsMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setUseWideViewPort(boolean use) {
      try {
         this.setUseWideViewPortbooleanMethod.invoke(use);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getUseWideViewPort() {
      try {
         return (Boolean)this.getUseWideViewPortMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setDomStorageEnabled(boolean flag) {
      try {
         this.setDomStorageEnabledbooleanMethod.invoke(flag);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getDomStorageEnabled() {
      try {
         return (Boolean)this.getDomStorageEnabledMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setDatabaseEnabled(boolean flag) {
      try {
         this.setDatabaseEnabledbooleanMethod.invoke(flag);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getDatabaseEnabled() {
      try {
         return (Boolean)this.getDatabaseEnabledMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setMediaPlaybackRequiresUserGesture(boolean require) {
      try {
         this.setMediaPlaybackRequiresUserGesturebooleanMethod.invoke(require);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getMediaPlaybackRequiresUserGesture() {
      try {
         return (Boolean)this.getMediaPlaybackRequiresUserGestureMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
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

   public String getAcceptLanguages() {
      try {
         return (String)this.getAcceptLanguagesMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setSaveFormData(boolean enable) {
      try {
         this.setSaveFormDatabooleanMethod.invoke(enable);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getSaveFormData() {
      try {
         return (Boolean)this.getSaveFormDataMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setInitialPageScale(float scaleInPercent) {
      try {
         this.setInitialPageScalefloatMethod.invoke(scaleInPercent);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void setTextZoom(int textZoom) {
      try {
         this.setTextZoomintMethod.invoke(textZoom);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public int getTextZoom() {
      try {
         return (Integer)this.getTextZoomMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public void setDefaultFontSize(int size) {
      try {
         this.setDefaultFontSizeintMethod.invoke(size);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public int getDefaultFontSize() {
      try {
         return (Integer)this.getDefaultFontSizeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public void setDefaultFixedFontSize(int size) {
      try {
         this.setDefaultFixedFontSizeintMethod.invoke(size);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public int getDefaultFixedFontSize() {
      try {
         return (Integer)this.getDefaultFixedFontSizeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public void setSupportZoom(boolean support) {
      try {
         this.setSupportZoombooleanMethod.invoke(support);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean supportZoom() {
      try {
         return (Boolean)this.supportZoomMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setBuiltInZoomControls(boolean enabled) {
      try {
         this.setBuiltInZoomControlsbooleanMethod.invoke(enabled);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getBuiltInZoomControls() {
      try {
         return (Boolean)this.getBuiltInZoomControlsMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public boolean supportsMultiTouchZoomForTest() {
      try {
         return (Boolean)this.supportsMultiTouchZoomForTestMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setSupportSpatialNavigation(boolean enable) {
      try {
         this.setSupportSpatialNavigationbooleanMethod.invoke(enable);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getSupportSpatialNavigation() {
      try {
         return (Boolean)this.getSupportSpatialNavigationMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setSupportQuirksMode(boolean enable) {
      try {
         this.setSupportQuirksModebooleanMethod.invoke(enable);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getSupportQuirksMode() {
      try {
         return (Boolean)this.getSupportQuirksModeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm la) {
      try {
         this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.invoke(this.ConvertLayoutAlgorithm(la));
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public XWalkSettings.LayoutAlgorithm getLayoutAlgorithm() {
      try {
         return XWalkSettings.LayoutAlgorithm.valueOf(this.getLayoutAlgorithmMethod.invoke().toString());
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setLoadWithOverviewMode(boolean overview) {
      try {
         this.setLoadWithOverviewModebooleanMethod.invoke(overview);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean getLoadWithOverviewMode() {
      try {
         return (Boolean)this.getLoadWithOverviewModeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   void reflectionInit() {
      XWalkCoreWrapper.initEmbeddedMode();
      this.coreWrapper = XWalkCoreWrapper.getInstance();
      if (this.coreWrapper == null) {
         XWalkCoreWrapper.reserveReflectObject(this);
      } else {
         this.enumLayoutAlgorithmClassValueOfMethod.init((Object)null, this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal"), "valueOf", String.class);
         this.setCacheModeintMethod.init(this.bridge, (Class)null, "setCacheModeSuper", Integer.TYPE);
         this.getCacheModeMethod.init(this.bridge, (Class)null, "getCacheModeSuper");
         this.setBlockNetworkLoadsbooleanMethod.init(this.bridge, (Class)null, "setBlockNetworkLoadsSuper", Boolean.TYPE);
         this.getBlockNetworkLoadsMethod.init(this.bridge, (Class)null, "getBlockNetworkLoadsSuper");
         this.setAllowFileAccessbooleanMethod.init(this.bridge, (Class)null, "setAllowFileAccessSuper", Boolean.TYPE);
         this.getAllowFileAccessMethod.init(this.bridge, (Class)null, "getAllowFileAccessSuper");
         this.setAllowContentAccessbooleanMethod.init(this.bridge, (Class)null, "setAllowContentAccessSuper", Boolean.TYPE);
         this.getAllowContentAccessMethod.init(this.bridge, (Class)null, "getAllowContentAccessSuper");
         this.setJavaScriptEnabledbooleanMethod.init(this.bridge, (Class)null, "setJavaScriptEnabledSuper", Boolean.TYPE);
         this.setAllowUniversalAccessFromFileURLsbooleanMethod.init(this.bridge, (Class)null, "setAllowUniversalAccessFromFileURLsSuper", Boolean.TYPE);
         this.setAllowFileAccessFromFileURLsbooleanMethod.init(this.bridge, (Class)null, "setAllowFileAccessFromFileURLsSuper", Boolean.TYPE);
         this.setLoadsImagesAutomaticallybooleanMethod.init(this.bridge, (Class)null, "setLoadsImagesAutomaticallySuper", Boolean.TYPE);
         this.getLoadsImagesAutomaticallyMethod.init(this.bridge, (Class)null, "getLoadsImagesAutomaticallySuper");
         this.setBlockNetworkImagebooleanMethod.init(this.bridge, (Class)null, "setBlockNetworkImageSuper", Boolean.TYPE);
         this.getBlockNetworkImageMethod.init(this.bridge, (Class)null, "getBlockNetworkImageSuper");
         this.getJavaScriptEnabledMethod.init(this.bridge, (Class)null, "getJavaScriptEnabledSuper");
         this.getAllowUniversalAccessFromFileURLsMethod.init(this.bridge, (Class)null, "getAllowUniversalAccessFromFileURLsSuper");
         this.getAllowFileAccessFromFileURLsMethod.init(this.bridge, (Class)null, "getAllowFileAccessFromFileURLsSuper");
         this.setJavaScriptCanOpenWindowsAutomaticallybooleanMethod.init(this.bridge, (Class)null, "setJavaScriptCanOpenWindowsAutomaticallySuper", Boolean.TYPE);
         this.getJavaScriptCanOpenWindowsAutomaticallyMethod.init(this.bridge, (Class)null, "getJavaScriptCanOpenWindowsAutomaticallySuper");
         this.setSupportMultipleWindowsbooleanMethod.init(this.bridge, (Class)null, "setSupportMultipleWindowsSuper", Boolean.TYPE);
         this.supportMultipleWindowsMethod.init(this.bridge, (Class)null, "supportMultipleWindowsSuper");
         this.setUseWideViewPortbooleanMethod.init(this.bridge, (Class)null, "setUseWideViewPortSuper", Boolean.TYPE);
         this.getUseWideViewPortMethod.init(this.bridge, (Class)null, "getUseWideViewPortSuper");
         this.setDomStorageEnabledbooleanMethod.init(this.bridge, (Class)null, "setDomStorageEnabledSuper", Boolean.TYPE);
         this.getDomStorageEnabledMethod.init(this.bridge, (Class)null, "getDomStorageEnabledSuper");
         this.setDatabaseEnabledbooleanMethod.init(this.bridge, (Class)null, "setDatabaseEnabledSuper", Boolean.TYPE);
         this.getDatabaseEnabledMethod.init(this.bridge, (Class)null, "getDatabaseEnabledSuper");
         this.setMediaPlaybackRequiresUserGesturebooleanMethod.init(this.bridge, (Class)null, "setMediaPlaybackRequiresUserGestureSuper", Boolean.TYPE);
         this.getMediaPlaybackRequiresUserGestureMethod.init(this.bridge, (Class)null, "getMediaPlaybackRequiresUserGestureSuper");
         this.setUserAgentStringStringMethod.init(this.bridge, (Class)null, "setUserAgentStringSuper", String.class);
         this.getUserAgentStringMethod.init(this.bridge, (Class)null, "getUserAgentStringSuper");
         this.setAcceptLanguagesStringMethod.init(this.bridge, (Class)null, "setAcceptLanguagesSuper", String.class);
         this.getAcceptLanguagesMethod.init(this.bridge, (Class)null, "getAcceptLanguagesSuper");
         this.setSaveFormDatabooleanMethod.init(this.bridge, (Class)null, "setSaveFormDataSuper", Boolean.TYPE);
         this.getSaveFormDataMethod.init(this.bridge, (Class)null, "getSaveFormDataSuper");
         this.setInitialPageScalefloatMethod.init(this.bridge, (Class)null, "setInitialPageScaleSuper", Float.TYPE);
         this.setTextZoomintMethod.init(this.bridge, (Class)null, "setTextZoomSuper", Integer.TYPE);
         this.getTextZoomMethod.init(this.bridge, (Class)null, "getTextZoomSuper");
         this.setDefaultFontSizeintMethod.init(this.bridge, (Class)null, "setDefaultFontSizeSuper", Integer.TYPE);
         this.getDefaultFontSizeMethod.init(this.bridge, (Class)null, "getDefaultFontSizeSuper");
         this.setDefaultFixedFontSizeintMethod.init(this.bridge, (Class)null, "setDefaultFixedFontSizeSuper", Integer.TYPE);
         this.getDefaultFixedFontSizeMethod.init(this.bridge, (Class)null, "getDefaultFixedFontSizeSuper");
         this.setSupportZoombooleanMethod.init(this.bridge, (Class)null, "setSupportZoomSuper", Boolean.TYPE);
         this.supportZoomMethod.init(this.bridge, (Class)null, "supportZoomSuper");
         this.setBuiltInZoomControlsbooleanMethod.init(this.bridge, (Class)null, "setBuiltInZoomControlsSuper", Boolean.TYPE);
         this.getBuiltInZoomControlsMethod.init(this.bridge, (Class)null, "getBuiltInZoomControlsSuper");
         this.supportsMultiTouchZoomForTestMethod.init(this.bridge, (Class)null, "supportsMultiTouchZoomForTestSuper");
         this.setSupportSpatialNavigationbooleanMethod.init(this.bridge, (Class)null, "setSupportSpatialNavigationSuper", Boolean.TYPE);
         this.getSupportSpatialNavigationMethod.init(this.bridge, (Class)null, "getSupportSpatialNavigationSuper");
         this.setSupportQuirksModebooleanMethod.init(this.bridge, (Class)null, "setSupportQuirksModeSuper", Boolean.TYPE);
         this.getSupportQuirksModeMethod.init(this.bridge, (Class)null, "getSupportQuirksModeSuper");
         this.setLayoutAlgorithmLayoutAlgorithmInternalMethod.init(this.bridge, (Class)null, "setLayoutAlgorithmSuper", this.coreWrapper.getBridgeClass("XWalkSettingsInternal$LayoutAlgorithmInternal"));
         this.getLayoutAlgorithmMethod.init(this.bridge, (Class)null, "getLayoutAlgorithmSuper");
         this.setLoadWithOverviewModebooleanMethod.init(this.bridge, (Class)null, "setLoadWithOverviewModeSuper", Boolean.TYPE);
         this.getLoadWithOverviewModeMethod.init(this.bridge, (Class)null, "getLoadWithOverviewModeSuper");
      }
   }

   public static enum LayoutAlgorithm {
      NORMAL,
      SINGLE_COLUMN,
      NARROW_COLUMNS,
      TEXT_AUTOSIZING;
   }
}
