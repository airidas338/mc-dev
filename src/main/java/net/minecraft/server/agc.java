package net.minecraft.server;


class agc extends yn {

   private float g;
   private int h;
   private EntitySlime i;
   private boolean j;


   public agc(EntitySlime var1) {
      super(var1);
      this.i = var1;
   }

   public void a(float var1, boolean var2) {
      this.g = var1;
      this.j = var2;
   }

   public void a(double var1) {
      this.e = var1;
      this.f = true;
   }

   public void c() {
      this.a.y = this.a(this.a.y, this.g, 30.0F);
      this.a.aI = this.a.y;
      this.a.aG = this.a.y;
      if(!this.f) {
         this.a.m(0.0F);
      } else {
         this.f = false;
         if(this.a.C) {
            this.a.j((float)(this.e * this.a.getAttributeInstance(GenericAttributes.d).getValue()));
            if(this.h-- <= 0) {
               this.h = this.i.ce();
               if(this.j) {
                  this.h /= 3;
               }

               this.i.r().a();
               if(this.i.cl()) {
                  this.i.a(this.i.ci(), this.i.bA(), ((this.i.bb().nextFloat() - this.i.bb().nextFloat()) * 0.2F + 1.0F) * 0.8F);
               }
            } else {
               this.i.aX = this.i.aY = 0.0F;
               this.a.j(0.0F);
            }
         } else {
            this.a.j((float)(this.e * this.a.getAttributeInstance(GenericAttributes.d).getValue()));
         }

      }
   }
}
