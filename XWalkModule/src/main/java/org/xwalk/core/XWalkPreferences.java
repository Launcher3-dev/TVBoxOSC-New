package org.xwalk.core;

public class XWalkPreferences {
   public static final String REMOTE_DEBUGGING = "remote-debugging";
   public static final String ANIMATABLE_XWALK_VIEW = "animatable-xwalk-view";
   public static final String JAVASCRIPT_CAN_OPEN_WINDOW = "javascript-can-open-window";
   public static final String ALLOW_UNIVERSAL_ACCESS_FROM_FILE = "allow-universal-access-from-file";
   public static final String SUPPORT_MULTIPLE_WINDOWS = "support-multiple-windows";
   public static final String PROFILE_NAME = "profile-name";
   public static final String SPATIAL_NAVIGATION = "enable-spatial-navigation";
   public static final String ENABLE_THEME_COLOR = "enable-theme-color";
   public static final String ENABLE_JAVASCRIPT = "enable-javascript";
   public static final String ENABLE_EXTENSIONS = "enable-extensions";
   private static XWalkCoreWrapper coreWrapper;
   private static ReflectMethod setValueStringbooleanMethod = new ReflectMethod((Class)null, "setValue", new Class[0]);
   private static ReflectMethod setValueStringintMethod = new ReflectMethod((Class)null, "setValue", new Class[0]);
   private static ReflectMethod setValueStringStringMethod = new ReflectMethod((Class)null, "setValue", new Class[0]);
   private static ReflectMethod getValueStringMethod = new ReflectMethod((Class)null, "getValue", new Class[0]);
   private static ReflectMethod getBooleanValueStringMethod = new ReflectMethod((Class)null, "getBooleanValue", new Class[0]);
   private static ReflectMethod getIntegerValueStringMethod = new ReflectMethod((Class)null, "getIntegerValue", new Class[0]);
   private static ReflectMethod getStringValueStringMethod = new ReflectMethod((Class)null, "getStringValue", new Class[0]);

   public static void setValue(String key, boolean enabled) {
      reflectionInit();

      try {
         setValueStringbooleanMethod.invoke(key, enabled);
      } catch (UnsupportedOperationException var3) {
         if (coreWrapper == null) {
            setValueStringbooleanMethod.setArguments(key, enabled);
            XWalkCoreWrapper.reserveReflectMethod(setValueStringbooleanMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }

   }

   public static void setValue(String key, int value) {
      reflectionInit();

      try {
         setValueStringintMethod.invoke(key, value);
      } catch (UnsupportedOperationException var3) {
         if (coreWrapper == null) {
            setValueStringintMethod.setArguments(key, value);
            XWalkCoreWrapper.reserveReflectMethod(setValueStringintMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }

   }

   public static void setValue(String key, String value) {
      reflectionInit();

      try {
         setValueStringStringMethod.invoke(key, value);
      } catch (UnsupportedOperationException var3) {
         if (coreWrapper == null) {
            setValueStringStringMethod.setArguments(key, value);
            XWalkCoreWrapper.reserveReflectMethod(setValueStringStringMethod);
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
         }
      }

   }

   /** @deprecated */
   public static boolean getValue(String key) {
      reflectionInit();

      try {
         return (Boolean)getValueStringMethod.invoke(key);
      } catch (UnsupportedOperationException var2) {
         if (coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public static boolean getBooleanValue(String key) {
      reflectionInit();

      try {
         return (Boolean)getBooleanValueStringMethod.invoke(key);
      } catch (UnsupportedOperationException var2) {
         if (coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public static int getIntegerValue(String key) {
      reflectionInit();

      try {
         return (Integer)getIntegerValueStringMethod.invoke(key);
      } catch (UnsupportedOperationException var2) {
         if (coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public static String getStringValue(String key) {
      reflectionInit();

      try {
         return (String)getStringValueStringMethod.invoke(key);
      } catch (UnsupportedOperationException var2) {
         if (coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   static void reflectionInit() {
      if (coreWrapper == null) {
         XWalkCoreWrapper.initEmbeddedMode();
         coreWrapper = XWalkCoreWrapper.getInstance();
         if (coreWrapper == null) {
            XWalkCoreWrapper.reserveReflectClass(XWalkPreferences.class);
         } else {
            Class<?> bridgeClass = coreWrapper.getBridgeClass("XWalkPreferencesBridge");
            setValueStringbooleanMethod.init((Object)null, bridgeClass, "setValue", String.class, Boolean.TYPE);
            setValueStringintMethod.init((Object)null, bridgeClass, "setValue", String.class, Integer.TYPE);
            setValueStringStringMethod.init((Object)null, bridgeClass, "setValue", String.class, String.class);
            getValueStringMethod.init((Object)null, bridgeClass, "getValue", String.class);
            getBooleanValueStringMethod.init((Object)null, bridgeClass, "getBooleanValue", String.class);
            getIntegerValueStringMethod.init((Object)null, bridgeClass, "getIntegerValue", String.class);
            getStringValueStringMethod.init((Object)null, bridgeClass, "getStringValue", String.class);
         }
      }
   }
}
