package net.minecraft.server;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class yt extends PathfinderGoal {

   private EntityAnimal d;
   World a;
   private EntityAnimal e;
   int b;
   double c;


   public yt(EntityAnimal var1, double var2) {
      this.d = var1;
      this.a = var1.o;
      this.c = var2;
      this.a(3);
   }

   public boolean a() {
      if(!this.d.cp()) {
         return false;
      } else {
         this.e = this.f();
         return this.e != null;
      }
   }

   public boolean b() {
      return this.e.isAlive() && this.e.cp() && this.b < 60;
   }

   public void d() {
      this.e = null;
      this.b = 0;
   }

   public void e() {
      this.d.p().a(this.e, 10.0F, (float)this.d.bP());
      this.d.getNavigation().a((Entity)this.e, this.c);
      ++this.b;
      if(this.b >= 60 && this.d.h(this.e) < 9.0D) {
         this.g();
      }

   }

   private EntityAnimal f() {
      float var1 = 8.0F;
      List var2 = this.a.getEntities(this.d.getClass(), this.d.aQ().b((double)var1, (double)var1, (double)var1));
      double var3 = Double.MAX_VALUE;
      EntityAnimal var5 = null;
      Iterator var6 = var2.iterator();

      while(var6.hasNext()) {
         EntityAnimal var7 = (EntityAnimal)var6.next();
         if(this.d.a(var7) && this.d.h(var7) < var3) {
            var5 = var7;
            var3 = this.d.h(var7);
         }
      }

      return var5;
   }

   private void g() {
      EntityAgeable var1 = this.d.a((EntityAgeable)this.e);
      if(var1 != null) {
         EntityHuman var2 = this.d.co();
         if(var2 == null && this.e.co() != null) {
            var2 = this.e.co();
         }

         if(var2 != null) {
            var2.b(StatisticList.A);
            if(this.d instanceof EntityCow) {
               var2.b((Statistic)AchievementList.H);
            }
         }

         this.d.b(6000);
         this.e.b(6000);
         this.d.cq();
         this.e.cq();
         var1.b(-24000);
         var1.setPositionRotation(this.d.s, this.d.t, this.d.u, 0.0F, 0.0F);
         this.a.addEntity((Entity)var1);
         Random var3 = this.d.bb();

         for(int var4 = 0; var4 < 7; ++var4) {
            double var5 = var3.nextGaussian() * 0.02D;
            double var7 = var3.nextGaussian() * 0.02D;
            double var9 = var3.nextGaussian() * 0.02D;
            this.a.a(EnumParticleEffect.I, this.d.s + (double)(var3.nextFloat() * this.d.J * 2.0F) - (double)this.d.J, this.d.t + 0.5D + (double)(var3.nextFloat() * this.d.K), this.d.u + (double)(var3.nextFloat() * this.d.J * 2.0F) - (double)this.d.J, var5, var7, var9, new int[0]);
         }

         if(this.a.getGameRules().getBoolean("doMobLoot")) {
            this.a.addEntity((Entity)(new EntityExperienceOrb(this.a, this.d.s, this.d.t, this.d.u, var3.nextInt(7) + 1)));
         }

      }
   }
}
