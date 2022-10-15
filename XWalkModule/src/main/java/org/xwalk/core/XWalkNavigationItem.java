package org.xwalk.core;

import java.util.ArrayList;

public class XWalkNavigationItem {
   private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod getUrlMethod = new ReflectMethod((Class)null, "getUrl", new Class[0]);
   private ReflectMethod getOriginalUrlMethod = new ReflectMethod((Class)null, "getOriginalUrl", new Class[0]);
   private ReflectMethod getTitleMethod = new ReflectMethod((Class)null, "getTitle", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkNavigationItem(Object bridge) {
      this.bridge = bridge;
      this.reflectionInit();
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

   void reflectionInit() {
      XWalkCoreWrapper.initEmbeddedMode();
      this.coreWrapper = XWalkCoreWrapper.getInstance();
      if (this.coreWrapper == null) {
         XWalkCoreWrapper.reserveReflectObject(this);
      } else {
         this.getUrlMethod.init(this.bridge, (Class)null, "getUrlSuper");
         this.getOriginalUrlMethod.init(this.bridge, (Class)null, "getOriginalUrlSuper");
         this.getTitleMethod.init(this.bridge, (Class)null, "getTitleSuper");
      }
   }
}
