package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class bgq implements IChunkProvider {

   private World a;
   private Random b;
   private final IBlockData[] c = new IBlockData[256];
   private final biv d;
   private final List e = Lists.newArrayList();
   private final boolean f;
   private final boolean g;
   private bhy h;
   private bhy i;


   public bgq(World var1, long var2, boolean var4, String var5) {
      this.a = var1;
      this.b = new Random(var2);
      this.d = biv.a(var5);
      if(var4) {
         Map var6 = this.d.b();
         if(var6.containsKey("village")) {
            Map var7 = (Map)var6.get("village");
            if(!var7.containsKey("size")) {
               var7.put("size", "1");
            }

            this.e.add(new bmw(var7));
         }

         if(var6.containsKey("biome_1")) {
            this.e.add(new blg((Map)var6.get("biome_1")));
         }

         if(var6.containsKey("mineshaft")) {
            this.e.add(new bjd((Map)var6.get("mineshaft")));
         }

         if(var6.containsKey("stronghold")) {
            this.e.add(new blp((Map)var6.get("stronghold")));
         }

         if(var6.containsKey("oceanmonument")) {
            this.e.add(new bkg((Map)var6.get("oceanmonument")));
         }
      }

      if(this.d.b().containsKey("lake")) {
         this.h = new bhy(Blocks.STATIONARY_WATER);
      }

      if(this.d.b().containsKey("lava_lake")) {
         this.i = new bhy(Blocks.STATIONARY_LAVA);
      }

      this.g = this.d.b().containsKey("dungeon");
      boolean var11 = true;
      Iterator var12 = this.d.c().iterator();

      while(var12.hasNext()) {
         biw var8 = (biw)var12.next();

         for(int var9 = var8.d(); var9 < var8.d() + var8.b(); ++var9) {
            IBlockData var10 = var8.c();
            if(var10.c() != Blocks.AIR) {
               var11 = false;
               this.c[var9] = var10;
            }
         }
      }

      this.f = var11?false:this.d.b().containsKey("decoration");
   }

   public Chunk getOrCreateChunk(int var1, int var2) {
      bgk var3 = new bgk();

      int var7;
      for(int var4 = 0; var4 < this.c.length; ++var4) {
         IBlockData var5 = this.c[var4];
         if(var5 != null) {
            for(int var6 = 0; var6 < 16; ++var6) {
               for(var7 = 0; var7 < 16; ++var7) {
                  var3.a(var6, var4, var7, var5);
               }
            }
         }
      }

      Iterator var8 = this.e.iterator();

      while(var8.hasNext()) {
         bgt var9 = (bgt)var8.next();
         var9.a(this, this.a, var1, var2, var3);
      }

      Chunk var10 = new Chunk(this.a, var3, var1, var2);
      BiomeBase[] var11 = this.a.getWorldChunkManager().b((BiomeBase[])null, var1 * 16, var2 * 16, 16, 16);
      byte[] var12 = var10.k();

      for(var7 = 0; var7 < var12.length; ++var7) {
         var12[var7] = (byte)var11[var7].id;
      }

      var10.b();
      return var10;
   }

   public boolean isChunkLoaded(int var1, int var2) {
      return true;
   }

   public void getChunkAt(IChunkProvider var1, int var2, int var3) {
      int var4 = var2 * 16;
      int var5 = var3 * 16;
      Location var6 = new Location(var4, 0, var5);
      BiomeBase var7 = this.a.getBiome(new Location(var4 + 16, 0, var5 + 16));
      boolean var8 = false;
      this.b.setSeed(this.a.getSeed());
      long var9 = this.b.nextLong() / 2L * 2L + 1L;
      long var11 = this.b.nextLong() / 2L * 2L + 1L;
      this.b.setSeed((long)var2 * var9 + (long)var3 * var11 ^ this.a.getSeed());
      aqm var13 = new aqm(var2, var3);
      Iterator var14 = this.e.iterator();

      while(var14.hasNext()) {
         bmm var15 = (bmm)var14.next();
         boolean var16 = var15.a(this.a, this.b, var13);
         if(var15 instanceof bmw) {
            var8 |= var16;
         }
      }

      if(this.h != null && !var8 && this.b.nextInt(4) == 0) {
         this.h.generate(this.a, this.b, var6.a(this.b.nextInt(16) + 8, this.b.nextInt(256), this.b.nextInt(16) + 8));
      }

      if(this.i != null && !var8 && this.b.nextInt(8) == 0) {
         Location var17 = var6.a(this.b.nextInt(16) + 8, this.b.nextInt(this.b.nextInt(248) + 8), this.b.nextInt(16) + 8);
         if(var17.o() < 63 || this.b.nextInt(10) == 0) {
            this.i.generate(this.a, this.b, var17);
         }
      }

      if(this.g) {
         for(int var18 = 0; var18 < 8; ++var18) {
            (new bie()).generate(this.a, this.b, var6.a(this.b.nextInt(16) + 8, this.b.nextInt(256), this.b.nextInt(16) + 8));
         }
      }

      if(this.f) {
         var7.a(this.a, this.b, new Location(var4, 0, var5));
      }

   }

   public boolean a(IChunkProvider var1, Chunk var2, int var3, int var4) {
      return false;
   }

   public boolean saveChunks(boolean var1, IProgressUpdate var2) {
      return true;
   }

   public void c() {}

   public boolean unloadChunks() {
      return false;
   }

   public boolean canSave() {
      return true;
   }

   public String getName() {
      return "FlatLevelSource";
   }

   public List getMobsFor(EnumCreatureType var1, Location var2) {
      BiomeBase var3 = this.a.getBiome(var2);
      return var3.a(var1);
   }

   public Location findNearestMapFeature(World var1, String var2, Location var3) {
      if("Stronghold".equals(var2)) {
         Iterator var4 = this.e.iterator();

         while(var4.hasNext()) {
            bmm var5 = (bmm)var4.next();
            if(var5 instanceof blp) {
               return var5.b(var1, var3);
            }
         }
      }

      return null;
   }

   public int getLoadedChunks() {
      return 0;
   }

   public void recreateStructures(Chunk var1, int var2, int var3) {
      Iterator var4 = this.e.iterator();

      while(var4.hasNext()) {
         bmm var5 = (bmm)var4.next();
         var5.a(this, this.a, var2, var3, (bgk)null);
      }

   }

   public Chunk getChunkAt(Location var1) {
      return this.getOrCreateChunk(var1.n() >> 4, var1.p() >> 4);
   }
}
