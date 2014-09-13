package net.minecraft.server;


public class ItemShears extends Item {

   public ItemShears() {
      this.c(1);
      this.d(238);
      this.a(CreativeModeTab.i);
   }

   public boolean a(amj var1, World var2, Block var3, Location var4, EntityLiving var5) {
      if(var3.r() != Material.LEAVES && var3 != Blocks.G && var3 != Blocks.H && var3 != Blocks.bn && var3 != Blocks.bS && var3 != Blocks.L) {
         return super.a(var1, var2, var3, var4, var5);
      } else {
         var1.a(1, var5);
         return true;
      }
   }

   public boolean b(Block var1) {
      return var1 == Blocks.G || var1 == Blocks.af || var1 == Blocks.bS;
   }

   public float a(amj var1, Block var2) {
      return var2 != Blocks.G && var2.r() != Material.LEAVES?(var2 == Blocks.L?5.0F:super.a(var1, var2)):15.0F;
   }
}
