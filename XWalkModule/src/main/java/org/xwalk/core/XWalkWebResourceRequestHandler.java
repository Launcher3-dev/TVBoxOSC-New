package org.xwalk.core;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Map;

public class XWalkWebResourceRequestHandler implements XWalkWebResourceRequest {
   private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod getUrlMethod = new ReflectMethod((Class)null, "getUrl", new Class[0]);
   private ReflectMethod isForMainFrameMethod = new ReflectMethod((Class)null, "isForMainFrame", new Class[0]);
   private ReflectMethod hasGestureMethod = new ReflectMethod((Class)null, "hasGesture", new Class[0]);
   private ReflectMethod getMethodMethod = new ReflectMethod((Class)null, "getMethod", new Class[0]);
   private ReflectMethod getRequestHeadersMethod = new ReflectMethod((Class)null, "getRequestHeaders", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkWebResourceRequestHandler(Object bridge) {
      this.bridge = bridge;
      this.reflectionInit();
   }

   public Uri getUrl() {
      try {
         return (Uri)this.getUrlMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public boolean isForMainFrame() {
      try {
         return (Boolean)this.isForMainFrameMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public boolean hasGesture() {
      try {
         return (Boolean)this.hasGestureMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public String getMethod() {
      try {
         return (String)this.getMethodMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public Map<String, String> getRequestHeaders() {
      try {
         return (Map)this.getRequestHeadersMethod.invoke();
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
         this.getUrlMethod.init(this.bridge, (Class)null, "getUrlSuper");
         this.isForMainFrameMethod.init(this.bridge, (Class)null, "isForMainFrameSuper");
         this.hasGestureMethod.init(this.bridge, (Class)null, "hasGestureSuper");
         this.getMethodMethod.init(this.bridge, (Class)null, "getMethodSuper");
         this.getRequestHeadersMethod.init(this.bridge, (Class)null, "getRequestHeadersSuper");
      }
   }
}
