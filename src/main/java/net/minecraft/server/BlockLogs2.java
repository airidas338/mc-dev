package net.minecraft.server;
import com.google.common.base.Predicate;

public class BlockLogs2 extends BlockLogAbstract {

   public static final bev b = bev.a("variant", ayx.class, (Predicate)(new ayj()));


   public BlockLogs2() {
      this.j(this.L.b().a(b, ayx.e).a(a, axo.b));
   }

   public IBlockData a(int var1) {
      IBlockData var2 = this.P().a(b, ayx.a((var1 & 3) + 4));
      switch(var1 & 12) {
      case 0:
         var2 = var2.a(a, axo.b);
         break;
      case 4:
         var2 = var2.a(a, axo.a);
         break;
      case 8:
         var2 = var2.a(a, axo.c);
         break;
      default:
         var2 = var2.a(a, axo.d);
      }

      return var2;
   }

   public int c(IBlockData var1) {
      byte var2 = 0;
      int var3 = var2 | ((ayx)var1.b(b)).a() - 4;
      switch(ayk.a[((axo)var1.b(a)).ordinal()]) {
      case 1:
         var3 |= 4;
         break;
      case 2:
         var3 |= 8;
         break;
      case 3:
         var3 |= 12;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{b, a});
   }

   protected ItemStack i(IBlockData var1) {
      return new ItemStack(Item.getItemOf((Block)this), 1, ((ayx)var1.b(b)).a() - 4);
   }

   public int getDropData(IBlockData var1) {
      return ((ayx)var1.b(b)).a() - 4;
   }

}
