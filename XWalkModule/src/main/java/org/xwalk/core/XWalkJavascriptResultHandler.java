package org.xwalk.core;

import java.util.ArrayList;

public class XWalkJavascriptResultHandler implements XWalkJavascriptResult {
   private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod confirmMethod = new ReflectMethod((Class)null, "confirm", new Class[0]);
   private ReflectMethod confirmWithResultStringMethod = new ReflectMethod((Class)null, "confirmWithResult", new Class[0]);
   private ReflectMethod cancelMethod = new ReflectMethod((Class)null, "cancel", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkJavascriptResultHandler(Object bridge) {
      this.bridge = bridge;
      this.reflectionInit();
   }

   public void confirm() {
      try {
         this.confirmMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void confirmWithResult(String promptResult) {
      try {
         this.confirmWithResultStringMethod.invoke(promptResult);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
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

   void reflectionInit() {
      XWalkCoreWrapper.initEmbeddedMode();
      this.coreWrapper = XWalkCoreWrapper.getInstance();
      if (this.coreWrapper == null) {
         XWalkCoreWrapper.reserveReflectObject(this);
      } else {
         this.confirmMethod.init(this.bridge, (Class)null, "confirmSuper");
         this.confirmWithResultStringMethod.init(this.bridge, (Class)null, "confirmWithResultSuper", String.class);
         this.cancelMethod.init(this.bridge, (Class)null, "cancelSuper");
      }
   }
}
