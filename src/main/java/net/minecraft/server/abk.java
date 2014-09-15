package net.minecraft.server;
import java.util.Iterator;
import java.util.List;

public class abk {

   private World a;
   private boolean b;
   private int c = -1;
   private int d;
   private int e;
   private Village f;
   private int g;
   private int h;
   private int i;


   public abk(World var1) {
      this.a = var1;
   }

   public void a() {
      if(this.a.w()) {
         this.c = 0;
      } else if(this.c != 2) {
         if(this.c == 0) {
            float var1 = this.a.c(0.0F);
            if((double)var1 < 0.5D || (double)var1 > 0.501D) {
               return;
            }

            this.c = this.a.random.nextInt(10) == 0?1:2;
            this.b = false;
            if(this.c == 2) {
               return;
            }
         }

         if(this.c != -1) {
            if(!this.b) {
               if(!this.b()) {
                  return;
               }

               this.b = true;
            }

            if(this.e > 0) {
               --this.e;
            } else {
               this.e = 2;
               if(this.d > 0) {
                  this.c();
                  --this.d;
               } else {
                  this.c = 2;
               }

            }
         }
      }
   }

   private boolean b() {
      List var1 = this.a.players;
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         EntityHuman var3 = (EntityHuman)var2.next();
         if(!var3.v()) {
            this.f = this.a.ae().a(new Location(var3), 1);
            if(this.f != null && this.f.c() >= 10 && this.f.d() >= 20 && this.f.e() >= 20) {
               Location var4 = this.f.a();
               float var5 = (float)this.f.b();
               boolean var6 = false;
               int var7 = 0;

               while(true) {
                  if(var7 < 10) {
                     float var8 = this.a.random.nextFloat() * 3.1415927F * 2.0F;
                     this.g = var4.n() + (int)((double)(MathHelper.cos(var8) * var5) * 0.9D);
                     this.h = var4.o();
                     this.i = var4.p() + (int)((double)(MathHelper.sin(var8) * var5) * 0.9D);
                     var6 = false;
                     Iterator var9 = this.a.ae().b().iterator();

                     while(var9.hasNext()) {
                        Village var10 = (Village)var9.next();
                        if(var10 != this.f && var10.a(new Location(this.g, this.h, this.i))) {
                           var6 = true;
                           break;
                        }
                     }

                     if(var6) {
                        ++var7;
                        continue;
                     }
                  }

                  if(var6) {
                     return false;
                  }

                  Vec3D var11 = this.a(new Location(this.g, this.h, this.i));
                  if(var11 != null) {
                     this.e = 0;
                     this.d = 20;
                     return true;
                  }
                  break;
               }
            }
         }
      }

      return false;
   }

   private boolean c() {
      Vec3D var1 = this.a(new Location(this.g, this.h, this.i));
      if(var1 == null) {
         return false;
      } else {
         EntityZombie var2;
         try {
            var2 = new EntityZombie(this.a);
            var2.a(this.a.E(new Location(var2)), (xq)null);
            var2.m(false);
         } catch (Exception var4) {
            var4.printStackTrace();
            return false;
         }

         var2.setPositionRotation(var1.a, var1.b, var1.c, this.a.random.nextFloat() * 360.0F, 0.0F);
         this.a.d((Entity)var2);
         Location var3 = this.f.a();
         var2.a(var3, this.f.b());
         return true;
      }
   }

   private Vec3D a(Location var1) {
      for(int var2 = 0; var2 < 10; ++var2) {
         Location var3 = var1.a(this.a.random.nextInt(16) - 8, this.a.random.nextInt(6) - 3, this.a.random.nextInt(16) - 8);
         if(this.f.a(var3) && SpawnerCreature.a(xo.a, this.a, var3)) {
            return new Vec3D((double)var3.n(), (double)var3.o(), (double)var3.p());
         }
      }

      return null;
   }
}
