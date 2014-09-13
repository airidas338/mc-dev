package net.minecraft.server;

public class amo extends Item {

   public amo() {
      this.c(1);
      this.a(CreativeModeTab.f);
   }

   public amj b(amj var1, World var2, EntityHuman var3) {
      if(!var3.by.d) {
         --var1.b;
      }

      if(!var2.D) {
         var3.bj();
      }

      var3.b(ty.J[Item.b((Item)this)]);
      return var1.b <= 0?new amj(Items.aw):var1;
   }

   public int d(amj var1) {
      return 32;
   }

   public ano e(amj var1) {
      return ano.c;
   }

   public amj a(amj var1, World var2, EntityHuman var3) {
      var3.a(var1, this.d(var1));
      return var1;
   }
}
