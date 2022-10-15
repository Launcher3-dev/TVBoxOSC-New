package org.xwalk.core;

import java.util.ArrayList;

public class XWalkHitTestResult {
   private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private ReflectMethod enumtypeClassValueOfMethod = new ReflectMethod();
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod getTypeMethod = new ReflectMethod((Class)null, "getType", new Class[0]);
   private ReflectMethod getExtraMethod = new ReflectMethod((Class)null, "getExtra", new Class[0]);

   private Object Converttype(XWalkHitTestResult.type type) {
      return this.enumtypeClassValueOfMethod.invoke(type.toString());
   }

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkHitTestResult(Object bridge) {
      this.bridge = bridge;
      this.reflectionInit();
   }

   public XWalkHitTestResult.type getType() {
      try {
         return XWalkHitTestResult.type.valueOf(this.getTypeMethod.invoke().toString());
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public String getExtra() {
      try {
         return (String)this.getExtraMethod.invoke();
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
         this.enumtypeClassValueOfMethod.init((Object)null, this.coreWrapper.getBridgeClass("XWalkHitTestResultInternal$type"), "valueOf", String.class);
         this.getTypeMethod.init(this.bridge, (Class)null, "getTypeSuper");
         this.getExtraMethod.init(this.bridge, (Class)null, "getExtraSuper");
      }
   }

   public static enum type {
      UNKNOWN_TYPE,
      ANCHOR_TYPE,
      PHONE_TYPE,
      GEO_TYPE,
      EMAIL_TYPE,
      IMAGE_TYPE,
      IMAGE_ANCHOR_TYPE,
      SRC_ANCHOR_TYPE,
      SRC_IMAGE_ANCHOR_TYPE,
      EDIT_TEXT_TYPE;
   }
}
