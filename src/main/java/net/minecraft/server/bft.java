package net.minecraft.server;

public class bft {

   public static bfu a(NBTTagCompound var0) {
      int var1 = var0.getInt("xPos");
      int var2 = var0.getInt("zPos");
      bfu var3 = new bfu(var1, var2);
      var3.g = var0.getByteArray("Blocks");
      var3.f = new bfn(var0.getByteArray("Data"), 7);
      var3.e = new bfn(var0.getByteArray("SkyLight"), 7);
      var3.d = new bfn(var0.getByteArray("BlockLight"), 7);
      var3.c = var0.getByteArray("HeightMap");
      var3.b = var0.n("TerrainPopulated");
      var3.h = var0.getList("Entities", 10);
      var3.i = var0.getList("TileEntities", 10);
      var3.j = var0.getList("TileTicks", 10);

      try {
         var3.a = var0.getLong("LastUpdate");
      } catch (ClassCastException var5) {
         var3.a = (long)var0.getInt("LastUpdate");
      }

      return var3;
   }

   public static void a(bfu var0, NBTTagCompound var1, WorldChunkManager var2) {
      var1.setInt("xPos", var0.k);
      var1.setInt("zPos", var0.l);
      var1.setLong("LastUpdate", var0.a);
      int[] var3 = new int[var0.c.length];

      for(int var4 = 0; var4 < var0.c.length; ++var4) {
         var3[var4] = var0.c[var4];
      }

      var1.setIntArray("HeightMap", var3);
      var1.setBoolean("TerrainPopulated", var0.b);
      NBTTagList var16 = new NBTTagList();

      int var7;
      for(int var5 = 0; var5 < 8; ++var5) {
         boolean var6 = true;

         for(var7 = 0; var7 < 16 && var6; ++var7) {
            int var8 = 0;

            while(var8 < 16 && var6) {
               int var9 = 0;

               while(true) {
                  if(var9 < 16) {
                     int var10 = var7 << 11 | var9 << 7 | var8 + (var5 << 4);
                     byte var11 = var0.g[var10];
                     if(var11 == 0) {
                        ++var9;
                        continue;
                     }

                     var6 = false;
                  }

                  ++var8;
                  break;
               }
            }
         }

         if(!var6) {
            byte[] var19 = new byte[4096];
            bff var20 = new bff();
            bff var21 = new bff();
            bff var23 = new bff();

            for(int var22 = 0; var22 < 16; ++var22) {
               for(int var12 = 0; var12 < 16; ++var12) {
                  for(int var13 = 0; var13 < 16; ++var13) {
                     int var14 = var22 << 11 | var13 << 7 | var12 + (var5 << 4);
                     byte var15 = var0.g[var14];
                     var19[var12 << 8 | var13 << 4 | var22] = (byte)(var15 & 255);
                     var20.a(var22, var12, var13, var0.f.a(var22, var12 + (var5 << 4), var13));
                     var21.a(var22, var12, var13, var0.e.a(var22, var12 + (var5 << 4), var13));
                     var23.a(var22, var12, var13, var0.d.a(var22, var12 + (var5 << 4), var13));
                  }
               }
            }

            NBTTagCompound var24 = new NBTTagCompound();
            var24.setByte("Y", (byte)(var5 & 255));
            var24.setByteArray("Blocks", var19);
            var24.setByteArray("Data", var20.a());
            var24.setByteArray("SkyLight", var21.a());
            var24.setByteArray("BlockLight", var23.a());
            var16.a((NBTBase)var24);
         }
      }

      var1.set("Sections", (NBTBase)var16);
      byte[] var17 = new byte[256];

      for(int var18 = 0; var18 < 16; ++var18) {
         for(var7 = 0; var7 < 16; ++var7) {
            var17[var7 << 4 | var18] = (byte)(var2.a(new Location(var0.k << 4 | var18, 0, var0.l << 4 | var7), BiomeBase.ad).az & 255);
         }
      }

      var1.setByteArray("Biomes", var17);
      var1.set("Entities", (NBTBase)var0.h);
      var1.set("TileEntities", (NBTBase)var0.i);
      if(var0.j != null) {
         var1.set("TileTicks", (NBTBase)var0.j);
      }

   }
}
