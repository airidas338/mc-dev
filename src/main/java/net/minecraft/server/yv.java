package net.minecraft.server;



public abstract class yv extends PathfinderGoal {

   protected EntityInsentient a;
   protected Location b;
   protected BlockDoor c;
   boolean d;
   float e;
   float f;


   public yv(EntityInsentient var1) {
      this.b = Location.a;
      this.a = var1;
      if(!(var1.getNavigation() instanceof aay)) {
         throw new IllegalArgumentException("Unsupported mob type for DoorInteractGoal");
      }
   }

   public boolean a() {
      if(!this.a.D) {
         return false;
      } else {
         aay var1 = (aay)this.a.getNavigation();
         bpv var2 = var1.j();
         if(var2 != null && !var2.b() && var1.g()) {
            for(int var3 = 0; var3 < Math.min(var2.e() + 2, var2.d()); ++var3) {
               PathPoint var4 = var2.a(var3);
               this.b = new Location(var4.a, var4.b + 1, var4.c);
               if(this.a.e((double)this.b.n(), this.a.t, (double)this.b.p()) <= 2.25D) {
                  this.c = this.a(this.b);
                  if(this.c != null) {
                     return true;
                  }
               }
            }

            this.b = (new Location(this.a)).a();
            this.c = this.a(this.b);
            return this.c != null;
         } else {
            return false;
         }
      }
   }

   public boolean b() {
      return !this.d;
   }

   public void c() {
      this.d = false;
      this.e = (float)((double)((float)this.b.n() + 0.5F) - this.a.s);
      this.f = (float)((double)((float)this.b.p() + 0.5F) - this.a.u);
   }

   public void e() {
      float var1 = (float)((double)((float)this.b.n() + 0.5F) - this.a.s);
      float var2 = (float)((double)((float)this.b.p() + 0.5F) - this.a.u);
      float var3 = this.e * var1 + this.f * var2;
      if(var3 < 0.0F) {
         this.d = true;
      }

   }

   private BlockDoor a(Location var1) {
      Block var2 = this.a.o.getData(var1).c();
      return var2 instanceof BlockDoor && var2.getMaterial() == Material.WOOD?(BlockDoor)var2:null;
   }
}
