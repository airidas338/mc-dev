package net.minecraft.server;
import java.util.Random;

class ags implements agw {

   public void a(aqd var1, Random var2) {
      Enchantment var3 = Enchantment.b[var2.nextInt(Enchantment.b.length)];
      int var4 = MathHelper.a(var2, var3.e(), var3.b());
      ItemStack var5 = Items.cd.a(new apo(var3, var4));
      int var6 = 2 + var2.nextInt(5 + var4 * 10) + 3 * var4;
      if(var6 > 64) {
         var6 = 64;
      }

      var1.add(new aqc(new ItemStack(Items.aL), new ItemStack(Items.bO, var6), var5));
   }
}
