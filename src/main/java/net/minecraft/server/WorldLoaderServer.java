package net.minecraft.server;
import com.google.common.collect.Lists;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldLoaderServer extends bqn {

   private static final Logger b = LogManager.getLogger();


   public WorldLoaderServer(File var1) {
      super(var1);
   }

   protected int c() {
      return 19133;
   }

   public void d() {
      bfx.a();
   }

   public IDataManager a(String var1, boolean var2) {
      return new ServerNBTManager(this.a, var1, var2);
   }

   public boolean b(String var1) {
      WorldData var2 = this.c(var1);
      return var2 != null && var2.l() != this.c();
   }

   public boolean convert(String var1, IProgressUpdate var2) {
      var2.a(0);
      ArrayList var3 = Lists.newArrayList();
      ArrayList var4 = Lists.newArrayList();
      ArrayList var5 = Lists.newArrayList();
      File var6 = new File(this.a, var1);
      File var7 = new File(var6, "DIM-1");
      File var8 = new File(var6, "DIM1");
      b.info("Scanning folders...");
      this.a(var6, (Collection)var3);
      if(var7.exists()) {
         this.a(var7, (Collection)var4);
      }

      if(var8.exists()) {
         this.a(var8, (Collection)var5);
      }

      int var9 = var3.size() + var4.size() + var5.size();
      b.info("Total conversion count is " + var9);
      WorldData var10 = this.c(var1);
      Object var11 = null;
      if(var10.getType() == WorldType.FLAT) {
         var11 = new asc(BiomeBase.PLAINS, 0.5F);
      } else {
         var11 = new WorldChunkManager(var10.getSeed(), var10.getType(), var10.getGeneratorOptions());
      }

      this.a(new File(var6, "region"), (Iterable)var3, (WorldChunkManager)var11, 0, var9, var2);
      this.a(new File(var7, "region"), (Iterable)var4, new asc(BiomeBase.HELL, 0.0F), var3.size(), var9, var2);
      this.a(new File(var8, "region"), (Iterable)var5, new asc(BiomeBase.SKY, 0.0F), var3.size() + var4.size(), var9, var2);
      var10.e(19133);
      if(var10.getType() == WorldType.NORMAL_1_1) {
         var10.setType(WorldType.NORMAL);
      }

      this.g(var1);
      IDataManager var12 = this.a(var1, false);
      var12.a(var10);
      return true;
   }

   private void g(String var1) {
      File var2 = new File(this.a, var1);
      if(!var2.exists()) {
         b.warn("Unable to create level.dat_mcr backup");
      } else {
         File var3 = new File(var2, "level.dat");
         if(!var3.exists()) {
            b.warn("Unable to create level.dat_mcr backup");
         } else {
            File var4 = new File(var2, "level.dat_mcr");
            if(!var3.renameTo(var4)) {
               b.warn("Unable to create level.dat_mcr backup");
            }

         }
      }
   }

   private void a(File var1, Iterable var2, WorldChunkManager var3, int var4, int var5, IProgressUpdate var6) {
      Iterator var7 = var2.iterator();

      while(var7.hasNext()) {
         File var8 = (File)var7.next();
         this.a(var1, var8, var3, var4, var5, var6);
         ++var4;
         int var9 = (int)Math.round(100.0D * (double)var4 / (double)var5);
         var6.a(var9);
      }

   }

   private void a(File var1, File var2, WorldChunkManager var3, int var4, int var5, IProgressUpdate var6) {
      try {
         String var7 = var2.getName();
         RegionFile var8 = new RegionFile(var2);
         RegionFile var9 = new RegionFile(new File(var1, var7.substring(0, var7.length() - ".mcr".length()) + ".mca"));

         for(int var10 = 0; var10 < 32; ++var10) {
            int var11;
            for(var11 = 0; var11 < 32; ++var11) {
               if(var8.c(var10, var11) && !var9.c(var10, var11)) {
                  DataInputStream var12 = var8.a(var10, var11);
                  if(var12 == null) {
                     b.warn("Failed to fetch input stream");
                  } else {
                     NBTTagCompound var13 = NBTCompressedStreamTools.a(var12);
                     var12.close();
                     NBTTagCompound var14 = var13.getCompound("Level");
                     bfu var15 = bft.a(var14);
                     NBTTagCompound var16 = new NBTTagCompound();
                     NBTTagCompound var17 = new NBTTagCompound();
                     var16.set("Level", (NBTBase)var17);
                     bft.a(var15, var17, var3);
                     DataOutputStream var18 = var9.b(var10, var11);
                     NBTCompressedStreamTools.a(var16, (DataOutput)var18);
                     var18.close();
                  }
               }
            }

            var11 = (int)Math.round(100.0D * (double)(var4 * 1024) / (double)(var5 * 1024));
            int var20 = (int)Math.round(100.0D * (double)((var10 + 1) * 32 + var4 * 1024) / (double)(var5 * 1024));
            if(var20 > var11) {
               var6.a(var20);
            }
         }

         var8.c();
         var9.c();
      } catch (IOException var19) {
         var19.printStackTrace();
      }

   }

   private void a(File var1, Collection var2) {
      File var3 = new File(var1, "region");
      File[] var4 = var3.listFiles(new bqk(this));
      if(var4 != null) {
         Collections.addAll(var2, var4);
      }

   }

}
