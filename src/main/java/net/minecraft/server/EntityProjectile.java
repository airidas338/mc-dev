package net.minecraft.server;
import java.io.IOException;
import java.util.List;

public abstract class EntityProjectile extends Entity implements IProjectile {

   private int c = -1;
   private int d = -1;
   private int e = -1;
   private Block f;
   protected boolean a;
   public int b;
   private EntityLiving g;
   private String h;
   private int i;
   private int ap;


   public EntityProjectile(World var1) {
      super(var1);
      this.a(0.25F, 0.25F);
   }

   protected void h() {}

   public EntityProjectile(World var1, EntityLiving var2) {
      super(var1);
      this.g = var2;
      this.a(0.25F, 0.25F);
      this.setPositionRotation(var2.s, var2.t + (double)var2.aR(), var2.u, var2.y, var2.z);
      this.s -= (double)(MathHelper.cos(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.t -= 0.10000000149011612D;
      this.u -= (double)(MathHelper.sin(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.b(this.s, this.t, this.u);
      float var3 = 0.4F;
      this.v = (double)(-MathHelper.sin(this.y / 180.0F * 3.1415927F) * MathHelper.cos(this.z / 180.0F * 3.1415927F) * var3);
      this.x = (double)(MathHelper.cos(this.y / 180.0F * 3.1415927F) * MathHelper.cos(this.z / 180.0F * 3.1415927F) * var3);
      this.w = (double)(-MathHelper.sin((this.z + this.l()) / 180.0F * 3.1415927F) * var3);
      this.shoot(this.v, this.w, this.x, this.j(), 1.0F);
   }

   public EntityProjectile(World var1, double var2, double var4, double var6) {
      super(var1);
      this.i = 0;
      this.a(0.25F, 0.25F);
      this.b(var2, var4, var6);
   }

   protected float j() {
      return 1.5F;
   }

   protected float l() {
      return 0.0F;
   }

   public void shoot(double var1, double var3, double var5, float var7, float var8) {
      float var9 = MathHelper.sqrt(var1 * var1 + var3 * var3 + var5 * var5);
      var1 /= (double)var9;
      var3 /= (double)var9;
      var5 /= (double)var9;
      var1 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var3 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var5 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var1 *= (double)var7;
      var3 *= (double)var7;
      var5 *= (double)var7;
      this.v = var1;
      this.w = var3;
      this.x = var5;
      float var10 = MathHelper.sqrt(var1 * var1 + var5 * var5);
      this.A = this.y = (float)(Math.atan2(var1, var5) * 180.0D / 3.1415927410125732D);
      this.B = this.z = (float)(Math.atan2(var3, (double)var10) * 180.0D / 3.1415927410125732D);
      this.i = 0;
   }

   public void s_() throws IOException {
      this.P = this.s;
      this.Q = this.t;
      this.R = this.u;
      super.s_();
      if(this.b > 0) {
         --this.b;
      }

      if(this.a) {
         if(this.o.getData(new Location(this.c, this.d, this.e)).c() == this.f) {
            ++this.i;
            if(this.i == 1200) {
               this.J();
            }

            return;
         }

         this.a = false;
         this.v *= (double)(this.V.nextFloat() * 0.2F);
         this.w *= (double)(this.V.nextFloat() * 0.2F);
         this.x *= (double)(this.V.nextFloat() * 0.2F);
         this.i = 0;
         this.ap = 0;
      } else {
         ++this.ap;
      }

      Vec3D var1 = new Vec3D(this.s, this.t, this.u);
      Vec3D var2 = new Vec3D(this.s + this.v, this.t + this.w, this.u + this.x);
      MovingObjectPosition var3 = this.o.a(var1, var2);
      var1 = new Vec3D(this.s, this.t, this.u);
      var2 = new Vec3D(this.s + this.v, this.t + this.w, this.u + this.x);
      if(var3 != null) {
         var2 = new Vec3D(var3.c.a, var3.c.b, var3.c.c);
      }

      if(!this.o.D) {
         Entity var4 = null;
         List var5 = this.o.b((Entity)this, this.aQ().a(this.v, this.w, this.x).b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;
         EntityLiving var8 = this.n();

         for(int var9 = 0; var9 < var5.size(); ++var9) {
            Entity var10 = (Entity)var5.get(var9);
            if(var10.ad() && (var10 != var8 || this.ap >= 5)) {
               float var11 = 0.3F;
               AxisAlignedBB var12 = var10.aQ().b((double)var11, (double)var11, (double)var11);
               MovingObjectPosition var13 = var12.a(var1, var2);
               if(var13 != null) {
                  double var14 = var1.f(var13.c);
                  if(var14 < var6 || var6 == 0.0D) {
                     var4 = var10;
                     var6 = var14;
                  }
               }
            }
         }

         if(var4 != null) {
            var3 = new MovingObjectPosition(var4);
         }
      }

      if(var3 != null) {
         if(var3.a == brv.b && this.o.getData(var3.a()).c() == Blocks.PORTAL) {
            this.aq();
         } else {
            this.a(var3);
         }
      }

      this.s += this.v;
      this.t += this.w;
      this.u += this.x;
      float var16 = MathHelper.sqrt(this.v * this.v + this.x * this.x);
      this.y = (float)(Math.atan2(this.v, this.x) * 180.0D / 3.1415927410125732D);

      for(this.z = (float)(Math.atan2(this.w, (double)var16) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
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
      float var17 = 0.99F;
      float var18 = this.m();
      if(this.V()) {
         for(int var7 = 0; var7 < 4; ++var7) {
            float var19 = 0.25F;
            this.o.a(ew.e, this.s - this.v * (double)var19, this.t - this.w * (double)var19, this.u - this.x * (double)var19, this.v, this.w, this.x, new int[0]);
         }

         var17 = 0.8F;
      }

      this.v *= (double)var17;
      this.w *= (double)var17;
      this.x *= (double)var17;
      this.w -= (double)var18;
      this.b(this.s, this.t, this.u);
   }

   protected float m() {
      return 0.03F;
   }

   protected abstract void a(MovingObjectPosition var1);

   public void b(NBTTagCompound var1) {
      var1.setShort("xTile", (short)this.c);
      var1.setShort("yTile", (short)this.d);
      var1.setShort("zTile", (short)this.e);
      RegistryMaterials var2 = (RegistryMaterials)Block.c.c(this.f);
      var1.setString("inTile", var2 == null?"":var2.toString());
      var1.setByte("shake", (byte)this.b);
      var1.setByte("inGround", (byte)(this.a?1:0));
      if((this.h == null || this.h.length() == 0) && this.g instanceof EntityHuman) {
         this.h = this.g.d_();
      }

      var1.setString("ownerName", this.h == null?"":this.h);
   }

   public void a(NBTTagCompound var1) {
      this.c = var1.getShort("xTile");
      this.d = var1.getShort("yTile");
      this.e = var1.getShort("zTile");
      if(var1.hasKeyOfType("inTile", 8)) {
         this.f = Block.b(var1.getString("inTile"));
      } else {
         this.f = Block.c(var1.getByte("inTile") & 255);
      }

      this.b = var1.getByte("shake") & 255;
      this.a = var1.getByte("inGround") == 1;
      this.h = var1.getString("ownerName");
      if(this.h != null && this.h.length() == 0) {
         this.h = null;
      }

   }

   public EntityLiving n() {
      if(this.g == null && this.h != null && this.h.length() > 0) {
         this.g = this.o.a(this.h);
      }

      return this.g;
   }
}
