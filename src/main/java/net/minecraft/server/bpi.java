package net.minecraft.server;

public class bpi extends GenLayer {

   private GenLayer c;
   private GenLayer d;


   public bpi(long var1, GenLayer var3, GenLayer var4) {
      super(var1);
      this.c = var3;
      this.d = var4;
   }

   public void a(long var1) {
      this.c.a(var1);
      this.d.a(var1);
      super.a(var1);
   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.c.a(var1, var2, var3, var4);
      int[] var6 = this.d.a(var1, var2, var3, var4);
      int[] var7 = boy.a(var3 * var4);

      for(int var8 = 0; var8 < var3 * var4; ++var8) {
         if(var5[var8] != BiomeBase.OCEAN.id && var5[var8] != BiomeBase.DEEP_OCEAN.id) {
            if(var6[var8] == BiomeBase.RIVER.id) {
               if(var5[var8] == BiomeBase.ICE_PLAINS.id) {
                  var7[var8] = BiomeBase.FROZEN_RIVER.id;
               } else if(var5[var8] != BiomeBase.MUSHROOM_ISLAND.id && var5[var8] != BiomeBase.MUSHROOM_SHORE.id) {
                  var7[var8] = var6[var8] & 255;
               } else {
                  var7[var8] = BiomeBase.MUSHROOM_SHORE.id;
               }
            } else {
               var7[var8] = var5[var8];
            }
         } else {
            var7[var8] = var5[var8];
         }
      }

      return var7;
   }
}
