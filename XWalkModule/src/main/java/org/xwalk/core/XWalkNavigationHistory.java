package org.xwalk.core;

import java.util.ArrayList;

public class XWalkNavigationHistory {
   private ArrayList<Object> constructorTypes;
   private ArrayList<Object> constructorParams;
   private ReflectMethod postWrapperMethod;
   private ReflectMethod enumDirectionClassValueOfMethod = new ReflectMethod();
   private XWalkCoreWrapper coreWrapper;
   private Object bridge;
   private ReflectMethod sizeMethod = new ReflectMethod((Class)null, "size", new Class[0]);
   private ReflectMethod hasItemAtintMethod = new ReflectMethod((Class)null, "hasItemAt", new Class[0]);
   private ReflectMethod getItemAtintMethod = new ReflectMethod((Class)null, "getItemAt", new Class[0]);
   private ReflectMethod getCurrentItemMethod = new ReflectMethod((Class)null, "getCurrentItem", new Class[0]);
   private ReflectMethod canGoBackMethod = new ReflectMethod((Class)null, "canGoBack", new Class[0]);
   private ReflectMethod canGoForwardMethod = new ReflectMethod((Class)null, "canGoForward", new Class[0]);
   private ReflectMethod navigateDirectionInternalintMethod = new ReflectMethod((Class)null, "navigate", new Class[0]);
   private ReflectMethod getCurrentIndexMethod = new ReflectMethod((Class)null, "getCurrentIndex", new Class[0]);
   private ReflectMethod clearMethod = new ReflectMethod((Class)null, "clear", new Class[0]);

   private Object ConvertDirection(XWalkNavigationHistory.Direction type) {
      return this.enumDirectionClassValueOfMethod.invoke(type.toString());
   }

   protected Object getBridge() {
      return this.bridge;
   }

   public XWalkNavigationHistory(Object bridge) {
      this.bridge = bridge;
      this.reflectionInit();
   }

   public int size() {
      try {
         return (Integer)this.sizeMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public boolean hasItemAt(int index) {
      try {
         return (Boolean)this.hasItemAtintMethod.invoke(index);
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
            return false;
         }
      }
   }

   public XWalkNavigationItem getItemAt(int index) {
      try {
         return (XWalkNavigationItem)this.coreWrapper.getWrapperObject(this.getItemAtintMethod.invoke(index));
      } catch (UnsupportedOperationException var3) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var3);
            return null;
         }
      }
   }

   public XWalkNavigationItem getCurrentItem() {
      try {
         return (XWalkNavigationItem)this.coreWrapper.getWrapperObject(this.getCurrentItemMethod.invoke());
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return null;
         }
      }
   }

   public boolean canGoBack() {
      try {
         return (Boolean)this.canGoBackMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public boolean canGoForward() {
      try {
         return (Boolean)this.canGoForwardMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return false;
         }
      }
   }

   public void navigate(XWalkNavigationHistory.Direction direction, int steps) {
      try {
         this.navigateDirectionInternalintMethod.invoke(this.ConvertDirection(direction), steps);
      } catch (UnsupportedOperationException var4) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var4);
      }

   }

   public int getCurrentIndex() {
      try {
         return (Integer)this.getCurrentIndexMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         } else {
            XWalkCoreWrapper.handleRuntimeError(var2);
            return 0;
         }
      }
   }

   public void clear() {
      try {
         this.clearMethod.invoke();
      } catch (UnsupportedOperationException var2) {
         if (this.coreWrapper == null) {
            throw new RuntimeException("Crosswalk's APIs are not ready yet");
         }

         XWalkCoreWrapper.handleRuntimeError(var2);
      }

   }

   void reflectionInit() {
      XWalkCoreWrapper.initEmbeddedMode();
      this.coreWrapper = XWalkCoreWrapper.getInstance();
      if (this.coreWrapper == null) {
         XWalkCoreWrapper.reserveReflectObject(this);
      } else {
         this.enumDirectionClassValueOfMethod.init((Object)null, this.coreWrapper.getBridgeClass("XWalkNavigationHistoryInternal$DirectionInternal"), "valueOf", String.class);
         this.sizeMethod.init(this.bridge, (Class)null, "sizeSuper");
         this.hasItemAtintMethod.init(this.bridge, (Class)null, "hasItemAtSuper", Integer.TYPE);
         this.getItemAtintMethod.init(this.bridge, (Class)null, "getItemAtSuper", Integer.TYPE);
         this.getCurrentItemMethod.init(this.bridge, (Class)null, "getCurrentItemSuper");
         this.canGoBackMethod.init(this.bridge, (Class)null, "canGoBackSuper");
         this.canGoForwardMethod.init(this.bridge, (Class)null, "canGoForwardSuper");
         this.navigateDirectionInternalintMethod.init(this.bridge, (Class)null, "navigateSuper", this.coreWrapper.getBridgeClass("XWalkNavigationHistoryInternal$DirectionInternal"), Integer.TYPE);
         this.getCurrentIndexMethod.init(this.bridge, (Class)null, "getCurrentIndexSuper");
         this.clearMethod.init(this.bridge, (Class)null, "clearSuper");
      }
   }

   public static enum Direction {
      BACKWARD,
      FORWARD;
   }
}
