package org.xwalk.core;

import java.lang.reflect.Field;
import java.util.concurrent.RejectedExecutionException;

class ReflectField {
   private Object mInstance;
   private Class<?> mClass;
   private String mName;
   private Field mField;

   public ReflectField() {
   }

   public ReflectField(Object instance, String name) {
      this.init(instance, (Class)null, name);
   }

   public ReflectField(Class<?> clazz, String name) {
      this.init((Object)null, clazz, name);
   }

   public boolean init(Object instance, Class<?> clazz, String name) {
      this.mInstance = instance;
      this.mClass = clazz != null ? clazz : (instance != null ? instance.getClass() : null);
      this.mName = name;
      this.mField = null;
      if (this.mClass == null) {
         return false;
      } else {
         try {
            this.mField = this.mClass.getField(this.mName);
         } catch (NoSuchFieldException var8) {
            Class parent = this.mClass;

            while(parent != null) {
               try {
                  this.mField = parent.getDeclaredField(this.mName);
                  this.mField.setAccessible(true);
                  break;
               } catch (NoSuchFieldException var7) {
                  parent = parent.getSuperclass();
               }
            }
         }

         return this.mField != null;
      }
   }

   public Object get() {
      if (this.mField == null) {
         throw new UnsupportedOperationException(this.toString());
      } else {
         try {
            return this.mField.get(this.mInstance);
         } catch (NullPointerException | IllegalAccessException var2) {
            throw new RejectedExecutionException(var2);
         } catch (IllegalArgumentException var3) {
            throw var3;
         } catch (ExceptionInInitializerError var4) {
            throw new RuntimeException(var4);
         }
      }
   }

   public boolean isNull() {
      return this.mField == null;
   }

   public String toString() {
      if (this.mField != null) {
         return this.mField.toString();
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
}
