package net.minecraft.server;
import java.util.Random;

public class blh extends bmv {

   public blh() {}

   public blh(World var1, Random var2, int var3, int var4) {
      super(var3, var4);
      BiomeBase var5 = var1.b(new Location(var3 * 16 + 8, 0, var4 * 16 + 8));
      if(var5 != BiomeBase.K && var5 != BiomeBase.L) {
         if(var5 == BiomeBase.v) {
            blo var8 = new blo(var2, var3 * 16, var4 * 16);
            this.a.add(var8);
         } else if(var5 == BiomeBase.r || var5 == BiomeBase.G) {
            blk var7 = new blk(var2, var3 * 16, var4 * 16);
            this.a.add(var7);
         }
      } else {
         bll var6 = new bll(var2, var3 * 16, var4 * 16);
         this.a.add(var6);
      }

      this.c();
   }
}
