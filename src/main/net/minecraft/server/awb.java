package net.minecraft.server;
import com.google.common.base.Predicate;

final class awb implements Predicate {

   // $FF: synthetic field
   final awc a;


   awb(awc var1) {
      this.a = var1;
   }

   public boolean a(EnumFlowerType var1) {
      return var1.a() == this.a;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((EnumFlowerType)var1);
   }
}
