package net.minecraft.server;
import java.io.IOException;
import java.util.Calendar;

public class EntitySkeleton extends EntityMonster implements IRangedEntity {

   private PathfinderGoalArrowAttack b = new PathfinderGoalArrowAttack(this, 1.0D, 20, 60, 15.0F);
   private PathfinderGoalMeleeAttack c = new PathfinderGoalMeleeAttack(this, EntityHuman.class, 1.2D, false);


   public EntitySkeleton(World var1) {
      super(var1);
      this.goalSelector.a(1, new yy(this));
      this.goalSelector.a(2, new aab(this));
      this.goalSelector.a(2, this.a);
      this.goalSelector.a(3, new yx(this, 1.0D));
      this.goalSelector.a(3, new yp(this, new afx(this), 6.0F, 1.0D, 1.2D));
      this.goalSelector.a(4, new PathfinderGoalRandomStroll(this, 1.0D));
      this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(6, new PathfinderGoalRandomLookaround(this));
      this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, false, new Class[0]));
      this.targetSelector.a(2, new aaq(this, EntityHuman.class, true));
      this.targetSelector.a(3, new aaq(this, EntityIronGolem.class, true));
      if(var1 != null && !var1.isStatic) {
         this.n();
      }

   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.d).a(0.25D);
   }

   protected void h() {
      super.h();
      this.ac.a(13, new Byte((byte)0));
   }

   protected String z() {
      return "mob.skeleton.say";
   }

   protected String bn() {
      return "mob.skeleton.hurt";
   }

   protected String bo() {
      return "mob.skeleton.death";
   }

   protected void a(Location var1, Block var2) {
      this.a("mob.skeleton.step", 0.15F, 1.0F);
   }

   public boolean r(Entity var1) {
      if(super.r(var1)) {
         if(this.ck() == 1 && var1 instanceof EntityLiving) {
            ((EntityLiving)var1).c(new MobEffect(MobEffectList.v.H, 200));
         }

         return true;
      } else {
         return false;
      }
   }

   public xs by() {
      return xs.b;
   }

   public void m() throws IOException {
      if(this.o.w() && !this.o.isStatic) {
         float var1 = this.c(1.0F);
         Location var2 = new Location(this.s, (double)Math.round(this.t), this.u);
         if(var1 > 0.5F && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.o.i(var2)) {
            boolean var3 = true;
            ItemStack var4 = this.p(4);
            if(var4 != null) {
               if(var4.e()) {
                  var4.b(var4.h() + this.V.nextInt(2));
                  if(var4.h() >= var4.j()) {
                     this.b(var4);
                     this.c(4, (ItemStack)null);
                  }
               }

               var3 = false;
            }

            if(var3) {
               this.e(8);
            }
         }
      }

      if(this.o.isStatic && this.ck() == 1) {
         this.a(0.72F, 2.535F);
      }

      super.m();
   }

   public void ak() throws IOException {
      super.ak();
      if(this.m instanceof EntityCreature) {
         EntityCreature var1 = (EntityCreature)this.m;
         this.aG = var1.aG;
      }

   }

   public void a(DamageSource var1) {
      super.a(var1);
      if(var1.i() instanceof EntityArrow && var1.getEntity() instanceof EntityHuman) {
         EntityHuman var2 = (EntityHuman)var1.getEntity();
         double var3 = var2.s - this.s;
         double var5 = var2.u - this.u;
         if(var3 * var3 + var5 * var5 >= 2500.0D) {
            var2.b((Statistic)AchievementList.v);
         }
      } else if(var1.getEntity() instanceof EntityCreeper && ((EntityCreeper)var1.getEntity()).n() && ((EntityCreeper)var1.getEntity()).cn()) {
         ((EntityCreeper)var1.getEntity()).co();
         this.a(new ItemStack(Items.bX, 1, this.ck() == 1?1:0), 0.0F);
      }

   }

   protected Item A() {
      return Items.g;
   }

   protected void b(boolean var1, int var2) {
      int var3;
      int var4;
      if(this.ck() == 1) {
         var3 = this.V.nextInt(3 + var2) - 1;

         for(var4 = 0; var4 < var3; ++var4) {
            this.a(Items.h, 1);
         }
      } else {
         var3 = this.V.nextInt(3 + var2);

         for(var4 = 0; var4 < var3; ++var4) {
            this.a(Items.g, 1);
         }
      }

      var3 = this.V.nextInt(3 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(Items.aX, 1);
      }

   }

   protected void bp() {
      if(this.ck() == 1) {
         this.a(new ItemStack(Items.bX, 1, 1), 0.0F);
      }

   }

   protected void a(vu var1) {
      super.a(var1);
      this.c(0, new ItemStack(Items.BOW));
   }

   public xq a(vu var1, xq var2) {
      var2 = super.a(var1, var2);
      if(this.o.worldProvider instanceof bge && this.bb().nextInt(5) > 0) {
         this.goalSelector.a(4, this.c);
         this.a(1);
         this.c(0, new ItemStack(Items.q));
         this.getAttributeInstance(GenericAttributes.e).a(4.0D);
      } else {
         this.goalSelector.a(4, this.b);
         this.a(var1);
         this.b(var1);
      }

      this.j(this.V.nextFloat() < 0.55F * var1.c());
      if(this.p(4) == null) {
         Calendar var3 = this.o.Y();
         if(var3.get(2) + 1 == 10 && var3.get(5) == 31 && this.V.nextFloat() < 0.25F) {
            this.c(4, new ItemStack(this.V.nextFloat() < 0.1F?Blocks.JACK_O_LANTERN:Blocks.PUMPKIN));
            this.bh[4] = 0.0F;
         }
      }

      return var2;
   }

   public void n() {
      this.goalSelector.a((PathfinderGoal)this.c);
      this.goalSelector.a((PathfinderGoal)this.b);
      ItemStack var1 = this.bz();
      if(var1 != null && var1.b() == Items.BOW) {
         this.goalSelector.a(4, this.b);
      } else {
         this.goalSelector.a(4, this.c);
      }

   }

   public void a(EntityLiving var1, float var2) {
      EntityArrow var3 = new EntityArrow(this.o, this, var1, 1.6F, (float)(14 - this.o.aa().a() * 4));
      int var4 = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_DAMAGE.B, this.bz());
      int var5 = EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK.B, this.bz());
      var3.b((double)(var2 * 2.0F) + this.V.nextGaussian() * 0.25D + (double)((float)this.o.aa().a() * 0.11F));
      if(var4 > 0) {
         var3.b(var3.j() + (double)var4 * 0.5D + 0.5D);
      }

      if(var5 > 0) {
         var3.a(var5);
      }

      if(EnchantmentManager.getEnchantmentLevel(Enchantment.ARROW_FIRE.B, this.bz()) > 0 || this.ck() == 1) {
         var3.e(100);
      }

      this.a("random.bow", 1.0F, 1.0F / (this.bb().nextFloat() * 0.4F + 0.8F));
      this.o.addEntity((Entity)var3);
   }

   public int ck() {
      return this.ac.a(13);
   }

   public void a(int var1) {
      this.ac.b(13, Byte.valueOf((byte)var1));
      this.ab = var1 == 1;
      if(var1 == 1) {
         this.a(0.72F, 2.535F);
      } else {
         this.a(0.6F, 1.95F);
      }

   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasKeyOfType("SkeletonType", 99)) {
         byte var2 = var1.getByte("SkeletonType");
         this.a(var2);
      }

      this.n();
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setByte("SkeletonType", (byte)this.ck());
   }

   public void c(int var1, ItemStack var2) {
      super.c(var1, var2);
      if(!this.o.isStatic && var1 == 0) {
         this.n();
      }

   }

   public float aR() {
      return this.ck() == 1?super.aR():1.74F;
   }

   public double am() {
      return super.am() - 0.5D;
   }
}
