package net.minecraft.server;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldServer extends World implements vn {

   private static final Logger a = LogManager.getLogger();
   private final MinecraftServer I;
   private final EntityTracker J;
   private final PlayerChunkMap K;
   private final Set L = Sets.newHashSet();
   private final TreeSet M = new TreeSet();
   private final Map N = Maps.newHashMap();
   public ChunkProviderServer b;
   public boolean c;
   private boolean O;
   private int P;
   private final PortalTravelAgent Q;
   private final SpawnerCreature R = new SpawnerCreature();
   protected final abk d = new abk(this);
   private BlockActionDataList[] S = new BlockActionDataList[]{new BlockActionDataList((PredicateEntityUnderSun)null), new BlockActionDataList((PredicateEntityUnderSun)null)};
   private int T;
   private static final List U = Lists.newArrayList(new StructurePieceTreaasure[]{new StructurePieceTreaasure(Items.STICK, 0, 1, 3, 10), new StructurePieceTreaasure(Item.getItemOf(Blocks.WOOD), 0, 1, 3, 10), new StructurePieceTreaasure(Item.getItemOf(Blocks.LOG), 0, 1, 3, 10), new StructurePieceTreaasure(Items.STONE_AXE, 0, 1, 1, 3), new StructurePieceTreaasure(Items.WOOD_AXE, 0, 1, 1, 5), new StructurePieceTreaasure(Items.STONE_PICKAXE, 0, 1, 1, 3), new StructurePieceTreaasure(Items.WOOD_PICKAXE, 0, 1, 1, 5), new StructurePieceTreaasure(Items.APPLE, 0, 2, 3, 5), new StructurePieceTreaasure(Items.BREAD, 0, 2, 3, 3), new StructurePieceTreaasure(Item.getItemOf(Blocks.LOG2), 0, 1, 3, 10)});
   private List V = Lists.newArrayList();


   public WorldServer(MinecraftServer var1, IDataManager var2, WorldData var3, int var4, MethodProfiler var5) {
      super(var2, var3, WorldProvider.a(var4), var5, false);
      this.I = var1;
      this.J = new EntityTracker(this);
      this.K = new PlayerChunkMap(this);
      this.worldProvider.a(this);
      this.chunkProvider = this.k();
      this.Q = new PortalTravelAgent(this);
      this.B();
      this.C();
      this.af().a(var1.aG());
   }

   public World b() {
      this.worldMaps = new PersistentCollection(this.dataManager);
      String var1 = VillageSiege.a(this.worldProvider);
      VillageSiege var2 = (VillageSiege)this.worldMaps.get(VillageSiege.class, var1);
      if(var2 == null) {
         this.siegeManager = new VillageSiege(this);
         this.worldMaps.a(var1, (PersistentBase)this.siegeManager);
      } else {
         this.siegeManager = var2;
         this.siegeManager.a((World)this);
      }

      this.scoreboard = new ScoreboardServer(this.I);
      PersistentScoreboard var3 = (PersistentScoreboard)this.worldMaps.get(PersistentScoreboard.class, "scoreboard");
      if(var3 == null) {
         var3 = new PersistentScoreboard();
         this.worldMaps.a("scoreboard", (PersistentBase)var3);
      }

      var3.a(this.scoreboard);
      ((ScoreboardServer)this.scoreboard).a(var3);
      this.af().c(this.worldData.C(), this.worldData.D());
      this.af().c(this.worldData.I());
      this.af().b(this.worldData.H());
      this.af().c(this.worldData.J());
      this.af().b(this.worldData.K());
      if(this.worldData.F() > 0L) {
         this.af().a(this.worldData.E(), this.worldData.G(), this.worldData.F());
      } else {
         this.af().a(this.worldData.E());
      }

      return this;
   }

   public void doTick() {
      super.doTick();
      if(this.getWorldData().isHardcore() && this.aa() != EnumDifficulty.HARD) {
         this.getWorldData().a(EnumDifficulty.HARD);
      }

      this.worldProvider.m().b();
      if(this.f()) {
         if(this.getGameRules().getBoolean("doDaylightCycle")) {
            long var1 = this.worldData.getDayTime() + 24000L;
            this.worldData.setDayTime(var1 - var1 % 24000L);
         }

         this.e();
      }

      this.methodProfiler.a("mobSpawner");
      if(this.getGameRules().getBoolean("doMobSpawning") && this.worldData.getType() != WorldType.DEBUG) {
         this.R.a(this, this.allowMonsters, this.allowAnimals, this.worldData.getTime() % 400L == 0L);
      }

      this.methodProfiler.c("chunkSource");
      this.chunkProvider.unloadChunks();
      int var3 = this.a(1.0F);
      if(var3 != this.ab()) {
         this.b(var3);
      }

      this.worldData.b(this.worldData.getTime() + 1L);
      if(this.getGameRules().getBoolean("doDaylightCycle")) {
         this.worldData.setDayTime(this.worldData.getDayTime() + 1L);
      }

      this.methodProfiler.c("tickPending");
      this.a(false);
      this.methodProfiler.c("tickBlocks");
      this.h();
      this.methodProfiler.c("chunkMap");
      this.K.b();
      this.methodProfiler.c("village");
      this.siegeManager.a();
      this.d.a();
      this.methodProfiler.c("portalForcer");
      this.Q.a(this.getTime());
      this.methodProfiler.b();
      this.ak();
   }

   public BiomeMeta a(EnumCreatureType var1, Location var2) {
      List var3 = this.N().getMobsFor(var1, var2);
      return var3 != null && !var3.isEmpty()?(BiomeMeta)WeightedRandom.a(this.random, var3):null;
   }

   public boolean a(EnumCreatureType var1, BiomeMeta var2, Location var3) {
      List var4 = this.N().getMobsFor(var1, var3);
      return var4 != null && !var4.isEmpty()?var4.contains(var2):false;
   }

   public void everyoneSleeping() {
      this.O = false;
      if(!this.players.isEmpty()) {
         int var1 = 0;
         int var2 = 0;
         Iterator var3 = this.players.iterator();

         while(var3.hasNext()) {
            EntityHuman var4 = (EntityHuman)var3.next();
            if(var4.v()) {
               ++var1;
            } else if(var4.bI()) {
               ++var2;
            }
         }

         this.O = var2 > 0 && var2 >= this.players.size() - var1;
      }

   }

   protected void e() {
      this.O = false;
      Iterator var1 = this.players.iterator();

      while(var1.hasNext()) {
         EntityHuman var2 = (EntityHuman)var1.next();
         if(var2.bI()) {
            var2.a(false, false, true);
         }
      }

      this.ag();
   }

   private void ag() {
      this.worldData.setWeatherDuration(0);
      this.worldData.setStorm(false);
      this.worldData.setThunderDuration(0);
      this.worldData.setThundering(false);
   }

   public boolean f() {
      if(this.O && !this.isStatic) {
         Iterator var1 = this.players.iterator();

         EntityHuman var2;
         do {
            if(!var1.hasNext()) {
               return true;
            }

            var2 = (EntityHuman)var1.next();
         } while(!var2.v() && var2.ce());

         return false;
      } else {
         return false;
      }
   }

   protected void h() {
      super.h();
      if(this.worldData.getType() == WorldType.DEBUG) {
         Iterator var21 = this.chunkTickList.iterator();

         while(var21.hasNext()) {
            aqm var22 = (aqm)var21.next();
            this.getChunkAt(var22.a, var22.b).b(false);
         }

      } else {
         int var1 = 0;
         int var2 = 0;

         for(Iterator var3 = this.chunkTickList.iterator(); var3.hasNext(); this.methodProfiler.b()) {
            aqm var4 = (aqm)var3.next();
            int var5 = var4.a * 16;
            int var6 = var4.b * 16;
            this.methodProfiler.a("getChunk");
            Chunk var7 = this.getChunkAt(var4.a, var4.b);
            this.a(var5, var6, var7);
            this.methodProfiler.c("tickChunk");
            var7.b(false);
            this.methodProfiler.c("thunder");
            int var8;
            Location var9;
            if(this.random.nextInt(100000) == 0 && this.S() && this.R()) {
               this.m = this.m * 3 + 1013904223;
               var8 = this.m >> 2;
               var9 = this.a(new Location(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
               if(this.isRainingAt(var9)) {
                  this.strikeLightning(new EntityLightning(this, (double)var9.n(), (double)var9.o(), (double)var9.p()));
               }
            }

            this.methodProfiler.c("iceandsnow");
            if(this.random.nextInt(16) == 0) {
               this.m = this.m * 3 + 1013904223;
               var8 = this.m >> 2;
               var9 = this.q(new Location(var5 + (var8 & 15), 0, var6 + (var8 >> 8 & 15)));
               Location var10 = var9.b();
               if(this.w(var10)) {
                  this.a(var10, Blocks.ICE.P());
               }

               if(this.S() && this.f(var9, true)) {
                  this.a(var9, Blocks.SNOW.P());
               }

               if(this.S() && this.getBiome(var10).e()) {
                  this.getData(var10).c().k(this, var10);
               }
            }

            this.methodProfiler.c("tickBlocks");
            var8 = this.getGameRules().getInt("randomTickSpeed");
            if(var8 > 0) {
               bfm[] var23 = var7.h();
               int var24 = var23.length;

               for(int var11 = 0; var11 < var24; ++var11) {
                  bfm var12 = var23[var11];
                  if(var12 != null && var12.b()) {
                     for(int var13 = 0; var13 < var8; ++var13) {
                        this.m = this.m * 3 + 1013904223;
                        int var14 = this.m >> 2;
                        int var15 = var14 & 15;
                        int var16 = var14 >> 8 & 15;
                        int var17 = var14 >> 16 & 15;
                        ++var2;
                        Location var18 = new Location(var15 + var5, var17 + var12.d(), var16 + var6);
                        IBlockData var19 = var12.a(var15, var17, var16);
                        Block var20 = var19.c();
                        if(var20.isTicking()) {
                           ++var1;
                           var20.a((World)this, var18, var19, this.random);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   protected Location a(Location var1) {
      Location var2 = this.q(var1);
      AxisAlignedBB var3 = (new AxisAlignedBB(var2, new Location(var2.n(), this.U(), var2.p()))).b(3.0D, 3.0D, 3.0D);
      List var4 = this.getEntities(EntityLiving.class, var3, new PredicateEntityUnderSun(this));
      return !var4.isEmpty()?((EntityLiving)var4.get(this.random.nextInt(var4.size()))).getLocation():var2;
   }

   public boolean a(Location var1, Block var2) {
      NextTickListEntry var3 = new NextTickListEntry(var1, var2);
      return this.V.contains(var3);
   }

   public void a(Location var1, Block var2, int var3) {
      this.a(var1, var2, var3, 0);
   }

   public void a(Location var1, Block var2, int var3, int var4) {
      NextTickListEntry var5 = new NextTickListEntry(var1, var2);
      byte var6 = 0;
      if(this.e && var2.getMaterial() != Material.AIR) {
         if(var2.M()) {
            var6 = 8;
            if(this.a(var5.a.a(-var6, -var6, -var6), var5.a.a(var6, var6, var6))) {
               IBlockData var7 = this.getData(var5.a);
               if(var7.c().getMaterial() != Material.AIR && var7.c() == var5.a()) {
                  var7.c().b((World)this, var5.a, var7, this.random);
               }
            }

            return;
         }

         var3 = 1;
      }

      if(this.a(var1.a(-var6, -var6, -var6), var1.a(var6, var6, var6))) {
         if(var2.getMaterial() != Material.AIR) {
            var5.a((long)var3 + this.worldData.getTime());
            var5.a(var4);
         }

         if(!this.L.contains(var5)) {
            this.L.add(var5);
            this.M.add(var5);
         }
      }

   }

   public void b(Location var1, Block var2, int var3, int var4) {
      NextTickListEntry var5 = new NextTickListEntry(var1, var2);
      var5.a(var4);
      if(var2.getMaterial() != Material.AIR) {
         var5.a((long)var3 + this.worldData.getTime());
      }

      if(!this.L.contains(var5)) {
         this.L.add(var5);
         this.M.add(var5);
      }

   }

   public void tickEntities() {
      if(this.players.isEmpty()) {
         if(this.P++ >= 1200) {
            return;
         }
      } else {
         this.j();
      }

      super.tickEntities();
   }

   public void j() {
      this.P = 0;
   }

   public boolean a(boolean var1) {
      if(this.worldData.getType() == WorldType.DEBUG) {
         return false;
      } else {
         int var2 = this.M.size();
         if(var2 != this.L.size()) {
            throw new IllegalStateException("TickNextTick list out of synch");
         } else {
            if(var2 > 1000) {
               var2 = 1000;
            }

            this.methodProfiler.a("cleaning");

            NextTickListEntry var4;
            for(int var3 = 0; var3 < var2; ++var3) {
               var4 = (NextTickListEntry)this.M.first();
               if(!var1 && var4.b > this.worldData.getTime()) {
                  break;
               }

               this.M.remove(var4);
               this.L.remove(var4);
               this.V.add(var4);
            }

            this.methodProfiler.b();
            this.methodProfiler.a("ticking");
            Iterator var11 = this.V.iterator();

            while(var11.hasNext()) {
               var4 = (NextTickListEntry)var11.next();
               var11.remove();
               byte var5 = 0;
               if(this.a(var4.a.a(-var5, -var5, -var5), var4.a.a(var5, var5, var5))) {
                  IBlockData var6 = this.getData(var4.a);
                  if(var6.c().getMaterial() != Material.AIR && Block.a(var6.c(), var4.a())) {
                     try {
                        var6.c().b((World)this, var4.a, var6, this.random);
                     } catch (Throwable var10) {
                        CrashReport var8 = CrashReport.a(var10, "Exception while ticking a block");
                        CrashReportSystemDetails var9 = var8.a("Block being ticked");
                        CrashReportSystemDetails.a(var9, var4.a, var6);
                        throw new ReportedException(var8);
                     }
                  }
               } else {
                  this.a(var4.a, var4.a(), 0);
               }
            }

            this.methodProfiler.b();
            this.V.clear();
            return !this.M.isEmpty();
         }
      }
   }

   public List a(Chunk var1, boolean var2) {
      aqm var3 = var1.j();
      int var4 = (var3.a << 4) - 2;
      int var5 = var4 + 16 + 2;
      int var6 = (var3.b << 4) - 2;
      int var7 = var6 + 16 + 2;
      return this.a(new bjb(var4, 0, var6, var5, 256, var7), var2);
   }

   public List a(bjb var1, boolean var2) {
      ArrayList var3 = null;

      for(int var4 = 0; var4 < 2; ++var4) {
         Iterator var5;
         if(var4 == 0) {
            var5 = this.M.iterator();
         } else {
            var5 = this.V.iterator();
            if(!this.V.isEmpty()) {
               a.debug("toBeTicked = " + this.V.size());
            }
         }

         while(var5.hasNext()) {
            NextTickListEntry var6 = (NextTickListEntry)var5.next();
            Location var7 = var6.a;
            if(var7.n() >= var1.a && var7.n() < var1.d && var7.p() >= var1.c && var7.p() < var1.f) {
               if(var2) {
                  this.L.remove(var6);
                  var5.remove();
               }

               if(var3 == null) {
                  var3 = Lists.newArrayList();
               }

               var3.add(var6);
            }
         }
      }

      return var3;
   }

   public void entityJoinedWorld(Entity var1, boolean var2) throws IOException {
      if(!this.ai() && (var1 instanceof EntityAnimal || var1 instanceof EntityWaterAnimal)) {
         var1.J();
      }

      if(!this.ah() && var1 instanceof ago) {
         var1.J();
      }

      super.entityJoinedWorld(var1, var2);
   }

   private boolean ah() {
      return this.I.ag();
   }

   private boolean ai() {
      return this.I.af();
   }

   protected IChunkProvider k() {
      IChunkLoader var1 = this.dataManager.a(this.worldProvider);
      this.b = new ChunkProviderServer(this, var1, this.worldProvider.c());
      return this.b;
   }

   public List a(int var1, int var2, int var3, int var4, int var5, int var6) {
      ArrayList var7 = Lists.newArrayList();

      for(int var8 = 0; var8 < this.tileEntityList.size(); ++var8) {
         TileEntity var9 = (TileEntity)this.tileEntityList.get(var8);
         Location var10 = var9.v();
         if(var10.n() >= var1 && var10.o() >= var2 && var10.p() >= var3 && var10.n() < var4 && var10.o() < var5 && var10.p() < var6) {
            var7.add(var9);
         }
      }

      return var7;
   }

   public boolean a(EntityHuman var1, Location var2) {
      return !this.I.a((World)this, var2, var1) && this.af().a(var2);
   }

   public void a(WorldSettings var1) {
      if(!this.worldData.isInitialized()) {
         try {
            this.b(var1);
            if(this.worldData.getType() == WorldType.DEBUG) {
               this.aj();
            }

            super.a(var1);
         } catch (Throwable var6) {
            CrashReport var3 = CrashReport.a(var6, "Exception initializing level");

            try {
               this.a(var3);
            } catch (Throwable var5) {
               ;
            }

            throw new ReportedException(var3);
         }

         this.worldData.d(true);
      }

   }

   private void aj() {
      this.worldData.f(false);
      this.worldData.c(true);
      this.worldData.setStorm(false);
      this.worldData.setThundering(false);
      this.worldData.i(1000000000);
      this.worldData.setDayTime(6000L);
      this.worldData.setGameType(EnumGamemode.SPECTATOR);
      this.worldData.g(false);
      this.worldData.a(EnumDifficulty.PEACEFUL);
      this.worldData.e(true);
      this.getGameRules().set("doDaylightCycle", "false");
   }

   private void b(WorldSettings var1) {
      if(!this.worldProvider.e()) {
         this.worldData.setSpawn(Location.a.b(this.worldProvider.i()));
      } else if(this.worldData.getType() == WorldType.DEBUG) {
         this.worldData.setSpawn(Location.a.a());
      } else {
         this.isLoading = true;
         WorldChunkManager var2 = this.worldProvider.m();
         List var3 = var2.a();
         Random var4 = new Random(this.getSeed());
         Location var5 = var2.a(0, 0, 256, var3, var4);
         int var6 = 0;
         int var7 = this.worldProvider.i();
         int var8 = 0;
         if(var5 != null) {
            var6 = var5.n();
            var8 = var5.p();
         } else {
            a.warn("Unable to find spawn biome");
         }

         int var9 = 0;

         while(!this.worldProvider.a(var6, var8)) {
            var6 += var4.nextInt(64) - var4.nextInt(64);
            var8 += var4.nextInt(64) - var4.nextInt(64);
            ++var9;
            if(var9 == 1000) {
               break;
            }
         }

         this.worldData.setSpawn(new Location(var6, var7, var8));
         this.isLoading = false;
         if(var1.c()) {
            this.l();
         }

      }
   }

   protected void l() {
      WorldGenBonusChest var1 = new WorldGenBonusChest(U, 10);

      for(int var2 = 0; var2 < 10; ++var2) {
         int var3 = this.worldData.c() + this.random.nextInt(6) - this.random.nextInt(6);
         int var4 = this.worldData.e() + this.random.nextInt(6) - this.random.nextInt(6);
         Location var5 = this.r(new Location(var3, 0, var4)).a();
         if(var1.generate(this, this.random, var5)) {
            break;
         }
      }

   }

   public Location m() {
      return this.worldProvider.h();
   }

   public void a(boolean var1, IProgressUpdate var2) throws ExceptionWorldConflict {
      if(this.chunkProvider.canSave()) {
         if(var2 != null) {
            var2.a("Saving level");
         }

         this.a();
         if(var2 != null) {
            var2.c("Saving chunks");
         }

         this.chunkProvider.saveChunks(var1, var2);
         List var3 = this.b.a();
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            Chunk var5 = (Chunk)var4.next();
            if(!this.K.a(var5.a, var5.b)) {
               this.b.b(var5.a, var5.b);
            }
         }

      }
   }

   public void n() {
      if(this.chunkProvider.canSave()) {
         this.chunkProvider.c();
      }
   }

   protected void a() throws ExceptionWorldConflict {
      this.I();
      this.worldData.a(this.af().h());
      this.worldData.d(this.af().f());
      this.worldData.c(this.af().g());
      this.worldData.e(this.af().m());
      this.worldData.f(this.af().n());
      this.worldData.j(this.af().q());
      this.worldData.k(this.af().p());
      this.worldData.b(this.af().j());
      this.worldData.e(this.af().i());
      this.dataManager.a(this.worldData, this.I.an().u());
      this.worldMaps.a();
   }

   protected void a(Entity var1) {
      super.a(var1);
      this.l.a(var1.F(), var1);
      this.N.put(var1.aJ(), var1);
      Entity[] var2 = var1.aC();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.l.a(var2[var3].F(), var2[var3]);
         }
      }

   }

   protected void b(Entity var1) {
      super.b(var1);
      this.l.d(var1.F());
      this.N.remove(var1.aJ());
      Entity[] var2 = var1.aC();
      if(var2 != null) {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            this.l.d(var2[var3].F());
         }
      }

   }

   public boolean strikeLightning(Entity var1) {
      if(super.strikeLightning(var1)) {
         this.I.an().a(var1.s, var1.t, var1.u, 512.0D, this.worldProvider.q(), new PacketPlayOutSpawnEntityWeather(var1));
         return true;
      } else {
         return false;
      }
   }

   public void broadcastEntityEffect(Entity var1, byte var2) {
      this.s().b(var1, new PacketPlayOutEntityStatus(var1, var2));
   }

   public Explosion createExplosion(Entity var1, double var2, double var4, double var6, float var8, boolean var9, boolean var10) {
      Explosion var11 = new Explosion(this, var1, var2, var4, var6, var8, var9, var10);
      var11.a();
      var11.a(false);
      if(!var10) {
         var11.d();
      }

      Iterator var12 = this.players.iterator();

      while(var12.hasNext()) {
         EntityHuman var13 = (EntityHuman)var12.next();
         if(var13.e(var2, var4, var6) < 4096.0D) {
            ((EntityPlayer)var13).a.sendPacket((Packet)(new PacketPlayOutExplosion(var2, var4, var6, var8, var11.e(), (Vec3D)var11.b().get(var13))));
         }
      }

      return var11;
   }

   public void playBlockAction(Location var1, Block var2, int var3, int var4) {
      aqk var5 = new aqk(var1, var2, var3, var4);
      Iterator var6 = this.S[this.T].iterator();

      aqk var7;
      do {
         if(!var6.hasNext()) {
            this.S[this.T].add(var5);
            return;
         }

         var7 = (aqk)var6.next();
      } while(!var7.equals(var5));

   }

   private void ak() {
      while(!this.S[this.T].isEmpty()) {
         int var1 = this.T;
         this.T ^= 1;
         Iterator var2 = this.S[var1].iterator();

         while(var2.hasNext()) {
            aqk var3 = (aqk)var2.next();
            if(this.a(var3)) {
               this.I.an().a((double)var3.a().n(), (double)var3.a().o(), (double)var3.a().p(), 64.0D, this.worldProvider.q(), new PacketPlayOutBlockAction(var3.a(), var3.d(), var3.b(), var3.c()));
            }
         }

         this.S[var1].clear();
      }

   }

   private boolean a(aqk var1) {
      IBlockData var2 = this.getData(var1.a());
      return var2.c() == var1.d()?var2.c().a(this, var1.a(), var2, var1.b(), var1.c()):false;
   }

   public void o() {
      this.dataManager.a();
   }

   protected void p() {
      boolean var1 = this.S();
      super.p();
      if(this.o != this.p) {
         this.I.an().a((Packet)(new PacketPlayOutGameStateChange(7, this.p)), this.worldProvider.q());
      }

      if(this.q != this.r) {
         this.I.an().a((Packet)(new PacketPlayOutGameStateChange(8, this.r)), this.worldProvider.q());
      }

      if(var1 != this.S()) {
         if(var1) {
            this.I.an().a((Packet)(new PacketPlayOutGameStateChange(2, 0.0F)));
         } else {
            this.I.an().a((Packet)(new PacketPlayOutGameStateChange(1, 0.0F)));
         }

         this.I.an().a((Packet)(new PacketPlayOutGameStateChange(7, this.p)));
         this.I.an().a((Packet)(new PacketPlayOutGameStateChange(8, this.r)));
      }

   }

   protected int q() {
      return this.I.an().t();
   }

   public MinecraftServer r() {
      return this.I;
   }

   public EntityTracker s() {
      return this.J;
   }

   public PlayerChunkMap t() {
      return this.K;
   }

   public PortalTravelAgent u() {
      return this.Q;
   }

   public void a(EnumParticleEffect var1, double var2, double var4, double var6, int var8, double var9, double var11, double var13, double var15, int ... var17) {
      this.a(var1, false, var2, var4, var6, var8, var9, var11, var13, var15, var17);
   }

   public void a(EnumParticleEffect var1, boolean var2, double var3, double var5, double var7, int var9, double var10, double var12, double var14, double var16, int ... var18) {
      PacketPlayOutWorldParticles var19 = new PacketPlayOutWorldParticles(var1, var2, (float)var3, (float)var5, (float)var7, (float)var10, (float)var12, (float)var14, (float)var16, var9, var18);

      for(int var20 = 0; var20 < this.players.size(); ++var20) {
         EntityPlayer var21 = (EntityPlayer)this.players.get(var20);
         Location var22 = var21.getLocation();
         double var23 = var22.c(var3, var5, var7);
         if(var23 <= 256.0D || var2 && var23 <= 65536.0D) {
            var21.a.sendPacket((Packet)var19);
         }
      }

   }

   public Entity a(UUID var1) {
      return (Entity)this.N.get(var1);
   }

   public ListenableFuture a(Runnable var1) {
      return this.I.a(var1);
   }

   public boolean aH() {
      return this.I.aH();
   }

}
