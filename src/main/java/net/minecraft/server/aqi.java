package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public abstract class aqi {

   private int a = 20;
   private String b = "Pig";
   private final List c = Lists.newArrayList();
   private aqj d;
   private double e;
   private double f;
   private int g = 200;
   private int h = 800;
   private int i = 4;
   private Entity j;
   private int k = 6;
   private int l = 16;
   private int m = 4;


   private String f() {
      if(this.i() == null) {
         if(this.b.equals("Minecart")) {
            this.b = "MinecartRideable";
         }

         return this.b;
      } else {
         return aqj.a(this.i());
      }
   }

   public void a(String var1) {
      this.b = var1;
   }

   private boolean g() {
      Location var1 = this.b();
      return this.a().b((double)var1.n() + 0.5D, (double)var1.o() + 0.5D, (double)var1.p() + 0.5D, (double)this.l);
   }

   public void c() {
      if(this.g()) {
         Location var1 = this.b();
         double var6;
         if(this.a().D) {
            double var2 = (double)((float)var1.n() + this.a().s.nextFloat());
            double var4 = (double)((float)var1.o() + this.a().s.nextFloat());
            var6 = (double)((float)var1.p() + this.a().s.nextFloat());
            this.a().a(ew.l, var2, var4, var6, 0.0D, 0.0D, 0.0D, new int[0]);
            this.a().a(ew.A, var2, var4, var6, 0.0D, 0.0D, 0.0D, new int[0]);
            if(this.a > 0) {
               --this.a;
            }

            this.f = this.e;
            this.e = (this.e + (double)(1000.0F / ((float)this.a + 200.0F))) % 360.0D;
         } else {
            if(this.a == -1) {
               this.h();
            }

            if(this.a > 0) {
               --this.a;
               return;
            }

            boolean var13 = false;

            for(int var3 = 0; var3 < this.i; ++var3) {
               Entity var14 = EntityTypes.a(this.f(), this.a());
               if(var14 == null) {
                  return;
               }

               int var5 = this.a().getEntities(var14.getClass(), (new AxisAlignedBB((double)var1.n(), (double)var1.o(), (double)var1.p(), (double)(var1.n() + 1), (double)(var1.o() + 1), (double)(var1.p() + 1))).b((double)this.m, (double)this.m, (double)this.m)).size();
               if(var5 >= this.k) {
                  this.h();
                  return;
               }

               var6 = (double)var1.n() + (this.a().s.nextDouble() - this.a().s.nextDouble()) * (double)this.m + 0.5D;
               double var8 = (double)(var1.o() + this.a().s.nextInt(3) - 1);
               double var10 = (double)var1.p() + (this.a().s.nextDouble() - this.a().s.nextDouble()) * (double)this.m + 0.5D;
               EntityInsentient var12 = var14 instanceof EntityInsentient?(EntityInsentient)var14:null;
               var14.setPositionRotation(var6, var8, var10, this.a().s.nextFloat() * 360.0F, 0.0F);
               if(var12 == null || var12.bQ() && var12.bR()) {
                  this.a(var14, true);
                  this.a().b(2004, var1, 0);
                  if(var12 != null) {
                     var12.y();
                  }

                  var13 = true;
               }
            }

            if(var13) {
               this.h();
            }
         }

      }
   }

   private Entity a(Entity var1, boolean var2) {
      if(this.i() != null) {
         NBTTagCompound var3 = new NBTTagCompound();
         var1.d(var3);
         Iterator var4 = aqj.b(this.i()).c().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            NBTBase var6 = aqj.b(this.i()).a(var5);
            var3.set(var5, var6.b());
         }

         var1.f(var3);
         if(var1.o != null && var2) {
            var1.o.d(var1);
         }

         NBTTagCompound var12;
         for(Entity var11 = var1; var3.b("Riding", 10); var3 = var12) {
            var12 = var3.getCompound("Riding");
            Entity var13 = EntityTypes.a(var12.getString("id"), var1.o);
            if(var13 != null) {
               NBTTagCompound var7 = new NBTTagCompound();
               var13.d(var7);
               Iterator var8 = var12.c().iterator();

               while(var8.hasNext()) {
                  String var9 = (String)var8.next();
                  NBTBase var10 = var12.a(var9);
                  var7.set(var9, var10.b());
               }

               var13.f(var7);
               var13.setPositionRotation(var11.s, var11.t, var11.u, var11.y, var11.z);
               if(var1.o != null && var2) {
                  var1.o.d(var13);
               }

               var11.a(var13);
            }

            var11 = var13;
         }
      } else if(var1 instanceof EntityLiving && var1.o != null && var2) {
         ((EntityInsentient)var1).a(var1.o.E(new Location(var1)), (xq)null);
         var1.o.d(var1);
      }

      return var1;
   }

   private void h() {
      if(this.h <= this.g) {
         this.a = this.g;
      } else {
         int var10003 = this.h - this.g;
         this.a = this.g + this.a().s.nextInt(var10003);
      }

      if(this.c.size() > 0) {
         this.a((aqj)WeightedRandom.a(this.a().s, this.c));
      }

      this.a(1);
   }

   public void a(NBTTagCompound var1) {
      this.b = var1.getString("EntityId");
      this.a = var1.getShort("Delay");
      this.c.clear();
      if(var1.b("SpawnPotentials", 9)) {
         NBTTagList var2 = var1.getList("SpawnPotentials", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            this.c.add(new aqj(this, var2.b(var3)));
         }
      }

      if(var1.b("SpawnData", 10)) {
         this.a(new aqj(this, var1.getCompound("SpawnData"), this.b));
      } else {
         this.a((aqj)null);
      }

      if(var1.b("MinSpawnDelay", 99)) {
         this.g = var1.getShort("MinSpawnDelay");
         this.h = var1.getShort("MaxSpawnDelay");
         this.i = var1.getShort("SpawnCount");
      }

      if(var1.b("MaxNearbyEntities", 99)) {
         this.k = var1.getShort("MaxNearbyEntities");
         this.l = var1.getShort("RequiredPlayerRange");
      }

      if(var1.b("SpawnRange", 99)) {
         this.m = var1.getShort("SpawnRange");
      }

      if(this.a() != null) {
         this.j = null;
      }

   }

   public void b(NBTTagCompound var1) {
      var1.setString("EntityId", this.f());
      var1.setShort("Delay", (short)this.a);
      var1.setShort("MinSpawnDelay", (short)this.g);
      var1.setShort("MaxSpawnDelay", (short)this.h);
      var1.setShort("SpawnCount", (short)this.i);
      var1.setShort("MaxNearbyEntities", (short)this.k);
      var1.setShort("RequiredPlayerRange", (short)this.l);
      var1.setShort("SpawnRange", (short)this.m);
      if(this.i() != null) {
         var1.set("SpawnData", aqj.b(this.i()).b());
      }

      if(this.i() != null || this.c.size() > 0) {
         NBTTagList var2 = new NBTTagList();
         if(this.c.size() > 0) {
            Iterator var3 = this.c.iterator();

            while(var3.hasNext()) {
               aqj var4 = (aqj)var3.next();
               var2.a((NBTBase)var4.a());
            }
         } else {
            var2.a((NBTBase)this.i().a());
         }

         var1.set("SpawnPotentials", (NBTBase)var2);
      }

   }

   public boolean b(int var1) {
      if(var1 == 1 && this.a().D) {
         this.a = this.g;
         return true;
      } else {
         return false;
      }
   }

   private aqj i() {
      return this.d;
   }

   public void a(aqj var1) {
      this.d = var1;
   }

   public abstract void a(int var1);

   public abstract World a();

   public abstract Location b();
}
