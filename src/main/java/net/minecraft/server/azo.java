package net.minecraft.server;

public class azo extends ati {

   public static final bev b = bev.a("shape", atl.class);


   protected azo() {
      super(false);
      this.j(this.L.b().a(b, atl.a));
   }

   protected void b(World var1, Location var2, IBlock var3, Block var4) {
      if(var4.g() && (new atk(this, var1, var2, var3)).a() == 3) {
         this.a(var1, var2, var3, false);
      }

   }

   public bex l() {
      return b;
   }

   public IBlock a(int var1) {
      return this.P().a(b, atl.a(var1));
   }

   public int c(IBlock var1) {
      return ((atl)var1.b(b)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{b});
   }

}
