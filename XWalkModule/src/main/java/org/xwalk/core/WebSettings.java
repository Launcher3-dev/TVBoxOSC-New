package org.xwalk.core;

import android.annotation.TargetApi;
import android.content.Context;

import java.util.Objects;

public class WebSettings extends android.webkit.WebSettings{
   public static final int LOAD_DEFAULT = -1;
   public static final int LOAD_NORMAL = 0;
   public static final int LOAD_CACHE_ELSE_NETWORK = 1;
   public static final int LOAD_NO_CACHE = 2;
   public static final int LOAD_CACHE_ONLY = 3;
   private XWalkSettings xWalkSettings = null;
   private XWalkView xWalkView = null;

   WebSettings(XWalkSettings var1) {
	   Objects.requireNonNull(var1);
      this.xWalkSettings = var1;
   }

   /** @deprecated */
   @Deprecated
   public void setNavDump(boolean var1) {
	   //this.xWalkSettings.setNavDump(var1);
   }

   public synchronized int getMixedContentMode() {
//	   try {
//		   return this.xWalkSettings.getMixedContentMode();
//	   } catch (Throwable var2) {
//		   var2.printStackTrace();
//		   return -1;
//	   }
	   return -1;
   }
	
	@Override
	public void setOffscreenPreRaster(boolean enabled) {
	
	}
	
	@Override
	public boolean getOffscreenPreRaster() {
		return false;
	}
	
	/** @deprecated */
   @Deprecated
   public boolean getNavDump() {
	   //return this.xWalkSettings.getNavDump();
	   return false;
   }

   public void setSupportZoom(boolean var1) {
	   this.xWalkSettings.setSupportZoom(var1);
   }

   public boolean supportZoom() {
	   return this.xWalkSettings.supportZoom();
   }

   @TargetApi(3)
   public void setBuiltInZoomControls(boolean var1) {
	   this.xWalkSettings.setBuiltInZoomControls(var1);
   }

   @TargetApi(3)
   public boolean getBuiltInZoomControls() {
	   return this.xWalkSettings.getBuiltInZoomControls();
   }

   @TargetApi(11)
   public void setDisplayZoomControls(boolean var1) {
	   //this.xWalkSettings.setDisplayZoomControls(var1);
   }

   @TargetApi(11)
   public boolean getDisplayZoomControls() {
	   //return this.xWalkSettings.getDisplayZoomControls();
	   return false;
   }

   @TargetApi(3)
   public void setAllowFileAccess(boolean var1) {
	   this.xWalkSettings.setAllowFileAccess(var1);
   }

   @TargetApi(3)
   public boolean getAllowFileAccess() {
	   return this.xWalkSettings.getAllowFileAccess();
   }

   @TargetApi(11)
   public void setAllowContentAccess(boolean var1) {
	   this.xWalkSettings.setAllowContentAccess(var1);
   }

   @TargetApi(21)
   public void setMixedContentMode(int var1) {
   }

   @TargetApi(11)
   public boolean getAllowContentAccess() {
	   return this.xWalkSettings.getAllowContentAccess();
   }

   @TargetApi(7)
   public void setLoadWithOverviewMode(boolean var1) {
	   this.xWalkSettings.setLoadWithOverviewMode(var1);
   }

   @TargetApi(7)
   public boolean getLoadWithOverviewMode() {
	   return this.xWalkSettings.getLoadWithOverviewMode();
   }

   /** @deprecated */
   @Deprecated
   @TargetApi(11)
   public void setEnableSmoothTransition(boolean var1) {
	   //this.xWalkSettings.setEnableSmoothTransition(var1);
   }

   /** @deprecated */
   @Deprecated
   public boolean enableSmoothTransition() {
	   //return this.xWalkSettings.enableSmoothTransition();
	   return false;
   }

   /** @deprecated */
   @Deprecated
   public void setUseWebViewBackgroundForOverscrollBackground(boolean var1) {
	   //this.xWalkSettings.setUseWebViewBackgroundForOverscrollBackground(var1);
   }

   /** @deprecated */
   @Deprecated
   public boolean getUseWebViewBackgroundForOverscrollBackground() {
	   //return this.xWalkSettings.getUseWebViewBackgroundForOverscrollBackground();
	   return false;
   }

   /** @deprecated */
   @Deprecated
   public void setSaveFormData(boolean var1) {
	   this.xWalkSettings.setSaveFormData(var1);
   }

   /** @deprecated */
   @Deprecated
   public boolean getSaveFormData() {
	   return this.xWalkSettings.getSaveFormData();
   }

   /** @deprecated */
   @Deprecated
   public void setSavePassword(boolean var1) {
	   //this.xWalkSettings.setSavePassword(var1);
   }

   /** @deprecated */
   @Deprecated
   public boolean getSavePassword() {
	  //return this.xWalkSettings.getSavePassword();
	   return false;
   }

   @TargetApi(14)
   public synchronized void setTextZoom(int var1) {
	   this.xWalkSettings.setTextZoom(var1);
   }

   @TargetApi(14)
   public synchronized int getTextZoom() {
	   return this.xWalkSettings.getTextZoom();
   }

   /** @deprecated */
   @Deprecated
   public void setTextSize(TextSize var1) {
	   //this.xWalkSettings.setTextSize(IX5WebSettings.TextSize.valueOf(var1.name()));
   }

   /** @deprecated
	* @return */
   @Deprecated
   public TextSize getTextSize() {
	   //return TextSize.valueOf(this.xWalkSettings.getTextSize().name());
	   return TextSize.NORMAL;
   }

   /** @deprecated */
   @Deprecated
   @TargetApi(7)
   public void setDefaultZoom(ZoomDensity var1) {
   //	this.xWalkSettings.setDefaultZoom(IX5WebSettings.ZoomDensity.valueOf(var1.name()));
   }

   /** @deprecated
	* @return */
   @Deprecated
   @TargetApi(7)
   public ZoomDensity getDefaultZoom() {
	  // return ZoomDensity.valueOf(this.xWalkSettings.getDefaultZoom().name());
	   return ZoomDensity.MEDIUM;
   }

   /** @deprecated */
   @Deprecated
   public void setLightTouchEnabled(boolean var1) {
	  // this.xWalkSettings.setLightTouchEnabled(var1);
   }

   /** @deprecated */
   @Deprecated
   public boolean getLightTouchEnabled() {
	  // return this.xWalkSettings.getLightTouchEnabled();
	   return false;
   }

   public void setUserAgent(String var1) {
	   this.xWalkSettings.setUserAgentString(var1);
   }

   @TargetApi(3)
   public String getUserAgentString() {
	  return this.xWalkSettings.getUserAgentString();
   }

   @TargetApi(3)
   public void setUserAgentString(String var1) {
	   this.xWalkSettings.setUserAgentString(var1);
   }

   public void setUseWideViewPort(boolean var1) {
	   this.xWalkSettings.setUseWideViewPort(var1);
   }

   public synchronized boolean getUseWideViewPort() {
	   return this.xWalkSettings.getUseWideViewPort();
   }

   public void setSupportMultipleWindows(boolean var1) {
	   this.xWalkSettings.setSupportMultipleWindows(var1);
   }

   public synchronized boolean supportMultipleWindows() {
	   return this.xWalkSettings.supportMultipleWindows();
   }

   public void setLayoutAlgorithm(LayoutAlgorithm var1) {
	   this.xWalkSettings.setLayoutAlgorithm(XWalkSettings.LayoutAlgorithm.valueOf(var1.name()));
   }

   public synchronized LayoutAlgorithm getLayoutAlgorithm() {
         return LayoutAlgorithm.valueOf(this.xWalkSettings.getLayoutAlgorithm().name());
   }

   public synchronized void setStandardFontFamily(String var1) {
	   //this.xWalkSettings.setStandardFontFamily(var1);
   }

   public synchronized String getStandardFontFamily() {
	   //return this.xWalkSettings.getStandardFontFamily();
	   return "";
   }

   public synchronized void setFixedFontFamily(String var1) {
	  // this.xWalkSettings.setFixedFontFamily(var1);
   }

   public synchronized String getFixedFontFamily() {
	   //return this.xWalkSettings.getFixedFontFamily();
	   return "";
   }

   public synchronized void setSansSerifFontFamily(String var1) {
	   //this.xWalkSettings.setSansSerifFontFamily(var1);
   }

   public synchronized String getSansSerifFontFamily() {
	   //return this.xWalkSettings.getSansSerifFontFamily();
	   return "";
   }

   public synchronized void setSerifFontFamily(String var1) {
	   //this.xWalkSettings.setSerifFontFamily(var1);
   }

   public synchronized String getSerifFontFamily() {
	  // return this.xWalkSettings.getSerifFontFamily();
	   return "";
   }

   public synchronized void setCursiveFontFamily(String var1) {
	   //this.xWalkSettings.setCursiveFontFamily(var1);
   }

   public synchronized String getCursiveFontFamily() {
	   //return this.xWalkSettings.getCursiveFontFamily();
	   return "";
   }

   public synchronized void setFantasyFontFamily(String var1) {
	   //this.xWalkSettings.setFantasyFontFamily(var1);
   }

   public synchronized String getFantasyFontFamily() {
	   //return this.xWalkSettings.getFantasyFontFamily();
	   return "";
   }

   public synchronized void setMinimumFontSize(int var1) {
	   //this.xWalkSettings.setMinimumFontSize(var1);
   }

   public synchronized int getMinimumFontSize() {
	   //return this.xWalkSettings.getMinimumFontSize();
	   return 0;
   }

   public synchronized void setMinimumLogicalFontSize(int var1) {
	   //this.xWalkSettings.setMinimumLogicalFontSize(var1);
   }

   public synchronized int getMinimumLogicalFontSize() {
	   //return this.xWalkSettings.getMinimumLogicalFontSize();
	   return 0;
   }

   public synchronized void setDefaultFontSize(int var1) {
	   this.xWalkSettings.setDefaultFontSize(var1);
   }

   public synchronized int getDefaultFontSize() {
	   return this.xWalkSettings.getDefaultFontSize();
   }

   public synchronized void setDefaultFixedFontSize(int var1) {
	   this.xWalkSettings.setDefaultFixedFontSize(var1);
   }

   public synchronized int getDefaultFixedFontSize() {
	   return this.xWalkSettings.getDefaultFixedFontSize();
   }

   public void setLoadsImagesAutomatically(boolean var1) {
	   this.xWalkSettings.setLoadsImagesAutomatically(var1);
   }

   public synchronized boolean getLoadsImagesAutomatically() {
	   return this.xWalkSettings.getLoadsImagesAutomatically();
   }

   public void setBlockNetworkImage(boolean var1) {
	   this.xWalkSettings.setBlockNetworkImage(var1);
   }

   public synchronized boolean getBlockNetworkImage() {
	   return this.xWalkSettings.getBlockNetworkImage();
   }

   @TargetApi(8)
   public synchronized void setBlockNetworkLoads(boolean var1) {
	   this.xWalkSettings.setBlockNetworkLoads(var1);
   }

   @TargetApi(8)
   public synchronized boolean getBlockNetworkLoads() {
	   return this.xWalkSettings.getBlockNetworkLoads();
   }

   /** @deprecated */
   @Deprecated
   public void setJavaScriptEnabled(boolean var1) {
      try {
		  this.xWalkSettings.setJavaScriptEnabled(var1);
      } catch (Throwable var3) {
         var3.printStackTrace();
      }
   }

   @TargetApi(16)
   public void setAllowUniversalAccessFromFileURLs(boolean var1) {
	   this.xWalkSettings.setAllowUniversalAccessFromFileURLs(var1);
   }

   @TargetApi(16)
   public void setAllowFileAccessFromFileURLs(boolean var1) {
	   this.xWalkSettings.setAllowFileAccessFromFileURLs(var1);
   }

   /** @deprecated */
   @Deprecated
   public void setPluginsEnabled(boolean var1) {
	   //this.xWalkSettings.setPluginsEnabled(var1);
   }

   /** @deprecated */
   @Deprecated
   @TargetApi(8)
   public synchronized void setPluginState(PluginState var1) {
	   //this.xWalkSettings.setPluginState(IX5WebSettings.PluginState.valueOf(var1.name()));
   }

   /** @deprecated */
   @Deprecated
   public synchronized void setPluginsPath(String var1) {
	   //this.xWalkSettings.setPluginsPath(var1);
   }

   /** @deprecated */
   @Deprecated
   @TargetApi(5)
   public void setDatabasePath(String var1) {
	   //this.xWalkSettings.setDatabasePath(var1);
   }

   /** @deprecated */
   @Deprecated
   @TargetApi(5)
   public void setGeolocationDatabasePath(String var1) {
	   //this.xWalkSettings.setGeolocationDatabasePath(var1);
   }

   @TargetApi(7)
   public void setAppCacheEnabled(boolean var1) {
	   //this.xWalkSettings.setAppCacheEnabled(var1);
   }

   @TargetApi(7)
   public void setAppCachePath(String var1) {
	   //this.xWalkSettings.setAppCachePath(var1);
   }

   /** @deprecated */
   @Deprecated
   @TargetApi(7)
   public void setAppCacheMaxSize(long var1) {
	   //this.xWalkSettings.setAppCacheMaxSize(var1);
   }

   @TargetApi(5)
   public void setDatabaseEnabled(boolean var1) {
	   this.xWalkSettings.setDatabaseEnabled(var1);
   }

   @TargetApi(7)
   public void setDomStorageEnabled(boolean var1) {
	   this.xWalkSettings.setDomStorageEnabled(var1);
   }

   @TargetApi(7)
   public synchronized boolean getDomStorageEnabled() {
	   return this.xWalkSettings.getDomStorageEnabled();
   }

   /** @deprecated */
   @Deprecated
   @TargetApi(5)
   public synchronized String getDatabasePath() {
	   //return this.xWalkSettings.getDatabasePath();
	   return "";
   }

   @TargetApi(5)
   public synchronized boolean getDatabaseEnabled() {
	   return this.xWalkSettings.getDatabaseEnabled();
   }

   @TargetApi(5)
   public void setGeolocationEnabled(boolean var1) {
	   //this.xWalkSettings.setGeolocationEnabled(var1);
   }

   public synchronized boolean getJavaScriptEnabled() {
	   return this.xWalkSettings.getJavaScriptEnabled();
   }
	
	@Override
	public boolean getAllowUniversalAccessFromFileURLs() {
   		//ttt
		return false;
	}
	
	@Override
	public boolean getAllowFileAccessFromFileURLs() {
		//ttt
		return false;
	}
	
	/** @deprecated */
   @Deprecated
   @TargetApi(8)
   public synchronized boolean getPluginsEnabled() {
	   //return this.xWalkSettings.getPluginsEnabled();
	   return false;
   }

   /** @deprecated */
   @Deprecated
   @TargetApi(8)
   public synchronized PluginState getPluginState() {
	   //return PluginState.valueOf(this.xWalkSettings.getPluginState().name());
	   return null;
   }

   /** @deprecated */
   @Deprecated
   public synchronized String getPluginsPath() {
	   //return this.xWalkSettings.getPluginsPath();
	   return null;
   }

   public synchronized void setJavaScriptCanOpenWindowsAutomatically(boolean var1) {
	   this.xWalkSettings.setJavaScriptCanOpenWindowsAutomatically(var1);
   }

   public synchronized boolean getJavaScriptCanOpenWindowsAutomatically() {
	   return this.xWalkSettings.getJavaScriptCanOpenWindowsAutomatically();
   }

   public synchronized void setDefaultTextEncodingName(String var1) {
	   //this.xWalkSettings.setDefaultTextEncodingName(var1);
   }

   public synchronized String getDefaultTextEncodingName() {
	   //return this.xWalkSettings.getDefaultTextEncodingName();
	   return null;
   }

   @TargetApi(17)
   public static String getDefaultUserAgent(Context var0) {
	   //return X5CoreEngine.getInstance().getWVWizardBase().getDefaultUserAgent(var0);
	   return null;
   }

   @TargetApi(17)
   public boolean getMediaPlaybackRequiresUserGesture() {
	   return this.xWalkSettings.getMediaPlaybackRequiresUserGesture();
   }

   @TargetApi(17)
   public void setMediaPlaybackRequiresUserGesture(boolean var1) {
	   this.xWalkSettings.setMediaPlaybackRequiresUserGesture(var1);
   }

   public void setNeedInitialFocus(boolean var1) {
	   //this.xWalkSettings.setNeedInitialFocus(var1);
   }

   /** @deprecated */
   @Deprecated
   public void setRenderPriority(RenderPriority var1) {
   	//this.xWalkSettings.setRenderPriority(IX5WebSettings.RenderPriority.valueOf(var1.name()));
   }

   public void setCacheMode(int var1) {
	   this.xWalkSettings.setCacheMode(var1);
   }

   public int getCacheMode() {
	   return this.xWalkSettings.getCacheMode();
   }

   public void setSafeBrowsingEnabled(boolean var1) {
//	   try {
//		   this.xWalkSettings.setSafeBrowsingEnabled(var1);
//	   } catch (Throwable var3) {
//		   var3.printStackTrace();
//	   }
   }

   public boolean getSafeBrowsingEnabled() {
//	   try {
//		   return this.xWalkSettings.getSafeBrowsingEnabled();
//	   } catch (Throwable var2) {
//		   var2.printStackTrace();
//	   }
      return false;
   }
	
	@Override
	public void setDisabledActionModeMenuItems(int menuItems) {
		//ttt
	}
	
	@Override
	public int getDisabledActionModeMenuItems() {
		//ttt
		return 0;
	}
}
