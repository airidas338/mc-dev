package net.minecraft.server;

class aci extends yn {

   private acb g;


   public aci(acb var1) {
      super(var1);
      this.g = var1;
   }

   public void c() {
      if(this.g.C && !this.g.cj()) {
         this.g.b(0.0D);
      }

      super.c();
   }
}
