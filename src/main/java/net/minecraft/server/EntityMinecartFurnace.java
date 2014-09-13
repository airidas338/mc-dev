package net.minecraft.server;
import java.io.IOException;


public class EntityMinecartFurnace extends EntityMinecartAbstract {

   private int c;
   public double a;
   public double b;


   public EntityMinecartFurnace(World var1) {
      super(var1);
   }

   public EntityMinecartFurnace(World var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   public EnumMinecartType s() {
      return EnumMinecartType.FURNACE;
   }

   protected void h() {
      super.h();
      this.ac.a(16, new Byte((byte)0));
   }

   public void s_() throws IOException {
      super.s_();
      if(this.c > 0) {
         --this.c;
      }

      if(this.c <= 0) {
         this.a = this.b = 0.0D;
      }

      this.i(this.c > 0);
      if(this.j() && this.V.nextInt(4) == 0) {
         this.o.a(ew.m, this.s, this.t + 0.8D, this.u, 0.0D, 0.0D, 0.0D, new int[0]);
      }

   }

   protected double m() {
      return 0.2D;
   }

   public void a(DamageSource var1) {
      super.a(var1);
      if(!var1.c()) {
         this.a(new amj(Blocks.al, 1), 0.0F);
      }

   }

   protected void a(Location var1, IBlock var2) {
      super.a(var1, var2);
      double var3 = this.a * this.a + this.b * this.b;
      if(var3 > 1.0E-4D && this.v * this.v + this.x * this.x > 0.001D) {
         var3 = (double)MathHelper.a(var3);
         this.a /= var3;
         this.b /= var3;
         if(this.a * this.v + this.b * this.x < 0.0D) {
            this.a = 0.0D;
            this.b = 0.0D;
         } else {
            double var5 = var3 / this.m();
            this.a *= var5;
            this.b *= var5;
         }
      }

   }

   protected void o() {
      double var1 = this.a * this.a + this.b * this.b;
      if(var1 > 1.0E-4D) {
         var1 = (double)MathHelper.a(var1);
         this.a /= var1;
         this.b /= var1;
         double var3 = 1.0D;
         this.v *= 0.800000011920929D;
         this.w *= 0.0D;
         this.x *= 0.800000011920929D;
         this.v += this.a * var3;
         this.x += this.b * var3;
      } else {
         this.v *= 0.9800000190734863D;
         this.w *= 0.0D;
         this.x *= 0.9800000190734863D;
      }

      super.o();
   }

   public boolean e(EntityHuman var1) {
      amj var2 = var1.bg.h();
      if(var2 != null && var2.b() == Items.h) {
         if(!var1.by.d && --var2.b == 0) {
            var1.bg.a(var1.bg.c, (amj)null);
         }

         this.c += 3600;
      }

      this.a = this.s - var1.s;
      this.b = this.u - var1.u;
      return true;
   }

   protected void b(NBTTagCompound var1) {
      super.b(var1);
      var1.a("PushX", this.a);
      var1.a("PushZ", this.b);
      var1.a("Fuel", (short)this.c);
   }

   protected void a(NBTTagCompound var1) {
      super.a(var1);
      this.a = var1.i("PushX");
      this.b = var1.i("PushZ");
      this.c = var1.e("Fuel");
   }

   protected boolean j() {
      return (this.ac.a(16) & 1) != 0;
   }

   protected void i(boolean var1) {
      if(var1) {
         this.ac.b(16, Byte.valueOf((byte)(this.ac.a(16) | 1)));
      } else {
         this.ac.b(16, Byte.valueOf((byte)(this.ac.a(16) & -2)));
      }

   }

   public IBlock u() {
      return (this.j()?Blocks.am:Blocks.al).P().a(BlockFurnace.a, ej.c);
   }
}
