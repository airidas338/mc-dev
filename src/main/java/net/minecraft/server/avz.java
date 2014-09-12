package net.minecraft.server;
import com.google.common.base.Predicate;

class avz implements Predicate {

   // $FF: synthetic field
   final avy a;


   avz(avy var1) {
      this.a = var1;
   }

   public boolean a(EnumFlowerType var1) {
      return var1.a() == this.a.j();
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((EnumFlowerType)var1);
   }
}
