package net.minecraft.server;

class ajc extends ajk {

   // $FF: synthetic field
   final int a;
   // $FF: synthetic field
   final ajb b;


   ajc(ajb var1, IInventory var2, int var3, int var4, int var5, int var6) {
      super(var2, var3, var4, var5);
      this.b = var1;
      this.a = var6;
   }

   public int a() {
      return 1;
   }

   public boolean a(ItemStack var1) {
      return var1 == null?false:(var1.b() instanceof ItemArmor?((ItemArmor)var1.b()).b == this.a:(var1.b() != Item.a(Blocks.aU) && var1.b() != Items.bX?false:this.a == 0));
   }
}
