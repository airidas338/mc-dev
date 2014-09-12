package net.minecraft.server;

public class jj implements id {

   private IChatBaseComponent a;


   public jj() {}

   public jj(IChatBaseComponent var1) {
      this.a = var1;
   }

   public void a(hd var1) {
      this.a = var1.d();
   }

   public void b(hd var1) {
      var1.a(this.a);
   }

   public void a(hg var1) {
      ((ik)var1).a(this);
   }
}
