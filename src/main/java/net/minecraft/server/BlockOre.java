package net.minecraft.server;
import java.util.Random;

public class BlockOre extends Block {

   public BlockOre() {
      super(Material.STONE);
      this.a(CreativeModeTab.b);
   }

   public Item a(IBlock var1, Random var2, int var3) {
      return this == Blocks.q?Items.h:(this == Blocks.ag?Items.i:(this == Blocks.x?Items.aW:(this == Blocks.bP?Items.bO:(this == Blocks.co?Items.cg:Item.a((Block)this)))));
   }

   public int a(Random var1) {
      return this == Blocks.x?4 + var1.nextInt(5):1;
   }

   public int a(int var1, Random var2) {
      if(var1 > 0 && Item.a((Block)this) != this.a((IBlock)this.O().a().iterator().next(), var2, var1)) {
         int var3 = var2.nextInt(var1 + 2) - 1;
         if(var3 < 0) {
            var3 = 0;
         }

         return this.a(var2) * (var3 + 1);
      } else {
         return this.a(var2);
      }
   }

   public void a(World var1, Location var2, IBlock var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if(this.a(var3, var1.s, var5) != Item.a((Block)this)) {
         int var6 = 0;
         if(this == Blocks.q) {
            var6 = MathHelper.a(var1.s, 0, 2);
         } else if(this == Blocks.ag) {
            var6 = MathHelper.a(var1.s, 3, 7);
         } else if(this == Blocks.bP) {
            var6 = MathHelper.a(var1.s, 3, 7);
         } else if(this == Blocks.x) {
            var6 = MathHelper.a(var1.s, 2, 5);
         } else if(this == Blocks.co) {
            var6 = MathHelper.a(var1.s, 2, 5);
         }

         this.b(var1, var2, var6);
      }

   }

   public int j(World var1, Location var2) {
      return 0;
   }

   public int a(IBlock var1) {
      return this == Blocks.x?akv.l.b():0;
   }
}
