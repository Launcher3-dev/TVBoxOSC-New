package org.xwalk.core;

import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

public class ClientCertRequestHandler implements ClientCertRequest {
   private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod proceedPrivateKeyListMethod = new ReflectMethod((Class)null, "proceed", new Class[0]);
   private ReflectMethod ignoreMethod = new ReflectMethod((Class)null, "ignore", new Class[0]);
   private ReflectMethod cancelMethod = new ReflectMethod((Class)null, "cancel", new Class[0]);
   private ReflectMethod getHostMethod = new ReflectMethod((Class)null, "getHost", new Class[0]);
   private ReflectMethod getPortMethod = new ReflectMethod((Class)null, "getPort", new Class[0]);
   private ReflectMethod getKeyTypesMethod = new ReflectMethod((Class)null, "getKeyTypes", new Class[0]);
   private ReflectMethod getPrincipalsMethod = new ReflectMethod((Class)null, "getPrincipals", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public ClientCertRequestHandler(Object bridge) {
      this.bridge = bridge;
      this.reflectionInit();
   }

   public void proceed(PrivateKey privateKey, List<X509Certificate> chain) {
      try {
         this.proceedPrivateKeyListMethod.invoke(privateKey, chain);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public void ignore() {
      try {
         this.ignoreMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
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

   public String getHost() {
      try {
         return (String)this.getHostMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public int getPort() {
      try {
         return (Integer)this.getPortMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public String[] getKeyTypes() {
      try {
         return (String[])((String[])this.getKeyTypesMethod.invoke());
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public Principal[] getPrincipals() {
      try {
         return (Principal[])((Principal[])this.getPrincipalsMethod.invoke());
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
         this.proceedPrivateKeyListMethod.init(this.bridge, (Class)null, "proceedSuper", PrivateKey.class, List.class);
         this.ignoreMethod.init(this.bridge, (Class)null, "ignoreSuper");
         this.cancelMethod.init(this.bridge, (Class)null, "cancelSuper");
         this.getHostMethod.init(this.bridge, (Class)null, "getHostSuper");
         this.getPortMethod.init(this.bridge, (Class)null, "getPortSuper");
         this.getKeyTypesMethod.init(this.bridge, (Class)null, "getKeyTypesSuper");
         this.getPrincipalsMethod.init(this.bridge, (Class)null, "getPrincipalsSuper");
      }
   }
}
