package net.minecraft.server;
import com.google.common.base.Objects;

public abstract class bes implements bex {

   private final Class a;
   private final String b;


   protected bes(String var1, Class var2) {
      this.a = var2;
      this.b = var1;
   }

   public String a() {
      return this.b;
   }

   public Class b() {
      return this.a;
   }

   public String toString() {
      return Objects.toStringHelper(this).add("name", this.b).add("clazz", this.a).add("values", this.c()).toString();
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 != null && this.getClass() == var1.getClass()) {
         bes var2 = (bes)var1;
         return this.a.equals(var2.a) && this.b.equals(var2.b);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return 31 * this.a.hashCode() + this.b.hashCode();
   }
}
