package net.minecraft.server;



public class zu extends PathfinderGoal {

   private EntityCreature b;
   protected double a;
   private double c;
   private double d;
   private double e;


   public zu(EntityCreature var1, double var2) {
      this.b = var1;
      this.a = var2;
      this.a(1);
   }

   public boolean a() {
      if(this.b.bc() == null && !this.b.au()) {
         return false;
      } else {
         Vec3D var1 = abf.a(this.b, 5, 4);
         if(var1 == null) {
            return false;
         } else {
            this.c = var1.a;
            this.d = var1.b;
            this.e = var1.c;
            return true;
         }
      }
   }

   public void c() {
      this.b.getNavigation().a(this.c, this.d, this.e, this.a);
   }

   public boolean b() {
      return !this.b.getNavigation().m();
   }
}
