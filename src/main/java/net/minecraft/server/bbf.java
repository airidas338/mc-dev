package net.minecraft.server;
import java.util.Random;

public abstract class bbf extends BlockStepAbstract {

   public static final bet b = bet.a("seamless");
   public static final bev M = bev.a("variant", bbg.class);


   public bbf() {
      super(Material.STONE);
      IBlock var1 = this.L.b();
      if(this.j()) {
         var1 = var1.a(b, Boolean.valueOf(false));
      } else {
         var1 = var1.a(a, awr.b);
      }

      this.j(var1.a(M, bbg.a));
      this.a(CreativeModeTab.b);
   }

   public Item a(IBlock var1, Random var2, int var3) {
      return Item.a((Block)Blocks.U);
   }

   public String b(int var1) {
      return super.a() + "." + bbg.a(var1).c();
   }

   public bex l() {
      return M;
   }

   public Object a(amj var1) {
      return bbg.a(var1.i() & 7);
   }

   public IBlock a(int var1) {
      IBlock var2 = this.P().a(M, bbg.a(var1 & 7));
      if(this.j()) {
         var2 = var2.a(b, Boolean.valueOf((var1 & 8) != 0));
      } else {
         var2 = var2.a(a, (var1 & 8) == 0?awr.b:awr.a);
      }

      return var2;
   }

   public int c(IBlock var1) {
      byte var2 = 0;
      int var3 = var2 | ((bbg)var1.b(M)).a();
      if(this.j()) {
         if(((Boolean)var1.b(b)).booleanValue()) {
            var3 |= 8;
         }
      } else if(var1.b(a) == awr.a) {
         var3 |= 8;
      }

      return var3;
   }

   protected bed e() {
      return this.j()?new bed(this, new bex[]{b, M}):new bed(this, new bex[]{a, M});
   }

   public int a(IBlock var1) {
      return ((bbg)var1.b(M)).a();
   }

}
