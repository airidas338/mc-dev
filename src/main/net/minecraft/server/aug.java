package net.minecraft.server;
import java.util.Random;

public class aug extends Block {

   public static final bew a = bew.a("bites", 0, 6);


   protected aug() {
      super(Material.F);
      this.j(this.L.b().a(a, Integer.valueOf(0)));
      this.a(true);
   }

   public void a(ard var1, Location var2) {
      float var3 = 0.0625F;
      float var4 = (float)(1 + ((Integer)var1.p(var2).b(a)).intValue() * 2) / 16.0F;
      float var5 = 0.5F;
      this.a(var4, 0.0F, var3, 1.0F - var3, var5, 1.0F - var3);
   }

   public void h() {
      float var1 = 0.0625F;
      float var2 = 0.5F;
      this.a(var1, 0.0F, var1, 1.0F - var1, var2, 1.0F - var1);
   }

   public AxisAlignedBB a(World var1, Location var2, IBlock var3) {
      float var4 = 0.0625F;
      float var5 = (float)(1 + ((Integer)var3.b(a)).intValue() * 2) / 16.0F;
      float var6 = 0.5F;
      return new AxisAlignedBB((double)((float)var2.n() + var5), (double)var2.o(), (double)((float)var2.p() + var4), (double)((float)(var2.n() + 1) - var4), (double)((float)var2.o() + var6), (double)((float)(var2.p() + 1) - var4));
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public boolean a(World var1, Location var2, IBlock var3, EntityHuman var4, ej var5, float var6, float var7, float var8) {
      this.b(var1, var2, var3, var4);
      return true;
   }

   public void a(World var1, Location var2, EntityHuman var3) {
      this.b(var1, var2, var1.p(var2), var3);
   }

   private void b(World var1, Location var2, IBlock var3, EntityHuman var4) {
      if(var4.j(false)) {
         var4.ck().a(2, 0.1F);
         int var5 = ((Integer)var3.b(a)).intValue();
         if(var5 < 6) {
            var1.a(var2, var3.a(a, Integer.valueOf(var5 + 1)), 3);
         } else {
            var1.g(var2);
         }

      }
   }

   public boolean c(World var1, Location var2) {
      return super.c(var1, var2)?this.d(var1, var2):false;
   }

   public void a(World var1, Location var2, IBlock var3, Block var4) {
      if(!this.d(var1, var2)) {
         var1.g(var2);
      }

   }

   private boolean d(World var1, Location var2) {
      return var1.p(var2.b()).c().r().a();
   }

   public int a(Random var1) {
      return 0;
   }

   public alq a(IBlock var1, Random var2, int var3) {
      return null;
   }

   public IBlock a(int var1) {
      return this.P().a(a, Integer.valueOf(var1));
   }

   public int c(IBlock var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

   public int l(World var1, Location var2) {
      return (7 - ((Integer)var1.p(var2).b(a)).intValue()) * 2;
   }

   public boolean N() {
      return true;
   }

}
