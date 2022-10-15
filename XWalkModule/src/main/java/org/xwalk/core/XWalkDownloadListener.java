package org.xwalk.core;

import android.content.Context;
import android.webkit.DownloadListener;

import java.util.ArrayList;

public class XWalkDownloadListener {
	private final DownloadListener a;
   private ArrayList<Object> constructorTypes = new ArrayList();
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkDownloadListener(Context context, DownloadListener a) {
	   this.a = a;
	   this.constructorTypes.add(Context.class);
      this.constructorParams = new ArrayList();
      this.constructorParams.add(context);
      this.reflectionInit();
   }
	
	public void onDownloadStart(String var1, String var2, String var3, String var4, long var5) {
		a.onDownloadStart(var1, var2, var3, var4, var5);
	}
	
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
         ReflectConstructor constructor = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkDownloadListenerBridge"), paramTypes);

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
