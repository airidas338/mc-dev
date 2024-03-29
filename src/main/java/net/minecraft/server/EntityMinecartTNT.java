package net.minecraft.server;
import java.io.IOException;


public class EntityMinecartTNT extends EntityMinecartAbstract {

   private int a = -1;


   public EntityMinecartTNT(World var1) {
      super(var1);
   }

   public EntityMinecartTNT(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public EnumMinecartType s() {
      return EnumMinecartType.TNT;
   }

   public IBlockData u() {
      return Blocks.TNT.P();
   }

   public void s_() throws IOException {
      super.s_();
      if(this.a > 0) {
         --this.a;
         this.o.a(EnumParticleEffect.l, this.s, this.t + 0.5D, this.u, 0.0D, 0.0D, 0.0D, new int[0]);
      } else if(this.a == 0) {
         this.b(this.v * this.v + this.x * this.x);
      }

      if(this.D) {
         double var1 = this.v * this.v + this.x * this.x;
         if(var1 >= 0.009999999776482582D) {
            this.b(var1);
         }
      }

   }

   public boolean a(DamageSource var1, float var2) {
      Entity var3 = var1.i();
      if(var3 instanceof EntityArrow) {
         EntityArrow var4 = (EntityArrow)var3;
         if(var4.au()) {
            this.b(var4.v * var4.v + var4.w * var4.w + var4.x * var4.x);
         }
      }

      return super.a(var1, var2);
   }

   public void a(DamageSource var1) {
      super.a(var1);
      double var2 = this.v * this.v + this.x * this.x;
      if(!var1.isExplosion()) {
         this.a(new ItemStack(Blocks.TNT, 1), 0.0F);
      }

      if(var1.o() || var1.isExplosion() || var2 >= 0.009999999776482582D) {
         this.b(var2);
      }

   }

   protected void b(double var1) {
      if(!this.o.isStatic) {
         double var3 = Math.sqrt(var1);
         if(var3 > 5.0D) {
            var3 = 5.0D;
         }

         this.o.explode(this, this.s, this.t, this.u, (float)(4.0D + this.V.nextDouble() * 1.5D * var3), true);
         this.J();
      }

   }

   public void e(float var1, float var2) {
      if(var1 >= 3.0F) {
         float var3 = var1 / 10.0F;
         this.b((double)(var3 * var3));
      }

      super.e(var1, var2);
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      if(var4 && this.a < 0) {
         this.j();
      }

   }

   public void j() {
      this.a = 80;
      if(!this.o.isStatic) {
         this.o.broadcastEntityEffect((Entity)this, (byte)10);
         if(!this.R()) {
            this.o.makeSound((Entity)this, "game.tnt.primed", 1.0F, 1.0F);
         }
      }

   }

   public boolean y() {
      return this.a > -1;
   }

   public float a(Explosion var1, World var2, Location var3, IBlockData var4) {
      return this.y() && (BlockMinecartTrackAbstract.d(var4) || BlockMinecartTrackAbstract.d(var2, var3.a()))?0.0F:super.a(var1, var2, var3, var4);
   }

   public boolean a(Explosion var1, World var2, Location var3, IBlockData var4, float var5) {
      return this.y() && (BlockMinecartTrackAbstract.d(var4) || BlockMinecartTrackAbstract.d(var2, var3.a()))?false:super.a(var1, var2, var3, var4, var5);
   }

   protected void a(NBTTagCompound var1) {
      super.a(var1);
      if(var1.hasKeyOfType("TNTFuse", 99)) {
         this.a = var1.getInt("TNTFuse");
      }

   }

   protected void b(NBTTagCompound var1) {
      super.b(var1);
      var1.setInt("TNTFuse", this.a);
   }
}
