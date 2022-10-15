package org.xwalk.core;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

public class XWalkWebResourceResponse {
   private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod setMimeTypeStringMethod = new ReflectMethod((Class)null, "setMimeType", new Class[0]);
   private ReflectMethod getMimeTypeMethod = new ReflectMethod((Class)null, "getMimeType", new Class[0]);
   private ReflectMethod setEncodingStringMethod = new ReflectMethod((Class)null, "setEncoding", new Class[0]);
   private ReflectMethod getEncodingMethod = new ReflectMethod((Class)null, "getEncoding", new Class[0]);
   private ReflectMethod setDataInputStreamMethod = new ReflectMethod((Class)null, "setData", new Class[0]);
   private ReflectMethod getDataMethod = new ReflectMethod((Class)null, "getData", new Class[0]);
   private ReflectMethod setStatusCodeAndReasonPhraseintStringMethod = new ReflectMethod((Class)null, "setStatusCodeAndReasonPhrase", new Class[0]);
   private ReflectMethod getStatusCodeMethod = new ReflectMethod((Class)null, "getStatusCode", new Class[0]);
   private ReflectMethod getReasonPhraseMethod = new ReflectMethod((Class)null, "getReasonPhrase", new Class[0]);
   private ReflectMethod setResponseHeadersMapMethod = new ReflectMethod((Class)null, "setResponseHeaders", new Class[0]);
   private ReflectMethod getResponseHeadersMethod = new ReflectMethod((Class)null, "getResponseHeaders", new Class[0]);

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkWebResourceResponse(Object bridge) {
      this.bridge = bridge;
      this.reflectionInit();
   }

   public void setMimeType(String mimeType) {
      try {
         this.setMimeTypeStringMethod.invoke(mimeType);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public String getMimeType() {
      try {
         return (String)this.getMimeTypeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setEncoding(String encoding) {
      try {
         this.setEncodingStringMethod.invoke(encoding);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public String getEncoding() {
      try {
         return (String)this.getEncodingMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setData(InputStream data) {
      try {
         this.setDataInputStreamMethod.invoke(data);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public InputStream getData() {
      try {
         return (InputStream)this.getDataMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setStatusCodeAndReasonPhrase(int statusCode, String reasonPhrase) {
      try {
         this.setStatusCodeAndReasonPhraseintStringMethod.invoke(statusCode, reasonPhrase);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public int getStatusCode() {
      try {
         return (Integer)this.getStatusCodeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public String getReasonPhrase() {
      try {
         return (String)this.getReasonPhraseMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public void setResponseHeaders(Map<String, String> headers) {
      try {
         this.setResponseHeadersMapMethod.invoke(headers);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var3);
      }

   }

   public Map<String, String> getResponseHeaders() {
      try {
         return (Map)this.getResponseHeadersMethod.invoke();
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
         this.setMimeTypeStringMethod.init(this.bridge, (Class)null, "setMimeTypeSuper", String.class);
         this.getMimeTypeMethod.init(this.bridge, (Class)null, "getMimeTypeSuper");
         this.setEncodingStringMethod.init(this.bridge, (Class)null, "setEncodingSuper", String.class);
         this.getEncodingMethod.init(this.bridge, (Class)null, "getEncodingSuper");
         this.setDataInputStreamMethod.init(this.bridge, (Class)null, "setDataSuper", InputStream.class);
         this.getDataMethod.init(this.bridge, (Class)null, "getDataSuper");
         this.setStatusCodeAndReasonPhraseintStringMethod.init(this.bridge, (Class)null, "setStatusCodeAndReasonPhraseSuper", Integer.TYPE, String.class);
         this.getStatusCodeMethod.init(this.bridge, (Class)null, "getStatusCodeSuper");
         this.getReasonPhraseMethod.init(this.bridge, (Class)null, "getReasonPhraseSuper");
         this.setResponseHeadersMapMethod.init(this.bridge, (Class)null, "setResponseHeadersSuper", Map.class);
         this.getResponseHeadersMethod.init(this.bridge, (Class)null, "getResponseHeadersSuper");
      }
   }
}
