package net.minecraft.server;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class EntityWither extends EntityMonster implements IRangedEntity {

   private float[] b = new float[2];
   private float[] c = new float[2];
   private float[] bk = new float[2];
   private float[] bl = new float[2];
   private int[] bm = new int[2];
   private int[] bn = new int[2];
   private int bo;
   private static final Predicate bp = new adg();


   public EntityWither(World var1) {
      super(var1);
      this.h(this.bt());
      this.a(0.9F, 3.5F);
      this.ab = true;
      ((aay)this.getNavigation()).d(true);
      this.goalSelector.a(0, new yy(this));
      this.goalSelector.a(2, new PathfinderGoalArrowAttack(this, 1.0D, 40, 20.0F));
      this.goalSelector.a(5, new PathfinderGoalRandomStroll(this, 1.0D));
      this.goalSelector.a(6, new PathfinderGoalLookAtPlayer(this, EntityHuman.class, 8.0F));
      this.goalSelector.a(7, new PathfinderGoalRandomLookaround(this));
      this.targetSelector.a(1, new PathfinderGoalHurtByTarget(this, false, new Class[0]));
      this.targetSelector.a(2, new aaq(this, EntityInsentient.class, 0, false, false, bp));
      this.b_ = 50;
   }

   protected void h() {
      super.h();
      this.ac.a(17, new Integer(0));
      this.ac.a(18, new Integer(0));
      this.ac.a(19, new Integer(0));
      this.ac.a(20, new Integer(0));
   }

   public void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setInt("Invul", this.cj());
   }

   public void a(NBTTagCompound var1) {
      super.a(var1);
      this.r(var1.getInt("Invul"));
   }

   protected String z() {
      return "mob.wither.idle";
   }

   protected String bn() {
      return "mob.wither.hurt";
   }

   protected String bo() {
      return "mob.wither.death";
   }

   public void m() throws IOException {
      this.w *= 0.6000000238418579D;
      double var4;
      double var6;
      double var8;
      if(!this.o.isStatic && this.s(0) > 0) {
         Entity var1 = this.o.getEntity(this.s(0));
         if(var1 != null) {
            if(this.t < var1.t || !this.ck() && this.t < var1.t + 5.0D) {
               if(this.w < 0.0D) {
                  this.w = 0.0D;
               }

               this.w += (0.5D - this.w) * 0.6000000238418579D;
            }

            double var2 = var1.s - this.s;
            var4 = var1.u - this.u;
            var6 = var2 * var2 + var4 * var4;
            if(var6 > 9.0D) {
               var8 = (double)MathHelper.sqrt(var6);
               this.v += (var2 / var8 * 0.5D - this.v) * 0.6000000238418579D;
               this.x += (var4 / var8 * 0.5D - this.x) * 0.6000000238418579D;
            }
         }
      }

      if(this.v * this.v + this.x * this.x > 0.05000000074505806D) {
         this.y = (float)Math.atan2(this.x, this.v) * 57.295776F - 90.0F;
      }

      super.m();

      int var20;
      for(var20 = 0; var20 < 2; ++var20) {
         this.bl[var20] = this.c[var20];
         this.bk[var20] = this.b[var20];
      }

      int var21;
      for(var20 = 0; var20 < 2; ++var20) {
         var21 = this.s(var20 + 1);
         Entity var3 = null;
         if(var21 > 0) {
            var3 = this.o.getEntity(var21);
         }

         if(var3 != null) {
            var4 = this.t(var20 + 1);
            var6 = this.u(var20 + 1);
            var8 = this.v(var20 + 1);
            double var10 = var3.s - var4;
            double var12 = var3.t + (double)var3.aR() - var6;
            double var14 = var3.u - var8;
            double var16 = (double)MathHelper.sqrt(var10 * var10 + var14 * var14);
            float var18 = (float)(Math.atan2(var14, var10) * 180.0D / 3.1415927410125732D) - 90.0F;
            float var19 = (float)(-(Math.atan2(var12, var16) * 180.0D / 3.1415927410125732D));
            this.b[var20] = this.b(this.b[var20], var19, 40.0F);
            this.c[var20] = this.b(this.c[var20], var18, 10.0F);
         } else {
            this.c[var20] = this.b(this.c[var20], this.aG, 10.0F);
         }
      }

      boolean var22 = this.ck();

      for(var21 = 0; var21 < 3; ++var21) {
         double var23 = this.t(var21);
         double var5 = this.u(var21);
         double var7 = this.v(var21);
         this.o.a(EnumParticleEffect.l, var23 + this.V.nextGaussian() * 0.30000001192092896D, var5 + this.V.nextGaussian() * 0.30000001192092896D, var7 + this.V.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D, new int[0]);
         if(var22 && this.o.random.nextInt(4) == 0) {
            this.o.a(EnumParticleEffect.p, var23 + this.V.nextGaussian() * 0.30000001192092896D, var5 + this.V.nextGaussian() * 0.30000001192092896D, var7 + this.V.nextGaussian() * 0.30000001192092896D, 0.699999988079071D, 0.699999988079071D, 0.5D, new int[0]);
         }
      }

      if(this.cj() > 0) {
         for(var21 = 0; var21 < 3; ++var21) {
            this.o.a(EnumParticleEffect.p, this.s + this.V.nextGaussian() * 1.0D, this.t + (double)(this.V.nextFloat() * 3.3F), this.u + this.V.nextGaussian() * 1.0D, 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D, new int[0]);
         }
      }

   }

   protected void E() {
      int var1;
      if(this.cj() > 0) {
         var1 = this.cj() - 1;
         if(var1 <= 0) {
            this.o.createExplosion(this, this.s, this.t + (double)this.aR(), this.u, 7.0F, false, this.o.getGameRules().getBoolean("mobGriefing"));
            this.o.a(1013, new Location(this), 0);
         }

         this.r(var1);
         if(this.W % 10 == 0) {
            this.g(10.0F);
         }

      } else {
         super.E();

         int var12;
         for(var1 = 1; var1 < 3; ++var1) {
            if(this.W >= this.bm[var1 - 1]) {
               this.bm[var1 - 1] = this.W + 10 + this.V.nextInt(10);
               if(this.o.aa() == EnumDifficulty.NORMAL || this.o.aa() == EnumDifficulty.HARD) {
                  int var10001 = var1 - 1;
                  int var10003 = this.bn[var1 - 1];
                  this.bn[var10001] = this.bn[var1 - 1] + 1;
                  if(var10003 > 15) {
                     float var2 = 10.0F;
                     float var3 = 5.0F;
                     double var4 = MathHelper.a(this.V, this.s - (double)var2, this.s + (double)var2);
                     double var6 = MathHelper.a(this.V, this.t - (double)var3, this.t + (double)var3);
                     double var8 = MathHelper.a(this.V, this.u - (double)var2, this.u + (double)var2);
                     this.a(var1 + 1, var4, var6, var8, true);
                     this.bn[var1 - 1] = 0;
                  }
               }

               var12 = this.s(var1);
               if(var12 > 0) {
                  Entity var14 = this.o.getEntity(var12);
                  if(var14 != null && var14.isAlive() && this.h(var14) <= 900.0D && this.t(var14)) {
                     this.a(var1 + 1, (EntityLiving)var14);
                     this.bm[var1 - 1] = this.W + 40 + this.V.nextInt(20);
                     this.bn[var1 - 1] = 0;
                  } else {
                     this.b(var1, 0);
                  }
               } else {
                  List var13 = this.o.getEntities(EntityLiving.class, this.aQ().b(20.0D, 8.0D, 20.0D), Predicates.and(bp, EntitySelectors.d));

                  for(int var16 = 0; var16 < 10 && !var13.isEmpty(); ++var16) {
                     EntityLiving var5 = (EntityLiving)var13.get(this.V.nextInt(var13.size()));
                     if(var5 != this && var5.isAlive() && this.t(var5)) {
                        if(var5 instanceof EntityHuman) {
                           if(!((EntityHuman)var5).abilities.isInvulnerable) {
                              this.b(var1, var5.F());
                           }
                        } else {
                           this.b(var1, var5.F());
                        }
                        break;
                     }

                     var13.remove(var5);
                  }
               }
            }
         }

         if(this.u() != null) {
            this.b(0, this.u().F());
         } else {
            this.b(0, 0);
         }

         if(this.bo > 0) {
            --this.bo;
            if(this.bo == 0 && this.o.getGameRules().getBoolean("mobGriefing")) {
               var1 = MathHelper.floor(this.t);
               var12 = MathHelper.floor(this.s);
               int var15 = MathHelper.floor(this.u);
               boolean var18 = false;

               for(int var17 = -1; var17 <= 1; ++var17) {
                  for(int var19 = -1; var19 <= 1; ++var19) {
                     for(int var7 = 0; var7 <= 3; ++var7) {
                        int var20 = var12 + var17;
                        int var9 = var1 + var7;
                        int var10 = var15 + var19;
                        Block var11 = this.o.getData(new Location(var20, var9, var10)).c();
                        if(var11.getMaterial() != Material.AIR && var11 != Blocks.BEDROCK && var11 != Blocks.ENDER_PORTAL && var11 != Blocks.ENDER_PORTAL_FRAME && var11 != Blocks.COMMAND && var11 != Blocks.BARRIER) {
                           var18 = this.o.setAir(new Location(var20, var9, var10), true) || var18;
                        }
                     }
                  }
               }

               if(var18) {
                  this.o.a((EntityHuman)null, 1012, new Location(this), 0);
               }
            }
         }

         if(this.W % 20 == 0) {
            this.g(1.0F);
         }

      }
   }

   public void n() {
      this.r(220);
      this.h(this.bt() / 3.0F);
   }

   public void aB() {}

   public int bq() {
      return 4;
   }

   private double t(int var1) {
      if(var1 <= 0) {
         return this.s;
      } else {
         float var2 = (this.aG + (float)(180 * (var1 - 1))) / 180.0F * 3.1415927F;
         float var3 = MathHelper.cos(var2);
         return this.s + (double)var3 * 1.3D;
      }
   }

   private double u(int var1) {
      return var1 <= 0?this.t + 3.0D:this.t + 2.2D;
   }

   private double v(int var1) {
      if(var1 <= 0) {
         return this.u;
      } else {
         float var2 = (this.aG + (float)(180 * (var1 - 1))) / 180.0F * 3.1415927F;
         float var3 = MathHelper.sin(var2);
         return this.u + (double)var3 * 1.3D;
      }
   }

   private float b(float var1, float var2, float var3) {
      float var4 = MathHelper.g(var2 - var1);
      if(var4 > var3) {
         var4 = var3;
      }

      if(var4 < -var3) {
         var4 = -var3;
      }

      return var1 + var4;
   }

   private void a(int var1, EntityLiving var2) {
      this.a(var1, var2.s, var2.t + (double)var2.aR() * 0.5D, var2.u, var1 == 0 && this.V.nextFloat() < 0.001F);
   }

   private void a(int var1, double var2, double var4, double var6, boolean var8) {
      this.o.a((EntityHuman)null, 1014, new Location(this), 0);
      double var9 = this.t(var1);
      double var11 = this.u(var1);
      double var13 = this.v(var1);
      double var15 = var2 - var9;
      double var17 = var4 - var11;
      double var19 = var6 - var13;
      EntityWitherSkull var21 = new EntityWitherSkull(this.o, this, var15, var17, var19);
      if(var8) {
         var21.a(true);
      }

      var21.t = var11;
      var21.s = var9;
      var21.u = var13;
      this.o.addEntity((Entity)var21);
   }

   public void a(EntityLiving var1, float var2) {
      this.a(0, var1);
   }

   public boolean a(DamageSource var1, float var2) {
      if(this.b(var1)) {
         return false;
      } else if(var1 != DamageSource.DROWN && !(var1.getEntity() instanceof EntityWither)) {
         if(this.cj() > 0 && var1 != DamageSource.OUT_OF_WORLD) {
            return false;
         } else {
            Entity var3;
            if(this.ck()) {
               var3 = var1.i();
               if(var3 instanceof EntityArrow) {
                  return false;
               }
            }

            var3 = var1.getEntity();
            if(var3 != null && !(var3 instanceof EntityHuman) && var3 instanceof EntityLiving && ((EntityLiving)var3).by() == this.by()) {
               return false;
            } else {
               if(this.bo <= 0) {
                  this.bo = 20;
               }

               for(int var4 = 0; var4 < this.bn.length; ++var4) {
                  this.bn[var4] += 3;
               }

               return super.a(var1, var2);
            }
         }
      } else {
         return false;
      }
   }

   protected void b(boolean var1, int var2) {
      EntityItem var3 = this.a(Items.bZ, 1);
      if(var3 != null) {
         var3.u();
      }

      if(!this.o.isStatic) {
         Iterator var4 = this.o.getEntities(EntityHuman.class, this.aQ().b(50.0D, 100.0D, 50.0D)).iterator();

         while(var4.hasNext()) {
            EntityHuman var5 = (EntityHuman)var4.next();
            var5.b((Statistic)AchievementList.J);
         }
      }

   }

   protected void D() {
      this.aO = 0;
   }

   public void e(float var1, float var2) {}

   public void c(MobEffect var1) {}

   protected void aW() {
      super.aW();
      this.getAttributeInstance(GenericAttributes.a).a(300.0D);
      this.getAttributeInstance(GenericAttributes.d).a(0.6000000238418579D);
      this.getAttributeInstance(GenericAttributes.b).a(40.0D);
   }

   public int cj() {
      return this.ac.c(20);
   }

   public void r(int var1) {
      this.ac.b(20, Integer.valueOf(var1));
   }

   public int s(int var1) {
      return this.ac.c(17 + var1);
   }

   public void b(int var1, int var2) {
      this.ac.b(17 + var1, Integer.valueOf(var2));
   }

   public boolean ck() {
      return this.bm() <= this.bt() / 2.0F;
   }

   public xs by() {
      return xs.b;
   }

   public void a(Entity var1) {
      this.m = null;
   }

}
