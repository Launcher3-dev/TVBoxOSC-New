package org.xwalk.core;

public class XWalkViewDatabase {
   private static XWalkCoreWrapper coreWrapper;
   private static ReflectMethod hasFormDataMethod = new ReflectMethod((Class)null, "hasFormData", new Class[0]);
   private static ReflectMethod clearFormDataMethod = new ReflectMethod((Class)null, "clearFormData", new Class[0]);

   public static boolean hasFormData() {
      reflectionInit();

      try {
         return (Boolean)hasFormDataMethod.invoke();
      } catch (UnsupportedOperationException var1) {
         if (coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var1);
            return false;
         }
      }
   }

   public static void clearFormData() {
      reflectionInit();

      try {
         clearFormDataMethod.invoke();
      } catch (UnsupportedOperationException var1) {
         if (coreWrapper == null) {
            clearFormDataMethod.setArguments();
            XWalkCoreWrapper.reserveReflectMethod(clearFormDataMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var1);
         }
      }

   }

   static void reflectionInit() {
      if (coreWrapper == null) {
         XWalkCoreWrapper.initEmbeddedMode();
         coreWrapper = XWalkCoreWrapper.getInstance();
         if (coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectClass(XWalkViewDatabase.class);
         } else {
            Class<?> bridgeClass = coreWrapper.getBridgeClass("XWalkViewDatabaseBridge");
            hasFormDataMethod.init((Object)null, bridgeClass, "hasFormData");
            clearFormDataMethod.init((Object)null, bridgeClass, "clearFormData");
         }
      }
   }
}
