package org.xwalk.core;

import java.util.ArrayList;

public class XWalkCookieManager {
   private ArrayList<Object> constructorTypes = new ArrayList();
   private ArrayList<Object> constructorParams = new ArrayList();
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod setAcceptCookiebooleanMethod = new ReflectMethod((Class)null, "setAcceptCookie", new Class[0]);
   private ReflectMethod acceptCookieMethod = new ReflectMethod((Class)null, "acceptCookie", new Class[0]);
   private ReflectMethod setCookieStringStringMethod = new ReflectMethod((Class)null, "setCookie", new Class[0]);
   private ReflectMethod getCookieStringMethod = new ReflectMethod((Class)null, "getCookie", new Class[0]);
   private ReflectMethod removeSessionCookieMethod = new ReflectMethod((Class)null, "removeSessionCookie", new Class[0]);
   private ReflectMethod removeAllCookieMethod = new ReflectMethod((Class)null, "removeAllCookie", new Class[0]);
   private ReflectMethod hasCookiesMethod = new ReflectMethod((Class)null, "hasCookies", new Class[0]);
   private ReflectMethod removeExpiredCookieMethod = new ReflectMethod((Class)null, "removeExpiredCookie", new Class[0]);
   private ReflectMethod flushCookieStoreMethod = new ReflectMethod((Class)null, "flushCookieStore", new Class[0]);
   private ReflectMethod allowFileSchemeCookiesMethod = new ReflectMethod((Class)null, "allowFileSchemeCookies", new Class[0]);
   private ReflectMethod setAcceptFileSchemeCookiesbooleanMethod = new ReflectMethod((Class)null, "setAcceptFileSchemeCookies", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkCookieManager() {
      this.reflectionInit();
   }

   public void setAcceptCookie(boolean accept) {
      try {
         this.setAcceptCookiebooleanMethod.invoke(accept);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public boolean acceptCookie() {
      try {
         return (Boolean)this.acceptCookieMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setCookie(String url, String value) {
      try {
         this.setCookieStringStringMethod.invoke(url, value);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public String getCookie(String url) {
      try {
         return (String)this.getCookieStringMethod.invoke(url);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
            return null;
         }
      }
   }

   public void removeSessionCookie() {
      try {
         this.removeSessionCookieMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void removeAllCookie() {
      try {
         this.removeAllCookieMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public boolean hasCookies() {
      try {
         return (Boolean)this.hasCookiesMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void removeExpiredCookie() {
      try {
         this.removeExpiredCookieMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public void flushCookieStore() {
      try {
         this.flushCookieStoreMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   public boolean allowFileSchemeCookies() {
      try {
         return (Boolean)this.allowFileSchemeCookiesMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void setAcceptFileSchemeCookies(boolean accept) {
      try {
         this.setAcceptFileSchemeCookiesbooleanMethod.invoke(accept);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

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
         ReflectConstructor constructor = new ReflectConstructor(this.coreWrapper.getBridgeClass("XWalkCookieManagerBridge"), paramTypes);

         try {
            this.bridge = constructor.newInstance(this.constructorParams.toArray());
         } catch (UnsupportedOperationException var5) {
            return;
         }

         if (this.postWrapperMethod != null) {
            this.postWrapperMethod.invoke();
         }

         this.setAcceptCookiebooleanMethod.init(this.bridge, (Class)null, "setAcceptCookieSuper", Boolean.TYPE);
         this.acceptCookieMethod.init(this.bridge, (Class)null, "acceptCookieSuper");
         this.setCookieStringStringMethod.init(this.bridge, (Class)null, "setCookieSuper", String.class, String.class);
         this.getCookieStringMethod.init(this.bridge, (Class)null, "getCookieSuper", String.class);
         this.removeSessionCookieMethod.init(this.bridge, (Class)null, "removeSessionCookieSuper");
         this.removeAllCookieMethod.init(this.bridge, (Class)null, "removeAllCookieSuper");
         this.hasCookiesMethod.init(this.bridge, (Class)null, "hasCookiesSuper");
         this.removeExpiredCookieMethod.init(this.bridge, (Class)null, "removeExpiredCookieSuper");
         this.flushCookieStoreMethod.init(this.bridge, (Class)null, "flushCookieStoreSuper");
         this.allowFileSchemeCookiesMethod.init(this.bridge, (Class)null, "allowFileSchemeCookiesSuper");
         this.setAcceptFileSchemeCookiesbooleanMethod.init(this.bridge, (Class)null, "setAcceptFileSchemeCookiesSuper", Boolean.TYPE);
      }
   }
}
