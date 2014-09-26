package net.minecraft.server;
import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class EntityHuman extends EntityLiving {

   public ahb bg = new ahb(this);
   private ajh a = new ajh();
   public aib bh;
   public aib bi;
   protected FoodMetaData bj = new FoodMetaData();
   protected int bk;
   public float bl;
   public float bm;
   public int bn;
   public double bo;
   public double bp;
   public double bq;
   public double br;
   public double bs;
   public double bt;
   protected boolean bu;
   public Location bv;
   private int b;
   public float bw;
   public float bx;
   private Location c;
   private boolean d;
   private Location e;
   public PlayerAbilities abilities = new PlayerAbilities();
   public int bz;
   public int bA;
   public float bB;
   private int f;
   private ItemStack g;
   private int h;
   protected float bC = 0.1F;
   protected float bD = 0.02F;
   private int i;
   private final GameProfile bF;
   private boolean bG = false;
   public EntityFishingHook bE;


   public EntityHuman(World var1, GameProfile var2) {
      super(var1);
      this.ao = a(var2);
      this.bF = var2;
      this.bh = new ajb(this.bg, !var1.isStatic, this);
      this.bi = this.bh;
      Location var3 = var1.getSpawn();
      this.setPositionRotation((double)var3.n() + 0.5D, (double)(var3.o() + 1), (double)var3.p() + 0.5D, 0.0F, 0.0F);
      this.aT = 180.0F;
      this.X = 20;
   }

   protected void aW() {
      super.aW();
      this.getAttributeMap().load(GenericAttributes.e).a(1.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.10000000149011612D);
   }

   protected void h() {
      super.h();
      this.ac.a(16, Byte.valueOf((byte)0));
      this.ac.a(17, Float.valueOf(0.0F));
      this.ac.a(18, Integer.valueOf(0));
      this.ac.a(10, Byte.valueOf((byte)0));
   }

   public boolean bR() {
      return this.g != null;
   }

   public void bT() {
      if(this.g != null) {
         this.g.b(this.o, this, this.h);
      }

      this.bU();
   }

   public void bU() {
      this.g = null;
      this.h = 0;
      if(!this.o.isStatic) {
         this.f(false);
      }

   }

   public boolean bV() {
      return this.bR() && this.g.getItem().e(this.g) == EnumAnimation.BLOCK;
   }

   public void s_() throws IOException {
      this.T = this.v();
      if(this.v()) {
         this.C = false;
      }

      if(this.g != null) {
         ItemStack var1 = this.bg.h();
         if(var1 == this.g) {
            if(this.h <= 25 && this.h % 4 == 0) {
               this.b(var1, 5);
            }

            if(--this.h == 0 && !this.o.isStatic) {
               this.s();
            }
         } else {
            this.bU();
         }
      }

      if(this.bn > 0) {
         --this.bn;
      }

      if(this.bI()) {
         ++this.b;
         if(this.b > 100) {
            this.b = 100;
         }

         if(!this.o.isStatic) {
            if(!this.p()) {
               this.a(true, true, false);
            } else if(this.o.w()) {
               this.a(false, true, true);
            }
         }
      } else if(this.b > 0) {
         ++this.b;
         if(this.b >= 110) {
            this.b = 0;
         }
      }

      super.s_();
      if(!this.o.isStatic && this.bi != null && !this.bi.a(this)) {
         this.n();
         this.bi = this.bh;
      }

      if(this.au() && this.abilities.isInvulnerable) {
         this.N();
      }

      this.bo = this.br;
      this.bp = this.bs;
      this.bq = this.bt;
      double var14 = this.s - this.br;
      double var3 = this.t - this.bs;
      double var5 = this.u - this.bt;
      double var7 = 10.0D;
      if(var14 > var7) {
         this.bo = this.br = this.s;
      }

      if(var5 > var7) {
         this.bq = this.bt = this.u;
      }

      if(var3 > var7) {
         this.bp = this.bs = this.t;
      }

      if(var14 < -var7) {
         this.bo = this.br = this.s;
      }

      if(var5 < -var7) {
         this.bq = this.bt = this.u;
      }

      if(var3 < -var7) {
         this.bp = this.bs = this.t;
      }

      this.br += var14 * 0.25D;
      this.bt += var5 * 0.25D;
      this.bs += var3 * 0.25D;
      if(this.m == null) {
         this.e = null;
      }

      if(!this.o.isStatic) {
         this.bj.a(this);
         this.b(StatisticList.g);
         if(this.isAlive()) {
            this.b(StatisticList.h);
         }
      }

      int var9 = 29999999;
      double var10 = MathHelper.a(this.s, -2.9999999E7D, 2.9999999E7D);
      double var12 = MathHelper.a(this.u, -2.9999999E7D, 2.9999999E7D);
      if(var10 != this.s || var12 != this.u) {
         this.b(var10, this.t, var12);
      }

   }

   public int L() {
      return this.abilities.isInvulnerable?0:80;
   }

   protected String P() {
      return "game.player.swim";
   }

   protected String aa() {
      return "game.player.swim.splash";
   }

   public int ar() {
      return 10;
   }

   public void a(String var1, float var2, float var3) {
      this.o.a(this, var1, var2, var3);
   }

   protected void b(ItemStack var1, int var2) {
      if(var1.m() == EnumAnimation.DRINK) {
         this.a("random.drink", 0.5F, this.o.random.nextFloat() * 0.1F + 0.9F);
      }

      if(var1.m() == EnumAnimation.EAT) {
         for(int var3 = 0; var3 < var2; ++var3) {
            Vec3D var4 = new Vec3D(((double)this.V.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
            var4 = var4.a(-this.z * 3.1415927F / 180.0F);
            var4 = var4.b(-this.y * 3.1415927F / 180.0F);
            double var5 = (double)(-this.V.nextFloat()) * 0.6D - 0.3D;
            Vec3D var7 = new Vec3D(((double)this.V.nextFloat() - 0.5D) * 0.3D, var5, 0.6D);
            var7 = var7.a(-this.z * 3.1415927F / 180.0F);
            var7 = var7.b(-this.y * 3.1415927F / 180.0F);
            var7 = var7.add(this.s, this.t + (double)this.aR(), this.u);
            if(var1.usesData()) {
               this.o.a(EnumParticleEffect.K, var7.a, var7.b, var7.c, var4.a, var4.b + 0.05D, var4.c, new int[]{Item.getId(var1.getItem()), var1.getData()});
            } else {
               this.o.a(EnumParticleEffect.K, var7.a, var7.b, var7.c, var4.a, var4.b + 0.05D, var4.c, new int[]{Item.getId(var1.getItem())});
            }
         }

         this.a("random.eat", 0.5F + 0.5F * (float)this.V.nextInt(2), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
      }

   }

   protected void s() {
      if(this.g != null) {
         this.b(this.g, 16);
         int var1 = this.g.count;
         ItemStack var2 = this.g.b(this.o, this);
         if(var2 != this.g || var2 != null && var2.count != var1) {
            this.bg.a[this.bg.c] = var2;
            if(var2.count == 0) {
               this.bg.a[this.bg.c] = null;
            }
         }

         this.bU();
      }

   }

   protected boolean bC() {
      return this.bm() <= 0.0F || this.bI();
   }

   protected void n() {
      this.bi = this.bh;
   }

   public void ak() throws IOException {
      if(!this.o.isStatic && this.aw()) {
         this.a((Entity)null);
         this.c(false);
      } else {
         double var1 = this.s;
         double var3 = this.t;
         double var5 = this.u;
         float var7 = this.y;
         float var8 = this.z;
         super.ak();
         this.bl = this.bm;
         this.bm = 0.0F;
         this.l(this.s - var1, this.t - var3, this.u - var5);
         if(this.m instanceof EntityPig) {
            this.z = var8;
            this.y = var7;
            this.aG = ((EntityPig)this.m).aG;
         }

      }
   }

   protected void bJ() {
      super.bJ();
      this.bw();
      this.aI = this.y;
   }

   public void m() throws IOException {
      if(this.bk > 0) {
         --this.bk;
      }

      if(this.o.aa() == EnumDifficulty.PEACEFUL && this.o.getGameRules().getBoolean("naturalRegeneration")) {
         if(this.bm() < this.bt() && this.W % 20 == 0) {
            this.g(1.0F);
         }

         if(this.bj.c() && this.W % 10 == 0) {
            this.bj.a(this.bj.getFoodLevel() + 1);
         }
      }

      this.bg.k();
      this.bl = this.bm;
      super.m();
      AttributeInstance var1 = this.getAttributeInstance(GenericAttributes.d);
      if(!this.o.isStatic) {
         var1.a((double)this.abilities.b());
      }

      this.aK = this.bD;
      if(this.ax()) {
         this.aK = (float)((double)this.aK + (double)this.bD * 0.3D);
      }

      this.j((float)var1.getValue());
      float var2 = MathHelper.sqrt(this.v * this.v + this.x * this.x);
      float var3 = (float)(Math.atan(-this.w * 0.20000000298023224D) * 15.0D);
      if(var2 > 0.1F) {
         var2 = 0.1F;
      }

      if(!this.C || this.bm() <= 0.0F) {
         var2 = 0.0F;
      }

      if(this.C || this.bm() <= 0.0F) {
         var3 = 0.0F;
      }

      this.bm += (var2 - this.bm) * 0.4F;
      this.aD += (var3 - this.aD) * 0.8F;
      if(this.bm() > 0.0F && !this.v()) {
         AxisAlignedBB var4 = null;
         if(this.m != null && !this.m.I) {
            var4 = this.aQ().a(this.m.aQ()).b(1.0D, 0.0D, 1.0D);
         } else {
            var4 = this.aQ().b(1.0D, 0.5D, 1.0D);
         }

         List var5 = this.o.b((Entity)this, var4);

         for(int var6 = 0; var6 < var5.size(); ++var6) {
            Entity var7 = (Entity)var5.get(var6);
            if(!var7.I) {
               this.d(var7);
            }
         }
      }

   }

   private void d(Entity var1) throws IOException {
      var1.d(this);
   }

   public int bW() {
      return this.ac.c(18);
   }

   public void r(int var1) {
      this.ac.b(18, Integer.valueOf(var1));
   }

   public void s(int var1) {
      int var2 = this.bW();
      this.ac.b(18, Integer.valueOf(var2 + var1));
   }

   public void a(DamageSource var1) {
      super.a(var1);
      this.a(0.2F, 0.2F);
      this.b(this.s, this.t, this.u);
      this.w = 0.10000000149011612D;
      if(this.getName().equals("Notch")) {
         this.a(new ItemStack(Items.APPLE, 1), true, false);
      }

      if(!this.o.getGameRules().getBoolean("keepInventory")) {
         this.bg.n();
      }

      if(var1 != null) {
         this.v = (double)(-MathHelper.cos((this.au + this.y) * 3.1415927F / 180.0F) * 0.1F);
         this.x = (double)(-MathHelper.sin((this.au + this.y) * 3.1415927F / 180.0F) * 0.1F);
      } else {
         this.v = this.x = 0.0D;
      }

      this.b(StatisticList.y);
      this.a(StatisticList.h);
   }

   protected String bn() {
      return "game.player.hurt";
   }

   protected String bo() {
      return "game.player.die";
   }

   public void b(Entity var1, int var2) {
      this.s(var2);
      Collection var3 = this.co().getObjectivesForCriteria(IScoreboardCriteria.f);
      if(var1 instanceof EntityHuman) {
         this.b(StatisticList.B);
         var3.addAll(this.co().getObjectivesForCriteria(IScoreboardCriteria.e));
         var3.addAll(this.e(var1));
      } else {
         this.b(StatisticList.z);
      }

      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         ScoreboardObjective var5 = (ScoreboardObjective)var4.next();
         ScoreboardScore var6 = this.co().getPlayerScoreForObjective(this.getName(), var5);
         var6.incrementScore();
      }

   }

   private Collection e(Entity var1) {
      ScoreboardTeam var2 = this.co().getPlayerTeam(this.getName());
      if(var2 != null) {
         int var3 = var2.l().b();
         if(var3 >= 0 && var3 < IScoreboardCriteria.i.length) {
            Iterator var4 = this.co().getObjectivesForCriteria(IScoreboardCriteria.i[var3]).iterator();

            while(var4.hasNext()) {
               ScoreboardObjective var5 = (ScoreboardObjective)var4.next();
               ScoreboardScore var6 = this.co().getPlayerScoreForObjective(var1.getName(), var5);
               var6.incrementScore();
            }
         }
      }

      ScoreboardTeam var7 = this.co().getPlayerTeam(var1.getName());
      if(var7 != null) {
         int var8 = var7.l().b();
         if(var8 >= 0 && var8 < IScoreboardCriteria.h.length) {
            return this.co().getObjectivesForCriteria(IScoreboardCriteria.h[var8]);
         }
      }

      return Lists.newArrayList();
   }

   public EntityItem a(boolean var1) {
      return this.a(this.bg.a(this.bg.c, var1 && this.bg.h() != null?this.bg.h().count:1), false, true);
   }

   public EntityItem a(ItemStack var1, boolean var2) {
      return this.a(var1, false, false);
   }

   public EntityItem a(ItemStack var1, boolean var2, boolean var3) {
      if(var1 == null) {
         return null;
      } else if(var1.count == 0) {
         return null;
      } else {
         double var4 = this.t - 0.30000001192092896D + (double)this.aR();
         EntityItem var6 = new EntityItem(this.o, this.s, var4, this.u, var1);
         var6.a(40);
         if(var3) {
            var6.c(this.getName());
         }

         float var7;
         float var8;
         if(var2) {
            var7 = this.V.nextFloat() * 0.5F;
            var8 = this.V.nextFloat() * 3.1415927F * 2.0F;
            var6.v = (double)(-MathHelper.sin(var8) * var7);
            var6.x = (double)(MathHelper.cos(var8) * var7);
            var6.w = 0.20000000298023224D;
         } else {
            var7 = 0.3F;
            var6.v = (double)(-MathHelper.sin(this.y / 180.0F * 3.1415927F) * MathHelper.cos(this.z / 180.0F * 3.1415927F) * var7);
            var6.x = (double)(MathHelper.cos(this.y / 180.0F * 3.1415927F) * MathHelper.cos(this.z / 180.0F * 3.1415927F) * var7);
            var6.w = (double)(-MathHelper.sin(this.z / 180.0F * 3.1415927F) * var7 + 0.1F);
            var8 = this.V.nextFloat() * 3.1415927F * 2.0F;
            var7 = 0.02F * this.V.nextFloat();
            var6.v += Math.cos((double)var8) * (double)var7;
            var6.w += (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.1F);
            var6.x += Math.sin((double)var8) * (double)var7;
         }

         this.a(var6);
         if(var3) {
            this.b(StatisticList.v);
         }

         return var6;
      }
   }

   protected void a(EntityItem var1) {
      this.o.addEntity((Entity)var1);
   }

   public float a(Block var1) {
      float var2 = this.bg.a(var1);
      if(var2 > 1.0F) {
         int var3 = EnchantmentManager.c(this);
         ItemStack var4 = this.bg.h();
         if(var3 > 0 && var4 != null) {
            var2 += (float)(var3 * var3 + 1);
         }
      }

      if(this.a(MobEffectList.e)) {
         var2 *= 1.0F + (float)(this.b(MobEffectList.e).getAmplifier() + 1) * 0.2F;
      }

      if(this.a(MobEffectList.f)) {
         float var5 = 1.0F;
         switch(this.b(MobEffectList.f).getAmplifier()) {
         case 0:
            var5 = 0.3F;
            break;
         case 1:
            var5 = 0.09F;
            break;
         case 2:
            var5 = 0.0027F;
            break;
         case 3:
         default:
            var5 = 8.1E-4F;
         }

         var2 *= var5;
      }

      if(this.a(Material.WATER) && !EnchantmentManager.j(this)) {
         var2 /= 5.0F;
      }

      if(!this.C) {
         var2 /= 5.0F;
      }

      return var2;
   }

   public boolean b(Block var1) {
      return this.bg.b(var1);
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.ao = a(this.bF);
      NBTTagList var2 = var1.getList("Inventory", 10);
      this.bg.b(var2);
      this.bg.c = var1.getInt("SelectedItemSlot");
      this.bu = var1.getBoolean("Sleeping");
      this.b = var1.getShort("SleepTimer");
      this.bB = var1.getFloat("XpP");
      this.bz = var1.getInt("XpLevel");
      this.bA = var1.getInt("XpTotal");
      this.f = var1.getInt("XpSeed");
      if(this.f == 0) {
         this.f = this.V.nextInt();
      }

      this.r(var1.getInt("Score"));
      if(this.bu) {
         this.bv = new Location(this);
         this.a(true, true, false);
      }

      if(var1.hasKeyOfType("SpawnX", 99) && var1.hasKeyOfType("SpawnY", 99) && var1.hasKeyOfType("SpawnZ", 99)) {
         this.c = new Location(var1.getInt("SpawnX"), var1.getInt("SpawnY"), var1.getInt("SpawnZ"));
         this.d = var1.getBoolean("SpawnForced");
      }

      this.bj.a(var1);
      this.abilities.b(var1);
      if(var1.hasKeyOfType("EnderItems", 9)) {
         NBTTagList var3 = var1.getList("EnderItems", 10);
         this.a.a(var3);
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.set("Inventory", (NBTBase)this.bg.a(new NBTTagList()));
      var1.setInt("SelectedItemSlot", this.bg.c);
      var1.setBoolean("Sleeping", this.bu);
      var1.setShort("SleepTimer", (short)this.b);
      var1.setFloat("XpP", this.bB);
      var1.setInt("XpLevel", this.bz);
      var1.setInt("XpTotal", this.bA);
      var1.setInt("XpSeed", this.f);
      var1.setInt("Score", this.bW());
      if(this.c != null) {
         var1.setInt("SpawnX", this.c.n());
         var1.setInt("SpawnY", this.c.o());
         var1.setInt("SpawnZ", this.c.p());
         var1.setBoolean("SpawnForced", this.d);
      }

      this.bj.b(var1);
      this.abilities.a(var1);
      var1.set("EnderItems", (NBTBase)this.a.h());
      ItemStack var2 = this.bg.h();
      if(var2 != null && var2.getItem() != null) {
         var1.set("SelectedItem", (NBTBase)var2.save(new NBTTagCompound()));
      }

   }

   public boolean a(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else if(this.abilities.isInvulnerable && !var1.g()) {
         return false;
      } else {
         this.aO = 0;
         if(this.bm() <= 0.0F) {
            return false;
         } else {
            if(this.bI() && !this.o.isStatic) {
               this.a(true, true, false);
            }

            if(var1.r()) {
               if(this.o.aa() == EnumDifficulty.PEACEFUL) {
                  var2 = 0.0F;
               }

               if(this.o.aa() == EnumDifficulty.EASY) {
                  var2 = var2 / 2.0F + 1.0F;
               }

               if(this.o.aa() == EnumDifficulty.HARD) {
                  var2 = var2 * 3.0F / 2.0F;
               }
            }

            if(var2 == 0.0F) {
               return false;
            } else {
               Entity var3 = var1.getEntity();
               if(var3 instanceof EntityArrow && ((EntityArrow)var3).c != null) {
                  var3 = ((EntityArrow)var3).c;
               }

               return super.a(var1, var2);
            }
         }
      }
   }

   public boolean a(EntityHuman var1) {
      ScoreboardTeamBase var2 = this.bN();
      ScoreboardTeamBase var3 = var1.bN();
      return var2 == null?true:(!var2.a(var3)?true:var2.allowFriendlyFire());
   }

   protected void i(float var1) {
      this.bg.a(var1);
   }

   public int bq() {
      return this.bg.m();
   }

   public float bX() {
      int var1 = 0;
      ItemStack[] var2 = this.bg.b;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack var5 = var2[var4];
         if(var5 != null) {
            ++var1;
         }
      }

      return (float)var1 / (float)this.bg.b.length;
   }

   protected void d(DamageSource var1, float var2) {
      if(!this.b(var1)) {
         if(!var1.e() && this.bV() && var2 > 0.0F) {
            var2 = (1.0F + var2) * 0.5F;
         }

         var2 = this.b(var1, var2);
         var2 = this.c(var1, var2);
         float var3 = var2;
         var2 = Math.max(var2 - this.bM(), 0.0F);
         this.l(this.bM() - (var3 - var2));
         if(var2 != 0.0F) {
            this.a(var1.f());
            float var4 = this.bm();
            this.h(this.bm() - var2);
            this.br().a(var1, var4, var2);
            if(var2 < 3.4028235E37F) {
               this.a(StatisticList.x, Math.round(var2 * 10.0F));
            }

         }
      }
   }

   public void a(TileEntitySign var1) {}

   public void a(CommandBlockListenerAbstract var1) {}

   public void a(aqb var1) {}

   public void a(IInventory var1) {}

   public void a(EntityHorse var1, IInventory var2) {}

   public void a(vv var1) {}

   public void a(ItemStack var1) {}

   public boolean u(Entity var1) throws IOException {
      if(this.v()) {
         if(var1 instanceof IInventory) {
            this.a((IInventory)var1);
         }

         return false;
      } else {
         ItemStack var2 = this.bY();
         ItemStack var3 = var2 != null?var2.cloneItemStack():null;
         if(!var1.e(this)) {
            if(var2 != null && var1 instanceof EntityLiving) {
               if(this.abilities.canInstantlyBuild) {
                  var2 = var3;
               }

               if(var2.a(this, (EntityLiving)var1)) {
                  if(var2.count <= 0 && !this.abilities.canInstantlyBuild) {
                     this.bZ();
                  }

                  return true;
               }
            }

            return false;
         } else {
            if(var2 != null && var2 == this.bY()) {
               if(var2.count <= 0 && !this.abilities.canInstantlyBuild) {
                  this.bZ();
               } else if(var2.count < var3.count && this.abilities.canInstantlyBuild) {
                  var2.count = var3.count;
               }
            }

            return true;
         }
      }
   }

   public ItemStack bY() {
      return this.bg.h();
   }

   public void bZ() {
      this.bg.a(this.bg.c, (ItemStack)null);
   }

   public double am() {
      return -0.35D;
   }

   public void f(Entity var1) {
      if(var1.aE()) {
         if(!var1.l(this)) {
            float var2 = (float)this.getAttributeInstance(GenericAttributes.e).getValue();
            byte var3 = 0;
            float var4 = 0.0F;
            if(var1 instanceof EntityLiving) {
               var4 = EnchantmentManager.a(this.bz(), ((EntityLiving)var1).by());
            } else {
               var4 = EnchantmentManager.a(this.bz(), xs.a);
            }

            int var18 = var3 + EnchantmentManager.a((EntityLiving)this);
            if(this.ax()) {
               ++var18;
            }

            if(var2 > 0.0F || var4 > 0.0F) {
               boolean var5 = this.O > 0.0F && !this.C && !this.j_() && !this.V() && !this.a(MobEffectList.q) && this.m == null && var1 instanceof EntityLiving;
               if(var5 && var2 > 0.0F) {
                  var2 *= 1.5F;
               }

               var2 += var4;
               boolean var6 = false;
               int var7 = EnchantmentManager.getFireAspectEnchantmentLevel((EntityLiving)this);
               if(var1 instanceof EntityLiving && var7 > 0 && !var1.au()) {
                  var6 = true;
                  var1.e(1);
               }

               double var8 = var1.v;
               double var10 = var1.w;
               double var12 = var1.x;
               boolean var14 = var1.a(DamageSource.a(this), var2);
               if(var14) {
                  if(var18 > 0) {
                     var1.g((double)(-MathHelper.sin(this.y * 3.1415927F / 180.0F) * (float)var18 * 0.5F), 0.1D, (double)(MathHelper.cos(this.y * 3.1415927F / 180.0F) * (float)var18 * 0.5F));
                     this.v *= 0.6D;
                     this.x *= 0.6D;
                     this.d(false);
                  }

                  if(var1 instanceof EntityPlayer && var1.G) {
                     ((EntityPlayer)var1).a.sendPacket((Packet)(new PacketPlayOutEntityVelocity(var1)));
                     var1.G = false;
                     var1.v = var8;
                     var1.w = var10;
                     var1.x = var12;
                  }

                  if(var5) {
                     this.b(var1);
                  }

                  if(var4 > 0.0F) {
                     this.c(var1);
                  }

                  if(var2 >= 18.0F) {
                     this.b((Statistic)AchievementList.F);
                  }

                  this.p(var1);
                  if(var1 instanceof EntityLiving) {
                     EnchantmentManager.a((EntityLiving)var1, (Entity)this);
                  }

                  EnchantmentManager.b(this, var1);
                  ItemStack var15 = this.bY();
                  Object var16 = var1;
                  if(var1 instanceof EntityComplexPart) {
                     IComplexPart var17 = ((EntityComplexPart)var1).a;
                     if(var17 instanceof EntityLiving) {
                        var16 = (EntityLiving)var17;
                     }
                  }

                  if(var15 != null && var16 instanceof EntityLiving) {
                     var15.a((EntityLiving)var16, this);
                     if(var15.count <= 0) {
                        this.bZ();
                     }
                  }

                  if(var1 instanceof EntityLiving) {
                     this.a(StatisticList.w, Math.round(var2 * 10.0F));
                     if(var7 > 0) {
                        var1.e(var7 * 4);
                     }
                  }

                  this.a(0.3F);
               } else if(var6) {
                  var1.N();
               }
            }

         }
      }
   }

   public void b(Entity var1) {}

   public void c(Entity var1) {}

   public void J() {
      super.J();
      this.bh.b(this);
      if(this.bi != null) {
         this.bi.b(this);
      }

   }

   public boolean aj() {
      return !this.bu && super.aj();
   }

   public GameProfile cc() {
      return this.bF;
   }

   public ahf a(Location var1) {
      if(!this.o.isStatic) {
         if(this.bI() || !this.isAlive()) {
            return ahf.e;
         }

         if(!this.o.worldProvider.d()) {
            return ahf.b;
         }

         if(this.o.w()) {
            return ahf.c;
         }

         if(Math.abs(this.s - (double)var1.n()) > 3.0D || Math.abs(this.t - (double)var1.o()) > 2.0D || Math.abs(this.u - (double)var1.p()) > 3.0D) {
            return ahf.d;
         }

         double var2 = 8.0D;
         double var4 = 5.0D;
         List var6 = this.o.getEntities(EntityMonster.class, new AxisAlignedBB((double)var1.n() - var2, (double)var1.o() - var4, (double)var1.p() - var2, (double)var1.n() + var2, (double)var1.o() + var4, (double)var1.p() + var2));
         if(!var6.isEmpty()) {
            return ahf.f;
         }
      }

      if(this.av()) {
         this.a((Entity)null);
      }

      this.a(0.2F, 0.2F);
      if(this.o.isLoaded(var1)) {
         EnumFacing var7 = (EnumFacing)this.o.getData(var1).b(BlockDirectional.N);
         float var3 = 0.5F;
         float var8 = 0.5F;
         switch(ahe.a[var7.ordinal()]) {
         case 1:
            var8 = 0.9F;
            break;
         case 2:
            var8 = 0.1F;
            break;
         case 3:
            var3 = 0.1F;
            break;
         case 4:
            var3 = 0.9F;
         }

         this.a(var7);
         this.b((double)((float)var1.n() + var3), (double)((float)var1.o() + 0.6875F), (double)((float)var1.p() + var8));
      } else {
         this.b((double)((float)var1.n() + 0.5F), (double)((float)var1.o() + 0.6875F), (double)((float)var1.p() + 0.5F));
      }

      this.bu = true;
      this.b = 0;
      this.bv = var1;
      this.v = this.x = this.w = 0.0D;
      if(!this.o.isStatic) {
         this.o.everyoneSleeping();
      }

      return ahf.a;
   }

   private void a(EnumFacing var1) {
      this.bw = 0.0F;
      this.bx = 0.0F;
      switch(ahe.a[var1.ordinal()]) {
      case 1:
         this.bx = -1.8F;
         break;
      case 2:
         this.bx = 1.8F;
         break;
      case 3:
         this.bw = 1.8F;
         break;
      case 4:
         this.bw = -1.8F;
      }

   }

   public void a(boolean var1, boolean var2, boolean var3) {
      this.a(0.6F, 1.8F);
      IBlockData var4 = this.o.getData(this.bv);
      if(this.bv != null && var4.c() == Blocks.BED) {
         this.o.setTypeAndData(this.bv, var4.a(BlockBed.b, Boolean.valueOf(false)), 4);
         Location var5 = BlockBed.a(this.o, this.bv, 0);
         if(var5 == null) {
            var5 = this.bv.a();
         }

         this.b((double)((float)var5.n() + 0.5F), (double)((float)var5.o() + 0.1F), (double)((float)var5.p() + 0.5F));
      }

      this.bu = false;
      if(!this.o.isStatic && var2) {
         this.o.everyoneSleeping();
      }

      this.b = var1?0:100;
      if(var3) {
         this.a(this.bv, false);
      }

   }

   private boolean p() {
      return this.o.getData(this.bv).c() == Blocks.BED;
   }

   public static Location a(World var0, Location var1, boolean var2) {
      if(var0.getData(var1).c() != Blocks.BED) {
         if(!var2) {
            return null;
         } else {
            Material var3 = var0.getData(var1).c().getMaterial();
            Material var4 = var0.getData(var1.a()).c().getMaterial();
            boolean var5 = !var3.isBuildable() && !var3.isLiquid();
            boolean var6 = !var4.isBuildable() && !var4.isLiquid();
            return var5 && var6?var1:null;
         }
      } else {
         return BlockBed.a(var0, var1, 0);
      }
   }

   public boolean bI() {
      return this.bu;
   }

   public boolean ce() {
      return this.bu && this.b >= 100;
   }

   public void b(IChatBaseComponent var1) {}

   public Location cg() {
      return this.c;
   }

   public boolean ch() {
      return this.d;
   }

   public void a(Location var1, boolean var2) {
      if(var1 != null) {
         this.c = var1;
         this.d = var2;
      } else {
         this.c = null;
         this.d = false;
      }

   }

   public void b(Statistic var1) {
      this.a(var1, 1);
   }

   public void a(Statistic var1, int var2) {}

   public void a(Statistic var1) {}

   public void bE() {
      super.bE();
      this.b(StatisticList.u);
      if(this.ax()) {
         this.a(0.8F);
      } else {
         this.a(0.2F);
      }

   }

   public void g(float var1, float var2) {
      double var3 = this.s;
      double var5 = this.t;
      double var7 = this.u;
      if(this.abilities.isFlying && this.m == null) {
         double var9 = this.w;
         float var11 = this.aK;
         this.aK = this.abilities.a() * (float)(this.ax()?2:1);
         super.g(var1, var2);
         this.w = var9 * 0.6D;
         this.aK = var11;
      } else {
         super.g(var1, var2);
      }

      this.k(this.s - var3, this.t - var5, this.u - var7);
   }

   public float bH() {
      return (float)this.getAttributeInstance(GenericAttributes.d).getValue();
   }

   public void k(double var1, double var3, double var5) {
      if(this.m == null) {
         int var7;
         if(this.a(Material.WATER)) {
            var7 = Math.round(MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
            if(var7 > 0) {
               this.a(StatisticList.p, var7);
               this.a(0.015F * (float)var7 * 0.01F);
            }
         } else if(this.V()) {
            var7 = Math.round(MathHelper.sqrt(var1 * var1 + var5 * var5) * 100.0F);
            if(var7 > 0) {
               this.a(StatisticList.l, var7);
               this.a(0.015F * (float)var7 * 0.01F);
            }
         } else if(this.j_()) {
            if(var3 > 0.0D) {
               this.a(StatisticList.n, (int)Math.round(var3 * 100.0D));
            }
         } else if(this.C) {
            var7 = Math.round(MathHelper.sqrt(var1 * var1 + var5 * var5) * 100.0F);
            if(var7 > 0) {
               this.a(StatisticList.i, var7);
               if(this.ax()) {
                  this.a(StatisticList.k, var7);
                  this.a(0.099999994F * (float)var7 * 0.01F);
               } else {
                  if(this.aw()) {
                     this.a(StatisticList.j, var7);
                  }

                  this.a(0.01F * (float)var7 * 0.01F);
               }
            }
         } else {
            var7 = Math.round(MathHelper.sqrt(var1 * var1 + var5 * var5) * 100.0F);
            if(var7 > 25) {
               this.a(StatisticList.o, var7);
            }
         }

      }
   }

   private void l(double var1, double var3, double var5) {
      if(this.m != null) {
         int var7 = Math.round(MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
         if(var7 > 0) {
            if(this.m instanceof EntityMinecartAbstract) {
               this.a(StatisticList.q, var7);
               if(this.e == null) {
                  this.e = new Location(this);
               } else if(this.e.c((double)MathHelper.floor(this.s), (double)MathHelper.floor(this.t), (double)MathHelper.floor(this.u)) >= 1000000.0D) {
                  this.b((Statistic)AchievementList.q);
               }
            } else if(this.m instanceof EntityBoat) {
               this.a(StatisticList.r, var7);
            } else if(this.m instanceof EntityPig) {
               this.a(StatisticList.s, var7);
            } else if(this.m instanceof EntityHorse) {
               this.a(StatisticList.t, var7);
            }
         }
      }

   }

   public void e(float var1, float var2) {
      if(!this.abilities.canFly) {
         if(var1 >= 2.0F) {
            this.a(StatisticList.m, (int)Math.round((double)var1 * 100.0D));
         }

         super.e(var1, var2);
      }
   }

   protected void X() {
      if(!this.v()) {
         super.X();
      }

   }

   protected String n(int var1) {
      return var1 > 4?"game.player.hurt.fall.big":"game.player.hurt.fall.small";
   }

   public void a(EntityLiving var1) {
      if(var1 instanceof IMonster) {
         this.b((Statistic)AchievementList.s);
      }

      MonsterEggInfo var2 = (MonsterEggInfo)EntityTypes.a.get(Integer.valueOf(EntityTypes.a(var1)));
      if(var2 != null) {
         this.b(var2.d);
      }

   }

   public void aB() {
      if(!this.abilities.isFlying) {
         super.aB();
      }

   }

   public ItemStack q(int var1) {
      return this.bg.e(var1);
   }

   public void u(int var1) {
      this.s(var1);
      int var2 = Integer.MAX_VALUE - this.bA;
      if(var1 > var2) {
         var1 = var2;
      }

      this.bB += (float)var1 / (float)this.cj();

      for(this.bA += var1; this.bB >= 1.0F; this.bB /= (float)this.cj()) {
         this.bB = (this.bB - 1.0F) * (float)this.cj();
         this.a(1);
      }

   }

   public int ci() {
      return this.f;
   }

   public void b(int var1) {
      this.bz -= var1;
      if(this.bz < 0) {
         this.bz = 0;
         this.bB = 0.0F;
         this.bA = 0;
      }

      this.f = this.V.nextInt();
   }

   public void a(int var1) {
      this.bz += var1;
      if(this.bz < 0) {
         this.bz = 0;
         this.bB = 0.0F;
         this.bA = 0;
      }

      if(var1 > 0 && this.bz % 5 == 0 && (float)this.i < (float)this.W - 100.0F) {
         float var2 = this.bz > 30?1.0F:(float)this.bz / 30.0F;
         this.o.makeSound((Entity)this, "random.levelup", var2 * 0.75F, 1.0F);
         this.i = this.W;
      }

   }

   public int cj() {
      return this.bz >= 30?112 + (this.bz - 30) * 9:(this.bz >= 15?37 + (this.bz - 15) * 5:7 + this.bz * 2);
   }

   public void a(float var1) {
      if(!this.abilities.isInvulnerable) {
         if(!this.o.isStatic) {
            this.bj.a(var1);
         }

      }
   }

   public FoodMetaData ck() {
      return this.bj;
   }

   public boolean j(boolean var1) {
      return (var1 || this.bj.c()) && !this.abilities.isInvulnerable;
   }

   public boolean cl() {
      return this.bm() > 0.0F && this.bm() < this.bt();
   }

   public void a(ItemStack var1, int var2) {
      if(var1 != this.g) {
         this.g = var1;
         this.h = var2;
         if(!this.o.isStatic) {
            this.f(true);
         }

      }
   }

   public boolean cm() {
      return this.abilities.e;
   }

   public boolean a(Location var1, EnumFacing var2, ItemStack var3) {
      if(this.abilities.e) {
         return true;
      } else if(var3 == null) {
         return false;
      } else {
         Location var4 = var1.a(var2.d());
         Block var5 = this.o.getData(var4).c();
         return var3.d(var5) || var3.x();
      }
   }

   protected int b(EntityHuman var1) {
      if(this.o.getGameRules().getBoolean("keepInventory")) {
         return 0;
      } else {
         int var2 = this.bz * 7;
         return var2 > 100?100:var2;
      }
   }

   protected boolean ba() {
      return true;
   }

   public void a(EntityHuman var1, boolean var2) {
      if(var2) {
         this.bg.b(var1.bg);
         this.h(var1.bm());
         this.bj = var1.bj;
         this.bz = var1.bz;
         this.bA = var1.bA;
         this.bB = var1.bB;
         this.r(var1.bW());
         this.an = var1.an;
      } else if(this.o.getGameRules().getBoolean("keepInventory")) {
         this.bg.b(var1.bg);
         this.bz = var1.bz;
         this.bA = var1.bA;
         this.bB = var1.bB;
         this.r(var1.bW());
      }

      this.a = var1.a;
      this.H().b(10, Byte.valueOf(var1.H().a(10)));
   }

   protected boolean r_() {
      return !this.abilities.isFlying;
   }

   public void t() {}

   public void a(EnumGamemode var1) throws IOException {}

   public String getName() {
      return this.bF.getName();
   }

   public ajh cn() {
      return this.a;
   }

   public ItemStack p(int var1) {
      return var1 == 0?this.bg.h():this.bg.b[var1 - 1];
   }

   public ItemStack bz() {
      return this.bg.h();
   }

   public void c(int var1, ItemStack var2) {
      this.bg.b[var1] = var2;
   }

   public abstract boolean v();

   public ItemStack[] at() {
      return this.bg.b;
   }

   public boolean aK() {
      return !this.abilities.isFlying;
   }

   public Scoreboard co() {
      return this.o.getScoreboard();
   }

   public ScoreboardTeamBase bN() {
      return this.co().getPlayerTeam(this.getName());
   }

   public IChatBaseComponent getScoreboardDisplayName() {
      ChatComponentText var1 = new ChatComponentText(ScoreboardTeam.getPlayerDisplayName(this.bN(), this.getName()));
      var1.getChatModifier().a(new hm(hn.e, "/msg " + this.getName() + " "));
      var1.getChatModifier().a(this.aP());
      var1.getChatModifier().a(this.getName());
      return var1;
   }

   public float aR() {
      float var1 = 1.62F;
      if(this.bI()) {
         var1 = 0.2F;
      }

      if(this.aw()) {
         var1 -= 0.08F;
      }

      return var1;
   }

   public void l(float var1) {
      if(var1 < 0.0F) {
         var1 = 0.0F;
      }

      this.H().b(17, Float.valueOf(var1));
   }

   public float bM() {
      return this.H().d(17);
   }

   public static UUID a(GameProfile var0) {
      UUID var1 = var0.getId();
      if(var1 == null) {
         var1 = b(var0.getName());
      }

      return var1;
   }

   public static UUID b(String var0) {
      return UUID.nameUUIDFromBytes(("OfflinePlayer:" + var0).getBytes(Charsets.UTF_8));
   }

   public boolean a(InventoryPlayerLock var1) {
      if(var1.a()) {
         return true;
      } else {
         ItemStack var2 = this.bY();
         return var2 != null && var2.hasName()?var2.getName().equals(var1.b()):false;
      }
   }

   public boolean t_() {
      return MinecraftServer.M().c[0].getGameRules().getBoolean("sendCommandFeedback");
   }

   public boolean d(int var1, ItemStack var2) {
      if(var1 >= 0 && var1 < this.bg.a.length) {
         this.bg.a(var1, var2);
         return true;
      } else {
         int var3 = var1 - 100;
         int var4;
         if(var3 >= 0 && var3 < this.bg.b.length) {
            var4 = var3 + 1;
            if(var2 != null && var2.getItem() != null) {
               if(var2.getItem() instanceof ItemArmor) {
                  if(EntityInsentient.c(var2) != var4) {
                     return false;
                  }
               } else if(var4 != 4 || var2.getItem() != Items.bX && !(var2.getItem() instanceof ItemBlock)) {
                  return false;
               }
            }

            this.bg.a(var3 + this.bg.a.length, var2);
            return true;
         } else {
            var4 = var1 - 200;
            if(var4 >= 0 && var4 < this.a.n_()) {
               this.a.a(var4, var2);
               return true;
            } else {
               return false;
            }
         }
      }
   }
}
