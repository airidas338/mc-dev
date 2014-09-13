package net.minecraft.server;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class EntityZombie extends EntityMonster {

   protected static final IAttribute b = (new AttributeRanged((IAttribute)null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).a("Spawn Reinforcements Chance");
   private static final UUID c = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
   private static final AttributeModifier bk = new AttributeModifier(c, "Baby speed boost", 0.5D, 1);
   private final ys bl = new ys(this);
   private int bm;
   private boolean bn = false;
   private float bo = -1.0F;
   private float bp;


   public EntityZombie(World var1) {
      super(var1);
      ((aay)this.getNavigation()).b(true);
      this.goalSelector.a(0, new yy(this));
      this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, EntityHuman.class, 1.0D, false));
      this.goalSelector.a(2, this.a);
      this.goalSelector.a(5, new PathfinderGoalMoveTowardsRestriction(this, 1.0D));
      this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
      this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
      this.n();
      this.a(0.6F, 1.95F);
   }

   protected void n() {
      this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, EntityVillager.class, 1.0D, true));
      this.goalSelector.a(4, new PathfinderGoalMeleeAttack(this, EntityIronGolem.class, 1.0D, true));
      this.goalSelector.a(6, new PathfinderGoalMoveThroughVillage(this, 1.0D, false));
      this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, true, new Class[]{EntityPigZombie.class}));
      this.targetSelector.a(2, new aaq(this, EntityHuman.class, true));
      this.targetSelector.a(2, new aaq(this, EntityVillager.class, false));
      this.targetSelector.a(2, new aaq(this, EntityIronGolem.class, true));
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.b).a(35.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.23000000417232513D);
      this.getAttributeInstance(GenericAttributes.e).a(3.0D);
      this.getAttributeMap().load(b).a(this.V.nextDouble() * 0.10000000149011612D);
   }

   protected void h() {
      super.h();
      this.H().a(12, Byte.valueOf((byte)0));
      this.H().a(13, Byte.valueOf((byte)0));
      this.H().a(14, Byte.valueOf((byte)0));
   }

   public int bq() {
      int var1 = super.bq() + 2;
      if(var1 > 20) {
         var1 = 20;
      }

      return var1;
   }

   public boolean cl() {
      return this.bn;
   }

   public void a(boolean var1) {
      if(this.bn != var1) {
         this.bn = var1;
         if(var1) {
            this.goalSelector.a(1, this.bl);
         } else {
            this.goalSelector.a((PathfinderGoal)this.bl);
         }
      }

   }

   public boolean i_() {
      return this.H().a(12) == 1;
   }

   protected int b(EntityHuman var1) {
      if(this.i_()) {
         this.b_ = (int)((float)this.b_ * 2.5F);
      }

      return super.b(var1);
   }

   public void l(boolean var1) {
      this.H().b(12, Byte.valueOf((byte)(var1?1:0)));
      if(this.o != null && !this.o.D) {
         AttributeInstance var2 = this.getAttributeInstance(GenericAttributes.d);
         var2.c(bk);
         if(var1) {
            var2.b(bk);
         }
      }

      this.n(var1);
   }

   public boolean cm() {
      return this.H().a(13) == 1;
   }

   public void m(boolean var1) {
      this.H().b(13, Byte.valueOf((byte)(var1?1:0)));
   }

   public void m() throws IOException {
      if(this.o.w() && !this.o.D && !this.i_()) {
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

      if(this.av() && this.u() != null && this.m instanceof EntityChicken) {
         ((EntityInsentient)this.m).getNavigation().a(this.getNavigation().j(), 1.5D);
      }

      super.m();
   }

   public boolean a(DamageSource var1, float var2) {
      if(super.a(var1, var2)) {
         EntityLiving var3 = this.u();
         if(var3 == null && var1.getEntity() instanceof EntityLiving) {
            var3 = (EntityLiving)var1.getEntity();
         }

         if(var3 != null && this.o.aa() == EnumDifficulty.HARD && (double)this.V.nextFloat() < this.getAttributeInstance(b).getValue()) {
            int var4 = MathHelper.c(this.s);
            int var5 = MathHelper.c(this.t);
            int var6 = MathHelper.c(this.u);
            EntityZombie var7 = new EntityZombie(this.o);

            for(int var8 = 0; var8 < 50; ++var8) {
               int var9 = var4 + MathHelper.a(this.V, 7, 40) * MathHelper.a(this.V, -1, 1);
               int var10 = var5 + MathHelper.a(this.V, 7, 40) * MathHelper.a(this.V, -1, 1);
               int var11 = var6 + MathHelper.a(this.V, 7, 40) * MathHelper.a(this.V, -1, 1);
               if(World.a((IBlockAccess)this.o, new Location(var9, var10 - 1, var11)) && this.o.l(new Location(var9, var10, var11)) < 10) {
                  var7.b((double)var9, (double)var10, (double)var11);
                  if(!this.o.b((double)var9, (double)var10, (double)var11, 7.0D) && this.o.a(var7.aQ(), (Entity)var7) && this.o.a((Entity)var7, var7.aQ()).isEmpty() && !this.o.d(var7.aQ())) {
                     this.o.d((Entity)var7);
                     var7.d(var3);
                     var7.a(this.o.E(new Location(var7)), (xq)null);
                     this.getAttributeInstance(b).b(new AttributeModifier("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
                     var7.getAttributeInstance(b).b(new AttributeModifier("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
                     break;
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public void s_() throws IOException {
      if(!this.o.D && this.cn()) {
         int var1 = this.cp();
         this.bm -= var1;
         if(this.bm <= 0) {
            this.co();
         }
      }

      super.s_();
   }

   public boolean r(Entity var1) {
      boolean var2 = super.r(var1);
      if(var2) {
         int var3 = this.o.aa().a();
         if(this.bz() == null && this.au() && this.V.nextFloat() < (float)var3 * 0.3F) {
            var1.e(2 * var3);
         }
      }

      return var2;
   }

   protected String z() {
      return "mob.zombie.say";
   }

   protected String bn() {
      return "mob.zombie.hurt";
   }

   protected String bo() {
      return "mob.zombie.death";
   }

   protected void a(Location var1, Block var2) {
      this.a("mob.zombie.step", 0.15F, 1.0F);
   }

   protected Item A() {
      return Items.bt;
   }

   public xs by() {
      return xs.b;
   }

   protected void bp() {
      switch(this.V.nextInt(3)) {
      case 0:
         this.a(Items.j, 1);
         break;
      case 1:
         this.a(Items.bR, 1);
         break;
      case 2:
         this.a(Items.bS, 1);
      }

   }

   protected void a(vu var1) {
      super.a(var1);
      if(this.V.nextFloat() < (this.o.aa() == EnumDifficulty.HARD?0.05F:0.01F)) {
         int var2 = this.V.nextInt(3);
         if(var2 == 0) {
            this.c(0, new ItemStack(Items.l));
         } else {
            this.c(0, new ItemStack(Items.a));
         }
      }

   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      if(this.i_()) {
         var1.setBoolean("IsBaby", true);
      }

      if(this.cm()) {
         var1.setBoolean("IsVillager", true);
      }

      var1.setInt("ConversionTime", this.cn()?this.bm:-1);
      var1.setBoolean("CanBreakDoors", this.cl());
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.getBoolean("IsBaby")) {
         this.l(true);
      }

      if(var1.getBoolean("IsVillager")) {
         this.m(true);
      }

      if(var1.hasKeyOfType("ConversionTime", 99) && var1.getInt("ConversionTime") > -1) {
         this.a(var1.getInt("ConversionTime"));
      }

      this.a(var1.getBoolean("CanBreakDoors"));
   }

   public void a(EntityLiving var1) {
      super.a(var1);
      if((this.o.aa() == EnumDifficulty.NORMAL || this.o.aa() == EnumDifficulty.HARD) && var1 instanceof EntityVillager) {
         if(this.o.aa() != EnumDifficulty.HARD && this.V.nextBoolean()) {
            return;
         }

         EntityZombie var2 = new EntityZombie(this.o);
         var2.m(var1);
         this.o.e((Entity)var1);
         var2.a(this.o.E(new Location(var2)), (xq)null);
         var2.m(true);
         if(var1.i_()) {
            var2.l(true);
         }

         this.o.d((Entity)var2);
         this.o.a((EntityHuman)null, 1016, new Location((int)this.s, (int)this.t, (int)this.u), 0);
      }

   }

   public float aR() {
      float var1 = 1.74F;
      if(this.i_()) {
         var1 = (float)((double)var1 - 0.81D);
      }

      return var1;
   }

   protected boolean a(ItemStack var1) {
      return var1.b() == Items.aP && this.i_() && this.av()?false:super.a(var1);
   }

   public xq a(vu var1, xq var2) {
      Object var7 = super.a(var1, var2);
      float var3 = var1.c();
      this.j(this.V.nextFloat() < 0.55F * var3);
      if(var7 == null) {
         var7 = new agl(this, this.o.s.nextFloat() < 0.05F, this.o.s.nextFloat() < 0.05F, (agk)null);
      }

      if(var7 instanceof agl) {
         agl var4 = (agl)var7;
         if(var4.b) {
            this.m(true);
         }

         if(var4.a) {
            this.l(true);
            if((double)this.o.s.nextFloat() < 0.05D) {
               List var5 = this.o.a(EntityChicken.class, this.aQ().b(5.0D, 3.0D, 5.0D), EntitySelectors.b);
               if(!var5.isEmpty()) {
                  EntityChicken var6 = (EntityChicken)var5.get(0);
                  var6.l(true);
                  this.a((Entity)var6);
               }
            } else if((double)this.o.s.nextFloat() < 0.05D) {
               EntityChicken var10 = new EntityChicken(this.o);
               var10.setPositionRotation(this.s, this.t, this.u, this.y, 0.0F);
               var10.a(var1, (xq)null);
               var10.l(true);
               this.o.d((Entity)var10);
               this.a((Entity)var10);
            }
         }
      }

      this.a(this.V.nextFloat() < var3 * 0.1F);
      this.a(var1);
      this.b(var1);
      if(this.p(4) == null) {
         Calendar var8 = this.o.Y();
         if(var8.get(2) + 1 == 10 && var8.get(5) == 31 && this.V.nextFloat() < 0.25F) {
            this.c(4, new ItemStack(this.V.nextFloat() < 0.1F?Blocks.JACK_O_LANTERN:Blocks.PUMPKIN));
            this.bh[4] = 0.0F;
         }
      }

      this.getAttributeInstance(GenericAttributes.c).b(new AttributeModifier("Random spawn bonus", this.V.nextDouble() * 0.05000000074505806D, 0));
      double var9 = this.V.nextDouble() * 1.5D * (double)var3;
      if(var9 > 1.0D) {
         this.getAttributeInstance(GenericAttributes.b).b(new AttributeModifier("Random zombie-spawn bonus", var9, 2));
      }

      if(this.V.nextFloat() < var3 * 0.05F) {
         this.getAttributeInstance(b).b(new AttributeModifier("Leader zombie bonus", this.V.nextDouble() * 0.25D + 0.5D, 0));
         this.getAttributeInstance(GenericAttributes.a).b(new AttributeModifier("Leader zombie bonus", this.V.nextDouble() * 3.0D + 1.0D, 2));
         this.a(true);
      }

      return (xq)var7;
   }

   public boolean a(EntityHuman var1) {
      ItemStack var2 = var1.bY();
      if(var2 != null && var2.b() == Items.ao && var2.i() == 0 && this.cm() && this.a(MobEffectList.t)) {
         if(!var1.by.d) {
            --var2.b;
         }

         if(var2.b <= 0) {
            var1.bg.a(var1.bg.c, (ItemStack)null);
         }

         if(!this.o.D) {
            this.a(this.V.nextInt(2401) + 3600);
         }

         return true;
      } else {
         return false;
      }
   }

   protected void a(int var1) {
      this.bm = var1;
      this.H().b(14, Byte.valueOf((byte)1));
      this.m(MobEffectList.t.H);
      this.c(new MobEffect(MobEffectList.g.H, var1, Math.min(this.o.aa().a() - 1, 0)));
      this.o.a((Entity)this, (byte)16);
   }

   protected boolean C() {
      return !this.cn();
   }

   public boolean cn() {
      return this.H().a(14) == 1;
   }

   protected void co() {
      EntityVillager var1 = new EntityVillager(this.o);
      var1.m(this);
      var1.a(this.o.E(new Location(var1)), (xq)null);
      var1.cn();
      if(this.i_()) {
         var1.b(-24000);
      }

      this.o.e((Entity)this);
      this.o.d((Entity)var1);
      var1.c(new MobEffect(MobEffectList.k.H, 200, 0));
      this.o.a((EntityHuman)null, 1017, new Location((int)this.s, (int)this.t, (int)this.u), 0);
   }

   protected int cp() {
      int var1 = 1;
      if(this.V.nextFloat() < 0.01F) {
         int var2 = 0;

         for(int var3 = (int)this.s - 4; var3 < (int)this.s + 4 && var2 < 14; ++var3) {
            for(int var4 = (int)this.t - 4; var4 < (int)this.t + 4 && var2 < 14; ++var4) {
               for(int var5 = (int)this.u - 4; var5 < (int)this.u + 4 && var2 < 14; ++var5) {
                  Block var6 = this.o.getData(new Location(var3, var4, var5)).c();
                  if(var6 == Blocks.IRON_FENCE || var6 == Blocks.BED) {
                     if(this.V.nextFloat() < 0.3F) {
                        ++var1;
                     }

                     ++var2;
                  }
               }
            }
         }
      }

      return var1;
   }

   public void n(boolean var1) {
      this.a(var1?0.5F:1.0F);
   }

   protected final void a(float var1, float var2) {
      boolean var3 = this.bo > 0.0F && this.bp > 0.0F;
      this.bo = var1;
      this.bp = var2;
      if(!var3) {
         this.a(1.0F);
      }

   }

   protected final void a(float var1) {
      super.a(this.bo * var1, this.bp * var1);
   }

   public double am() {
      return super.am() - 0.5D;
   }

   public void a(DamageSource var1) {
      super.a(var1);
      if(var1.getEntity() instanceof EntityCreeper && !(this instanceof EntityPigZombie) && ((EntityCreeper)var1.getEntity()).n() && ((EntityCreeper)var1.getEntity()).cn()) {
         ((EntityCreeper)var1.getEntity()).co();
         this.a(new ItemStack(Items.bX, 1, 2), 0.0F);
      }

   }

}
