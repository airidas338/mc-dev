package net.minecraft.server;

import com.google.common.collect.Maps;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public abstract class EntityLiving extends Entity {

   private static final UUID a = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
   private static final ya b = (new ya(a, "Sprinting speed boost", 0.30000001192092896D, 2)).a(false);
   private AttributeMapBase c;
   private final wg f = new wg(this);
   private final Map g = Maps.newHashMap();
   private final ItemStack[] h = new ItemStack[5];
   public boolean ap;
   public int aq;
   public int ar;
   public int as;
   public int at;
   public float au;
   public int av;
   public float aw;
   public float ax;
   public float ay;
   public float az;
   public float aA;
   public int aB = 20;
   public float aC;
   public float aD;
   public float aE;
   public float aF;
   public float aG;
   public float aH;
   public float aI;
   public float aJ;
   public float aK = 0.02F;
   protected EntityHuman aL;
   protected int aM;
   protected boolean aN;
   protected int aO;
   protected float aP;
   protected float aQ;
   protected float aR;
   protected float aS;
   protected float aT;
   protected int aU;
   protected float aV;
   protected boolean aW;
   public float aX;
   public float aY;
   protected float aZ;
   protected int ba;
   protected double bb;
   protected double bc;
   protected double bd;
   protected double be;
   protected double bf;
   private boolean i = true;
   private EntityLiving bg;
   private int bh;
   private EntityLiving bi;
   private int bj;
   private float bk;
   private int bl;
   private float bm;


   public void G() {
      this.a(DamageSource.j, Float.MAX_VALUE);
   }

   public EntityLiving(World var1) {
      super(var1);
      this.aW();
      this.h(this.bt());
      this.k = true;
      this.aF = (float)((Math.random() + 1.0D) * 0.009999999776482582D);
      this.b(this.s, this.t, this.u);
      this.aE = (float)Math.random() * 12398.0F;
      this.y = (float)(Math.random() * 3.1415927410125732D * 2.0D);
      this.aI = this.y;
      this.S = 0.6F;
   }

   protected void h() {
      this.ac.a(7, Integer.valueOf(0));
      this.ac.a(8, Byte.valueOf((byte)0));
      this.ac.a(9, Byte.valueOf((byte)0));
      this.ac.a(6, Float.valueOf(1.0F));
   }

   protected void aW() {
      this.getAttributeMap().load(GenericAttributes.a);
      this.getAttributeMap().load(GenericAttributes.c);
      this.getAttributeMap().load(GenericAttributes.d);
   }

   protected void a(double var1, boolean var3, Block var4, Location var5) {
      if(!this.V()) {
         this.W();
      }

      if(!this.o.D && this.O > 3.0F && var3) {
         IBlock var6 = this.o.getData(var5);
         Block var7 = var6.c();
         float var8 = (float)MathHelper.f(this.O - 3.0F);
         if(var7.r() != Material.AIR) {
            double var9 = (double)Math.min(0.2F + var8 / 15.0F, 10.0F);
            if(var9 > 2.5D) {
               var9 = 2.5D;
            }

            int var11 = (int)(150.0D * var9);
            ((WorldServer)this.o).a(ew.M, this.s, this.t, this.u, var11, 0.0D, 0.0D, 0.0D, 0.15000000596046448D, new int[]{Block.f(var6)});
         }
      }

      super.a(var1, var3, var4, var5);
   }

   public boolean aX() {
      return false;
   }

   public void K() throws IOException {
      this.aw = this.ax;
      super.K();
      this.o.B.a("livingEntityBaseTick");
      boolean var1 = this instanceof EntityHuman;
      if(this.isAlive()) {
         if(this.aj()) {
            this.a(DamageSource.e, 1.0F);
         } else if(var1 && !this.o.af().a(this.aQ())) {
            double var2 = this.o.af().a((Entity)this) + this.o.af().m();
            if(var2 < 0.0D) {
               this.a(DamageSource.e, (float)Math.max(1, MathHelper.c(-var2 * this.o.af().n())));
            }
         }
      }

      if(this.T() || this.o.D) {
         this.N();
      }

      boolean var7 = var1 && ((EntityHuman)this).by.a;
      if(this.isAlive() && this.a(Material.WATER)) {
         if(!this.aX() && !this.k(MobEffectList.o.H) && !var7) {
            this.h(this.j(this.aA()));
            if(this.aA() == -20) {
               this.h(0);

               for(int var3 = 0; var3 < 8; ++var3) {
                  float var4 = this.V.nextFloat() - this.V.nextFloat();
                  float var5 = this.V.nextFloat() - this.V.nextFloat();
                  float var6 = this.V.nextFloat() - this.V.nextFloat();
                  this.o.a(ew.e, this.s + (double)var4, this.t + (double)var5, this.u + (double)var6, this.v, this.w, this.x, new int[0]);
               }

               this.a(DamageSource.f, 2.0F);
            }
         }

         if(!this.o.D && this.av() && this.m instanceof EntityLiving) {
            this.a((Entity)null);
         }
      } else {
         this.h(300);
      }

      if(this.isAlive() && this.U()) {
         this.N();
      }

      this.aC = this.aD;
      if(this.as > 0) {
         --this.as;
      }

      if(this.Z > 0 && !(this instanceof EntityPlayer)) {
         --this.Z;
      }

      if(this.bm() <= 0.0F) {
         this.aY();
      }

      if(this.aM > 0) {
         --this.aM;
      } else {
         this.aL = null;
      }

      if(this.bi != null && !this.bi.isAlive()) {
         this.bi = null;
      }

      if(this.bg != null) {
         if(!this.bg.isAlive()) {
            this.b((EntityLiving)null);
         } else if(this.W - this.bh > 100) {
            this.b((EntityLiving)null);
         }
      }

      this.bh();
      this.aS = this.aR;
      this.aH = this.aG;
      this.aJ = this.aI;
      this.A = this.y;
      this.B = this.z;
      this.o.B.b();
   }

   public boolean i_() {
      return false;
   }

   protected void aY() {
      ++this.av;
      if(this.av == 20) {
         int var1;
         if(!this.o.D && (this.aM > 0 || this.ba()) && this.aZ() && this.o.Q().b("doMobLoot")) {
            var1 = this.b(this.aL);

            while(var1 > 0) {
               int var2 = EntityExperienceOrb.a(var1);
               var1 -= var2;
               this.o.d((Entity)(new EntityExperienceOrb(this.o, this.s, this.t, this.u, var2)));
            }
         }

         this.J();

         for(var1 = 0; var1 < 20; ++var1) {
            double var8 = this.V.nextGaussian() * 0.02D;
            double var4 = this.V.nextGaussian() * 0.02D;
            double var6 = this.V.nextGaussian() * 0.02D;
            this.o.a(ew.a, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var8, var4, var6, new int[0]);
         }
      }

   }

   protected boolean aZ() {
      return !this.i_();
   }

   protected int j(int var1) {
      int var2 = EnchantmentManager.a((Entity)this);
      return var2 > 0 && this.V.nextInt(var2 + 1) > 0?var1:var1 - 1;
   }

   protected int b(EntityHuman var1) {
      return 0;
   }

   protected boolean ba() {
      return false;
   }

   public Random bb() {
      return this.V;
   }

   public EntityLiving bc() {
      return this.bg;
   }

   public int bd() {
      return this.bh;
   }

   public void b(EntityLiving var1) {
      this.bg = var1;
      this.bh = this.W;
   }

   public EntityLiving be() {
      return this.bi;
   }

   public int bf() {
      return this.bj;
   }

   public void p(Entity var1) {
      if(var1 instanceof EntityLiving) {
         this.bi = (EntityLiving)var1;
      } else {
         this.bi = null;
      }

      this.bj = this.W;
   }

   public int bg() {
      return this.aO;
   }

   public void b(NBTTagCompound var1) {
      var1.setFloat("HealF", this.bm());
      var1.setShort("Health", (short)((int)Math.ceil((double)this.bm())));
      var1.setShort("HurtTime", (short)this.as);
      var1.setInt("HurtByTimestamp", this.bh);
      var1.setShort("DeathTime", (short)this.av);
      var1.setFloat("AbsorptionAmount", this.bM());
      ItemStack[] var2 = this.at();
      int var3 = var2.length;

      int var4;
      ItemStack var5;
      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if(var5 != null) {
            this.c.a(var5.B());
         }
      }

      var1.set("Attributes", (NBTBase)GenericAttributes.a(this.getAttributeMap()));
      var2 = this.at();
      var3 = var2.length;

      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if(var5 != null) {
            this.c.b(var5.B());
         }
      }

      if(!this.g.isEmpty()) {
         NBTTagList var6 = new NBTTagList();
         Iterator var7 = this.g.values().iterator();

         while(var7.hasNext()) {
            MobEffect var8 = (MobEffect)var7.next();
            var6.a((NBTBase)var8.a(new NBTTagCompound()));
         }

         var1.set("ActiveEffects", (NBTBase)var6);
      }

   }

   public void a(NBTTagCompound var1) {
      this.l(var1.getFloat("AbsorptionAmount"));
      if(var1.b("Attributes", 9) && this.o != null && !this.o.D) {
         GenericAttributes.a(this.getAttributeMap(), var1.getList("Attributes", 10));
      }

      if(var1.b("ActiveEffects", 9)) {
         NBTTagList var2 = var1.getList("ActiveEffects", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            NBTTagCompound var4 = var2.b(var3);
            MobEffect var5 = MobEffect.b(var4);
            if(var5 != null) {
               this.g.put(Integer.valueOf(var5.getEffectId()), var5);
            }
         }
      }

      if(var1.b("HealF", 99)) {
         this.h(var1.getFloat("HealF"));
      } else {
         NBTBase var6 = var1.a("Health");
         if(var6 == null) {
            this.h(this.bt());
         } else if(var6.getTypeId() == 5) {
            this.h(((NBTTagFloat)var6).h());
         } else if(var6.getTypeId() == 2) {
            this.h((float)((NBTTagShort)var6).e());
         }
      }

      this.as = var1.getShort("HurtTime");
      this.av = var1.getShort("DeathTime");
      this.bh = var1.getInt("HurtByTimestamp");
   }

   protected void bh() {
      Iterator var1 = this.g.keySet().iterator();

      while(var1.hasNext()) {
         Integer var2 = (Integer)var1.next();
         MobEffect var3 = (MobEffect)this.g.get(var2);
         if(!var3.a(this)) {
            if(!this.o.D) {
               var1.remove();
               this.b(var3);
            }
         } else if(var3.getDuration() % 600 == 0) {
            this.a(var3, false);
         }
      }

      if(this.i) {
         if(!this.o.D) {
            this.B();
         }

         this.i = false;
      }

      int var11 = this.ac.c(7);
      boolean var12 = this.ac.a(8) > 0;
      if(var11 > 0) {
         boolean var4 = false;
         if(!this.ay()) {
            var4 = this.V.nextBoolean();
         } else {
            var4 = this.V.nextInt(15) == 0;
         }

         if(var12) {
            var4 &= this.V.nextInt(5) == 0;
         }

         if(var4 && var11 > 0) {
            double var5 = (double)(var11 >> 16 & 255) / 255.0D;
            double var7 = (double)(var11 >> 8 & 255) / 255.0D;
            double var9 = (double)(var11 >> 0 & 255) / 255.0D;
            this.o.a(var12?ew.q:ew.p, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J, this.t + this.V.nextDouble() * (double)this.K, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J, var5, var7, var9, new int[0]);
         }
      }

   }

   protected void B() {
      if(this.g.isEmpty()) {
         this.bi();
         this.e(false);
      } else {
         int var1 = PotionBrewer.a(this.g.values());
         this.ac.b(8, Byte.valueOf((byte)(PotionBrewer.b(this.g.values())?1:0)));
         this.ac.b(7, Integer.valueOf(var1));
         this.e(this.k(MobEffectList.p.H));
      }

   }

   protected void bi() {
      this.ac.b(8, Byte.valueOf((byte)0));
      this.ac.b(7, Integer.valueOf(0));
   }

   public void bj() {
      Iterator var1 = this.g.keySet().iterator();

      while(var1.hasNext()) {
         Integer var2 = (Integer)var1.next();
         MobEffect var3 = (MobEffect)this.g.get(var2);
         if(!this.o.D) {
            var1.remove();
            this.b(var3);
         }
      }

   }

   public Collection bk() {
      return this.g.values();
   }

   public boolean k(int var1) {
      return this.g.containsKey(Integer.valueOf(var1));
   }

   public boolean a(MobEffectList var1) {
      return this.g.containsKey(Integer.valueOf(var1.H));
   }

   public MobEffect b(MobEffectList var1) {
      return (MobEffect)this.g.get(Integer.valueOf(var1.H));
   }

   public void c(MobEffect var1) {
      if(this.d(var1)) {
         if(this.g.containsKey(Integer.valueOf(var1.getEffectId()))) {
            ((MobEffect)this.g.get(Integer.valueOf(var1.getEffectId()))).a(var1);
            this.a((MobEffect)this.g.get(Integer.valueOf(var1.getEffectId())), true);
         } else {
            this.g.put(Integer.valueOf(var1.getEffectId()), var1);
            this.a(var1);
         }

      }
   }

   public boolean d(MobEffect var1) {
      if(this.by() == xs.b) {
         int var2 = var1.getEffectId();
         if(var2 == MobEffectList.l.H || var2 == MobEffectList.u.H) {
            return false;
         }
      }

      return true;
   }

   public boolean bl() {
      return this.by() == xs.b;
   }

   public void m(int var1) {
      MobEffect var2 = (MobEffect)this.g.remove(Integer.valueOf(var1));
      if(var2 != null) {
         this.b(var2);
      }

   }

   protected void a(MobEffect var1) {
      this.i = true;
      if(!this.o.D) {
         MobEffectList.a[var1.getEffectId()].b(this, this.getAttributeMap(), var1.getAmplifier());
      }

   }

   protected void a(MobEffect var1, boolean var2) {
      this.i = true;
      if(var2 && !this.o.D) {
         MobEffectList.a[var1.getEffectId()].a(this, this.getAttributeMap(), var1.getAmplifier());
         MobEffectList.a[var1.getEffectId()].b(this, this.getAttributeMap(), var1.getAmplifier());
      }

   }

   protected void b(MobEffect var1) {
      this.i = true;
      if(!this.o.D) {
         MobEffectList.a[var1.getEffectId()].a(this, this.getAttributeMap(), var1.getAmplifier());
      }

   }

   public void g(float var1) {
      float var2 = this.bm();
      if(var2 > 0.0F) {
         this.h(var2 + var1);
      }

   }

   public final float bm() {
      return this.ac.d(6);
   }

   public void h(float var1) {
      this.ac.b(6, Float.valueOf(MathHelper.a(var1, 0.0F, this.bt())));
   }

   public boolean a(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else if(this.o.D) {
         return false;
      } else {
         this.aO = 0;
         if(this.bm() <= 0.0F) {
            return false;
         } else if(var1.o() && this.a(MobEffectList.n)) {
            return false;
         } else {
            if((var1 == DamageSource.n || var1 == DamageSource.o) && this.p(4) != null) {
               this.p(4).a((int)(var2 * 4.0F + this.V.nextFloat() * var2 * 2.0F), this);
               var2 *= 0.75F;
            }

            this.az = 1.5F;
            boolean var3 = true;
            if((float)this.Z > (float)this.aB / 2.0F) {
               if(var2 <= this.aV) {
                  return false;
               }

               this.d(var1, var2 - this.aV);
               this.aV = var2;
               var3 = false;
            } else {
               this.aV = var2;
               this.Z = this.aB;
               this.d(var1, var2);
               this.as = this.at = 10;
            }

            this.au = 0.0F;
            Entity var4 = var1.getEntity();
            if(var4 != null) {
               if(var4 instanceof EntityLiving) {
                  this.b((EntityLiving)var4);
               }

               if(var4 instanceof EntityHuman) {
                  this.aM = 100;
                  this.aL = (EntityHuman)var4;
               } else if(var4 instanceof EntityWolf) {
                  EntityWolf var5 = (EntityWolf)var4;
                  if(var5.cj()) {
                     this.aM = 100;
                     this.aL = null;
                  }
               }
            }

            if(var3) {
               this.o.a((Entity)this, (byte)2);
               if(var1 != DamageSource.f) {
                  this.ac();
               }

               if(var4 != null) {
                  double var9 = var4.s - this.s;

                  double var7;
                  for(var7 = var4.u - this.u; var9 * var9 + var7 * var7 < 1.0E-4D; var7 = (Math.random() - Math.random()) * 0.01D) {
                     var9 = (Math.random() - Math.random()) * 0.01D;
                  }

                  this.au = (float)(Math.atan2(var7, var9) * 180.0D / 3.1415927410125732D - (double)this.y);
                  this.a(var4, var2, var9, var7);
               } else {
                  this.au = (float)((int)(Math.random() * 2.0D) * 180);
               }
            }

            String var10;
            if(this.bm() <= 0.0F) {
               var10 = this.bo();
               if(var3 && var10 != null) {
                  this.a(var10, this.bA(), this.bB());
               }

               this.a(var1);
            } else {
               var10 = this.bn();
               if(var3 && var10 != null) {
                  this.a(var10, this.bA(), this.bB());
               }
            }

            return true;
         }
      }
   }

   public void b(ItemStack var1) {
      this.a("random.break", 0.8F, 0.8F + this.o.s.nextFloat() * 0.4F);

      for(int var2 = 0; var2 < 5; ++var2) {
         Vec3D var3 = new Vec3D(((double)this.V.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
         var3 = var3.a(-this.z * 3.1415927F / 180.0F);
         var3 = var3.b(-this.y * 3.1415927F / 180.0F);
         double var4 = (double)(-this.V.nextFloat()) * 0.6D - 0.3D;
         Vec3D var6 = new Vec3D(((double)this.V.nextFloat() - 0.5D) * 0.3D, var4, 0.6D);
         var6 = var6.a(-this.z * 3.1415927F / 180.0F);
         var6 = var6.b(-this.y * 3.1415927F / 180.0F);
         var6 = var6.b(this.s, this.t + (double)this.aR(), this.u);
         this.o.a(ew.K, var6.a, var6.b, var6.c, var3.a, var3.b + 0.05D, var3.c, new int[]{Item.b(var1.b())});
      }

   }

   public void a(DamageSource var1) {
      Entity var2 = var1.getEntity();
      EntityLiving var3 = this.bs();
      if(this.aU >= 0 && var3 != null) {
         var3.b(this, this.aU);
      }

      if(var2 != null) {
         var2.a(this);
      }

      this.aN = true;
      this.br().g();
      if(!this.o.D) {
         int var4 = 0;
         if(var2 instanceof EntityHuman) {
            var4 = EnchantmentManager.i((EntityLiving)var2);
         }

         if(this.aZ() && this.o.Q().b("doMobLoot")) {
            this.b(this.aM > 0, var4);
            this.a(this.aM > 0, var4);
            if(this.aM > 0 && this.V.nextFloat() < 0.025F + (float)var4 * 0.01F) {
               this.bp();
            }
         }
      }

      this.o.a((Entity)this, (byte)3);
   }

   protected void a(boolean var1, int var2) {}

   public void a(Entity var1, float var2, double var3, double var5) {
      if(this.V.nextDouble() >= this.getAttributeInstance(GenericAttributes.c).getValue()) {
         this.ai = true;
         float var7 = MathHelper.sqrt(var3 * var3 + var5 * var5);
         float var8 = 0.4F;
         this.v /= 2.0D;
         this.w /= 2.0D;
         this.x /= 2.0D;
         this.v -= var3 / (double)var7 * (double)var8;
         this.w += (double)var8;
         this.x -= var5 / (double)var7 * (double)var8;
         if(this.w > 0.4000000059604645D) {
            this.w = 0.4000000059604645D;
         }

      }
   }

   protected String bn() {
      return "game.neutral.hurt";
   }

   protected String bo() {
      return "game.neutral.die";
   }

   protected void bp() {}

   protected void b(boolean var1, int var2) {}

   public boolean j_() {
      int var1 = MathHelper.c(this.s);
      int var2 = MathHelper.c(this.aQ().b);
      int var3 = MathHelper.c(this.u);
      Block var4 = this.o.getData(new Location(var1, var2, var3)).c();
      return (var4 == Blocks.au || var4 == Blocks.bn) && (!(this instanceof EntityHuman) || !((EntityHuman)this).v());
   }

   public boolean isAlive() {
      return !this.I && this.bm() > 0.0F;
   }

   public void e(float var1, float var2) {
      super.e(var1, var2);
      MobEffect var3 = this.b(MobEffectList.j);
      float var4 = var3 != null?(float)(var3.getAmplifier() + 1):0.0F;
      int var5 = MathHelper.f((var1 - 3.0F - var4) * var2);
      if(var5 > 0) {
         this.a(this.n(var5), 1.0F, 1.0F);
         this.a(DamageSource.i, (float)var5);
         int var6 = MathHelper.c(this.s);
         int var7 = MathHelper.c(this.t - 0.20000000298023224D);
         int var8 = MathHelper.c(this.u);
         Block var9 = this.o.getData(new Location(var6, var7, var8)).c();
         if(var9.r() != Material.AIR) {
            StepSound var10 = var9.H;
            this.a(var10.c(), var10.d() * 0.5F, var10.e() * 0.75F);
         }
      }

   }

   protected String n(int var1) {
      return var1 > 4?"game.neutral.hurt.fall.big":"game.neutral.hurt.fall.small";
   }

   public int bq() {
      int var1 = 0;
      ItemStack[] var2 = this.at();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         ItemStack var5 = var2[var4];
         if(var5 != null && var5.b() instanceof ItemArmor) {
            int var6 = ((ItemArmor)var5.b()).c;
            var1 += var6;
         }
      }

      return var1;
   }

   protected void i(float var1) {}

   protected float b(DamageSource var1, float var2) {
      if(!var1.e()) {
         int var3 = 25 - this.bq();
         float var4 = var2 * (float)var3;
         this.i(var2);
         var2 = var4 / 25.0F;
      }

      return var2;
   }

   protected float c(DamageSource var1, float var2) {
      if(var1.h()) {
         return var2;
      } else {
         int var3;
         int var4;
         float var5;
         if(this.a(MobEffectList.m) && var1 != DamageSource.j) {
            var3 = (this.b(MobEffectList.m).getAmplifier() + 1) * 5;
            var4 = 25 - var3;
            var5 = var2 * (float)var4;
            var2 = var5 / 25.0F;
         }

         if(var2 <= 0.0F) {
            return 0.0F;
         } else {
            var3 = EnchantmentManager.a(this.at(), var1);
            if(var3 > 20) {
               var3 = 20;
            }

            if(var3 > 0 && var3 <= 20) {
               var4 = 25 - var3;
               var5 = var2 * (float)var4;
               var2 = var5 / 25.0F;
            }

            return var2;
         }
      }
   }

   protected void d(DamageSource var1, float var2) {
      if(!this.b(var1)) {
         var2 = this.b(var1, var2);
         var2 = this.c(var1, var2);
         float var3 = var2;
         var2 = Math.max(var2 - this.bM(), 0.0F);
         this.l(this.bM() - (var3 - var2));
         if(var2 != 0.0F) {
            float var4 = this.bm();
            this.h(var4 - var2);
            this.br().a(var1, var4, var2);
            this.l(this.bM() - var2);
         }
      }
   }

   public wg br() {
      return this.f;
   }

   public EntityLiving bs() {
      return (EntityLiving)(this.f.c() != null?this.f.c():(this.aL != null?this.aL:(this.bg != null?this.bg:null)));
   }

   public final float bt() {
      return (float)this.getAttributeInstance(GenericAttributes.a).getValue();
   }

   public final int bu() {
      return this.ac.a(9);
   }

   public final void o(int var1) {
      this.ac.b(9, Byte.valueOf((byte)var1));
   }

   private int n() {
      return this.a(MobEffectList.e)?6 - (1 + this.b(MobEffectList.e).getAmplifier()) * 1:(this.a(MobEffectList.f)?6 + (1 + this.b(MobEffectList.f).getAmplifier()) * 2:6);
   }

   public void bv() {
      if(!this.ap || this.aq >= this.n() / 2 || this.aq < 0) {
         this.aq = -1;
         this.ap = true;
         if(this.o instanceof WorldServer) {
            ((WorldServer)this.o).s().a((Entity)this, (Packet)(new ir(this, 0)));
         }
      }

   }

   protected void O() {
      this.a(DamageSource.j, 4.0F);
   }

   protected void bw() {
      int var1 = this.n();
      if(this.ap) {
         ++this.aq;
         if(this.aq >= var1) {
            this.aq = 0;
            this.ap = false;
         }
      } else {
         this.aq = 0;
      }

      this.ax = (float)this.aq / (float)var1;
   }

   public AttributeInstance getAttributeInstance(IAttribute var1) {
      return this.getAttributeMap().a(var1);
   }

   public AttributeMapBase getAttributeMap() {
      if(this.c == null) {
         this.c = new yf();
      }

      return this.c;
   }

   public xs by() {
      return xs.a;
   }

   public abstract ItemStack bz();

   public abstract ItemStack p(int var1);

   public abstract void c(int var1, ItemStack var2);

   public void d(boolean var1) {
      super.d(var1);
      AttributeInstance var2 = this.getAttributeInstance(GenericAttributes.d);
      if(var2.a(a) != null) {
         var2.c(b);
      }

      if(var1) {
         var2.b(b);
      }

   }

   public abstract ItemStack[] at();

   protected float bA() {
      return 1.0F;
   }

   protected float bB() {
      return this.i_()?(this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.5F:(this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F;
   }

   protected boolean bC() {
      return this.bm() <= 0.0F;
   }

   public void q(Entity var1) {
      double var3 = var1.s;
      double var5 = var1.aQ().b + (double)var1.K;
      double var7 = var1.u;
      byte var9 = 1;

      for(int var10 = -var9; var10 <= var9; ++var10) {
         for(int var11 = -var9; var11 < var9; ++var11) {
            if(var10 != 0 || var11 != 0) {
               int var12 = (int)(this.s + (double)var10);
               int var13 = (int)(this.u + (double)var11);
               AxisAlignedBB var2 = this.aQ().c((double)var10, 1.0D, (double)var11);
               if(this.o.a(var2).isEmpty()) {
                  if(World.a((IBlockAccess)this.o, new Location(var12, (int)this.t, var13))) {
                     this.a(this.s + (double)var10, this.t + 1.0D, this.u + (double)var11);
                     return;
                  }

                  if(World.a((IBlockAccess)this.o, new Location(var12, (int)this.t - 1, var13)) || this.o.getData(new Location(var12, (int)this.t - 1, var13)).c().r() == Material.WATER) {
                     var3 = this.s + (double)var10;
                     var5 = this.t + 1.0D;
                     var7 = this.u + (double)var11;
                  }
               }
            }
         }
      }

      this.a(var3, var5, var7);
   }

   protected float bD() {
      return 0.42F;
   }

   protected void bE() {
      this.w = (double)this.bD();
      if(this.a(MobEffectList.j)) {
         this.w += (double)((float)(this.b(MobEffectList.j).getAmplifier() + 1) * 0.1F);
      }

      if(this.ax()) {
         float var1 = this.y * 0.017453292F;
         this.v -= (double)(MathHelper.sin(var1) * 0.2F);
         this.x += (double)(MathHelper.cos(var1) * 0.2F);
      }

      this.ai = true;
   }

   protected void bF() {
      this.w += 0.03999999910593033D;
   }

   protected void bG() {
      this.w += 0.03999999910593033D;
   }

   public void g(float var1, float var2) {
      double var8;
      float var9;
      if(this.bL()) {
         float var5;
         float var6;
         if(this.V() && (!(this instanceof EntityHuman) || !((EntityHuman)this).by.b)) {
            var8 = this.t;
            var5 = 0.8F;
            var6 = 0.02F;
            var9 = (float)EnchantmentManager.b((Entity)this);
            if(var9 > 3.0F) {
               var9 = 3.0F;
            }

            if(!this.C) {
               var9 *= 0.5F;
            }

            if(var9 > 0.0F) {
               var5 += (0.54600006F - var5) * var9 / 3.0F;
               var6 += (this.bH() * 1.0F - var6) * var9 / 3.0F;
            }

            this.a(var1, var2, var6);
            this.d(this.v, this.w, this.x);
            this.v *= (double)var5;
            this.w *= 0.800000011920929D;
            this.x *= (double)var5;
            this.w -= 0.02D;
            if(this.D && this.c(this.v, this.w + 0.6000000238418579D - this.t + var8, this.x)) {
               this.w = 0.30000001192092896D;
            }
         } else if(this.ab() && (!(this instanceof EntityHuman) || !((EntityHuman)this).by.b)) {
            var8 = this.t;
            this.a(var1, var2, 0.02F);
            this.d(this.v, this.w, this.x);
            this.v *= 0.5D;
            this.w *= 0.5D;
            this.x *= 0.5D;
            this.w -= 0.02D;
            if(this.D && this.c(this.v, this.w + 0.6000000238418579D - this.t + var8, this.x)) {
               this.w = 0.30000001192092896D;
            }
         } else {
            float var3 = 0.91F;
            if(this.C) {
               var3 = this.o.getData(new Location(MathHelper.c(this.s), MathHelper.c(this.aQ().b) - 1, MathHelper.c(this.u))).c().K * 0.91F;
            }

            float var4 = 0.16277136F / (var3 * var3 * var3);
            if(this.C) {
               var5 = this.bH() * var4;
            } else {
               var5 = this.aK;
            }

            this.a(var1, var2, var5);
            var3 = 0.91F;
            if(this.C) {
               var3 = this.o.getData(new Location(MathHelper.c(this.s), MathHelper.c(this.aQ().b) - 1, MathHelper.c(this.u))).c().K * 0.91F;
            }

            if(this.j_()) {
               var6 = 0.15F;
               this.v = MathHelper.a(this.v, (double)(-var6), (double)var6);
               this.x = MathHelper.a(this.x, (double)(-var6), (double)var6);
               this.O = 0.0F;
               if(this.w < -0.15D) {
                  this.w = -0.15D;
               }

               boolean var7 = this.aw() && this instanceof EntityHuman;
               if(var7 && this.w < 0.0D) {
                  this.w = 0.0D;
               }
            }

            this.d(this.v, this.w, this.x);
            if(this.D && this.j_()) {
               this.w = 0.2D;
            }

            if(this.o.D && (!this.o.e(new Location((int)this.s, 0, (int)this.u)) || !this.o.f(new Location((int)this.s, 0, (int)this.u)).o())) {
               if(this.t > 0.0D) {
                  this.w = -0.1D;
               } else {
                  this.w = 0.0D;
               }
            } else {
               this.w -= 0.08D;
            }

            this.w *= 0.9800000190734863D;
            this.v *= (double)var3;
            this.x *= (double)var3;
         }
      }

      this.ay = this.az;
      var8 = this.s - this.p;
      double var10 = this.u - this.r;
      var9 = MathHelper.sqrt(var8 * var8 + var10 * var10) * 4.0F;
      if(var9 > 1.0F) {
         var9 = 1.0F;
      }

      this.az += (var9 - this.az) * 0.4F;
      this.aA += this.az;
   }

   public float bH() {
      return this.bk;
   }

   public void j(float var1) {
      this.bk = var1;
   }

   public boolean r(Entity var1) {
      this.p(var1);
      return false;
   }

   public boolean bI() {
      return false;
   }

   public void s_() throws IOException {
      super.s_();
      if(!this.o.D) {
         int var1 = this.bu();
         if(var1 > 0) {
            if(this.ar <= 0) {
               this.ar = 20 * (30 - var1);
            }

            --this.ar;
            if(this.ar <= 0) {
               this.o(var1 - 1);
            }
         }

         for(int var2 = 0; var2 < 5; ++var2) {
            ItemStack var3 = this.h[var2];
            ItemStack var4 = this.p(var2);
            if(!ItemStack.b(var4, var3)) {
               ((WorldServer)this.o).s().a((Entity)this, (Packet)(new la(this.F(), var2, var4)));
               if(var3 != null) {
                  this.c.a(var3.B());
               }

               if(var4 != null) {
                  this.c.b(var4.B());
               }

               this.h[var2] = var4 == null?null:var4.k();
            }
         }

         if(this.W % 20 == 0) {
            this.br().g();
         }
      }

      this.m();
      double var9 = this.s - this.p;
      double var10 = this.u - this.r;
      float var5 = (float)(var9 * var9 + var10 * var10);
      float var6 = this.aG;
      float var7 = 0.0F;
      this.aP = this.aQ;
      float var8 = 0.0F;
      if(var5 > 0.0025000002F) {
         var8 = 1.0F;
         var7 = (float)Math.sqrt((double)var5) * 3.0F;
         var6 = (float)Math.atan2(var10, var9) * 180.0F / 3.1415927F - 90.0F;
      }

      if(this.ax > 0.0F) {
         var6 = this.y;
      }

      if(!this.C) {
         var8 = 0.0F;
      }

      this.aQ += (var8 - this.aQ) * 0.3F;
      this.o.B.a("headTurn");
      var7 = this.h(var6, var7);
      this.o.B.b();
      this.o.B.a("rangeChecks");

      while(this.y - this.A < -180.0F) {
         this.A -= 360.0F;
      }

      while(this.y - this.A >= 180.0F) {
         this.A += 360.0F;
      }

      while(this.aG - this.aH < -180.0F) {
         this.aH -= 360.0F;
      }

      while(this.aG - this.aH >= 180.0F) {
         this.aH += 360.0F;
      }

      while(this.z - this.B < -180.0F) {
         this.B -= 360.0F;
      }

      while(this.z - this.B >= 180.0F) {
         this.B += 360.0F;
      }

      while(this.aI - this.aJ < -180.0F) {
         this.aJ -= 360.0F;
      }

      while(this.aI - this.aJ >= 180.0F) {
         this.aJ += 360.0F;
      }

      this.o.B.b();
      this.aR += var7;
   }

   protected float h(float var1, float var2) {
      float var3 = MathHelper.g(var1 - this.aG);
      this.aG += var3 * 0.3F;
      float var4 = MathHelper.g(this.y - this.aG);
      boolean var5 = var4 < -90.0F || var4 >= 90.0F;
      if(var4 < -75.0F) {
         var4 = -75.0F;
      }

      if(var4 >= 75.0F) {
         var4 = 75.0F;
      }

      this.aG = this.y - var4;
      if(var4 * var4 > 2500.0F) {
         this.aG += var4 * 0.2F;
      }

      if(var5) {
         var2 *= -1.0F;
      }

      return var2;
   }

   public void m() throws IOException {
      if(this.bl > 0) {
         --this.bl;
      }

      if(this.ba > 0) {
         double var1 = this.s + (this.bb - this.s) / (double)this.ba;
         double var3 = this.t + (this.bc - this.t) / (double)this.ba;
         double var5 = this.u + (this.bd - this.u) / (double)this.ba;
         double var7 = MathHelper.g(this.be - (double)this.y);
         this.y = (float)((double)this.y + var7 / (double)this.ba);
         this.z = (float)((double)this.z + (this.bf - (double)this.z) / (double)this.ba);
         --this.ba;
         this.b(var1, var3, var5);
         this.b(this.y, this.z);
      } else if(!this.bL()) {
         this.v *= 0.98D;
         this.w *= 0.98D;
         this.x *= 0.98D;
      }

      if(Math.abs(this.v) < 0.005D) {
         this.v = 0.0D;
      }

      if(Math.abs(this.w) < 0.005D) {
         this.w = 0.0D;
      }

      if(Math.abs(this.x) < 0.005D) {
         this.x = 0.0D;
      }

      this.o.B.a("ai");
      if(this.bC()) {
         this.aW = false;
         this.aX = 0.0F;
         this.aY = 0.0F;
         this.aZ = 0.0F;
      } else if(this.bL()) {
         this.o.B.a("newAi");
         this.bJ();
         this.o.B.b();
      }

      this.o.B.b();
      this.o.B.a("jump");
      if(this.aW) {
         if(this.V()) {
            this.bF();
         } else if(this.ab()) {
            this.bG();
         } else if(this.C && this.bl == 0) {
            this.bE();
            this.bl = 10;
         }
      } else {
         this.bl = 0;
      }

      this.o.B.b();
      this.o.B.a("travel");
      this.aX *= 0.98F;
      this.aY *= 0.98F;
      this.aZ *= 0.9F;
      this.g(this.aX, this.aY);
      this.o.B.b();
      this.o.B.a("push");
      if(!this.o.D) {
         this.bK();
      }

      this.o.B.b();
   }

   protected void bJ() {}

   protected void bK() {
      List var1 = this.o.b((Entity)this, this.aQ().b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
      if(var1 != null && !var1.isEmpty()) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            Entity var3 = (Entity)var1.get(var2);
            if(var3.ae()) {
               this.s(var3);
            }
         }
      }

   }

   protected void s(Entity var1) {
      var1.i(this);
   }

   public void a(Entity var1) {
      if(this.m != null && var1 == null) {
         if(!this.o.D) {
            this.q(this.m);
         }

         if(this.m != null) {
            this.m.l = null;
         }

         this.m = null;
      } else {
         super.a(var1);
      }
   }

   public void ak() throws IOException {
      super.ak();
      this.aP = this.aQ;
      this.aQ = 0.0F;
      this.O = 0.0F;
   }

   public void i(boolean var1) {
      this.aW = var1;
   }

   public void a(Entity var1, int var2) {
      if(!var1.I && !this.o.D) {
         EntityTracker var3 = ((WorldServer)this.o).s();
         if(var1 instanceof EntityItem) {
            var3.a(var1, (Packet)(new ln(var1.F(), this.F())));
         }

         if(var1 instanceof EntityArrow) {
            var3.a(var1, (Packet)(new ln(var1.F(), this.F())));
         }

         if(var1 instanceof EntityExperienceOrb) {
            var3.a(var1, (Packet)(new ln(var1.F(), this.F())));
         }
      }

   }

   public boolean t(Entity var1) {
      return this.o.a(new Vec3D(this.s, this.t + (double)this.aR(), this.u), new Vec3D(var1.s, var1.t + (double)var1.aR(), var1.u)) == null;
   }

   public Vec3D ap() {
      return this.d(1.0F);
   }

   public Vec3D d(float var1) {
      if(var1 == 1.0F) {
         return this.f(this.z, this.aI);
      } else {
         float var2 = this.B + (this.z - this.B) * var1;
         float var3 = this.aJ + (this.aI - this.aJ) * var1;
         return this.f(var2, var3);
      }
   }

   public boolean bL() {
      return !this.o.D;
   }

   public boolean ad() {
      return !this.I;
   }

   public boolean ae() {
      return !this.I;
   }

   protected void ac() {
      this.G = this.V.nextDouble() >= this.getAttributeInstance(GenericAttributes.c).getValue();
   }

   public float aD() {
      return this.aI;
   }

   public void f(float var1) {
      this.aI = var1;
   }

   public float bM() {
      return this.bm;
   }

   public void l(float var1) {
      if(var1 < 0.0F) {
         var1 = 0.0F;
      }

      this.bm = var1;
   }

   public ScoreboardTeamBase bN() {
      return this.o.Z().getPlayerTeam(this.aJ().toString());
   }

   public boolean c(EntityLiving var1) {
      return this.a(var1.bN());
   }

   public boolean a(ScoreboardTeamBase var1) {
      return this.bN() != null?this.bN().a(var1):false;
   }

   public void g_() {}

   public void j() {}

   protected void bO() {
      this.i = true;
   }

}
