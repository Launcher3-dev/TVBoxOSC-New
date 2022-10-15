package org.xwalk.core;

import java.util.ArrayList;

public class XWalkHttpAuthHandler implements XWalkHttpAuth {
   private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod proceedStringStringMethod = new ReflectMethod((Class)null, "proceed", new Class[0]);
   private ReflectMethod cancelMethod = new ReflectMethod((Class)null, "cancel", new Class[0]);
   private ReflectMethod isFirstAttemptMethod = new ReflectMethod((Class)null, "isFirstAttempt", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkHttpAuthHandler(Object bridge) {
      this.bridge = bridge;
      this.reflectionInit();
   }

   public void proceed(String username, String password) {
      try {
         this.proceedStringStringMethod.invoke(username, password);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void cancel() {
      try {
         this.cancelMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public boolean isFirstAttempt() {
      try {
         return (Boolean)this.isFirstAttemptMethod.invoke();
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
         this.proceedStringStringMethod.init(this.bridge, (Class)null, "proceedSuper", String.class, String.class);
         this.cancelMethod.init(this.bridge, (Class)null, "cancelSuper");
         this.isFirstAttemptMethod.init(this.bridge, (Class)null, "isFirstAttemptSuper");
      }
   }
}
