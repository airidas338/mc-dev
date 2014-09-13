package net.minecraft.server;
import com.google.common.base.Predicate;

class av implements Predicate {

   // $FF: synthetic field
   final EntityPlayer a;
   // $FF: synthetic field
   final tq b;
   // $FF: synthetic field
   final au c;


   av(au var1, EntityPlayer var2, tq var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public boolean a(Achievement var1) {
      return this.a.A().a(var1) && var1 != this.b;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((Achievement)var1);
   }
}
