package net.minecraft.server;
import java.util.Random;

public class BlockOre extends Block {

   public BlockOre() {
      super(Material.STONE);
      this.a(CreativeModeTab.b);
   }

   public Item a(IBlockData var1, Random var2, int var3) {
      return this == Blocks.COAL_ORE?Items.COAL:(this == Blocks.DIAMOND_ORE?Items.DIAMOND:(this == Blocks.LAPIS_ORE?Items.aW:(this == Blocks.EMERALD_ORE?Items.bO:(this == Blocks.QUARTZ_ORE?Items.cg:Item.getItemOf((Block)this)))));
   }

   public int a(Random var1) {
      return this == Blocks.LAPIS_ORE?4 + var1.nextInt(5):1;
   }

   public int getDropCount(int var1, Random var2) {
      if(var1 > 0 && Item.getItemOf((Block)this) != this.a((IBlockData)this.O().a().iterator().next(), var2, var1)) {
         int var3 = var2.nextInt(var1 + 2) - 1;
         if(var3 < 0) {
            var3 = 0;
         }

         return this.a(var2) * (var3 + 1);
      } else {
         return this.a(var2);
      }
   }

   public void dropNaturally(World var1, Location var2, IBlockData var3, float var4, int var5) {
      super.dropNaturally(var1, var2, var3, var4, var5);
      if(this.a(var3, var1.random, var5) != Item.getItemOf((Block)this)) {
         int var6 = 0;
         if(this == Blocks.COAL_ORE) {
            var6 = MathHelper.a(var1.random, 0, 2);
         } else if(this == Blocks.DIAMOND_ORE) {
            var6 = MathHelper.a(var1.random, 3, 7);
         } else if(this == Blocks.EMERALD_ORE) {
            var6 = MathHelper.a(var1.random, 3, 7);
         } else if(this == Blocks.LAPIS_ORE) {
            var6 = MathHelper.a(var1.random, 2, 5);
         } else if(this == Blocks.QUARTZ_ORE) {
            var6 = MathHelper.a(var1.random, 2, 5);
         }

         this.dropExperience(var1, var2, var6);
      }

   }

   public int j(World var1, Location var2) {
      return 0;
   }

   public int getDropData(IBlockData var1) {
      return this == Blocks.LAPIS_ORE?akv.l.b():0;
   }
}
