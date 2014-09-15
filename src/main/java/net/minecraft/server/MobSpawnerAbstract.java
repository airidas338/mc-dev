package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;

public abstract class MobSpawnerAbstract {

   private int spawnDelay = 20;
   private String mobName = "Pig";
   private final List mobs = Lists.newArrayList();
   private TileEntityMobSpawnerData spawnerData;
   private double e;
   private double f;
   private int minSpawnDelay = 200;
   private int maxSpawnDelay = 800;
   private int spawnCount = 4;
   private Entity j;
   private int maxNearbyEntities = 6;
   private int requirePlayerRange = 16;
   private int spawnRange = 4;


   private String f() {
      if(this.i() == null) {
         if(this.mobName.equals("Minecart")) {
            this.mobName = "MinecartRideable";
         }

         return this.mobName;
      } else {
         return TileEntityMobSpawnerData.a(this.i());
      }
   }

   public void a(String var1) {
      this.mobName = var1;
   }

   private boolean g() {
      Location var1 = this.b();
      return this.a().b((double)var1.n() + 0.5D, (double)var1.o() + 0.5D, (double)var1.p() + 0.5D, (double)this.requirePlayerRange);
   }

   public void c() {
      if(this.g()) {
         Location var1 = this.b();
         double var6;
         if(this.a().isStatic) {
            double var2 = (double)((float)var1.n() + this.a().random.nextFloat());
            double var4 = (double)((float)var1.o() + this.a().random.nextFloat());
            var6 = (double)((float)var1.p() + this.a().random.nextFloat());
            this.a().a(ew.l, var2, var4, var6, 0.0D, 0.0D, 0.0D, new int[0]);
            this.a().a(ew.A, var2, var4, var6, 0.0D, 0.0D, 0.0D, new int[0]);
            if(this.spawnDelay > 0) {
               --this.spawnDelay;
            }

            this.f = this.e;
            this.e = (this.e + (double)(1000.0F / ((float)this.spawnDelay + 200.0F))) % 360.0D;
         } else {
            if(this.spawnDelay == -1) {
               this.h();
            }

            if(this.spawnDelay > 0) {
               --this.spawnDelay;
               return;
            }

            boolean var13 = false;

            for(int var3 = 0; var3 < this.spawnCount; ++var3) {
               Entity var14 = EntityTypes.a(this.f(), this.a());
               if(var14 == null) {
                  return;
               }

               int var5 = this.a().getEntities(var14.getClass(), (new AxisAlignedBB((double)var1.n(), (double)var1.o(), (double)var1.p(), (double)(var1.n() + 1), (double)(var1.o() + 1), (double)(var1.p() + 1))).b((double)this.spawnRange, (double)this.spawnRange, (double)this.spawnRange)).size();
               if(var5 >= this.maxNearbyEntities) {
                  this.h();
                  return;
               }

               var6 = (double)var1.n() + (this.a().random.nextDouble() - this.a().random.nextDouble()) * (double)this.spawnRange + 0.5D;
               double var8 = (double)(var1.o() + this.a().random.nextInt(3) - 1);
               double var10 = (double)var1.p() + (this.a().random.nextDouble() - this.a().random.nextDouble()) * (double)this.spawnRange + 0.5D;
               EntityInsentient var12 = var14 instanceof EntityInsentient?(EntityInsentient)var14:null;
               var14.setPositionRotation(var6, var8, var10, this.a().random.nextFloat() * 360.0F, 0.0F);
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
         Iterator var4 = TileEntityMobSpawnerData.b(this.i()).c().iterator();

         while(var4.hasNext()) {
            String var5 = (String)var4.next();
            NBTBase var6 = TileEntityMobSpawnerData.b(this.i()).get(var5);
            var3.set(var5, var6.clone());
         }

         var1.f(var3);
         if(var1.o != null && var2) {
            var1.o.d(var1);
         }

         NBTTagCompound var12;
         for(Entity var11 = var1; var3.hasKeyOfType("Riding", 10); var3 = var12) {
            var12 = var3.getCompound("Riding");
            Entity var13 = EntityTypes.a(var12.getString("id"), var1.o);
            if(var13 != null) {
               NBTTagCompound var7 = new NBTTagCompound();
               var13.d(var7);
               Iterator var8 = var12.c().iterator();

               while(var8.hasNext()) {
                  String var9 = (String)var8.next();
                  NBTBase var10 = var12.get(var9);
                  var7.set(var9, var10.clone());
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
      if(this.maxSpawnDelay <= this.minSpawnDelay) {
         this.spawnDelay = this.minSpawnDelay;
      } else {
         int var10003 = this.maxSpawnDelay - this.minSpawnDelay;
         this.spawnDelay = this.minSpawnDelay + this.a().random.nextInt(var10003);
      }

      if(this.mobs.size() > 0) {
         this.a((TileEntityMobSpawnerData)WeightedRandom.a(this.a().random, this.mobs));
      }

      this.a(1);
   }

   public void a(NBTTagCompound var1) {
      this.mobName = var1.getString("EntityId");
      this.spawnDelay = var1.getShort("Delay");
      this.mobs.clear();
      if(var1.hasKeyOfType("SpawnPotentials", 9)) {
         NBTTagList var2 = var1.getList("SpawnPotentials", 10);

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            this.mobs.add(new TileEntityMobSpawnerData(this, var2.get(var3)));
         }
      }

      if(var1.hasKeyOfType("SpawnData", 10)) {
         this.a(new TileEntityMobSpawnerData(this, var1.getCompound("SpawnData"), this.mobName));
      } else {
         this.a((TileEntityMobSpawnerData)null);
      }

      if(var1.hasKeyOfType("MinSpawnDelay", 99)) {
         this.minSpawnDelay = var1.getShort("MinSpawnDelay");
         this.maxSpawnDelay = var1.getShort("MaxSpawnDelay");
         this.spawnCount = var1.getShort("SpawnCount");
      }

      if(var1.hasKeyOfType("MaxNearbyEntities", 99)) {
         this.maxNearbyEntities = var1.getShort("MaxNearbyEntities");
         this.requirePlayerRange = var1.getShort("RequiredPlayerRange");
      }

      if(var1.hasKeyOfType("SpawnRange", 99)) {
         this.spawnRange = var1.getShort("SpawnRange");
      }

      if(this.a() != null) {
         this.j = null;
      }

   }

   public void b(NBTTagCompound var1) {
      var1.setString("EntityId", this.f());
      var1.setShort("Delay", (short)this.spawnDelay);
      var1.setShort("MinSpawnDelay", (short)this.minSpawnDelay);
      var1.setShort("MaxSpawnDelay", (short)this.maxSpawnDelay);
      var1.setShort("SpawnCount", (short)this.spawnCount);
      var1.setShort("MaxNearbyEntities", (short)this.maxNearbyEntities);
      var1.setShort("RequiredPlayerRange", (short)this.requirePlayerRange);
      var1.setShort("SpawnRange", (short)this.spawnRange);
      if(this.i() != null) {
         var1.set("SpawnData", TileEntityMobSpawnerData.b(this.i()).clone());
      }

      if(this.i() != null || this.mobs.size() > 0) {
         NBTTagList var2 = new NBTTagList();
         if(this.mobs.size() > 0) {
            Iterator var3 = this.mobs.iterator();

            while(var3.hasNext()) {
               TileEntityMobSpawnerData var4 = (TileEntityMobSpawnerData)var3.next();
               var2.add((NBTBase)var4.a());
            }
         } else {
            var2.add((NBTBase)this.i().a());
         }

         var1.set("SpawnPotentials", (NBTBase)var2);
      }

   }

   public boolean b(int var1) {
      if(var1 == 1 && this.a().isStatic) {
         this.spawnDelay = this.minSpawnDelay;
         return true;
      } else {
         return false;
      }
   }

   private TileEntityMobSpawnerData i() {
      return this.spawnerData;
   }

   public void a(TileEntityMobSpawnerData var1) {
      this.spawnerData = var1;
   }

   public abstract void a(int var1);

   public abstract World a();

   public abstract Location b();
}
