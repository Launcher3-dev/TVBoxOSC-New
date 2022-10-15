package org.xwalk.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.RejectedExecutionException;

class ReflectMethod {
   private Object mInstance;
   private Class<?> mClass;
   private String mName;
   private Class<?>[] mParameterTypes;
   private Method mMethod;
   private Object[] mArguments;

   public ReflectMethod() {
   }

   public ReflectMethod(Object instance, String name, Class<?>... parameterTypes) {
      this.init(instance, (Class)null, name, parameterTypes);
   }

   public ReflectMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
      this.init((Object)null, clazz, name, parameterTypes);
   }

   public boolean init(Object instance, Class<?> clazz, String name, Class<?>... parameterTypes) {
      this.mInstance = instance;
      this.mClass = clazz != null ? clazz : (instance != null ? instance.getClass() : null);
      this.mName = name;
      this.mParameterTypes = parameterTypes;
      this.mMethod = null;
      if (this.mClass == null) {
         return false;
      } else {
         try {
            this.mMethod = this.mClass.getMethod(this.mName, this.mParameterTypes);
         } catch (NoSuchMethodException var9) {
            Class parent = this.mClass;

            while(parent != null) {
               try {
                  this.mMethod = parent.getDeclaredMethod(this.mName, this.mParameterTypes);
                  this.mMethod.setAccessible(true);
                  break;
               } catch (NoSuchMethodException var8) {
                  parent = parent.getSuperclass();
               }
            }
         }

         return this.mMethod != null;
      }
   }

   public Object invoke(Object... args) {
      if (this.mMethod == null) {
         throw new UnsupportedOperationException(this.toString());
      } else {
         try {
            return this.mMethod.invoke(this.mInstance, args);
         } catch (NullPointerException | IllegalAccessException var3) {
            throw new RejectedExecutionException(var3);
         } catch (IllegalArgumentException var4) {
            throw var4;
         } catch (InvocationTargetException var5) {
            throw new RuntimeException(var5.getCause());
         }
      }
   }

   public boolean isNull() {
      return this.mMethod == null;
   }

   public String toString() {
      if (this.mMethod != null) {
         return this.mMethod.toString();
      } else {
         String ret = "";
         if (this.mClass != null) {
            ret = ret + this.mClass.toString() + ".";
         }

         if (this.mName != null) {
            ret = ret + this.mName;
         }

         return ret;
      }
   }

   public String getName() {
      return this.mName;
   }

   public Object getInstance() {
      return this.mInstance;
   }

   public Object[] getArguments() {
      return this.mArguments;
   }

   public void setArguments(Object... args) {
      this.mArguments = args;
   }

   public Object invokeWithArguments() {
      return this.invoke(this.mArguments);
   }
}
