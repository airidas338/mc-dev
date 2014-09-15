package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ChunkRegionLoader implements IChunkLoader, brq {

   private static final Logger a = LogManager.getLogger();
   private List b = Lists.newArrayList();
   private Set c = Sets.newHashSet();
   private Object d = new Object();
   private final File e;


   public ChunkRegionLoader(File var1) {
      this.e = var1;
   }

   public Chunk a(World var1, int var2, int var3) throws IOException {
      NBTTagCompound var4 = null;
      aqm var5 = new aqm(var2, var3);
      Object var6 = this.d;
      synchronized(this.d) {
         if(this.c.contains(var5)) {
            for(int var7 = 0; var7 < this.b.size(); ++var7) {
               if(((bfz)this.b.get(var7)).a.equals(var5)) {
                  var4 = ((bfz)this.b.get(var7)).b;
                  break;
               }
            }
         }
      }

      if(var4 == null) {
         DataInputStream var10 = bfx.c(this.e, var2, var3);
         if(var10 == null) {
            return null;
         }

         var4 = NBTCompressedStreamTools.a(var10);
      }

      return this.a(var1, var2, var3, var4);
   }

   protected Chunk a(World var1, int var2, int var3, NBTTagCompound var4) {
      if(!var4.hasKeyOfType("Level", 10)) {
         a.error("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
         return null;
      } else if(!var4.getCompound("Level").hasKeyOfType("Sections", 9)) {
         a.error("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
         return null;
      } else {
         Chunk var5 = this.a(var1, var4.getCompound("Level"));
         if(!var5.a(var2, var3)) {
            a.error("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var5.a + ", " + var5.b + ")");
            var4.setInt("xPos", var2);
            var4.setInt("zPos", var3);
            var5 = this.a(var1, var4.getCompound("Level"));
         }

         return var5;
      }
   }

   public void a(World var1, Chunk var2) throws ExceptionWorldConflict {
      var1.I();

      try {
         NBTTagCompound var3 = new NBTTagCompound();
         NBTTagCompound var4 = new NBTTagCompound();
         var3.set("Level", (NBTBase)var4);
         this.a(var2, var1, var4);
         this.a(var2.j(), var3);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   protected void a(aqm var1, NBTTagCompound var2) {
      Object var3 = this.d;
      synchronized(this.d) {
         if(this.c.contains(var1)) {
            for(int var4 = 0; var4 < this.b.size(); ++var4) {
               if(((bfz)this.b.get(var4)).a.equals(var1)) {
                  this.b.set(var4, new bfz(var1, var2));
                  return;
               }
            }
         }

         this.b.add(new bfz(var1, var2));
         this.c.add(var1);
         FileIOThread.a().a(this);
      }
   }

   public boolean c() {
      bfz var1 = null;
      Object var2 = this.d;
      synchronized(this.d) {
         if(this.b.isEmpty()) {
            return false;
         }

         var1 = (bfz)this.b.remove(0);
         this.c.remove(var1.a);
      }

      if(var1 != null) {
         try {
            this.a(var1);
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      return true;
   }

   private void a(bfz var1) throws IOException {
      DataOutputStream var2 = bfx.d(this.e, var1.a.a, var1.a.b);
      NBTCompressedStreamTools.a(var1.b, (DataOutput)var2);
      var2.close();
   }

   public void b(World var1, Chunk var2) {}

   public void a() {}

   public void b() {
      while(this.c()) {
         ;
      }

   }

   private void a(Chunk var1, World var2, NBTTagCompound var3) {
      var3.setByte("V", (byte)1);
      var3.setInt("xPos", var1.a);
      var3.setInt("zPos", var1.b);
      var3.setLong("LastUpdate", var2.K());
      var3.setIntArray("HeightMap", var1.q());
      var3.setBoolean("TerrainPopulated", var1.t());
      var3.setBoolean("LightPopulated", var1.u());
      var3.setLong("InhabitedTime", var1.w());
      bfm[] var4 = var1.h();
      NBTTagList var5 = new NBTTagList();
      boolean var6 = !var2.worldProvider.o();
      bfm[] var7 = var4;
      int var8 = var4.length;

      NBTTagCompound var11;
      for(int var9 = 0; var9 < var8; ++var9) {
         bfm var10 = var7[var9];
         if(var10 != null) {
            var11 = new NBTTagCompound();
            var11.setByte("Y", (byte)(var10.d() >> 4 & 255));
            byte[] var12 = new byte[var10.g().length];
            bff var13 = new bff();
            bff var14 = null;

            for(int var15 = 0; var15 < var10.g().length; ++var15) {
               char var16 = var10.g()[var15];
               int var17 = var15 & 15;
               int var18 = var15 >> 8 & 15;
               int var19 = var15 >> 4 & 15;
               if(var16 >> 12 != 0) {
                  if(var14 == null) {
                     var14 = new bff();
                  }

                  var14.a(var17, var18, var19, var16 >> 12);
               }

               var12[var15] = (byte)(var16 >> 4 & 255);
               var13.a(var17, var18, var19, var16 & 15);
            }

            var11.setByteArray("Blocks", var12);
            var11.setByteArray("Data", var13.a());
            if(var14 != null) {
               var11.setByteArray("Add", var14.a());
            }

            var11.setByteArray("BlockLight", var10.h().a());
            if(var6) {
               var11.setByteArray("SkyLight", var10.i().a());
            } else {
               var11.setByteArray("SkyLight", new byte[var10.h().a().length]);
            }

            var5.a((NBTBase)var11);
         }
      }

      var3.set("Sections", (NBTBase)var5);
      var3.setByteArray("Biomes", var1.k());
      var1.g(false);
      NBTTagList var20 = new NBTTagList();

      Iterator var22;
      for(var8 = 0; var8 < var1.s().length; ++var8) {
         var22 = var1.s()[var8].iterator();

         while(var22.hasNext()) {
            Entity var25 = (Entity)var22.next();
            var11 = new NBTTagCompound();
            if(var25.d(var11)) {
               var1.g(true);
               var20.a((NBTBase)var11);
            }
         }
      }

      var3.set("Entities", (NBTBase)var20);
      NBTTagList var21 = new NBTTagList();
      var22 = var1.r().values().iterator();

      while(var22.hasNext()) {
         TileEntity var26 = (TileEntity)var22.next();
         var11 = new NBTTagCompound();
         var26.b(var11);
         var21.a((NBTBase)var11);
      }

      var3.set("TileEntities", (NBTBase)var21);
      List var24 = var2.a(var1, false);
      if(var24 != null) {
         long var23 = var2.K();
         NBTTagList var27 = new NBTTagList();
         Iterator var28 = var24.iterator();

         while(var28.hasNext()) {
            NextTickListEntry var29 = (NextTickListEntry)var28.next();
            NBTTagCompound var31 = new NBTTagCompound();
            RegistryPrepender var30 = (RegistryPrepender)Block.REGISTRY.c(var29.a());
            var31.setString("i", var30 == null?"":var30.toString());
            var31.setInt("x", var29.a.n());
            var31.setInt("y", var29.a.o());
            var31.setInt("z", var29.a.p());
            var31.setInt("t", (int)(var29.b - var23));
            var31.setInt("p", var29.c);
            var27.a((NBTBase)var31);
         }

         var3.set("TileTicks", (NBTBase)var27);
      }

   }

   private Chunk a(World var1, NBTTagCompound var2) {
      int var3 = var2.getInt("xPos");
      int var4 = var2.getInt("zPos");
      Chunk var5 = new Chunk(var1, var3, var4);
      var5.a(var2.getIntArray("HeightMap"));
      var5.d(var2.getBoolean("TerrainPopulated"));
      var5.e(var2.getBoolean("LightPopulated"));
      var5.c(var2.getLong("InhabitedTime"));
      NBTTagList var6 = var2.getList("Sections", 10);
      byte var7 = 16;
      bfm[] var8 = new bfm[var7];
      boolean var9 = !var1.worldProvider.o();

      for(int var10 = 0; var10 < var6.c(); ++var10) {
         NBTTagCompound var11 = var6.b(var10);
         byte var12 = var11.getByte("Y");
         bfm var13 = new bfm(var12 << 4, var9);
         byte[] var14 = var11.getByteArray("Blocks");
         bff var15 = new bff(var11.getByteArray("Data"));
         bff var16 = var11.hasKeyOfType("Add", 7)?new bff(var11.getByteArray("Add")):null;
         char[] var17 = new char[var14.length];

         for(int var18 = 0; var18 < var17.length; ++var18) {
            int var19 = var18 & 15;
            int var20 = var18 >> 8 & 15;
            int var21 = var18 >> 4 & 15;
            int var22 = var16 != null?var16.a(var19, var20, var21):0;
            var17[var18] = (char)(var22 << 12 | (var14[var18] & 255) << 4 | var15.a(var19, var20, var21));
         }

         var13.a(var17);
         var13.a(new bff(var11.getByteArray("BlockLight")));
         if(var9) {
            var13.b(new bff(var11.getByteArray("SkyLight")));
         }

         var13.e();
         var8[var12] = var13;
      }

      var5.a(var8);
      if(var2.hasKeyOfType("Biomes", 7)) {
         var5.a(var2.getByteArray("Biomes"));
      }

      NBTTagList var24 = var2.getList("Entities", 10);
      if(var24 != null) {
         for(int var23 = 0; var23 < var24.c(); ++var23) {
            NBTTagCompound var25 = var24.b(var23);
            Entity var30 = EntityTypes.a(var25, var1);
            var5.g(true);
            if(var30 != null) {
               var5.a(var30);
               Entity var35 = var30;

               for(NBTTagCompound var33 = var25; var33.hasKeyOfType("Riding", 10); var33 = var33.getCompound("Riding")) {
                  Entity var36 = EntityTypes.a(var33.getCompound("Riding"), var1);
                  if(var36 != null) {
                     var5.a(var36);
                     var35.a(var36);
                  }

                  var35 = var36;
               }
            }
         }
      }

      NBTTagList var27 = var2.getList("TileEntities", 10);
      if(var27 != null) {
         for(int var26 = 0; var26 < var27.c(); ++var26) {
            NBTTagCompound var28 = var27.b(var26);
            TileEntity var32 = TileEntity.c(var28);
            if(var32 != null) {
               var5.a(var32);
            }
         }
      }

      if(var2.hasKeyOfType("TileTicks", 9)) {
         NBTTagList var31 = var2.getList("TileTicks", 10);
         if(var31 != null) {
            for(int var29 = 0; var29 < var31.c(); ++var29) {
               NBTTagCompound var34 = var31.b(var29);
               Block var37;
               if(var34.hasKeyOfType("i", 8)) {
                  var37 = Block.b(var34.getString("i"));
               } else {
                  var37 = Block.c(var34.getInt("i"));
               }

               var1.b(new Location(var34.getInt("x"), var34.getInt("y"), var34.getInt("z")), var37, var34.getInt("t"), var34.getInt("p"));
            }
         }
      }

      return var5;
   }

}
