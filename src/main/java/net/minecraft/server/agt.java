package net.minecraft.server;
import java.util.Random;

class agt implements agw {

   public ItemStack a;
   public agx b;


   public agt(Item var1, agx var2) {
      this.a = new ItemStack(var1);
      this.b = var2;
   }

   public void a(aqd var1, Random var2) {
      int var3 = 1;
      if(this.b != null) {
         var3 = this.b.a(var2);
      }

      ItemStack var4 = new ItemStack(Items.bO, var3, 0);
      ItemStack var5 = new ItemStack(this.a.getItem(), 1, this.a.getData());
      var5 = EnchantmentManager.a(var2, var5, 5 + var2.nextInt(15));
      var1.add(new aqc(var4, var5));
   }
}
