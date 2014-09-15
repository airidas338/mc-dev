package net.minecraft.server;
import java.io.IOException;
import java.util.List;

public class EntityLightning extends EntityWeather {

   private int b;
   public long a;
   private int c;


   public EntityLightning(World var1, double var2, double var4, double var6) {
      super(var1);
      this.setPositionRotation(var2, var4, var6, 0.0F, 0.0F);
      this.b = 2;
      this.a = this.V.nextLong();
      this.c = this.V.nextInt(3) + 1;
      if(!var1.isStatic && var1.Q().b("doFireTick") && (var1.aa() == EnumDifficulty.NORMAL || var1.aa() == EnumDifficulty.HARD) && var1.a(new Location(this), (int)10)) {
         Location var8 = new Location(this);
         if(var1.getData(var8).c().r() == Material.AIR && Blocks.FIRE.c(var1, var8)) {
            var1.a(var8, Blocks.FIRE.P());
         }

         for(int var9 = 0; var9 < 4; ++var9) {
            Location var10 = var8.a(this.V.nextInt(3) - 1, this.V.nextInt(3) - 1, this.V.nextInt(3) - 1);
            if(var1.getData(var10).c().r() == Material.AIR && Blocks.FIRE.c(var1, var10)) {
               var1.a(var10, Blocks.FIRE.P());
            }
         }
      }

   }

   public void s_() throws IOException {
      super.s_();
      if(this.b == 2) {
         this.o.a(this.s, this.t, this.u, "ambient.weather.thunder", 10000.0F, 0.8F + this.V.nextFloat() * 0.2F);
         this.o.a(this.s, this.t, this.u, "random.explode", 2.0F, 0.5F + this.V.nextFloat() * 0.2F);
      }

      --this.b;
      if(this.b < 0) {
         if(this.c == 0) {
            this.J();
         } else if(this.b < -this.V.nextInt(10)) {
            --this.c;
            this.b = 1;
            this.a = this.V.nextLong();
            Location var1 = new Location(this);
            if(!this.o.isStatic && this.o.Q().b("doFireTick") && this.o.a(var1, (int)10) && this.o.getData(var1).c().r() == Material.AIR && Blocks.FIRE.c(this.o, var1)) {
               this.o.a(var1, Blocks.FIRE.P());
            }
         }
      }

      if(this.b >= 0) {
         if(this.o.isStatic) {
            this.o.c(2);
         } else {
            double var6 = 3.0D;
            List var3 = this.o.b((Entity)this, new AxisAlignedBB(this.s - var6, this.t - var6, this.u - var6, this.s + var6, this.t + 6.0D + var6, this.u + var6));

            for(int var4 = 0; var4 < var3.size(); ++var4) {
               Entity var5 = (Entity)var3.get(var4);
               var5.a(this);
            }
         }
      }

   }

   protected void h() {}

   protected void a(NBTTagCompound var1) {}

   protected void b(NBTTagCompound var1) {}
}
