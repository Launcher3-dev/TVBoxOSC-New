package org.xwalk.core;

import java.util.ArrayList;

public abstract class XWalkExtension {
   private ArrayList<Object> constructorTypes = new ArrayList();
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod postMessageintStringMethod = new ReflectMethod((Class)null, "postMessage", new Class[0]);
   private ReflectMethod postBinaryMessageintbyteArrayMethod = new ReflectMethod((Class)null, "postBinaryMessage", new Class[0]);
   private ReflectMethod broadcastMessageStringMethod = new ReflectMethod((Class)null, "broadcastMessage", new Class[0]);
   private ReflectMethod onInstanceCreatedintMethod = new ReflectMethod((Class)null, "onInstanceCreated", new Class[0]);
   private ReflectMethod onInstanceDestroyedintMethod = new ReflectMethod((Class)null, "onInstanceDestroyed", new Class[0]);
   private ReflectMethod onBinaryMessageintbyteArrayMethod = new ReflectMethod((Class)null, "onBinaryMessage", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkExtension(String name, String jsApi) {
      this.constructorTypes.add(String.class);
      this.constructorTypes.add(String.class);
      this.constructorParams = new ArrayList();
      this.constructorParams.add(name);
      this.constructorParams.add(jsApi);
      this.reflectionInit();
   }

   public XWalkExtension(String name, String jsApi, String[] entryPoints) {
      this.constructorTypes.add(String.class);
      this.constructorTypes.add(String.class);
      this.constructorTypes.add(String[].class);
      this.constructorParams = new ArrayList();
      this.constructorParams.add(name);
      this.constructorParams.add(jsApi);
      this.constructorParams.add(entryPoints);
      this.reflectionInit();
   }

   public void postMessage(int instanceID, String message) {
      try {
         this.postMessageintStringMethod.invoke(instanceID, message);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void postBinaryMessage(int instanceID, byte[] message) {
      try {
         this.postBinaryMessageintbyteArrayMethod.invoke(instanceID, message);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void broadcastMessage(String message) {
      try {
         this.broadcastMessageStringMethod.invoke(message);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void onInstanceCreated(int instanceID) {
      try {
         this.onInstanceCreatedintMethod.invoke(instanceID);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void onInstanceDestroyed(int instanceID) {
      try {
         this.onInstanceDestroyedintMethod.invoke(instanceID);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public void onBinaryMessage(int instanceID, byte[] message) {
      try {
         this.onBinaryMessageintbyteArrayMethod.invoke(instanceID, message);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public abstract void onMessage(int var1, String var2);

   public abstract String onSyncMessage(int var1, String var2);

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
         ReflectConstructor constructor = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkExtensionBridge"), paramTypes);

         try {
            this.bridge = constructor.newInstance(this.constructorParams.toArray());
         } catch (UnsupportedOperationException var5) {
            return;
         }

         if (this.postWrapperMethod != null) {
            this.postWrapperMethod.invoke();
         }

         this.postMessageintStringMethod.init(this.bridge, (Class)null, "postMessageSuper", Integer.TYPE, String.class);
         this.postBinaryMessageintbyteArrayMethod.init(this.bridge, (Class)null, "postBinaryMessageSuper", Integer.TYPE, byte[].class);
         this.broadcastMessageStringMethod.init(this.bridge, (Class)null, "broadcastMessageSuper", String.class);
         this.onInstanceCreatedintMethod.init(this.bridge, (Class)null, "onInstanceCreatedSuper", Integer.TYPE);
         this.onInstanceDestroyedintMethod.init(this.bridge, (Class)null, "onInstanceDestroyedSuper", Integer.TYPE);
         this.onBinaryMessageintbyteArrayMethod.init(this.bridge, (Class)null, "onBinaryMessageSuper", Integer.TYPE, byte[].class);
      }
   }
}
