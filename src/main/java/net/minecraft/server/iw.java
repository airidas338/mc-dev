package net.minecraft.server;

public class iw implements id {

   private Location a;
   private IBlock b;


   public iw() {}

   public iw(World var1, Location var2) {
      this.a = var2;
      this.b = var1.p(var2);
   }

   public void a(hd var1) {
      this.a = var1.c();
      this.b = (IBlock)Block.d.a(var1.e());
   }

   public void b(hd var1) {
      var1.a(this.a);
      var1.b(Block.d.b(this.b));
   }

   public void a(hg var1) {
      ((ik)var1).a(this);
   }
}
