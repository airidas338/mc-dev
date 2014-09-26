package net.minecraft.server;

public class ItemBook extends Item {

   public boolean f_(ItemStack var1) {
      return var1.count == 1;
   }

   public int b() {
      return 1;
   }
}
