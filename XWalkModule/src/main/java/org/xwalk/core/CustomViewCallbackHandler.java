package org.xwalk.core;

import java.util.ArrayList;

public class CustomViewCallbackHandler implements CustomViewCallback {
   private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod onCustomViewHiddenMethod = new ReflectMethod((Class)null, "onCustomViewHidden", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public CustomViewCallbackHandler(Object bridge) {
      this.bridge = bridge;
      this.reflectionInit();
   }

   public void onCustomViewHidden() {
      try {
         this.onCustomViewHiddenMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   void reflectionInit() {
      XWalkCoreWrapper.initEmbeddedMode();
      this.coreWrapper = XWalkCoreWrapper.getInstance();
      if (this.coreWrapper == null) {
         XWalkCoreWrapper.reserveReflectObject(this);
      } else {
         this.onCustomViewHiddenMethod.init(this.bridge, (Class)null, "onCustomViewHiddenSuper");
      }
   }
}
