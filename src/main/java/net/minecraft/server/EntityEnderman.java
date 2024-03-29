package net.minecraft.server;
import com.google.common.collect.Sets;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public class EntityEnderman extends EntityMonster {

   private static final UUID b = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");
   private static final AttributeModifier c = (new AttributeModifier(b, "Attacking speed boost", 0.15000000596046448D, 0)).a(false);
   private static final Set bk = Sets.newIdentityHashSet();
   private boolean bl;


   public EntityEnderman(World var1) {
      super(var1);
      this.a(0.6F, 2.9F);
      this.S = 1.0F;
      this.goalSelector.a(0, new yy(this));
      this.goalSelector.a(2, new PathfinderGoalMeleeAttack(this, 1.0D, false));
      this.goalSelector.a(7, new PathfinderGoalRandomStroll(this, 1.0D));
      this.goalSelector.a(8, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(8, new PathfinderGoalRandomLookaround(this));
      this.goalSelector.a(10, new aet(this));
      this.goalSelector.a(11, new aev(this));
      this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, false, new Class[0]));
      this.targetSelector.a(2, new aeu(this));
      this.targetSelector.a(3, new aaq(this, EntityEndermite.class, 10, true, false, new aes(this)));
   }

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(40.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.30000001192092896D);
      this.getAttributeInstance(GenericAttributes.e).a(7.0D);
      this.getAttributeInstance(GenericAttributes.b).a(64.0D);
   }

   protected void h() {
      super.h();
      this.ac.a(16, new Short((short)0));
      this.ac.a(17, new Byte((byte)0));
      this.ac.a(18, new Byte((byte)0));
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      IBlockData var2 = this.ck();
      var1.setShort("carried", (short)Block.getId(var2.c()));
      var1.setShort("carriedData", (short)var2.c().c(var2));
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      IBlockData var2;
      if(var1.hasKeyOfType("carried", 8)) {
         var2 = Block.b(var1.getString("carried")).a(var1.getShort("carriedData") & '\uffff');
      } else {
         var2 = Block.getById(var1.getShort("carried")).a(var1.getShort("carriedData") & '\uffff');
      }

      this.a(var2);
   }

   private boolean c(EntityHuman var1) {
      ItemStack var2 = var1.bg.b[3];
      if(var2 != null && var2.getItem() == Item.getItemOf(Blocks.PUMPKIN)) {
         return false;
      } else {
         Vec3D var3 = var1.d(1.0F).a();
         Vec3D var4 = new Vec3D(this.s - var1.s, this.aQ().b + (double)(this.K / 2.0F) - (var1.t + (double)var1.aR()), this.u - var1.u);
         double var5 = var4.b();
         var4 = var4.a();
         double var7 = var3.b(var4);
         return var7 > 1.0D - 0.025D / var5?var1.t(this):false;
      }
   }

   public float aR() {
      return 2.55F;
   }

   public void m() throws IOException {
      if(this.o.isStatic) {
         for(int var1 = 0; var1 < 2; ++var1) {
            this.o.a(EnumParticleEffect.y, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J, this.t + this.V.nextDouble() * (double)this.K - 0.25D, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J, (this.V.nextDouble() - 0.5D) * 2.0D, -this.V.nextDouble(), (this.V.nextDouble() - 0.5D) * 2.0D, new int[0]);
         }
      }

      this.aW = false;
      super.m();
   }

   protected void E() {
      if(this.U()) {
         this.a(DamageSource.DROWN, 1.0F);
      }

      if(this.cm() && !this.bl && this.V.nextInt(100) == 0) {
         this.a(false);
      }

      if(this.o.w()) {
         float var1 = this.c(1.0F);
         if(var1 > 0.5F && this.o.i(new Location(this)) && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
            this.d((EntityLiving)null);
            this.a(false);
            this.bl = false;
            this.n();
         }
      }

      super.E();
   }

   protected boolean n() {
      double var1 = this.s + (this.V.nextDouble() - 0.5D) * 64.0D;
      double var3 = this.t + (double)(this.V.nextInt(64) - 32);
      double var5 = this.u + (this.V.nextDouble() - 0.5D) * 64.0D;
      return this.k(var1, var3, var5);
   }

   protected boolean b(Entity var1) {
      Vec3D var2 = new Vec3D(this.s - var1.s, this.aQ().b + (double)(this.K / 2.0F) - var1.t + (double)var1.aR(), this.u - var1.u);
      var2 = var2.a();
      double var3 = 16.0D;
      double var5 = this.s + (this.V.nextDouble() - 0.5D) * 8.0D - var2.a * var3;
      double var7 = this.t + (double)(this.V.nextInt(16) - 8) - var2.b * var3;
      double var9 = this.u + (this.V.nextDouble() - 0.5D) * 8.0D - var2.c * var3;
      return this.k(var5, var7, var9);
   }

   protected boolean k(double var1, double var3, double var5) {
      double var7 = this.s;
      double var9 = this.t;
      double var11 = this.u;
      this.s = var1;
      this.t = var3;
      this.u = var5;
      boolean var13 = false;
      Location var14 = new Location(this.s, this.t, this.u);
      if(this.o.isLoaded(var14)) {
         boolean var15 = false;

         while(!var15 && var14.o() > 0) {
            Location var16 = var14.b();
            Block var17 = this.o.getData(var16).c();
            if(var17.getMaterial().isSolid()) {
               var15 = true;
            } else {
               --this.t;
               var14 = var16;
            }
         }

         if(var15) {
            super.a(this.s, this.t, this.u);
            if(this.o.getCubes((Entity)this, this.aQ()).isEmpty() && !this.o.containsLiquid(this.aQ())) {
               var13 = true;
            }
         }
      }

      if(!var13) {
         this.b(var7, var9, var11);
         return false;
      } else {
         short var29 = 128;

         for(int var28 = 0; var28 < var29; ++var28) {
            double var30 = (double)var28 / ((double)var29 - 1.0D);
            float var19 = (this.V.nextFloat() - 0.5F) * 0.2F;
            float var20 = (this.V.nextFloat() - 0.5F) * 0.2F;
            float var21 = (this.V.nextFloat() - 0.5F) * 0.2F;
            double var22 = var7 + (this.s - var7) * var30 + (this.V.nextDouble() - 0.5D) * (double)this.J * 2.0D;
            double var24 = var9 + (this.t - var9) * var30 + this.V.nextDouble() * (double)this.K;
            double var26 = var11 + (this.u - var11) * var30 + (this.V.nextDouble() - 0.5D) * (double)this.J * 2.0D;
            this.o.a(EnumParticleEffect.y, var22, var24, var26, (double)var19, (double)var20, (double)var21, new int[0]);
         }

         this.o.makeSound(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
         this.a("mob.endermen.portal", 1.0F, 1.0F);
         return true;
      }
   }

   protected String z() {
      return this.cm()?"mob.endermen.scream":"mob.endermen.idle";
   }

   protected String bn() {
      return "mob.endermen.hit";
   }

   protected String bo() {
      return "mob.endermen.death";
   }

   protected Item A() {
      return Items.bu;
   }

   protected void b(boolean var1, int var2) {
      Item var3 = this.A();
      if(var3 != null) {
         int var4 = this.V.nextInt(2 + var2);

         for(int var5 = 0; var5 < var4; ++var5) {
            this.a(var3, 1);
         }
      }

   }

   public void a(IBlockData var1) {
      this.ac.b(16, Short.valueOf((short)(Block.f(var1) & '\uffff')));
   }

   public IBlockData ck() {
      return Block.d(this.ac.b(16) & '\uffff');
   }

   public boolean a(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else {
         if(var1.getEntity() == null || !(var1.getEntity() instanceof EntityEndermite)) {
            if(!this.o.isStatic) {
               this.a(true);
            }

            if(var1 instanceof EntityDamageSource && var1.getEntity() instanceof EntityHuman) {
               if(var1.getEntity() instanceof EntityPlayer && ((EntityPlayer)var1.getEntity()).c.d()) {
                  this.a(false);
               } else {
                  this.bl = true;
               }
            }

            if(var1 instanceof EntityDamageSourceIndirect) {
               this.bl = false;

               for(int var4 = 0; var4 < 64; ++var4) {
                  if(this.n()) {
                     return true;
                  }
               }

               return false;
            }
         }

         boolean var3 = super.a(var1, var2);
         if(var1.e() && this.V.nextInt(10) != 0) {
            this.n();
         }

         return var3;
      }
   }

   public boolean cm() {
      return this.ac.a(18) > 0;
   }

   public void a(boolean var1) {
      this.ac.b(18, Byte.valueOf((byte)(var1?1:0)));
   }

   // $FF: synthetic method
   static AttributeModifier cn() {
      return c;
   }

   // $FF: synthetic method
   static boolean a(EntityEnderman var0, EntityHuman var1) {
      return var0.c(var1);
   }

   // $FF: synthetic method
   static boolean a(EntityEnderman var0, boolean var1) {
      return var0.bl = var1;
   }

   // $FF: synthetic method
   static Set co() {
      return bk;
   }

   static {
      bk.add(Blocks.GRASS);
      bk.add(Blocks.DIRT);
      bk.add(Blocks.SAND);
      bk.add(Blocks.GRAVEL);
      bk.add(Blocks.YELLOW_FLOWER);
      bk.add(Blocks.RED_ROSE);
      bk.add(Blocks.BROWN_MUSHROOM);
      bk.add(Blocks.RED_MUSHROOM);
      bk.add(Blocks.TNT);
      bk.add(Blocks.CACTUS);
      bk.add(Blocks.CLAY);
      bk.add(Blocks.PUMPKIN);
      bk.add(Blocks.MELON);
      bk.add(Blocks.MYCEL);
   }
}
