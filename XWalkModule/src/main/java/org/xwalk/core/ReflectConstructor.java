package org.xwalk.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.RejectedExecutionException;

class ReflectConstructor {
   private Class<?> mClass;
   private Class<?>[] mParameterTypes;
   private Constructor<?> mConstructor;

   public ReflectConstructor() {
   }

   public ReflectConstructor(Class<?> clazz, Class<?>... parameterTypes) {
      this.init(clazz, parameterTypes);
   }

   public boolean init(Class<?> clazz, Class<?>... parameterTypes) {
      this.mClass = clazz;
      this.mParameterTypes = parameterTypes;
      this.mConstructor = null;
      if (this.mClass == null) {
         return false;
      } else {
         try {
            this.mConstructor = this.mClass.getConstructor(this.mParameterTypes);
         } catch (NoSuchMethodException var6) {
            try {
               this.mConstructor = this.mClass.getDeclaredConstructor(this.mParameterTypes);
               this.mConstructor.setAccessible(true);
            } catch (NoSuchMethodException var5) {
            }
         }

         return this.mConstructor != null;
      }
   }

   public Object newInstance(Object... args) {
      if (this.mConstructor == null) {
         throw new UnsupportedOperationException(this.toString());
      } else {
         try {
            return this.mConstructor.newInstance(args);
         } catch (InstantiationException | IllegalAccessException var3) {
            throw new RejectedExecutionException(var3);
         } catch (IllegalArgumentException var4) {
            throw var4;
         } catch (InvocationTargetException var5) {
            throw new RuntimeException(var5.getCause());
         }
      }
   }

   public boolean isNull() {
      return this.mConstructor == null;
   }

   public String toString() {
      if (this.mConstructor != null) {
         return this.mConstructor.toString();
      } else {
         String ret = "";
         if (this.mClass != null) {
            ret = ret + this.mClass.toString();
         }

         return ret;
      }
   }
}
