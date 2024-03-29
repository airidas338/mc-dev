package net.minecraft.server;
import java.io.IOException;
import java.util.List;

public class EntityArrow extends Entity implements IProjectile {

   private int d = -1;
   private int e = -1;
   private int f = -1;
   private Block g;
   private int h;
   private boolean i;
   public int a;
   public int b;
   public Entity c;
   private int ap;
   private int aq;
   private double ar = 2.0D;
   private int as;


   public EntityArrow(World var1) {
      super(var1);
      this.j = 10.0D;
      this.a(0.5F, 0.5F);
   }

   public EntityArrow(World var1, double var2, double var4, double var6) {
      super(var1);
      this.j = 10.0D;
      this.a(0.5F, 0.5F);
      this.b(var2, var4, var6);
   }

   public EntityArrow(World var1, EntityLiving var2, EntityLiving var3, float var4, float var5) {
      super(var1);
      this.j = 10.0D;
      this.c = var2;
      if(var2 instanceof EntityHuman) {
         this.a = 1;
      }

      this.t = var2.t + (double)var2.aR() - 0.10000000149011612D;
      double var6 = var3.s - var2.s;
      double var8 = var3.aQ().b + (double)(var3.K / 3.0F) - this.t;
      double var10 = var3.u - var2.u;
      double var12 = (double)MathHelper.sqrt(var6 * var6 + var10 * var10);
      if(var12 >= 1.0E-7D) {
         float var14 = (float)(Math.atan2(var10, var6) * 180.0D / 3.1415927410125732D) - 90.0F;
         float var15 = (float)(-(Math.atan2(var8, var12) * 180.0D / 3.1415927410125732D));
         double var16 = var6 / var12;
         double var18 = var10 / var12;
         this.setPositionRotation(var2.s + var16, this.t, var2.u + var18, var14, var15);
         float var20 = (float)(var12 * 0.20000000298023224D);
         this.shoot(var6, var8 + (double)var20, var10, var4, var5);
      }
   }

   public EntityArrow(World var1, EntityLiving var2, float var3) {
      super(var1);
      this.j = 10.0D;
      this.c = var2;
      if(var2 instanceof EntityHuman) {
         this.a = 1;
      }

      this.a(0.5F, 0.5F);
      this.setPositionRotation(var2.s, var2.t + (double)var2.aR(), var2.u, var2.y, var2.z);
      this.s -= (double)(MathHelper.cos(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.t -= 0.10000000149011612D;
      this.u -= (double)(MathHelper.sin(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.b(this.s, this.t, this.u);
      this.v = (double)(-MathHelper.sin(this.y / 180.0F * 3.1415927F) * MathHelper.cos(this.z / 180.0F * 3.1415927F));
      this.x = (double)(MathHelper.cos(this.y / 180.0F * 3.1415927F) * MathHelper.cos(this.z / 180.0F * 3.1415927F));
      this.w = (double)(-MathHelper.sin(this.z / 180.0F * 3.1415927F));
      this.shoot(this.v, this.w, this.x, var3 * 1.5F, 1.0F);
   }

   protected void h() {
      this.ac.a(16, Byte.valueOf((byte)0));
   }

   public void shoot(double var1, double var3, double var5, float var7, float var8) {
      float var9 = MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5);
      var1 /= (double)var9;
      var3 /= (double)var9;
      var5 /= (double)var9;
      var1 += this.V.nextGaussian() * (double)(this.V.nextBoolean()?-1:1) * 0.007499999832361937D * (double)var8;
      var3 += this.V.nextGaussian() * (double)(this.V.nextBoolean()?-1:1) * 0.007499999832361937D * (double)var8;
      var5 += this.V.nextGaussian() * (double)(this.V.nextBoolean()?-1:1) * 0.007499999832361937D * (double)var8;
      var1 *= (double)var7;
      var3 *= (double)var7;
      var5 *= (double)var7;
      this.v = var1;
      this.w = var3;
      this.x = var5;
      float var10 = MathHelper.sqrt(var1 * var1 + var5 * var5);
      this.A = this.y = (float)(Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
      this.B = this.z = (float)(Math.atan2(var3, (double)var10) * 180.0D / 3.1415927410125732D);
      this.ap = 0;
   }

   public void s_() throws IOException {
      super.s_();
      if(this.B == 0.0F && this.A == 0.0F) {
         float var1 = MathHelper.sqrt(this.v * this.v + this.x * this.x);
         this.A = this.y = (float)(Math.atan2(this.v, this.x) * 180.0D / 3.1415927410125732D);
         this.B = this.z = (float)(Math.atan2(this.w, (double)var1) * 180.0D / 3.1415927410125732D);
      }

      Location var18 = new Location(this.d, this.e, this.f);
      IBlockData var2 = this.o.getData(var18);
      Block var3 = var2.c();
      if(var3.getMaterial() != Material.AIR) {
         var3.updateShape((IBlockAccess)this.o, var18);
         AxisAlignedBB var4 = var3.a(this.o, var18, var2);
         if(var4 != null && var4.a(new Vec3D(this.s, this.t, this.u))) {
            this.i = true;
         }
      }

      if(this.b > 0) {
         --this.b;
      }

      if(this.i) {
         int var20 = var3.c(var2);
         if(var3 == this.g && var20 == this.h) {
            ++this.ap;
            if(this.ap >= 1200) {
               this.J();
            }

         } else {
            this.i = false;
            this.v *= (double)(this.V.nextFloat() * 0.2F);
            this.w *= (double)(this.V.nextFloat() * 0.2F);
            this.x *= (double)(this.V.nextFloat() * 0.2F);
            this.ap = 0;
            this.aq = 0;
         }
      } else {
         ++this.aq;
         Vec3D var19 = new Vec3D(this.s, this.t, this.u);
         Vec3D var5 = new Vec3D(this.s + this.v, this.t + this.w, this.u + this.x);
         MovingObjectPosition var6 = this.o.rayTrace(var19, var5, false, true, false);
         var19 = new Vec3D(this.s, this.t, this.u);
         var5 = new Vec3D(this.s + this.v, this.t + this.w, this.u + this.x);
         if(var6 != null) {
            var5 = new Vec3D(var6.c.a, var6.c.b, var6.c.c);
         }

         Entity var7 = null;
         List var8 = this.o.b((Entity)this, this.aQ().a(this.v, this.w, this.x).b(1.0D, 1.0D, 1.0D));
         double var9 = 0.0D;

         int var11;
         float var13;
         for(var11 = 0; var11 < var8.size(); ++var11) {
            Entity var12 = (Entity)var8.get(var11);
            if(var12.ad() && (var12 != this.c || this.aq >= 5)) {
               var13 = 0.3F;
               AxisAlignedBB var14 = var12.aQ().b((double)var13, (double)var13, (double)var13);
               MovingObjectPosition var15 = var14.a(var19, var5);
               if(var15 != null) {
                  double var16 = var19.distanceSquared(var15.c);
                  if(var16 < var9 || var9 == 0.0D) {
                     var7 = var12;
                     var9 = var16;
                  }
               }
            }
         }

         if(var7 != null) {
            var6 = new MovingObjectPosition(var7);
         }

         if(var6 != null && var6.d != null && var6.d instanceof EntityHuman) {
            EntityHuman var23 = (EntityHuman)var6.d;
            if(var23.abilities.isInvulnerable || this.c instanceof EntityHuman && !((EntityHuman)this.c).a(var23)) {
               var6 = null;
            }
         }

         float var25;
         float var24;
         float var27;
         if(var6 != null) {
            if(var6.d != null) {
               var24 = MathHelper.sqrt(this.v * this.v + this.w * this.w + this.x * this.x);
               int var22 = MathHelper.f((double)var24 * this.ar);
               if(this.l()) {
                  var22 += this.V.nextInt(var22 / 2 + 2);
               }

               DamageSource var26;
               if(this.c == null) {
                  var26 = DamageSource.a(this, this);
               } else {
                  var26 = DamageSource.a(this, this.c);
               }

               if(this.au() && !(var6.d instanceof EntityEnderman)) {
                  var6.d.e(5);
               }

               if(var6.d.a(var26, (float)var22)) {
                  if(var6.d instanceof EntityLiving) {
                     EntityLiving var28 = (EntityLiving)var6.d;
                     if(!this.o.isStatic) {
                        var28.o(var28.bu() + 1);
                     }

                     if(this.as > 0) {
                        var27 = MathHelper.sqrt(this.v * this.v + this.x * this.x);
                        if(var27 > 0.0F) {
                           var6.d.g(this.v * (double)this.as * 0.6000000238418579D / (double)var27, 0.1D, this.x * (double)this.as * 0.6000000238418579D / (double)var27);
                        }
                     }

                     if(this.c instanceof EntityLiving) {
                        EnchantmentManager.a(var28, this.c);
                        EnchantmentManager.b((EntityLiving)this.c, var28);
                     }

                     if(this.c != null && var6.d != this.c && var6.d instanceof EntityHuman && this.c instanceof EntityPlayer) {
                        ((EntityPlayer)this.c).a.sendPacket((Packet)(new PacketPlayOutGameStateChange(6, 0.0F)));
                     }
                  }

                  this.a("random.bowhit", 1.0F, 1.2F / (this.V.nextFloat() * 0.2F + 0.9F));
                  if(!(var6.d instanceof EntityEnderman)) {
                     this.J();
                  }
               } else {
                  this.v *= -0.10000000149011612D;
                  this.w *= -0.10000000149011612D;
                  this.x *= -0.10000000149011612D;
                  this.y += 180.0F;
                  this.A += 180.0F;
                  this.aq = 0;
               }
            } else {
               Location var21 = var6.a();
               this.d = var21.n();
               this.e = var21.o();
               this.f = var21.p();
               var2 = this.o.getData(var21);
               this.g = var2.c();
               this.h = this.g.c(var2);
               this.v = (double)((float)(var6.c.a - this.s));
               this.w = (double)((float)(var6.c.b - this.t));
               this.x = (double)((float)(var6.c.c - this.u));
               var25 = MathHelper.sqrt(this.v * this.v + this.w * this.w + this.x * this.x);
               this.s -= this.v / (double)var25 * 0.05000000074505806D;
               this.t -= this.w / (double)var25 * 0.05000000074505806D;
               this.u -= this.x / (double)var25 * 0.05000000074505806D;
               this.a("random.bowhit", 1.0F, 1.2F / (this.V.nextFloat() * 0.2F + 0.9F));
               this.i = true;
               this.b = 7;
               this.a(false);
               if(this.g.getMaterial() != Material.AIR) {
                  this.g.a(this.o, var21, var2, (Entity)this);
               }
            }
         }

         if(this.l()) {
            for(var11 = 0; var11 < 4; ++var11) {
               this.o.a(EnumParticleEffect.j, this.s + this.v * (double)var11 / 4.0D, this.t + this.w * (double)var11 / 4.0D, this.u + this.x * (double)var11 / 4.0D, -this.v, -this.w + 0.2D, -this.x, new int[0]);
            }
         }

         this.s += this.v;
         this.t += this.w;
         this.u += this.x;
         var24 = MathHelper.sqrt(this.v * this.v + this.x * this.x);
         this.y = (float)(Math.atan2(this.v, this.x) * 180.0D / 3.1415927410125732D);

         for(this.z = (float)(Math.atan2(this.w, (double)var24) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
            ;
         }

         while(this.z - this.B >= 180.0F) {
            this.B += 360.0F;
         }

         while(this.y - this.A < -180.0F) {
            this.A -= 360.0F;
         }

         while(this.y - this.A >= 180.0F) {
            this.A += 360.0F;
         }

         this.z = this.B + (this.z - this.B) * 0.2F;
         this.y = this.A + (this.y - this.A) * 0.2F;
         var25 = 0.99F;
         var13 = 0.05F;
         if(this.V()) {
            for(int var29 = 0; var29 < 4; ++var29) {
               var27 = 0.25F;
               this.o.a(EnumParticleEffect.e, this.s - this.v * (double)var27, this.t - this.w * (double)var27, this.u - this.x * (double)var27, this.v, this.w, this.x, new int[0]);
            }

            var25 = 0.6F;
         }

         if(this.U()) {
            this.N();
         }

         this.v *= (double)var25;
         this.w *= (double)var25;
         this.x *= (double)var25;
         this.w -= (double)var13;
         this.b(this.s, this.t, this.u);
         this.Q();
      }
   }

   public void b(NBTTagCompound var1) {
      var1.setShort("xTile", (short)this.d);
      var1.setShort("yTile", (short)this.e);
      var1.setShort("zTile", (short)this.f);
      var1.setShort("life", (short)this.ap);
      RegistryPrepender var2 = (RegistryPrepender)Block.REGISTRY.c(this.g);
      var1.setString("inTile", var2 == null?"":var2.toString());
      var1.setByte("inData", (byte)this.h);
      var1.setByte("shake", (byte)this.b);
      var1.setByte("inGround", (byte)(this.i?1:0));
      var1.setByte("pickup", (byte)this.a);
      var1.setDouble("damage", this.ar);
   }

   public void a(NBTTagCompound var1) {
      this.d = var1.getShort("xTile");
      this.e = var1.getShort("yTile");
      this.f = var1.getShort("zTile");
      this.ap = var1.getShort("life");
      if(var1.hasKeyOfType("inTile", 8)) {
         this.g = Block.b(var1.getString("inTile"));
      } else {
         this.g = Block.getById(var1.getByte("inTile") & 255);
      }

      this.h = var1.getByte("inData") & 255;
      this.b = var1.getByte("shake") & 255;
      this.i = var1.getByte("inGround") == 1;
      if(var1.hasKeyOfType("damage", 99)) {
         this.ar = var1.getDouble("damage");
      }

      if(var1.hasKeyOfType("pickup", 99)) {
         this.a = var1.getByte("pickup");
      } else if(var1.hasKeyOfType("player", 99)) {
         this.a = var1.getBoolean("player")?1:0;
      }

   }

   public void d(EntityHuman var1) {
      if(!this.o.isStatic && this.i && this.b <= 0) {
         boolean var2 = this.a == 1 || this.a == 2 && var1.abilities.canInstantlyBuild;
         if(this.a == 1 && !var1.bg.a(new ItemStack(Items.ARROW, 1))) {
            var2 = false;
         }

         if(var2) {
            this.a("random.pop", 0.2F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            var1.a((Entity)this, 1);
            this.J();
         }

      }
   }

   protected boolean r_() {
      return false;
   }

   public void b(double var1) {
      this.ar = var1;
   }

   public double j() {
      return this.ar;
   }

   public void a(int var1) {
      this.as = var1;
   }

   public boolean aE() {
      return false;
   }

   public void a(boolean var1) {
      byte var2 = this.ac.a(16);
      if(var1) {
         this.ac.b(16, Byte.valueOf((byte)(var2 | 1)));
      } else {
         this.ac.b(16, Byte.valueOf((byte)(var2 & -2)));
      }

   }

   public boolean l() {
      byte var1 = this.ac.a(16);
      return (var1 & 1) != 0;
   }
}
