package org.xwalk.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;

public abstract class XWalkExternalExtensionManager {
   private ArrayList<Object> constructorTypes = new ArrayList();
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod getViewActivityMethod = new ReflectMethod((Class)null, "getViewActivity", new Class[0]);
   private ReflectMethod getViewContextMethod = new ReflectMethod((Class)null, "getViewContext", new Class[0]);
   private ReflectMethod loadExtensionStringMethod = new ReflectMethod((Class)null, "loadExtension", new Class[0]);
   private ReflectMethod onStartMethod = new ReflectMethod((Class)null, "onStart", new Class[0]);
   private ReflectMethod onResumeMethod = new ReflectMethod((Class)null, "onResume", new Class[0]);
   private ReflectMethod onPauseMethod = new ReflectMethod((Class)null, "onPause", new Class[0]);
   private ReflectMethod onStopMethod = new ReflectMethod((Class)null, "onStop", new Class[0]);
   private ReflectMethod onDestroyMethod = new ReflectMethod((Class)null, "onDestroy", new Class[0]);
   private ReflectMethod onActivityResultintintIntentMethod = new ReflectMethod((Class)null, "onActivityResult", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkExternalExtensionManager(XWalkView view) {
      this.constructorTypes.add("XWalkViewBridge");
      this.constructorParams = new ArrayList();
      this.constructorParams.add(view);
      this.reflectionInit();
   }

   /** @deprecated */
   @Deprecated
   public Activity getViewActivity() {
      try {
         return (Activity)this.getViewActivityMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public Context getViewContext() {
      try {
         return (Context)this.getViewContextMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void loadExtension(String extensionPath) {
      try {
         this.loadExtensionStringMethod.invoke(extensionPath);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void onStart() {
      try {
         this.onStartMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void onResume() {
      try {
         this.onResumeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void onPause() {
      try {
         this.onPauseMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void onStop() {
      try {
         this.onStopMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void onDestroy() {
      try {
         this.onDestroyMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   /** @deprecated */
   @Deprecated
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
      try {
         this.onActivityResultintintIntentMethod.invoke(requestCode, resultCode, data);
      } catch (UnsupportedOperationException var5) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var5);
      }

   }

   public abstract void onNewIntent(Intent var1);

   void reflectionInit() {
      XWalkCoreWrapper.initEmbeddedMode();
      this.coreWrapper = XWalkCoreWrapper.getInstance();
      if (this.coreWrapper == null) {
         XWalkCoreWrapper.reserveReflectObject(this);
      } else {
         int length = this.constructorTypes.size();
         Class<?>[] paramTypes = new Class[length + 1];

         for(int i = 0; i < length; ++i) {
            Object type = this.constructorTypes.get(i);
            if (type instanceof String) {
               paramTypes[i] = this.coreWrapper.getBridgeClass((String)type);
               this.constructorParams.set(i, this.coreWrapper.getBridgeObject(this.constructorParams.get(i)));
            } else if (type instanceof Class) {
               paramTypes[i] = (Class)type;
            } else {
               assert false;
            }
         }

         paramTypes[length] = Object.class;
         this.constructorParams.add(this);
         ReflectConstructor constructor = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExternalExtensionManagerBridge"), paramTypes);

         try {
            this.bridge = constructor.newInstance(this.constructorParams.toArray());
         } catch (UnsupportedOperationException var5) {
            return;
         }

         if (this.postWrapperMethod != null) {
            this.postWrapperMethod.invoke();
         }

         this.getViewActivityMethod.init(this.bridge, (Class)null, "getViewActivitySuper");
         this.getViewContextMethod.init(this.bridge, (Class)null, "getViewContextSuper");
         this.loadExtensionStringMethod.init(this.bridge, (Class)null, "loadExtensionSuper", String.class);
         this.onStartMethod.init(this.bridge, (Class)null, "onStartSuper");
         this.onResumeMethod.init(this.bridge, (Class)null, "onResumeSuper");
         this.onPauseMethod.init(this.bridge, (Class)null, "onPauseSuper");
         this.onStopMethod.init(this.bridge, (Class)null, "onStopSuper");
         this.onDestroyMethod.init(this.bridge, (Class)null, "onDestroySuper");
         this.onActivityResultintintIntentMethod.init(this.bridge, (Class)null, "onActivityResultSuper", Integer.TYPE, Integer.TYPE, Intent.class);
      }
   }
}
