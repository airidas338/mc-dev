package net.minecraft.server;

public class ItemCoal extends Item {

   public ItemCoal() {
      this.a(true);
      this.d(0);
      this.a(CreativeModeTab.l);
   }

   public String e_(ItemStack var1) {
      return var1.i() == 1?"item.charcoal":"item.coal";
   }
}
