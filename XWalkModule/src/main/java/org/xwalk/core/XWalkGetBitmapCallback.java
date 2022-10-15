package org.xwalk.core;

import android.graphics.Bitmap;
import java.util.ArrayList;

public abstract class XWalkGetBitmapCallback {
   private ArrayList<Object> constructorTypes = new ArrayList();
   private ArrayList<Object> constructorParams = new ArrayList();
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkGetBitmapCallback() {
      this.reflectionInit();
   }

   public abstract void onFinishGetBitmap(Bitmap var1, int var2);

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
         ReflectConstructor constructor = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkGetBitmapCallbackBridge"), paramTypes);

         try {
            this.bridge = constructor.newInstance(this.constructorParams.toArray());
         } catch (UnsupportedOperationException var5) {
            return;
         }

         if (this.postWrapperMethod != null) {
            this.postWrapperMethod.invoke();
         }

      }
   }
}
