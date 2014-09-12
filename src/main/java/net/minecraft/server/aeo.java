package net.minecraft.server;


public class aeo extends age {

   public aeo(World var1) {
      super(var1);
      this.a(0.7F, 0.5F);
   }

   protected void aW() {
      super.aW();
      this.a(afs.a).a(12.0D);
   }

   public boolean r(Entity var1) {
      if(super.r(var1)) {
         if(var1 instanceof xm) {
            byte var2 = 0;
            if(this.o.aa() == EnumDifficulty.c) {
               var2 = 7;
            } else if(this.o.aa() == EnumDifficulty.d) {
               var2 = 15;
            }

            if(var2 > 0) {
               ((xm)var1).c(new wq(wp.u.H, var2 * 20, 0));
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public xq a(vu var1, xq var2) {
      return var2;
   }

   public float aR() {
      return 0.45F;
   }
}
