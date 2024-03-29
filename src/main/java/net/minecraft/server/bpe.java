package net.minecraft.server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bpe extends GenLayer {

   private static final Logger c = LogManager.getLogger();
   private GenLayer d;


   public bpe(long var1, GenLayer var3, GenLayer var4) {
      super(var1);
      this.a = var3;
      this.d = var4;
   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.a.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
      int[] var6 = this.d.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
      int[] var7 = boy.a(var3 * var4);

      for(int var8 = 0; var8 < var4; ++var8) {
         for(int var9 = 0; var9 < var3; ++var9) {
            this.a((long)(var9 + var1), (long)(var8 + var2));
            int var10 = var5[var9 + 1 + (var8 + 1) * (var3 + 2)];
            int var11 = var6[var9 + 1 + (var8 + 1) * (var3 + 2)];
            boolean var12 = (var11 - 2) % 29 == 0;
            if(var10 > 255) {
               c.debug("old! " + var10);
            }

            if(var10 != 0 && var11 >= 2 && (var11 - 2) % 29 == 1 && var10 < 128) {
               if(BiomeBase.getBiome(var10 + 128) != null) {
                  var7[var9 + var8 * var3] = var10 + 128;
               } else {
                  var7[var9 + var8 * var3] = var10;
               }
            } else if(this.a(3) != 0 && !var12) {
               var7[var9 + var8 * var3] = var10;
            } else {
               int var13 = var10;
               int var14;
               if(var10 == BiomeBase.DESERT.id) {
                  var13 = BiomeBase.DESERT_HILLS.id;
               } else if(var10 == BiomeBase.FOREST.id) {
                  var13 = BiomeBase.FOREST_HILLS.id;
               } else if(var10 == BiomeBase.BIRCH_FOREST.id) {
                  var13 = BiomeBase.BIRCH_FOREST_HILLS.id;
               } else if(var10 == BiomeBase.ROOFED_FOREST.id) {
                  var13 = BiomeBase.PLAINS.id;
               } else if(var10 == BiomeBase.TAIGA.id) {
                  var13 = BiomeBase.TAIGA_HILLS.id;
               } else if(var10 == BiomeBase.MEGA_TAIGA.id) {
                  var13 = BiomeBase.MEGA_TAIGA_HILLS.id;
               } else if(var10 == BiomeBase.COLD_TAIGA.id) {
                  var13 = BiomeBase.COLD_TAIGA_HILLS.id;
               } else if(var10 == BiomeBase.PLAINS.id) {
                  if(this.a(3) == 0) {
                     var13 = BiomeBase.FOREST_HILLS.id;
                  } else {
                     var13 = BiomeBase.FOREST.id;
                  }
               } else if(var10 == BiomeBase.ICE_PLAINS.id) {
                  var13 = BiomeBase.ICE_MOUNTAINS.id;
               } else if(var10 == BiomeBase.JUNGLE.id) {
                  var13 = BiomeBase.JUNGLE_HILLS.id;
               } else if(var10 == BiomeBase.OCEAN.id) {
                  var13 = BiomeBase.DEEP_OCEAN.id;
               } else if(var10 == BiomeBase.EXTREME_HILLS.id) {
                  var13 = BiomeBase.EXTREME_HILLS_PLUS.id;
               } else if(var10 == BiomeBase.SAVANNA.id) {
                  var13 = BiomeBase.SAVANNA_PLATEAU.id;
               } else if(a(var10, BiomeBase.MESA_PLATEAU_F.id)) {
                  var13 = BiomeBase.MESA.id;
               } else if(var10 == BiomeBase.DEEP_OCEAN.id && this.a(3) == 0) {
                  var14 = this.a(2);
                  if(var14 == 0) {
                     var13 = BiomeBase.PLAINS.id;
                  } else {
                     var13 = BiomeBase.FOREST.id;
                  }
               }

               if(var12 && var13 != var10) {
                  if(BiomeBase.getBiome(var13 + 128) != null) {
                     var13 += 128;
                  } else {
                     var13 = var10;
                  }
               }

               if(var13 == var10) {
                  var7[var9 + var8 * var3] = var10;
               } else {
                  var14 = var5[var9 + 1 + (var8 + 1 - 1) * (var3 + 2)];
                  int var15 = var5[var9 + 1 + 1 + (var8 + 1) * (var3 + 2)];
                  int var16 = var5[var9 + 1 - 1 + (var8 + 1) * (var3 + 2)];
                  int var17 = var5[var9 + 1 + (var8 + 1 + 1) * (var3 + 2)];
                  int var18 = 0;
                  if(a(var14, var10)) {
                     ++var18;
                  }

                  if(a(var15, var10)) {
                     ++var18;
                  }

                  if(a(var16, var10)) {
                     ++var18;
                  }

                  if(a(var17, var10)) {
                     ++var18;
                  }

                  if(var18 >= 3) {
                     var7[var9 + var8 * var3] = var13;
                  } else {
                     var7[var9 + var8 * var3] = var10;
                  }
               }
            }
         }
      }

      return var7;
   }

}
