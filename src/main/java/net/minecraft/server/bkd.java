package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class bkd extends bkb {

   public bkd() {}

   public bkd(int var1, Random var2, bjb var3, EnumFacing var4) {
      super(var1);
      this.m = var4;
      this.l = var3;
   }

   public void a(bms var1, List var2, Random var3) {
      this.a((bkf)var1, var2, var3, 2, 0, false);
      this.b((bkf)var1, var2, var3, 0, 2, false);
      this.c((bkf)var1, var2, var3, 0, 2, false);
   }

   public static bkd a(List var0, Random var1, int var2, int var3, int var4, EnumFacing var5, int var6) {
      bjb var7 = bjb.a(var2, var3, var4, -2, 0, 0, 7, 9, 7, var5);
      return a(var7) && bms.a(var0, var7) == null?new bkd(var6, var1, var7, var5):null;
   }

   public boolean a(World var1, Random var2, bjb var3) {
      this.a(var1, var3, 0, 0, 0, 6, 1, 6, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 0, 2, 0, 6, 7, 6, Blocks.AIR.P(), Blocks.AIR.P(), false);
      this.a(var1, var3, 0, 2, 0, 1, 6, 0, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 0, 2, 6, 1, 6, 6, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 5, 2, 0, 6, 6, 0, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 5, 2, 6, 6, 6, 6, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 0, 2, 0, 0, 6, 1, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 0, 2, 5, 0, 6, 6, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 6, 2, 0, 6, 6, 1, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 6, 2, 5, 6, 6, 6, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 2, 6, 0, 4, 6, 0, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 2, 5, 0, 4, 5, 0, Blocks.NETHER_FENCE.P(), Blocks.NETHER_FENCE.P(), false);
      this.a(var1, var3, 2, 6, 6, 4, 6, 6, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 2, 5, 6, 4, 5, 6, Blocks.NETHER_FENCE.P(), Blocks.NETHER_FENCE.P(), false);
      this.a(var1, var3, 0, 6, 2, 0, 6, 4, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 0, 5, 2, 0, 5, 4, Blocks.NETHER_FENCE.P(), Blocks.NETHER_FENCE.P(), false);
      this.a(var1, var3, 6, 6, 2, 6, 6, 4, Blocks.NETHER_BRICK.P(), Blocks.NETHER_BRICK.P(), false);
      this.a(var1, var3, 6, 5, 2, 6, 5, 4, Blocks.NETHER_FENCE.P(), Blocks.NETHER_FENCE.P(), false);

      for(int var4 = 0; var4 <= 6; ++var4) {
         for(int var5 = 0; var5 <= 6; ++var5) {
            this.b(var1, Blocks.NETHER_BRICK.P(), var4, -1, var5, var3);
         }
      }

      return true;
   }
}
