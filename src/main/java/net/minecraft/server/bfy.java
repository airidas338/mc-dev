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

public class bfy implements bfq, brq {

   private static final Logger a = LogManager.getLogger();
   private List b = Lists.newArrayList();
   private Set c = Sets.newHashSet();
   private Object d = new Object();
   private final File e;


   public bfy(File var1) {
      this.e = var1;
   }

   public bfh a(World var1, int var2, int var3) throws IOException {
      fn var4 = null;
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

         var4 = fz.a(var10);
      }

      return this.a(var1, var2, var3, var4);
   }

   protected bfh a(World var1, int var2, int var3, fn var4) {
      if(!var4.b("Level", 10)) {
         a.error("Chunk file at " + var2 + "," + var3 + " is missing level data, skipping");
         return null;
      } else if(!var4.m("Level").b("Sections", 9)) {
         a.error("Chunk file at " + var2 + "," + var3 + " is missing block data, skipping");
         return null;
      } else {
         bfh var5 = this.a(var1, var4.m("Level"));
         if(!var5.a(var2, var3)) {
            a.error("Chunk file at " + var2 + "," + var3 + " is in the wrong location; relocating. (Expected " + var2 + ", " + var3 + ", got " + var5.a + ", " + var5.b + ")");
            var4.a("xPos", var2);
            var4.a("zPos", var3);
            var5 = this.a(var1, var4.m("Level"));
         }

         return var5;
      }
   }

   public void a(World var1, bfh var2) throws ExceptionWorldConflict {
      var1.I();

      try {
         fn var3 = new fn();
         fn var4 = new fn();
         var3.a("Level", (gd)var4);
         this.a(var2, var1, var4);
         this.a(var2.j(), var3);
      } catch (Exception var5) {
         var5.printStackTrace();
      }

   }

   protected void a(aqm var1, fn var2) {
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
         brp.a().a(this);
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
      fz.a(var1.b, (DataOutput)var2);
      var2.close();
   }

   public void b(World var1, bfh var2) {}

   public void a() {}

   public void b() {
      while(this.c()) {
         ;
      }

   }

   private void a(bfh var1, World var2, fn var3) {
      var3.a("V", (byte)1);
      var3.a("xPos", var1.a);
      var3.a("zPos", var1.b);
      var3.a("LastUpdate", var2.K());
      var3.a("HeightMap", var1.q());
      var3.a("TerrainPopulated", var1.t());
      var3.a("LightPopulated", var1.u());
      var3.a("InhabitedTime", var1.w());
      bfm[] var4 = var1.h();
      fv var5 = new fv();
      boolean var6 = !var2.t.o();
      bfm[] var7 = var4;
      int var8 = var4.length;

      fn var11;
      for(int var9 = 0; var9 < var8; ++var9) {
         bfm var10 = var7[var9];
         if(var10 != null) {
            var11 = new fn();
            var11.a("Y", (byte)(var10.d() >> 4 & 255));
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

            var11.a("Blocks", var12);
            var11.a("Data", var13.a());
            if(var14 != null) {
               var11.a("Add", var14.a());
            }

            var11.a("BlockLight", var10.h().a());
            if(var6) {
               var11.a("SkyLight", var10.i().a());
            } else {
               var11.a("SkyLight", new byte[var10.h().a().length]);
            }

            var5.a((gd)var11);
         }
      }

      var3.a("Sections", (gd)var5);
      var3.a("Biomes", var1.k());
      var1.g(false);
      fv var20 = new fv();

      Iterator var22;
      for(var8 = 0; var8 < var1.s().length; ++var8) {
         var22 = var1.s()[var8].iterator();

         while(var22.hasNext()) {
            Entity var25 = (Entity)var22.next();
            var11 = new fn();
            if(var25.d(var11)) {
               var1.g(true);
               var20.a((gd)var11);
            }
         }
      }

      var3.a("Entities", (gd)var20);
      fv var21 = new fv();
      var22 = var1.r().values().iterator();

      while(var22.hasNext()) {
         bcm var26 = (bcm)var22.next();
         var11 = new fn();
         var26.b(var11);
         var21.a((gd)var11);
      }

      var3.a("TileEntities", (gd)var21);
      List var24 = var2.a(var1, false);
      if(var24 != null) {
         long var23 = var2.K();
         fv var27 = new fv();
         Iterator var28 = var24.iterator();

         while(var28.hasNext()) {
            ark var29 = (ark)var28.next();
            fn var31 = new fn();
            oa var30 = (oa)atr.c.c(var29.a());
            var31.a("i", var30 == null?"":var30.toString());
            var31.a("x", var29.a.n());
            var31.a("y", var29.a.o());
            var31.a("z", var29.a.p());
            var31.a("t", (int)(var29.b - var23));
            var31.a("p", var29.c);
            var27.a((gd)var31);
         }

         var3.a("TileTicks", (gd)var27);
      }

   }

   private bfh a(World var1, fn var2) {
      int var3 = var2.f("xPos");
      int var4 = var2.f("zPos");
      bfh var5 = new bfh(var1, var3, var4);
      var5.a(var2.l("HeightMap"));
      var5.d(var2.n("TerrainPopulated"));
      var5.e(var2.n("LightPopulated"));
      var5.c(var2.g("InhabitedTime"));
      fv var6 = var2.c("Sections", 10);
      byte var7 = 16;
      bfm[] var8 = new bfm[var7];
      boolean var9 = !var1.t.o();

      for(int var10 = 0; var10 < var6.c(); ++var10) {
         fn var11 = var6.b(var10);
         byte var12 = var11.d("Y");
         bfm var13 = new bfm(var12 << 4, var9);
         byte[] var14 = var11.k("Blocks");
         bff var15 = new bff(var11.k("Data"));
         bff var16 = var11.b("Add", 7)?new bff(var11.k("Add")):null;
         char[] var17 = new char[var14.length];

         for(int var18 = 0; var18 < var17.length; ++var18) {
            int var19 = var18 & 15;
            int var20 = var18 >> 8 & 15;
            int var21 = var18 >> 4 & 15;
            int var22 = var16 != null?var16.a(var19, var20, var21):0;
            var17[var18] = (char)(var22 << 12 | (var14[var18] & 255) << 4 | var15.a(var19, var20, var21));
         }

         var13.a(var17);
         var13.a(new bff(var11.k("BlockLight")));
         if(var9) {
            var13.b(new bff(var11.k("SkyLight")));
         }

         var13.e();
         var8[var12] = var13;
      }

      var5.a(var8);
      if(var2.b("Biomes", 7)) {
         var5.a(var2.k("Biomes"));
      }

      fv var24 = var2.c("Entities", 10);
      if(var24 != null) {
         for(int var23 = 0; var23 < var24.c(); ++var23) {
            fn var25 = var24.b(var23);
            Entity var30 = EntityTypes.a(var25, var1);
            var5.g(true);
            if(var30 != null) {
               var5.a(var30);
               Entity var35 = var30;

               for(fn var33 = var25; var33.b("Riding", 10); var33 = var33.m("Riding")) {
                  Entity var36 = EntityTypes.a(var33.m("Riding"), var1);
                  if(var36 != null) {
                     var5.a(var36);
                     var35.a(var36);
                  }

                  var35 = var36;
               }
            }
         }
      }

      fv var27 = var2.c("TileEntities", 10);
      if(var27 != null) {
         for(int var26 = 0; var26 < var27.c(); ++var26) {
            fn var28 = var27.b(var26);
            bcm var32 = bcm.c(var28);
            if(var32 != null) {
               var5.a(var32);
            }
         }
      }

      if(var2.b("TileTicks", 9)) {
         fv var31 = var2.c("TileTicks", 10);
         if(var31 != null) {
            for(int var29 = 0; var29 < var31.c(); ++var29) {
               fn var34 = var31.b(var29);
               atr var37;
               if(var34.b("i", 8)) {
                  var37 = atr.b(var34.j("i"));
               } else {
                  var37 = atr.c(var34.f("i"));
               }

               var1.b(new dt(var34.f("x"), var34.f("y"), var34.f("z")), var37, var34.f("t"), var34.f("p"));
            }
         }
      }

      return var5;
   }

}
