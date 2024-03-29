package net.minecraft.server;



public class zl extends PathfinderGoal {

   private EntityCreature a;
   private VillageDoor b;
   private int c = -1;
   private int d = -1;


   public zl(EntityCreature var1) {
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      Location var1 = new Location(this.a);
      if((!this.a.o.w() || this.a.o.S() && !this.a.o.getBiome(var1).e()) && !this.a.o.worldProvider.o()) {
         if(this.a.bb().nextInt(50) != 0) {
            return false;
         } else if(this.c != -1 && this.a.e((double)this.c, this.a.t, (double)this.d) < 4.0D) {
            return false;
         } else {
            Village var2 = this.a.o.ae().a(var1, 14);
            if(var2 == null) {
               return false;
            } else {
               this.b = var2.c(var1);
               return this.b != null;
            }
         }
      } else {
         return false;
      }
   }

   public boolean b() {
      return !this.a.getNavigation().m();
   }

   public void c() {
      this.c = -1;
      Location var1 = this.b.e();
      int var2 = var1.n();
      int var3 = var1.o();
      int var4 = var1.p();
      if(this.a.b(var1) > 256.0D) {
         Vec3D var5 = abf.a(this.a, 14, 3, new Vec3D((double)var2 + 0.5D, (double)var3, (double)var4 + 0.5D));
         if(var5 != null) {
            this.a.getNavigation().a(var5.a, var5.b, var5.c, 1.0D);
         }
      } else {
         this.a.getNavigation().a((double)var2 + 0.5D, (double)var3, (double)var4 + 0.5D, 1.0D);
      }

   }

   public void d() {
      this.c = this.b.e().n();
      this.d = this.b.e().p();
      this.b = null;
   }
}
